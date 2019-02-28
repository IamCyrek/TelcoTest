package com.telco.app;

import com.jcraft.jsch.JSchException;

import java.io.IOException;

public class App {

    public static void main( String[] args ) {
        if (args.length == 0) {
            System.out.println("There is no path of configuration file.");
            return;
        }

        PropertiesWorker propertiesWorker;
        try {
            propertiesWorker = new PropertiesWorker(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DBService dbService = new DBService(propertiesWorker);

        try {
            dbService.insertFileRecordObject(FilesManager.copyFiles(propertiesWorker));
        } catch (JSchException e) {
            e.printStackTrace();
        }

        dbService.readFileRecordsObject().forEach(System.out::println);
        dbService.close();
    }

}
