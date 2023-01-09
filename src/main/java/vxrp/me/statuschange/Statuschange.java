package vxrp.me.statuschange;

import org.bukkit.plugin.java.JavaPlugin;
import vxrp.me.statuschange.TabCompletion.StatusChangeTabCompletion;
import vxrp.me.statuschange.Commands.StatusCommand;

import java.io.File;

public final class Statuschange extends JavaPlugin {

    public static  Statuschange plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic

        this.Config();

        getCommand("status").setExecutor(new StatusCommand(this));
        if (getConfig().getString("CustomStatus") == "off") {
            getCommand("status").setTabCompleter(new StatusChangeTabCompletion());
        } else {
        }
    }


    public void Config() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
