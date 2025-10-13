package Absyn;

public class BitFieldValue extends Exp {
    public Exp field;
    public Exp value;

    public BitFieldValue(int p, Exp f, Exp v) {
        pos = p; field = f; value = v;
    }
}