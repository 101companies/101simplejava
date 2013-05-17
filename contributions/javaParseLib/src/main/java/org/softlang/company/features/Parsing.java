package org.softlang.company.features;

import org.softlang.company.features.parser.CompanyParser;
import org.softlang.company.features.parser.CompanyAcceptor;
import parseLib.util.Input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parsing {

    public static Boolean parseCompany(String file) throws FileNotFoundException, IOException {
        Input input = new Input(new FileReader(file));
        Double totalValue = new CompanyParser().parse(input);
        if (totalValue != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean acceptCompany(String file) throws FileNotFoundException, IOException {
        Input input = new Input(new FileReader(file));
        return (new CompanyAcceptor().accept(input));
    }

}