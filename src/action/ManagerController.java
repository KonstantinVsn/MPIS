/**
 * Created by vkv76 on 10.12.2017.
 */

package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconn.JDBCSingleton;
import models.Manager;

public class ManagerController {
    public List<Manager> getAllManagers() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<Manager> list = new ArrayList<Manager>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from managers");
            while(rs.next()) {
                Manager Manager = new Manager();
                Manager.setId(rs.getInt("id_manager"));
                Manager.setName(rs.getString("name"));
                Manager.setEmail(rs.getString("email"));
                list.add(Manager);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public Manager getManagerById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        Manager Manager = new Manager();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from managers where id_manager=" + Integer.toString(id));
            while(rs.next()) {
                Manager.setId(rs.getInt("id_manager"));
                Manager.setName(rs.getString("name"));
                Manager.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return Manager;
    }

    public void addManager(Manager Manager) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO Manager (id_manager, name, email) VALUES (%d, '%s', '%s')",
                    Manager.getId(), Manager.getName(), Manager.getEmail());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateManager(Manager Manager, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE Manager SET id_manager = %d, name = '%s', email = '%s' WHERE id_manager = %d",
                    Manager.getId(), Manager.getName(), Manager.getEmail(), id);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteManager(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM manager WHERE id_manager = %d", id);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
