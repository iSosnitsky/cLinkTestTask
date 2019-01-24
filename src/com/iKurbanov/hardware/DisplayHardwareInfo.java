package com.iKurbanov.hardware;

public class DisplayHardwareInfo {
    public static void main(String[] args) {

        HardwareInfo hardwareInfo = new HardwareInfo();

        System.out.println("OS: "+hardwareInfo.getOs());
        System.out.println("CPU: "+hardwareInfo.getCpu());
        System.out.println("RAM: "+hardwareInfo.getRam()+"gb");
        System.out.println("HDD: "+hardwareInfo.getHdd()+"gb");

    }
}
