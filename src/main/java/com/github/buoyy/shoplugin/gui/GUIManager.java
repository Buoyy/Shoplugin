package com.github.buoyy.shoplugin.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {
    private final Map<Inventory, InventoryHandler> activeInvs = new HashMap<>();
    public void registerInv(Inventory inv, InventoryHandler handler) {
        this.activeInvs.put(inv, handler);
    }
    public void unregisterInv(Inventory inv) {
        this.activeInvs.remove(inv);
    }

    public void handleClick(InventoryClickEvent e) {
        InventoryHandler handler = this.activeInvs.get(e.getInventory());
        if (handler != null)
            handler.onClick(e);
    }
    public void handleOpen(InventoryOpenEvent e) {
        InventoryHandler handler = this.activeInvs.get(e.getInventory());
        if (handler != null)
            handler.onOpen(e);
    }
    public void handleClose(InventoryCloseEvent e) {
        InventoryHandler handler = this.activeInvs.get(e.getInventory());
        if (handler != null) {
            handler.onClose(e);
            this.unregisterInv(e.getInventory());
        }
    }
    public void openGUI(InventoryGUI gui, Player player) {
        this.registerInv(gui.getInv(), gui);
        player.openInventory(gui.getInv());
    }
}
