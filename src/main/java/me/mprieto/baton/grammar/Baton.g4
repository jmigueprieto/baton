parser grammar Baton;

options { tokenVocab = BatonLexer; }

batonUnit
    : (structDeclaration | taskDeclaration)* workflowDeclaration EOF
    ;

structDeclaration
    : STRUCT IDENTIFIER structDef
    ;

structDef
    : LBRACE keyTypePair? (COMMA keyTypePair)* RBRACE;

keyTypePair
    : key COLON (type            // Basic types e.g.: String, Boolean
                | IDENTIFIER    // named type
                | structDef)    // nested struct
    ;

//TODO how do we define an array of X?
type
    : TYPE_BOOLEAN
    | TYPE_STRING
    | TYPE_INTEGER
    | TYPE_DECIMAL
    ;

taskDeclaration
    : TASK IDENTIFIER taskParams
    ;

taskParams
    : LBRACE metadataParams RBRACE
    ;
    
workflowDeclaration
    : WORKFLOW IDENTIFIER workflowParams? (COLON workflowOutput)? block
    ;

workflowParams
    : LPAREN metadataParams RPAREN
    ;

workflowOutput
    : structDef | IDENTIFIER
    ;

metadataParams
    : (keyValuePair | keyTypePair)? (COMMA metadataParams)*
    ;

keyValuePair
    : key COLON value
    ;

key
    : LITERAL_STRING
    | IDENTIFIER
    ;

value
   : identifier
   | literal
   | array
   | object
   ;

object
   : LBRACE keyValuePair (COMMA keyValuePair)* RBRACE
   | LBRACE RBRACE
   ;

identifier
    : IDENTIFIER (DOT identifier)*
    ;

literal
   : LITERAL_STRING
   | LITERAL_INTEGER
   | LITERAL_DECIMAL
   | LITERAL_BOOL
   | LITERAL_NULL
   ;

array
   : LBRACK value (COMMA value)* RBRACK
   | LBRACK RBRACK
   ;

block
    : LBRACE statement* RBRACE
    ;

statement
    : IF parExpression block (ELSE block)?              # ifStmt
    | WHILE parExpression block                         # whileStmt
    | DEF IDENTIFIER (ASSIGNMENT expression)?           # varDeclStmt
    | IDENTIFIER ASSIGNMENT expression                  # assignmentStmt // should this be indentifier instead of IDENTIFIER?
    | RETURN object?                                    # returnStmt
    | expression                                        # exprStmt
    ;

//TODO there's a lot of missing stuff here like basic aritmethic operations (+,-,*,/)
expression
    : (identifier | literal | parExpression)                           # primaryExpr
    | IDENTIFIER execParams                                            # executeExpr // consider moving this up to stmt
    | EXECUTE (IDENTIFIER | LITERAL_STRING) execParams?                # executeCmdExpr
    | NOT expression                                                   # negationExpr
    | expression (EQ | NEQ | LT | GT | LTE | GTE) expression           # compExpr
    | expression (AND | OR) expression                                 # logicExpr
    ;

execParams
    :  LPAREN keyValuePair? (COMMA keyValuePair)* RPAREN
    ;

parExpression
    : LPAREN expression RPAREN
    ;
