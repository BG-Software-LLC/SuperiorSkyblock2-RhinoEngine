package com.bgsoftware.superiorskyblock.scripts;

import com.bgsoftware.superiorskyblock.api.scripts.IScriptEngine;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import javax.script.Bindings;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import java.util.Map;

public final class RhinoScript implements IScriptEngine {

    private static final RhinoScript instance = new RhinoScript();

    public static RhinoScript getInstance() {
        return instance;
    }

    private RhinoScript(){

    }

    @Override
    public Object eval(String stringToEvaluate) throws ScriptException {
        return eval(stringToEvaluate, new SimpleBindings());
    }

    @Override
    public Object eval(String stringToEvaluate, Bindings bindings) throws ScriptException {
        Context cx = Context.enter();
        try {
            Scriptable scope = cx.initSafeStandardObjects();

            for(Map.Entry<String, Object> entry : bindings.entrySet()){
                Object wrappedObject = Context.javaToJS(entry.getValue(), scope);
                ScriptableObject.putProperty(scope, entry.getKey(), wrappedObject);
            }

            return cx.evaluateString(scope, stringToEvaluate, "EvaluationScript", 1, null);
        } finally {
            Context.exit();
        }
    }

}
