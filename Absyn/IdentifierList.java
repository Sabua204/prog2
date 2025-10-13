package Absyn;
import Symbol.Symbol;
public class IdentifierList {
    public Symbol id;
    public IdentifierList next;

    public IdentifierList(Symbol i, IdentifierList n) {
        id = i; next = n;
    }
}