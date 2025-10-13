package Absyn;
import Symbol.Symbol;
public class TypeDec extends Dec {
   public Symbol name;
   public Ty ty;
   public TypeDec next;
   public TypeDec(int p, Ty t, Symbol n, TypeDec x) {  
        //struct Point {int x; int y;}
      pos = p;
       ty = t; 
       name = n; 
       next = x;
   }
}

//Tiger class reworked for C