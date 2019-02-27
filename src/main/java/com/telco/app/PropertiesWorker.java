package com.telco.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesWorker {
    private String sftp_host;
    private String sftp_port;
    private String sftp_user;
    private String sftp_password;
    private String sftp_remote_dir;
    private String local_dir;
    private String sql_user;
    private String sql_password;
    private String sql_database;

    PropertiesWorker(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        Properties props = new Properties();
        try {
            props.load(inputStream);

            sftp_host = props.getProperty("sftp_host");
            sftp_port = props.getProperty("sftp_port");
            sftp_user = props.getProperty("sftp_user");
            sftp_password = props.getProperty("sftp_password");
            sftp_remote_dir = props.getProperty("sftp_remote_dir");
            local_dir = props.getProperty("local_dir");
            sql_user = props.getProperty("sql_user");
            sql_password = props.getProperty("sql_password");
            sql_database = props.getProperty("sql_database");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream.close();
        }
    }

    String getSftp_host() {
        return sftp_host;
    }

    String getSftp_port() {
        return sftp_port;
    }

    String getSftp_user() {
        return sftp_user;
    }

    String getSftp_password() {
        return sftp_password;
    }

    String getSftp_remote_dir() {
        return sftp_remote_dir;
    }

    String getLocal_dir() {
        return local_dir;
    }

    String getSql_user() {
        return sql_user;
    }

    String getSql_password() {
        return sql_password;
    }

    String getSql_database() {
        return sql_database;
    }
}
