/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rayzr522.decoheads.api;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

/**
 *
 * @author crashdemons (crashenator at gmail.com)
 */
public interface DecoHeadsPlugin extends Plugin{
    @Nullable
    public DecoHeadsAPI getApiInstance();
}
