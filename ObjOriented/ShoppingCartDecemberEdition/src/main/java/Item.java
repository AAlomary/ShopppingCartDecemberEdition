import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import java.util.Objects;

/**
 * Created by ahmad.alomary on 15/12/2016.
 */
public class Item
{

    private String name;
    private int price;
    private String offer;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (price != item.price) return false;
        return name.equals(item.name);

    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }

    public Item(String name, int price, String offer)
    {
        this.name = name;
        setPrice(price);
        this.offer = offer;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getOffer()
    {
        return offer;
    }

    public void setOffer(String offer)
    {
        this.offer = offer;
    }
}
