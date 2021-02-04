package pl.skorupinski.minescript.commands;

import org.bukkit.command.CommandSender;
import pl.skorupinski.minescript.Minescript;

public class CloseScopeCommandExecutor implements Executor {
    @Override
    public void execute(Minescript plugin, CommandSender sender, String[] args) {
        if(plugin.scopes.containsKey(sender)) {
            plugin.scopes.remove(sender);

            sender.sendMessage("Scope has been closed.");
        } else {
            sender.sendMessage("You have no open scopes.");
        }
    }
}
