package Absyn;
import Symbol.Symbol;
public class VarDec extends Dec {
   public Symbol name;
   public boolean escape = true;
   public NameTy typ;
   public Exp init;
   public VarDec(int p, NameTy t, Symbol n) {        
     //int n;
      pos = p ;
       typ= t;
        name = n;
        init = null;
   }
   public VarDec(int p, NameTy t, Symbol n, Exp i) {  
    //int n = 0;
      pos = p; 
      typ= t; 
      name = n; 
      init = i;
   }
}

//Tiger class reworked for C