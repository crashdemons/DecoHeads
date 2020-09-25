/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rayzr522.decoheads.api;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import me.rayzr522.decoheads.data.HeadManager;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author crashdemons (crashenator at gmail.com)
 */
public class ApiProvider implements DecoHeadsAPI {
    private HeadManager headManager;
    
    @Override
    public Optional<ApiHead> findHeadByName(String name){
        return headManager.findByName(name).map((head)->(ApiHead)head);
    }
    @Override
    public Collection<ApiHead> getHeads(){
        return headManager.getHeads().stream().map((head)->(ApiHead)head).collect(Collectors.toSet());
    }
    
    @Override
    public ItemStack createHeadItem(ApiHead head, boolean addName, boolean addLore){
        return headManager.createHeadItem(head, addName, addLore);
    }
    
    /**
     * Constructs a new ApiProvider (DecoHeadsAPI implementation) and optionally registers API instances
     * @param parentPlugin the plugin creating the API implementation
     * @param headManager the HeadManager object to be used by the API for head operations
     * @param registerInstances whether to register the plugin/ApiProvider with the API helper
     */
    public ApiProvider(DecoHeadsPlugin parentPlugin, HeadManager headManager, boolean registerInstances){
        this.headManager = headManager;
        if(registerInstances){
            DecoHeadsHelper.setAPI(this);
            DecoHeadsHelper.setPlugin(parentPlugin);
        }
    }
}
