package com.gl.springaopone;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import com.gl.springaopone.service.CustomerService;

import java.sql.*;
/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3307/dem";
        String user = "root";
        String password = "";

        // JDBC Connection and CallableStatement
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish connection
            conn = DriverManager.getConnection(url, user, password);
            
            // Step 2: Prepare the CallableStatement to execute the stored procedure
            String query = "{CALL UpdateOrderStatus(?)}";
            stmt = conn.prepareCall(query);
            
            // Step 3: Set the input parameter for employee ID
            stmt.setInt(1, 2); // Example Employee ID to test

            // Step 4: Execute the stored procedure
            rs = stmt.executeQuery();

            // Step 5: Print the output (this will be printed in the terminal)
            while (rs.next()) {
                System.out.println("Order " + rs.getInt("order_id")+" has already been shipped");
        
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

	
}

