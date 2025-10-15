package Absyn;

public class TypeQualifierList extends Exp {
    public String qualifier;       
    public TypeQualifierList tail;   

    public TypeQualifierList(String q)
     {qualifier = q; tail = null; }

    public TypeQualifierList(String q, TypeQualifierList t)
     {qualifier = q; tail = t;}

    public boolean hasTail() 
    { return tail != null; }
}