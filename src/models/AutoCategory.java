package models;

/**
 * Created by vkv76 on 10.12.2017.
 */
public class AutoCategory {
    public int id_auto_cvategory;
    public String name;


    public AutoCategory(int Id,
                     String name)
    {
        setId(Id);
        setName(name);
    }
    public AutoCategory(){

    }

    public int getId()
    {
        return this.id_auto_cvategory;
    }
    public String getName()
    {
        return this.name;
    }

    public void setId(int id_auto_cvategory)
    {
        id_auto_cvategory = id_auto_cvategory;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
