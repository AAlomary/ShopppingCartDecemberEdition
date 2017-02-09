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
    boolean bogoffOfferApplies = true;
    boolean btgoffOfferApplies = true;
    private int totalPriceWithoutVat = 0;
    private int vAT;
    private int totalPriceWithVat;
    private int totalVatPayable;

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
                bogoffOfferApplies = false;
                break;
            }
        }
        if(!bogoffOfferApplies){
            totalPriceWithoutVat += singleItemVat(item);
            Bogoff.remove(item);
            bogoffOfferApplies = true;
        }else{
            addPartialOfferItem(Bogoff, item);
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
            if(count % 2 == 0)
            {
                btgoffOfferApplies = false;
                break;
            }
        }
        if(!btgoffOfferApplies){
            totalPriceWithoutVat += singleItemVat(item);
            Btgoff.remove(item);
            Btgoff.remove(item);
            btgoffOfferApplies = true;
        }else{
            addPartialOfferItem(Btgoff ,item);

        }
    }

    public void addPartialOfferItem(List<Item> offers, Item item){
            offers.add(item);
            totalPriceWithoutVat += item.getPrice();
            totalPriceWithVat += (item.getPrice() + singleItemVat(item));
            totalVatPayable += singleItemVat(item);
    }

    private int singleItemVat(Item item)
    {
        Double itemPrice =  new Double(item.getPrice());
        Double result = itemPrice * (vAT)/100;
        return result.intValue();
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

    public int getTotalVATPayable()
    {
        getTotalPriceWithoutVat();
        return  totalVatPayable;
    }

    public int getTotalPriceWithVat()
    {
        return totalPriceWithVat;
    }
}
