tree grammar CutCompany;

options { 
  tokenVocab=Company;
  ASTLabelType=CommonTree;
  output = AST;
  filter=true;
  backtrack=true;
}

@header {
package org.softlang.company.antlr;
}
    
// START: strategy
topdown : employee;
// END: strategy
        
employee :
  ^(EMPLOYEE STRING STRING s=FLOAT)
  -> ^(EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)])
  ;
