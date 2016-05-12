/* *** This file is given as part of the programming assignment. *** */

public class Parser {

  // tok is global to all these parsing methods;
  // scan just calls the scanner's scan method and saves the result in tok.
  private Token tok; // the current token
  
  private void scan() {
	  tok = scanner.scan();
  }

  private Scan scanner;
  
  Parser(Scan scanner) {
	  this.scanner = scanner;
	  scan();
	  program();
	  if( tok.kind != TK.EOF )
	      parse_error("junk after logical end of program");
  }

  private void program() {
	  block();
  }

  private void block(){
	  declaration_list();
	  statement_list();
  }

  private void declaration_list() {
  	// below checks whether tok is in first set of declaration.
  	// here, that's easy since there's only one token kind in the set.
  	// in other places, though, there might be more.
  	// so, you might want to write a general function to handle that.
  	
  	// The empty set case is automatically taken care of
  	// by having no error message when no token is present.
  	// The "while(is)" represents {} in EBNF
  	while( is(TK.DECLARE) ) {
  	    declaration();
  	}
  }

  private void declaration() {
  	mustbe(TK.DECLARE);
  	mustbe(TK.ID);
  	while( is(TK.COMMA) ) {
  	    scan();
  	    mustbe(TK.ID);
  	}
  }

  private void statement_list() {
    while( is(TK.TILDE) || is(TK.ID) || is(TK.PRINT) || is(TK.DO) || is(TK.IF)) {
      statement();
    }
  }
  
  private void statement() {
    if ( is(TK.TILDE) || is(TK.ID) ) {
      assignment();
    }
    else if ( is(TK.PRINT) ) {
      print();
    }
    else if ( is(TK.DO) ) {
      Do();   // cannotbe do() because do is a reserved word
    }
    else {
      If();   // cannotbe if() because if is a reserved word
    }
  }
  
  private void assignment() {
    ref_id();
    mustbe(TK.ASSIGN);
    expression();
  }
  
  private void ref_id() {
    if ( is(TK.TILDE) ) {
      scan(); //skip the '~' and scan for the next thing
      if ( is(TK.NUM) ) {
        scan();
        mustbe(TK.ID);
      }
      else {
        mustbe(TK.ID);
      }
    }
    else {
      mustbe(TK.ID);
    }
  }
  
  private void print() {
    mustbe(TK.PRINT);
    expression(); // after the '!' there must be an expression
  }
  
  private void expression() {
    term();
    while ( is(TK.PLUS) || is(TK.MINUS) ) {
      addop();
      term();
    }
  }
  
  private void term() {
    factor();
    while ( is(TK.TIMES) || is(TK.DIVIDE) ) {
      multop();
      factor();
    }
  }
  
  private void addop() {
    if ( is(TK.PLUS) ) {
      scan();
    }
    else {
      mustbe(TK.MINUS);
    }
  }
  
  private void multop () {
    if ( is(TK.TIMES) ) {
      scan();
    }
    else {
      mustbe(TK.DIVIDE);
    }
  }
  
  private void factor() {
    if ( is(TK.LPAREN) ) {
      scan();
      expression();
      mustbe(TK.RPAREN);
    }
    else if ( is(TK.TILDE) || is(TK.ID) ) {
      ref_id();
    }
    else {
      mustbe(TK.NUM);
    }
  }
  
  private void Do() {
    mustbe(TK.DO);
    guarded_command();
    mustbe(TK.ENDDO);
  }
  
  private void If() {
    mustbe(TK.IF);
    guarded_command();
    while ( is(TK.ELSEIF) ) {
      scan();
      guarded_command();
    }
    
    if ( is(TK.ELSE) ) {
      scan();
      block();
    }
    mustbe(TK.ENDIF);
  }
  
  private void guarded_command() {
    expression();
    mustbe(TK.THEN);
    block();
  }

  // is current token what we want?
  private boolean is(TK tk) {
    return tk == tok.kind;
  }

  // ensure current token is tk and skip over it.
  private void mustbe(TK tk) {
	  if( tok.kind != tk ) {
	    System.err.println( "mustbe: want " + tk + ", got " + tok);
	    parse_error( "missing token (mustbe)" );
	  }
	  scan();
  }

  private void parse_error(String msg) {
	  System.err.println( "can't parse: line " + tok.lineNumber + " " + msg );
	  System.exit(1);
  }


} //end Parser class
