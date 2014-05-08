package org.softlang.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void cut() throws SQLException {
        List<Double> salariesBefore = getSalaries();
        List<Double> expected = new ArrayList<Double>();
        for (Double s : salariesBefore) {
            expected.add(s / 2.0);
        }

        Cut.cut(conn, NAME);

        List<Double> salariesAfter = getSalaries();
        assertEquals(expected, salariesAfter);
    }

    @Test
    public void total() throws SQLException {
        double expected = 399747.0;
        double total = Total.total(conn, NAME);
        assertEquals(expected, total, 10e-10);
    }

    @Test
    public void depth() throws SQLException {
        assertEquals(3, Depth.depth(conn, NAME));
    }

    private List<Double> getSalaries() throws SQLException {
        ResultSet salarySet = queryAllEmployees();
        List<Double> salaries = new ArrayList<Double>();
        while (salarySet.next()) {
            salaries.add(salarySet.getDouble("salary"));
        }
        return salaries;
    }

    public ResultSet queryAllEmployees() throws SQLException {
        String select = "SELECT * FROM employee;";
        PreparedStatement stm = conn.prepareStatement(select);
        return stm.executeQuery();
    }
}
