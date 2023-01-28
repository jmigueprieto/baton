lexer grammar BatonLexer;

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
NOT:                '!';
MINUS:              '-';
EQ:                 '==';
NEQ:                '!=';
AND:                '&&';
OR:                 '||';

IF:                 'if';
ELSE:               'else';
VAR:                'var';
WHILE:              'while';
RETURN:             'return';
LITERAL_BOOL:       'true' | 'false';
LITERAL_STRING:      '"' (~["\\\r\n] | EscapeSequence)* '"';
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
