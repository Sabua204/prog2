package Absyn;
import Symbol.Symbol;
public class PrimaryExp extends Exp{
    public Exp exp;

    public PrimaryExp(int p, Exp e)
    {
        pos=p;
        exp=e;
    }
}
