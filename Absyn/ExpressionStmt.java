package Absyn;

public class ExpressionStmt extends Statement {
    public Exp exp;  

    public ExpressionStmt(int p, Exp e) {
	pos = p; exp = e;}

    public boolean hasExp() { return exp != null; }
}