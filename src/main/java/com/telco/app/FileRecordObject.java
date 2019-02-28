package com.telco.app;

import java.text.SimpleDateFormat;
import java.util.Date;

class FileRecordObject {
    private long id;
    private long dateAndTime;
    private String filePathAndName;

    FileRecordObject(long dateAndTime, String filePathAndName) {
        this.dateAndTime = dateAndTime;
        this.filePathAndName = filePathAndName;
    }

    FileRecordObject(long id, long dateAndTime, String filePathAndName) {
        this.id = id;
        this.dateAndTime = dateAndTime;
        this.filePathAndName = filePathAndName;
    }

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    long getDateAndTime() {
        return dateAndTime;
    }

    void setDateAndTime(long dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    String getFilePathAndName() {
        return filePathAndName;
    }

    void setFilePathAndName(String filePathAndName) {
        this.filePathAndName = filePathAndName;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss.SSS z");
        Date date = new Date(dateAndTime);

        return "FileRecordObject{" +
                "id=" + id +
                ", dateAndTime=" + formatter.format(date) +
                ", filePathAndName='" + filePathAndName + '\'' +
                '}';
    }
}
