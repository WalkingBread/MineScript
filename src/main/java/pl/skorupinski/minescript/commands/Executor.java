package pl.skorupinski.minescript.commands;

import org.bukkit.command.CommandSender;
import pl.skorupinski.minescript.Minescript;

public interface Executor {

    public void execute(Minescript plugin, CommandSender sender, String[] args);
}
