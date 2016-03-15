package com.lhamacorp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> getList(String netmask) {
        List<String> ips = new ArrayList<String>();

        for (int i = 0; i < 255; i++) {
            ips.add(netmask + "." + i);
        }

        return ips;
    }

    public static void main(String[] args) {
        String param = args.length == 0 ? "192.168.1" : args[0];
        List<String> ips = getList(param);

        for(String ip : ips) {
            Runnable myRunnable = new Runnable(ip);
            Thread t = new Thread(myRunnable);
            t.start();
        }

    }
}
