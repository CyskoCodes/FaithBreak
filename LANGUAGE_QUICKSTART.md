# FaithBreak Multi-Language Quick Start Guide

## What's New?

FaithBreak now automatically detects each player's Minecraft client language and shows all messages in their preferred language!

## For Players

### Automatic Detection
When you join the server, FaithBreak will automatically detect your Minecraft client language and use it. You'll see a message like:
```
§aLanguage detected: English
```

### Change Your Language Manually
If you want to use a different language:
```
/language <code>
```

**Available Languages:**
- `/language en_US` - English
- `/language ar_SA` - Arabic (العربية)
- `/language ur_PK` - Urdu (اردو)
- `/language es_ES` - Spanish (Español)
- `/language fr_FR` - French (Français)
- `/language id_ID` - Indonesian (Bahasa Indonesia)
- `/language hi_IN` - Hindi (हिन्दी)
- `/language de_DE` - German (Deutsch)
- `/language pl_PL` - Polish (Polski)
- `/language nl_NL` - Dutch (Nederlands)

### View Available Languages
```
/language
```
This shows your current language and all available options.

## For Server Administrators

### Installation
1. Replace your old FaithBreak.jar with the new version
2. Restart your server
3. The plugin will automatically create language files in `plugins/FaithBreak/messages/`

### File Structure
After first run, you'll see:
```
plugins/FaithBreak/
├── messages/
│   ├── en_US.yml
│   ├── ar_SA.yml
│   ├── ur_PK.yml
│   ├── es_ES.yml
│   ├── fr_FR.yml
│   ├── id_ID.yml
│   ├── hi_IN.yml
│   ├── de_DE.yml
│   ├── pl_PL.yml
│   └── nl_NL.yml
├── player_languages.yml  (stores player preferences)
└── config.yml
```

### Adding a New Language

1. **Create a new file** in `plugins/FaithBreak/messages/`
   - Name it using format: `language_COUNTRY.yml`
   - Example: `de_DE.yml` for German

2. **Copy the structure** from `en_US.yml`

3. **Translate the messages**
   - Keep the color codes (`§a`, `§c`, etc.)
   - Keep the placeholders (`%s`)
   - Example:
   ```yaml
   language:
     name: "Deutsch"
     code: "de_DE"
   
   commands:
     language:
       current: "§aAktuelle Sprache: §e%s"
   ```

4. **Restart the server**

5. **Test it**: `/language de_DE`

### Editing Existing Languages

1. Open the language file (e.g., `messages/en_US.yml`)
2. Edit the messages
3. Save the file
4. Restart the server

**Important:** 
- Use 2 spaces for indentation (not tabs)
- Keep the structure the same
- Don't remove the `%s` placeholders

### Permissions

- `faithbreak.language` - Allows players to use `/language` command (default: true)
- `faithbreak.nonmuslim` - Allows players to use `/non-muslim` command (default: true)

## Examples

### Player Experience

**English Player:**
```
> /non-muslim
§aYou have opted out of prayer time actions.

> /language ar_SA
§aLanguage changed to: العربية
```

**Arabic Player:**
```
> /non-muslim
§aلقد اخترت عدم المشاركة في إجراءات وقت الصلاة.

> /language en_US
§aLanguage changed to: English
```

### Prayer Time Messages

**English:**
```
§cIt's Fajr prayer time! Please take a break.
§cYou can rejoin in 12 minutes.
```

**Arabic:**
```
§cحان وقت صلاة الفجر! يرجى أخذ استراحة.
§cيمكنك العودة بعد 12 دقيقة.
```

**Urdu:**
```
§cفجر نماز کا وقت ہے! براہ کرم وقفہ لیں۔
§cآپ 12 منٹ میں دوبارہ شامل ہو سکتے ہیں۔
```

## Troubleshooting

### "Language not detected"
- The player's client language might not be supported yet
- They can manually select a language with `/language <code>`

### "Messages still in English"
- Check if the language file exists in `plugins/FaithBreak/messages/`
- Verify the YAML syntax is correct (use a YAML validator)
- Restart the server after adding new language files

### "Player language reset after restart"
- Check if `player_languages.yml` exists and is not corrupted
- Make sure the file has write permissions

## Tips

### For Multilingual Servers
- The plugin automatically detects each player's language
- Players from different countries see messages in their own language
- No configuration needed!

### For Single-Language Servers
- Players can still manually change their language preference
- Useful for players who prefer a different language than their client

### For Translators
- You can edit language files while the server is running
- Restart the server to apply changes
- Test your translations with `/language <code>`

## Need Help?

- Check `LANGUAGE_SYSTEM.md` for detailed documentation
- Look at existing language files for examples
- Test with `/language en_US` if something goes wrong

## What Gets Translated?

✅ Prayer time kick messages
✅ Prayer time reminders  
✅ Prayer names (Fajr, Dhuhr, Asr, Maghrib, Isha)
✅ Command responses
✅ Error messages
✅ Help text
✅ Language detection notifications

## Coming Soon

- More languages (Turkish, Indonesian, Malay, Bengali, etc.)
- GUI for language selection
- Translation progress tracking
- Community translation contributions

---

**Enjoy FaithBreak in your language! 🌍🕌**
