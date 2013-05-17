package org.softlang.company.features;

import static org.softlang.company.features.parsing.Token.*;
import org.softlang.company.features.parsing.Recognizer;
import org.softlang.company.features.parsing.Token;

import java.io.FileNotFoundException;

public class Total {

	private double total = 0;
	
	public double getTotal() {
		return total;
	}
	
	public Total(String s) throws FileNotFoundException {
		Recognizer recognizer = new Recognizer(s);
		Token current = null;
		Token previous = null;
		while (recognizer.hasNext()) {
			current = recognizer.next();
			if (current == FLOAT && previous == SALARY) 
				total += Double.parseDouble(recognizer.getLexeme());
			if (current!=WS)
				previous = current;
		}
	}
	
}
