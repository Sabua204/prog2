package Absyn;

public class ParameterTypeList {
    public Ty type;
    public ParameterTypeList next;

    public ParameterTypeList(Ty t, ParameterTypeList n) {
        type = t; next = n;
    }
}
