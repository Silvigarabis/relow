/*
   Copyright (c) 2023 Silvigarabis
   EnchantmentSplitter is licensed under Mulan PSL v2.
   You can use this software according to the terms and conditions of the Mulan PSL v2. 
   You may obtain a copy of Mulan PSL v2 at:
            http://license.coscl.org.cn/MulanPSL2 
   THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.  
   See the Mulan PSL v2 for more details.  
*/

package io.github.silvigarabis.esplitter;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.silvigarabis.esplitter.commands.ESplitterComand;

import java.util.logging.Logger;

public final class ESplitterPlugin extends JavaPlugin {
    
    public static ESplitterPlugin getPluginInstance(){
        if (plugin == null) {
            throw new RuntimeException("plugin instance not found");
        }
        return plugin;
    }
    private static ESplitterPlugin plugin = null;
    
    private Logger logger;

    @Override
    public void onEnable() {
        this.logger = this.getLogger();

        logger.info("ESplitter 正在加载。");
        
        if (plugin == null){
            plugin = this;
        } else {
            logger.severe("插件状态异常");
            throw new IllegalStateException("plugin is not null");
        }

        registerEvents();
        registerCommands();
        
        logger.info("ESplitter 已加载。");
        logger.info("ESplitter 插件，一个让玩家可以分离装备上的附魔的插件");
        logger.info("源代码： https://github.com/Imeaces/EnchantmentSplitter");
        logger.info("你可以在在GitHub上提出建议，或者反馈错误： https://github.com/Imeaces/EnchantmentSplitter/issues");
    }

    private static void registerEvents(){
        plugin.getServer().getPluginManager().registerEvents(new ESplitterListener(), plugin);
    }

    private static void registerCommands(){
        plugin.getCommand("esplitter").setExecutor(new ESplitterComand(plugin));
    }

    @Override
    public void onDisable() {
        if (this.equals(plugin)){
            plugin = null;
        }
        logger.info("插件已禁用");
    }

    public void openGui(Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Player getPlayer(String playerName) {
        return this.getServer().getPlayerExact(playerName);
    }
}
