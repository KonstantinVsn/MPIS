package models;

import java.util.Date;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class Car {
    public int id_car;
    public int id_auto_model;
    public double engine_volume;
    public int motor_power;
    public int max_torque;
    public int max_speed;
    public double fuel_used;
    public String color;
    public double lenght;
    public double hight;
    public Date year;
    public int price;
    public double shift_time;


    public Car(int id_car,
            int id_auto_model,
            double engine_volume,
            int motor_power,
            int max_torque,
            int max_speed,
            double fuel_used,
            String color,
            double lenght,
            double hight,
            Date year,
            int price,
            String shift_time)
    {


    }
    public Car(){}

    public int getId()
    {
        return this.id_car;
    }
    public int getAutoModel()
    {
        return this.id_auto_model;
    }
    public double getEngineVolume()
    {
        return this.engine_volume;
    }
    public int getMotorPower()
    {
        return this.motor_power;
    }
    public int getMaxTorque()
    {
        return this.max_torque;
    }
    public int getMaxSpeed()
    {
        return this.max_speed;
    }
    public double getFluelUsed()
    {
        return this.fuel_used;
    }
    public String getColor()
    {
        return this.color;
    }
    public double getLenght()
    {
        return this.lenght;
    }
    public double getHight()
    {
        return this.hight;
    }
    public Date getYear()
    {
        return this.year;
    }
    public int getPrice()
    {
        return this.price;
    }
    public double getShiftTime()
    {
        return this.shift_time;
    }

    public void setId(int value)
    {
        this.id_car = value;
    }
    public void setAutoModel(int value)
    {
         this.id_auto_model = value;
    }
    public void setEngineVolume(double value)
    {
         this.engine_volume= value;
    }
    public void setMotorPower(int value)
    {
         this.motor_power= value;
    }
    public void setMaxTorque(int value)
    {
         this.max_torque= value;
    }
    public void setMaxSpeed(int value)
    {
         this.max_speed= value;
    }
    public void setFluelUsed(double value)
    {
         this.fuel_used= value;
    }
    public void setColor(String value)
    {
         this.color = value;
    }
    public void setLenght(double value)
    {
         this.lenght = value;
    }
    public void setHight(double value)
    {
         this.hight = value;
    }
    public void setYear(Date value)
    {
         this.year = value;
    }
    public void setPrice(int value)
    {
         this.price = value;
    }
    public void setShiftTime(double value)
    {
         this.shift_time = value;
    }

}
