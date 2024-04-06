package me.theclashfruit.wasmer.api.wrapper;

public enum ValueType {
    F64(com.dylibso.chicory.wasm.types.ValueType.F64),
    F32(com.dylibso.chicory.wasm.types.ValueType.F32),
    I64(com.dylibso.chicory.wasm.types.ValueType.I64),
    I32(com.dylibso.chicory.wasm.types.ValueType.I32),
    V128(com.dylibso.chicory.wasm.types.ValueType.V128),
    FuncRef(com.dylibso.chicory.wasm.types.ValueType.FuncRef),
    ExternRef(com.dylibso.chicory.wasm.types.ValueType.ExternRef);

    public final com.dylibso.chicory.wasm.types.ValueType vT;

    ValueType(com.dylibso.chicory.wasm.types.ValueType vT) {
        this.vT = vT;
    }
}
