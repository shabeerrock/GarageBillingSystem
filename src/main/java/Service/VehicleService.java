package Service;

import config.Dbconfig;
import enity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService
{
    public void addVehicle(Vehicle vc) throws SQLException
    {
        Connection conn = Dbconfig.getConnection();
        
        PreparedStatement ps = conn.prepareStatement("Insert into Vehicle(customer_id,Number_Plate,model)Values(?,?,?)");
        ps.setInt(1,vc.getCustomerId());
        ps.setString(2,vc.getNumberPlate());
        ps.setString(3,vc.getModel());
        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    public List<Vehicle> getAllVehicle(int customerId,int vechileId) throws SQLException
    {
        List<Vehicle> li = new ArrayList<>();
        Connection conn = Dbconfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from  vehicle where customer_id = "+customerId+"AND id ="+vechileId);
        while (rs.next())
        {
           li.add( new Vehicle( rs.getInt("ID"),
            rs.getInt("customer_id"), rs.getString("Number_Plate"),rs.getString("model"))) ;
        }
        return  li;
    }


}
