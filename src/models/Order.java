package models;

import java.util.Date;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class Order {
    public int id_order;
    public int id_client;
    public int id_manager;
    public int id_car;
    public Date order_date;

    public Order(int id_order,
                 int id_client,
                 int id_manager,
                 int id_car,
                 Date order_date)
    {
        setId(id_order);
        setIdClient(id_client);
        setIdManager(id_manager);
        setIdCar(id_car);
        setOrderDate(order_date);
    }
    public Order(){

    }

    public int getId()
    {
        return this.id_order;
    }
    public int getIdClient()
    {
        return this.id_client;
    }
    public int getIdManager()
    {
        return this.id_manager;
    }
    public int getIdCar()
    {
        return this.id_car;
    }
    public Date getOrderDate()
    {
        return this.order_date;
    }

    public void setId(int value)
    {
        id_order = value;
    }
    public void setIdClient(int value)
    {
        this.id_client = value;
    }
    public void setIdManager(int value)
    {
        this.id_manager = value;
    }
    public void setIdCar(int value)
    {
        this.id_car = value;
    }
    public void setOrderDate(Date value)
    {
        this.order_date = value;
    }
}
