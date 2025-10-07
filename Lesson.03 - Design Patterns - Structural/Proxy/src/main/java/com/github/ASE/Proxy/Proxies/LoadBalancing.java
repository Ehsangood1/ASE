package com.github.ASE.Proxy.Proxies;

import java.util.List;

import com.github.ASE.Proxy.FileService;
import com.github.ASE.Proxy.User;

public class LoadBalancing implements FileService {
    private final List<FileService> servers;

    public LoadBalancing(List<FileService> servers) {
        this.servers = servers;
    }

    private int currentServer = 0;

    @Override
    public String downloadFile(String fileId, User user) {
        FileService server = getNextServer();
        return server.downloadFile(fileId, user);
    }

    @Override
    public void uploadFile(String content, String filename, User user) {
        for (FileService server : servers) {
            server.uploadFile(content, filename, user);
        }
    }

    private FileService getNextServer() {
        FileService server = servers.get(currentServer);
        currentServer = (currentServer + 1) % servers.size();
        return server;
    }
}
