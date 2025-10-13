package Absyn;
import Symbol.Symbol;
public class UnaryOps extends Exp {
   public int oper;
   public UnaryOps(int p, int o)
    {
      pos=p;
      oper=o; 
      }
   public final static int
   AMPERSAND=0,
   TIMES =1,
   PLUS=2,
   MINUS=3,
   TILDE=4,
   BITWISEAND=5;
   //EXCLAMATION=5;
}
