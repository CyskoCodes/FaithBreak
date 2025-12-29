# FaithBreak - Supported Languages Reference

## Quick Language Codes

| Code | Language | Native Name | Command |
|------|----------|-------------|---------|
| `en_US` | English | English | `/language en_US` |
| `ar_SA` | Arabic | العربية | `/language ar_SA` |
| `ur_PK` | Urdu | اردو | `/language ur_PK` |
| `es_ES` | Spanish | Español | `/language es_ES` |
| `fr_FR` | French | Français | `/language fr_FR` |
| `id_ID` | Indonesian | Bahasa Indonesia | `/language id_ID` |
| `hi_IN` | Hindi | हिन्दी | `/language hi_IN` |
| `de_DE` | German | Deutsch | `/language de_DE` |
| `pl_PL` | Polish | Polski | `/language pl_PL` |
| `nl_NL` | Dutch | Nederlands | `/language nl_NL` |

## Prayer Names by Language

### English (en_US)
- Fajr
- Dhuhr
- Asr
- Maghrib
- Isha

### Arabic (ar_SA)
- الفجر (Fajr)
- الظهر (Dhuhr)
- العصر (Asr)
- المغرب (Maghrib)
- العشاء (Isha)

### Urdu (ur_PK)
- فجر (Fajr)
- ظہر (Dhuhr)
- عصر (Asr)
- مغرب (Maghrib)
- عشاء (Isha)

### Spanish (es_ES)
- Fajr
- Dhuhr
- Asr
- Maghrib
- Isha

### French (fr_FR)
- Fajr
- Dhuhr
- Asr
- Maghrib
- Isha

### Indonesian (id_ID)
- Subuh (Fajr)
- Dzuhur (Dhuhr)
- Ashar (Asr)
- Maghrib (Maghrib)
- Isya (Isha)

### Hindi (hi_IN)
- फज्र (Fajr)
- ज़ुहर (Dhuhr)
- अस्र (Asr)
- मग़रिब (Maghrib)
- इशा (Isha)

### German (de_DE)
- Fadschr (Fajr)
- Zuhr (Dhuhr)
- Asr (Asr)
- Maghrib (Maghrib)
- Ischa (Isha)

### Polish (pl_PL)
- Fadżr (Fajr)
- Zuhr (Dhuhr)
- Asr (Asr)
- Maghrib (Maghrib)
- Isza (Isha)

### Dutch (nl_NL)
- Fajr
- Dhuhr
- Asr
- Maghrib
- Isha

## Sample Messages by Language

### Prayer Time Kick Message

**English:** "It's Fajr prayer time! Please take a break."

**Arabic:** "حان وقت صلاة الفجر! يرجى أخذ استراحة."

**Urdu:** "فجر نماز کا وقت ہے! براہ کرم وقفہ لیں۔"

**Spanish:** "¡Es hora de la oración Fajr! Por favor, toma un descanso."

**French:** "C'est l'heure de la prière Fajr! Veuillez prendre une pause."

**Indonesian:** "Ini waktu sholat Subuh! Silakan istirahat."

**Hindi:** "यह फज्र नमाज़ का समय है! कृपया विराम लें।"

**German:** "Es ist Fadschr Gebetszeit! Bitte mache eine Pause."

**Polish:** "To czas modlitwy Fadżr! Proszę zrobić przerwę."

**Dutch:** "Het is Fajr gebedstijd! Neem alsjeblieft een pauze."

### Opt-Out Message

**English:** "You have opted out of prayer time actions."

**Arabic:** "لقد اخترت عدم المشاركة في إجراءات وقت الصلاة."

**Urdu:** "آپ نے نماز کے وقت کی کارروائیوں سے آپٹ آؤٹ کر دیا ہے۔"

**Spanish:** "Has optado por no participar en las acciones de tiempo de oración."

**French:** "Vous avez choisi de ne pas participer aux actions de temps de prière."

**Indonesian:** "Anda telah memilih keluar dari tindakan waktu sholat."

**Hindi:** "आपने नमाज़ के समय की कार्रवाइयों से ऑप्ट आउट कर दिया है।"

**German:** "Du hast dich von Gebetszeitaktionen abgemeldet."

**Polish:** "Zrezygnowałeś z akcji związanych z czasem modlitwy."

**Dutch:** "Je hebt je afgemeld voor gebedstijd acties."

## Automatic Detection

The plugin automatically detects these Minecraft client locales:

| Minecraft Locale | Detected As | Language |
|-----------------|-------------|----------|
| `en_us` | `en_US` | English |
| `ar_sa` | `ar_SA` | Arabic |
| `ur_pk` | `ur_PK` | Urdu |
| `es_es` | `es_ES` | Spanish |
| `fr_fr` | `fr_FR` | French |
| `id_id` | `id_ID` | Indonesian |
| `hi_in` | `hi_IN` | Hindi |
| `de_de` | `de_DE` | German |
| `pl_pl` | `pl_PL` | Polish |
| `nl_nl` | `nl_NL` | Dutch |

Single-part locales (e.g., `en`, `ar`, `de`) are automatically mapped to their default country variant.

## Language Coverage

### Regions Covered
- **North America**: English
- **Europe**: English, Spanish, French, German, Polish, Dutch
- **Middle East**: Arabic
- **South Asia**: Urdu, Hindi
- **Southeast Asia**: Indonesian

### Muslim-Majority Countries
Languages spoken in Muslim-majority countries:
- Arabic (ar_SA) - Saudi Arabia, UAE, Egypt, etc.
- Urdu (ur_PK) - Pakistan
- Indonesian (id_ID) - Indonesia
- Turkish (coming soon)
- Malay (coming soon)
- Bengali (coming soon)
- Persian (coming soon)

## Commands Reference

### View Current Language
```
/language
/lang
```

### Change Language
```
/language <code>
/lang <code>
```

### Examples
```
/language ar_SA    # Switch to Arabic
/lang ur_PK        # Switch to Urdu (short form)
/language hi_IN    # Switch to Hindi
```

## File Locations

### Language Files
```
plugins/FaithBreak/messages/
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

### Player Preferences
```
plugins/FaithBreak/player_languages.yml
```

## Translation Status

| Language | Code | Status | Prayer Names | Messages | Commands |
|----------|------|--------|--------------|----------|----------|
| English | en_US | ✅ Complete | ✅ | ✅ | ✅ |
| Arabic | ar_SA | ✅ Complete | ✅ Localized | ✅ | ✅ |
| Urdu | ur_PK | ✅ Complete | ✅ Localized | ✅ | ✅ |
| Spanish | es_ES | ✅ Complete | ✅ | ✅ | ✅ |
| French | fr_FR | ✅ Complete | ✅ | ✅ | ✅ |
| Indonesian | id_ID | ✅ Complete | ✅ Localized | ✅ | ✅ |
| Hindi | hi_IN | ✅ Complete | ✅ Localized | ✅ | ✅ |
| German | de_DE | ✅ Complete | ✅ Localized | ✅ | ✅ |
| Polish | pl_PL | ✅ Complete | ✅ Localized | ✅ | ✅ |
| Dutch | nl_NL | ✅ Complete | ✅ | ✅ | ✅ |

## Contributing Translations

Want to add a new language or improve existing translations?

1. Copy `messages/en_US.yml` to `messages/<your_language_code>.yml`
2. Translate all messages
3. Keep color codes (`§a`, `§c`) and placeholders (`%s`)
4. Test in-game
5. Submit a pull request or send to server admin

### Requested Languages
- Turkish (tr_TR)
- Malay (ms_MY)
- Bengali (bn_BD)
- Persian (fa_IR)
- Russian (ru_RU)
- Italian (it_IT)
- Portuguese (pt_BR)

## Support

For language-related issues:
- Check if your client language is supported
- Use `/language` to manually select a language
- Report translation errors to server admin
- Suggest new languages or improvements

---

**Total Languages Supported: 10**

**Last Updated:** November 1, 2025
