package Absyn;

import Symbol.Symbol;

public class Enumerator {
    public int    pos;
    public Symbol name;  
    public Exp    value; 

    // ID
    public Enumerator(int p, Symbol n) {
        if (n == null) throw new IllegalArgumentException("Enumerator.name null");
        pos = p; name = n; value = null;
    }

    // ID = constant_expression
    public Enumerator(int p, Symbol n, Exp v) {
        if (n == null) throw new IllegalArgumentException("Enumerator.name null");
        pos = p; name = n; value = v; 
    }

    public boolean hasValue() { return value != null; }
}