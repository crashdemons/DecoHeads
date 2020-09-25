package me.rayzr522.decoheads.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

/**
 * API Helper class for getting access to DecoHeads.
 * This class can either be used from DecoHeads or included directly in your project.
 * @author crashdemons (crashenator at gmail.com)
 */
public class DecoHeadsHelper {
    private static DecoHeadsPlugin plugin = null;
    private static DecoHeadsAPI api = null;
    
    private DecoHeadsHelper(){}// do not allow subclassing - this is a static utility class.
    
    /**
     * Retrieves the currently running DecoHeads Plugin instance, if any.
     * @return the DecoHeads plugin, or null if it is not found.
     */
    @Nullable
    public static Plugin getPlugin(){
        if(plugin==null){
            Plugin potentialPlugin = Bukkit.getPluginManager().getPlugin("DecoHeads");
            if(potentialPlugin instanceof DecoHeadsPlugin) plugin = (DecoHeadsPlugin) potentialPlugin;//do not allow providing incompatible plugin versions
        }
        return plugin;
    }
    
    /**
     * Retrieves the current API implementation supported by the plugin
     * @return the API object, or null if it is not ready.
     */
    @Nullable
    public DecoHeadsAPI getAPI(){
        if(api==null){//API is not registered - we may be in a shaded copy of the API.  Try to retrieve the API from the plugin itself.
            if(getPlugin()!=null){//force recheck for the plugin before doing anything else
                api = plugin.getApiInstance();//this is only necessary if we are in a user-included copy of the API, where the API is not registered.
            }
        }
        return api;
    }
    
    
    //only allow classes within the API package to register themselves, don't expose to public
    
    /**
     * (Internal use only) register the plugin with the API helper
     * @param plugin 
     */
    protected static void setPlugin(DecoHeadsPlugin plugin){
        DecoHeadsHelper.plugin=plugin;
    }
    /**
     * (Internal use only) register the API provider with the API helper
     * @param api 
     */
    protected static void setAPI(DecoHeadsAPI api){
        DecoHeadsHelper.api=api;
    }
}
