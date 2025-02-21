package com.github.buoyy.shoplugin;

import com.github.buoyy.shoplugin.commands.BaseShopCommand;
import com.github.buoyy.shoplugin.files.YAML;
import com.github.buoyy.shoplugin.gui.GUIListener;
import com.github.buoyy.shoplugin.gui.GUIManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Shoplugin extends JavaPlugin {
    private static final Messenger messenger = new Messenger();
    private static final GUIManager guiManager = new GUIManager();
    private static final YAML general = new YAML("general");
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GUIListener(guiManager), this);
        Objects.requireNonNull(getCommand("shop")).setExecutor(new BaseShopCommand());
    }
    public static GUIManager getGuiManager() {
        return guiManager;
    }
    public static YAML getGeneral() {
        return general;
    }
    public static Messenger getMessenger() {
        return messenger;
    }
}
