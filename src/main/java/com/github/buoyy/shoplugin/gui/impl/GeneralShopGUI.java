package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.Shoplugin;
import com.github.buoyy.shoplugin.files.YAML;
import com.github.buoyy.shoplugin.gui.InvButton;
import com.github.buoyy.shoplugin.gui.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class GeneralShopGUI extends InventoryGUI {
    YAML yaml = Shoplugin.getGeneral();
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 36, "General shop");
    }

    @Override
    public void decorate() {
        for (String i: yaml.getConfig().getKeys(false)) {
            InvButton item = InvButton.Builder.newBuilder()
                    .setIcon(Material.valueOf(yaml.getConfig().getString(i+".item")))
                    .setOnClick(e->e.setCancelled(true))
                    .build();
            this.addButton(Integer.parseInt(i), item);
        }
        super.decorate();
    }
}
