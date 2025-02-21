package com.github.buoyy.shoplugin.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public abstract class InvButton {
    private final ItemStack icon;
    public InvButton(ItemStack icon) {
        this.icon = icon;
    }

    public ItemStack getIcon() {
        return icon;
    }
    public abstract void onClick(InventoryClickEvent e);
}
