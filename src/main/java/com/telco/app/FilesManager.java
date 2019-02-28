package com.telco.app;

import com.jcraft.jsch.*;

import java.io.File;
import java.util.Properties;
import java.util.Vector;

class FilesManager {

    static Vector<FileRecordObject> copyFiles(PropertiesWorker propertiesWorker) throws JSchException {
        JSch jSch = new JSch();
        Vector<FileRecordObject> fileRecordsObject = new Vector<>();

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        Session session = jSch.getSession(
                propertiesWorker.getSftpUser(),
                propertiesWorker.getSftpHost(),
                Integer.parseInt(propertiesWorker.getSftpPort())
        );
        session.setPassword(propertiesWorker.getSftpPassword());
        session.setConfig(config);
        session.connect();

        ChannelSftp sftpChannel = (ChannelSftp)session.openChannel("sftp");
        sftpChannel.connect();

        try {
            sftpChannel.cd(propertiesWorker.getSftpRemoteDir());

            Vector remoteFiles = sftpChannel.ls(propertiesWorker.getSftpRemoteDir());

            for (Object file : remoteFiles) {
                ChannelSftp.LsEntry remoteFile = (ChannelSftp.LsEntry) file;

                if (!remoteFile.getAttrs().isDir()) {
                    String localFileName = propertiesWorker.getLocalDir() + File.separator + remoteFile.getFilename();

                    if (!new File(localFileName).exists()) {
                        new File(localFileName);
                        sftpChannel.get(remoteFile.getFilename(), localFileName);
                        fileRecordsObject.add(new FileRecordObject(System.currentTimeMillis(), localFileName));
                    }
                }
            }
        } catch (SftpException e) {
            e.printStackTrace();
        }

        sftpChannel.exit();
        session.disconnect();
        return fileRecordsObject;
    }
}
