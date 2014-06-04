lexer grammar Company;

@header {
package org.softlang.company.antlr;
}

COMPANY     : 'company';
DEPARTMENT  : 'department';
EMPLOYEE    : 'employee';
MANAGER     : 'manager';
ADDRESS     : 'address';
SALARY      : 'salary';
OPEN        : '{';
CLOSE       : '}';
WS          :   (' '|'\r'? '\n'|'\t')+;
STRING      :   '"' (~'"')* '"';
FLOAT       : DIGIT+ ('.' DIGIT+)?;

fragment DIGIT : ('0'..'9'); 
