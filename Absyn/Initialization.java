package Absyn;

public class Initialization {
    public Exp value; 

    public Initialization() { value = null; }

    public Initialization(Exp v) { value = v; }

    public boolean hasValue() { return value != null; }
}