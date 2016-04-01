grammar XPath10;

options
{
	k=4;	
	output=AST;
}

tokens {
  OR                = 'or'  ; 
  AND               = 'and' ; 
  MOD               = 'mod' ; 
  DIV               = 'div' ;
  	  	  
	LPAREN            =	'('   ;	
	RPAREN	          =	')'   ;
	LBRACKET	        = '['   ;	
	RBRACKET	        =	']'   ;		
	PIPE	            =	'|'   ;	
	DOT               = '.'   ;	
	DOT2              = '..'	;	
	AT                = '@'	  ;	
	COMMA             = ','   ;	
	COLON2            = '::'	;	
	COLON             = ':'	  ;	
	SLASH             = '/'   ;	
	SLASH2            =	'//'  ;	
	DOLLAR            = '$'	  ;	
	PLUS              = '+'		;	
	MINUS             = '-'		;
	
	EQ                = '='		;
	NE                = '!='	;	
	LT                = '<'		;	
	LTE               = '<='	;	
	GT                = '>'   ;	
	GTE               = '>='  ;	
	STAR              = '*'		;
	  
	// Pseudo Tokens.	     
  Args;
}


@header {   
   package org.eclipse.bpel.xpath10.parser;      
   import org.eclipse.bpel.xpath10.*;
   
}

@lexer::header {	 
	 package org.eclipse.bpel.xpath10.parser;	 
}

@members {
      
    boolean isNodeNodeName (String node) {
    		return "node".equals(node);
    }
    boolean isTextNodeName (String node) {
    	  return "text".equals(node);
    }
    boolean isCommentNodeName (String node) {
    	  return "comment".equals(node);
    }
    boolean isProcessingInstructionNodeName (String node) {
    	  return "processing-instruction".equals(node);
    }
      
    static int positionOf (Token token, boolean start) {
    		if (token instanceof CommonToken) {
    		    CommonToken t = (CommonToken)token;
    		    if (start) {
    		    		 return t.getStartIndex();    		    	   
    		    }
    		    return t.getStopIndex();
    		}
    		return -1;
    }
    
    static int positionOfIfUnset (Token token, boolean start, int currentValue) {
    		if (currentValue < 0) {
   					return positionOf(token,start); 		
    		}
    		return currentValue;
    }

	  public void displayRecognitionError(String[] tokenNames, RecognitionException re)
	  {		    
		    String msg = getErrorMessage(re, tokenNames);
		    // we don't recover
         throw new XPath10Exception(msg,re.getCause(),re.index);
	  }
	
}

@lexer::members {
	  public void displayRecognitionError(String[] tokenNames, RecognitionException re)
	  {		    
		    String msg = getErrorMessage(re, tokenNames);
		    // we don't recover
         throw new XPath10Exception(msg,re.getCause(),re.index);
	  }
}
//
// XPath 1.0 Grammer rules.
//

xpath	returns [Expr result]
		:	e=unionExpr
		    { $result = e.result; }	
		;

locationPath	returns [LocationPath result]:	
	aloc=absoluteLocationPath	
		{ $result=aloc.result; }
	|	rloc=relativeLocationPath
	  { $result=rloc.result; } 
	;

absoluteLocationPath	returns [LocationPath result]
@init {
	Step ans = null;
} :
		(op=SLASH2^ { 
		     ans=new AllNodeStep(Axis.DESCENDANT_OR_SELF); 
		     ans.setPosition(positionOf($op,true),positionOf($op,false)); } | op=SLASH^ ) 
		     
		    ( (AT|STAR|IDENTIFIER)=> loc=i_relativeLocationPath	{ $result = loc.result; }  |	{ $result = new LocationPath(true); } )		    
		     { if ($result != null) {
		          if (ans != null) { $result.addFirstStep(ans); }
		          $result.setIsAbsolute(true);
		       }
		     }
	;
			
relativeLocationPath returns [LocationPath result]:	
	 e=i_relativeLocationPath 
	    { $result = e.result; }	
	;

i_relativeLocationPath	returns [LocationPath result]:	
	  s1=step { $result=new LocationPath(false, s1.result); }
	     ( (op=SLASH2 { $result.addStep(new AllNodeStep(Axis.DESCENDANT_OR_SELF)); 
	                    $result.setPosition(positionOf($op,true),positionOf($op,false));
	                  } |SLASH ) s2=step  {$result.addStep(s2.result);} )* 	  
	  ;


// Step is:
//   NameStep
//   Special Step
//   Abbr Step
step returns [Step result]
@init {
	// default axis, per XPath spec.
	int anAxis  = Axis.CHILD;
	int posStart = -1;
	String aNs  = null;
	
}  :
		(
			// If it has an axis
			(	(IDENTIFIER COLON2 | AT) =>  axis { anAxis=$axis.axis; posStart = $axis.posStart;}  |	 /* Empty, no axis (default) */ )

			(
				(	(ns=IDENTIFIER COLON  { aNs=$ns.text; posStart=positionOfIfUnset($ns,true,posStart); } )? ( id=IDENTIFIER|id=STAR )	{				 
					          $result = new NameStep(anAxis,aNs,$id.text); 
					          $result.setPosition(positionOfIfUnset($id,true,posStart), positionOf($id,false));
				          } )
				|

				ss=specialStep {$result = ss.result; $result.setAxis(anAxis); }
				
			)	(	p=predicate	{$result.addPredicate(p.result);} )*
		)
				
		|	as=abbrStep {
		              $result=as.result; 
		              $result.setPosition(as.posStart,as.posEnd);
		             }  ( p=predicate {$result.addPredicate(p.result);} )*
	;


// special step copies the position in the token stream into the semantic tree 
// 
specialStep returns [Step result] 
@init {
   String piID = null;
} :
	{	isProcessingInstructionNodeName( input.LT(1).getText() ) }? 
			id=IDENTIFIER^ LPAREN! ( pi=IDENTIFIER {piID=$pi.text; } )?	rp=RPAREN! 
			  { $result = new ProcessingInstructionNodeStep(0, piID );
			    $result.setPosition(positionOf($id,true),positionOf($rp,false));
			  } 			  
			
	| { isCommentNodeName(input.LT(1).getText()) }? 	id=IDENTIFIER^ LPAREN! rp=RPAREN! 
	      { $result = new CommentNodeStep(Axis.CHILD); 
	        $result.setPosition(positionOf($id,true),positionOf($rp,false));
	      } 
	      	     
	|	{ isTextNodeName(input.LT(1).getText())  }?     id=IDENTIFIER^ LPAREN! rp=RPAREN! 
	      { $result = new TextNodeStep(Axis.CHILD);
	        $result.setPosition(positionOf($id,true),positionOf($rp,false)); 
	      }
	      
	|	{ isNodeNodeName(input.LT(1).getText())  }?     id=IDENTIFIER^ LPAREN! rp=RPAREN! 
	      { $result = new AllNodeStep(Axis.CHILD); 
	        $result.setPosition(positionOf($id,true),positionOf($rp,false));
	      }  	      
	        	      
	;

axis returns [int axis, int posStart, int posEnd ]: 
  	id=IDENTIFIER COLON2^	
  	    { $axis = Axis.getAxis( $id.text); 
  	      $posStart = positionOf($id,true);
  	      $posEnd   = positionOf($id,false);
  	    }
  	|	at=AT
  	    { $axis = Axis.ATTRIBUTE;
  	      $posStart = positionOf($at,true);
  	      $posEnd   = positionOf($at,false);
  	    }	  	
  	;

   
// ----------------------------------------
//		Section 2.4
//			Predicates
// ----------------------------------------

// .... production [8] ....
//
predicate	returns [Predicate result]:	
		LBRACKET^ e=predicateExpr RBRACKET!
		  { $result = e.result ; } 		
		;

// .... production [9] ....
//
predicateExpr	returns [Predicate result]
		: e=expr 
		   { $result = new Predicate(e.result) ; }
		;

// .... production [12] ....
// A location step of . is short for self::node().
// Similarly, a location step of .. is short for parent::node()
//
abbrStep returns [Step result, int posStart, int posEnd ]: 
	  d=DOT    { $result = new AllNodeStep(Axis.SELF);   $posStart = positionOf($d,true); $posEnd = $posStart+1; } 
	| d=DOT2   { $result = new AllNodeStep(Axis.PARENT); $posStart = positionOf($d,true); $posEnd = $posStart+2; }

;

// .... production [13] ....
//
abbrAxisSpecifier : ( AT )? ;


// ----------------------------------------
//		Section 3
//			Expressions
// ----------------------------------------

// ----------------------------------------
//		Section 3.1
//			Basics
// ----------------------------------------

// .... production [14] ....
//
expr returns [Expr result] 
		: e=orExpr 
			 { $result = $e.result ; } 
		;

// .... production [15] ....
//
primaryExpr returns [Expr result]:
			varRef=variableReference          { $result = varRef.result ; }
		|	LPAREN! exp=expr RPAREN!          { $result = exp.result; $result.setWrapParen(true);  }
		|	lit=literal                       { $result = lit.result ;}
		|	num=number                        { $result = num.result ; }
		|	fn=functionCall                   { $result = fn.result ; }
	;


literal returns [Expr result]
	: lit=LITERAL^
	  { $result = new LiteralExpr($lit.text) ; 
	    $result.setPosition (positionOf($lit,true),positionOf($lit,false) );
	  }
	;
	
number returns [Expr result]
   : num=NUMBER^
      { $result = new NumberExpr($num.text);
        $result.setPosition(positionOf($num,true),positionOf($num,false));
      }
   ;
    
variableReference	returns [Expr result]
		:	DOLLAR^ var=qName
				{ $result = new VariableReferenceExpr($var.prefix, $var.localName);
				  $result.setPosition( $var.startOffset, $var.endOffset );
				} 
		;

// ----------------------------------------
//		Section 3.2
//			Function Calls
// ----------------------------------------

// .... production [16] ....
//
functionCall returns [FunctionCallExpr result ]
    : qn=qName 
          { $result = new FunctionCallExpr($qn.prefix,$qn.localName);
            $result.setPosition ($qn.startOffset,$qn.endOffset); 
          } 
         LPAREN! ( list=argList { $result.getParameters().addAll(list.result); } )? RPAREN!       
    ;

// .... production [16.1] ....
//
argList returns [ List<Expr> result ]
@init {
   $result = new ArrayList<Expr>();
}	
		: a=argument { $result.add(a.result); } 
		  ( COMMA b=argument { $result.add(b.result); } )* 		  				 
       -> ^(Args argument+) ;

// .... production [17] ....
//
argument returns [Expr result]
			: e=expr 
				{ $result = e.result ; }
			;

// ----------------------------------------
//		Section 3.3
//			Node-sets
// ----------------------------------------

// .... production [18] ....
//
unionExpr returns [Expr result]
		:	(a=pathExpr) 
		    { $result = a.result; } 
		  ((op=PIPE^) b=pathExpr 
		    {$result = new UnionExpr($op.text,$unionExpr.result,b.result); }			    
		  )*	
		;
// .... production [19] ....
// TODO: Fix Slash2 //

pathExpr returns [Expr result] 
@init {
    Step ans = null;
}:
		loc=locationPath
		     { $result = $loc.result; }
		|	e=filterExpr { $result = e.result; } 
		     ( (SLASH|SLASH2 { ans=new AllNodeStep(Axis.DESCENDANT_OR_SELF);}) path=relativeLocationPath { 
		         $result = new PathExpr(e.result,path.result); 
		         if (ans != null) { path.result.addFirstStep(ans); } 
		     }	)? 		     
	;
	
// .... production [20] ....
//
filterExpr returns [Expr result]
@init {
	FilterExpr filter = null;
}
		:	e=primaryExpr	{ filter = new FilterExpr(e.result) ; } 
		      (	p=predicate	{filter.addPredicate(p.result); } )*
		      { $result = filter.hasPredicates() ? filter : filter.getExpr(); } 
		;


// ----------------------------------------
//		Section 3.4
//			Booleans
// ----------------------------------------

// .... production [21] ....
// orExpr:	andExpr (	OR^ andExpr	)* ;

orExpr returns [Expr result]
		:	(a=andExpr) 
		    { $result = $a.result; }				    
	       ((op=OR^) b=andExpr
	       	  { $result = new LogicalExpr($op.text, $orExpr.result, b.result); }	
	       )*
    ;
         
// .... production [22] ....
// andExpr	: 	equalityExpr (	AND^	equalityExpr )? ;

andExpr	returns [Expr result]
		: 	(a=equalityExpr) 
		        { $result = a.result; }  				        
           ((op=AND^)	b=equalityExpr
              { $result = new LogicalExpr($op.text,$andExpr.result,b.result); } 
           )*
    ;
             
// .... production [23] ....
// equalityExpr : relationalExpr ((EQ|NE)^ relationalExpr )?  ;
equalityExpr returns [Expr result] 
		: (a=relationalExpr) 
				{ $result = a.result; } 						
	          ((op=EQ^|op=NE^) b=relationalExpr
	              { $result = new EqualityExpr($op.text, $equalityExpr.result, b.result ); }
	          )*
	  ;
               
// .... production [24] ....
// relationalExpr	:	additiveExpr ((LT|GT|LTE|GTE)^ additiveExpr )? ;
relationalExpr returns [Expr result] 
		: (a=additiveExpr) // set result
		      { $result = a.result; }
            ((op=LT^|op=GT^|op=LTE^|op=GTE^) b=additiveExpr
            	{ $result = new RelationalExpr($op.text, $relationalExpr.result, b.result); }
            )*
    ;
// ----------------------------------------
//		Section 3.5
//			Numbers
// ----------------------------------------

// .... production [25] ....
//
// additiveExpr	:		multExpr ((PLUS^|MINUS^)	multExpr )?	;

additiveExpr returns [Expr result] 
	:  (a=multExpr) 
	      { $result = a.result; }    // set result
           ((op=PLUS^|op=MINUS^) b=multExpr
             { $result = new AdditiveExpr($op.text,$additiveExpr.result, b.result); }             
           )*
        ;
        
// .... production [26] ....
// multExpr	:	unaryExpr	(	(STAR^|	DIV^|	MOD^)	unaryExpr	)?	;
multExpr returns [Expr result] 
		:	(a=unaryExpr) 
		    { $result = a.result; }   // set result
         ((op=STAR^|op=DIV^|op=MOD^) b=unaryExpr
         		{ $result = new MultiplicativeExpr($op.text, $multExpr.result, b.result); }               
         )*
    ;

// .... production [27] ....
//
unaryExpr returns [UnaryExpr result] 
		:	u=unionExpr
		   { $result = new UnaryExpr(u.result); } 
		   
		|	op=MINUS n=unaryExpr
		   { 
		     $result = n.result;
		     $result.setOperand($op.text);
		     $result.setPosition(positionOf($op,true),-1);
		   }
	;


// QName
// When  no namespace is present, the default prefix is "", not null 

qName returns [String prefix, String localName , int startOffset, int endOffset ] 
@init {
	$prefix = "";
	$startOffset   = -1;
	$startOffset   = -1;
} :
     (p=IDENTIFIER COLON^ { $prefix=$p.text ; $startOffset = positionOf($p,true); })? 
        n=IDENTIFIER { $localName=$n.text;
	         if ($startOffset < 0) {
	             $startOffset = positionOf($n,true);
	         }
	         $endOffset = positionOf($n,false); 
         } 
   ;


// Lexer section. Convention is that rules which start with an uppercase letter are lexer rules.
WS : ('\n' | ' ' | '\t' | '\r')+		{	$channel=HIDDEN;}
	 ;
	 
fragment
DIGITS	:	'0'..'9'+;

fragment 
SINGLE_QUOTE_STRING	:	'\''! (~('\''))* '\''!	;

fragment
DOUBLE_QUOTE_STRING :	'"'! (~('"'))* '"'!	;

LITERAL :	SINGLE_QUOTE_STRING | DOUBLE_QUOTE_STRING	;

NUMBER : (DIGITS) ('.'DIGITS)? | '.' DIGITS 	;

IDENTIFIER : 	
		('\u0241'..'\u0377'|'a'..'z'|'A'..'Z'|'_') ('\u0241'..'\u0377'|'a'..'z'|'A'..'Z'|'-'|'_'|'0'..'9'|'.')*	
   ;
   
