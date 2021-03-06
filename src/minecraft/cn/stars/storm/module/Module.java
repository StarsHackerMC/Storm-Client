package cn.stars.storm.module;

import et.event.EventBus;
import net.minecraft.client.Minecraft;

public class Module {
    private final String name;
    private final Category category;
    private int key;

    private boolean enable;
    private static final Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, Category category, int key) {
        this.name = name;
        this.category = category;
        this.key = key;
        enable = false;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean getEnable() {
        return enable;
    }

    public void Enable() {
        this.enable = !this.enable;
        if (this.enable) {
            onEnable();
        } else {
            onDisable();
        }
    }

    protected void onEnable() {
        if (mc.theWorld != null) {
            mc.thePlayer.playSound("random.click", 0.5f, 1);
        }
        EventBus.getInstance().register(this);
    }

    protected void onDisable() {
        if (mc.theWorld != null) {
            mc.thePlayer.playSound("random.click", 0.5f, 1);
        }
        EventBus.getInstance().unregister(this);
    }
}
