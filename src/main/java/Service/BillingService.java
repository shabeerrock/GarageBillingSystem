package Service;

import enity.Customer;
import enity.Invoice;
import enity.Vehicle;

import java.security.Provider;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingService
{
    public CustomerSeverice cs = new CustomerSeverice();
    public InvoiceSevice is    = new InvoiceSevice();
    public VehicleService vs   = new VehicleService();

    public void createInvoice(int CustomerID, int VehicleId, List<Integer> ServiceId) throws SQLException {
        String ids = "";
        System.out.println("service id List ServiceId"+ServiceId);
        for(int sevice : ServiceId)
        {
            ids += sevice;
        }
        System.out.println("service id Added the : "+ids);
        is.addInvoice( new Invoice(0,CustomerID,VehicleId,Integer.parseInt(ids)));
        System.out.println("Invoice generated successfully...");
    }

    public void  showAllInvoice() throws SQLException
    {

        List<Invoice> invoiceLi = is.getAllInvoice();
        for (Invoice InvoiceList : invoiceLi)
        {
            System.out.println(InvoiceList);
        }
    }

}
