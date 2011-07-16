/*
* (Kaikz ~ http://pwncraft.net)
*
* THIS PLUGIN IS LICENSED UNDER THE WTFPL - (Do What The Fuck You Want To Public License)
*
* This program is free software. It comes without any warranty, to
* the extent permitted by applicable law. You can redistribute it
* and/or modify it under the terms of the Do What The Fuck You Want
* To Public License, Version 2, as published by Sam Hocevar. See
* http://sam.zoy.org/wtfpl/COPYING for more details.
*
* TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
*
* 0. You just DO WHAT THE FUCK YOU WANT TO.
*
* */

package net.pwncraft.kaikz.armorslots;

import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherListener;

public class ASWeatherListener extends WeatherListener {
    private final ArmorSlots plugin;

    public ASWeatherListener(ArmorSlots instance) {
        plugin = instance;
    }
    
    @Override
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState() == true) {
            ArmorSlots.fireArmor = false;
        }
    }
}