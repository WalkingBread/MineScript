package pl.skorupinski.minescript.commands;

import org.bukkit.command.CommandSender;
import pl.skorupinski.minescript.Minescript;

public class CommandlineScriptExecutor implements Executor {

    @Override
    public void execute(Minescript plugin, CommandSender sender, String[] args) {
        String script = "";
        for(String arg : args) {
            script += arg + " ";
        }

        String result = plugin.engine.exec_script(script);
        sender.sendMessage(result);
    }
}
