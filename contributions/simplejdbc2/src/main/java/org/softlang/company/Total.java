package org.softlang.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Total {

    /**
     * Total all salaries of a given company.
     */
    public static double total(Connection connection, String name){
        double total = 0;
        try {
            String query =
                    "SELECT SUM(salary) FROM employee "
                            + "WHERE cid = (SELECT id FROM company WHERE name = ?);";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            ResultSet result = stm.executeQuery();
            result.next();
            total = result.getDouble(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }
}