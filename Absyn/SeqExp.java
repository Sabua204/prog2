package Absyn;

public class SeqExp extends Exp {
    public ExpList list;

    public SeqExp(int p) {pos = p; list = null;}
    public SeqExp(int p, ExpList l) {pos = p; list = l;}

    public boolean isEmpty() {return list == null;}
}