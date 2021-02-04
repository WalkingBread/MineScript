package pl.skorupinski.minescript.engine;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ScriptEngine {
    private Context ctx;

    public ScriptEngine() {
        ctx = Context.enter();
    }

    public String execScript(String script, Scriptable scope) {
        Object output = ctx.evaluateString(scope, script, "", 1, null);

        return Context.toString(output);
    }

    public String execFile(InputStream in, Scriptable scope) {
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

    public Context getContext() {
        return ctx;
    }
}
