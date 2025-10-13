package Absyn;
import Symbol.Symbol;

public class ForStatement extends Statement {
    public Exp assignment;
    public Exp comparison;
    public Exp iteration;
    public Statement statement;
    public ForStatement(int p, Exp assign, Exp comp, Exp itr, Statement s){
        pos = p;
        assignment = assign;
        comparison = comp;
        iteration = itr;
        statement = s;
    }
}
