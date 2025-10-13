package Absyn;
public class VarExp extends Exp {
   public Var var;
   public VarExp(int p, Var v) {    //just a variable by itself
      pos = p; var = v;
   }
}

//Tiger class reworked for C