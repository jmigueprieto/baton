parser grammar Baton;

options { tokenVocab = BatonLexer; }

batonUnit
    : (structDeclaration | taskDeclaration)* workflowDeclaration EOF
    ;

structDeclaration
    : STRUCT IDENTIFIER structDef
    ;

structDef
    : LBRACE structKeyValuePair? (COMMA structKeyValuePair)* RBRACE;

structKeyValuePair
    : key COLON (type            // Basic types e.g.: String, Boolean
                | IDENTIFIER    // named type
                | structDef)    // nested struct
    ;

type
    : TYPE_BOOLEAN
    | TYPE_STRING
    | TYPE_INTEGER
    | TYPE_DECIMAL
    ;

taskDeclaration
    : TASK IDENTIFIER object
    ;

object
   : LBRACE keyValuePair (COMMA keyValuePair)* RBRACE
   | LBRACE RBRACE
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
   | type
   | literal
   | array
   | object
   ;

identifier
    : IDENTIFIER (DOT IDENTIFIER)*
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

workflowDeclaration
    : WORKFLOW IDENTIFIER workflowParameters? (COLON workflowOutput)? block
    ;

workflowParameters : parameters;

parameters
    : LPAREN keyValuePair? (COMMA keyValuePair)* RPAREN
    ;

workflowOutput: structDef | IDENTIFIER;

block
    : LBRACE statement* RBRACE
    ;

statement
    : IF parExpression block (ELSE block)?              # ifStmt
    | WHILE parExpression block                         # whileStmt
    | DEF IDENTIFIER (ASSIGNMENT expression)?           # varDeclStmt
    | IDENTIFIER ASSIGNMENT expression                  # assignmentStmt
    | RETURN object?                                    # returnStmt
    | expression                                        # exprStmt
    ;

expression
    : (IDENTIFIER | literal | parExpression)                # primaryExpr
    | EXECUTE (IDENTIFIER | LITERAL_STRING) taskParameters  # executeExpr
    | expression DOT IDENTIFIER expression?                 # dotExpr
    | (NOT | MINUS) expression                              # prefixExpr
    | expression (EQ | NEQ) expression                      # eqExpr
    | expression (AND | OR) expression                      # logicExpr
    ;

taskParameters : parameters;

parExpression
    : LPAREN expression RPAREN
    ;
