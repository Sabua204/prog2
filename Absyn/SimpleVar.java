package Absyn;
import Symbol.Symbol;

public class SimpleVar extends Var {
    public Symbol name;  

    public SimpleVar(int p, Symbol n) {
        if (n == null) throw new IllegalArgumentException("SimpleVar.name null");
        pos = p; name = n;}
}