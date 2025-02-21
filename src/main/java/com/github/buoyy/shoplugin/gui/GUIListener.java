package com.github.buoyy.shoplugin.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GUIListener implements Listener {
    private final GUIManager manager;
    public GUIListener(GUIManager manager) {
        this.manager = manager;
    }
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        this.manager.handleOpen(e);
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        this.manager.handleClick(e);
    }
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        this.manager.handleClose(e);
    }
}
