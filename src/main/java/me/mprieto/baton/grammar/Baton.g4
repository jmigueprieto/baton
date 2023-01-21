grammar Baton;

batonUnit
    : typeDeclaration*  workflowDeclaration taskDeclaration*
    ;

typeDeclaration
    : TYPE IDENTIFIER params
    ;

params
    : LBRACE param (COMMA param)* RBRACE
    ;

param
    : STRING_LITERAL COLON (TYPE_BOOLEAN | TYPE_STRING | TYPE_INTEGER | TYPE_DECIMAL | IDENTIFIER)
    ;

workflowDeclaration
    : WORKFLOW IDENTIFIER workflowBlock
    ;

workflowBlock
    : LBRACE (INPUT (params | IDENTIFIER))? (OUTPUT (params | IDENTIFIER))? (PROPERTIES propertiesBlock)? statement+ RBRACE
    ;

taskDeclaration
    : TASK IDENTIFIER taskBlock
    ;

taskBlock
    : LBRACE (INPUT (params | IDENTIFIER))? (OUTPUT (params | IDENTIFIER))? (PROPERTIES propertiesBlock) RBRACE
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

//returnStatement
//    : RETURN

expression
    : primary
    | EXECUTE (IDENTIFIER | STRING_LITERAL) propertiesBlock
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

propertiesBlock
   : LBRACE propertiesPair (COMMA propertiesPair)* RBRACE
   | LBRACE RBRACE
   ;

propertiesPair
   : STRING_LITERAL COLON propertiesValue
   ;

propertiesArray
   : LBRACK propertiesValue (COMMA propertiesValue)* RBRACK
   | LBRACK RBRACK
   ;

propertiesValue
   : IDENTIFIER
   | STRING_LITERAL
   | NUMBER_LITERAL
   | BOOL_LITERAL
   | NULL_LITERAL
   | propertiesArray
   | propertiesBlock
   ;

WS :                ('\t' | '\r' | '\n' | ' ')+ -> skip;
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

WORKFLOW:           'workflow';
TASK:               'task';
TYPE:               'type';
DEF:                'def';
EXECUTE:            'execute';
INPUT:              'input';
OUTPUT:             'output';
PROPERTIES:         'properties';
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