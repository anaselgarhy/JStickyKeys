package com.anas.code;

import java.awt.*;
import java.util.ArrayList;

public class MainController {
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<KeyPressed> keyList = new ArrayList<>();
    public static void addKey(int keyCode) {
        KeyPressed temp = new KeyPressed(keyCode);
        if (!keyList.contains(temp)) {
            keyList.add(temp);
        }
        pressKey(temp);
    }

    private static void pressKey(KeyPressed key) {
        robot.keyPress(key.getKeyCode());
    }
}