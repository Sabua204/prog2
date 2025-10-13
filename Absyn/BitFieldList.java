package Absyn;

public class BitFieldList {
    public BitFieldValue head;
    public BitFieldList tail;

    public BitFieldList(BitFieldValue h, BitFieldList t) {
        head = h; tail = t;
    }
}

