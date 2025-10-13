package Absyn;

public class Initializer extends Exp {
    public Exp assignmentExp;
    public InitializerList initList;
    public int type;

    public static final int ASSIGN = 0;
    public static final int LIST = 1;

    public Initializer(int p, Exp a) {
        pos = p; assignmentExp = a; type = ASSIGN;
    }

    public Initializer(int p, InitializerList l) {
        pos = p; initList = l; type = LIST;
    }
}
