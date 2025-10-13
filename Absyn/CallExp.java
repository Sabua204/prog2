package Absyn;

import Symbol.Symbol;

public class CallExp extends Exp {
    public Symbol func; 
    public ExpList args; 

    public CallExp(int p, Symbol f) {
        if (f == null) throw new IllegalArgumentException("CallExp.func null");
        pos = p; func = f; args = null;}

    public CallExp(int p, Symbol f, ExpList a) {
        if (f == null) throw new IllegalArgumentException("CallExp.func null");
        pos = p; func = f; args = a;}

    public boolean hasArgs() {return args != null;
   }
}

