package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.gui.InvButton;
import com.github.buoyy.shoplugin.gui.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public class BaseGUI extends InventoryGUI {
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 9, "SHOP");
    }

    @Override
    public void decorate() {
        this.addButton(2, new InvButton(new ItemStack(Material.DIAMOND)) {
            @Override
            public void onClick(InventoryClickEvent e) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("You opened general shop.");
            }
        });
        this.addButton(6, new InvButton(new ItemStack(Material.GOLD_BLOCK)) {
            @Override
            public void onClick(InventoryClickEvent e) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("You opened player owned shop.");
            }
        });
        super.decorate();
    }
}
