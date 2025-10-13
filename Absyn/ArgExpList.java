/*package Absyn;
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
*/

package Absyn;
public class ArgExpList extends Absyn {
   public ArgExpList head;
   public Exp tail;
   public boolean escape = true;
   public ArgExpList(int p, ArgExpList h, Exp t) 
   {
      pos = p;
      head = h;
      tail = t;
   }
   public ArgExpList(int p, Exp t) 
   {
      pos = p;
      head = null;
      tail = t;
   }
}