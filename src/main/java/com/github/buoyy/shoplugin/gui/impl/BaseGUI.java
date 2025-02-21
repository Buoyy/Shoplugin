package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.gui.InvButton;
import com.github.buoyy.shoplugin.gui.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class BaseGUI extends InventoryGUI {
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 9, "SHOP");
    }

    @Override
    public void decorate() {
        InvButton generalShop = InvButton.Builder.newBuilder()
                .setIcon(Material.STONE_PICKAXE)
                .setOnClick(e -> {
                    e.setCancelled(true);
                    e.getWhoClicked().sendMessage("You opened player owned shop.");
                })
                .setName("General shop")
                .setLore("The shop where general",
                        "items like stone, coal, etc",
                        "are found.")
                .build();
        InvButton playerShop = InvButton.Builder.newBuilder()
                .setIcon(Material.ENCHANTED_BOOK)
                .setOnClick(e -> {
                    e.setCancelled(true);
                    e.getWhoClicked().sendMessage("You opened player owned shop.");
                })
                .setName("Player owned shop")
                .setLore("These are shops where",
                        "players choose their own",
                        "stocks, usually precious stuff.")
                .build();
        this.addButton(2, generalShop);
        this.addButton(6, playerShop);
        super.decorate();
    }
}
