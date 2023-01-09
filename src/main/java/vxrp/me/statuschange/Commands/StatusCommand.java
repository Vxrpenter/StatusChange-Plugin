package vxrp.me.statuschange.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import vxrp.me.statuschange.Statuschange;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StatusCommand implements CommandExecutor {
    private final Statuschange plugin;

    public StatusCommand(Statuschange plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playername = player.getName();
            String language = plugin.getConfig().getString("language");
            String EnglishStatusChangeMessage = plugin.getConfig().getString("English_StatusChangeMessage");
            String GermanStatusChangeMessage = plugin.getConfig().getString("German_StatusChangeMessage");
            String ErrorCode = plugin.getConfig().getString("ErrorCode");
            String English_ErrorMessage = plugin.getConfig().getString("English_ErrorMessage");
            String German_ErrorMessage = plugin.getConfig().getString("German_ErrorMessage");
            List bannedwords = plugin.getConfig().getList("Banned-Words");
            String English_wordfilter_message = plugin.getConfig().getString("English_wordfilter_message");
            String German_wordfilter_message = plugin.getConfig().getString("German_wordfilter_message");
            String FlagCode = plugin.getConfig().getString("FlagCode");
            String WarningCode = plugin.getConfig().getString("WarningCode");


            if (language.equals("English")) {
                if (args.length == 0) {
                    if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                        player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + English_ErrorMessage);
                        player.sendMessage(ChatColor.GRAY + " -  SuffixList: [Rec] [Live] [Afk] [clear]");
                    } else {
                        player.setDisplayName(playername);
                        player.setPlayerListName(playername);
                        player.sendMessage(ChatColor.GRAY + "Your Status was reset");
                    }
                } else {
                    if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                        if (args[0].matches("Rec|Afk|clear|Live")) {
                            if (args[0].equals("Rec")) {
                                player.sendMessage(ChatColor.GRAY + EnglishStatusChangeMessage + ChatColor.RED + " Rec");
                                player.setDisplayName(playername + ChatColor.GRAY + " [" + ChatColor.RED + "Rec" + ChatColor.GRAY + "]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [" + ChatColor.RED + "Rec" + ChatColor.GRAY + "]");
                            }

                            if (args[0].equals("Live")) {
                                player.sendMessage(ChatColor.GRAY + EnglishStatusChangeMessage + ChatColor.DARK_PURPLE + " Live");
                                player.setDisplayName(playername + ChatColor.GRAY + " [" + ChatColor.DARK_PURPLE + "LIVE" + ChatColor.GRAY + "]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [" + ChatColor.DARK_PURPLE + "LIVE" + ChatColor.GRAY + "]");
                            }

                            if (args[0].equals("Afk")) {
                                player.sendMessage(ChatColor.GRAY + EnglishStatusChangeMessage + ChatColor.GRAY + " Afk");
                                player.setDisplayName(playername + ChatColor.GRAY + " [AFK]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [AFK]");
                            }

                            if (args[0].equals("clear")) {
                                player.setDisplayName(playername);
                                player.setPlayerListName(playername);
                            }
                        }else {
                            if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                                player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + English_ErrorMessage);
                                player.sendMessage(ChatColor.GRAY + " -  SuffixList: [Rec] [Live] [Afk] [clear]");
                            } else {
                                player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + plugin.getConfig().getString("English_Custom_StatusErrorMessage"));
                            }
                        }
                    } else{
                        if (args[0].length() > 0) {
                            player.sendMessage(EnglishStatusChangeMessage + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                            player.setDisplayName(playername + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                            player.setPlayerListName(playername + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                        }
                    }
                }
            }

            if (language.equals("German")) {
                if (args.length == 0) {
                    if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                        player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + German_ErrorMessage);
                        player.sendMessage(ChatColor.GRAY + " -  SuffixListe: [Rec] [Live] [Afk] [clear]");
                    } else {
                        player.setDisplayName(playername);
                        player.setPlayerListName(playername);
                        player.sendMessage(ChatColor.GRAY + "Your Status was reset");
                    }
                } else {
                    if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                        if (args[0].matches("Rec|Afk|clear|Live")) {
                            if (args[0].equals("Rec")) {
                                player.sendMessage(ChatColor.GRAY + GermanStatusChangeMessage + ChatColor.RED + " Rec");
                                player.setDisplayName(playername + ChatColor.GRAY + " [" + ChatColor.RED + "Rec" + ChatColor.GRAY + "]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [" + ChatColor.RED + "Rec" + ChatColor.GRAY + "]");
                            }

                            if (args[0].equals("Live")) {
                                player.sendMessage(ChatColor.GRAY + GermanStatusChangeMessage + ChatColor.DARK_PURPLE + " Live");
                                player.setDisplayName(playername + ChatColor.GRAY + " [" + ChatColor.DARK_PURPLE + "LIVE" + ChatColor.GRAY + "]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [" + ChatColor.DARK_PURPLE + "LIVE" + ChatColor.GRAY + "]");
                            }

                            if (args[0].equals("Afk")) {
                                player.sendMessage(ChatColor.GRAY + GermanStatusChangeMessage + ChatColor.GRAY + " Afk");
                                player.setDisplayName(playername + ChatColor.GRAY + " [AFK]");
                                player.setPlayerListName(playername + ChatColor.GRAY + " [AFK]");
                            }

                            if (args[0].equals("clear")) {
                                player.setDisplayName(playername);
                                player.setPlayerListName(playername);
                            }
                        }else {
                            if (plugin.getConfig().getString("Custom_Status").equals("off")) {
                                player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + German_ErrorMessage);
                                player.sendMessage(ChatColor.GRAY + " -  SuffixListe: [Rec] [Live] [Afk] [clear]");
                            } else {
                                player.sendMessage(ChatColor.RED + ErrorCode + ChatColor.GRAY + plugin.getConfig().getString("German_Custom_StatusErrorMessage"));
                            }
                        }
                    } else {
                        if (args[0].length() > 0) {
                            player.sendMessage(GermanStatusChangeMessage + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                            player.setDisplayName(playername + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                            player.setPlayerListName(playername + ChatColor.GRAY + " [" +ChatColor.translateAlternateColorCodes('&', args[0]) + ChatColor.GRAY + "]");
                        }
                    }
                }
            }

            }else {
            Player player = (Player) sender;

            player.sendMessage(ChatColor.RED + "You are not a Player");
        }
        return true;
    }
}
