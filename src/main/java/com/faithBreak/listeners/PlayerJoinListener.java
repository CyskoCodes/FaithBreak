package com.faithBreak.listeners;

import com.faithBreak.FaithBreak;
import com.faithBreak.i18n.LanguageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {
    private final FaithBreak plugin;
    private final LanguageManager languageManager;

    public PlayerJoinListener(FaithBreak plugin, LanguageManager languageManager) {
        this.plugin = plugin;
        this.languageManager = languageManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        // Detect and set player language
        new BukkitRunnable() {
            @Override
            public void run() {
                detectAndSetLanguage(player);
            }
        }.runTaskLater(plugin, 40L); // 2 seconds delay to avoid join spam
    }

    private void detectAndSetLanguage(Player player) {
        try {
            // Get player's client locale
            String clientLocale = player.locale().toString();
            String languageCode = convertLocaleToLanguageCode(clientLocale);

            // Check if this language is supported
            if (languageManager.getAvailableLanguages().contains(languageCode)) {
                String currentLanguage = languageManager.getPlayerLanguage(player.getUniqueId());
                
                // Only update if different from current
                if (!currentLanguage.equals(languageCode)) {
                    languageManager.setPlayerLanguage(player.getUniqueId(), languageCode);
                    
                    // Notify player
                    String languageName = languageManager.getLanguageName(languageCode);
                    String message = languageManager.getMessage(player, "general.language_detected", languageName);
                    player.sendMessage(message);
                }
            }
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to detect language for player: " + player.getName());
        }
    }

    private String convertLocaleToLanguageCode(String locale) {
        // Convert Minecraft locale format to our format
        // Examples: "en_us" -> "en_US", "ar_sa" -> "ar_SA"
        String[] parts = locale.toLowerCase().split("_");
        
        if (parts.length == 2) {
            return parts[0].toLowerCase() + "_" + parts[1].toUpperCase();
        } else if (parts.length == 1) {
            // Single part locale, map to default country
            String lang = parts[0].toLowerCase();
            switch (lang) {
                case "en": return "en_US";
                case "ar": return "ar_SA";
                case "ur": return "ur_PK";
                case "es": return "es_ES";
                case "fr": return "fr_FR";
                case "id": return "id_ID";
                case "hi": return "hi_IN";
                case "de": return "de_DE";
                case "pl": return "pl_PL";
                case "nl": return "nl_NL";
                default: return "en_US";
            }
        }
        
        return "en_US"; // Default fallback
    }
}
