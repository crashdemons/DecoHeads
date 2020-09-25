package me.rayzr522.decoheads.api;

import org.bukkit.inventory.ItemStack;

/**
 *
 * @author crashdemons (crashenator at gmail.com)
 */
public interface ApiHead {
    public String getName();
    public String getTexture();
    public String getUUID();
    public double getCost();
    public boolean isEnabled();
    
    /**
     * Gets the (unstyled) item for this head.
     * This item will not have a name or lore added.
     * @return the itemstack for of the head
     */
    public ItemStack getItem();
    
    public ApiCategory getCategory();
}
