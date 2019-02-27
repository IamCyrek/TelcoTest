package com.telco.app;


import java.io.IOException;

public class App
{
    public static void main( String[] args ) {
        if (args.length == 0) {
            System.out.println("There is no path of configuration file.");
            return;
        }

        PropertiesWorker propertiesValues = null;
        try {
            propertiesValues = new PropertiesWorker(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert propertiesValues != null;
        System.out.println(propertiesValues.getSftp_host());
        System.out.println(propertiesValues.getSftp_port());
        System.out.println(propertiesValues.getSftp_user());
        System.out.println(propertiesValues.getSftp_password());
        System.out.println(propertiesValues.getSftp_remote_dir());
        System.out.println(propertiesValues.getLocal_dir());
        System.out.println(propertiesValues.getSql_user());
        System.out.println(propertiesValues.getSql_password());
        System.out.println(propertiesValues.getSql_database());
    }

}
