package Absyn;

public class StringExp extends Exp {
    public String value;  

    public StringExp(int p, String v) {
        if (v == null) throw new IllegalArgumentException("StringExp.value null");
        pos = p; value = v;}
}
