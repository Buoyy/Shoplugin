package com.github.buoyy.shoplugin.commands;

import com.github.buoyy.shoplugin.Shoplugin;
import com.github.buoyy.shoplugin.gui.GUIManager;
import com.github.buoyy.shoplugin.gui.impl.BaseGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BaseShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Player only command.");
            return true;
        }
        Shoplugin.getGuiManager().openGUI(player, new BaseGUI());
        return true;
    }
}
