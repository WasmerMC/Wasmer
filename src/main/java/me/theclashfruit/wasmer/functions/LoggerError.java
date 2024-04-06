package me.theclashfruit.wasmer.functions;

import me.theclashfruit.wasmer.api.wrapper.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerError extends WasmMethod {
    public LoggerError() {
        this.fieldName = "logger_error";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Integer[] execute(Integer... args) {
        LOGGER.error(getString(args[0], args[1]));

        return null;
    }
}
