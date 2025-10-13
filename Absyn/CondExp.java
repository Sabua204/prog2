package Absyn;

public class CondExp extends Exp {
    public Exp test;    
    public Exp thenExp; 
    public Exp elseExp; 

    public CondExp(int p, Exp test, Exp thenExp, Exp elseExp) {pos = p; this.test = test; this.thenExp = thenExp; this.elseExp = elseExp;}
}