package org.softlang.company.features;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.softlang.company.model.Company;

public class Parsing {
    
    /**
     * Read (say, deserialize) a company
     */
    public static Company readObject(String filename) {

        Object o = null;

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            o = in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Company) o;
    }

}