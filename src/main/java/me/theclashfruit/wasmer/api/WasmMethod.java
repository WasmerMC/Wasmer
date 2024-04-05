package me.theclashfruit.wasmer.api;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.Value;
import com.dylibso.chicory.wasm.types.ValueType;

import java.util.List;

public class WasmMethod {
    public String fieldName = "default";

    public List<ValueType> params  = List.of();
    public List<ValueType> returns = List.of();

    public WasmMethod() {}

    public Value[] execute(Instance inst, Value... args) {
        return null;
    }

    public static String getString(Instance inst, int length, int offset) {
        return inst.memory().readString(offset, length);
    }
}
