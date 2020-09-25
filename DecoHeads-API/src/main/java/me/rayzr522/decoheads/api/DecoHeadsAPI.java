package me.rayzr522.decoheads.api;

import java.util.Collection;
import java.util.Optional;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author crashdemons (crashenator at gmail.com)
 */
public interface DecoHeadsAPI {
    /**
     * Retrieves the head with the provided name
     * @param name the name to find
     * @return the head, if any.
     */
    public Optional<ApiHead> findHeadByName(String name);
    /**
     * Retrieves the collection of supported heads
     * @return the collection of heads
     */
    public Collection<ApiHead> getHeads();
    /**
     * Creates an ItemStack of the provided head
     * @param head the head to create an item for
     * @param addName whether to add the default displayname to the item
     * @param addLore whether to add the default loretext to the item
     * @return the itemstack created
     */
    public ItemStack createHeadItem(ApiHead head, boolean addName, boolean addLore);
}
