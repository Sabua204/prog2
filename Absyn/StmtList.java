package Absyn;

public class StmtList extends Statement{
    public int pos;
    public Statement head;
    public StmtList tail;
    public StmtList(int p, Statement h, StmtList t) { 
        pos = p;
        head = h;
        tail = t;
    }
    public StmtList(int p, Statement h) {
        pos = p;
        head = h;
        tail = null;
    }
} 