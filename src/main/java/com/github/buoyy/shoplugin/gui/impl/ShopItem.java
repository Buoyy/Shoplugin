package com.github.buoyy.shoplugin.gui.impl;

import com.github.buoyy.shoplugin.gui.InvButton;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShopItem {
    private final ItemStack item;
    private final float sell;
    private final float cost;
    private ShopItem(Builder builder) {
        this.item = builder.item;
        this.cost = builder.cost;
        this.sell = builder.sell;
    }

    public ItemStack getItem() {
        return item;
    }

    public float getCost() {
        return cost;
    }

    public float getSell() {
        return sell;
    }

    public static class Builder {
        private ItemStack item;
        private float sell;
        private float cost;
        public Builder setItem(Material material) {
            this.item = new ItemStack(material);
            return this;
        }
        public Builder setPrices(float sell, float cost) {
            this.cost = cost;
            this.sell = sell;
            return this;
        }
        public ShopItem build() {
            return new ShopItem(this);
        }
    }
}
