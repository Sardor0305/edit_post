package org.example.bot.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.bot.databse.ExecuteData.createTableIfNotExist;

public class DatabaseConnection {
    public static final List<Connection> connections = new ArrayList<>();

    public static void setConnection() {
        try {
            final Connection con = DriverManager.getConnection(
                    "jdbc:h2:file:./data/mydatabase;TRACE_LEVEL_FILE=0",
                    "sa",
                    ""
            );
            connections.add(con);
            createTableIfNotExist();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnections() {
        return connections.get(0);
    }

}
