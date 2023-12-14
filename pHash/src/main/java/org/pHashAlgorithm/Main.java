package org.pHashAlgorithm;

import java.util.function.IntBinaryOperator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        PHash pHash = new PHash();

        long hash1 = pHash.getPHash("D:/PC/Desktop/23-02-03 16-38-08 0021.jpg");
        long hash2 = pHash.getPHash("D:/PC/Desktop/23-02-03 16-38-04 0019.jpg");
        long hash3 = pHash.getPHash("D:/PC/Desktop/23-02-03 16-38-08 0020.jpg");

        System.out.println( hash1 );
        System.out.println( hash2 );
        System.out.println( hash3 );

        System.out.println( pHash.getHammingDistance(hash1, hash3) );

    }
}