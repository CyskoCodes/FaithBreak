# 📜 FaithBreak Changelog

## v1.3.1 — Persistence & Privacy Update 🛡️

### ✨ New Features
- **💾 Persistent Opt-Out** - `/non-muslim` preference now saved to `optout.yml`! Survives server restarts and player reconnects
- **🔒 Privacy Controls** - New `log-player-locations` config option (default: OFF)
- **🎮 Unified Commands** - Language command moved to `/fb lang` for cleaner organization
- **🧪 Kick Test Command** - `/fb kick <prayer>` lets admins test the kick screen without the 12-min timer

### 🔧 Changes
- `/language` and `/lang` commands replaced with `/fb lang`
- Player locations no longer logged to console by default
- Added `faithbreak.admin` permission for `/fb kick` command
- Added `faithbreak.use` permission for `/fb` commands

### 🐛 Fixes
- Fixed opt-out status resetting after server restart
- Fixed opt-out status resetting after player reconnect
- Reduced console spam from location detection

### 📁 New Files
- `optout.yml` - Stores player opt-out preferences persistently

### ⚙️ Config Changes
```yaml
# New option in config.yml
log-player-locations: false    # Log player country/city to console (default: OFF)
```

---

## v1.3.0 — Multi-Language Update 🌍

### ✨ New Features
- **10 Languages Supported**: English, Arabic, Urdu, Spanish, French, Indonesian, Hindi, German, Polish, Dutch
- **Automatic Language Detection**: Detects Minecraft client language on join
- **Manual Language Switching**: `/language` command with tab completion
- **Persistent Language Preferences**: Saved across restarts

### 🔧 Changes
- Rich text components with Adventure API
- Localized prayer names in supported languages
- Fallback system for missing translations

---

## v1.2.x — Initial Releases

- Smart location detection via IP geolocation
- Prayer time calculation using Aladhan API
- 12-minute break enforcement for Middle Eastern players
- `/non-muslim` opt-out command
- Reminder messages for non-Middle Eastern players
