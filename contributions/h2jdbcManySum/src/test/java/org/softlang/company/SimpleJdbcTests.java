package org.softlang.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class SimpleJdbcTests {

    private static Connection conn;
    public static final String NAME = "Acme Corporation";

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        System.out.println(System.getProperty("user.dir"));
        conn = DriverManager.getConnection("jdbc:h2:mem:company;INIT=runscript from 'src/test/resources/Company.sql'\\;runscript from 'src/test/resources/sampleCompany.sql'", "sa", "");
    }

    @After
    public void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    public void total() throws SQLException {
        double expected = 399747.0;
        double total = Total.total(conn, NAME);
        assertEquals(expected, total, 10e-10);
    }

}
