package me.theclashfruit.wasmer.client;

import com.dylibso.chicory.runtime.ExportFunction;
import me.theclashfruit.wasmer.wasm.WasmLoader;
import net.fabricmc.api.ClientModInitializer;

public class WasmerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WasmLoader.instances.forEach(instance -> {
            try {
                ExportFunction eFunc = instance.export("on_initialize_client");

                if (eFunc != null) {
                    eFunc.apply();
                }
            } catch (Exception ignored) {}
        });
    }
}
