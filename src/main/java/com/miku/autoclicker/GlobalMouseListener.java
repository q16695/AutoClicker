package com.miku.autoclicker;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

import java.awt.event.MouseEvent;

public class GlobalMouseListener implements NativeMouseListener {
    @Override
    public void nativeMousePressed(NativeMouseEvent nativeEvent) {
        /*if(nativeEvent.getButton() == 1) {
            Main.leftPressed = true;
            if (Main.leftEnable && !Main.systemPressLeft) {
                for (int i = 0; i < Main.leftLoop; i++) {
                    Main.robot.mousePress(MouseEvent.BUTTON1_MASK);
                    Main.robot.mouseRelease(MouseEvent.BUTTON1_MASK);
                    Main.systemPressLeft = true;
                }
                return;
            }
            Main.systemPressLeft = false;
        } else if(nativeEvent.getButton() == 2) {
            Main.rightPressed = true;
            if (Main.rightEnable && !Main.systemPressRight) {
                for (int i = 0; i < Main.rightLoop; i++) {
                    Main.robot.mousePress(MouseEvent.BUTTON2_MASK);
                    Main.robot.mouseRelease(MouseEvent.BUTTON2_MASK);
                    Main.systemPressRight = true;
                }
                return;
            }
            Main.systemPressRight = false;
        }
         */
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeEvent) {
        if(nativeEvent.getButton() == 1) {
            Main.leftPressed = false;
        } else if(nativeEvent.getButton() == 2) {
            Main.rightPressed = false;
        }
    }
}
