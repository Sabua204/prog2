
package Absyn;

public class IterStmt extends Statement{

public static final int WHILE_LOOP =0;
public static final int DO_WHILE_LOOP=1;
public static final int FOR_LOOP=2;

public int type;
public Exp exp;
public Statement stmt;
public Exp init;
public Exp increment;


public IterStmt(int p, Exp e, Statement s){
	pos=p; type=WHILE_LOOP; exp=e; stmt=s;}


public IterStmt(int p, Statement s, Exp e){
	pos=p; type=DO_WHILE_LOOP; exp=e; stmt=s;}


public IterStmt(int p, Exp i, Exp e, Exp ic, Statement s){
	pos=p; type=FOR_LOOP; init=i; exp=e; increment=ic; stmt=s;}
}