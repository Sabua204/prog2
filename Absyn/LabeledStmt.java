package Absyn;
import Symbol.Symbol;
public class LabeledStmt extends Statement {
   public Symbol iden;
   public Statement stmt;
   public LabeledStmt(int p, Symbol i, Statement s) {
        pos = p; iden = i; stmt = s;
    }
}