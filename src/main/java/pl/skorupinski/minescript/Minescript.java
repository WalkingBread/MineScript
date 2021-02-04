package pl.skorupinski.minescript;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.mozilla.javascript.Scriptable;
import pl.skorupinski.minescript.commands.CloseScopeCommandExecutor;
import pl.skorupinski.minescript.commands.CommandHandler;
import pl.skorupinski.minescript.commands.CreateScopeCommandExecutor;
import pl.skorupinski.minescript.commands.ExecScriptCommandExecutor;
import pl.skorupinski.minescript.engine.ScriptEngine;

import java.io.InputStream;
import java.util.HashMap;

public class Minescript extends JavaPlugin {
    private CommandHandler handler;
    private ScriptEngine engine;

    public HashMap<CommandSender, Scriptable> scopes;

    @Override
    public void onEnable() {
        handler = new CommandHandler(this);
        engine = new ScriptEngine();

        scopes = new HashMap<>();

        registerCommands();

        getLogger().info("MineScript enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("MineScript disabled.");
    }

    private void registerCommands() {
        handler.addCommand("js", new ExecScriptCommandExecutor());
        handler.addCommand("openscope", new CreateScopeCommandExecutor());
        handler.addCommand("closescope", new CloseScopeCommandExecutor());
    }

    private void loadScript(String path, Scriptable scope) {
        InputStream in = getClass().getResourceAsStream(path);
        engine.execFile(in, scope);
    }

    private void loadDefaultScripts(Scriptable scope) {
        loadScript("lib/langutils.js", scope);
        loadScript("lib/pluginutils.js", scope);
    }

    public Scriptable createScope(CommandSender sender) {
        Scriptable scope = engine.getContext().initStandardObjects();
        loadDefaultScripts(scope);

        return scope;
    }

    public ScriptEngine getScriptEngine() {
        return engine;
    }
}
