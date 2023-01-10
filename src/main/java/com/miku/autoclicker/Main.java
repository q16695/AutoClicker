package com.miku.autoclicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import sun.jvmstat.monitor.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static boolean rightPressed = false, leftPressed = false, leftEnable = false, rightEnable = false;
    public static int enableRight = 19, enableLeft = 38;
    public static JDialog frame = new JDialog();
    public static JLabel right = new JLabel(), left = new JLabel();
    public static GlobalMouseListener globalMouseListener = new GlobalMouseListener();
    public static GlobalKeyListener globalKeyListener = new GlobalKeyListener();
    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        frame.add(right);
        frame.setSize(200, 100);
        frame.setLocation(20, 40);
        frame.add(left);
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeMouseListener(globalMouseListener);
            GlobalScreen.addNativeKeyListener(globalKeyListener);
            while (true) {
                int pid = getProcess("net.minecraft.launchwrapper.Launch");
                if (pid != -1) {
                    right.setBounds(20, 15, 150, 20);
                    left.setBounds(20, 40, 150, 20);
                    right.setText("Right Enable: " + rightEnable);
                    left.setText("Left  Enable: " + leftEnable);
                    if(rightEnable) {
                        right.setForeground(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(), 120));
                    } else {
                        right.setForeground(new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 120));
                    }
                    if(leftEnable) {
                        left.setForeground(new Color(Color.GREEN.getRed(), Color.GREEN.getGreen(), Color.GREEN.getBlue(), 120));
                    } else {
                        left.setForeground(new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 120));
                    }
                    if(leftEnable) {
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }
                    if(rightEnable) {
                        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                    }
                    if(!frame.isVisible()) {
                        frame.setUndecorated(true);
                        frame.setBackground(new Color(0,0,0,0));
                        frame.setAlwaysOnTop(true);
                        frame.setVisible(true);
                    }
                    Thread.sleep(10L);
                } else {
                    frame.setVisible(false);
                }
            }
        } catch (Exception exception) {
            //
        }
    }

    public static int getProcess(String cls) {
        if (cls == null) {
            return -1;
        }
        try {
            MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
            Set<?> vmlist = new HashSet<Object>(local.activeVms());
            for (Object process : vmlist) {
                MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
                String processname = MonitoredVmUtil.mainClass(vm, true);
                if (cls.equals(processname)) {
                    return ((Integer) process).intValue();
                }
            }
        } catch (Exception exception) {
            //
        }
        return -1;
    }
}
