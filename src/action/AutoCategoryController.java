package action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconn.JDBCSingleton;
import models.AutoCategory;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class AutoCategoryController {
    public List<AutoCategory> getAllAutoCategory() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<AutoCategory> list = new ArrayList<AutoCategory>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from auto_category");
            while(rs.next()) {
                AutoCategory AutoCategory = new AutoCategory();
                AutoCategory.setId(rs.getInt("id_category"));
                AutoCategory.setName(rs.getString("name"));
                list.add(AutoCategory);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public AutoCategory getAutoCategoryById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        AutoCategory AutoCategory = new AutoCategory();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from auto_category where id_category=" + Integer.toString(id));
            while(rs.next()) {
                AutoCategory.setId(rs.getInt("id_category"));
                AutoCategory.setName(rs.getString("name"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return AutoCategory;
    }

    public void addAutoCategory(AutoCategory AutoCategory) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO auto_category (id_category, name) VALUES (%d, '%s')",
                    AutoCategory.getId(), AutoCategory.getName());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateAutoCategory(AutoCategory AutoCategory, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE auto_category SET id_category = %d, name = '%s' WHERE id_category = %d",
                    AutoCategory.getId(), AutoCategory.getName(), id);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteAutoCategory(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM auto_category WHERE id_category = %d", id);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
