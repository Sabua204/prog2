package Absyn;
import Symbol.Symbol;
public class UnaryExp extends Exp {
    public Exp exp;
    public int oper;
    public UnaryExp(int p, int o, Exp e) {
        pos = p; oper = o; exp = e;
    }
    public final static int 
        INCREMENT= 0,   //++number
        DECREMENT = 1,   //--number
        SIZEOF = 2;         //sizeof(number)
}