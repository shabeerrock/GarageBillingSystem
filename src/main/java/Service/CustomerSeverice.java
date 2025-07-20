package Service;

import config.Dbconfig;
import enity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerSeverice
{
    public void addCustomer(Customer cs) throws SQLException
    {
        Connection conn = Dbconfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO CUSTOMER(NAME,PHONE) VALUES (?,?)");
        ps.setString(1,cs.getName());
        ps.setString(2,cs.getPhone());
        int ints = ps.executeUpdate();
        System.out.println("Customer  is added");
        ps.close();
        conn.close();
    }

    public List<Customer> getAllCustomer() throws  SQLException
    {
        List<Customer> li = new ArrayList<>();
        Connection conn = Dbconfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from customer");
        while(rs.next())
        {
             li.add(new Customer( rs.getInt("ID"),rs.getString("NAME"),rs.getString("PHONE")) );
        }
        return li;
    }

    public Customer getCustomerByNumber(String number) throws  SQLException
    {
        Customer cs = new Customer();
        Connection conn = Dbconfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from customer where phone= "+number+" ");
        while(rs.next())
        {
            cs = new Customer( rs.getInt("ID"),rs.getString("NAME"),rs.getString("PHONE")) ;
        }
        return cs;
    }





}
