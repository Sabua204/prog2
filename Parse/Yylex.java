package Parse;
import ErrorMsg.ErrorMsg;


class Yylex implements Lexer {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final char YYEOF = '\uFFFF';

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
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int STRING = 1;
	private final int YYINITIAL = 0;
	private final int COMMENT = 2;
	private final int CHAR = 3;
	private final int yy_state_dtrans[] = {
		0,
		106,
		114,
		-1
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private char yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YYEOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YYEOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_start () {
		++yychar;
		++yy_buffer_start;
	}
	private void yy_pushback () {
		--yy_buffer_end;
	}
	private void yy_mark_start () {
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
private int [][] unpackFromString(int size1, int size2, String st)
    {
      int colonIndex = -1;
      String lengthString;
      int sequenceLength = 0;
      int sequenceInteger = 0;
      int commaIndex;
      String workString;
      int res[][] = new int[size1][size2];
      for (int i= 0; i < size1; i++)
	for (int j= 0; j < size2; j++)
	  {
	    if (sequenceLength == 0) 
	      {	
		commaIndex = st.indexOf(',');
		if (commaIndex == -1)
		  workString = st;
		else
		  workString = st.substring(0, commaIndex);
		st = st.substring(commaIndex+1);
		colonIndex = workString.indexOf(':');
		if (colonIndex == -1)
		  {
		    res[i][j] = Integer.parseInt(workString);
		  }
		else 
		  {
		    lengthString = workString.substring(colonIndex+1);  
		    sequenceLength = Integer.parseInt(lengthString);
		    workString = workString.substring(0,colonIndex);
		    sequenceInteger = Integer.parseInt(workString);
		    res[i][j] = sequenceInteger;
		    sequenceLength--;
		  }
	      }
	    else 
	      {
		res[i][j] = sequenceInteger;
		sequenceLength--;
	      }
	  }
      return res;
    }
	private int yy_acpt[] = {
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NOT_ACCEPT,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR,
		YY_NO_ANCHOR
	};
	private int yy_cmap[] = {
		0, 0, 0, 0, 0, 0, 0, 0,
		1, 1, 2, 0, 0, 3, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		1, 4, 5, 0, 0, 6, 7, 8,
		9, 10, 11, 12, 13, 14, 15, 16,
		17, 18, 18, 18, 18, 18, 18, 18,
		19, 19, 20, 21, 22, 23, 24, 0,
		0, 25, 25, 25, 25, 25, 25, 26,
		26, 26, 26, 26, 26, 26, 26, 26,
		26, 26, 26, 26, 26, 26, 26, 26,
		26, 26, 26, 27, 28, 29, 30, 0,
		0, 31, 32, 33, 34, 35, 36, 37,
		38, 39, 26, 40, 41, 42, 43, 44,
		45, 26, 46, 47, 48, 49, 50, 51,
		52, 53, 54, 55, 56, 57, 58, 0
		
	};
	private int yy_rmap[] = {
		0, 1, 2, 1, 1, 3, 4, 1,
		1, 5, 6, 1, 7, 8, 9, 10,
		1, 1, 11, 12, 13, 1, 1, 14,
		1, 15, 1, 1, 1, 1, 1, 1,
		16, 1, 1, 1, 1, 1, 1, 1,
		1, 17, 18, 1, 1, 1, 19, 1,
		20, 21, 1, 1, 1, 1, 1, 22,
		1, 1, 21, 21, 21, 21, 21, 21,
		21, 21, 21, 21, 21, 21, 21, 21,
		21, 21, 21, 21, 21, 21, 21, 21,
		21, 21, 21, 21, 21, 21, 23, 1,
		1, 1, 1, 1, 1, 1, 1, 21,
		24, 25, 26, 27, 28, 29, 30, 31,
		32, 27, 33, 34, 35, 36, 37, 38,
		39, 40, 41, 42, 43, 44, 45, 46,
		47, 48, 49, 50, 51, 52, 53, 54,
		55, 56, 57, 58, 59, 60, 61, 62,
		63, 64, 65, 66, 67, 68, 69, 70,
		71, 72, 73, 74, 75, 76, 77, 78,
		79, 80, 81, 82, 83, 84, 85, 86,
		87, 88, 89, 90, 91, 92, 93, 94,
		95, 96, 97, 98, 99, 100, 101, 102,
		103, 104, 105, 106, 107, 108, 109, 110,
		111, 112, 113, 114, 115, 116, 117, 118,
		119, 120, 121, 122, 123, 124, 125, 126,
		127, 128, 129, 130, 131, 132, 133, 134,
		135, 136 
	};
	private int yy_nxt[][] = unpackFromString(137,59,
"1,2,3,1,96,4,5,6,101,7,8,9,10,11,12,13,14,15,97:2,16,17,18,19,20,95:2,21,1,22,23,168,191,169,100,170,141,171,95,103,95,172,95:4,204,192,209,193,142,194,95:3,24,25,26,27,-1:60,2,-1:80,29,-1:42,30,-1:15,31,-1:58,33,-1:47,34,-1:10,35,-1:49,36,-1:8,37,38,-1:49,102,-1:54,39,-1:4,104,-1:6,40,-1:52,41:2,95,-1:5,95:2,-1:4,95:21,105,95:2,-1:26,42,43,-1:58,44,-1:58,45,46,-1:57,47,-1:58,50,-1:32,51,-1:10,52,-1:67,41:2,95,-1:5,95:2,-1:4,95:24,-1:27,56,-1:58,57,-1:52,95:3,-1:5,95:2,-1:4,95:18,179,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:24,-1:17,55,-1:3,55:3,-1:5,55,-1:33,86:2,-1:2,86,-1,86:22,-1,86:30,-1:23,28,-1:52,97:3,-1:5,95:2,-1:4,95:24,-1:12,32,-1:19,32,-1:14,32,-1:2,32,-1,32,-1:23,55,-1:3,99:3,-1:5,99,95,-1:4,95:24,-1:21,95:3,-1:5,95:2,-1:4,95:13,48,95:10,-1:9,32,-1:11,32:3,-1:5,32:2,-1,98,-1:2,32:24,-1:19,53,-1:60,95:3,-1:5,95:2,-1:4,95:5,49,95:6,109,95:11,-1:4,104:2,54,104:56,86:2,-1:2,86,87,86:22,108,86:30,-1:17,95:3,-1:5,95:2,-1:4,95:15,58,95:8,-1:9,88,-1:22,89,-1:14,90,-1:4,91,-1:3,110,-1:23,95:3,-1:5,95:2,-1:4,95:17,59,95:6,-1:17,112,-1:3,112:3,-1:5,112,-1:50,95:3,-1:5,95:2,-1:4,95:15,60,95:8,-1:17,92,-1:3,92:3,-1:5,92,-1:50,95:3,-1:5,95:2,-1:4,95:13,61,95:10,-1:4,116:2,-1,116:8,118,116:47,-1:17,95:3,-1:5,95:2,-1:4,95:15,62,95:8,-1:4,93:11,-1,93:47,-1:17,95:3,-1:5,95:2,-1:4,95:4,63,95:19,-1:4,93:11,-1,93:4,94,93:42,-1:17,95:3,-1:5,95:2,-1:4,95:11,64,95:12,-1:21,95:3,-1:5,95:2,-1:4,95:13,65,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:6,66,95:17,-1:21,95:3,-1:5,95:2,-1:4,95:3,67,95:20,-1:21,95:3,-1:5,95:2,-1:4,95:9,68,95:14,-1:21,95:3,-1:5,95:2,-1:4,95:17,69,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:17,70,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:17,71,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:12,72,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:4,73,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:4,74,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:12,75,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:12,76,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:3,77,95:20,-1:21,95:3,-1:5,95:2,-1:4,95:5,78,95:18,-1:21,95:3,-1:5,95:2,-1:4,95:2,79,95:21,-1:21,95:3,-1:5,95:2,-1:4,95:17,80,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:5,81,95:18,-1:21,95:3,-1:5,95:2,-1:4,95:4,82,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:15,83,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:3,84,95:20,-1:21,95:3,-1:5,95:2,-1:4,95:4,85,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:10,175,95:2,107,95:10,-1:21,95:3,-1:5,95:2,-1:4,111,95:12,149,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:17,113,95:6,-1:21,95:3,-1:5,95:2,-1:4,115,95:23,-1:21,95:3,-1:5,95:2,-1:4,95:16,117,95:7,-1:21,95:3,-1:5,95:2,-1:4,95:18,119,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:17,120,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:12,121,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:8,122,95,208,95:13,-1:21,95:3,-1:5,95:2,-1:4,123,95:23,-1:21,95:3,-1:5,95:2,-1:4,95:16,124,200,95:6,-1:21,95:3,-1:5,95:2,-1:4,125,95:23,-1:21,95:3,-1:5,95:2,-1:4,95:15,126,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:13,127,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:10,128,95:13,-1:21,95:3,-1:5,95:2,-1:4,95:10,129,95:13,-1:21,95:3,-1:5,95:2,-1:4,95:15,130,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:15,131,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:4,132,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:13,133,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:8,134,95:15,-1:21,95:3,-1:5,95:2,-1:4,95:2,135,95:21,-1:21,95:3,-1:5,95:2,-1:4,95:4,136,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:18,137,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:4,138,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:4,139,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:10,140,95:13,-1:21,95:3,-1:5,95:2,-1:4,95:18,143,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:7,144,95:5,174,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:10,145,95,146,95:8,195,95:2,-1:21,95:3,-1:5,95:2,-1:4,95:13,147,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:13,148,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:4,150,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:12,151,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:13,152,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:13,153,95:10,-1:21,95:3,-1:5,95:2,-1:4,95:8,154,95:7,207,95:7,-1:21,95:3,-1:5,95:2,-1:4,95:8,155,95:15,-1:21,95:3,-1:5,95:2,-1:4,95,156,95:22,-1:21,95:3,-1:5,95:2,-1:4,95:4,157,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:18,158,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:12,159,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:4,160,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:17,161,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:18,162,95:5,-1:21,95:3,-1:5,95:2,-1:4,95:3,163,95:20,-1:21,95:3,-1:5,95:2,-1:4,95:12,164,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:17,165,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:12,166,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:8,167,95:15,-1:21,95:3,-1:5,95:2,-1:4,95:15,173,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:7,176,197,95:8,198,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:12,177,95:11,-1:21,95:3,-1:5,95:2,-1:4,95:7,178,95:16,-1:21,95:3,-1:5,95:2,-1:4,95:17,180,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:6,206,95:10,181,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:6,182,95:16,183,-1:21,95:3,-1:5,95:2,-1:4,184,95:14,185,95:8,-1:21,95:3,-1:5,95:2,-1:4,95:4,186,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:8,187,95:15,-1:21,95:3,-1:5,95:2,-1:4,95:16,188,95:7,-1:21,95:3,-1:5,95:2,-1:4,95:6,189,95:17,-1:21,95:3,-1:5,95:2,-1:4,95:17,190,95:6,-1:21,95:3,-1:5,95:2,-1:4,95:4,196,95:19,-1:21,95:3,-1:5,95:2,-1:4,95:14,199,95:9,-1:21,95:3,-1:5,95:2,-1:4,95:8,201,95:15,-1:21,95:3,-1:5,95:2,-1:4,95:8,202,95:15,-1:21,95:3,-1:5,95:2,-1:4,203,95:23,-1:21,95:3,-1:5,95:2,-1:4,95:22,205,95,-1:4");
	public java_cup.runtime.Symbol nextToken ()
		throws java.io.IOException {
		char yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			if (YYEOF != yy_lookahead) {
				yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YYEOF == yy_lookahead && true == yy_initial) {

	{
	 return tok(sym.EOF, null);
        }
				}
				else if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_to_mark();
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_pushback();
					}
					if (0 != (YY_START & yy_anchor)) {
						yy_move_start();
					}
					switch (yy_last_accept_state) {
					case 0:
						{return tok(sym.ID, yytext());}
					case -2:
						break;
					case 1:
						{ err("Illegal character: " + yytext()); }
					case -3:
						break;
					case 2:
						{}
					case -4:
						break;
					case 3:
						{newline();}
					case -5:
						break;
					case 4:
						{yybegin(STRING);}
					case -6:
						break;
					case 5:
						{return tok(sym.MODULUS);}
					case -7:
						break;
					case 6:
						{return tok(sym.BITWISEAND);}
					case -8:
						break;
					case 7:
						{return tok(sym.LPAREN);}
					case -9:
						break;
					case 8:
						{ return tok(sym.RPAREN);}
					case -10:
						break;
					case 9:
						{return tok(sym.TIMES);}
					case -11:
						break;
					case 10:
						{return tok(sym.PLUS);}
					case -12:
						break;
					case 11:
						{return tok(sym.COMMA);}
					case -13:
						break;
					case 12:
						{return tok(sym.MINUS);}
					case -14:
						break;
					case 13:
						{return tok(sym.PERIOD);}
					case -15:
						break;
					case 14:
						{return tok(sym.DIVIDE);}
					case -16:
						break;
					case 15:
						{return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext()));}
					case -17:
						break;
					case 16:
						{return tok(sym.COLON);}
					case -18:
						break;
					case 17:
						{ return tok(sym.SEMICOLON); }
					case -19:
						break;
					case 18:
						{return tok(sym.LT);}
					case -20:
						break;
					case 19:
						{return tok(sym.ASSIGN);}
					case -21:
						break;
					case 20:
						{return tok(sym.GT);}
					case -22:
						break;
					case 21:
						{ return tok(sym.LBRACK); }
					case -23:
						break;
					case 22:
						{ return tok(sym.RBRACK); }
					case -24:
						break;
					case 23:
						{return tok(sym.BWISEXOR);}
					case -25:
						break;
					case 24:
						{ return tok(sym.LBRACE); }
					case -26:
						break;
					case 25:
						{return tok(sym.BWISEOR);}
					case -27:
						break;
					case 26:
						{ return tok(sym.RBRACE); }
					case -28:
						break;
					case 27:
						{return tok(sym.TILDE);}
					case -29:
						break;
					case 28:
						{return tok(sym.NEQ);}
					case -30:
						break;
					case 29:
						{return tok(sym.MODASSIGN);}
					case -31:
						break;
					case 30:
						{return tok(sym.AND);}
					case -32:
						break;
					case 31:
						{return tok(sym.BWISEANDASSIGN);}
					case -33:
						break;
					case 33:
						{return tok(sym.MULASSIGN);}
					case -34:
						break;
					case 34:
						{return tok(sym.INCREMENT);}
					case -35:
						break;
					case 35:
						{return tok(sym.ADDASSIGN);}
					case -36:
						break;
					case 36:
						{return tok(sym.DECREMENT);}
					case -37:
						break;
					case 37:
						{return tok(sym.SUBASSIGN);}
					case -38:
						break;
					case 38:
						{return tok(sym.ARROW);}
					case -39:
						break;
					case 39:
						{yybegin(COMMENT);}
					case -40:
						break;
					case 40:
						{return tok(sym.DIVASSIGN);}
					case -41:
						break;
					case 41:
						{return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext().substring(1),8));}
					case -42:
						break;
					case 42:
						{return tok(sym.LSHIFT);}
					case -43:
						break;
					case 43:
						{return tok(sym.LE);}
					case -44:
						break;
					case 44:
						{return tok(sym.EQ);}
					case -45:
						break;
					case 45:
						{return tok(sym.GE);}
					case -46:
						break;
					case 46:
						{return tok(sym.RSHIFT);}
					case -47:
						break;
					case 47:
						{return tok(sym.BWISEXORASSIGN);}
					case -48:
						break;
					case 48:
						{ return tok(sym.DO); }
					case -49:
						break;
					case 49:
						{ return tok(sym.IF); }
					case -50:
						break;
					case 50:
						{return tok(sym.BWISEORASSIGN);}
					case -51:
						break;
					case 51:
						{return tok(sym.OR);}
					case -52:
						break;
					case 52:
						{return tok(sym.CHAR_LITERAL, yytext());}
					case -53:
						break;
					case 53:
						{ return tok(sym.ELIPSIS); }
					case -54:
						break;
					case 54:
						{}
					case -55:
						break;
					case 55:
						{return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext().substring(2),16));}
					case -56:
						break;
					case 56:
						{return tok(sym.LSHIFTASSIGN);}
					case -57:
						break;
					case 57:
						{return tok(sym.RSHIFTASSIGN);}
					case -58:
						break;
					case 58:
						{ return tok(sym.FOR); }
					case -59:
						break;
					case 59:
						{return tok(sym.INT); }
					case -60:
						break;
					case 60:
						{ return tok(sym.VAR); }
					case -61:
						break;
					case 61:
						{return tok(sym.AUTO); }
					case -62:
						break;
					case 62:
						{ return tok(sym.CHAR); }
					case -63:
						break;
					case 63:
						{ return tok(sym.ELSE); }
					case -64:
						break;
					case 64:
						{ return tok(sym.ENUM); }
					case -65:
						break;
					case 65:
						{ return tok(sym.GOTO); }
					case -66:
						break;
					case 66:
						{ return tok(sym.LONG); }
					case -67:
						break;
					case 67:
						{ return tok(sym.VOID); }
					case -68:
						break;
					case 68:
						{ return tok(sym.BREAK); }
					case -69:
						break;
					case 69:
						{ return tok(sym.CONST); }
					case -70:
						break;
					case 70:
						{ return tok(sym.FLOAT); }
					case -71:
						break;
					case 71:
						{ return tok(sym.SHORT); }
					case -72:
						break;
					case 72:
						{ return tok(sym.UNION); }
					case -73:
						break;
					case 73:
						{ return tok(sym.WHILE); }
					case -74:
						break;
					case 74:
						{return tok(sym.DOUBLE);}
					case -75:
						break;
					case 75:
						{ return tok(sym.EXTERN); }
					case -76:
						break;
					case 76:
						{ return tok(sym.RETURN); }
					case -77:
						break;
					case 77:
						{ return tok(sym.SIGNED); }
					case -78:
						break;
					case 78:
						{ return tok(sym.SIZEOF); }
					case -79:
						break;
					case 79:
						{ return tok(sym.STATIC); }
					case -80:
						break;
					case 80:
						{return tok(sym.STRUCT);}
					case -81:
						break;
					case 81:
						{ return tok(sym.TYPEDEF); }
					case -82:
						break;
					case 82:
						{ return tok(sym.CONTINUE); }
					case -83:
						break;
					case 83:
						{ return tok(sym.REGISTER); }
					case -84:
						break;
					case 84:
						{ return tok(sym.UNSIGNED); }
					case -85:
						break;
					case 85:
						{ return tok(sym.VOLATILE); }
					case -86:
						break;
					case 86:
						{ string.append(yytext());}
					case -87:
						break;
					case 87:
						{ 
   {yybegin(YYINITIAL);
      return tok(sym.STRING_LITERAL, string.toString());}
}
					case -88:
						break;
					case 88:
						{ string.append('\"'); }
					case -89:
						break;
					case 89:
						{ string.append('\\'); }
					case -90:
						break;
					case 90:
						{ string.append('\n'); }
					case -91:
						break;
					case 91:
						{ string.append('\t'); }
					case -92:
						break;
					case 92:
						{
 String hex = yytext().substring(2);
 int val = Integer.parseInt(hex,16);
 char cast = (char) val;
 string.append("");
}
					case -93:
						break;
					case 93:
						{ }
					case -94:
						break;
					case 94:
						{yybegin(YYINITIAL);}
					case -95:
						break;
					case 95:
						{return tok(sym.ID, yytext());}
					case -96:
						break;
					case 96:
						{ err("Illegal character: " + yytext()); }
					case -97:
						break;
					case 97:
						{return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext()));}
					case -98:
						break;
					case 99:
						{return tok(sym.DECIMAL_LITERAL,Integer.parseInt(yytext().substring(2),16));}
					case -99:
						break;
					case 100:
						{return tok(sym.ID, yytext());}
					case -100:
						break;
					case 101:
						{ err("Illegal character: " + yytext()); }
					case -101:
						break;
					case 103:
						{return tok(sym.ID, yytext());}
					case -102:
						break;
					case 105:
						{return tok(sym.ID, yytext());}
					case -103:
						break;
					case 107:
						{return tok(sym.ID, yytext());}
					case -104:
						break;
					case 109:
						{return tok(sym.ID, yytext());}
					case -105:
						break;
					case 111:
						{return tok(sym.ID, yytext());}
					case -106:
						break;
					case 113:
						{return tok(sym.ID, yytext());}
					case -107:
						break;
					case 115:
						{return tok(sym.ID, yytext());}
					case -108:
						break;
					case 117:
						{return tok(sym.ID, yytext());}
					case -109:
						break;
					case 119:
						{return tok(sym.ID, yytext());}
					case -110:
						break;
					case 120:
						{return tok(sym.ID, yytext());}
					case -111:
						break;
					case 121:
						{return tok(sym.ID, yytext());}
					case -112:
						break;
					case 122:
						{return tok(sym.ID, yytext());}
					case -113:
						break;
					case 123:
						{return tok(sym.ID, yytext());}
					case -114:
						break;
					case 124:
						{return tok(sym.ID, yytext());}
					case -115:
						break;
					case 125:
						{return tok(sym.ID, yytext());}
					case -116:
						break;
					case 126:
						{return tok(sym.ID, yytext());}
					case -117:
						break;
					case 127:
						{return tok(sym.ID, yytext());}
					case -118:
						break;
					case 128:
						{return tok(sym.ID, yytext());}
					case -119:
						break;
					case 129:
						{return tok(sym.ID, yytext());}
					case -120:
						break;
					case 130:
						{return tok(sym.ID, yytext());}
					case -121:
						break;
					case 131:
						{return tok(sym.ID, yytext());}
					case -122:
						break;
					case 132:
						{return tok(sym.ID, yytext());}
					case -123:
						break;
					case 133:
						{return tok(sym.ID, yytext());}
					case -124:
						break;
					case 134:
						{return tok(sym.ID, yytext());}
					case -125:
						break;
					case 135:
						{return tok(sym.ID, yytext());}
					case -126:
						break;
					case 136:
						{return tok(sym.ID, yytext());}
					case -127:
						break;
					case 137:
						{return tok(sym.ID, yytext());}
					case -128:
						break;
					case 138:
						{return tok(sym.ID, yytext());}
					case -129:
						break;
					case 139:
						{return tok(sym.ID, yytext());}
					case -130:
						break;
					case 140:
						{return tok(sym.ID, yytext());}
					case -131:
						break;
					case 141:
						{return tok(sym.ID, yytext());}
					case -132:
						break;
					case 142:
						{return tok(sym.ID, yytext());}
					case -133:
						break;
					case 143:
						{return tok(sym.ID, yytext());}
					case -134:
						break;
					case 144:
						{return tok(sym.ID, yytext());}
					case -135:
						break;
					case 145:
						{return tok(sym.ID, yytext());}
					case -136:
						break;
					case 146:
						{return tok(sym.ID, yytext());}
					case -137:
						break;
					case 147:
						{return tok(sym.ID, yytext());}
					case -138:
						break;
					case 148:
						{return tok(sym.ID, yytext());}
					case -139:
						break;
					case 149:
						{return tok(sym.ID, yytext());}
					case -140:
						break;
					case 150:
						{return tok(sym.ID, yytext());}
					case -141:
						break;
					case 151:
						{return tok(sym.ID, yytext());}
					case -142:
						break;
					case 152:
						{return tok(sym.ID, yytext());}
					case -143:
						break;
					case 153:
						{return tok(sym.ID, yytext());}
					case -144:
						break;
					case 154:
						{return tok(sym.ID, yytext());}
					case -145:
						break;
					case 155:
						{return tok(sym.ID, yytext());}
					case -146:
						break;
					case 156:
						{return tok(sym.ID, yytext());}
					case -147:
						break;
					case 157:
						{return tok(sym.ID, yytext());}
					case -148:
						break;
					case 158:
						{return tok(sym.ID, yytext());}
					case -149:
						break;
					case 159:
						{return tok(sym.ID, yytext());}
					case -150:
						break;
					case 160:
						{return tok(sym.ID, yytext());}
					case -151:
						break;
					case 161:
						{return tok(sym.ID, yytext());}
					case -152:
						break;
					case 162:
						{return tok(sym.ID, yytext());}
					case -153:
						break;
					case 163:
						{return tok(sym.ID, yytext());}
					case -154:
						break;
					case 164:
						{return tok(sym.ID, yytext());}
					case -155:
						break;
					case 165:
						{return tok(sym.ID, yytext());}
					case -156:
						break;
					case 166:
						{return tok(sym.ID, yytext());}
					case -157:
						break;
					case 167:
						{return tok(sym.ID, yytext());}
					case -158:
						break;
					case 168:
						{return tok(sym.ID, yytext());}
					case -159:
						break;
					case 169:
						{return tok(sym.ID, yytext());}
					case -160:
						break;
					case 170:
						{return tok(sym.ID, yytext());}
					case -161:
						break;
					case 171:
						{return tok(sym.ID, yytext());}
					case -162:
						break;
					case 172:
						{return tok(sym.ID, yytext());}
					case -163:
						break;
					case 173:
						{return tok(sym.ID, yytext());}
					case -164:
						break;
					case 174:
						{return tok(sym.ID, yytext());}
					case -165:
						break;
					case 175:
						{return tok(sym.ID, yytext());}
					case -166:
						break;
					case 176:
						{return tok(sym.ID, yytext());}
					case -167:
						break;
					case 177:
						{return tok(sym.ID, yytext());}
					case -168:
						break;
					case 178:
						{return tok(sym.ID, yytext());}
					case -169:
						break;
					case 179:
						{return tok(sym.ID, yytext());}
					case -170:
						break;
					case 180:
						{return tok(sym.ID, yytext());}
					case -171:
						break;
					case 181:
						{return tok(sym.ID, yytext());}
					case -172:
						break;
					case 182:
						{return tok(sym.ID, yytext());}
					case -173:
						break;
					case 183:
						{return tok(sym.ID, yytext());}
					case -174:
						break;
					case 184:
						{return tok(sym.ID, yytext());}
					case -175:
						break;
					case 185:
						{return tok(sym.ID, yytext());}
					case -176:
						break;
					case 186:
						{return tok(sym.ID, yytext());}
					case -177:
						break;
					case 187:
						{return tok(sym.ID, yytext());}
					case -178:
						break;
					case 188:
						{return tok(sym.ID, yytext());}
					case -179:
						break;
					case 189:
						{return tok(sym.ID, yytext());}
					case -180:
						break;
					case 190:
						{return tok(sym.ID, yytext());}
					case -181:
						break;
					case 191:
						{return tok(sym.ID, yytext());}
					case -182:
						break;
					case 192:
						{return tok(sym.ID, yytext());}
					case -183:
						break;
					case 193:
						{return tok(sym.ID, yytext());}
					case -184:
						break;
					case 194:
						{return tok(sym.ID, yytext());}
					case -185:
						break;
					case 195:
						{return tok(sym.ID, yytext());}
					case -186:
						break;
					case 196:
						{return tok(sym.ID, yytext());}
					case -187:
						break;
					case 197:
						{return tok(sym.ID, yytext());}
					case -188:
						break;
					case 198:
						{return tok(sym.ID, yytext());}
					case -189:
						break;
					case 199:
						{return tok(sym.ID, yytext());}
					case -190:
						break;
					case 200:
						{return tok(sym.ID, yytext());}
					case -191:
						break;
					case 201:
						{return tok(sym.ID, yytext());}
					case -192:
						break;
					case 202:
						{return tok(sym.ID, yytext());}
					case -193:
						break;
					case 203:
						{return tok(sym.ID, yytext());}
					case -194:
						break;
					case 204:
						{return tok(sym.ID, yytext());}
					case -195:
						break;
					case 205:
						{return tok(sym.ID, yytext());}
					case -196:
						break;
					case 206:
						{return tok(sym.ID, yytext());}
					case -197:
						break;
					case 207:
						{return tok(sym.ID, yytext());}
					case -198:
						break;
					case 208:
						{return tok(sym.ID, yytext());}
					case -199:
						break;
					case 209:
						{return tok(sym.ID, yytext());}
					case -200:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
					}
				}
			}
		}
	}
}
