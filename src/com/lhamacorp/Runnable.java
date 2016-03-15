package com.lhamacorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runnable implements java.lang.Runnable {

    private String ip;
    public Runnable(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {

        String pingResult = "";
        String pingCmd = "ping -n 1 " + ip;

        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                if (inputLine.contains("Destination host unreachable")) {
                } else if (inputLine.contains("TTL")) {
                    System.out.println(ip);
                }

                pingResult += inputLine;
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
