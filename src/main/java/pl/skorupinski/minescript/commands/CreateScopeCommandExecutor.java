package pl.skorupinski.minescript.commands;

import org.bukkit.command.CommandSender;
import org.mozilla.javascript.Scriptable;
import pl.skorupinski.minescript.Minescript;

public class CreateScopeCommandExecutor implements Executor{
    @Override
    public void execute(Minescript plugin, CommandSender sender, String[] args) {
        if(!plugin.scopes.containsKey(sender)) {
            Scriptable scope = plugin.createScope(sender);
            plugin.scopes.put(sender, scope);

            sender.sendMessage("Scope has been created.");
        } else {
            sender.sendMessage("You already have an open scope.");
        }
    }
}
