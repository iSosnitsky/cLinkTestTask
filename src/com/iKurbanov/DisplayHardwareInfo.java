package com.iKurbanov;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

public class DisplayHardwareInfo {
    public static void main(String[] args) {

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        System.out.println("OS: "+osBean.getName()+" "+osBean.getVersion());
        System.out.println("CPU: "+System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println("RAM: "+osBean.getTotalPhysicalMemorySize()/1000/1000/1000+"gb");

        System.out.println("HDD: ");
        File[] rootFiles = File.listRoots();
        for(File root : rootFiles){
            System.out.println(root.getAbsolutePath()+": "+root.getTotalSpace()/1000/1000/1000+"gb");
        }

    }
}
