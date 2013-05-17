grammar Company;

options {
  k = 1;
}

@header {
package org.softlang.company.antlr;
}

@lexer::header {
package org.softlang.company.antlr;
}

@members {

// Throw if any error was emitted
public boolean error = false;

@Override
public void emitErrorMessage(String msg) 
{
  error = true;
  super.emitErrorMessage(msg);
}
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
