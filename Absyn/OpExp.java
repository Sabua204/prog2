package Absyn;
import Symbol.Symbol;
public class OpExp extends Exp {
   public int oper;
   public OpExp(int p, int o)
    {
      pos=p;
      oper=o; 
      }
   public final static int
    PLUS=0, 
    MINUS=1,
    TIMES=2,
    DIVIDE=3,
	 EQ=4,
    NE=5,
    LT=6,
    LE=7, 
    GT=8,
    GE=9,
    ASSIGN = 10,
    MULASSIGN =11,
    DIVASSIGN=12,
    MODASSIGN=13,
    ADDASSIGN=14,
    SUBASSIGN=15,
    LSHIFTASSIGN=16,
    RSHIFTASSIGN=17,
    BWISEANDASSIGN =18,
    BWISEXORASSIGN=19,
    BWISEORASSIGN=20;
   
}
