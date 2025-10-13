package Absyn;

public class ExpressionArrayTypeList {
    public ExpressionArrayType head;
    public ExpressionArrayTypeList tail;

    public ExpressionArrayTypeList(ExpressionArrayType head) {
        this.head = head;
        this.tail = null;
    }

    public ExpressionArrayTypeList(ExpressionArrayType head, ExpressionArrayTypeList tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean hasTail() { return tail != null; }
}
