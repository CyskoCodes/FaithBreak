### 🌟 **Join Our Discord for Giveaways & Events!** 🎮

Join our **[Discord Server](https://discord.gg/snkKDmc89f)** 🔗 for monthly giveaways & events where you can win coupon codes or plugins like **[AstralSwords Premium](https://builtbybit.com/resources/astral-swords.81777/)** or **[TrimBlades](https://builtbybit.com/resources/trimblades.87033/)**! Plus, grab the official **[Astral Swords Texture Pack](https://discord.gg/snkKDmc89f)** on the **Discord Server** for free! 🎨🚀

---

# ⚔️ **Astral Swords v1.2.13 — Reliability & Architecture Update!** 🛠️

Warriors, **v1.2.13** is here with **major sword identification improvements** and **architecture enhancements**! This update brings NBT-based sword detection for bulletproof reliability, plus a unified configuration system. 🚀
Your swords will now be recognized correctly even if renamed — no more false negatives! Full details below!

---

## ✨ **What's New in v1.2.13** ✨

### 🎯 Major Improvements
* **fix:** 🎯 **NBT-BASED SWORD IDENTIFICATION** - Swords are now identified using NBT tags instead of display names, making detection bulletproof even when swords are renamed!
* **feat:** ⚙️ **UNIFIED CONFIGURATION SYSTEM** - Streamlined config management for easier customization
* **refactor:** 🏗️ **REMOVED PLUGIN INSTANCE DEPENDENCIES** - Event listeners no longer depend on plugin instances, improving stability and reducing potential crashes
* **docs:** 📝 **Updated plugin branding** - Consistent AstralSwords naming throughout the plugin

### 🛡️ Why NBT-Based Detection Matters
- **Renamed swords still work!** - Players can rename their swords at anvils without breaking abilities
- **No more false negatives** - Sword detection is now 100% reliable regardless of display name changes
- **Better mod compatibility** - Works seamlessly with plugins that modify item names

### Previous v1.2.12 Fixes Still Included:
* **fix:** 🛡️ **FIXED NULLPOINTEREXCEPTION CRASH** - Resolved server crashes when attacking with Astral Swords
* **fix:** 🚨 **FIXED CONSOLE SPAM** - Eliminated "Plugin cannot be null" error flooding server console
* **refactor:** 🌘 **Enhanced Eclipse Blade invisibility** - Invisibility now persists across item switches until ability ends
* **fix:** ⏰ **FIXED Eclipse Blade infinite invisibility exploit** - Dropping and picking up the sword now properly respects the 90-second timer

### v1.2.11 Features:
* **feat:** 🗡️ **POWER HOUSE SWORD** - New sword with ground slam ability that sends enemies flying!
* **feat:** ⚡ **REDUCED COOLDOWNS** - Ability cooldowns reduced from 75s to 25s for faster-paced combat
* **feat:** ✨ **CONTINUOUS SWORD EFFECTS** - Phoenix Talon grants Fire Resistance, Windblade grants Speed II while held
* **feat:** 🔄 **SELF-UPDATE FUNCTIONALITY** - Check and install updates directly from in-game!

---

## ✨ **Features & Improvements** ✨
🔹 **Custom Trigger System** – Set your own keybind to activate abilities (must already be bound in MC) 🔑
🔹 **Config Overhaul** – Full control over recipes & enchants
🔹 **Sword Tracking 2.0** – No more duplicate swords! 🔒
🔹 **Global Crafting Announcements** – Let the world know a sword has emerged (without exposing the crafter!) 🌍
🔹 **Sword Selection GUI** – Deciding between two swords? Choose easily via a sleek chat popup menu 🪄
🔹 **Disable Containers** - Swords can't be put into any container except anvils

---

### 🌟 **Sword Playstyle Types**
Each sword now has a unique playstyle type:
- **DUELIST** - Focused on one-on-one combat and skilled swordplay
- **INITIATOR** - Excels at starting fights and creating opportunities
- **CONTROLLER** - Masters of crowd control and battlefield manipulation
- **SENTINEL** - Defensive playstyle with sustain and protective abilities

---

### 🌈 Visual Effects & Feedback  
- **Custom Particles:** Each sword has its own stunning visuals when activated! ✨  
  - *Eclipse Blade* → Dark Aura ☁️  
  - *Phoenix Talon* → Fiery Sparks 🔥
  - *Windblade* → Swift Cloud Trails 🌬️
- **Lightning Flashes:** Certain swords like *Thunderstrike* cause real in-game lightning ⚡
- **Global Announcements:** When a sword is crafted, everyone gets notified — but without revealing who made it 😉

---

### 🔥 Sword Abilities  
Activate with **F** or your off-hand key (configurable)!  
Each sword has a **unique ability**, including:

- 🌌 *Skyfall Blade*: Launch into the air & create an explosion  
- 🐉 *Dragon's Wrath*: Dragon breath attack  
- 🗡️ *Shadowbane*: Apply weakness & blindness to nearby enemies  
- ⚡ *Thunderstrike*: Call down thunder  
- ☠️ *Venom Edge*: Poison your foes  
- 🌘 *Eclipse Blade*: Blind others & turn invisible (persists across item switches!)  
- ❤️ *Soul Reaver*: Heal by absorbing souls  
- 🔥 *Phoenix Talon*: Shoot fireballs  
- 🔊 *Warden's Oath*: Sonic boom explosion  
- 🌪️ *Windblade*: Dash forward with the force of a storm  
- 💪 *Power House Sword*: Ground slam & send enemies flying with sheer force!

---

### 🌟 **Continuous Sword Effects**
When certain swords are held in your hand, you gain special passive effects:

- 🔥 **Phoenix Talon**: Grants permanent Fire Resistance while the sword is held
- 🌪️ **Windblade**: Grants permanent Speed II while the sword is held

---

### 🧪 Crafting Recipes & GUI  
- 🌪️ **Windblade Recipe** available in-game!  
- 💪 **Power House Recipe** available in-game!  
- Use `/aswords craftable` or `/aswords recipes` to view all current recipes in a **clean GUI format**!

---

### 🧰 Admin & Player Commands  
- `/aswords recipes` – View available sword recipes  
- `/aswords give materials` – Admins can give custom items  
- `/aswords trigger` – Change your sword activation key!  
- `/aswords reload` – Reload the config without restarting
- `/aswords update check` - Check & install updates without having to go on Modrinth or Spigot!  
- `/aswords swordannouncements` - Enable or disable sword crafting announcements
- `/aswords craftable` - View which legendary blades are still unclaimed
- `/aswords announceplayername` - Enable or disable the announcing of names in sword crafting announcements

---

## ✅ **Fixes & Improvements in v1.2.13**  
- 🎯 **MAJOR: NBT-based sword identification** - Swords now detected by NBT tags, not display names — works even when renamed!
- ⚙️ **Unified configuration system** - Cleaner, more organized config management
- 🏗️ **Removed plugin instance dependencies** - Event listeners are now more stable and crash-resistant
- 📝 **Consistent branding** - All references updated to AstralSwords

### Previous Fixes Still Active:
- 🛡️ **Fixed NullPointerException crash** - No more server crashes during combat
- 🚨 **Fixed console spam** - Eliminated "Plugin cannot be null" errors
- 🌘 **Enhanced Eclipse Blade** - Invisibility persists when switching items
- ⏰ **Fixed Eclipse Blade timer exploit** - No more infinite invisibility
- 🌪️ **Windblade properly grants Speed II when held**
- 🔥 **Phoenix Talon properly removes Fire Resistance when dropped**

---

## 🔮 Coming Soon  
- 🔊 **Immersive Sword Sounds** (like dragon roars and thunder cracks)  
- 📦 **Custom Sound Pack** for even more immersive vibes!

---

## 🧠 How to Install  
1. Download **v1.2.13** from **Modrinth** or **Spigot**  
2. Drop the `.jar` file into your server's `plugins` folder  
3. Restart your server (recommended) or use `/reload`
4. **Enjoy bulletproof sword detection!** 🎯
5. Begin your legendary sword-forging journey! 🌌⚔️

**Requirements:** Paper 1.21+ (Java 21+ recommended)  
**⚠️ IMPORTANT:** Update to v1.2.13 for reliable sword detection even when swords are renamed!

---

## 🎯 **Why Update to v1.2.13?**
**If you've experienced issues with:**
- Swords not being recognized after renaming at an anvil
- Abilities not triggering on renamed swords
- Inconsistent sword detection

**v1.2.13 completely fixes this with NBT-based identification!** Your swords will always be recognized, no matter what you name them.

💬 **Got suggestions or found a bug?**  
Jump into **#『💡』suggestions** or **#『🐛』bug-reports** on **[Discord](https://discord.gg/snkKDmc89f)** and let me know!  
Let's keep making this plugin better — together!

**Happy crafting, legends!** 🗡️🔥🌠  

## ☕ Support Me on Ko-fi

If you like my work, consider buying me a coffee:

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/calastiotech)
