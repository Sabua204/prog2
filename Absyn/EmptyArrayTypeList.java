package Absyn;

public class EmptyArrayTypeList extends Exp {
    public int count; 

    public EmptyArrayTypeList(int count) {
        if (count < 1)
            throw new IllegalArgumentException("count must be >= 1");
        this.count = count;
    }
}