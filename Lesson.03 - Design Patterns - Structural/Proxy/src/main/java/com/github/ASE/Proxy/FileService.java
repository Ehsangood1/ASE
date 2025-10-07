package com.github.ASE.Proxy;

public interface FileService {
    String downloadFile(String fileId, User user);

    void uploadFile(String content, String filename, User user);
}
