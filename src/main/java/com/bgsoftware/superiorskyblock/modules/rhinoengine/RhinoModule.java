package com.bgsoftware.superiorskyblock.modules.rhinoengine;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblock;
import com.bgsoftware.superiorskyblock.api.commands.SuperiorCommand;
import com.bgsoftware.superiorskyblock.api.modules.ModuleLoadTime;
import com.bgsoftware.superiorskyblock.api.modules.PluginModule;
import com.bgsoftware.superiorskyblock.scripts.RhinoScript;
import org.bukkit.event.Listener;

public final class RhinoModule extends PluginModule {

    public RhinoModule(){
        super("rhino-engine", "Ome_R");
    }

    @Override
    public void onEnable(SuperiorSkyblock superiorSkyblock) {
        superiorSkyblock.setScriptEngine(RhinoScript.getInstance());
    }

    @Override
    public void onReload(SuperiorSkyblock superiorSkyblock) {

    }

    @Override
    public void onDisable(SuperiorSkyblock superiorSkyblock) {
        superiorSkyblock.setScriptEngine(null);
    }

    @Override
    public Listener[] getModuleListeners(SuperiorSkyblock superiorSkyblock) {
        return null;
    }

    @Override
    public SuperiorCommand[] getSuperiorCommands(SuperiorSkyblock superiorSkyblock) {
        return null;
    }

    @Override
    public SuperiorCommand[] getSuperiorAdminCommands(SuperiorSkyblock superiorSkyblock) {
        return null;
    }

    @Override
    public ModuleLoadTime getLoadTime() {
        return ModuleLoadTime.BEFORE_WORLD_CREATION;
    }

}
