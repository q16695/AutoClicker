package com.miku.autoclicker;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        if(nativeEvent.getKeyCode() == Main.enableRight) {
            Main.rightEnable = !Main.rightEnable;
        }
        if(nativeEvent.getKeyCode() == Main.enableLeft) {
            Main.leftEnable = !Main.leftEnable;
        }
    }
}
