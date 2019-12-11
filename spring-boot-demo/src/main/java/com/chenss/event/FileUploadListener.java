package com.chenss.event;

public class FileUploadListener implements ApplicationListener<FileUploadEvent> {
    @Override
    public void onEvent(FileUploadEvent fileUploadEvent) {
        double fileSize = ((double) fileUploadEvent.getFileSize());
        double readSize = ((double) fileUploadEvent.getReadSize());
        double percent = readSize / fileSize;
        System.out.println(String.format("当前文件上传百分比：{%s}",percent));
    }
}
