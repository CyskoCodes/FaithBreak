# FaithBreak Multi-Language System

## Overview

FaithBreak now includes comprehensive multi-language support with automatic per-player localization. When players join the server, the plugin automatically detects their Minecraft client language and adapts all messages to match their preferred language.

## Features

### Automatic Language Detection
- Detects player's Minecraft client language on join
- Automatically sets player's language preference
- Supports fallback to English if language not available
- Notifies players about language detection (after 2 seconds to avoid join spam)

### Per-Player Localization
- Each player can have their own language preference
- Language preferences are saved and persist across sessions
- Players can manually change their language using commands

### Comprehensive Translation Support
- All command messages are localized
- Prayer time notifications are translated
- Prayer names are localized
- Error messages and help text are localized

## Supported Languages

Currently included language files:
- **English (US)** - `en_US` (default)
- **Arabic (Saudi Arabia)** - `ar_SA`
- **Urdu (Pakistan)** - `ur_PK`
- **Spanish (Spain)** - `es_ES`
- **French (France)** - `fr_FR`
- **Indonesian (Indonesia)** - `id_ID`
- **Hindi (India)** - `hi_IN`
- **German (Germany)** - `de_DE`
- **Polish (Poland)** - `pl_PL`
- **Dutch (Netherlands)** - `nl_NL`

Additional languages can be easily added by creating new language files in the `messages/` directory.

## Usage

### For Players

#### View Current Language
```
/language
```
Shows your current language and lists all available languages.

#### Change Language
```
/language <language_code>
```
Examples:
- `/language en_US` - Switch to English
- `/language ar_SA` - Switch to Arabic
- `/language ur_PK` - Switch to Urdu
- `/language es_ES` - Switch to Spanish
- `/language fr_FR` - Switch to French
- `/language id_ID` - Switch to Indonesian
- `/language hi_IN` - Switch to Hindi
- `/language de_DE` - Switch to German
- `/language pl_PL` - Switch to Polish
- `/language nl_NL` - Switch to Dutch

#### Short Command
```
/lang <language_code>
```
Same as the language command but shorter.

### For Administrators

#### Add New Languages
1. Create a new `.yml` file in `plugins/FaithBreak/messages/`
2. Use the format `language_COUNTRY.yml` (e.g., `de_DE.yml` for German)
3. Copy the structure from `en_US.yml` and translate the messages
4. Restart the plugin or server

## File Structure

```
plugins/FaithBreak/
├── messages/
│   ├── en_US.yml          # English (default)
│   ├── ar_SA.yml          # Arabic
│   ├── ur_PK.yml          # Urdu
│   ├── es_ES.yml          # Spanish
│   ├── fr_FR.yml          # French
│   ├── id_ID.yml          # Indonesian
│   ├── hi_IN.yml          # Hindi
│   ├── de_DE.yml          # German
│   ├── pl_PL.yml          # Polish
│   ├── nl_NL.yml          # Dutch
│   └── [other_languages]  # Additional languages
├── player_languages.yml   # Player language preferences
└── config.yml             # Plugin configuration
```

## Language File Format

Language files use YAML format with nested keys:

```yaml
# Language metadata
language:
  name: "English"
  code: "en_US"

# General messages
general:
  language_detected: "§aLanguage detected: %s"
  prefix: "§6[FaithBreak]§r"

# Commands
commands:
  no_permission: "§cYou don't have permission to use this command!"
  
  language:
    current: "§aCurrent language: §e%s"
    available: "§aAvailable languages:"
    changed: "§aLanguage changed to: §e%s"
    invalid: "§cInvalid language code: %s"
  
  non_muslim:
    opted_out: "§aYou have opted out of prayer time actions."
    opted_in: "§aYou will now receive prayer time notifications."

# Prayer messages
prayer:
  kick_message: "§cIt's %s prayer time! Please take a break."
  rejoin_warning: "§cYou can rejoin in %s minutes."
  reminder: "§e⏰ Reminder: It's %s prayer time!"
  
# Prayer names
prayers:
  Fajr: "Fajr"
  Dhuhr: "Dhuhr"
  Asr: "Asr"
  Maghrib: "Maghrib"
  Isha: "Isha"
```

## Technical Implementation

### Core Components

1. **LanguageManager** (`com.faithBreak.i18n.LanguageManager`)
   - Manages language files and player preferences
   - Handles message retrieval with fallback logic
   - Persists player language preferences

2. **PlayerJoinListener** (`com.faithBreak.listeners.PlayerJoinListener`)
   - Detects client language on player join
   - Automatically sets player language if supported
   - Notifies player about language detection

3. **LanguageCommand** (`com.faithBreak.commands.LanguageCommand`)
   - Handles `/language` and `/lang` commands
   - Allows players to view and change their language
   - Provides tab completion for language codes

### Language Detection Process

1. Player joins the server
2. Plugin waits 2 seconds (to avoid join message spam)
3. Detects client language using Bukkit API (`player.locale()`)
4. Converts locale format (e.g., `en_us` → `en_US`)
5. Checks if detected language is supported
6. Sets player's language preference (if new or changed)
7. Notifies player about language detection
8. All subsequent messages use player's preferred language

### Message Resolution

1. Plugin looks for message in player's preferred language
2. If not found, falls back to default language (English)
3. If still not found, returns the message key as fallback
4. Supports parameter substitution using `String.format()`

### Locale Conversion

The system converts Minecraft locale formats to standard language codes:

| Minecraft Locale | Language Code | Language |
|-----------------|---------------|----------|
| `en_us` | `en_US` | English (US) |
| `ar_sa` | `ar_SA` | Arabic (Saudi Arabia) |
| `ur_pk` | `ur_PK` | Urdu (Pakistan) |
| `es_es` | `es_ES` | Spanish (Spain) |
| `fr_fr` | `fr_FR` | French (France) |
| `id_id` | `id_ID` | Indonesian (Indonesia) |
| `hi_in` | `hi_IN` | Hindi (India) |
| `de_de` | `de_DE` | German (Germany) |
| `pl_pl` | `pl_PL` | Polish (Poland) |
| `nl_nl` | `nl_NL` | Dutch (Netherlands) |

Single-part locales are mapped to defaults:
- `en` → `en_US`
- `ar` → `ar_SA`
- `ur` → `ur_PK`
- `es` → `es_ES`
- `fr` → `fr_FR`
- `id` → `id_ID`
- `hi` → `hi_IN`
- `de` → `de_DE`
- `pl` → `pl_PL`
- `nl` → `nl_NL`

## Adding New Languages

### Step 1: Create Language File
Create a new file in `plugins/FaithBreak/messages/` with the format `language_COUNTRY.yml`.

### Step 2: Translate Messages
Copy the structure from `en_US.yml` and translate all messages:

```yaml
# Example for German (de_DE.yml)
language:
  name: "Deutsch"
  code: "de_DE"

general:
  language_detected: "§aErkannte Sprache: %s"
  prefix: "§6[FaithBreak]§r"

commands:
  no_permission: "§cDu hast keine Berechtigung, diesen Befehl zu verwenden!"
  
  language:
    current: "§aAktuelle Sprache: §e%s"
    available: "§aVerfügbare Sprachen:"
    changed: "§aSprache geändert zu: §e%s"
    invalid: "§cUngültiger Sprachcode: %s"
  
  non_muslim:
    opted_out: "§aDu hast dich von Gebetszeitaktionen abgemeldet."
    opted_in: "§aDu erhältst jetzt Gebetszeitbenachrichtigungen."

prayer:
  kick_message: "§cEs ist %s Gebetszeit! Bitte mache eine Pause."
  rejoin_warning: "§cDu kannst in %s Minuten wieder beitreten."
  reminder: "§e⏰ Erinnerung: Es ist %s Gebetszeit!"

prayers:
  Fajr: "Fadschr"
  Dhuhr: "Zuhr"
  Asr: "Asr"
  Maghrib: "Maghrib"
  Isha: "Ischa"
```

### Step 3: Update Locale Conversion (Optional)
If you want automatic detection for your new language, add it to the `convertLocaleToLanguageCode` method in `PlayerJoinListener.java`:

```java
case "de": return "de_DE";
```

### Step 4: Test and Restart
1. Restart the plugin or server
2. Test the new language: `/language de_DE`
3. Verify all messages display correctly

## Best Practices

### For Translators
- Keep color codes (`§a`, `§c`, etc.) consistent with the original
- Maintain the same parameter placeholders (`%s`, `%d`)
- Test translations in-game to ensure proper formatting
- Consider cultural context, not just literal translation
- For RTL languages (Arabic, Urdu), Minecraft handles text direction automatically

### For Developers
- Always use `languageManager.getMessage()` for user-facing messages
- Provide descriptive message keys for easy translation
- Test with multiple languages during development
- Use parameter substitution for dynamic content

## Troubleshooting

### Language Not Detected
- Ensure the player's client language is supported
- Check if the language file exists in the messages directory
- Verify the language file format is correct YAML
- Check console for any error messages

### Messages Not Translating
- Check if the message key exists in the language file
- Verify the YAML syntax is correct (no tabs, proper indentation)
- Ensure the language file was loaded (check console on startup)
- Try restarting the plugin or server

### Player Language Reset
- Language preferences are saved in `player_languages.yml`
- If this file is deleted, all players will revert to default language
- Backup this file to preserve player preferences

### Tab Completion Not Working
- Ensure the command is registered in `plugin.yml`
- Check that `TabCompleter` is properly set in `onEnable()`
- Verify player has permission `faithbreak.language`

## API Usage (For Developers)

If you want to integrate with the language system in your own code:

```java
// Get the language manager
LanguageManager languageManager = plugin.getLanguageManager();

// Get a message for a player
String message = languageManager.getMessage(player, "your.message.key", arg1, arg2);

// Get a list of messages
List<String> messages = languageManager.getMessageList(player, "your.list.key");

// Get player's current language
String language = languageManager.getPlayerLanguage(player.getUniqueId());

// Set player's language
languageManager.setPlayerLanguage(player.getUniqueId(), "ar_SA");

// Get available languages
Set<String> languages = languageManager.getAvailableLanguages();

// Get language display name
String name = languageManager.getLanguageName("ar_SA"); // Returns "العربية"
```

## Future Enhancements

Potential improvements for the language system:
- GUI for language selection with flags
- Automatic translation using external APIs
- Language-specific date/time formatting
- Regional variations (e.g., en_US vs en_GB, ar_SA vs ar_EG)
- More languages (Turkish, Indonesian, Malay, Bengali, etc.)
- Translation progress tracking
- Community translation contributions

## Credits

The multi-language system was inspired by best practices from the Minecraft plugin development community and adapted specifically for the FaithBreak prayer time plugin.

## Support

For issues with the language system:
1. Check the console for error messages
2. Verify language file syntax using a YAML validator
3. Test with the default English language first
4. Report bugs with specific language codes and error messages
5. Join our Discord/support channel for help

## License

This language system is part of the FaithBreak plugin and follows the same license terms.
