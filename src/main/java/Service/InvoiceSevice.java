package Service;

import config.Dbconfig;
import enity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceSevice
{
    public void addInvoice(Invoice inv) throws SQLException
    {
        Connection conn = Dbconfig.getConnection();
        System.out.println("checking"+inv.getService_id());
        PreparedStatement ps = conn.prepareStatement("Insert into INVOICE (customer_id,Vehicle_ID,SERVICE_ID)values(?,?,?)");
        ps.setInt(1,inv.getCustomer_id());
        ps.setInt(2,inv.getVehicle_id() );
        ps.setInt(3,inv.getService_id());
        ps.executeUpdate();
        ps.close();
        conn.close();
        System.out.println("New invoice is added ");
    }

    public List<Invoice> getAllInvoice() throws  SQLException
    {
        List<Invoice> li = new ArrayList<>();
        Connection conn =  Dbconfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from invoice");
         while (rs.next())
         {
            li.add ( new Invoice( rs.getInt("ID"),
                    rs.getInt("customer_id"),
                    rs.getInt("Vehicle_ID"),
                    rs.getInt("SERVICE_ID")));
         }
         return li;
    }


}
