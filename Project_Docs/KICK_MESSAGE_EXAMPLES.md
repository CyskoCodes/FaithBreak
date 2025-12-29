# Kick Message Examples with "Learn More" Button

## Visual Examples

### English Player
```
§cIt's Fajr prayer time! Please take a break.
§cYou can rejoin in 12 minutes.

§6§l[Learn More]
```
*Clicking the gold button opens: https://modrinth.com/plugin/faithbreak*

---

### Arabic Player
```
§cحان وقت صلاة الفجر! يرجى أخذ استراحة.
§cيمكنك العودة بعد 12 دقيقة.

§6§l[معرفة المزيد]
```
*النقر على الزر الذهبي يفتح صفحة Modrinth*

---

### Urdu Player
```
§cفجر نماز کا وقت ہے! براہ کرم وقفہ لیں۔
§cآپ 12 منٹ میں دوبارہ شامل ہو سکتے ہیں۔

§6§l[مزید جانیں]
```
*سنہری بٹن پر کلک کرنے سے Modrinth صفحہ کھلتا ہے*

---

### Spanish Player
```
§c¡Es hora de la oración Fajr! Por favor, toma un descanso.
§cPuedes volver a unirte en 12 minutos.

§6§l[Más información]
```
*Al hacer clic en el botón dorado se abre la página de Modrinth*

---

### French Player
```
§cC'est l'heure de la prière Fajr! Veuillez prendre une pause.
§cVous pouvez vous reconnecter dans 12 minutes.

§6§l[En savoir plus]
```
*Cliquer sur le bouton doré ouvre la page Modrinth*

---

### Indonesian Player
```
§cIni waktu sholat Subuh! Silakan istirahat.
§cAnda dapat bergabung kembali dalam 12 menit.

§6§l[Pelajari Lebih Lanjut]
```
*Mengklik tombol emas membuka halaman Modrinth*

---

### Hindi Player
```
§cयह फज्र नमाज़ का समय है! कृपया विराम लें।
§cआप 12 मिनट में फिर से शामिल हो सकते हैं।

§6§l[और जानें]
```
*सुनहरे बटन पर क्लिक करने से Modrinth पेज खुलता है*

---

### German Player
```
§cEs ist Fadschr Gebetszeit! Bitte mache eine Pause.
§cDu kannst in 12 Minuten wieder beitreten.

§6§l[Mehr erfahren]
```
*Durch Klicken auf die goldene Schaltfläche wird die Modrinth-Seite geöffnet*

---

### Polish Player
```
§cTo czas modlitwy Fadżr! Proszę zrobić przerwę.
§cMożesz dołączyć ponownie za 12 minut.

§6§l[Dowiedz się więcej]
```
*Kliknięcie złotego przycisku otwiera stronę Modrinth*

---

### Dutch Player
```
§cHet is Fajr gebedstijd! Neem alsjeblieft een pauze.
§cJe kunt over 12 minuten weer deelnemen.

§6§l[Meer informatie]
```
*Door op de gouden knop te klikken, wordt de Modrinth-pagina geopend*

---

## Color Code Legend

- `§c` = Red (for important messages)
- `§6` = Gold (for the button)
- `§l` = Bold (for emphasis)
- `§e` = Yellow (for reminders)

## Button Behavior

### On Click
1. Player's default web browser opens
2. Navigates to: https://modrinth.com/plugin/faithbreak
3. Player can read about:
   - Plugin features
   - How to opt-out with `/non-muslim`
   - Language support
   - Updates and changelog
   - Support information

### Visual Appearance
- **Color**: Bright gold (§6)
- **Style**: Bold (§l)
- **Format**: `[Text]` with brackets
- **Hover**: May show tooltip (client-dependent)

## Different Prayer Times

The message adapts to show the current prayer:

### Fajr (Dawn)
```
It's Fajr prayer time! Please take a break.
```

### Dhuhr (Noon)
```
It's Dhuhr prayer time! Please take a break.
```

### Asr (Afternoon)
```
It's Asr prayer time! Please take a break.
```

### Maghrib (Sunset)
```
It's Maghrib prayer time! Please take a break.
```

### Isha (Night)
```
It's Isha prayer time! Please take a break.
```

## Time Remaining

The message shows how long until the player can rejoin:

```
You can rejoin in 12 minutes.  (just kicked)
You can rejoin in 8 minutes.   (4 minutes later)
You can rejoin in 3 minutes.   (9 minutes later)
You can rejoin in 1 minutes.   (11 minutes later)
```

After 12 minutes, the player can rejoin without seeing this message.

## What Players Learn

By clicking "Learn More", players discover:

### Plugin Purpose
- Encourages prayer breaks for Muslim players
- Respects religious obligations
- Promotes healthy gaming habits

### How to Opt-Out
- Use `/non-muslim` command
- Receive reminders instead of kicks
- Voluntary participation

### Language Support
- 10 languages available
- Automatic detection
- Manual switching with `/language`

### Server Information
- Plugin is open source
- Available on Modrinth
- Community-driven development

## Accessibility

### For All Players
- Clear, concise messaging
- Localized in player's language
- Visual emphasis with colors
- Clickable for more info

### For Non-Muslim Players
- Easy opt-out option
- Respectful communication
- No forced participation

### For Server Admins
- Reduces support tickets
- Self-service information
- Professional appearance

## Testing the Feature

### As a Player
1. Wait for prayer time (or ask admin to test)
2. Get kicked from server
3. Try to rejoin immediately
4. See the kick message with button
5. Click `[Learn More]`
6. Browser opens to Modrinth page

### As an Admin
1. Use `/time set` to trigger prayer time
2. Kick a test player
3. Have them try to rejoin
4. Verify message appears correctly
5. Test button click functionality
6. Check different languages

## Comparison: Before vs After

### Before (Plain Text)
```
It's Fajr prayer time! Please take a break.
You can rejoin in 12 minutes.
```
- No additional information
- Players confused about plugin
- More support questions

### After (With Button)
```
It's Fajr prayer time! Please take a break.
You can rejoin in 12 minutes.

[Learn More]
```
- Self-service information
- Professional appearance
- Reduced confusion
- Better player experience

---

**Note**: The actual appearance may vary slightly depending on the Minecraft client and version, but the functionality remains consistent across supported platforms.
