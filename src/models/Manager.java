package models;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class Manager {
    public int id_manager;
    public String name;
    public String email;

    public Manager(int id_managers,
                   String name,
                   String email)
    {
        setId(id_managers);
        setName(name);
        setEmail(email);
    }
    public Manager(){

    }

    public int getId()
    {
        return this.id_manager;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setId(int id_manager)
    {
        this.id_manager = id_manager;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
