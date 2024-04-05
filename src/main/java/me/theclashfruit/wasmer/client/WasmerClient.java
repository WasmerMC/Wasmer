package me.theclashfruit.wasmer.client;

import com.dylibso.chicory.runtime.ExportFunction;
import me.theclashfruit.wasmer.wasm.WasmLoader;
import net.fabricmc.api.ClientModInitializer;

public class WasmerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WasmLoader.instances.forEach(instance -> {
            try {
                ExportFunction iterFact = instance.export("on_initialize_client");

                if (iterFact != null) {
                    iterFact.apply();
                }
            } catch (Exception ignored) {}
        });
    }
}
