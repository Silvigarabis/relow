/*
   Copyright (c) 2024 Silvigarabis
   EnchantmentSplitter is licensed under Mulan PSL v2.
   You can use this software according to the terms and conditions of the Mulan PSL v2. 
   You may obtain a copy of Mulan PSL v2 at:
            http://license.coscl.org.cn/MulanPSL2 
   THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.  
   See the Mulan PSL v2 for more details.  
*/

package io.github.silvigarabis.esplitter;

public final class Logger {
    public static void debug(String message){
        if (!ESplitterPlugin.getPlugin().isDebugMode()){
            return;
        }
        
        Utils.getLogger().info(message);
    }
    public static void debugWarning(String message){
        if (!ESplitterPlugin.getPlugin().isDebugMode()){
            return;
        }
        
        Utils.getLogger().warning(message);
    }
}
