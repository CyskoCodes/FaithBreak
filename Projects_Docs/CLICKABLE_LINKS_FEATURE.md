# Clickable "Learn More" Button Feature

## Overview

When players are kicked for prayer time, they now see a clickable **"Learn More"** button that opens the FaithBreak Modrinth page in their browser.

## How It Works

### For Players

When kicked for prayer time, players will see:

```
It's Fajr prayer time! Please take a break.
You can rejoin in 12 minutes.

[Learn More]
```

The `[Learn More]` button is:
- **Gold colored** and **bold** for visibility
- **Clickable** - opens https://modrinth.com/plugin/faithbreak
- **Localized** - appears in the player's language

### Localized Button Text

The "Learn More" button appears in each player's language:

| Language | Button Text |
|----------|-------------|
| English | Learn More |
| Arabic | معرفة المزيد |
| Urdu | مزید جانیں |
| Spanish | Más información |
| French | En savoir plus |
| Indonesian | Pelajari Lebih Lanjut |
| Hindi | और जानें |
| German | Mehr erfahren |
| Polish | Dowiedz się więcej |
| Dutch | Meer informatie |

## Technical Implementation

### Adventure API Components

The kick message uses Minecraft's Adventure API to create rich text with click events:

```java
Component learnMoreButton = Component.text("[" + learnMoreText + "]")
    .color(NamedTextColor.GOLD)
    .decorate(TextDecoration.BOLD)
    .clickEvent(ClickEvent.openUrl("https://modrinth.com/plugin/faithbreak"));
```

### Where It Appears

The clickable button appears in:
1. **PlayerJoinEvent** - When a kicked player tries to rejoin too early
2. **PlayerLoginEvent** - When a kicked player tries to login too early

### Message Structure

```
[Prayer kick message]
[Rejoin warning with time]

[Clickable Learn More Button]
```

## Benefits

### For Players
- **Easy access** to plugin information
- **Understand the plugin** better
- **Learn about features** like `/non-muslim` command
- **See updates** and changelogs

### For Server Admins
- **Reduced support questions** - players can self-educate
- **Better player experience** - transparent about plugin functionality
- **Professional appearance** - modern clickable UI elements

## Customization

### Change the URL

To change the link destination, edit `FaithBreak.java`:

```java
.clickEvent(ClickEvent.openUrl("https://your-custom-url.com"));
```

### Change Button Appearance

Modify the button styling in `createKickMessageWithLink()`:

```java
Component learnMoreButton = Component.text("[" + learnMoreText + "]")
    .color(NamedTextColor.AQUA)        // Change color
    .decorate(TextDecoration.UNDERLINED) // Change decoration
    .clickEvent(ClickEvent.openUrl("..."));
```

Available colors:
- `NamedTextColor.GOLD` (current)
- `NamedTextColor.AQUA`
- `NamedTextColor.GREEN`
- `NamedTextColor.YELLOW`
- `NamedTextColor.RED`

Available decorations:
- `TextDecoration.BOLD` (current)
- `TextDecoration.UNDERLINED`
- `TextDecoration.ITALIC`

### Translate Button Text

The button text is stored in language files under `prayer.learn_more`:

```yaml
# messages/en_US.yml
prayer:
  learn_more: "Learn More"
```

To add a new language or change existing text, edit the appropriate language file.

## Player Experience

### Desktop Players
1. See kick message with gold button
2. Click the `[Learn More]` button
3. Browser opens to Modrinth page
4. Read about plugin features
5. Return to game after prayer time

### Mobile/Bedrock Players
- Button may not be clickable on all platforms
- Text still visible as informational element
- Can manually visit the URL if needed

## Security

### URL Validation
- The URL is hardcoded in the plugin
- Cannot be changed by players
- Safe from injection attacks
- Opens in player's default browser

### Privacy
- No tracking or analytics
- Direct link to Modrinth
- No data collection
- Player's choice to click

## Troubleshooting

### Button Not Clickable
- **Cause**: Some clients don't support click events
- **Solution**: Player can manually type the URL

### Wrong Language
- **Cause**: Player's language not detected correctly
- **Solution**: Use `/language <code>` to set manually

### Link Doesn't Open
- **Cause**: Browser not configured or client limitation
- **Solution**: Copy URL manually from Modrinth

## Future Enhancements

Possible improvements:
- Add hover text with more information
- Multiple buttons (Discord, Wiki, Support)
- Configurable URL in config.yml
- Different links per language/region
- Statistics tracking (opt-in)

## Code Reference

### Main Method
```java
private Component createKickMessageWithLink(Player player, String prayerName, long remainingMinutes)
```

### Location
`src/main/java/com/faithBreak/FaithBreak.java`

### Dependencies
- Adventure API (included in Paper/Spigot)
- LanguageManager for translations

## Testing

To test the feature:
1. Get kicked for prayer time
2. Try to rejoin immediately
3. See kick message with button
4. Click `[Learn More]`
5. Verify Modrinth page opens

## Compatibility

- **Minecraft Version**: 1.16+
- **Server Software**: Paper, Spigot, Purpur
- **Client Support**: Java Edition (full), Bedrock (limited)

---

**Feature Added:** November 1, 2025
**Version:** 1.2.1+
