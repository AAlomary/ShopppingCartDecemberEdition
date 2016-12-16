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
    int totalPriceWithoutVat = 0;
    private int vAT;
    private int totalPriceWithVat;

    public CartItems(int vat)
    {
        this.vAT = vat;
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public void add(Item item)
    {
        if(item.getPrice() >= 0){
            this.itemList.add(item);
        }
    }

    public void remove(Item item1)
    {
        this.itemList.remove(item1);
    }

    public int getTotalPriceWithoutVat()
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

        return totalPriceWithoutVat;
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
            totalPriceWithoutVat += item.getPrice();
            bogoffEmpty = true;
        }else{
            Bogoff.remove(item);
            bogoffEmpty = true;
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
            totalPriceWithoutVat += item.getPrice();
            btgoffEmpty = true;
        }else{
            Btgoff.remove(item);
            Btgoff.remove(item);
            btgoffEmpty = true;
        }
    }

    public int getTotalItems()
    {
        return itemList.size();
    }

    public List<Item> sort(){
       // sortedByPrice.sort(new PriceComparator());
        itemList.sort(new PriceComparator());
        return itemList;
    }

    public int getvAT()
    {
        return vAT;
    }


    public int getTotalPriceWithVat()
    {
        totalPriceWithVat = getTotalPriceWithoutVat() * (100 + vAT)/100;
        return totalPriceWithVat;
    }
}
