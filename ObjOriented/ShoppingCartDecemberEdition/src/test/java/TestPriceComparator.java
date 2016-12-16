/**
 * Created by ahmad.alomary on 16/12/2016.
 */
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPriceComparator
{
    @Test
    public void shouldReturn1() {
        // When
        CartItems cartItems = new CartItems(20);
        Item item = new Item("Apple", 3,"bogoff");
        Item item1 = new Item("Apple", 2,"bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        // Then
        PriceComparator priceComparator = new PriceComparator();
        int compare = priceComparator.compare(item, item1);

        assertEquals(compare, 1);
    }

    @Test
    public void shouldReturn0() {
        // When
        CartItems cartItems = new CartItems(20);
        Item item = new Item("Apple", 2,"bogoff");
        Item item1 = new Item("Apple", 2,"bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        // Then
        PriceComparator priceComparator = new PriceComparator();
        int compare = priceComparator.compare(item, item1);

        assertEquals(compare, 0);
    }

    @Test
    public void shouldReturn_1() {
        // When
        CartItems cartItems = new CartItems(20);
        Item item = new Item("Apple", 1,"bogoff");
        Item item1 = new Item("Apple", 2,"bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        // Then
        PriceComparator priceComparator = new PriceComparator();
        int compare = priceComparator.compare(item, item1);

        assertEquals(compare, -1);
    }
}
