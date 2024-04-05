package me.theclashfruit.wasmer;

import com.dylibso.chicory.runtime.*;
import me.theclashfruit.wasmer.functions.LoggerError;
import me.theclashfruit.wasmer.functions.LoggerInfo;
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
        MethodRegistry.register(new LoggerError());

        // load wasm files
        WasmLoader.loadWasmFiles();

        // call on_initialize functions
        WasmLoader.instances.forEach(instance -> {
            try {
                ExportFunction iterFact = instance.export("on_initialize");

                if (iterFact != null) {
                    iterFact.apply();
                }
            } catch (Exception ignored) {}
        });
    }
}
