package Absyn;

import Symbol.Symbol;

public class SelectStmt extends Statement{

    public Exp condition;
    public Statement thenClause;
    public Statement elseClause;
    public Exp switchExp;
    public ExpList caseList;
    public StmtList stmtList;
    public Statement defaultStmt;
    public int type;

    public static final int IF = 0;
    public static final int IF_ELSE = 1;
    public static final int SWITCH = 2;

    public SelectStmt(int p, Exp c, Statement t){
        pos = p; condition = c; thenClause = t; type = IF;
    }

    public SelectStmt(int p, Exp c, Statement t, Statement e){
        pos = p; condition = c; thenClause = t; elseClause = e; type = IF_ELSE;
    }

    public SelectStmt(int p, Exp s, ExpList cl, StmtList sl, Statement d){
        pos = p; switchExp = s; caseList = cl; stmtList = sl; defaultStmt = d; type = SWITCH;
    }
}