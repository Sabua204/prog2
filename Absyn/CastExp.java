package Absyn;
public class CastExp extends Exp {
    public Ty type;
    public CastExp cast;
    public CastExp(int p, Ty t, CastExp c) {
      pos = p; type = t; cast = c;
   }
}