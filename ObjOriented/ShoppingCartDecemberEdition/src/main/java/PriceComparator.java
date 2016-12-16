import java.util.Comparator;

/**
 * Created by ahmad.alomary on 16/12/2016.
 */
public class PriceComparator implements Comparator<Item>
{
    @Override
    public int compare(Item item1 , Item Item2)
    {
        if (item1.getPrice() == Item2.getPrice())
        {
            return 0;
        } else if (item1.getPrice() < Item2.getPrice())
        {
            return -1;
        }
        return 1;
    }
}
