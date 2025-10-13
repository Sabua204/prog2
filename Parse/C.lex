package Parse;
import ErrorMsg.ErrorMsg;

%% 

%implements Lexer
%function nextToken
%type java_cup.runtime.Symbol
%char

%{
private void newline() {
  errorMsg.newline(yychar);
}

private void err(int pos, String s) {
  errorMsg.error(pos,s);
}

private void err(String s) {
  err(yychar,s);
}

private java_cup.runtime.Symbol tok(int kind) {
    return tok(kind, null);
}

private java_cup.runtime.Symbol tok(int kind, Object value) {
    return new java_cup.runtime.Symbol(kind, yychar, yychar+yylength(), value);
}

private ErrorMsg errorMsg;

Yylex(java.io.InputStream s, ErrorMsg e) {
  this(s);
  errorMsg=e;
}


StringBuffer string = new StringBuffer();
java_cup.runtime.Symbol tok = null;
%}

%state STRING,COMMENT,CHAR

%eofval{
	{
	 return tok(sym.EOF, null);
        }
%eofval} 




NONDIGIT=[a-zA-Z]
DIGIT=0|[1-9][0-9]*
HEX=0x([0-9,A-F]+)
HEX_ESC=\\x[0-9,A-F][0-9,A-F]
OCTAL=0([0-7]+)
NONNEWLINE_WHITE_SPACE_CHARACTER=[\t\ \b]
WHITE_SPACE_CHARACTER=[\n\ \t\b]
ID={NONDIGIT}|({NONDIGIT}|{DIGIT})*
CHARA={NONDIGIT}|[0-9]|(\\n|\\t|\\r|\\\\|\\'|\")
CHARACTER=\'({CHARA})\'
ASCII=ASCII=[0-9]+


%%

<YYINITIAL> {NONNEWLINE_WHITE_SPACE_CHARACTER}+	{} 
<YYINITIAL> \n	{newline();}

<YYINITIAL> "/*" {yybegin(COMMENT);}
<COMMENT> "*/" {yybegin(YYINITIAL);}
<COMMENT> .[^*] { }

<YYINITIAL> "//".*\n {}

<YYINITIAL>   auto {return tok(sym.AUTO); }
<YYINITIAL>  double {return tok(sym.DOUBLE);}
<YYINITIAL> int {return tok(sym.INT); }
<YYINITIAL>  struct {return tok(sym.STRUCT);}
<YYINITIAL>  break { return tok(sym.BREAK); }
<YYINITIAL> else { return tok(sym.ELSE); }
<YYINITIAL>  long { return tok(sym.LONG); }

<YYINITIAL> enum   { return tok(sym.ENUM); }
<YYINITIAL> register { return tok(sym.REGISTER); }
<YYINITIAL>  typedef  { return tok(sym.TYPEDEF); }
<YYINITIAL>  char     { return tok(sym.CHAR); }
<YYINITIAL>  extern   { return tok(sym.EXTERN); }
<YYINITIAL>  return { return tok(sym.RETURN); }
<YYINITIAL>  union  { return tok(sym.UNION); }
<YYINITIAL> const   { return tok(sym.CONST); }
<YYINITIAL> float    { return tok(sym.FLOAT); }
<YYINITIAL>  short   { return tok(sym.SHORT); }
<YYINITIAL>  unsigned { return tok(sym.UNSIGNED); }
<YYINITIAL>  continue { return tok(sym.CONTINUE); }
<YYINITIAL>  for { return tok(sym.FOR); }
<YYINITIAL> signed   { return tok(sym.SIGNED); }
<YYINITIAL> void     { return tok(sym.VOID); }

<YYINITIAL>  goto  { return tok(sym.GOTO); }
<YYINITIAL>  sizeof   { return tok(sym.SIZEOF); }
<YYINITIAL>  volatile { return tok(sym.VOLATILE); }
<YYINITIAL> do  { return tok(sym.DO); }
<YYINITIAL>  if   { return tok(sym.IF); }
<YYINITIAL>   static   { return tok(sym.STATIC); }
<YYINITIAL>  while { return tok(sym.WHILE); }
<YYINITIAL>  var   { return tok(sym.VAR); }    


<YYINITIAL>  "{"  { return tok(sym.LBRACE); }
<YYINITIAL>  "}"   { return tok(sym.RBRACE); }

<YYINITIAL>  ;   { return tok(sym.SEMICOLON); }

<YYINITIAL> "["  { return tok(sym.LBRACK); }
<YYINITIAL> "]"  { return tok(sym.RBRACK); }

<YYINITIAL> "(" {return tok(sym.LPAREN);}
<YYINITIAL> ")" { return tok(sym.RPAREN);}
<YYINITIAL> , {return tok(sym.COMMA);}
<YYINITIAL> : {return tok(sym.COLON);}

<YYINITIAL> "." {return tok(sym.PERIOD);}
<YYINITIAL> "->" {return tok(sym.ARROW);}
<YYINITIAL> "++" {return tok(sym.INCREMENT);}
<YYINITIAL> "--" {return tok(sym.DECREMENT);}
<YYINITIAL> "*" {return tok(sym.TIMES);}
<YYINITIAL> "+" {return tok(sym.PLUS);}
<YYINITIAL> "-" {return tok(sym.MINUS);}
<YYINITIAL> "~" {return tok(sym.TILDE);}
<YYINITIAL> sizeof {return tok(sym.SIZEOF);}
<YYINITIAL> "/" {return tok(sym.DIVIDE);}
<YYINITIAL> "%" {return tok(sym.MODULUS);}
<YYINITIAL> "<<" {return tok(sym.LSHIFT);}
<YYINITIAL> ">>" {return tok(sym.RSHIFT);}
<YYINITIAL> "<=" {return tok(sym.LE);}
<YYINITIAL> ">=" {return tok(sym.GE);}
<YYINITIAL> "<" {return tok(sym.LT);}
<YYINITIAL> ">" {return tok(sym.GT);}
<YYINITIAL> "==" {return tok(sym.EQ);}
<YYINITIAL> "!=" {return tok(sym.NEQ);}
<YYINITIAL> "^" {return tok(sym.BWISEXOR);}
<YYINITIAL> "&&" {return tok(sym.AND);}
<YYINITIAL> "&" {return tok(sym.BITWISEAND);}
<YYINITIAL> "||" {return tok(sym.OR);}
<YYINITIAL> "|" {return tok(sym.BWISEOR);}

<YYINITIAL> : {return tok(sym.COLON);}
<YYINITIAL> "*=" {return tok(sym.MULASSIGN);}
<YYINITIAL> "/=" {return tok(sym.DIVASSIGN);}
<YYINITIAL> "%=" {return tok(sym.MODASSIGN);}
<YYINITIAL> "+=" {return tok(sym.ADDASSIGN);}
<YYINITIAL> "-=" {return tok(sym.SUBASSIGN);}
<YYINITIAL> "<<=" {return tok(sym.LSHIFTASSIGN);}
<YYINITIAL> ">>=" {return tok(sym.RSHIFTASSIGN);}
<YYINITIAL> "&=" {return tok(sym.BWISEANDASSIGN);}
<YYINITIAL> "^=" {return tok(sym.BWISEXORASSIGN);}
<YYINITIAL> "|=" {return tok(sym.BWISEORASSIGN);}
<YYINITIAL> "=" {return tok(sym.ASSIGN);}
<YYINITIAL>  "..." { return tok(sym.ELIPSIS); }


<YYINITIAL> {DIGIT} {return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext()));}

<YYINITIAL> {HEX} {return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext().substring(2),16));}
<YYINITIAL> {OCTAL} {return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext().substring(1),8));}

<YYINITIAL> {ID} {return tok(sym.ID, yytext());}


<YYINITIAL> \" {yybegin(STRING);}
<STRING> \"  { 
  
   {yybegin(YYINITIAL);
      return tok(sym.STRING_LITERAL, string.toString());}
} 
<STRING>[^\n\r\"\\]+ { string.append(yytext());}
<STRING> {HEX_ESC} 
{
 String hex = yytext().substring(2);
 int val = Integer.parseInt(hex,16);
 char cast = (char) val;
 string.append("");
}
<STRING>\\n { string.append('\n'); }
<STRING>\\t { string.append('\t'); }
<STRING>\\\\ { string.append('\\'); }
<STRING>\\\" { string.append('\"'); }

<YYINITIAL> {CHARACTER} {return tok(sym.CHAR_LITERAL, yytext());}

<STRING> {ASCII}
 {
    int val = Integer.parseInt(yytext());
    if(val<0 || val>127){
      err("No.")
    }
    char cast = (char) val;
    return tok(sym.CHAR_LITERAL);
}

<YYINITIAL> . { err("Illegal character: " + yytext()); }


