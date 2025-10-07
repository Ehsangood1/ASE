package com.github.ASE.Proxy.Proxies;

import com.github.ASE.Proxy.FileService;
import com.github.ASE.Proxy.User;

public class Retry implements FileService {
    private final FileService realService;
    private final int maxRetries;

    public Retry(FileService realService, int maxRetries) {
        this.realService = realService;
        this.maxRetries = maxRetries;
    }

    @Override
    public String downloadFile(String fileId, User user) {
        int attempt = 0;
        while (true) {
            try {
                return realService.downloadFile(fileId, user);
            } catch (Exception e) {
                attempt++;
                if (attempt > maxRetries) {
                    System.out.println("Max retries reached for file: " + fileId);
                    return "Error: " + e.getMessage();
                }
                System.out.println("Retry " + attempt + " for file: " + fileId);
            }
        }
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        int attempt = 0;
        while (true) {
            try {
                realService.uploadFile(content, filename, user);
                return;
            } catch (Exception e) {
                attempt++;
                if (attempt > maxRetries) {
                    System.out.println("Upload failed after " + maxRetries + " retries.");
                    return;
                }
                System.out.println("Retrying upload...");
            }
        }
    }
}
