package me.theclashfruit.wasmer;

import com.dylibso.chicory.runtime.*;
import me.theclashfruit.wasmer.functions.*;
import me.theclashfruit.wasmer.api.registry.MethodRegistry;
import me.theclashfruit.wasmer.wasm.WasmLoader;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wasmer implements ModInitializer {
    public final static String MOD_ID = "wasmer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // register base functions
        MethodRegistry.register(new LoggerInfo());
        MethodRegistry.register(new LoggerDebug());
        MethodRegistry.register(new LoggerWarning());
        MethodRegistry.register(new LoggerError());
        MethodRegistry.register(new LoggerTrace());

        // load wasm files
        WasmLoader.loadWasmFiles();

        // call on_initialize functions
        WasmLoader.instances.forEach(instance -> {
            try {
                ExportFunction eFunc = instance.export("on_initialize");

                if (eFunc != null) {
                    eFunc.apply();
                }
            } catch (Exception ignored) {}
        });
    }
}
