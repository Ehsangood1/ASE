// Program.cs
using System;
using System.IO;
using System.Collections.Generic;

// ---------- Product ----------
public interface ILogger
{
    void Debug(string message);
    void Info(string message);
    void Warning(string message);
    void Error(string message);
}

// ---------- Concrete Products ----------
public sealed class ConsoleLogger : ILogger
{
    public void Debug(string message)   => Write("DEBUG", message);
    public void Info(string message)    => Write("INFO", message);
    public void Warning(string message) => Write("WARN", message);
    public void Error(string message)   => Write("ERROR", message);

    private static void Write(string level, string message)
        => Console.WriteLine($"{DateTime.UtcNow:O} [{level}] {message}");
}

public sealed class FileLogger : ILogger, IDisposable
{
    private readonly string _path;
    private readonly object _lock = new();
    private readonly StreamWriter _writer;

    public FileLogger(string path)
    {
        _path = path;
        Directory.CreateDirectory(Path.GetDirectoryName(path) ?? ".");
        _writer = new StreamWriter(new FileStream(_path, FileMode.Append, FileAccess.Write, FileShare.Read))
        { AutoFlush = true };
    }

    public void Debug(string message)   => Write("DEBUG", message);
    public void Info(string message)    => Write("INFO", message);
    public void Warning(string message) => Write("WARN", message);
    public void Error(string message)   => Write("ERROR", message);

    private void Write(string level, string message)
    {
        lock (_lock)
        {
            _writer.WriteLine($"{DateTime.UtcNow:O} [{level}] {message}");
        }
    }

    public void Dispose() => _writer.Dispose();
}

// Minimal “DB” example for the exercise: store rows in-memory to simulate persistence.
// Swap this with a real database implementation later (e.g., Microsoft.Data.Sqlite).
public sealed class DatabaseLogger : ILogger
{
    private readonly List<(DateTime ts, string level, string msg)> _rows = new();

    public void Debug(string message)   => Insert("DEBUG", message);
    public void Info(string message)    => Insert("INFO", message);
    public void Warning(string message) => Insert("WARN", message);
    public void Error(string message)   => Insert("ERROR", message);

    private void Insert(string level, string msg)
    {
        _rows.Add((DateTime.UtcNow, level, msg));
        // For demo visibility:
        Console.WriteLine($"[DB] inserted row: {DateTime.UtcNow:O} [{level}] {msg}");
    }

    // Helper so tests/clients could read back (not part of ILogger)
    public IReadOnlyList<(DateTime ts, string level, string msg)> Dump() => _rows.AsReadOnly();
}

// ---------- Creator (Factory Method) ----------
public abstract class LoggerCreator
{
    // Factory Method
    public abstract ILogger CreateLogger();

    // Optional common operation that uses the product
    public void LogStartupBanner()
    {
        var logger = CreateLogger();
        logger.Info("Logger initialized.");
    }
}

// ---------- Concrete Creators ----------
public sealed class ConsoleLoggerCreator : LoggerCreator
{
    public override ILogger CreateLogger() => new ConsoleLogger();
}

public sealed class FileLoggerCreator : LoggerCreator
{
    private readonly string _path;
    public FileLoggerCreator(string path) => _path = path;
    public override ILogger CreateLogger() => new FileLogger(_path);
}

public sealed class DatabaseLoggerCreator : LoggerCreator
{
    public override ILogger CreateLogger() => new DatabaseLogger();
}

// ---------- Simple configuration discriminator (optional) ----------
public enum LoggerKind { Console, File, Database }

public static class LoggerCreatorFactory // helper to pick a Creator from config
{
    public static LoggerCreator From(LoggerKind kind, string? filePath = null) => kind switch
    {
        LoggerKind.Console  => new ConsoleLoggerCreator(),
        LoggerKind.File     => new FileLoggerCreator(filePath ?? "logs/app.log"),
        LoggerKind.Database => new DatabaseLoggerCreator(),
        _ => throw new ArgumentOutOfRangeException(nameof(kind))
    };
}

// ---------- Client ----------
public static class Program
{
    public static void Main(string[] args)
    {
        // Example: choose logger from args/env/config (client never new()s the concrete logger)
        LoggerKind kind = LoggerKind.Console;
        string? path = null;

        if (args.Length > 0 && Enum.TryParse<LoggerKind>(args[0], true, out var parsed))
            kind = parsed;
        if (args.Length > 1) path = args[1];

        var creator = LoggerCreatorFactory.From(kind, path);
        creator.LogStartupBanner(); // uses the product without knowing which one

        using var logger = creator.CreateLogger() as IDisposable ?? NullDisposable.Instance;
        var log = (creator.CreateLogger()); // create a fresh logger for demonstration

        log.Debug("Debug details for developers.");
        log.Info("Service started.");
        log.Warning("Disk space at 85%.");
        log.Error("Unable to connect to upstream service.");

        // If you need to prove extensibility:
        // 1) Add class CloudLogger : ILogger
        // 2) Add CloudLoggerCreator : LoggerCreator
        // 3) Extend LoggerKind and LoggerCreatorFactory — no change to client logic.
    }

    private sealed class NullDisposable : IDisposable
    {
        public static readonly NullDisposable Instance = new();
        public void Dispose() { }
    }
}
