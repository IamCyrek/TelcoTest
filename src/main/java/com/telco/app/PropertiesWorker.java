package com.telco.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesWorker {
    private String sftpHost;
    private String sftpPort;
    private String sftpUser;
    private String sftpPassword;
    private String sftpRemoteDir;
    private String localDir;
    private String sqlDatabase;

    PropertiesWorker(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        Properties props = new Properties();
        try {
            props.load(inputStream);

            sftpHost = props.getProperty("sftp_host");
            sftpPort = props.getProperty("sftp_port");
            sftpUser = props.getProperty("sftp_user");
            sftpPassword = props.getProperty("sftp_password");
            sftpRemoteDir = props.getProperty("sftp_remote_dir");
            localDir = props.getProperty("local_dir");
            sqlDatabase = props.getProperty("sql_database");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream.close();
        }
    }

    String getSftpHost() {
        return sftpHost;
    }

    String getSftpPort() {
        return sftpPort;
    }

    String getSftpUser() {
        return sftpUser;
    }

    String getSftpPassword() {
        return sftpPassword;
    }

    String getSftpRemoteDir() {
        return sftpRemoteDir;
    }

    String getLocalDir() {
        return localDir;
    }

    String getSqlDatabase() {
        return sqlDatabase;
    }
}
