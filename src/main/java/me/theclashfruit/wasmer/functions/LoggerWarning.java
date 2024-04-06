package me.theclashfruit.wasmer.functions;

import me.theclashfruit.wasmer.api.wrapper.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerWarning extends WasmMethod {
    public LoggerWarning() {
        this.fieldName = "logger_warning";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Integer[] execute(Integer... args) {
        LOGGER.warn(getString(args[0], args[1]));

        return null;
    }
}
