package me.theclashfruit.wasmer.api;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.ValueType;

import java.util.List;

/**
 * Represents a WebAssembly method.
 */
public class WasmMethod {
    /**
     * The name of the field.
     */
    public String fieldName = "default";

    /**
     * The parameters of the method.
     */
    public List<ValueType> params  = List.of();
    /**
     * The return values of the method.
     */
    public List<ValueType> returns = List.of();

    /**
     * The instance of the method.
     */
    private Instance instance;

    public WasmMethod() {}

    /**
     * Executes the method with the given arguments.
     *
     * @param args The arguments to execute the method with.
     * @return Return values of the method.
     */
    public Integer[] execute(Integer... args) {
        return null;
    }

    /**
     * Reads a string from the instance's memory.
     *
     * @param length The length of the string to read.
     * @param offset The offset to start reading from.
     * @return The read string.
     */
    public String getString(int length, int offset) {
        return instance.memory().readString(offset, length);
    }

    /**
     * Sets the instance of the method.
     *
     * @param inst The instance to set.
     */
    public void setInstance(Instance inst) {
        instance = inst;
    }
}
