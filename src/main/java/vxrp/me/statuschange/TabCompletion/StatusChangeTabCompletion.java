package vxrp.me.statuschange.TabCompletion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StatusChangeTabCompletion implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("Rec");
            arguments.add("Live");
            arguments.add("Afk");
            arguments.add("clear");

            return arguments;
        }

        return null;
    }
}
