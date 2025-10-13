package Absyn;

public class EnumeratorList {
    public Enumerator head;
    public EnumeratorList tail;

    public EnumeratorList(Enumerator h, EnumeratorList t) {
        head = h; tail = t;
    }
}