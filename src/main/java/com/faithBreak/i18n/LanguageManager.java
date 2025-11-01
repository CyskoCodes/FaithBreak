package com.faithBreak.i18n;

import com.faithBreak.FaithBreak;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

public class LanguageManager {
    private final FaithBreak plugin;
    private final Map<UUID, String> playerLanguages = new ConcurrentHashMap<>();
    private final Map<String, YamlConfiguration> languageConfigs = new HashMap<>();
    private final String defaultLanguage = "en_US";
    private File playerLanguagesFile;

    public LanguageManager(FaithBreak plugin) {
        this.plugin = plugin;
        initialize();
    }

    private void initialize() {
        // Create messages directory
        File messagesDir = new File(plugin.getDataFolder(), "messages");
        if (!messagesDir.exists()) {
            messagesDir.mkdirs();
        }

        // Create player languages file
        playerLanguagesFile = new File(plugin.getDataFolder(), "player_languages.yml");
        if (!playerLanguagesFile.exists()) {
            try {
                playerLanguagesFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().log(Level.SEVERE, "Failed to create player_languages.yml", e);
            }
        }

        // Copy default language files from resources
        copyLanguageFile("en_US.yml");
        copyLanguageFile("ar_SA.yml");
        copyLanguageFile("ur_PK.yml");
        copyLanguageFile("es_ES.yml");
        copyLanguageFile("fr_FR.yml");
        copyLanguageFile("id_ID.yml");
        copyLanguageFile("hi_IN.yml");
        copyLanguageFile("de_DE.yml");
        copyLanguageFile("pl_PL.yml");
        copyLanguageFile("nl_NL.yml");

        // Load all language files
        loadLanguageFiles();

        // Load player language preferences
        loadPlayerLanguages();
    }

    private void copyLanguageFile(String fileName) {
        File file = new File(plugin.getDataFolder(), "messages/" + fileName);
        if (!file.exists()) {
            try (InputStream in = plugin.getResource("messages/" + fileName)) {
                if (in != null) {
                    Files.copy(in, file.toPath());
                    plugin.getLogger().info("Created language file: " + fileName);
                }
            } catch (IOException e) {
                plugin.getLogger().log(Level.WARNING, "Failed to copy language file: " + fileName, e);
            }
        }
    }

    private void loadLanguageFiles() {
        File messagesDir = new File(plugin.getDataFolder(), "messages");
        File[] files = messagesDir.listFiles((dir, name) -> name.endsWith(".yml"));

        if (files != null) {
            for (File file : files) {
                String langCode = file.getName().replace(".yml", "");
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                languageConfigs.put(langCode, config);
                plugin.getLogger().info("Loaded language: " + langCode);
            }
        }

        // Ensure default language is loaded
        if (!languageConfigs.containsKey(defaultLanguage)) {
            plugin.getLogger().warning("Default language " + defaultLanguage + " not found!");
        }
    }

    private void loadPlayerLanguages() {
        if (!playerLanguagesFile.exists()) {
            return;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerLanguagesFile);
        for (String key : config.getKeys(false)) {
            try {
                UUID playerId = UUID.fromString(key);
                String language = config.getString(key);
                if (language != null && languageConfigs.containsKey(language)) {
                    playerLanguages.put(playerId, language);
                }
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid UUID in player_languages.yml: " + key);
            }
        }
    }

    private void savePlayerLanguages() {
        YamlConfiguration config = new YamlConfiguration();
        for (Map.Entry<UUID, String> entry : playerLanguages.entrySet()) {
            config.set(entry.getKey().toString(), entry.getValue());
        }

        try {
            config.save(playerLanguagesFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Failed to save player_languages.yml", e);
        }
    }

    public String getPlayerLanguage(UUID playerId) {
        return playerLanguages.getOrDefault(playerId, defaultLanguage);
    }

    public void setPlayerLanguage(UUID playerId, String languageCode) {
        if (!languageConfigs.containsKey(languageCode)) {
            return;
        }
        playerLanguages.put(playerId, languageCode);
        savePlayerLanguages();
    }

    public String getMessage(Player player, String key, Object... args) {
        String language = getPlayerLanguage(player.getUniqueId());
        YamlConfiguration config = languageConfigs.get(language);

        String message = null;
        if (config != null) {
            message = config.getString(key);
        }

        // Fallback to default language
        if (message == null && !language.equals(defaultLanguage)) {
            config = languageConfigs.get(defaultLanguage);
            if (config != null) {
                message = config.getString(key);
            }
        }

        // Last resort: return key
        if (message == null) {
            return key;
        }

        // Apply formatting
        if (args.length > 0) {
            try {
                message = String.format(message, args);
            } catch (IllegalFormatException e) {
                plugin.getLogger().warning("Invalid format for key: " + key);
            }
        }

        return message;
    }

    public List<String> getMessageList(Player player, String key) {
        String language = getPlayerLanguage(player.getUniqueId());
        YamlConfiguration config = languageConfigs.get(language);

        List<String> messages = null;
        if (config != null) {
            messages = config.getStringList(key);
        }

        // Fallback to default language
        if ((messages == null || messages.isEmpty()) && !language.equals(defaultLanguage)) {
            config = languageConfigs.get(defaultLanguage);
            if (config != null) {
                messages = config.getStringList(key);
            }
        }

        return messages != null ? messages : Collections.emptyList();
    }

    public Set<String> getAvailableLanguages() {
        return languageConfigs.keySet();
    }

    public String getLanguageName(String languageCode) {
        YamlConfiguration config = languageConfigs.get(languageCode);
        if (config != null) {
            return config.getString("language.name", languageCode);
        }
        return languageCode;
    }

    public void reload() {
        languageConfigs.clear();
        playerLanguages.clear();
        initialize();
    }
}
