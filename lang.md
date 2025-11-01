# Multi-Language System Architecture - AI Implementation Guide

## System Purpose
This document describes a per-player localization system for a Minecraft plugin that automatically detects and adapts to each player's client language, allowing different players on the same server to see messages, GUI elements, and item names in their preferred language.

## Core Concept
The system operates on three fundamental principles:
1. **Per-Player Language Preferences**: Each player has their own language setting, stored persistently
2. **Automatic Detection**: Player language is detected from their Minecraft client on join
3. **Fallback Chain**: If a translation is missing, the system falls back to default language (English)

## Architecture Components

### 1. LanguageManager (Core Component)
**Location**: `src/main/java/com/celestialswords/i18n/LanguageManager.java`

**Purpose**: Central manager for all localization operations

**Key Data Structures**:
```java
// Maps player UUID to their language code (e.g., "en_US", "es_ES")
Map<UUID, String> playerLanguages = new ConcurrentHashMap<>();

// Maps language code to its YAML configuration containing all translations
Map<String, YamlConfiguration> languageConfigs = new HashMap<>();

// Default language used when translations are missing
String defaultLanguage = "en_US";
```

**Core Methods**:

1. **setPlayerLanguage(UUID playerId, String languageCode)**
   - Validates language code exists in available languages
   - Updates in-memory map
   - Persists to `player_languages.yml` file
   - Thread-safe using ConcurrentHashMap

2. **getMessage(Player player, String key, Object... args)**
   - Retrieves player's language preference
   - Looks up message in player's language file
   - Falls back to default language if not found
   - Applies String.format() for parameter substitution
   - Returns key itself as last resort

3. **getMessageList(Player player, String key)**
   - Same as getMessage but returns List<String> for multi-line content
   - Used for announcements, lore, and other list-based content

**Initialization Process**:
1. Create `messages/` directory if missing
2. Create `player_languages.yml` if missing
3. Copy language files from plugin resources to data folder
4. Load all `.yml` files from `messages/` directory into memory
5. Parse `player_languages.yml` to restore player preferences

### 2. Language Files Structure
**Location**: `src/main/resources/messages/*.yml` (bundled) → `plugins/CelestialSwords/messages/*.yml` (runtime)

**Format**: YAML with nested keys

**Example Structure**:
```yaml
# Command messages
commands:
  no_permission: "§cYou don't have permission!"
  reload:
    success: "§aReloaded successfully!"

# GUI elements
gui:
  main_title: "Astral Swords Recipes"
  recipe_title: "%s Recipe"  # %s replaced with sword name

# Sword names (for display)
swords:
  SHADOWBANE: "Shadowbane"
  PHOENIX_TALON: "Phoenix Talon"

# Lists (for announcements)
announcements:
  craft:
    - "%s has forged the %s!"
    - "The legendary %s has been crafted by %s!"
```

**Key Principles**:
- Minecraft color codes (§a, §c, etc.) are preserved in translations
- Parameter placeholders (%s, %d) must match original
- Nested keys use dot notation: `commands.reload.success`
- Lists are accessed as arrays

### 3. PlayerJoinListener (Auto-Detection)
**Location**: `src/main/java/com/celestialswords/listeners/PlayerJoinListener.java`

**Purpose**: Automatically detect and set player language on server join

**Detection Flow**:
```
Player joins server
    ↓
Get client locale via player.getLocale()
    ↓
Convert locale format (e.g., "en_us" → "en_US")
    ↓
Check if language is supported
    ↓
If supported: Set player language
    ↓
If not: Keep current/default language
    ↓
Notify player (delayed 2 seconds to avoid join spam)
    ↓
Refresh existing sword items in inventory with new language
```

**Locale Conversion Logic**:
- Minecraft locales are lowercase with underscore: `en_us`, `es_es`
- System uses format: `en_US`, `es_ES` (language lowercase, country uppercase)
- Single-part locales map to defaults: `en` → `en_US`, `es` → `es_ES`

**Inventory Refresh**:
- Scans all player inventory slots
- Identifies celestial sword items
- Recreates items with new language translations
- Preserves durability, amount, enchantments
- Updates inventory atomically

### 4. LanguageCommand (Manual Control)
**Location**: `src/main/java/com/celestialswords/commands/LanguageCommand.java`

**Purpose**: Allow players to manually change their language

**Command Syntax**:
- `/aswords language` - Show current language and available options
- `/aswords language <code>` - Change to specified language
- `/aswords lang <code>` - Short alias

**Behavior**:
- Case-insensitive language code matching
- Validates language exists before setting
- Sends confirmation message in NEW language
- Refreshes sword items in inventory immediately
- Shows available languages if invalid code provided

### 5. Integration Points

**GUI System Integration**:
```java
// When creating GUI title
String title = languageManager.getMessage(player, "gui.main_title");

// When creating recipe GUI
String title = languageManager.getMessage(player, "gui.recipe_title", swordName);
```

**Command Integration**:
```java
// In any command handler
String message = languageManager.getMessage(player, "commands.no_permission");
player.sendMessage(message);
```

**Item Creation Integration**:
```java
// When creating sword items
String swordName = languageManager.getMessage(player, "swords." + sword.name());
List<String> lore = languageManager.getMessageList(player, "lore." + sword.name());
```

## Data Persistence

### player_languages.yml Format
```yaml
# UUID: language_code
550e8400-e29b-41d4-a716-446655440000: "es_ES"
6ba7b810-9dad-11d1-80b4-00c04fd430c8: "fr_FR"
```

**Persistence Strategy**:
- Saved immediately when language changes
- Loaded on plugin startup
- Thread-safe writes using synchronized file operations
- Survives server restarts

## Supported Languages
Current implementation includes:
- en_US (English - United States) - DEFAULT
- es_ES (Spanish - Spain)
- fr_FR (French - France)
- pl_PL (Polish - Poland)
- nl_NL (Dutch - Netherlands)
- de_DE (German - Germany)
- hi_IN (Hindi - India)
- ur_PK (Urdu - Pakistan)

## Adding New Languages

### Step-by-Step Process:
1. Create new file: `messages/<language_code>.yml`
2. Copy structure from `en_US.yml`
3. Translate all keys, preserving:
   - Color codes (§a, §c, etc.)
   - Parameter placeholders (%s, %d)
   - YAML structure and indentation
4. Reload plugin or restart server
5. Language automatically available

### Translation Guidelines:
- Keep color codes in same positions
- Maintain parameter order and count
- Consider cultural context, not just literal translation
- Test in-game to verify formatting
- Use 2 spaces for YAML indentation (never tabs)

## Message Resolution Algorithm

```
getMessage(player, "commands.reload.success")
    ↓
Get player's language: "es_ES"
    ↓
Load es_ES.yml configuration
    ↓
Look up key: "commands.reload.success"
    ↓
Found? → Return translated message
    ↓
Not found? → Load en_US.yml (default)
    ↓
Look up key: "commands.reload.success"
    ↓
Found? → Return default message
    ↓
Not found? → Return key itself: "commands.reload.success"
```

## Thread Safety Considerations

**ConcurrentHashMap for playerLanguages**:
- Multiple players can join simultaneously
- Language changes can occur during gameplay
- No locking needed for reads

**Synchronized File Writes**:
- Only one thread writes to player_languages.yml at a time
- Prevents corruption from concurrent saves

**Immutable Language Configs**:
- Loaded once at startup/reload
- Read-only during runtime
- Reload requires explicit command

## Performance Optimizations

1. **In-Memory Caching**: All language files loaded into memory
2. **Lazy Loading**: Language files only loaded if they exist
3. **Fast Lookups**: HashMap O(1) access for player languages
4. **Minimal I/O**: File writes only on language change, not on every message

## Backward Compatibility

**Legacy Code Support**:
```java
// Old code still works
String title = "Astral Swords Recipes";

// New code is localized
String title = languageManager.getMessage(player, "gui.main_title");
```

**GUI Title Detection**:
- System can detect both localized and non-localized GUI titles
- Existing GUI listeners work with all language variants
- No breaking changes to existing functionality

## Error Handling

**Missing Language File**:
- Falls back to default language
- Logs warning to console
- Player sees English messages

**Invalid Language Code**:
- Rejects change request
- Shows available languages
- Keeps current language

**Corrupted YAML**:
- Logs error with details
- Skips corrupted file
- Uses default language

**Missing Translation Key**:
- Falls back to default language
- If still missing, returns key itself
- Allows plugin to continue functioning

## Implementation Checklist for Recreation

To recreate this system, implement in this order:

1. **Create LanguageManager class**:
   - Player language storage (Map<UUID, String>)
   - Language config storage (Map<String, YamlConfiguration>)
   - getMessage() with fallback logic
   - File persistence for player preferences

2. **Create language files**:
   - en_US.yml as default
   - Additional languages as needed
   - Consistent key structure across all files

3. **Implement PlayerJoinListener**:
   - Detect client locale
   - Convert to language code format
   - Set player language if supported
   - Notify player of detection

4. **Implement LanguageCommand**:
   - Show current language
   - List available languages
   - Change language with validation
   - Refresh inventory items

5. **Integrate into existing systems**:
   - Replace hardcoded strings with getMessage() calls
   - Update GUI creation to use localized titles
   - Update item creation to use localized names/lore
   - Update command responses to use localized messages

6. **Test thoroughly**:
   - Multiple players with different languages
   - Language switching during gameplay
   - Missing translations (fallback behavior)
   - Server restart (persistence)
   - Invalid language codes

## Key Design Decisions

**Why per-player instead of server-wide?**
- Multiplayer servers have international players
- Each player should see their own language
- No need to compromise on single language

**Why YAML instead of JSON/properties?**
- Supports nested structures naturally
- Human-readable and easy to edit
- Supports lists for multi-line content
- Standard in Minecraft plugin ecosystem

**Why automatic detection?**
- Better user experience (no manual setup)
- Respects player's client settings
- Can still be overridden manually

**Why fallback chain?**
- Graceful degradation if translations incomplete
- Plugin remains functional with partial translations
- Encourages incremental translation work

## Common Pitfalls to Avoid

1. **Don't use tabs in YAML files** - Use 2 spaces for indentation
2. **Don't forget parameter placeholders** - %s must match between languages
3. **Don't hardcode color codes differently** - Keep formatting consistent
4. **Don't skip validation** - Always check language exists before setting
5. **Don't forget persistence** - Save language changes to file immediately
6. **Don't block main thread** - Use async for file I/O if needed
7. **Don't forget inventory refresh** - Update existing items when language changes

## Extension Points

To extend this system:

**Add new message types**:
- Add keys to all language files
- Use getMessage() or getMessageList()

**Add new languages**:
- Create new .yml file
- Follow existing structure
- Reload plugin

**Add language-specific formatting**:
- Extend getMessage() to handle date/time formatting
- Add number formatting based on locale
- Support RTL languages (right-to-left)

**Add GUI language selector**:
- Create inventory GUI with language flags
- Click to change language
- Visual feedback of current selection

This system provides a robust, scalable foundation for multi-language support in Minecraft plugins while maintaining simplicity and performance.
