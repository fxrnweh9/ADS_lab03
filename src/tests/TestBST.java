package tests;

import models.BST;

public class TestBST {

    public static void run() {

        BST<Integer, String> myBST = new BST<>();

        System.out.println(" ");
        System.out.println("//////////////////////////////////");
        System.out.println("BST Test");
        System.out.println("//////////////////////////////////");
        System.out.println(" ");


        myBST.put(1, "One");
        myBST.put(7, "Seven");
        myBST.put(3, "Three");
        myBST.put(4, "Four");

        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Testing get method:");
        System.out.println("Getting key 10 " + myBST.get(10));


        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Deletig...");
        myBST.delete(1);


        System.out.println(" ");
        System.out.println(" ");
        System.out.println("//////////////////////////////////");
        System.out.println(" ");
        System.out.println(" ");

    }
}
