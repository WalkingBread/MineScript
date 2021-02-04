package pl.skorupinski.minescript.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.skorupinski.minescript.Minescript;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor {

    private Minescript plugin;
    private HashMap<String, Executor> commands;

    public CommandHandler(Minescript plugin) {
        this.plugin = plugin;
        commands = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String command_name = command.getName();
        Executor command_executor = commands.get(command_name);

        if(command_executor != null) {
            command_executor.execute(plugin, sender, args);
        }

        return false;
    }

    public void addCommand(String command_name, Executor executor) {
        commands.put(command_name, executor);
        plugin.getCommand(command_name).setExecutor(this);
    }
}
