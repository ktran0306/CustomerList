//A driver class that contains only a main method:
import java.util.Locale;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.lang.*;

public class Assignment3 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scan2 = new Scanner(System.in);
        customerList cL = new customerList(100);
        System.out.print("Input File Name: ");
        String inputFileName = scan2.nextLine();

        try {
            cL.getCustomerList(inputFileName);
        } catch (FileNotFoundException e){
            System.out.println("File error");
            System.exit(-1);
        }

        while (true) {
            System.out.println(
                    "------------------------------------------------------\n" +
                            "|  a   -   add customer    \n" +
                            "|  f   -   find customer   \n" +
                            "|  q   -   quit            \n" +
                            "------------------------------------------------------");
            System.out.print("Enter command: ");
            String command = scan2.next();
            if (command.equalsIgnoreCase("a")) {
                System.out.print("Enter customer number: ");
                int n = scan2.nextInt();
                scan2.nextLine();
                System.out.print("Enter customer's first name: ");
                String f = scan2.nextLine();
                System.out.print("Enter customer's last name: ");
                String l = scan2.nextLine();
                System.out.print("Enter customer's balance: ");
                double d = scan2.nextDouble();
                scan2.nextLine();

                customerRecord record = new customerRecord(n, f, l, d);
                cL.enterCustomerRecord(record);


            } else if (command.equalsIgnoreCase("f")) {
                System.out.print("Enter the customer key: ");
                int keyNumber = scan2.nextInt();
                scan2.nextLine();
                customerRecord cr = cL.getCustomer(keyNumber);
                if (cr != null) {
                    System.out.println(cr.toString());
                } else {
                    System.out.println("No customer found");
                }

            } else if (command.equalsIgnoreCase("q")) {
                cL.saveCustomerList(inputFileName);
                break;
            } else {
                System.out.print("Invalid command");
            }
        }
        scan2.close();
    }
}

