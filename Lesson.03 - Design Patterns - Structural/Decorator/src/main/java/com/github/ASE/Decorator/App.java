package com.github.ASE.Decorator;

import com.github.ASE.Decorator.Components.BasicStreamingService;
import com.github.ASE.Decorator.Components.StreamingService;
import com.github.ASE.Decorator.Decorators.FourKService;
import com.github.ASE.Decorator.Decorators.HDService;
import com.github.ASE.Decorator.Decorators.OfflineService;
import com.github.ASE.Decorator.Decorators.PremiumService;

public class App {

    public static void main(String[] args) {
        // Basic subscription
        StreamingService basic = new BasicStreamingService();
        System.out.println("Basic Subscription:");
        basic.streamContent("Movie: The Matrix");
        System.out.println("Monthly Cost: $" + basic.getCost() + "\n");

        // Basic + HD + Offline
        StreamingService hdOffline = new OfflineService(new HDService(new BasicStreamingService()));
        System.out.println("Basic + HD + Offline:");
        hdOffline.streamContent("Movie: Inception");
        System.out.println("Monthly Cost: $" + hdOffline.getCost() + "\n");

        // Basic + 4K + Premium Content
        StreamingService fourKPremium = new PremiumService(new FourKService(new BasicStreamingService()));
        System.out.println("Basic + 4K + Premium Content:");
        fourKPremium.streamContent("Movie: Avatar");
        System.out.println("Monthly Cost: $" + fourKPremium.getCost() + "\n");

        // All features combined
        StreamingService ultimate = new OfflineService(
                new PremiumService(new FourKService(new HDService(new BasicStreamingService()))));
        System.out.println("Ultimate Plan (All Features):");
        ultimate.streamContent("Movie: Dune");
        System.out.println("Monthly Cost: $" + ultimate.getCost());
    }
}
