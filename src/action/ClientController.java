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
import models.Client;
public class ClientController {
    public List<Client> getAllClients() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<Client> list = new ArrayList<Client>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from clients");
            while(rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id_client"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                list.add(client);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public Client getClientById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        Client client = new Client();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from clients where id_client=" + Integer.toString(id));
            while(rs.next()) {
                client.setId(rs.getInt("id_client"));
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return client;
    }

    public void addClient(Client client) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO client (id_client, name, email) VALUES (%d, '%s', '%s')",
                    client.getId(), client.getName(), client.getEmail());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateClient(Client client, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE client SET id_client = %d, name = '%s', email = '%s' WHERE id_client = %d",
                    client.getId(), client.getName(), client.getEmail(), id);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteClient(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM client WHERE id_client = %d", id);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
