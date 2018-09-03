package com.luckyryan.sample.webapp.controller;

import java.util.ArrayList;
import java.util.List;

public class HeapOomMock {
    
    public static void main(String[] args) {

        List<byte[]> oomList = new ArrayList<>();
        int i = 0;

        boolean contin = true;
        while (contin) {
            try {
                i++;
                oomList.add(new byte[1024 * 1024]);
            } catch (Throwable ex) {
                contin = false;
                System.out.println(i);
                System.gc();
                ex.printStackTrace();
            }
        }

    }
}