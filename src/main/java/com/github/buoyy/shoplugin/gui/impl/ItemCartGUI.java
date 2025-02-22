package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.Shoplugin;
import com.github.buoyy.shoplugin.gui.component.InvButton;
import com.github.buoyy.shoplugin.gui.component.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class ItemCartGUI extends InventoryGUI {
    private final ShopItem prevItem;
    public ItemCartGUI(ShopItem prevItem) {
        super();
        this.prevItem = prevItem;
    }
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 9, "Cart");
    }

    @Override
    public void decorate() {
        InvButton oneStack = InvButton.Builder.newBuilder()
                .setIcon(Material.BOOK)
                .setName("Buy 1 stack?")
                .setOnClick(e->
                        Shoplugin.getGuiManager()
                                .openGUI((Player)e.getWhoClicked(), new ConfirmationGUI(prevItem, 64)))
                .build();
        InvButton twoStack = InvButton.Builder.newBuilder()
                .setIcon(Material.BOOK)
                .setName("Buy 2 stack?")
                .setOnClick(e->
                        Shoplugin.getGuiManager()
                                .openGUI((Player)e.getWhoClicked(), new ConfirmationGUI(prevItem, 128)))
                .build();
        this.addButton(3, oneStack);
        this.addButton(5, twoStack);
        super.decorate();
    }
}
