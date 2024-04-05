package me.theclashfruit.wasmer.wasm;

import java.util.ArrayList;

public class FunctionRegistry {
    public static ArrayList<WasmFunction> functions = new ArrayList<>();

    public static void register(WasmFunction function) {
        functions.add(function);
    }
}
