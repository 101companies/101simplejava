grammar Company;

@header {
package org.softlang.company.antlr;
import org.softlang.company.model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
}

@members {
public static Company parseCompany(String s) throws IOException, RecognitionException {
    FileInputStream stream = new FileInputStream(s);
    ANTLRInputStream antlr = new ANTLRInputStream(stream);
    CompanyLexer lexer = new CompanyLexer(antlr);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CompanyParser parser = new CompanyParser(tokens);
    Company c = parser.company().c;
    if (parser.getNumberOfSyntaxErrors()>0) throw new RecognitionException(parser,tokens,null);
    return c;
}

}

company returns [Company c]:
  { $c = new Company(); }
  'company' STRING
  { $c.setName($STRING.text); }
  '{' 
  ( topdept=department
    { $c.getDepts().add($topdept.d); }
  )* 
  '}'
  ;
  

department returns [Department d]:
  { $d = new Department(); }
  'department' name=STRING
  { $d.setName($name.text); } 
  '{'
    'manager' m=employee
    { $d.setManager($m.e); }
    ( 'employee' e=employee
      { $d.getEmployees().add($e.e); }
    )*
    ( sub=department
      { $d.getSubdepts().add($sub.d); }
    )*
  '}'
  ;
    
employee returns [Employee e]:
  n=STRING '{'
    'address' a=STRING
    'salary' s=FLOAT
  '}'
  {
    $e = new Employee();
    $e.setName($n.text);
    $e.setAddress($a.text);
    $e.setSalary(Double.parseDouble($s.text));
  }
  ;

WS      :   (' '|'\r'? '\n'|'\t')+ { skip(); };
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
