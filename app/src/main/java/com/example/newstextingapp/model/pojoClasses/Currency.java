package com.example.newstextingapp.model.pojoClasses;
/*
 * Author - Levitskiy Konstantin
 */
// Typical pojo-class
public class Currency
{

    private String image, name, id;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", name = "+name+", id = "+id+"]";
    }
}
