import tests.TestBST;
import tests.TestMyHashTable;
import tests.TestMyTestingClass;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        run(new Scanner(System.in));
    }

    public static void run(Scanner in) {




        while (true) {

            System.out.println("[1] Test MyHashTable");
            System.out.println("[2] Test BST");
            System.out.println("[3] Test MyTestingClass");
            System.out.println("[4] Exit");


            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    TestMyHashTable.run();
                    break;
                case 2:
                    TestBST.run();
                    break;
                case 3:
                    TestMyTestingClass.run();
                    break;
                case 4:
                    System.out.println("exiting...");
                    return;

            }
        }
    }
}
