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
import models.Order;

public class OrderController {
    public List<Order> getAllorders() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<Order> list = new ArrayList<Order>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from orders");
            while(rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id_order"));
                order.setIdCar(rs.getInt("id_client"));
                order.setIdManager(rs.getInt("id_manager"));
                order.setIdCar(rs.getInt("id_car"));
                order.setOrderDate(rs.getDate("order_date"));
                list.add(order);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public Order getOrderById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        Order order = new Order();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from orders where id_order=" + Integer.toString(id));
            while(rs.next()) {
                order.setId(rs.getInt("id_order"));
                order.setIdCar(rs.getInt("id_client"));
                order.setIdManager(rs.getInt("id_manager"));
                order.setIdCar(rs.getInt("id_car"));
                order.setOrderDate(rs.getDate("order_date"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return order;
    }

    public void addOrder(Order order) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO orders (id_order, id_client, id_car, id_manager, order_date) VALUES (%d, '%d', '%d', '%d', '%d')",
                    order.getId(), order.getIdClient(), order.getIdCar(), order.getIdManager(), order.getOrderDate());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateOrder(Order order, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE orders SET id_order = %d, id_client = '%d', id_car = '%d', id_manager  = '%d', order_date  = '%d' WHERE id_order = %d",
                    order.getId(), order.getIdClient(), order.getIdCar(), order.getIdManager(), order.getOrderDate(), id);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteOrder(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM orders WHERE id_order = %d", id);
        stmt.executeUpdate(sql);
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
