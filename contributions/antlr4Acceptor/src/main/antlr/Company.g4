grammar Company;


@header {
package org.softlang.company.antlr;
} 

company :
  'company' STRING '{' department* '}' EOF;
  
department :
  'department' STRING '{' 
    ('manager' employee)
    ('employee' employee)* 
    department*
  '}';

employee :
  STRING '{'
    'address' STRING
    'salary' FLOAT
  '}';

STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
