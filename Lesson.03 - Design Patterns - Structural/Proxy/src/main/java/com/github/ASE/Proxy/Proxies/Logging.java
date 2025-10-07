package com.github.ASE.Proxy.Proxies;

import java.time.LocalDateTime;

import com.github.ASE.Proxy.FileService;
import com.github.ASE.Proxy.User;

public class Logging implements FileService {
    private final FileService realService;

    public Logging(FileService realService) {
        this.realService = realService;
    }

    @Override
    public String downloadFile(String fileId, User user) {
        logAccess("Download", fileId, user);
        return realService.downloadFile(fileId, user);
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        logAccess("Upload", filename, user);
        realService.uploadFile(content, filename, user);
    }

    private void logAccess(String operation, String fileId, User user) {
        System.out.printf("[%s] %s by %s (%s)%n", LocalDateTime.now(), operation, user.getUsername(), user.getRole());
    }
}
