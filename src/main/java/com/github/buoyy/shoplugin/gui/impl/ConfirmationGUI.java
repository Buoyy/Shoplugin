package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.gui.component.InvButton;
import com.github.buoyy.shoplugin.gui.component.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class ConfirmationGUI extends InventoryGUI {
    private final ShopItem item;
    private final int amount;
    public ConfirmationGUI(ShopItem item, int amount) {
        super();
        this.item = item;
        this.amount = amount;
    }
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 9, "Confirmation");
    }

    @Override
    public void decorate() {
        InvButton accept = InvButton.Builder.newBuilder()
                .setIcon(Material.GREEN_CONCRETE)
                .setName("Accept?")
                .setOnClick(e->{
                    e.getWhoClicked().closeInventory();
                    //TODO: Actual transaction code
                    e.getWhoClicked().sendMessage((amount*item.getCost())+" currency was credited from your account" +
                            "\nYou bought "+amount+item.getItem().getItemMeta().getDisplayName());
                })
                .build();
        this.addButton(3,accept);
        InvButton reject = InvButton.Builder.newBuilder()
                .setIcon(Material.RED_CONCRETE)
                .setName("Reject?")
                .setOnClick(e->{
                    e.getWhoClicked().closeInventory();
                    //TODO: Actual transaction code
                    e.getWhoClicked().sendMessage("You exited the transaction.");
                })
                .build();
        this.addButton(5, reject);
        super.decorate();
    }
}
