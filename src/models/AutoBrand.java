package models;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class AutoBrand {
    public int id_auto_brand;
    public String name;
    public String country;

    public AutoBrand(int Id,
                   String name,
                   String country)
    {
        setId(Id);
        setName(name);
        setCountry(country);
    }
    public AutoBrand(){

    }

    public int getId()
    {
        return this.id_auto_brand;
    }
    public String getName()
    {
        return this.name;
    }
    public String getCountry()
    {
        return this.country;
    }

    public void setId(int id_auto_brand)
    {
        id_auto_brand = id_auto_brand;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
