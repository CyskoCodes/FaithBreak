package com.faithBreak.commands;

import com.faithBreak.FaithBreak;
import com.faithBreak.i18n.LanguageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageCommand implements CommandExecutor, TabCompleter {
    private final LanguageManager languageManager;

    public LanguageCommand(FaithBreak plugin, LanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            // Show current language and available languages
            String currentLang = languageManager.getPlayerLanguage(player.getUniqueId());
            String currentLangName = languageManager.getLanguageName(currentLang);
            
            player.sendMessage(languageManager.getMessage(player, "commands.language.current", currentLangName));
            player.sendMessage(languageManager.getMessage(player, "commands.language.available"));
            
            for (String langCode : languageManager.getAvailableLanguages()) {
                String langName = languageManager.getLanguageName(langCode);
                player.sendMessage("§7- §e" + langCode + " §7(" + langName + ")");
            }
            
            return true;
        }

        // Change language
        String newLanguage = args[0];
        
        // Try case-insensitive match
        String matchedLanguage = null;
        for (String langCode : languageManager.getAvailableLanguages()) {
            if (langCode.equalsIgnoreCase(newLanguage)) {
                matchedLanguage = langCode;
                break;
            }
        }

        if (matchedLanguage == null) {
            player.sendMessage(languageManager.getMessage(player, "commands.language.invalid", newLanguage));
            return true;
        }

        // Set new language
        languageManager.setPlayerLanguage(player.getUniqueId(), matchedLanguage);
        
        // Send confirmation in NEW language
        String langName = languageManager.getLanguageName(matchedLanguage);
        player.sendMessage(languageManager.getMessage(player, "commands.language.changed", langName));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            String partial = args[0].toLowerCase();
            return languageManager.getAvailableLanguages().stream()
                    .filter(lang -> lang.toLowerCase().startsWith(partial))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
