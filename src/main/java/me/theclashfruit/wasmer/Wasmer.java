package me.theclashfruit.wasmer;

import com.dylibso.chicory.runtime.*;
import me.theclashfruit.wasmer.wasm.WasmLoader;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wasmer implements ModInitializer {
    public final static String MOD_ID = "wasmer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // load wasm files
        WasmLoader.loadWasmFiles();

        // call on_initialize functions
        WasmLoader.instances.forEach(instance -> {
            try {
                ExportFunction eFunc = instance.export("on_initialize");

                if (eFunc != null) {
                    eFunc.apply();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }
}
