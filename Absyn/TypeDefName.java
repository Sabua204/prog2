package Absyn;
import Symbol.Symbol;

public class TypeDefName extends Exp {
    public Symbol name;

    public TypeDefName(int p, Symbol n) {
        pos = p; name = n;
    }
}