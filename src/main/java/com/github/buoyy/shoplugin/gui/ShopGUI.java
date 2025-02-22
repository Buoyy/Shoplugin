package com.github.buoyy.shoplugin.gui;

import com.github.buoyy.shoplugin.gui.impl.ShopItem;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public abstract class ShopGUI implements InventoryHandler {
    private final Inventory inv;
    private final Map<Integer, ShopItem> items = new HashMap<>();
    public ShopGUI() {
        this.inv = this.createInventory();
    }
    public Inventory getInv() {
        return inv;
    }
    public void addItem(int slot, ShopItem item) {
        this.items.put(slot, item);
    }
    public void populate() {
        this.items.forEach((i, j)->this.inv.setItem(i, j.getItem()));
    }
    public abstract Inventory createInventory();
    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }

    @Override
    public void onOpen(InventoryOpenEvent e) {
        this.populate();
    }

    @Override
    public void onClose(InventoryCloseEvent e) {

    }
}
