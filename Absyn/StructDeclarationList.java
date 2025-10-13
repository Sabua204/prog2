package Absyn;

public class StructDeclarationList extends Absyn{
    public Ty type;
    public Name name;

    public StructDeclarationList(Ty t, Name n){
        type=t;
        name=n;
    }
    
}
