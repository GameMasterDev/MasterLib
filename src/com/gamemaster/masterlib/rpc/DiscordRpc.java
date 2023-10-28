package com.gamemaster.masterlib.rpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class DiscordRpc {

    private final DiscordRPC lib = DiscordRPC.INSTANCE;
    private final DiscordRichPresence presence = new DiscordRichPresence();
    private String applicationId = "908083569925161061";
    private String Details = "not set";
    private String State = "not set";
    private String largeImageKey = "not set";
    private String largeImageText = "not set";
    private String smallImageKey = "not set";
    private String smallImageText = "not set";

    public DiscordRpc() {
        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        this.lib.Discord_Initialize(applicationId, handlers, true, "");
        this.presence.details = "details";
        this.presence.state = "state";
    }

    public DiscordRpc(String app_id, String details, String state, String LargeImageKey, String LargeImageText) {

        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        this.lib.Discord_Initialize(app_id, handlers, true, "");
        applicationId = app_id;

        this.presence.startTimestamp = System.currentTimeMillis() / 1000;
        this.presence.details = details;
        this.presence.state = state;
        this.presence.largeImageKey = LargeImageKey;
        this.presence.largeImageText = LargeImageText;

        this.Details = details;
        this.State = state;
        this.largeImageKey = LargeImageText;
        this.largeImageText = LargeImageText;

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored){}
            }
        }, "RPC-Callback-Handler").start();
    }

    public DiscordRpc(String app_id, String details, String state, String LargeImageKey) {

        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        this.lib.Discord_Initialize(app_id, handlers, true, "");
        applicationId = app_id;

        this.presence.startTimestamp = System.currentTimeMillis() / 1000;
        this.presence.details = details;
        this.presence.state = state;
        this.presence.largeImageKey = LargeImageKey;

        this.Details = details;
        this.State = state;
        this.largeImageKey = LargeImageKey;

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored){}
            }
        }, "RPC-Callback-Handler").start();
    }

    public DiscordRpc(String app_id, String state, String LargeImageKey) {

        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        this.lib.Discord_Initialize(app_id, handlers, true, "");
        applicationId = app_id;

        this.presence.startTimestamp = System.currentTimeMillis() / 1000;
        this.presence.state = state;
        this.presence.largeImageKey = largeImageKey;

        this.State = state;
        this.largeImageKey = LargeImageKey;

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored){}
            }
        }, "RPC-Callback-Handler").start();
    }

    public DiscordRpc(String app_id, String details, String state, String LargeImageKey, String LargeImageText, String SmallImageKey, String SmallImageText) {

        final DiscordEventHandlers handlers = new DiscordEventHandlers();
        this.lib.Discord_Initialize(app_id, handlers, true, "");
        applicationId = app_id;

        this.presence.startTimestamp = System.currentTimeMillis() / 1000;
        this.presence.details = details;
        this.presence.state = state;
        this.presence.largeImageKey = largeImageKey;
        this.presence.largeImageText = largeImageText;
        this.presence.smallImageKey = smallImageKey;
        this.presence.smallImageText = smallImageText;

        this.Details = details;
        this.State = state;
        this.largeImageKey = LargeImageKey;
        this.largeImageText = LargeImageText;
        this.smallImageKey = SmallImageKey;
        this.smallImageText = SmallImageText;

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored){}
            }
        }, "RPC-Callback-Handler").start();
    }

    public void destroyRPC() {
        this.lib.Discord_ClearPresence();
    }

    public void setDetails(final String details) {
        this.presence.details = details;
        this.lib.Discord_UpdatePresence(this.presence);
    }

    public void setState(final String state) {
        this.presence.state = state;
        this.lib.Discord_UpdatePresence(this.presence);
    }
    public void setLargeImage(final String key) {
        this.presence.largeImageKey = key;
        this.lib.Discord_UpdatePresence(this.presence);
    }
    public void setLargeImageText(final String text) {
        this.presence.largeImageText = text;
        this.lib.Discord_UpdatePresence(this.presence);
    }
    public void setSmallImage(final String key) {
        this.presence.smallImageKey = key;
        this.lib.Discord_UpdatePresence(this.presence);
    }
    public void setSmallImageText(final String text) {
        this.presence.smallImageText = text;
        this.lib.Discord_UpdatePresence(this.presence);
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getDetails() {
        return Details;
    }

    public String getState() {
        return State;
    }

    public String getLargeImageKey() {
        return largeImageKey;
    }

    public String getLargeImageText() {
        return largeImageText;
    }

    public String getSmallImageKey() {
        return smallImageKey;
    }

    public String getSmallImageText() {
        return smallImageText;
    }

}
