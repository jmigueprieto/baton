grammar Baton;

batonUnit
    : typeDeclaration* taskDeclaration*  workflowDeclaration
    ;

typeDeclaration
    : TYPE IDENTIFIER parameters
    ;

taskDeclaration
    : TASK IDENTIFIER parameters
    ;

parameters
    : LPAREN keyValuePair? (COMMA keyValuePair)* RPAREN
    ;

keyValuePair
    : key COLON type
    | key COLON value
    | key COLON object
    ;

key
    : STRING_LITERAL
    | IDENTIFIER;

type
    : TYPE_BOOLEAN
    | TYPE_STRING
    | TYPE_INTEGER
    | TYPE_DECIMAL
    | customType;

customType : IDENTIFIER;

object
   : LBRACE keyValuePair (COMMA keyValuePair)* RBRACE
   | LBRACE RBRACE
   ;

array
   : LBRACK value (COMMA value)* RBRACK
   | LBRACK RBRACK
   ;

value
   : IDENTIFIER
   | STRING_LITERAL
   | NUMBER_LITERAL
   | BOOL_LITERAL
   | NULL_LITERAL
   | array
   | object
   ;

workflowDeclaration
    : WORKFLOW IDENTIFIER parameters? COLON parameters workflowBlock
    ;

workflowBlock
    : LBRACE statement* returnStatement RBRACE
    ;

block
    : LBRACE statement* RBRACE
    ;

statement
    : IF parExpression block (ELSE block)? // if
    | WHILE parExpression block // while
    | DEF IDENTIFIER ASSIGNMENT expression // variable declaration
    | IDENTIFIER ASSIGNMENT expression // variable assignment
    | expression
    ;

returnStatement: RETURN expression;

expression
    : primary
    | EXECUTE (IDENTIFIER | STRING_LITERAL) parameters
    | expression DOT IDENTIFIER expression?
    | ('!' | '-') expression
    | expression ('==' | '!=') expression
    | expression ('&&' | '||') expression
    ;

primary
    : NUMBER_LITERAL
    | STRING_LITERAL
    | BOOL_LITERAL
    | NULL_LITERAL
    | IDENTIFIER
    | parExpression
    ;

parExpression
    : LPAREN expression RPAREN
    ;

WS :                ('\t' | '\r' | '\n' | ' ')+ -> skip;
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

WORKFLOW:           'workflow';
TASK:               'task';
TYPE:               'type';
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
BOOL_LITERAL:       'true' | 'false';
STRING_LITERAL:     '"' (~["\\\r\n] | EscapeSequence)* '"';
NUMBER_LITERAL:     '-'? INT ('.' [0-9] +)? EXP?;
NULL_LITERAL:       'null';

IDENTIFIER:         Letter LetterOrDigit*;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment INT
   : '0' | [1-9] [0-9]*
   ;

fragment EXP
   : [Ee] [+\-]? INT
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