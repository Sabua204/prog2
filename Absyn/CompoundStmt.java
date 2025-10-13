package Absyn;

public class CompoundStmt extends Statement{

    public DecList decs;  //will add declaration_list_opt to DecList
    public StmtList stmts; //will add statement_list_opt to StmtList

    public CompoundStmt(int p, DecList d, StmtList s){
        pos=p;
        decs=d;
        stmts=s;
     }
}

