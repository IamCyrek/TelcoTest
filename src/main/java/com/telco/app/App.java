package com.telco.app;

import com.jcraft.jsch.JSchException;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) {
        if (args.length == 0) {
            System.out.println("There is no path of configuration file.");
            return;
        }

        PropertiesWorker propertiesWorker = null;
        try {
            propertiesWorker = new PropertiesWorker(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert propertiesWorker != null;
            FilesManager.copyFiles(propertiesWorker);
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

}
