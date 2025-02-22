package com.github.buoyy.shoplugin.gui.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class ShopItem {
    private final ItemStack item;
    private final double sell;
    private final double cost;
    private ShopItem(Builder builder) {
        this.item = builder.item;
        this.cost = builder.cost;
        this.sell = builder.sell;
    }
    public ItemStack getItem() {
        return item;
    }

    public double getCost() {
        return cost;
    }

    public double getSell() {
        return sell;
    }

    public static class Builder {
        private ItemStack item;
        private double sell;
        private double cost;
        public static Builder newBuilder() {
            return new Builder();
        }
        public Builder setItem(Material material) {
            this.item = new ItemStack(material);
            return this;
        }
        public Builder setPrices(double sell, double cost) {
            this.cost = cost;
            this.sell = sell;
            ItemMeta meta = this.item.getItemMeta();
            meta.setLore(Arrays.asList(String.format("Cost: %f",this.cost),
                    String.format("Sell: %f", this.sell)));
            item.setItemMeta(meta);
            return this;
        }
        public ShopItem build() {
            return new ShopItem(this);
        }
    }
}
