package Absyn;

public class Print {

  java.io.PrintWriter out;

  public Print(java.io.PrintWriter o) { out = o; }

  void indent(int d) {
      for(int i=0; i<d; i++) 
            out.print(' ');
  }

  void say(String s) {
    out.print(s);
  }

  void say(int i) {
    out.print(i);
  }

  void say(boolean b) {
    out.print(b);
  }

  void sayln(String s) {
    out.println(s);
  }


//In Absyn  , Used in Var Grammar
  void prVar(SimpleVar v, int d) {
    say("SimpleVar("); say(v.name.toString()); say(")");
  }


//  In Absyn , Not used in grammar atm
  void prVar(FieldVar v, int d) {
    sayln("FieldVar(");
    prVar(v.var, d+1); sayln(",");
    indent(d+1); say(v.field.toString()); say(")");
  }

 // Not used in grammar atm
  void prVar(SubscriptVar v, int d) {
    sayln("SubscriptVar(");
    prVar(v.var, d+1); sayln(",");
    prExp(v.index, d+1); say(")");
  }

  /* Print A_var types. Indent d spaces. */
  void prVar(Var v, int d) {
    indent(d);
    if (v instanceof SimpleVar) prVar((SimpleVar) v, d);
    else if (v instanceof FieldVar) prVar((FieldVar) v, d);
    else if (v instanceof SubscriptVar) prVar((SubscriptVar) v, d);
    else throw new Error("Print.prVar");
  }


  //In grammar: assignment_operator
  void prExp(OpExp e, int d) {
    sayln("OpExp(");
    indent(d+1); 
    switch(e.oper) {
    case OpExp.PLUS: say("PLUS"); break;
    case OpExp.MINUS: say("MINUS"); break;
    case OpExp.TIMES: say("TIMES"); break;
    case OpExp.DIVIDE: say("DIVIDE"); break;
    case OpExp.EQ: say("EQ"); break;
    case OpExp.NE: say("NE"); break;
    case OpExp.LT: say("LT"); break;
    case OpExp.LE: say("LE"); break;
    case OpExp.GT: say("GT"); break;
    case OpExp.GE: say("GE"); break;
    case OpExp.ASSIGN: say("ASSIGN"); break;
    case OpExp.MULASSIGN: say("MULASSIGN"); break;
    case OpExp.DIVASSIGN: say("DIVASSIGN"); break;
    case OpExp.MODASSIGN: say("MODASSIGN"); break;
    case OpExp.ADDASSIGN: say("ADDASSIGN"); break;
    case OpExp.SUBASSIGN: say("SUBASSIGN"); break;
    case OpExp.LSHIFTASSIGN: say("LSHIFTASSIGN"); break;
    case OpExp.RSHIFTASSIGN: say("RSHIFTASSIGN"); break;
    case OpExp.BWISEANDASSIGN: say("BWISEANDASSIGN"); break;
    case OpExp.BWISEXORASSIGN: say("BWISEXORASSIGN"); break;
    case OpExp.BWISEORASSIGN: say("BWISEORASSIGN"); break;
    default:
      throw new Error("Print.prExp.OpExp");
    }
    sayln(")");
  }

  //In Grammar: expression
  void prExp(VarExp e, int d) {
    sayln("VarExp("); prVar(e.var, d+1);
    say(")");
  }

 //Not in Grammar, maybe could use for optional fields? 
  void prExp(NullExp e, int d) {
    say("NullExp()");
  }

 // in grammar: initializer
  void prExp(Initializer e, int d) {
    say("Initializer("); say(e.type); say(")");
  }

  //Not in grammar atm
  void prExp(StringExp e, int d) {
    say("StringExp("); say(e.value); say(")");
  }

  //Not in Grammar atm
  void prExp(CallExp e, int d) {
    say("CallExp("); say(e.func.toString()); sayln(",");
    prExplist(e.args, d+1); say(")");
  }

  //Not in Grammar atm
  void prExp(RecordExp e, int d) {
    say("RecordExp("); say(e.typ.toString());  sayln(",");
    prFieldExpList(e.fields, d+1); say(")");
  }

  //In grammar:  expression
  void prExp(SeqExp e, int d) {
    sayln("SeqExp(");
    prExplist(e.list, d+1); say(")");
  }

  //Not in grammar atm
  void prExp(AssignExp e, int d) {
    sayln("AssignExp(");
    prVar(e.var, d+1); sayln(",");
    prExp(e.exp, d+1); say(")");
  }
  
  //Not in grammar
  void prExp(IfExp e, int d) {
    sayln("IfExp(");
    prExp(e.test, d+1); sayln(",");
    prExp(e.thenclause, d+1);
    if (e.elseclause!=null) { /* else is optional */
      sayln(",");
      prExp(e.elseclause, d+1);
    }
    say(")");
  }

  //Not in grammar,  possibly meant to be used in iteration_statement, but already returned with newly created iterStmt absyn
  void prExp(WhileExp e, int d) {
    sayln("WhileExp(");
    prExp(e.test, d+1); sayln(",");
    prExp(e.body, d+1); say(")");
  }

  //Same as WhileExp ^
  void prExp(ForExp e, int d) {
    sayln("ForExp("); 
    indent(d+1);
    prExp(e.assignment, d+1); sayln(",");
    prExp(e.comparison, d+1); sayln(",");
    prExp(e.iteration, d+1); sayln(",");  
    prExp(e.iteration, d+1); sayln(")");
  }

  //Not in grammar
  void prExp(BreakExp e, int d) {
    say("BreakExp()");
  }


//Not in grammar,  Possibly for expression_array_type
  void prExp(ArrayExp e, int d) {
    say("ArrayExp("); say(e.typ.toString()); sayln(",");
    prExp(e.size, d+1); sayln(",");
    prExp(e.init, d+1); say(")");
  }

  /* Print Exp class types. Indent d spaces. */
  //Absyn files that extend Exp Absyn here:
  public void prExp(Exp e, int d) {
    indent(d);
    if (e instanceof OpExp) prExp((OpExp)e, d);
    else if (e instanceof VarExp) prExp((VarExp) e, d);
    else if (e instanceof NullExp) prExp((NullExp) e, d);
   // else if (e instanceof IntExp) prExp((IntExp) e, d);
    else if (e instanceof StringExp) prExp((StringExp) e, d);
    else if (e instanceof CallExp) prExp((CallExp) e, d);
    else if (e instanceof RecordExp) prExp((RecordExp) e, d);
    else if (e instanceof SeqExp) prExp((SeqExp) e, d);
    else if (e instanceof AssignExp) prExp((AssignExp) e, d);
    else if (e instanceof IfExp) prExp((IfExp) e, d);
    else if (e instanceof WhileExp) prExp((WhileExp) e, d);
    else if (e instanceof ForExp) prExp((ForExp) e, d);
    else if (e instanceof BreakExp) prExp((BreakExp) e, d);
    else if (e instanceof ArrayExp) prExp((ArrayExp) e, d);
    else if (e instanceof PrimaryExp) prExp((PrimaryExp) e, d);
    else if (e instanceof UnaryExp) prExp((UnaryExp) e, d);
    else if (e instanceof VarExp) prExp((VarExp) e, d);
    else if (e instanceof BinOp) prExp((BinOp) e, d);
    else if (e instanceof BitFieldValue) prExp((BitFieldValue) e, d);
    else if (e instanceof BitFieldValue) prExp((BitFieldValue) e, d);
    else if (e instanceof CastExp) prExp((CastExp) e, d);
    else if (e instanceof CondExp) prExp((CondExp) e, d);
    else if (e instanceof ExpPart) prExp((ExpPart) e, d);
    else if (e instanceof BitFieldValue) prExp((BitFieldValue) e, d);
    else if (e instanceof Initializer) prExp((Initializer) e, d);
    else if (e instanceof BitFieldValue) prExp((BitFieldValue) e, d);
    else if (e instanceof OpExp) prExp((OpExp) e, d);
    else if (e instanceof PostFixExp) prExp((PostFixExp) e, d);
    else if (e instanceof PrimaryExp) prExp((PrimaryExp) e, d);
    else if (e instanceof RecordExp) prExp((RecordExp) e, d);
    else if (e instanceof StringExp) prExp((StringExp) e, d);
    else if (e instanceof TypeDefName) prExp((TypeDefName) e, d);
    else if (e instanceof UnaryExp) prExp((UnaryExp) e, d);
    else if (e instanceof UnaryOps) prExp((UnaryOps) e, d);
    else if (e instanceof BitFieldValue) prExp((BitFieldValue) e, d);
   // else if (e instanceof TypeQualifierList) prExp((TypeQualifierList) e, d);
     else if (e instanceof EmptyArrayTypeList) prExp((EmptyArrayTypeList) e, d);
    else throw new Error("Print.prExp");
  }

  //Not in grammar atm,  likely in declaration nonterminal
  void prDec(FunctionDec d, int i) {
    say("FunctionDec(");
    if (d!=null) {
      sayln(d.name.toString());
      prFieldlist(d.params, i+1); sayln(",");
      if (d.result!=null) {
	indent(i+1); sayln(d.result.name.toString());
      }
      prExp(d.body, i+1); sayln(",");
      indent(i+1); prDec(d.next, i+1);
    }
    say(")");
  }

  //not yet in grammar
  void prDec(VarDec d, int i) {
    say("VarDec("); say(d.name.toString()); sayln(",");
    if (d.typ!=null) {
      indent(i+1); say(d.typ.name.toString());  sayln(",");
    }
    prExp(d.init, i+1); sayln(",");
    indent(i+1); say(d.escape); say(")"); 
  }

  //Not yet in grammar,  possibly in type_qualifier grammar
  void prDec(TypeDec d, int i) {
    if (d!=null) {
      say("TypeDec("); say(d.name.toString()); sayln(",");
      prTy(d.ty, i+1); 
      if (d.next!=null) {
	sayln(","); indent(i+1); prDec(d.next, i+1);
      }
      say(")");
    }
  }

  // Abysn files that extend Dec Absyn here:
  void prDec(Dec d, int i) {
    indent(i);
    if (d instanceof FunctionDec) prDec((FunctionDec) d, i);
    else if (d instanceof VarDec) prDec((VarDec) d, i);
    else if (d instanceof TypeDec) prDec((TypeDec) d, i);
    else throw new Error("Print.prDec");
  }


  //in grammar:  type_name
  void prTy(NameTy t, int i) {
    say("NameTy("); say(t.name.toString()); say(")");
  }

  //Not in grammar atm
  void prTy(RecordTy t, int i) {
    sayln("RecordTy(");
    prFieldlist(t.fields, i+1); say(")");
  }

  //Not in grammar atm, could possibly be used for:  empty_array_type,  expression_array_type
  void prTy(ArrayTy t, int i) {
    say("ArrayTy("); say(t.typ.toString()); say(")");
  }

// Absyn files that extend Ty absyn here:
  void prTy(Ty t, int i) {
    if (t!=null) {
      indent(i);
      if (t instanceof NameTy) prTy((NameTy) t, i);
      else if (t instanceof RecordTy) prTy((RecordTy) t, i);
      else if (t instanceof ArrayTy) prTy((ArrayTy) t, i);
      else throw new Error("Print.prTy");
    }
  }



  //in grammar: argument_expression_list
  void prFieldlist(ArgExpList f, int d) {
    indent(d);
    say("ArgumentExpressionList("); 
    if (f!=null) {
      sayln("");
      indent(d+1); say(f.head.toString()); sayln(",");
      indent(d+1); say(f.tail.toString()); sayln(",");
      indent(d+1); say(f.escape);
      sayln(",");
      prFieldlist(f, d);
    }
    say(")");
  }

  //Not in grammar,    likely in expression_list grammar
  void prExplist(ExpList e, int d) {
    indent(d);
    say("ExpList("); 
    if (e!=null) {
      sayln("");
      prExp(e.head, d+1); 
      if (e.tail != null) {
	sayln(","); prExplist(e.tail, d+1);
      }
    }
    say(")");
  }

  //Not in grammar,  likely in declaration_list grammar
  void prDecList(DecList v, int d) {
    indent(d);
    say("DecList("); 
    if (v!=null) {
      sayln("");
      prDec(v.head, d+1); sayln(",");
      prDecList(v.tail, d+1);
    }
    say(")");
  }

  void prFieldExpList(FieldExpList f, int d) {
    indent(d);
    say("FieldExpList("); 
    if (f!=null) {
      sayln("");
      indent(d+1); say(f.name.toString()); sayln(",");
      prExp(f.init, d+1); sayln(",");
      prFieldExpList(f.tail, d+1);
    }
    say(")");
  }

// Absyn Extneds  Statments here
 void prStmt(Statement s, int i) {
    if (s!=null) {
      indent(i);
      if (s instanceof CompoundStmt) prStmt((CompoundStmt) s, i);
      else if (s instanceof ExpressionStmt) prStmt((ExpressionStmt) s, i);
      else if (s instanceof ForStatement) prStmt((ForStatement) s, i);
      else if (s instanceof LabeledStmt) prStmt((LabeledStmt) s, i);
      else if (s instanceof IterStmt) prStmt((IterStmt) s, i);
      else if (s instanceof SelectStmt) prStmt((SelectStmt) s, i);
      else if (s instanceof StmtList) prStmt((StmtList) s, i);
      else throw new Error("Print.prStmt");
    }
  }

void prStmt(ForStatement s, int d) {
    sayln("ForStatement(");
    indent(d+1); prExp(s.assignment, d+1); sayln(",");
    indent(d+1); prExp(s.comparison, d+1); sayln(",");
    indent(d+1); prExp(s.iteration, d+1); sayln(",");
    indent(d+1); prStmt(s.statement, d+1);
    say(")");
}

void prStmt(LabeledStmt s, int d) {
    say("LabeledStmt(");
    say(s.iden.toString()); sayln(",");
    prStmt(s.stmt, d+1);
    say(")");
}

void prStmt(IterStmt s, int d) {
    sayln("IterStmt(");
    indent(d+1);
    switch(s.type) {
        case IterStmt.WHILE_LOOP:
            say("WHILE_LOOP,"); sayln("");
            prExp(s.exp, d+1); sayln(",");
            prStmt(s.stmt, d+1);
            break;
        case IterStmt.DO_WHILE_LOOP:
            say("DO_WHILE_LOOP,"); sayln("");
            prStmt(s.stmt, d+1); sayln(",");
            prExp(s.exp, d+1);
            break;
        case IterStmt.FOR_LOOP:
            say("FOR_LOOP,"); sayln("");
            prExp(s.init, d+1); sayln(",");
            prExp(s.exp, d+1); sayln(",");
            prExp(s.increment, d+1); sayln(",");
            prStmt(s.stmt, d+1);
            break;
    }
    say(")");
}

// --- Initializations ---
void prInit(Initialization i, int d) {
    say("Initialization(");
    if (i.hasValue()) prExp(i.value, d+1);
    say(")");
}

void prInitList(InitializerList il, int d) {
    sayln("InitializerList(");
    if (il != null) {
        indent(d+1); prExp(il.head, d+1); sayln(",");
        prInitList(il.tail, d+1);
    }
    say(")");
}

// --- Names & Symbols ---
void prName(Name n, int d) {
    say("Name("); say(n.id.toString()); say(")");
}

void prIdentifierList(IdentifierList il, int d) {
    sayln("IdentifierList(");
    if (il != null) {
        indent(d+1); say(il.id.toString()); sayln(",");
        prIdentifierList(il.next, d+1);
    }
    say(")");
}

// --- Parameters ---
void prParamList(ParamList p, int d) {
    sayln("ParamList(");
    if (p.head != null) {
        indent(d+1); prParamList(p.head, d+1); sayln(",");
    }
    indent(d+1); 
    if (p.type != null) prTy(p.type, d+1); sayln(",");
    if (p.name != null) say(p.name.toString());
    say(")");
}

// --- PointerList ---
void prPointerList(PointerList p, int d) {
    say("PointerList("); say(p.num); say(")");
}

// --- PostFixExp ---
void prExp(PostFixExp e, int d) {
    sayln("PostFixExp(");
    indent(d+1);
    switch(e.type) {
        case PostFixExp.PRIMARY_EXP: say("PRIMARY_EXP,"); sayln(""); prExp(e.exp, d+1); break;
        case PostFixExp.ARRAY: say("ARRAY,"); sayln(""); prExp(e.exp, d+1); sayln(","); prExp(e.index, d+1); break;
        case PostFixExp.FUNC_CALL: say("FUNC_CALL,"); sayln(""); prExp(e.exp, d+1); sayln(","); prExplist(e.args, d+1); break;
        case PostFixExp.FIELD_ACCESS: say("FIELD_ACCESS,"); sayln(""); prExp(e.exp, d+1); sayln(","); say(e.field.toString()); break;
        case PostFixExp.ARROW: say("ARROW,"); sayln(""); prExp(e.exp, d+1); sayln(","); say(e.field.toString()); break;
    }
    say(")");
}

void prStmtList(StmtList s, int d) {
    indent(d);
    say("StmtList("); 
    if (s!=null) {
      sayln("");
      indent(d+1);
      prStmt(s.head, d+1); sayln(",");
      prStmtList(s.tail, d+1);
    }
    say(")");
  }


  void prStructDeclarationList(StructDeclarationList s, int d) {
    indent(d);
    say("StructDeclarationList("); 
    if (s!=null) {
      sayln("");
      indent(d+1);
    }
    say(")");
  }

  void prTypeQualifierList(TypeQualifierList t, int d) {
    indent(d);
    say("TypeQualifierList("); 
    if (t!=null) {
      sayln("");
      indent(d+1);
      prExp(t.tail, d+1);
    }
    say(")");
  }

  void prExp(PrimaryExp e, int d) {
    sayln("PrimaryExp(");
    prExp(e.exp, d+1); say(")");
  }

  void prExp(UnaryExp e, int d) {
    sayln("UnaryExp(");
    prExp(e.exp, d+1); sayln(",");
   // prExp(e.oper, d+1); say(")");
   switch(e.oper){
    case(0): say("INCREMENT"); sayln(""); break;
    case(1): say("DECREMENT"); sayln(""); break;
    case(2): say("SIZEOF"); sayln(""); break;
   }
   say(")");
  }






//Nene's part



  void prExp(BinOp e, int d) {
    indent(d);
    say("BinaryOp(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prExp(e.left, d+1); sayln(",");
      indent(d+1);
      prExp(e.right, d+1);
    }
    say(")");
  }

  void prExp(BitFieldList e, int d) {
    indent(d);
    say("BitFieldList(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prExp(e.head, d+1); sayln(",");
      prExp(e.tail, d+1);
    }
    say(")");
  }

  void prExp(BitFieldValue e, int d) {
    indent(d);
    say("BitFieldValue(");
    if (e != null) {
      sayln("");
      indent(d+1);
      say(e.field.toString()); sayln(",");
      indent(d+1);
      prExp(e.value, d+1);
    }
    say(")");
  }

  void prExp(BracketsList e, int d) {
    indent(d);
    say("BracketsList(");
    if (e != null) {
      sayln("");
      indent(d+1);
     // prExp(e.emptyDimsCount, d+1); sayln(",");
      //prExp(e.sizedDims, d+1);
    }
    say(")");
  }

  void prExp(CastExp e, int d) {
    indent(d);
    say("CastExp(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prTy(e.type, d+1); sayln(",");
      indent(d+1);
      prExp(e.cast, d+1);
    }
    say(")");
  }

  void prExp(CompoundStmt e, int d) {
    indent(d);
    say("CompoundStatement(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prDecList(e.decs, d+1); sayln(",");
      indent(d+1);
      prStmt(e.stmts, d+1);
    }
    say(")");
  }

  void prExp(CondExp e, int d) {
    indent(d);
    say("ConditionalExp(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prExp(e.test, d+1); sayln(",");
      indent(d+1);
      prExp(e.thenExp, d+1); sayln(",");
      indent(d+1);
      prExp(e.elseExp, d+1);
    }
    say(")");
  }

  void prExp(EmptyArrayTypeList e, int d) {
    indent(d);
    say("EmptyArrayTypeList(");
    if (e != null) {
      sayln("");
      indent(d+1);
     // prExp(e.count, d+1); sayln(",");
  
    }
    say(")");
  }

  void prExp(Enumerator e, int d) {
    indent(d);
    say("Enumerator(");
    if (e != null) {
      sayln("");
      indent(d+1);
      say(e.name.toString());
      if (e.value != null) {
        sayln(",");
        indent(d+1);
        prExp(e.value, d+1);
      }
    }
    say(")");
  }

  void prExp(EnumeratorList e, int d) {
    indent(d);
    say("EnumeratorList(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prExp(e.head, d+1); sayln(",");
      prExp(e.tail, d+1);
    }
    say(")");
  }

 

  void prExp(ExpPart e, int d) {
    indent(d);
    say("ExoPart(");
    if (e != null) {
      sayln("");
      indent(d+1);
      say(e.exp.toString()); sayln(",");
      indent(d+1);
      prExp(e.exp, d+1);
    }
    say(")");
  }

  void prExp(ExpressionArrayType e, int d) {
    indent(d);
    say("ExpArrayType(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prTy(e.type, d+1);
    }
    say(")");
  }

  void prExp(ExpressionArrayTypeList e, int d) {
    indent(d);
    say("ExpArrayTypeList(");
    if (e != null) {
      sayln("");
      indent(d+1);
      prExp(e.head, d+1); sayln(",");
      prExp(e.tail, d+1);
    }
    say(")");
  }
}