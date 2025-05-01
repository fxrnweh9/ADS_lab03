package Test;


import models.MyHashTable;

public class TestMyHashTable {

    public static void run() {

        MyHashTable<Integer, String> myHashTable = new MyHashTable();

        System.out.println(" ");
        System.out.println("//////////////////////////////////");
        System.out.println("MyHashTable Test");
        System.out.println("//////////////////////////////////");
        System.out.println(" ");



        myHashTable.put(1, "Olzhas Omerzak" );
        myHashTable.put(7, "Zhurtyn Balasy");
        myHashTable.put(12, "Palensheyev Palenshe");

        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Testing get method:");
        System.out.println("value key 1 " + myHashTable.get(1));
        System.out.println("value key 7 " + myHashTable.get(7));
        System.out.println("value key 12 " + myHashTable.get(12));

        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Testing remove method:");
        System.out.println("removing key 7 ");
        myHashTable.remove(7);


        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Testing contains method:");
        System.out.println("Does table contain value Olzhas Omerzak? " + myHashTable.contains("Olzhas Omerzak"));

        System.out.println(" ");
        System.out.println("_______________________________________________");
        System.out.println("Testing getKey method:");
        System.out.println("Key for value Olzhas Omerzak: " + myHashTable.getKey("Olzhas Omerzak"));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("//////////////////////////////////");
        System.out.println(" ");
        System.out.println(" ");
    }
}
