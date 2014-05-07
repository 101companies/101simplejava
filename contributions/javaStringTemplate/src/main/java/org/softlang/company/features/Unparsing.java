package org.softlang.company.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.softlang.company.model.Company;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author Matthias Paul
 * 
 */
public class Unparsing {

	public static String unparse(Company c, String file) {
		String res = unparse(c);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(res);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String unparse(Company c) {
		STGroup group = new STGroupFile("src" + File.separatorChar + "main"
				+ File.separatorChar + "stringtemplate" + File.separatorChar
				+ "companyUnparsing.stg");
		ST st = group.getInstanceOf("company");
		st.add("c", c);
		return st.render();
	}

}
