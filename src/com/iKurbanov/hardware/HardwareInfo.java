package com.iKurbanov.hardware;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Object of this class will contain current system's information
 */
class HardwareInfo {
    private final String os;
    private final String cpu;
    private final Long ram;
    private final Long hdd;


    HardwareInfo() {

        //The most reliable way to access OS-level information without 3-rd party libraries
        //Is OperatingSystemMXBean, so we use that

        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        this.os = "OS: "+osBean.getName()+" "+osBean.getVersion();

        this.cpu = System.getenv("PROCESSOR_IDENTIFIER");

        this.ram = bytesToGigabytes(osBean.getTotalPhysicalMemorySize());


        long hdd = (long)0;

        //Instead of calculating size of one partition,
        //i add them all together and calculate total HDD space
        File[] rootFiles = File.listRoots();
        for(File root : rootFiles){
            hdd += bytesToGigabytes(root.getTotalSpace());
        }

        this.hdd = hdd;
    }


    /**
     * @return current OS name and version
     */
    String getOs() {
        return os;
    }

    /**
     * @return current CPU info
     */
    String getCpu() {
        return cpu;
    }

    /**
     * @return current RAM amount in GB
     */
    Long getRam() {
        return ram;
    }

    /**
     * @return total HDD space on a current system in GB
     */
    Long getHdd() {
        return hdd;
    }


    /*Divider should actually be a 1000
    because since 1998 it was decided that there's 1000 bytes in a kilobyte,
    1000 kilobytes in a megabyte and 1000 megabytes in a gigabyte.
    Units with a 1024 divider are actually named Kibibytes(KiB), Mebibytes(MiB) and Gibibytes(GiB)
    See https://en.wikipedia.org/wiki/Kibibyte
    But since it's a CS background, i left it as 1024*/
    private final static int KYLOBYTE_DIVIDER = 1024;

    /**
     * @param bytes amount of bytes
     * @return Returns amount of Gigabytes in provided amount of bytes
     */
    private long bytesToGigabytes(long bytes){
        return bytesToMegabytes(bytes)/KYLOBYTE_DIVIDER;
    }

    /**
     * @param bytes amount of bytes
     * @return Returns amount of Megabytes in provided amount of bytes
     */
    private long bytesToMegabytes(long bytes){
        return bytesToKilobytes(bytes)/KYLOBYTE_DIVIDER;
    }

    /**
     * @param bytes amount of bytes
     * @return Returns amount of Kilobytes in provided amount of bytes
     */
    private long bytesToKilobytes(long bytes){
        return (bytes/KYLOBYTE_DIVIDER);
    }

}
