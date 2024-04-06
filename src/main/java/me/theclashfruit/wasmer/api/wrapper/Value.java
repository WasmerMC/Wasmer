package me.theclashfruit.wasmer.api.wrapper;

public class Value {
    public static com.dylibso.chicory.wasm.types.Value i32(int value) {
        return com.dylibso.chicory.wasm.types.Value.i32(value);
    }

    public static com.dylibso.chicory.wasm.types.Value i64(int value) {
        return com.dylibso.chicory.wasm.types.Value.i64(value);
    }

    public static com.dylibso.chicory.wasm.types.Value f32(long value) {
        return com.dylibso.chicory.wasm.types.Value.f32(value);
    }

    public static com.dylibso.chicory.wasm.types.Value f64(long value) {
        return com.dylibso.chicory.wasm.types.Value.f64(value);
    }

    public static com.dylibso.chicory.wasm.types.Value fromFloat(long value) {
        return com.dylibso.chicory.wasm.types.Value.fromFloat(value);
    }

    public static com.dylibso.chicory.wasm.types.Value fromDouble(long value) {
        return com.dylibso.chicory.wasm.types.Value.fromDouble(value);
    }
}
