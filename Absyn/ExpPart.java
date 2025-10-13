package Absyn;

public class ExpPart extends Exp{

    public Exp exp;

    public ExpPart(int p, Exp e){
        pos=p;
        exp=e;}
}