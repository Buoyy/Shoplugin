package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.gui.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class ShopCartGUI extends InventoryGUI {
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 9, "Cart");
    }

}
