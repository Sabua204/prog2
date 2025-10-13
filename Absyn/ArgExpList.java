package Absyn;
import Symbol.Symbol;
public class ArgExpList extends Absyn {
   public Symbol name;
   public Symbol typ;
   public ArgExpList tail;
   public boolean escape = true;
   public ArgExpList(int p, Symbol n, Symbol t, ArgExpList x) 
   {
      pos=p;
      name=n;
      typ=t;
      tail=x;
   }
}
