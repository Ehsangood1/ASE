package com.github.ASE.Proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.github.ASE.Proxy.Proxies.Authentication;
import com.github.ASE.Proxy.Proxies.Caching;
import com.github.ASE.Proxy.Proxies.LoadBalancing;
import com.github.ASE.Proxy.Proxies.Logging;
import com.github.ASE.Proxy.Proxies.Retry;

public class App {

    public static void main(String[] args) {
        // Create multiple remote servers
        List<FileService> servers = Arrays.asList(new RemoteFileService("US-East"), new RemoteFileService("EU-West"),
                new RemoteFileService("Asia-Singapore"));

        // Build layered proxy chain
        FileService fileService = new LoadBalancing(servers);
        fileService = new Retry(fileService, 3);
        fileService = new Caching(fileService);
        fileService = new Logging(fileService);
        fileService = new Authentication(fileService, Set.of("admin", "user"));

        // Create users
        User admin = new User("Alice", "admin");
        User user = new User("Trudy", "user");
        User guest = new User("Bob", "guest");

        // Admin uploads a file
        System.out.println("\nAdmin Upload:");
        fileService.uploadFile("Secret Data", "confidential.txt", admin);

        // Admin downloads (cache miss)
        System.out.println("\nAdmin Download (cache miss):");
        System.out.println(fileService.downloadFile("confidential.txt", admin));

        // Guest tries to download (access denied)
        System.out.println("\nGuest Download (access denied):");
        System.out.println(fileService.downloadFile("confidential.txt", guest));

        // Admin downloads again (cache hit)
        System.out.println("\nAdmin Download (cache hit):");
        System.out.println(fileService.downloadFile("confidential.txt", admin));

        // User uploads a file
        System.out.println("\nUser Upload:");
        fileService.uploadFile("Public Data", "public.txt", user);

        // Admin downloads (cache miss)
        System.out.println("\nAdmin Download (cache miss):");
        System.out.println(fileService.downloadFile("public.txt", admin));
    }
}
