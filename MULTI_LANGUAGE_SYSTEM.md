# Multi-Language Support System

## Overview

The CelestialSwords plugin now includes comprehensive multi-language support with automatic per-player localization. When players join the server, the plugin automatically detects their Minecraft client language and adapts all messages, commands, and GUI elements to match their preferred language.

## Features

### Automatic Language Detection
- Detects player's Minecraft client language on join
- Automatically sets player's language preference
- Supports fallback to English if language not available
- Notifies players about language detection

### Per-Player Localization
- Each player can have their own language preference
- Language preferences are saved and persist across sessions
- Players can manually change their language using commands

### Comprehensive Translation Support
- All command messages are localized
- GUI titles and elements are translated
- Error messages and help text are localized
- Sword names can be translated for different languages

## Supported Languages

Currently included language files:
- **English (US)** - `en_US` (default)
- **Spanish (Spain)** - `es_ES`
- **French (France)** - `fr_FR`
- **Polish (Poland)** - `pl_PL`
- **Dutch (Netherlands)** - `nl_NL`
- **German (Germany)** - `de_DE`
- **Hindi (India)** - `hi_IN`
- **Urdu (Pakistan)** - `ur_PK`

Additional languages can be easily added by creating new language files in the `messages/` directory.

## Usage

### For Players

#### View Current Language
```
/aswords language
```
Shows your current language and lists all available languages.

#### Change Language
```
/aswords language <language_code>
```
Examples:
- `/aswords language en_US` - Switch to English
- `/aswords language es_ES` - Switch to Spanish
- `/aswords language fr_FR` - Switch to French
- `/aswords language pl_PL` - Switch to Polish
- `/aswords language nl_NL` - Switch to Dutch
- `/aswords language de_DE` - Switch to German
- `/aswords language hi_IN` - Switch to Hindi
- `/aswords language ur_PK` - Switch to Urdu

#### Short Command
```
/aswords lang <language_code>
```
Same as the language command but shorter.

### For Administrators

#### Reload Language Files
```
/aswords reload
```
Reloads all plugin configurations including language files.

#### Add New Languages
1. Create a new `.yml` file in `plugins/CelestialSwords/messages/`
2. Use the format `language_country.yml` (e.g., `de_DE.yml` for German)
3. Copy the structure from `en_US.yml` and translate the messages
4. Reload the plugin with `/aswords reload`

## File Structure

```
plugins/CelestialSwords/
├── messages/
│   ├── en_US.yml          # English (default)
│   ├── es_ES.yml          # Spanish
│   ├── fr_FR.yml          # French
│   ├── pl_PL.yml          # Polish
│   ├── nl_NL.yml          # Dutch
│   ├── de_DE.yml          # German
│   ├── hi_IN.yml          # Hindi
│   ├── ur_PK.yml          # Urdu
│   └── [other_languages]  # Additional languages
├── player_languages.yml   # Player language preferences
└── [other config files]
```

## Language File Format

Language files use YAML format with nested keys:

```yaml
# Commands
commands:
  no_permission: "§cYou don't have permission to use this command!"
  reload:
    success: "§aSuccessfully reloaded configurations!"

# GUI Elements
gui:
  main_title: "Astral Swords Recipes"
  recipe_title: "%s Recipe"

# Sword Names
swords:
  SHADOWBANE: "Shadowbane"
  PHOENIX_TALON: "Phoenix Talon"
  # ... more swords

# General Messages
general:
  language_detected: "§aLanguage detected: %s"
  language_set: "§aLanguage set to: %s"
```

## Technical Implementation

### Core Components

1. **LanguageManager** - Manages language files and player preferences
2. **PlayerJoinListener** - Detects client language on player join
3. **LanguageCommand** - Handles language-related commands
4. **Localized Components** - Updated GUI, commands, and messages
5. **Backward Compatibility** - Maintains compatibility with existing GUI listeners

### Language Detection Process

1. Player joins the server
2. Plugin detects client language using Bukkit API
3. Checks if detected language is supported
4. Sets player's language preference (if new or changed)
5. Notifies player about language detection
6. All subsequent messages use player's preferred language

### Message Resolution

1. Plugin looks for message in player's preferred language
2. If not found, falls back to default language (English)
3. If still not found, returns the message key as fallback
4. Supports parameter substitution using String.format()

### Backward Compatibility

The system maintains backward compatibility with existing code:
- `SwordGUI.MAIN_GUI_TITLE` constant still exists for legacy code
- `SwordGUI.isMainGUITitle()` method handles localized title detection
- Existing GUI listeners work with both localized and non-localized titles

## Adding New Languages

### Step 1: Create Language File
Create a new file in `plugins/CelestialSwords/messages/` with the format `language_COUNTRY.yml`.

### Step 2: Translate Messages
Copy the structure from `en_US.yml` and translate all messages:

```yaml
# Example for German (de_DE.yml)
commands:
  no_permission: "§cDu hast keine Berechtigung für diesen Befehl!"
  reload:
    success: "§aKonfigurationen erfolgreich neu geladen!"

gui:
  main_title: "Astrale Schwert Rezepte"
  recipe_title: "%s Rezept"

swords:
  SHADOWBANE: "Schattenbann"
  PHOENIX_TALON: "Phönixklaue"
  # ... translate all sword names
```

```yaml
# Example for Polish (pl_PL.yml) - Already included!
commands:
  no_permission: "§cNie masz uprawnień do użycia tej komendy!"
  reload:
    success: "§aPomyślnie przeładowano konfiguracje CelestialSwords!"

gui:
  main_title: "Przepisy Mieczy Astralnych"
  recipe_title: "Przepis na %s"

swords:
  SHADOWBANE: "Pogromca Cieni"
  PHOENIX_TALON: "Szpon Feniksa"
  # ... all sword names translated
```

```yaml
# Example for Dutch (nl_NL.yml) - Already included!
commands:
  no_permission: "§cJe hebt geen toestemming om dit commando te gebruiken!"
  reload:
    success: "§aCelestialSwords configuraties succesvol herladen!"

gui:
  main_title: "Astrale Zwaarden Recepten"
  recipe_title: "%s Recept"

swords:
  SHADOWBANE: "Schaduwbane"
  PHOENIX_TALON: "Feniks Klauw"
  # ... all sword names translated
```

```yaml
# Example for German (de_DE.yml) - Already included!
commands:
  no_permission: "§cDu hast keine Berechtigung, diesen Befehl zu verwenden!"
  reload:
    success: "§aCelestialSwords Konfigurationen erfolgreich neu geladen!"

gui:
  main_title: "Astrale Schwert Rezepte"
  recipe_title: "%s Rezept"

swords:
  SHADOWBANE: "Schattenbann"
  PHOENIX_TALON: "Phönixklaue"
  # ... all sword names translated
```

```yaml
# Example for Hindi (hi_IN.yml) - Already included!
commands:
  no_permission: "§cआपके पास इस कमांड का उपयोग करने की अनुमति नहीं है!"
  reload:
    success: "§aCelestialSwords कॉन्फ़िगरेशन सफलतापूर्वक पुनः लोड किया गया!"

gui:
  main_title: "खगोलीय तलवार व्यंजन"
  recipe_title: "%s व्यंजन"

swords:
  SHADOWBANE: "छाया-नाशक"
  PHOENIX_TALON: "फीनिक्स पंजा"
  # ... all sword names translated
```

```yaml
# Example for Urdu (ur_PK.yml) - Already included!
commands:
  no_permission: "§cآپ کو اس کمانڈ کا استعمال کرنے کی اجازت نہیں ہے!"
  reload:
    success: "§aCelestialSwords کنفیگریشن کامیابی سے دوبارہ لوڈ ہو گئی!"

gui:
  main_title: "فلکی تلواروں کی ترکیبیں"
  recipe_title: "%s کی ترکیب"

swords:
  SHADOWBANE: "سایہ کش"
  PHOENIX_TALON: "ققنوس پنجہ"
  # ... all sword names translated
```

### Step 3: Update Tab Completion (Optional)
Add the new language code to `TabCompleter.java` for command completion.

### Step 4: Test and Reload
1. Reload the plugin: `/aswords reload`
2. Test the new language: `/aswords language de_DE`
3. Verify all messages display correctly

## Best Practices

### For Translators
- Keep color codes (`§a`, `§c`, etc.) consistent with the original
- Maintain the same parameter placeholders (`%s`, `%d`)
- Test translations in-game to ensure proper formatting
- Consider cultural context, not just literal translation

### For Developers
- Always use the LanguageManager for user-facing messages
- Provide fallback messages for console commands
- Use descriptive message keys for easy translation
- Test with multiple languages during development

## Troubleshooting

### Language Not Detected
- Ensure the player's client language is supported
- Check if the language file exists in the messages directory
- Verify the language file format is correct YAML

### Messages Not Translating
- Check if the message key exists in the language file
- Verify the YAML syntax is correct (no tabs, proper indentation)
- Reload the plugin after making changes to language files

### Player Language Reset
- Language preferences are saved in `player_languages.yml`
- If this file is deleted, all players will revert to default language
- Backup this file to preserve player preferences

## Future Enhancements

Potential improvements for the language system:
- GUI for language selection
- Automatic translation using external APIs
- Language-specific date/time formatting
- Regional variations (e.g., en_US vs en_GB)
- RTL (Right-to-Left) language support
- Voice message localization

## Support

For issues with the language system:
1. Check the console for error messages
2. Verify language file syntax using a YAML validator
3. Test with the default English language first
4. Report bugs with specific language codes and error messages