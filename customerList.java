import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
//This class contains an array of customerRecord objects.
public class customerList  {
    //instances
    private int count; //number of customers in the array
    private customerRecord[] customerData; //array list of customerRecord objects
    private int index; //index of the array


    ///////////////////////////////////////////////////////////////
    //Name: CustomerList
    //Parameter: count - the size of the array
    //Behavior: Constructs a CustomerList object containing
    //          the specified count and array
    ////////////////////////////////////////////////////////////////

    public customerList(int count){
        this.count = count;
        this.customerData = new customerRecord[this.count];
        this.index = 0;
    }

    ///////////////////////////////////////////////////////////////
    //Name: getCustomerList
    //Behavior: read text file, populate database
    //Parameter: fileName(String)
    //Return: None
    ////////////////////////////////////////////////////////////////

    public void getCustomerList(String fileName) throws FileNotFoundException{
        //create scanner for the file
        Scanner scan = new Scanner(new File(fileName));
        //read textFile, line by line:
        while(scan.hasNext()) {//loop through the textfile line by line
           int n = Integer.parseInt(scan.next());
           String f = scan.next();
           String l = scan.next();
           double d = Double.parseDouble(scan.next());
            //create new record
            customerRecord record = new customerRecord(n, f, l, d);
            System.out.println(record);
            //insert into database
            enterCustomerRecord(record);
        }
        scan.close();
    }

    ///////////////////////////////////////////////////////////////
    //Name: getCustomer
    //Behavior: returns the object corresponding to the customer with
    //          customer number. If the customer number is not in the array
    //          return null
    //Parameter: customerNumber - customer's number
    //Return: returns the object corresponding to the customer with
    //         customer number. If the customer number is not in the array
    //         return null
    ////////////////////////////////////////////////////////////////

    public customerRecord getCustomer(int customerNumber) {
        int i;
        for ( i = 0; i < index; i++) {
            if (customerNumber== customerData[i].getCustomerNumber()){
            return customerData[i];

            }

        }
        return null;
    }
        ///////////////////////////////////////////////////////////////
        //Name: enterCustomerRecord
        //Behavior: store the customer record into data array
        //Parameter: new_record - new record in data array
        //Return: None
        ////////////////////////////////////////////////////////////////

        public void enterCustomerRecord (customerRecord new_record){
            customerData[index] = new_record;
            index++;
        }
        ///////////////////////////////////////////////////////////////
        //Name: enterCustomerRecord
        //Behavior: save the information stored in the data array to the file called file name
        //Parameter: fileName
        //Return: None
        ////////////////////////////////////////////////////////////////
        public void saveCustomerList (String fileName) {
            try {
                FileWriter Writer = new FileWriter(new File(fileName));
                for(int i = 0;i < index;i++) {
                    Writer.write(customerData[i].getCustomerNumber() +"\t" + customerData[i].getFirstName()+" "+customerData[i].getLastName()+"\t"+customerData[i].getBalance() +"\n");
                }
                Writer.close();
                System.out.println("File has been updated");
            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
    }
}

