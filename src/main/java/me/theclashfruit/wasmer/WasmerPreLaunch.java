package me.theclashfruit.wasmer;

import me.theclashfruit.wasmer.api.registry.MethodRegistry;
import me.theclashfruit.wasmer.functions.*;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class WasmerPreLaunch implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        MethodRegistry.register(new LoggerInfo());
        MethodRegistry.register(new LoggerDebug());
        MethodRegistry.register(new LoggerWarning());
        MethodRegistry.register(new LoggerError());
        MethodRegistry.register(new LoggerTrace());
    }
}
