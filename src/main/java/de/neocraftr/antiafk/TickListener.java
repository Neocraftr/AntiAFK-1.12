package de.neocraftr.antiafk;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Timer;
import java.util.TimerTask;

public class TickListener {

    private boolean afkMenuOpen;

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent e) {
        if(e.phase == TickEvent.Phase.START) {
            EntityPlayerSP player = Minecraft.getMinecraft().player;
            Container cont = player.openContainer;
            if(cont instanceof ContainerChest) {
                if(!afkMenuOpen) {
                    ContainerChest chest = ((ContainerChest) cont);
                    IInventory inv = chest.getLowerChestInventory();
                    if(inv.getName().equals("§cAfk?")) {
                        afkMenuOpen = true;
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Minecraft.getMinecraft().playerController.windowClick(chest.windowId, 0,0, ClickType.PICKUP, player);
                            }
                        }, 1000);
                    }
                }
            } else {
                afkMenuOpen = false;
            }
        }
    }
}
