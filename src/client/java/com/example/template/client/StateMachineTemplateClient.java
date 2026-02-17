package com.example.template.client;

import com.example.template.StateMachineTemplateMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class StateMachineTemplateClient implements ClientModInitializer {
    private static final String KEY_CATEGORY = "category.statemachine-toggle-template";

    private enum ModState {
        INITIALIZING,
        STARTING,
        IDLE,
        STOPPING,
        STOPPED
    }

    private static ModState state = ModState.INITIALIZING;
    private static boolean toggleEnabled = false;
    private static KeyBinding toggleKey;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.statemachine-toggle-template.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_BRACKET,
                KEY_CATEGORY
        ));

        log("Client initialized. Toggle defaults to OFF and state defaults to INITIALIZING.");

        ClientTickEvents.END_CLIENT_TICK.register(client -> runStateLoop());
    }

    private static void runStateLoop() {
        switch (state) {
            case INITIALIZING -> {
                log("Entering state loop: INITIALIZING");
                setState(ModState.STARTING);
            }
            case STARTING -> {
                log("Entering state loop: STARTING");
                setToggleEnabled(true);
                setState(ModState.IDLE);
            }
            case IDLE -> {
                log("Entering state loop: IDLE");
                if (toggleKey.wasPressed()) {
                    setState(ModState.STOPPING);
                }
            }
            case STOPPING -> {
                log("Entering state loop: STOPPING");
                setToggleEnabled(false);
                setState(ModState.STOPPED);
            }
            case STOPPED -> {
                log("Entering state loop: STOPPED");
                if (toggleKey.wasPressed()) {
                    setState(ModState.STARTING);
                }
            }
        }
    }

    private static void setState(ModState nextState) {
        ModState previous = state;
        state = nextState;
        log("State changed: " + previous + " -> " + nextState);
    }

    private static void setToggleEnabled(boolean enabled) {
        if (toggleEnabled != enabled) {
            toggleEnabled = enabled;
            log("Toggle changed: " + (enabled ? "ON" : "OFF"));
        }
    }

    private static void log(String message) {
        StateMachineTemplateMod.LOGGER.info("[ClientStateMachine] {}", message);
    }
}
