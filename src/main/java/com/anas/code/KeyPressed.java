package com.anas.code;

public class KeyPressed {
    private final int keyCode;
    private float pressTime;

    public KeyPressed(int keyCode) {
        this.keyCode = keyCode;
        pressTime = 0;
    }

    public void update(float delta) {
        pressTime += delta;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public float getPressTime() {
        return pressTime;
    }
}
