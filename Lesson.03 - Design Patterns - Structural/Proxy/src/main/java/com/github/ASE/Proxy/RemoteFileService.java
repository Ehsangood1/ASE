package com.github.ASE.Proxy;

import java.util.HashMap;
import java.util.Map;

public class RemoteFileService implements FileService {
    private final Map<String, String> storage = new HashMap<>();
    private final String serverId;

    public RemoteFileService(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String downloadFile(String fileId, User user) {
        simulateNetworkLatency();
        if (Math.random() < 0.1) {
            throw new RuntimeException("Network error");
        }
        System.out.println("[Server " + serverId + "] Downloading file: " + fileId);
        return storage.getOrDefault(fileId, "File not found");
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        simulateNetworkLatency();
        System.out.println("[Server " + serverId + "] Uploading file: " + filename);
        storage.put(filename, content);
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(100); // Simulate network delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
