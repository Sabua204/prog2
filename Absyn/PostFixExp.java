package Absyn;

import Symbol.Symbol;

public class PostFixExp extends Exp{

	public Exp exp;
	public Exp index;
	public ExpList args;
	public Symbol field;
	public int type;

	public static final int PRIMARY_EXP =0;
	public static final int ARRAY = 1;
	public static final int FUNC_CALL =2;// fun(x,y)
	public static final int FIELD_ACCESS = 3; // x.y
	public static final int ARROW =4; // x-> y

	public PostFixExp(int p, Exp e, int t){
		pos=p; exp=e; type=t;}


	public PostFixExp(int p, Exp e, Exp i){
		pos=p; exp=e; index=i; type=ARRAY;}


	public PostFixExp(int p, Exp e, ExpList a){
		pos=p; exp=e; args=a; type=FUNC_CALL;}


	public PostFixExp(int p, Exp e, Symbol f, boolean pointer){
		pos=p; exp=e; field=f;
		 if (pointer)
		{
		  type=ARROW;
		}else
		{
		  type = FIELD_ACCESS;
		}
    }}