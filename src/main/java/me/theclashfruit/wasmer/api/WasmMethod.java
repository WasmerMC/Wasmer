package me.theclashfruit.wasmer.api;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.Value;
import com.dylibso.chicory.wasm.types.ValueType;

import java.util.List;

/**
 * This class represents a WebAssembly method.
 */
public class WasmMethod {
    /**
     * The name of the field associated with this method.
     */
    public String fieldName = "default";

    /**
     * The list of parameter types that this method accepts.
     */
    public List<ValueType> params  = List.of();
    /**
     * The list of return types that this method produces.
     */
    public List<ValueType> returns = List.of();

    public WasmMethod() {}

    /**
     * Executes the method on a given instance with the provided arguments.
     *
     * @param inst The instance on which to execute the method.
     * @param args The arguments to pass to the method.
     * @return The return values from the method execution.
     */
    public Value[] execute(Instance inst, Value... args) {
        return null;
    }

    /**
     * Reads a string from the memory of a given instance.
     *
     * @param inst The instance from which to read the string.
     * @param length The length of the string to read.
     * @param offset The offset in memory where the string starts.
     * @return The read string.
     */
    public static String getString(Instance inst, int length, int offset) {
        return inst.memory().readString(offset, length);
    }
}
