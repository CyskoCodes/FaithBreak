# 🕌 **FaithBreak v1.3.1 — Persistence & Privacy Update!** 🛡️

### 🌟 **Join Our Discord for Giveaways & Events!** 🎮

Join our **[Discord Server](https://discord.gg/snkKDmc89f)** 🔗 for monthly giveaways & events where you can win coupon codes or plugins like **[AstralSwords Premium](https://builtbybit.com/resources/astral-swords.81777/)** or **[TrimBlades](https://builtbybit.com/resources/trimblades.87033/)**! 🎨🚀

---

Warriors of faith, **v1.3.1** is here with **persistent opt-out preferences** and **enhanced privacy controls**! Your `/non-muslim` choice is now saved forever, and server admins have full control over location logging. 🚀

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

## ✨ **What's New in v1.3.1** ✨

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

### Previous Updates Still Included:
* ✨ **10 Languages Supported**: English, Arabic, Urdu, Spanish, French, Indonesian, Hindi, German, Polish, Dutch
* 🌍 **Automatic Language Detection**: Detects Minecraft client language on join
* 🎨 **Rich Text Components**: Beautiful messages with Adventure API
* 💾 **Persistent Preferences**: All choices saved across restarts

---

## 🔍 What Does FaithBreak Do?

FaithBreak is a unique Minecraft plugin that helps players take breaks during prayer times:

- 🌍 **Smart Location Detection**: Automatically detects each player's location based on their IP
- 🕰️ **Prayer Time Awareness**: Calculates accurate prayer times for each player's specific location
- ⏱️ **Timely Reminders**: Two minutes before prayer time, players are gently kicked
- ⏳ **Break Duration**: Players can't rejoin for 12 minutes, giving time for prayer
- 🌐 **Multi-Language Magic**: Messages automatically appear in each player's Minecraft language!
- 🎯 **Player Choice**: Use `/non-muslim` to opt out permanently (saved across restarts!)

The plugin works silently in the background with zero configuration needed.

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

- 🇬🇧 **English** (en_US)
- 🇸🇦 **Arabic** (ar_SA) - العربية
- 🇵🇰 **Urdu** (ur_PK) - اردو
- 🇪🇸 **Spanish** (es_ES) - Español
- 🇫🇷 **French** (fr_FR) - Français
- 🇮🇩 **Indonesian** (id_ID) - Bahasa Indonesia
- 🇮🇳 **Hindi** (hi_IN) - हिन्दी
- 🇩🇪 **German** (de_DE) - Deutsch
- 🇵🇱 **Polish** (pl_PL) - Polski
- 🇳🇱 **Dutch** (nl_NL) - Nederlands

**💡 Server Owners**: Add more languages by creating `[code].yml` files in `plugins/FaithBreak/messages/`!

---

## 📋 Features in Detail

### 🔔 What Happens During Prayer Time?

**For Middle Eastern Players:**
1. 2 minutes before prayer → kicked from server
2. See localized message with prayer name
3. Link to this page for more info
4. Can rejoin after 12 minutes

**For Other Players:**
- Receive a friendly reminder in chat
- No kick, just a gentle notification
- Encourages healthy gaming breaks

### 🚫 Don't Want Prayer Notifications?

No problem! Use `/non-muslim` to opt out:
- You won't receive kicks or reminders
- Toggle on/off anytime
- **NEW: Your choice is saved permanently!**

### 🔒 Privacy First (NEW!)

By default, FaithBreak does NOT log player locations to console:
- No more "Player X location detected: Country, City" spam
- Enable `log-player-locations: true` in config only if needed
- Your players' privacy is respected

### 🧪 Test Mode for Admins (NEW!)

Want to see what players see when kicked?
```
/fb kick Fajr
```
- Shows the exact kick screen
- No 12-minute timer - rejoin immediately!
- Great for testing translations

---

## ⚙️ Configuration

```yaml
# config.yml
debug-mode: false              # Detailed debug logging
log-player-locations: false    # Log player country/city (default: OFF)
```

---

## 🛠️ Technical Details

### Requirements
- **Minecraft**: 1.21+ (may work on older versions)
- **Server**: Paper, Spigot, Purpur
- **Java**: 21+

### How It Works
1. **Location Detection**: Uses IP geolocation APIs (ip-api.com, ipinfo.io)
2. **Prayer Times**: Fetches from Aladhan API with Umm Al-Qura method
3. **Timezone Handling**: Automatically converts to player's local timezone
4. **Caching**: Locations cached for 24 hours to reduce API calls
5. **Privacy**: Local/private IPs are skipped automatically

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

## ❓ Frequently Asked Questions

**Q: Will my opt-out be remembered after I log off?**  
A: Yes! As of v1.3.2, your `/non-muslim` preference is saved permanently to a file.

**Q: Is my location logged to console?**  
A: Not by default! Location logging is OFF unless the server admin enables `log-player-locations` in config.

**Q: How do I test the kick screen?**  
A: Use `/fb kick Fajr` (or any prayer name) as an OP - you can rejoin immediately!

**Q: I'm not Muslim, will I get kicked?**  
A: No! Non-Muslim players only receive gentle reminders. Use `/non-muslim` to opt out completely.

**Q: Can I change the language?**  
A: Yes! Use `/fb lang <code>` to change manually, or let the plugin auto-detect from your Minecraft client.

**Q: What if I'm on a VPN or local network?**  
A: The plugin detects local/private IPs and disables itself for those connections.

**Q: How do I add a new language?**  
A: Copy any existing language file from `plugins/FaithBreak/messages/`, rename it, translate, and restart!

---

## 🎯 **Why Update to v1.3.1?**

**If you've experienced:**
- Having to re-type `/non-muslim` after every server restart
- Console spam with player locations
- Wanting to test the kick screen without waiting 12 minutes

**v1.3.2 fixes all of this!**

---

## 🙏 Why I Made This

I made this plugin to help my fellow **Muslim brothers and sisters** stay on track with their **prayer times**.  
Let's be real — it's easy to get completely lost in Minecraft and forget 😅  
This plugin gives a gentle nudge at the right moment 🕌⏰

Also, fun fact: this plugin is **automatically bundled** with every plugin I make.  
Check out my other creations on [Modrinth](https://modrinth.com/user/CalastioTech)! 😉✨

---

## ☕ Support Me on Ko-fi

If you like my work, consider buying me a coffee:

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/calastiotech)

---

## 📸 What Players See

### English Player
```
It's Fajr prayer time! Please take a break.
You can rejoin in 12 minutes.

Learn More: https://modrinth.com/plugin/faithbreak
```

### Arabic Player
```
حان وقت صلاة الفجر! يرجى أخذ استراحة.
يمكنك العودة بعد 12 دقيقة.

معرفة المزيد: https://modrinth.com/plugin/faithbreak
```

---

## 🤝 Contributing

Want to help improve FaithBreak?

- 🌐 **Translate**: Add your language by creating a new `.yml` file
- 🐛 **Report Bugs**: Contact me on Discord
- 💡 **Suggest Features**: Share your ideas!
- ⭐ **Star & Share**: Help others discover this plugin!

---

## ❓ Got questions?

Contact me on Discord: `CiscoCodes`

---

## 🔗 Useful Links

- 📦 [Download Latest Version](https://modrinth.com/plugin/faithbreak/versions)
- 💬 Discord Support: `CiscoCodes`
- ⭐ [Rate & Review](https://modrinth.com/plugin/faithbreak)

---

**Made with ❤️ for the Muslim Minecraft community**

*JazakAllahu Khairan (May Allah reward you with goodness) for using FaithBreak!* 🤲
