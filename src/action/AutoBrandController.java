package action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconn.JDBCSingleton;
import models.AutoBrand;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class AutoBrandController {
    public List<AutoBrand> getAllAutoBrands() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<AutoBrand> list = new ArrayList<AutoBrand>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from auto_brand");
            while(rs.next()) {
                AutoBrand AutoBrand = new AutoBrand();
                AutoBrand.setId(rs.getInt("id_brand"));
                AutoBrand.setName(rs.getString("name"));
                AutoBrand.setCountry(rs.getString("country"));
                list.add(AutoBrand);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public AutoBrand getAutoBrandById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        AutoBrand AutoBrand = new AutoBrand();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from auto_brand where id_brand=" + Integer.toString(id));
            while(rs.next()) {
                AutoBrand.setId(rs.getInt("id_brand"));
                AutoBrand.setName(rs.getString("name"));
                AutoBrand.setCountry(rs.getString("country"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return AutoBrand;
    }

    public void addAutoBrand(AutoBrand AutoBrand) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO auto_brand (id_brand, name, country) VALUES (%d, '%s', '%s')",
                    AutoBrand.getId(), AutoBrand.getName(), AutoBrand.getCountry());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateAutoBrand(AutoBrand AutoBrand, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE AutoBrand SET id_brand = %d, name = '%s', Country = '%s' WHERE id_brand = %d",
                    AutoBrand.getId(), AutoBrand.getName(), AutoBrand.getCountry(), id);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteAutoBrand(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM AutoBrand WHERE id_brand = %d", id);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
