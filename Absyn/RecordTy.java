package Absyn;

public class RecordTy extends Ty {
    public ArgExpList fields; 

    public RecordTy(int p) {pos = p; fields = null;}
    public RecordTy(int p, ArgExpList f) {pos = p; fields = f;}

    public boolean hasFields() {return fields != null;}
}
