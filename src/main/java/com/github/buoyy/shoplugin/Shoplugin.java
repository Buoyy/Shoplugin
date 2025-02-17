package com.github.buoyy.shoplugin;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Shoplugin extends JavaPlugin {
    private static Economy econ = null;
    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe("Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Economy loaded successfully with plugin: " + econ.getName());
    }
    @Override
    public void onDisable() {
        getLogger().info("Bye bye!");
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().severe("Vault was not found in the server!");
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            getLogger().severe("No economy plugin was found in the server!");
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    public static Economy getEconomy() { return econ; }
}
