package com.telco.app;

import java.sql.*;
import java.util.Vector;

class DBService {
    private Connection connection = null;
    private final String FILES = "files";
    private final String ID = "id";
    private final String DATE_AND_FILE = "date_and_time";
    private final String FILE_PATH_AND_NAME = "file_path_and_name";

    DBService(PropertiesWorker propertiesWorker) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + propertiesWorker.getSqlDatabase());

            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + FILES + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DATE_AND_FILE + " DATETIME, " +
                    FILE_PATH_AND_NAME + " VARCHAR (25));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertFileRecordObject(Vector<FileRecordObject> fileRecordsObject) {
        try {
            Statement statement = connection.createStatement();

            for (FileRecordObject fileRecordObject : fileRecordsObject) {
                statement.executeUpdate("INSERT INTO " + FILES + " (" +
                        DATE_AND_FILE + ", " +
                        FILE_PATH_AND_NAME + ") values(" +
                        fileRecordObject.getDateAndTime() + ", '" +
                        fileRecordObject.getFilePathAndName() + "');");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Vector<FileRecordObject> readFileRecordsObject() {
        Vector<FileRecordObject> fileRecordsObject = new Vector<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + FILES + ";");
            while(resultSet.next()) {
                fileRecordsObject.add(new FileRecordObject(
                        Long.parseLong(resultSet.getString(ID)),
                        Long.parseLong(resultSet.getString(DATE_AND_FILE)),
                        resultSet.getString(FILE_PATH_AND_NAME)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fileRecordsObject;
    }

    void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
