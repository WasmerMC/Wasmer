package me.theclashfruit.wasmer.api.registry;

import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.ArrayList;

/**
 * This class represents a registry for WebAssembly methods.
 */
public class MethodRegistry {
    /**
     * A list of all registered WebAssembly methods.
     */
    public static ArrayList<WasmMethod> methods = new ArrayList<>();

    /**
     * Registers a new WebAssembly method.
     *
     * @param method The WebAssembly method to register.
     */
    public static void register(WasmMethod method) {
        methods.add(method);
    }
}
