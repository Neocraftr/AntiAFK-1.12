package de.neocraftr.antiafk;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

public class AntiAFK extends LabyModAddon {

    @Override
    public void onEnable() {
        getApi().registerForgeListener(new TickListener());
    }

    @Override
    public void loadConfig() {}

    @Override
    protected void fillSettings(List<SettingsElement> list) {}
}
