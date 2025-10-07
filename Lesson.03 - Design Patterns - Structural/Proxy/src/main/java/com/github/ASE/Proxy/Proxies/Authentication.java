package com.github.ASE.Proxy.Proxies;

import java.util.Set;

import com.github.ASE.Proxy.FileService;
import com.github.ASE.Proxy.User;

public class Authentication implements FileService {
    private final FileService realService;
    private final Set<String> allowedRoles;

    public Authentication(FileService realService, Set<String> allowedRoles) {
        this.realService = realService;
        this.allowedRoles = allowedRoles;
    }

    @Override
    public String downloadFile(String fileId, User user) {
        if (!allowedRoles.contains(user.getRole())) {
            System.out.println("Access denied to " + user.getUsername() + ": insufficient privileges");
            return "Error: Access denied";
        }
        return realService.downloadFile(fileId, user);
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        if (!allowedRoles.contains(user.getRole())) {
            System.out.println("Upload denied to " + user.getUsername() + ": insufficient privileges");
            return;
        }
        realService.uploadFile(content, filename, user);
    }

}
