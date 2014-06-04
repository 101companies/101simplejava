package org.softlang.company.features;

import org.softlang.company.model.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * Implementation of the Feature Unparsing
 */

public class Unparsing {

    private Writer writer;
    int indent = 0;

    // Local write that swallows checked exception, too
    private void write(String s) {
        try {
            writer.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Convenient macros for pretty printing
    private void space() { write(" "); }
    private void tab() { write("\t"); }
    private void nl() { write("\n"); }
    private void right() { indent += 1; }
    private void left() { indent -= 1; }
    private void indent() { for(int i=0; i<indent; i++) tab(); }

    public void unparseCompany(Company c, String s)
            throws IOException {
        writer = new OutputStreamWriter(new FileOutputStream(s));
        write("company");
        space();
        write(c.getName());
        space();
        write("{");
        right();
        nl();
        for (Department d : c.getDepts())
            unparseDept(d);
        left();
        indent();
        write("}");
        writer.close();
    }

    public void unparseDept(Department d) {
        indent();
        write("department");
        space();
        write(d.getName());
        space();
        write("{");
        right();
        nl();
        unparseEmployee(true,d.getManager());
        for (Employee e : d.getEmployees())
            unparseEmployee(false, e);
        for (Department s : d.getSubdepts())
            unparseDept(s);
        left();
        indent();
        write("}");
        nl();
    }

    public void unparseEmployee(boolean isManager, Employee e) {
        indent();
        if (isManager)
            write("manager");
        else
            write("employee");
        space();
        write(e.getName());
        space();
        write("{");
        right();
        nl();
        indent();
        write("address");
        space();
        write(e.getAddress());
        nl();
        indent();
        write("salary");
        space();
        write(Double.toString(e.getSalary()));
        nl();
        left();
        indent();
        write("}");
        nl();
    }

}