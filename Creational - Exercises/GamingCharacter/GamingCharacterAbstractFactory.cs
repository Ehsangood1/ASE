// File: GamingCharacter_AbstractFactory.cs
// Namespace suggestion: ASE.Creational.GamingCharacter

using System;

namespace ASE.Creational.GamingCharacter
{
    // ----------- Common Contracts -----------

    public interface ICharacter
    {
        void Attack();
        void Defend();
        string GetDescription();
    }

    public enum CharacterClass
    {
        Warrior,
        Mage
        // Future: Archer, Healer, Rogue, etc.
    }

    // Abstract Factory
    public interface ICharacterFactory
    {
        ICharacter Create(CharacterClass cls);
    }

    // ----------- Medieval Family -----------

    public class MedievalWarrior : ICharacter
    {
        public void Attack() => Console.WriteLine("Medieval Warrior swings a longsword!");
        public void Defend() => Console.WriteLine("Medieval Warrior raises a shield!");
        public string GetDescription() => "Medieval Warrior (steel, honor, melee).";
    }

    public class MedievalMage : ICharacter
    {
        public void Attack() => Console.WriteLine("Medieval Mage casts Fireball!");
        public void Defend() => Console.WriteLine("Medieval Mage conjures a magic barrier!");
        public string GetDescription() => "Medieval Mage (robes, staff, arcane spells).";
    }

    public class MedievalFactory : ICharacterFactory
    {
        public ICharacter Create(CharacterClass cls) => cls switch
        {
            CharacterClass.Warrior => new MedievalWarrior(),
            CharacterClass.Mage    => new MedievalMage(),
            _ => throw new NotSupportedException($"Medieval theme doesn't support {cls}")
        };
    }

    // ----------- Sci-Fi Family -----------

    public class SciFiWarrior : ICharacter
    {
        public void Attack() => Console.WriteLine("Sci-Fi Warrior fires a plasma rifle!");
        public void Defend() => Console.WriteLine("Sci-Fi Warrior deploys an energy shield!");
        public string GetDescription() => "Sci-Fi Warrior (armor, plasma, tactics).";
    }

    public class SciFiMage : ICharacter
    {
        public void Attack() => Console.WriteLine("Sci-Fi Mage launches a nano-swarm!");
        public void Defend() => Console.WriteLine("Sci-Fi Mage projects a phase field!");
        public string GetDescription() => "Sci-Fi Mage (psionics/techno-sorcery).";
    }

    public class SciFiFactory : ICharacterFactory
    {
        public ICharacter Create(CharacterClass cls) => cls switch
        {
            CharacterClass.Warrior => new SciFiWarrior(),
            CharacterClass.Mage    => new SciFiMage(),
            _ => throw new NotSupportedException($"Sci-Fi theme doesn't support {cls}")
        };
    }

    // ----------- Client / Game Layer -----------

    public enum Theme
    {
        Medieval,
        SciFi
        // Future: Fantasy, Cyberpunk, etc.
    }

    // (Optional) Simple resolver: keep theme consistency by selecting one factory up front
    public static class ThemeResolver
    {
        public static ICharacterFactory Resolve(Theme theme) => theme switch
        {
            Theme.Medieval => new MedievalFactory(),
            Theme.SciFi    => new SciFiFactory(),
            _ => throw new NotSupportedException($"Theme {theme} not supported")
        };
    }

    public static class Demo
    {
        public static void Main()
        {
            // Player picks a theme once:
            Theme currentTheme = Theme.Medieval;
            var factory = ThemeResolver.Resolve(currentTheme);

            // All characters now come from the same theme (no mixing):
            ICharacter warrior = factory.Create(CharacterClass.Warrior);
            ICharacter mage    = factory.Create(CharacterClass.Mage);

            Console.WriteLine(warrior.GetDescription());
            warrior.Attack();
            warrior.Defend();

            Console.WriteLine();

            Console.WriteLine(mage.GetDescription());
            mage.Attack();
            mage.Defend();

            Console.WriteLine("\n--- Switch theme to Sci-Fi ---\n");

            // If player switches theme, swap the factory (still consistent within theme):
            factory = ThemeResolver.Resolve(Theme.SciFi);

            warrior = factory.Create(CharacterClass.Warrior);
            mage    = factory.Create(CharacterClass.Mage);

            Console.WriteLine(warrior.GetDescription());
            warrior.Attack();
            warrior.Defend();

            Console.WriteLine();

            Console.WriteLine(mage.GetDescription());
            mage.Attack();
            mage.Defend();
        }
    }
}
