#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

class ConfigManager {
    unordered_map<string, string> properties;

    ConfigManager() {
        reset();
    };

    ~ConfigManager() = default;

    ConfigManager(const ConfigManager &) = delete;
    ConfigManager &operator=(const ConfigManager &) = delete;
    ConfigManager(ConfigManager &&) = delete;
    ConfigManager &operator=(ConfigManager &&) = delete;

public:
    static ConfigManager &getInstance() {
        static ConfigManager instance;
        return instance;
    }

    void setProperty(const string &key, const string &value) {
        properties.emplace(key, value);
    }

    void reset() {
        properties.clear();
        setProperty("databaseURL", "jdbc:mysql://localhost:3306/mydb");
        setProperty("maxConnections", "10");
        setProperty("theme", "dark");
        setProperty("logLevel", "INFO");
    }

    string getProperty(const string &key) const {
        auto it = properties.find(key);
        if (it != properties.end()) {
            return it->second;
        }
        return "NOT_FOUND";
    }

    string toJSON() const {
        string json = "{\n";
        for (const auto &pair : properties) {
            json += "   \"" + pair.first + "\": \"" + pair.second + "\",\n";
        }
        if (json.size() > 2) {
            json.pop_back();
            json.pop_back();
        }
        json += "\n}\n";
        return json;
    }
};

int main(int, char **) {
    cout << ConfigManager::getInstance().getProperty("UnknownKey") << endl << endl;
    cout << ConfigManager::getInstance().toJSON() << endl;

    ConfigManager::getInstance().setProperty("persistent", "true");
    cout << ConfigManager::getInstance().toJSON() << endl;

    return 0;
}
