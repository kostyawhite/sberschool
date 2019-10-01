package ru.sber.e1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {

    final static Logger logger = LoggerFactory.getLogger(Fibonacci.class);

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        int n1 = 0;
        int n2 = 1;
        int n3;
        int count = Integer.valueOf(args[0]);

        if (count == 1) {
            System.out.println(n1);
        } else if (count == 2) {
            System.out.print(n1 + " " + n2);
        }

        for(int i = 2;i < count; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }

        long end = System.currentTimeMillis() - start;
        System.out.println();
        logger.info("Execution time: {} milliseconds", String.valueOf(end));
    }

}
