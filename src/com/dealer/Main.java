package com.dealer;

import action.ManagerController;
import models.Manager;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ManagerController managertCtrl = new ManagerController();
        List<Manager> list =  managertCtrl.getAllManagers();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + list.get(i).getId() + "; name: " +list.get(i).getName());
        }
        System.out.println("-------------------------------------------");
    }

}
