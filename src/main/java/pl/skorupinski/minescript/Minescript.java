package pl.skorupinski.minescript;

import org.bukkit.plugin.java.JavaPlugin;
import pl.skorupinski.minescript.commands.CommandHandler;
import pl.skorupinski.minescript.commands.CommandlineScriptExecutor;
import pl.skorupinski.minescript.engine.ScriptEngine;

import java.io.InputStream;

public class Minescript extends JavaPlugin {
    private CommandHandler handler;
    public ScriptEngine engine;

    @Override
    public void onEnable() {
        handler = new CommandHandler(this);
        engine = new ScriptEngine();

        register_commands();
        load_scripts();

        getLogger().info("MineScript enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("MineScript plugin disabled.");
    }

    private void register_commands() {
        handler.add_command("js", new CommandlineScriptExecutor());
    }

    private void load_scripts() {
        InputStream in = getClass().getResourceAsStream("lib/utils.js");
        engine.exec_file(in);
    }
}
