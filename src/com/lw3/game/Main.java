package com.lw3.game;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        InputStream is = new ByteArrayInputStream("1 2 2 1 2 2 1 2 2 1 2 2 2 3 2 1 2 2 1 2 2 1 2 1 ".getBytes());

        System.setIn(is);

        Scanner s = new Scanner(System.in);
        while (s.hasNextInt())
            System.out.println(s.nextInt());

        InputStream def = System.in;
        System.out.println(def);
        System.setIn(is);
//        Scanner s = new Scanner(System.in);?
        System.out.println(s.next());
        System.setIn(def);
        s = new Scanner(System.in);
        System.out.println(s.next());
//        LocalDateTime time = LocalDateTime.now();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm")));
    }
}

