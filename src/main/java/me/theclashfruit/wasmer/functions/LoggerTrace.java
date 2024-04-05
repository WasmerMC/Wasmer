package me.theclashfruit.wasmer.functions;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.Value;
import com.dylibso.chicory.wasm.types.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerTrace extends WasmMethod {
    public LoggerTrace() {
        this.fieldName = "logger_trace";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Value[] execute(Instance inst, Value... args) {
        LOGGER.trace(getString(inst, args[0].asInt(), args[1].asInt()));

        return null;
    }
}