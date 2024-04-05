package me.theclashfruit.wasmer.wasm;

import com.dylibso.chicory.runtime.*;
import com.dylibso.chicory.runtime.Module;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class WasmLoader {
    private static final Path minecraftDir = FabricLoader.getInstance().getGameDir();

    public static ArrayList<Module>   modules   = new ArrayList<>();
    public static ArrayList<Instance> instances = new ArrayList<>();

    public static void loadWasmFiles() {
        if (!minecraftDir.resolve("wasm").toFile().exists()) {
            if (minecraftDir.resolve("wasm").toFile().mkdir()) {
                LOGGER.info("Wasm directory created!");
            } else {
                LOGGER.error("Failed to create Wasm directory!");
            }

            return;
        }

        for (File file : Objects.requireNonNull(minecraftDir.resolve("wasm").toFile().listFiles())) {
            if (!file.getName().endsWith(".wasm"))
                return;

            Module module = Module
                .builder(file)
                .withLogger(new LoggerBridge())
                .build();

            HostImports imports = getHostImports();

            Instance instance = module.instantiate(imports);

            modules.add(module);
            instances.add(instance);
        }
    }

    private static @NotNull HostImports getHostImports() {
        ArrayList<HostFunction> hostFunctions = new ArrayList<>();

        FunctionRegistry.functions.forEach((function) -> {
            hostFunctions.add(new HostFunction(
                function::execute,
                "env",
                function.fieldName,
                function.params,
                function.returns
            ));
        });

        HostFunction[] hostFunctionsArray = new HostFunction[hostFunctions.size()];

        hostFunctions.forEach((hostFunction) -> hostFunctionsArray[hostFunctions.indexOf(hostFunction)] = hostFunction);

        return new HostImports(hostFunctionsArray);
    }
}
