# 📖 Oh hey! You're actually reading this?! Let's gooo 🎉

Alright, here's how to use this plugin (super simple, I promise):

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

## 🔍 What Does FaithBreak Do?

FaithBreak is a unique Minecraft plugin that helps players take breaks during prayer times:

- 🌍 **Smart Location Detection**: The plugin automatically detects each player's location based on their IP address
- 🕰️ **Prayer Time Awareness**: Calculates accurate prayer times for the player's specific location
- ⏱️ **Timely Reminders**: Two minutes before prayer time, players are gently kicked from the server
- ⏳ **Break Duration**: Players can't rejoin for 12 minutes, giving them time for prayer or a short break
- 🔗 **Learn More Button**: Kicked players see a clickable gold button that opens the Modrinth page for more info!
- 🌐 **Universal Respect**: Non-Muslim players are also encouraged to take regular breaks for well-being
- 🎯 **Player Choice**: Use `/non-muslim` command to opt out of prayer time kicks and reminders (toggle on/off)
- 🌐 **Multi-Language Magic**: Messages automatically appear in each player's Minecraft language!

The plugin works silently in the background with zero configuration needed. It uses geolocation services and prayer time APIs to ensure accuracy across different regions and timezones.

---

## 🌍 Supported Languages (10 Total!)

FaithBreak automatically detects your Minecraft client language and shows all messages in your language:

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

**Change your language manually**: Use `/language <code>` or `/lang <code>`  
**View available languages**: Type `/language` to see all options

**💡 Server Owners**: Want to add more languages? Simply create `[language-code].yml` files in the `plugins/FaithBreak/messages` folder with your translations!

---

## 🎮 Commands

### `/non-muslim`
- **Description**: Toggle opting out of prayer time kicks and reminders
- **Usage**: Simply type `/non-muslim` in chat
- **Permission**: `faithbreak.nonmuslim` (default: true for all players)
- **How it works**: 
  - First use: Opts you out of prayer time kicks and reminders
  - Second use: Opts you back in to receive kicks and reminders
  - Your choice is remembered across server restarts

### `/language` or `/lang`
- **Description**: View or change your language preference
- **Usage**: 
  - `/language` - Show current language and available options
  - `/language <code>` - Change to a specific language
  - `/lang <code>` - Short alias
- **Permission**: `faithbreak.language` (default: true for all players)
- **Examples**:
  ```
  /language ar_SA    → Switch to Arabic
  /lang ur_PK        → Switch to Urdu
  /language          → Show current language
  ```

---

## 📋 Features in Detail

### 🔔 What Happens During Prayer Time?

**For Muslim Players (Middle Eastern Countries):**
1. 2 minutes before prayer time, you're kicked from the server
2. You see a message in your language with the prayer name
3. A clickable **[Learn More]** button appears (opens Modrinth page!)
4. You can rejoin after 12 minutes

**For Other Players:**
- Receive a friendly reminder message in chat
- No kick, just a gentle notification
- Encourages healthy gaming breaks

### 🚫 Don't Want Prayer Notifications?

No problem! Use `/non-muslim` to opt out:
- You'll receive reminders instead of kicks
- Toggle on/off anytime
- Your choice is saved permanently

### 🌐 Automatic Language Detection

When you join the server:
1. Plugin detects your Minecraft client language
2. Automatically sets your preference
3. All messages appear in your language
4. You can change it manually anytime with `/language`

### 🔗 Clickable "Learn More" Button

When kicked for prayer time, you'll see:
```
It's Fajr prayer time! Please take a break.
You can rejoin in 12 minutes.

[Learn More] ← Click this!
```
The gold button opens the Modrinth page so you can:
- Understand how the plugin works
- Learn about the `/non-muslim` command
- See all supported languages
- Get support if needed

---

## 🛠️ Technical Details

### Requirements
- **Minecraft Version**: 1.21+ (may work on older versions)
- **Server Software**: Paper, Spigot, Purpur
- **Java Version**: 21+

### How It Works
1. **Location Detection**: Uses IP geolocation APIs (ip-api.com, ipinfo.io)
2. **Prayer Times**: Fetches from Aladhan API with Umm Al-Qura calculation method
3. **Timezone Handling**: Automatically converts to player's local timezone
4. **Caching**: Locations cached for 24 hours to reduce API calls
5. **Privacy**: Local/private IPs are skipped (plugin disabled for localhost)

### Files Created
```
plugins/FaithBreak/
├── config.yml              # Plugin configuration
├── player_languages.yml    # Player language preferences
└── messages/               # Language files (10 languages)
    ├── en_US.yml
    ├── ar_SA.yml
    ├── ur_PK.yml
    ├── es_ES.yml
    ├── fr_FR.yml
    ├── id_ID.yml
    ├── hi_IN.yml
    ├── de_DE.yml
    ├── pl_PL.yml
    └── nl_NL.yml
```

### Permissions
- `faithbreak.nonmuslim` - Use `/non-muslim` command (default: true)
- `faithbreak.language` - Use `/language` command (default: true)

### Performance
- **Memory**: ~500KB for all language files
- **CPU**: Negligible (checks run every minute)
- **Network**: Minimal (cached geolocation, API calls only when needed)

---

## 📸 What Players See

### English Player
```
§cIt's Fajr prayer time! Please take a break.
§cYou can rejoin in 12 minutes.

§6§l[Learn More]
```

### Arabic Player
```
§cحان وقت صلاة الفجر! يرجى أخذ استراحة.
§cيمكنك العودة بعد 12 دقيقة.

§6§l[معرفة المزيد]
```

### Urdu Player
```
§cفجر نماز کا وقت ہے! براہ کرم وقفہ لیں۔
§cآپ 12 منٹ میں دوبارہ شامل ہو سکتے ہیں۔

§6§l[مزید جانیں]
```

*The gold button is clickable and opens the Modrinth page!*

---

## ❓ Frequently Asked Questions

**Q: I'm not Muslim, will I get kicked?**  
A: No! Non-Muslim players only receive gentle reminder messages in chat. You can also use `/non-muslim` to opt out completely.

**Q: Can I change the language?**  
A: Yes! Use `/language <code>` to change manually. The plugin auto-detects your Minecraft client language, but you can override it anytime.

**Q: What if I'm playing from a VPN or local network?**  
A: The plugin automatically detects local/private IPs and disables itself for those connections. No kicks, no reminders.

**Q: How accurate are the prayer times?**  
A: Very accurate! We use the Aladhan API with Umm Al-Qura calculation method (used in Saudi Arabia) and automatically adjust for your timezone.

**Q: How do I add a new language?**  
A: Copy any existing language file from `plugins/FaithBreak/messages/`, rename it to your language code (e.g., `tr_TR.yml` for Turkish), translate all messages, and restart the server!

---

## 🌟 What's New in Latest Version

### Version 1.2.1+
- ✨ **10 Languages Supported**: English, Arabic, Urdu, Spanish, French, Indonesian, Hindi, German, Polish, Dutch
- 🔗 **Clickable "Learn More" Button**: Gold button in kick messages opens Modrinth page
- 🌍 **Automatic Language Detection**: Detects Minecraft client language on join
- 🎨 **Rich Text Components**: Beautiful, colorful messages with Adventure API
- 📝 **Manual Language Switching**: `/language` command with tab completion
- 💾 **Persistent Preferences**: Language choices saved across restarts
- 🔄 **Fallback System**: Missing translations automatically fall back to English
- 🎯 **Localized Prayer Names**: Prayer names translated in Arabic, Urdu, Indonesian, Hindi, German, Polish

---

## ❓ Got questions or just wanna say hi?

Feel free to contact me on Discord:
```
CiscoCodes
```

Or check out the [Modrinth page](https://modrinth.com/plugin/faithbreak) for more information!

---

## 🙏 Why I Made This

I made this plugin to help my fellow **Muslim brothers and sisters** stay on track with their **prayer times**.  
Let’s be real — it’s easy to get completely lost in Minecraft and forget 😅  
This plugin gives a gentle nudge at the right moment 🕌⏰

Also, fun fact: this plugin is **automatically bundled** with every plugin I make.  
If you haven’t checked out my other creations yet, go explore them on [Modrinth](https://modrinth.com/user/CalastioTech) — who knows, you might find your next favorite plugin! 😉✨

## ☕ Support Me on Ko-fi

If you like my work, consider buying me a coffee:

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/calastiotech)


---

## 🤝 Contributing

Want to help improve FaithBreak?

- 🌐 **Translate**: Add your language by creating a new `.yml` file
- 🐛 **Report Bugs**: Open an issue on GitHub or contact me on Discord
- 💡 **Suggest Features**: Share your ideas for improvements
- ⭐ **Star & Share**: Help others discover this plugin!

---

## 📜 License & Credits

- **Plugin**: FaithBreak by CiscoCodes
- **Prayer Times API**: [Aladhan API](https://aladhan.com/prayer-times-api)
- **Geolocation**: ip-api.com, ipinfo.io
- **License**: Open source (check repository for details)

---

## 🔗 Useful Links

- 📦 [Download on Modrinth](https://modrinth.com/plugin/faithbreak/versions)
- 💬 Discord Support - Contact: `CiscoCodes`
- 📖 [Full Documentation](https://modrinth.com/plugin/faithbreak)
- ⭐ [Rate & Review](https://modrinth.com/plugin/faithbreak)

---

**Made with ❤️ for the Muslim Minecraft community**

*JazakAllahu Khairan (May Allah reward you with goodness) for using FaithBreak!* 🤲
