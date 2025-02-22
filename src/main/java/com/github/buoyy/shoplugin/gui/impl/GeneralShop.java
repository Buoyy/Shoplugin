package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.Shoplugin;
import com.github.buoyy.shoplugin.files.YAML;
import com.github.buoyy.shoplugin.gui.component.ShopGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class GeneralShop extends ShopGUI {
    YAML yaml = Shoplugin.getGeneral();
    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, 36, "General shop");
    }
    @Override
    public void populate() {
        for (String i: yaml.getConfig().getKeys(false)) {
            ShopItem item = ShopItem.Builder.newBuilder()
                    .setItem(Material.valueOf(yaml.getConfig().getString(i+".item")))
                    .setPrices(yaml.getConfig().getDouble(i+".sell"),
                            yaml.getConfig().getDouble(i+".cost"))
                    .build();
            this.addItem(Integer.parseInt(i), item);
        }
        super.populate();
    }
}
