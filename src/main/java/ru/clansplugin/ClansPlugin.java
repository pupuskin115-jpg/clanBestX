package ru.clansplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class ClansPlugin extends JavaPlugin {
    private static ClansPlugin instance;
    private ClanManager clanManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        clanManager = new ClanManager(this);
        getCommand("clan").setExecutor(new ClanCommand(this));
        getServer().getPluginManager().registerEvents(new ClanListener(this), this);
        getLogger().info("§aClansPlugin загружен! Русские кланы готовы.");
    }

    @Override
    public void onDisable() {
        clanManager.saveClans();
        getLogger().info("ClansPlugin выключен.");
    }

    public static ClansPlugin getInstance() { return instance; }
    public ClanManager getClanManager() { return clanManager; }
}
