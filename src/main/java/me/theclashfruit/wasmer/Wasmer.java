package me.theclashfruit.wasmer;

import com.dylibso.chicory.runtime.*;
import me.theclashfruit.wasmer.functions.LoggerError;
import me.theclashfruit.wasmer.functions.LoggerInfo;
import me.theclashfruit.wasmer.wasm.FunctionRegistry;
import me.theclashfruit.wasmer.wasm.WasmLoader;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wasmer implements ModInitializer {
    Path minecraftDir = FabricLoader.getInstance().getGameDir();

    public final static String MOD_ID = "assets/wasmer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // register base functions
        FunctionRegistry.register(new LoggerInfo());
        FunctionRegistry.register(new LoggerError());

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
