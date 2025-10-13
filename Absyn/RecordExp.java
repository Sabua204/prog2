package Absyn;

import Symbol.Symbol;

public class RecordExp extends Exp {
    public Symbol typ;         
    public FieldExpList fields;

    public RecordExp(int p, Symbol t) {
        if (t == null) throw new IllegalArgumentException("RecordExp.typ null");
        pos = p; typ = t; fields = null;}

    public RecordExp(int p, Symbol t, FieldExpList f) {
        if (t == null) throw new IllegalArgumentException("RecordExp.typ null");
        pos = p; typ = t; fields = f;}

    public boolean hasFields() {return fields != null;}
}
