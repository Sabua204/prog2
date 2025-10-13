package Absyn;
import Symbol.Symbol;

public class StmtList {
    public Statement head;
    public StmtList tail;


    public StmtList(Statement h, StmtList t) { 
        head = h;
        tail = t;}
} 
