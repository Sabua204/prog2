package Absyn;
import Symbol.Symbol;

public class BinOp extends Exp
{
    public Exp left,right;
    public int oper;
    public BinOp(int p, Exp l, int o, Exp r)
    {
        pos = p; left = l; oper = o; right = r;
    }
    public final static int
    OR = 0,
    AND = 1,
    BWISEOR = 2,
    BWISEXOR = 3,
    BWISEAND = 4,
    EQ = 5,
    NEQ = 6,
    LT = 7,
    GT = 8,
    LE = 9,
    GE = 10,
    LSHIFT = 11,
    RSHIFT = 12,
    PLUS = 13,
    MINUS = 14,
    TIMES = 15,
    DIVIDE = 16,
    MODULUS = 17,
    ASSIGN = 18;
}

