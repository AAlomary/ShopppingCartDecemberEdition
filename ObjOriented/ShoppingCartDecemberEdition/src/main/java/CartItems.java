import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad.alomary on 15/12/2016.
 */
public class CartItems
{

    public List<Item> itemList = new ArrayList<Item>();
    List<Item> Bogoff = new ArrayList<Item>();
    List<Item> Btgoff = new ArrayList<Item>();
    private int totalItems;
    boolean bogoffEmpty = true;
    boolean btgoffEmpty = true;
    int totalPrice = 0;

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
        for (Item item : itemList)
        {
            if(item.getOffer() == "bogoff")
            {
                checkBogoff(item);
            }
            else if(item.getOffer() == "btgoff")
            {
                checkBtgoff(item);
            }
        }

        return totalPrice;
    }

    public void checkBogoff(Item item){
        for (Item bogoffItem : Bogoff)
        {
            if(bogoffItem.equals(item))
            {
                bogoffEmpty = false;
                break;
            }
        }
        if(bogoffEmpty){
            Bogoff.add(item);
            totalPrice += item.getPrice();
        }else{
            Bogoff.remove(item);
        }
    }

    public void checkBtgoff(Item item){
        int count = 0;
        for (Item btgoffItem : Btgoff)
        {
            if(btgoffItem.equals(item))
            {
               count += 1;
            }
            if(count == 2)
            {
                btgoffEmpty = false;
                break;
            }
        }
        if(btgoffEmpty){
            Btgoff.add(item);
            totalPrice += item.getPrice();
        }else{
            Btgoff.remove(item);
            Btgoff.remove(item);
        }
    }

    public int getTotalItems()
    {
        return itemList.size();
    }
}
