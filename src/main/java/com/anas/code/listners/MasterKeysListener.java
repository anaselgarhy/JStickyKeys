package com.anas.code.listners;

import com.anas.code.MainController;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class MasterKeysListener implements NativeKeyListener, Runnable {
    NativeKeyEvent[] masterKeys;

    // Singleton pattern
    private static MasterKeysListener instance = null;

    private MasterKeysListener() {}

    public static MasterKeysListener getInstance() {
        if (instance == null) {
            synchronized (MasterKeysListener.class) {
                if (instance == null) {
                    instance = new MasterKeysListener();
                }
            }
        }
        return instance;
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Pressed: " + nativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        MainController.addKey(nativeKeyEvent.getKeyCode());
    }

    @Override
    public void run() throws NullPointerException {
        if (masterKeys == null) {
            throw new NullPointerException("MasterKeysListener: masterKeys is null");
        }
        listener();
    }

    private void listener() {
        // Add key listener to global screen
        GlobalScreen.addNativeKeyListener(this);
    }
}
