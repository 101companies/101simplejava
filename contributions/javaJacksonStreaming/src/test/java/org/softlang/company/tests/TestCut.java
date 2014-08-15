package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;

public class TestCut {

	@Test
	public void testCut() {
		String file = "inputs" + File.separator + "sampleCompany.json";
		String file2 = "outputs" + File.separator + "outputCompany.json";
		File in = new File(file);
		File out = new File(file2);
		assertEquals(326927.0, Total.total(in), 0.0);
		Cut.cut(in, out);
		assertEquals(Total.total(in) / 2, Total.total(out), 0.0);
		in = new File("inputs" + File.separator + "cutSampleCompany.json");
		try {
			BufferedReader actualReader = new BufferedReader(
					new FileReader(out));
			BufferedReader expectedReader = new BufferedReader(new FileReader(
					in));
			String expected = "";
			String actual = "";
			while (expectedReader.ready())
				expected += expectedReader.readLine();
			while (actualReader.ready())
				actual += actualReader.readLine();
			expectedReader.close();
			actualReader.close();
			assertEquals(0, expected.compareTo(actual));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.delete();
	}

	@Test
	public void testCutSameFile() {
		String file = "inputs" + File.separator + "sampleCompany.json";
		String file2 = "outputs" + File.separator + "outputCompany.json";
		File in = new File(file);
		File out = new File(file2);
		// in.renameTo(out);
		assertEquals(326927.0, Total.total(in), 0.0);

		try {
			Files.copy(in.toPath(), out.toPath());
			Cut.cut(out);
			in = new File("inputs" + File.separator + "cutSampleCompany.json");
			assertEquals(Total.total(in), Total.total(out), 0.0);
			BufferedReader actualReader = new BufferedReader(
					new FileReader(out));
			BufferedReader expectedReader = new BufferedReader(new FileReader(
					in));
			String expected = "";
			String actual = "";
			while (expectedReader.ready())
				expected += expectedReader.readLine();
			while (actualReader.ready())
				actual += actualReader.readLine();
			expectedReader.close();
			actualReader.close();
			assertEquals(0, expected.compareTo(actual));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}