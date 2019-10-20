package com.example.lampanewstextingapp.model.pojoClasses;

public class Results {

    private String owner;
    private Image image;
    private String price_week, email_count, price_month, phone_count, price, name, id, category, favorite, view_count;
    private Currency currency;

    public String getOwner ()
    {
        return owner;
    }

    public void setOwner (String owner)
    {
        this.owner = owner;
    }

    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    public String getPrice_week ()
    {
        return price_week;
    }

    public void setPrice_week (String price_week)
    {
        this.price_week = price_week;
    }

    public String getEmail_count ()
    {
        return email_count;
    }

    public void setEmail_count (String email_count)
    {
        this.email_count = email_count;
    }

    public String getPrice_month ()
    {
        return price_month;
    }

    public void setPrice_month (String price_month)
    {
        this.price_month = price_month;
    }

    public String getPhone_count ()
    {
        return phone_count;
    }

    public void setPhone_count (String phone_count)
    {
        this.phone_count = phone_count;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Currency getCurrency ()
    {
        return currency;
    }

    public void setCurrency (Currency currency)
    {
        this.currency = currency;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getFavorite ()
    {
        return favorite;
    }

    public void setFavorite (String favorite)
    {
        this.favorite = favorite;
    }

    public String getView_count ()
    {
        return view_count;
    }

    public void setView_count (String view_count)
    {
        this.view_count = view_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [owner = "+owner+", image = "+image+", price_week = "+price_week+", email_count = "+email_count+", price_month = "+price_month+", phone_count = "+phone_count+", price = "+price+", name = "+name+", currency = "+currency+", id = "+id+", category = "+category+", favorite = "+favorite+", view_count = "+view_count+"]";
    }
}
