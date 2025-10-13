// File: ComputerAssembly_Builder.cs
// Namespace suggestion: ASE.Creational.ComputerAssembly
// Focus: Class design with minimal logic (prints). Method chaining + Director.
// Optional: Simple Singleton catalog to centralize model names.

using System;
using System.Collections.Generic;

namespace ASE.Creational.ComputerAssembly
{
    // ----- Product -----
    public class Computer
    {
        public string Motherboard { get; set; }
        public string CPU { get; set; }
        public int RamGB { get; set; }
        public List<string> Storage { get; } = new List<string>();
        public string Graphics { get; set; } // null or "Integrated" or model name
        public int PowerSupplyWatt { get; set; }
        public string Case { get; set; }
        public string Cooling { get; set; }   // null or model name

        public void Summary()
        {
            Console.WriteLine("===== COMPUTER SUMMARY =====");
            Console.WriteLine($"Motherboard : {Motherboard}");
            Console.WriteLine($"CPU         : {CPU}");
            Console.WriteLine($"RAM         : {RamGB} GB");
            Console.WriteLine($"Storage     : {(Storage.Count == 0 ? "-" : string.Join(", ", Storage))}");
            Console.WriteLine($"Graphics    : {(string.IsNullOrWhiteSpace(Graphics) ? "None" : Graphics)}");
            Console.WriteLine($"PSU         : {PowerSupplyWatt} W");
            Console.WriteLine($"Case        : {Case}");
            Console.WriteLine($"Cooling     : {(string.IsNullOrWhiteSpace(Cooling) ? "Stock / None" : Cooling)}");
            Console.WriteLine("============================");
            Console.WriteLine();
        }
    }

    // ----- Builder interface -----
    public interface IComputerBuilder
    {
        IComputerBuilder WithMotherboard(string model);
        IComputerBuilder WithCPU(string model);
        IComputerBuilder WithRAM(int gb);
        IComputerBuilder AddStorage(string drive);
        IComputerBuilder WithIntegratedGraphics();         // optional path
        IComputerBuilder WithGraphics(string model);       // optional path
        IComputerBuilder WithPowerSupply(int watt);
        IComputerBuilder WithCase(string model);
        IComputerBuilder WithCooling(string model);        // optional
        Computer Build();
    }

    // ----- Concrete Builder (method chaining) -----
    public class ComputerBuilder : IComputerBuilder
    {
        private readonly Computer _pc = new Computer();

        public IComputerBuilder WithMotherboard(string model)
        {
            _pc.Motherboard = model;
            return this;
        }

        public IComputerBuilder WithCPU(string model)
        {
            _pc.CPU = model;
            return this;
        }

        public IComputerBuilder WithRAM(int gb)
        {
            _pc.RamGB = gb;
            return this;
        }

        public IComputerBuilder AddStorage(string drive)
        {
            _pc.Storage.Add(drive);
            return this;
        }

        public IComputerBuilder WithIntegratedGraphics()
        {
            _pc.Graphics = "Integrated";
            return this;
        }

        public IComputerBuilder WithGraphics(string model)
        {
            _pc.Graphics = model;
            return this;
        }

        public IComputerBuilder WithPowerSupply(int watt)
        {
            _pc.PowerSupplyWatt = watt;
            return this;
        }

        public IComputerBuilder WithCase(string model)
        {
            _pc.Case = model;
            return this;
        }

        public IComputerBuilder WithCooling(string model)
        {
            _pc.Cooling = model;
            return this;
        }

        public Computer Build()
        {
            // Minimal validation to show intent (optional; keep simple)
            if (string.IsNullOrWhiteSpace(_pc.Motherboard))
                throw new InvalidOperationException("Motherboard is required.");
            if (string.IsNullOrWhiteSpace(_pc.CPU))
                throw new InvalidOperationException("CPU is required.");
            if (_pc.RamGB <= 0)
                throw new InvalidOperationException("RAM is required.");
            if (_pc.Storage.Count == 0)
                throw new InvalidOperationException("At least one storage device is required.");
            if (_pc.PowerSupplyWatt <= 0)
                throw new InvalidOperationException("Power Supply is required.");
            if (string.IsNullOrWhiteSpace(_pc.Case))
                throw new InvalidOperationException("Case is required.");

            return _pc;
        }
    }

    // ----- Director (captures standard recipes) -----
    public class PresetDirector
    {
        private readonly ComponentCatalog _c = ComponentCatalog.Instance; // optional Singleton use

        public Computer BuildOffice(IComputerBuilder b)
        {
            return b.WithMotherboard(_c.MoboBasic)
                    .WithCPU(_c.CpuBasic)
                    .WithRAM(8)
                    .AddStorage(_c.Ssd512)
                    .WithIntegratedGraphics()
                    .WithPowerSupply(450)
                    .WithCase(_c.CaseCompact)
                    // cooling optional for office; omit or use stock
                    .Build();
        }

        public Computer BuildGaming(IComputerBuilder b)
        {
            return b.WithMotherboard(_c.MoboGaming)
                    .WithCPU(_c.CpuGaming)
                    .WithRAM(16)                 // 16GB+
                    .AddStorage(_c.Ssd1Tb)
                    .WithGraphics(_c.GpuHighEnd)
                    .WithPowerSupply(750)
                    .WithCase(_c.CaseMidTowerRgb)
                    .WithCooling(_c.CoolingAio240) // Advanced Cooling
                    .Build();
        }

        public Computer BuildWorkstation(IComputerBuilder b)
        {
            return b.WithMotherboard(_c.MoboPro)
                    .WithCPU(_c.CpuPro)
                    .WithRAM(32)                  // 32GB+
                    .AddStorage(_c.Ssd2Tb)
                    .AddStorage(_c.Hdd4Tb)
                    .WithGraphics(_c.GpuPro)
                    .WithPowerSupply(850)         // High-wattage PSU
                    .WithCase(_c.CaseFullTower)
                    .WithCooling(_c.CoolingAio360)
                    .Build();
        }

        public Computer BuildBudget(IComputerBuilder b)
        {
            return b.WithMotherboard(_c.MoboBasic)
                    .WithCPU(_c.CpuEntry)
                    .WithRAM(4)
                    .AddStorage(_c.Hdd1Tb)
                    .WithPowerSupply(400)
                    .WithCase(_c.CaseBasic)
                    // no discrete GPU; no advanced cooling
                    .Build();
        }
    }

    // ----- Optional Singleton: central component names (simple, non-thread-safe) -----
    public sealed class ComponentCatalog
    {
        private static ComponentCatalog _instance;
        public static ComponentCatalog Instance => _instance ??= new ComponentCatalog();
        private ComponentCatalog() { }

        public string MoboBasic => "mATX Basic Board";
        public string MoboGaming => "ATX Gaming Board";
        public string MoboPro => "ATX Workstation Board";

        public string CpuEntry => "Entry CPU";
        public string CpuBasic => "Basic CPU";
        public string CpuGaming => "Gaming CPU";
        public string CpuPro => "Professional CPU";

        public string GpuHighEnd => "High-end Graphics";
        public string GpuPro => "Professional Graphics";

        public string Ssd512 => "512GB SSD";
        public string Ssd1Tb => "1TB NVMe SSD";
        public string Ssd2Tb => "2TB NVMe SSD";
        public string Hdd1Tb => "1TB HDD";
        public string Hdd4Tb => "4TB HDD";

        public string CaseCompact => "Compact Case";
        public string CaseBasic => "Basic Case";
        public string CaseMidTowerRgb => "Mid Tower RGB";
        public string CaseFullTower => "Full Tower";

        public string CoolingAio240 => "AIO 240mm";
        public string CoolingAio360 => "AIO 360mm";
    }

    // ----- Demo / Client (clients don't know details; they just ask the Director) -----
    public static class Demo
    {
        public static void Main()
        {
            var director = new PresetDirector();

            var office = director.BuildOffice(new ComputerBuilder());
            var gaming = director.BuildGaming(new ComputerBuilder());
            var workstation = director.BuildWorkstation(new ComputerBuilder());
            var budget = director.BuildBudget(new ComputerBuilder());

            office.Summary();
            gaming.Summary();
            workstation.Summary();
            budget.Summary();
        }
    }
}
