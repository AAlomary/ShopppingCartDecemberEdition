import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad.alomary on 15/12/2016.
 */
public class CartItems
{

    public List<Item> itemList = new ArrayList<Item>();
    private int totalItems;

    public List<Item> getItemList()
    {
        return itemList;
    }

    public void add(Item item)
    {
        this.itemList.add(item);
    }

    public void remove(Item item1)
    {
        this.itemList.remove(item1);
    }

    public int getTotalPrice()
    {
        List<Item> Bogoff = new ArrayList<Item>();
        int totalPrice = 0;
        boolean empty = true;
        for (Item item : itemList)
        {
            for (Item bogoffItem : Bogoff)
            {
                if(bogoffItem.equals(item))
                {
                    empty = false;
                    break;
                }
            }
            if(empty){
                Bogoff.add(item);
                totalPrice += item.getPrice();
            }else{
                Bogoff.remove(item);
            }
        }

        return totalPrice;
    }

    public int getTotalItems()
    {
        return itemList.size();
    }
}
