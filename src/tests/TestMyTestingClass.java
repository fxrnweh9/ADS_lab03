package tests;

import models.MyHashTable;
import models.MyTestingClass;
import models.Student;

import java.util.Random;

public class TestMyTestingClass {

    public static void run() {

        System.out.println(" ");
        System.out.println("_______________________________________________");


        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            String id = "id" + rand.nextInt(100000);
            int number = rand.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id, number);
            Student value = new Student("Student" + i, i);
            table.put(key, value);
        }
        table.printBucketSizes();

        System.out.println("_______________________________________________");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("//////////////////////////////////");
        System.out.println(" ");
        System.out.println(" ");
    }
}
