package Absyn;
import Symbol.Symbol;
public class ForExp extends Exp{
   public Exp assignment;
   public Exp comparison;
   public Exp iteration;
   public Statement statement;
   public ForExp(int p, Exp assign, Exp comp, Exp iter, Statement s) {
      pos = p; 
      assignment = assign; 
      comparison = comp; 
      iteration = iter; 
      statement = s;
   }
}

//Tiger class reworked for C
