package org.softlang.company.features;

import org.softlang.company.model.Company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Unparsing {

    /**
     * Write (say, serialize) a company.
     */
    public static boolean writeCompany(Company c, String filename) {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(c);
            out.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}