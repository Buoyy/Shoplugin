package com.github.buoyy.shoplugin;

import com.github.buoyy.shoplugin.commands.BaseShopCommand;
import com.github.buoyy.shoplugin.files.YAML;
import com.github.buoyy.shoplugin.gui.GUIListener;
import com.github.buoyy.shoplugin.gui.GUIManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Shoplugin extends JavaPlugin {
    private static Messenger messenger;
    private static GUIManager guiManager;
    private static YAML general;
    @Override
    public void onEnable() {
instanceObjects(); getServer().getPluginManager().registerEvents(new GUIListener(guiManager), this);      Objects.requireNonNull(getCommand("shop")).setExecutor(new BaseShopCommand());
    }
    private void instanceObjects() {
        messenger = new Messenger();
        guiManager = new GUIManager();
        general = new YAML("general");
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
