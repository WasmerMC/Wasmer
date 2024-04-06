package me.theclashfruit.wasmer.functions;

import me.theclashfruit.wasmer.api.ValueType;
import me.theclashfruit.wasmer.api.WasmMethod;

import java.util.List;

import static me.theclashfruit.wasmer.Wasmer.LOGGER;

public class LoggerDebug extends WasmMethod {
    public LoggerDebug() {
        this.fieldName = "logger_debug";

        this.params = List.of(ValueType.I32, ValueType.I32);
    }

    @Override
    public Integer[] execute(Integer... args) {
        LOGGER.debug(getString(args[0], args[1]));

        return null;
    }
}
