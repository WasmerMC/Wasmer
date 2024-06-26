package me.theclashfruit.wasmer.functions;

import me.theclashfruit.wasmer.api.wrapper.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerTrace extends WasmMethod {
    public LoggerTrace() {
        this.fieldName = "logger_trace";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Integer[] execute(Integer... args) {
        LOGGER.trace(getString(args[0], args[1]));

        return null;
    }
}
