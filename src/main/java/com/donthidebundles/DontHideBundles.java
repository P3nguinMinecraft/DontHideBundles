package com.donthidebundles;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DontHideBundles implements ClientModInitializer {
	public static Logger LOGGER = LoggerFactory.getLogger("DontHideBundles");
    @Override
    public void onInitializeClient() {
        LOGGER.info("Don't Hide Bundles initialized!");
    }
}