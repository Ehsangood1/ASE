/*
Exercise: NetworkConfiguration
Pattern: Prototype (+ optional Singleton registry)
Reasoning:
- Engineers deploy many similar networks with small variations -> clone a vetted template then tweak.
- Reduces time and config errors versus building from scratch.
- Registry (Singleton) centrally exposes corporate/data center/branch templates.

Notes:
- Focus on design; minimal logic (prints).
*/

using System;
using System.Collections.Generic;

namespace ASE.Creational.NetworkConfiguration
{
    // ---------- Prototype contract ----------
    public interface IPrototype<T>
    {
        T Clone(); // Deep(ish) clone for our nested structure
    }

    // ---------- Model (composed sections) ----------
    public class NetworkConfig : IPrototype<NetworkConfig>
    {
        public BasicInfo Basic { get; set; } = new();
        public Topology Topology { get; set; } = new();
        public Security Security { get; set; } = new();
        public Devices Devices { get; set; } = new();
        public Performance Performance { get; set; } = new();
        public Monitoring Monitoring { get; set; } = new();

        // Deep clone (manual but clear)
        public NetworkConfig Clone()
        {
            return new NetworkConfig
            {
                Basic = Basic.Clone(),
                Topology = Topology.Clone(),
                Security = Security.Clone(),
                Devices = Devices.Clone(),
                Performance = Performance.Clone(),
                Monitoring = Monitoring.Clone()
            };
        }

        public void Summary()
        {
            Console.WriteLine("==== NETWORK CONFIG ====");
            Console.WriteLine($"ID: {Basic.NetworkId} | Client: {Basic.ClientName} | Type: {Basic.DeploymentType} | Date: {Basic.CreationDate:yyyy-MM-dd}");
            Console.WriteLine($"Topology: IPs={string.Join(";", Topology.IpRanges)} | VLANs={string.Join(",", Topology.Vlans)} | Subnets={string.Join(",", Topology.Subnets)}");
            Console.WriteLine($"Security: FW rules={Security.FirewallRules.Count} | ACLs={Security.AccessControls.Count} | Enc={Security.Encryption}");
            Console.WriteLine($"Devices: Router={Devices.RouterModel} | Switches={string.Join(",", Devices.SwitchModels)} | APs={Devices.WapModels.Count}");
            Console.WriteLine($"Performance: BW={Performance.BandwidthMbps}Mbps | QoS={string.Join(",", Performance.QosRules)} | Shaping={Performance.TrafficShaping}");
            Console.WriteLine($"Monitoring: Alerts={Monitoring.AlertThreshold} | Logging={Monitoring.LoggingLevel} | Health={string.Join(",", Monitoring.HealthChecks)}");
            Console.WriteLine("========================\n");
        }
    }

    public class BasicInfo : IPrototype<BasicInfo>
    {
        public string NetworkId { get; set; } = "TEMPLATE";
        public string ClientName { get; set; } = "TEMPLATE";
        public string DeploymentType { get; set; } = "TEMPLATE";
        public DateTime CreationDate { get; set; } = DateTime.UtcNow;

        public BasicInfo Clone() => new BasicInfo
        {
            NetworkId = NetworkId,
            ClientName = ClientName,
            DeploymentType = DeploymentType,
            CreationDate = CreationDate
        };
    }

    public class Topology : IPrototype<Topology>
    {
        public List<string> IpRanges { get; set; } = new();   // e.g., "10.0.0.0/16"
        public List<string> Subnets { get; set; } = new();    // e.g., "10.0.10.0/24"
        public List<int> Vlans { get; set; } = new();         // e.g., 10, 20, 30

        public Topology Clone() => new Topology
        {
            IpRanges = new List<string>(IpRanges),
            Subnets = new List<string>(Subnets),
            Vlans = new List<int>(Vlans)
        };
    }

    public class Security : IPrototype<Security>
    {
        public List<string> FirewallRules { get; set; } = new();   // "ALLOW Web -> App 80/TCP"
        public List<string> AccessControls { get; set; } = new();  // "HR VLAN -> Payroll DB read"
        public string Encryption { get; set; } = "None";           // "IPSec", "TLS", "WPA3-Enterprise"

        public Security Clone() => new Security
        {
            FirewallRules = new List<string>(FirewallRules),
            AccessControls = new List<string>(AccessControls),
            Encryption = Encryption
        };
    }

    public class Devices : IPrototype<Devices>
    {
        public string RouterModel { get; set; } = "Router-X";
        public List<string> SwitchModels { get; set; } = new();
        public List<string> WapModels { get; set; } = new();

        public Devices Clone() => new Devices
        {
            RouterModel = RouterModel,
            SwitchModels = new List<string>(SwitchModels),
            WapModels = new List<string>(WapModels)
        };
    }

    public class Performance : IPrototype<Performance>
    {
        public int BandwidthMbps { get; set; } = 100;
        public List<string> QosRules { get; set; } = new();
        public string TrafficShaping { get; set; } = "None";

        public Performance Clone() => new Performance
        {
            BandwidthMbps = BandwidthMbps,
            QosRules = new List<string>(QosRules),
            TrafficShaping = TrafficShaping
        };
    }

    public class Monitoring : IPrototype<Monitoring>
    {
        public string AlertThreshold { get; set; } = "Normal";
        public string LoggingLevel { get; set; } = "Info";
        public List<string> HealthChecks { get; set; } = new(); // "Ping GW", "HTTP 200 on portal"

        public Monitoring Clone() => new Monitoring
        {
            AlertThreshold = AlertThreshold,
            LoggingLevel = LoggingLevel,
            HealthChecks = new List<string>(HealthChecks)
        };
    }

    // ---------- Optional Singleton: template registry ----------
    public sealed class TemplateRegistry
    {
        private static TemplateRegistry? _instance;
        public static TemplateRegistry Instance => _instance ??= new TemplateRegistry();
        private TemplateRegistry() { }

        public NetworkConfig CorporateTemplate()
        {
            var cfg = new NetworkConfig();
            cfg.Basic.DeploymentType = "Corporate";
            cfg.Topology.IpRanges.Add("10.0.0.0/16");
            cfg.Topology.Vlans.AddRange(new[] { 10, 20, 30 }); // HR, ENG, GUEST
            cfg.Security.FirewallRules.Add("ALLOW ENG->Internet 80,443/TCP");
            cfg.Security.AccessControls.Add("GUEST VLAN -> Internet only");
            cfg.Security.Encryption = "TLS/IPSec";
            cfg.Devices.RouterModel = "EdgeRouter-Enterprise";
            cfg.Devices.SwitchModels.AddRange(new[] { "CoreSwitch-48", "AccessSwitch-24" });
            cfg.Performance.BandwidthMbps = 1000;
            cfg.Performance.QosRules.Add("VOIP > VIDEO > BULK");
            cfg.Monitoring.AlertThreshold = "Conservative";
            cfg.Monitoring.LoggingLevel = "Info";
            cfg.Monitoring.HealthChecks.AddRange(new[] { "Ping GW", "HTTP 200 CorpPortal" });
            return cfg;
        }

        public NetworkConfig DataCenterTemplate()
        {
            var cfg = new NetworkConfig();
            cfg.Basic.DeploymentType = "DataCenter";
            cfg.Topology.IpRanges.Add("172.16.0.0/12");
            cfg.Topology.Vlans.AddRange(new[] { 100, 200, 300 }); // Web, App, DB
            cfg.Security.FirewallRules.Add("ALLOW Web->App 80,443/TCP");
            cfg.Security.FirewallRules.Add("ALLOW App->DB 5432/TCP");
            cfg.Security.AccessControls.Add("Only Ops to Core via jump host");
            cfg.Security.Encryption = "TLS everywhere";
            cfg.Devices.RouterModel = "DC-Edge-HA";
            cfg.Devices.SwitchModels.AddRange(new[] { "Leaf-48x25G", "Spine-32x100G" });
            cfg.Performance.BandwidthMbps = 100000; // 100 Gbps logical aggregate (illustrative)
            cfg.Performance.QosRules.Add("DB replication priority");
            cfg.Performance.TrafficShaping = "BurstAware";
            cfg.Monitoring.AlertThreshold = "Strict";
            cfg.Monitoring.LoggingLevel = "Verbose";
            cfg.Monitoring.HealthChecks.AddRange(new[] { "BGP Up", "L4 LB Health", "DB Replication" });
            return cfg;
        }

        public NetworkConfig BranchTemplate()
        {
            var cfg = new NetworkConfig();
            cfg.Basic.DeploymentType = "Branch";
            cfg.Topology.IpRanges.Add("192.168.10.0/24");
            cfg.Topology.Vlans.AddRange(new[] { 10, 20 }); // Corp, Guest
            cfg.Security.FirewallRules.Add("ALLOW Corp->HQ VPN");
            cfg.Security.AccessControls.Add("Guest -> Internet only");
            cfg.Security.Encryption = "IPSec (Site-to-Site)";
            cfg.Devices.RouterModel = "BranchRouter-VPN";
            cfg.Devices.SwitchModels.Add("AccessSwitch-8");
            cfg.Devices.WapModels.Add("WAP-DualBand");
            cfg.Performance.BandwidthMbps = 200;
            cfg.Performance.QosRules.Add("Prioritize VPN + VOIP");
            cfg.Monitoring.AlertThreshold = "Normal";
            cfg.Monitoring.LoggingLevel = "Info";
            cfg.Monitoring.HealthChecks.AddRange(new[] { "VPN Tunnel", "ISP Latency" });
            return cfg;
        }
    }

    // ---------- Example “tweak” helpers (fluent modifiers) ----------
    public static class Tweaks
    {
        public static NetworkConfig WithClient(this NetworkConfig cfg, string client, string networkId)
        {
            cfg.Basic.ClientName = client;
            cfg.Basic.NetworkId = networkId;
            cfg.Basic.CreationDate = DateTime.UtcNow;
            return cfg;
        }

        public static NetworkConfig WithExtraSubnet(this NetworkConfig cfg, string cidr)
        {
            cfg.Topology.Subnets.Add(cidr);
            return cfg;
        }

        public static NetworkConfig WithBandwidth(this NetworkConfig cfg, int mbps)
        {
            cfg.Performance.BandwidthMbps = mbps;
            return cfg;
        }

        public static NetworkConfig WithAdditionalAcl(this NetworkConfig cfg, string acl)
        {
            cfg.Security.AccessControls.Add(acl);
            return cfg;
        }

        public static NetworkConfig WithWirelessAp(this NetworkConfig cfg, string model)
        {
            cfg.Devices.WapModels.Add(model);
            return cfg;
        }
    }

    // ---------- Demo (no Main here; call Demo.Run() from your playground) ----------
    public static class Demo
    {
        public static void Run()
        {
            var templates = TemplateRegistry.Instance;

            // 1) Corporate base -> clone & tweak for ACME Inc.
            var corpAcme = templates.CorporateTemplate().Clone()
                                .WithClient("ACME Inc.", "ACME-CORP-001")
                                .WithExtraSubnet("10.0.50.0/24")
                                .WithBandwidth(2000) // 2 Gbps
                                .WithAdditionalAcl("ENG VLAN -> GitServer read");

            // 2) Data Center base -> clone & tweak for MegaCloud
            var dcMega = templates.DataCenterTemplate().Clone()
                                .WithClient("MegaCloud", "MC-DC-042")
                                .WithBandwidth(200000) // 200 Gbps (illustrative)
                                .WithAdditionalAcl("Ops -> K8s API restricted");

            // 3) Branch base -> clone & tweak for Shop-12
            var brShop = templates.BranchTemplate().Clone()
                                .WithClient("Shop-12", "SHOP-BR-12")
                                .WithWirelessAp("WAP-TriBand-6E");

            corpAcme.Summary();
            dcMega.Summary();
            brShop.Summary();
        }
    }
}
