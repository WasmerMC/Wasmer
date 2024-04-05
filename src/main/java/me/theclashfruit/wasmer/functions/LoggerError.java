package me.theclashfruit.wasmer.functions;

import com.dylibso.chicory.wasm.types.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.Value;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerError extends WasmMethod {
    public LoggerError() {
        this.fieldName = "logger_error";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Value[] execute(Instance inst, Value... args) {
        LOGGER.error(getString(inst, args[0].asInt(), args[1].asInt()));

        return null;
    }
}
