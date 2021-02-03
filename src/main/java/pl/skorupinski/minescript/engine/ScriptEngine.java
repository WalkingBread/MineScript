package pl.skorupinski.minescript.engine;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.*;

public class ScriptEngine {
    public Context ctx;
    public Scriptable scope;

    public ScriptEngine() {
        ctx = Context.enter();
        scope = ctx.initStandardObjects();
    }

    public String exec_script(String script) {
        Object output = ctx.evaluateString(scope, script, "", 1, null);

        return Context.toString(output);
    }

    public String exec_file(InputStream in) {
        Object output = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            output = ctx.evaluateReader(scope, reader, "test", 1, null);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Context.toString(output);
    }
}
