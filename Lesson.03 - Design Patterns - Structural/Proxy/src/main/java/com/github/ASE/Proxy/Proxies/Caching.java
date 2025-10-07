package com.github.ASE.Proxy.Proxies;

import java.util.HashMap;
import java.util.Map;

import com.github.ASE.Proxy.FileService;
import com.github.ASE.Proxy.User;

public class Caching implements FileService {
    private final FileService realService;
    private final Map<String, String> cache = new HashMap<>();

    public Caching(FileService realService) {
        this.realService = realService;
    }

    @Override
    public String downloadFile(String fileId, User user) {
        if (cache.containsKey(fileId)) {
            System.out.println("Serving from cache: " + fileId);
            return cache.get(fileId);
        }
        String content = realService.downloadFile(fileId, user);
        if (!content.startsWith("Error")) {
            cache.put(fileId, content);
        }
        return content;
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        realService.uploadFile(content, filename, user);
    }
}
