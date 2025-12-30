# 🕌 **FaithBreak v1.3.2 — Persistence & Privacy Update!** 🛡️

Warriors of faith, **v1.3.2** is here with **persistent opt-out preferences** and **enhanced privacy controls**! Your `/non-muslim` choice is now saved forever, and server admins have full control over location logging. 🚀

---

## ⚙️ How to Use
1. 📥 Download the **latest release**
2. 📂 Drop it into your server's `plugins` folder
3. 🚀 Start the server... and BOOM, you're all set!

**No configuration needed!** The plugin automatically:
- Detects player locations
- Calculates prayer times
- Detects player languages
- Creates all necessary files

---

## ✨ **What's New in v1.3.2** ✨

### 🎯 Major Improvements
* **feat:** 💾 **PERSISTENT OPT-OUT** - `/non-muslim` preference now saved to file! Survives server restarts and player reconnects
* **feat:** 🔒 **PRIVACY CONTROLS** - New `log-player-locations` config option (default: OFF) - no more location spam in console!
* **feat:** 🎮 **UNIFIED COMMANDS** - All commands now under `/fb` for cleaner organization
* **feat:** 🧪 **KICK TEST COMMAND** - `/fb kick <prayer>` lets admins test the kick screen without the 12-min timer
* **fix:** 🔇 **SILENT BY DEFAULT** - Player locations no longer logged unless explicitly enabled

### 🛡️ Why Persistent Opt-Out Matters
- **One-time setup!** - Players only need to type `/non-muslim` once, ever
- **Survives restarts** - Server reboots won't reset player preferences
- **Respects player choice** - Your decision is remembered permanently

---

## 🔍 What Does FaithBreak Do?

FaithBreak is a unique Minecraft plugin that helps players take breaks during prayer times:

- 🌍 **Smart Location Detection**: Automatically detects each player's location based on their IP
- 🕰️ **Prayer Time Awareness**: Calculates accurate prayer times for each player's specific location
- ⏱️ **Timely Reminders**: Two minutes before prayer time, players are gently kicked
- ⏳ **Break Duration**: Players can't rejoin for 12 minutes, giving time for prayer
- 🌐 **Multi-Language Magic**: Messages automatically appear in each player's Minecraft language!
- 🎯 **Player Choice**: Use `/non-muslim` to opt out permanently (saved across restarts!)

---

## 🎮 Commands

### Player Commands
| Command | Description |
|---------|-------------|
| `/non-muslim` | Toggle opt-out of prayer kicks (saved permanently!) |
| `/fb lang` | View current language and available options |
| `/fb lang <code>` | Change your language (e.g., `/fb lang ar_SA`) |

### Admin Commands (OP only)
| Command | Description |
|---------|-------------|
| `/fb kick <prayer>` | Test the kick screen without the 12-min timer |

**Examples:**
```
/fb lang ar_SA     → Switch to Arabic
/fb lang ur_PK     → Switch to Urdu
/fb kick Fajr      → Test Fajr kick screen (OP only)
/non-muslim        → Toggle opt-out (saved forever!)
```

---

## 🌍 Supported Languages (10 Total!)

FaithBreak automatically detects your Minecraft client language:

| Flag | Language | Code |
|------|----------|------|
| 🇬🇧 | English | en_US |
| 🇸🇦 | Arabic - العربية | ar_SA |
| 🇵🇰 | Urdu - اردو | ur_PK |
| 🇪🇸 | Spanish - Español | es_ES |
| 🇫🇷 | French - Français | fr_FR |
| 🇮🇩 | Indonesian - Bahasa | id_ID |
| 🇮🇳 | Hindi - हिन्दी | hi_IN |
| 🇩🇪 | German - Deutsch | de_DE |
| 🇵🇱 | Polish - Polski | pl_PL |
| 🇳🇱 | Dutch - Nederlands | nl_NL |

**💡 Server Owners**: Add more languages by creating `[code].yml` files in `plugins/FaithBreak/messages/`!

---

## ⚙️ Configuration

```yaml
# config.yml
debug-mode: false              # Detailed debug logging
log-player-locations: false    # Log player country/city (privacy setting)
```

### 🔒 Privacy First
By default, FaithBreak does NOT log player locations to console. Enable `log-player-locations` only if you need it for debugging.

---

## 📋 Features in Detail

### 🔔 What Happens During Prayer Time?

**For Middle Eastern Players:**
1. 2 minutes before prayer → kicked from server
2. See localized message with prayer name
3. Can rejoin after 12 minutes

**For Other Players:**
- Receive a friendly reminder in chat
- No kick, just a gentle notification

### 💾 Persistent Preferences

Your choices are saved in `plugins/FaithBreak/optout.yml`:
- `/non-muslim` opt-out status saved permanently
- Survives server restarts
- No need to re-enter commands

---

## 🛠️ Technical Details

### Requirements
- **Minecraft**: 1.21+
- **Server**: Paper, Spigot, Purpur
- **Java**: 21+

### Files Created
```
plugins/FaithBreak/
├── config.yml              # Plugin settings
├── optout.yml              # Persistent opt-out data (NEW!)
├── player_languages.yml    # Language preferences
└── messages/               # 10 language files
```

### Permissions
| Permission | Description | Default |
|------------|-------------|---------|
| `faithbreak.nonmuslim` | Use `/non-muslim` | true |
| `faithbreak.use` | Use `/fb` commands | true |
| `faithbreak.admin` | Use `/fb kick` test | op |

---

## ❓ FAQ

**Q: Will my opt-out be remembered after I log off?**  
A: Yes! As of v1.3.2, your `/non-muslim` preference is saved permanently.

**Q: Is my location logged?**  
A: Not by default! Location logging is OFF unless you enable `log-player-locations` in config.

**Q: How do I test the kick screen?**  
A: Use `/fb kick Fajr` (or any prayer name) - you can rejoin immediately!

---

## 🙏 Why I Made This

I made this plugin to help my fellow **Muslim brothers and sisters** stay on track with their **prayer times**.  
Let's be real — it's easy to get completely lost in Minecraft and forget 😅  
This plugin gives a gentle nudge at the right moment 🕌⏰

---

## ☕ Support Me on Ko-fi

If you like my work, consider buying me a coffee:

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/calastiotech)

---

## ❓ Got questions?

Contact me on Discord: `CiscoCodes`

Or check out the [Modrinth page](https://modrinth.com/plugin/faithbreak)!

---

**Made with ❤️ for the Muslim Minecraft community**

*JazakAllahu Khairan (May Allah reward you with goodness) for using FaithBreak!* 🤲
