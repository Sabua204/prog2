package Absyn;
import Symbol.Symbol;
public class FieldExpList extends Absyn {
   public Symbol name;
   public Exp init;
   public FieldExpList head;
   public FieldExpList tail;
   public FieldExpList(int p, Symbol n, Exp i, FieldExpList h, FieldExpList t) 
   {pos=p; 
	name=n;
   init=i;
   head=h;
   tail=t;
   }
}

//added a head for multiple values
