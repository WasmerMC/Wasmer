package me.theclashfruit.wasmer.api.registry;

import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.ArrayList;

public class MethodRegistry {
    public static ArrayList<WasmMethod> functions = new ArrayList<>();

    public static void register(WasmMethod function) {
        functions.add(function);
    }
}
