grammar Baton;

batonUnit
    : (structDeclaration | taskDeclaration)* workflowDeclaration EOF
    ;

structDeclaration
    : STRUCT IDENTIFIER structDef
    ;

structDef
    : LBRACE structKeyValuePair? (COMMA structKeyValuePair)* RBRACE;

structKeyValuePair
    : key COLON (
        type            // Basic types e.g.: String, Boolean
        | IDENTIFIER    // named type
        | structDef     // nested struct
    )
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
   : IDENTIFIER
   | type
   | literal
   | array
   | object
   ;

literal
   : LITERAL_STRING
   | LITERAL_INTEGER
   | LITERAL_DECIMAL
   | LITERAL_BOOL
   | LITERAL_NULL
   ;

parameters
    : LPAREN keyValuePair? (COMMA keyValuePair)* RPAREN
    ;

array
   : LBRACK value (COMMA value)* RBRACK
   | LBRACK RBRACK
   ;

workflowDeclaration
    : WORKFLOW IDENTIFIER parameters? (COLON workflowOutput)? block
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
    | RETURN expression                                 # returnStmt
    | expression                                        # exprStmt
    ;

expression
    : (IDENTIFIER | literal | parExpression)            # primary
    | EXECUTE (IDENTIFIER | LITERAL_STRING) parameters  # execute
    | expression DOT IDENTIFIER expression?             # dotOp
    | ('!' | '-') expression                            # prefixOp
    | expression ('==' | '!=') expression               # eqOp
    | expression ('&&' | '||') expression               # logicOp
    ;

parExpression
    : LPAREN expression RPAREN
    ;

WS :                ('\t' | '\r' | '\n' | ' ')+ -> skip;
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

WORKFLOW:           'workflow';
TASK:               'task';
STRUCT:             'struct';
DEF:                'def';
EXECUTE:            'execute';
TYPE_STRING:        'String';
TYPE_BOOLEAN:       'Boolean';
TYPE_INTEGER:       'Integer';
TYPE_DECIMAL:       'Decimal';

LPAREN:             '(';
RPAREN:             ')';
LBRACE:             '{';
RBRACE:             '}';
LBRACK:             '[';
RBRACK:             ']';
COLON:              ':';
COMMA:              ',';
DOT:                '.';
ASSIGNMENT:         '=';

IF:                 'if';
ELSE:               'else';
VAR:                'var';
WHILE:              'while';
RETURN:             'return';
LITERAL_BOOL:       'true' | 'false';
LITERAL_STRING:     '"' (~["\\\r\n] | EscapeSequence)* '"';
LITERAL_INTEGER:     '-'? '0' | [1-9] [0-9]*;
LITERAL_DECIMAL:     LITERAL_INTEGER ('.' [0-9] +)?;
LITERAL_NULL:       'null';

IDENTIFIER:         Letter LetterOrDigit*;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment LetterOrDigit
    : Letter
    | [0-9]
    ;

fragment Letter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;