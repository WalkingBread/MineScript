package pl.skorupinski.minescript.commands;

import org.bukkit.command.CommandSender;
import org.mozilla.javascript.Scriptable;
import pl.skorupinski.minescript.Minescript;

public class ExecScriptCommandExecutor implements Executor {

    @Override
    public void execute(Minescript plugin, CommandSender sender, String[] args) {
        if(plugin.scopes.containsKey(sender)) {
            Scriptable scope = plugin.scopes.get(sender);

            String script = "";
            for(String arg : args) {
                script += arg + " ";
            }

            String result = plugin.getScriptEngine().execScript(script, scope);
            sender.sendMessage(result);
        } else {
            sender.sendMessage("You must create a scope first.");
        }
    }
}
