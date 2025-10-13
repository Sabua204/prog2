package Absyn;

public class StructOrUnionDeclarator extends Absyn {
    public StructDeclarationList declarations;

    public StructOrUnionDeclarator(int p, StructDeclarationList d) {
        pos = p; declarations = d;
    }
}
