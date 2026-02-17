package com.example.template;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineTemplateMod implements ModInitializer {
    public static final String MOD_ID = "statemachine-toggle-template";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initialized {}", MOD_ID);
    }
}
