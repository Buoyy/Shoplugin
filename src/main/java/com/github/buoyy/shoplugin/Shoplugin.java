package com.github.buoyy.shoplugin;

import com.github.buoyy.shoplugin.commands.BaseShopCommand;
import com.github.buoyy.shoplugin.gui.GUIListener;
import com.github.buoyy.shoplugin.gui.GUIManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Shoplugin extends JavaPlugin {
    @Override
    public void onEnable() {
        GUIManager guiManager = new GUIManager();
        getServer().getPluginManager().registerEvents(new GUIListener(guiManager), this);
        Objects.requireNonNull(getCommand("shop")).setExecutor(new BaseShopCommand(guiManager));
    }
}
