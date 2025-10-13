package Absyn;

public class StructOrUnion {
    public enum Kind { STRUCT, UNION }

    public int  pos;
    public Kind kind;

    public StructOrUnion(int p, Kind k) {
        if (k == null) throw new IllegalArgumentException("StructOrUnion.kind null");
        pos = p; kind = k;
    }

    public boolean isStruct() { return kind == Kind.STRUCT; }
    public boolean isUnion()  { return kind == Kind.UNION;  }
}