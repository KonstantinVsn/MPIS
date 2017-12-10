package models;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class Client {
    public int id_client;
    public String name;
    public String email;

    public Client(int id_client,
                   String name,
                   String email)
    {
        setId(id_client);
        setName(name);
        setEmail(email);
    }
    public Client(){

    }

    public int getId()
    {
        return this.id_client;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setId(int id_client)
    {
        this.id_client = id_client;
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
