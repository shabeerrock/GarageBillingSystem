import Service.BillingService;
import Service.CustomerSeverice;
import enity.Customer;
import enity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService bs = new BillingService();
        while (true)
        {
            System.out.println("1.ADD CUSTOMER with Vehicle \n 2.Generate Invoice \n3.show Invoice\n4.Exit");
            int val = sc.nextInt();

            switch (val)
            {
                case 1:
                System.out.println("enter the customer name ");
                String cusName = sc.next();
                System.out.println("enter the phone");
                String cusPhone = sc.next();
                bs.cs.addCustomer(new Customer(0,cusName,cusPhone));
                System.out.println("Enter the vehicle Number");
                String vcn = sc.next();
                System.out.println("Enter the vehicle Model");
                String vcm = sc.next();
                Customer customer = bs.cs.getCustomerByNumber(cusPhone);
                bs.vs.addVehicle(new Vehicle(0,customer.getId(),vcn,vcm));
                break;
                case 2:
                    System.out.println("Enter the Customer ID ");
                    int cuid = sc.nextInt();
                    System.out.println(" enter the vechicle id");
                    int vcid = sc.nextInt();
                    System.out.println("the vechilc details"+bs.vs.getAllVehicle(cuid,vcid));
                    System.out.println(" enter the number of services");
                    int n = sc.nextInt();
                    List<Integer> li = new ArrayList<>();
                    for(int i =1 ;i<=n;i++ )
                    {
                        System.out.println("Enter the service id");
                        li.add(sc.nextInt());
                    }
                    bs.createInvoice(cuid,vcid,li);
                    break;
                case 3:
                    bs.showAllInvoice();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }

    }
}
