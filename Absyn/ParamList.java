package Absyn;
import Symbol.Symbol;
public class ParamList extends Absyn {
    public ParamList head;
    public Ty type;
    public Symbol name;
    public ParamList(int p, ParamList h, Ty t, Symbol n) {      //(int num, char string[]); multiple parameters detected
        pos = p; head = h; type = t; name = n;
   }
   public ParamList(int p, Ty t, Symbol n) {                    //(int num); just one parameter, or the last parameter in a longer list
        pos = p; head = null; type = t; name = n;
   }
   public ParamList(int p, Ty t) {                              //(int); just the type for parameter_type_list
        pos = p; head = null; type = t; name = null;
   }
}