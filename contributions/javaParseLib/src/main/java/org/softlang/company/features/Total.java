package org.softlang.company.features;

import org.softlang.company.features.parser.CompanyParser;

import parseLib.util.Input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Total {

        /* 
         * Total is implemented by the Parser 
         * See org.softlang.company.features.parser.CompanyParser
         */
    public static Double total(String file) throws FileNotFoundException, IOException {
        Input input = new Input(new FileReader(file));
        return (new CompanyParser().parse(input));
    }

}