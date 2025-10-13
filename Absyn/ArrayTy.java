package Absyn;

import Symbol.Symbol;

public class ArrayTy extends Ty {
    public Symbol typ;

    public ArrayTy(int p, Symbol t) {
        if (t == null) throw new IllegalArgumentException("ArrayTy.typ null");
        pos = p; typ = t;}
}