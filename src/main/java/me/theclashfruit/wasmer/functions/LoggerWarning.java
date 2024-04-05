package me.theclashfruit.wasmer.functions;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.types.Value;
import com.dylibso.chicory.wasm.types.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerWarning extends WasmMethod {
    public LoggerWarning() {
        this.fieldName = "logger_warning";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Value[] execute(Instance inst, Value... args) {
        LOGGER.warn(getString(inst, args[0].asInt(), args[1].asInt()));

        return null;
    }
}
