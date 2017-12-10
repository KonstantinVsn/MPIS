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
import models.Car;

public class CarController {
    public List<Car> getAllCars() throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        List<Car> list = new ArrayList<Car>();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from cars");
            while(rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id_car"));
                car.setAutoModel(rs.getInt("id_auto_model"));
                car.setEngineVolume(rs.getInt("engine_volume"));
                car.setMotorPower(rs.getInt("motor_power"));
                car.setMaxSpeed(rs.getInt("max_torque"));
                car.setFluelUsed(rs.getDouble("fuel_used"));
                car.setColor(rs.getString("color"));
                car.setLenght(rs.getDouble("lenght"));
                car.setHight(rs.getDouble("hight"));
                car.setYear(rs.getDate("year"));
                car.setPrice(rs.getInt("price"));
                car.setShiftTime(rs.getDouble("shift_time"));
                list.add(car);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    public Car getcarById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        Car car = new Car();
        ResultSet rs = null;
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            rs = stmt.executeQuery("select * from cars where id_car=" + Integer.toString(id));
            while(rs.next()) {
                car.setId(rs.getInt("id_car"));
                car.setAutoModel(rs.getInt("id_auto_model"));
                car.setEngineVolume(rs.getInt("engine_volume"));
                car.setMotorPower(rs.getInt("motor_power"));
                car.setMaxSpeed(rs.getInt("max_torque"));
                car.setFluelUsed(rs.getDouble("fuel_used"));
                car.setColor(rs.getString("color"));
                car.setLenght(rs.getDouble("lenght"));
                car.setHight(rs.getDouble("hight"));
                car.setYear(rs.getDate("year"));
                car.setPrice(rs.getInt("price"));
                car.setShiftTime(rs.getDouble("shift_time"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return car;
    }

    public void addcar(Car car) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("INSERT INTO cars " +
                            "(id_car, id_auto_model, engine_volume, motor_power,max_torque," +
                            "max_speed, fuel_used, color, lenght, hight, year, price, shift_time) " +
                            "VALUES (%d, '%d', '%f', '%d', '%d', '%d', '%f', '%s', '%f', '%f', '%d', '%d','%f' )",
                    car.getId(), car.getAutoModel(), car.getEngineVolume(), car.getMotorPower()
                    , car.getMaxSpeed(), car.getMaxSpeed(), car.getFluelUsed(), car.getColor(), car.getLenght(),
                    car.getHight(), car.getYear(), car.getPrice(), car.getShiftTime());
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updatecar(Car car, int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("UPDATE cars SET id_car = %d, id_auto_model = '%d', engine_volume = '%f', motor_power = '%d', max_torque = '%d', max_speed = '%d', fuel_used = '%f'" +
                            ",color = '%s', lenght = '%f', hight = '%f', year = '%dd', price = '%d', shift_time = '%f' WHERE id_car = %d",
                    car.getId(), car.getAutoModel(), car.getEngineVolume(), car.getMotorPower()
                    , car.getMaxSpeed(), car.getMaxSpeed(), car.getFluelUsed(), car.getColor(), car.getLenght(),
                    car.getHight(), car.getYear(), car.getPrice(), car.getShiftTime());
            PreparedStatement pstmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void deletecar(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = JDBCSingleton.getConnection();
        try
        {
            Statement stmt=(Statement) conn.createStatement();
            String sql =  String.format("DELETE FROM cars WHERE id_car = %d", id);
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
