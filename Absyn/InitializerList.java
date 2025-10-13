package Absyn;

public class InitializerList {
    public Initializer head;
    public InitializerList tail;

    public InitializerList(Initializer h, InitializerList t) {
        head = h; tail = t;
    }
}


