/**
 * Created by ahmad.alomary on 15/12/2016.
 */
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCartItems
{

    private CartItems cartItems;

    @Before
    public void setUp() throws Exception
    {
        cartItems = new CartItems(20);
    }

    @Test
    public void shouldAddItemToList() {
        // When

        Item item = new Item("Apple", 1,"bogoff");

        cartItems.add(item);
        // Then

        assertEquals(item, cartItems.itemList.get(0));
    }
    @Test
    public void shouldRandomAddItemToList() {
        // When
        Item item = new Item("Apple", 1, "bogoff");

        cartItems.remove(item);
        cartItems.add(item);

        // Then

        assertEquals(item, cartItems.itemList.get(0));
    }

    @Test
    public void shouldAddMultipleItemsToTheList() {
        // When
        Item item = new Item("Apple", 1, "bogoff");
        Item item1 = new Item("Appl", 2, "bogoff");
        Item item2 = new Item("App", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        // Then

        assertEquals(item, cartItems.itemList.get(0));
        assertEquals(item1, cartItems.itemList.get(1));
        assertEquals(item2, cartItems.itemList.get(2));
    }

    @Test
    public void shouldRemoveNonExistingItemFromList() {
        // When
        Item item = new Item("Apple", 1, "bogoff");
        Item item1 = new Item("Appl", 2, "bogoff");
        Item item2 = new Item("App", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        cartItems.remove(item1);
        cartItems.remove(item1);

        // Then

        assertEquals(item, cartItems.itemList.get(0));
        assertEquals(item2, cartItems.itemList.get(1));
    }

    @Test
    public void shouldGetTotalItemPriceFromList() {
        // When
        Item item = new Item("Apple", 1, "bogoff");
        Item item1 = new Item("Appl", 2, "bogoff");
        Item item2 = new Item("App", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(6, totalPrice);
    }


    @Test
    public void shouldGetTotalNumberOffItemsFromList() {
        // When
        Item item = new Item("Apple", 1, "bogoff");
        Item item1 = new Item("Appl", 2, "bogoff");
        Item item2 = new Item("App", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        int totalNoOfItems = cartItems.getTotalItems();
        // Then

        assertEquals(3, totalNoOfItems);
    }

    @Test
    public void shouldImplementBogoff() {
        // When
        Item item = new Item("Apple", 2, "bogoff");
        Item item1 = new Item("Apple", 2, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(2, totalPrice);
    }

    @Test
    public void shouldImplementDifferentBogoffs() {
        // When
        Item item = new Item("Apple", 2, "bogoff");
        Item item1 = new Item("Apple", 2, "bogoff");
        Item item2 = new Item("Banana", 3, "bogoff");
        Item item3 = new Item("Banana", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(5, totalPrice);
    }

    @Test
    public void shouldImplementMultipleBogoffs() {
        // When
        Item item = new Item("Apple", 2, "bogoff");
        Item item1 = new Item("Apple", 2, "bogoff");
        Item item2 = new Item("Apple", 2, "bogoff");
        Item item3 = new Item("Apple", 2, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(4, totalPrice);
    }

    @Test
    public void shouldImplementBtgoff() {
        // When
        Item item = new Item("orange", 3, "btgoff");
        Item item1 = new Item("orange", 3, "btgoff");
        Item item2 = new Item("orange", 3, "btgoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(6, totalPrice);
    }


    @Test
    public void shouldImplementMultipleBtgoff() {
        // When

        Item item = new Item("orange", 3, "btgoff");
        Item item1 = new Item("orange", 3, "btgoff");
        Item item2 = new Item("orange", 3, "btgoff");
        Item item3 = new Item("orange", 3, "btgoff");
        Item item4 = new Item("orange", 3, "btgoff");
        Item item5 = new Item("orange", 3, "btgoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);
        cartItems.add(item4);
        cartItems.add(item5);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(12, totalPrice);
    }

    @Test
    public void shouldImplementBtgoffAndBogoff() {
        // When
        Item item = new Item("orange", 3, "btgoff");
        Item item1 = new Item("orange", 3, "btgoff");
        Item item2 = new Item("orange", 3, "btgoff");
        Item item3 = new Item("Apple", 2, "bogoff");
        Item item4 = new Item("Apple", 2, "bogoff");
        Item item5 = new Item("pear", 3, "btgoff");
        Item item6 = new Item("pear", 3, "btgoff");
        Item item7 = new Item("pear", 3, "btgoff");
        Item item8 = new Item("peach", 2, "bogoff");
        Item item9 = new Item("peach", 2, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);
        cartItems.add(item4);
        cartItems.add(item5);
        cartItems.add(item6);
        cartItems.add(item7);
        cartItems.add(item8);
        cartItems.add(item9);

        int totalPrice = cartItems.getTotalPriceWithoutVat();
        // Then

        assertEquals(16, totalPrice);
    }

    @Test
    public void shouldImplementSort() {
        // When
        Item item = new Item("orange", 5, "btgoff");
        Item item1 = new Item("Apple", 3, "btgoff");
        Item item2 = new Item("Banana", 4, "btgoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        List<Item> items = cartItems.sort();
        // Then

        assertEquals(items.get(0).getName(), "Apple");
        assertEquals(items.get(1).getName(), "Banana");
        assertEquals(items.get(2).getName(), "orange");
    }

    @Test
    public void shouldNotBeAbleToAddItemsWithANegativePrice(){
        Item item = new Item("orange", -5, "btgoff");

        cartItems.add(item);

        assertEquals(cartItems.itemList.size(), 0);
    }


    @Test
    public void shouldTotalPriceWithVat(){
        Item item = new Item("orange", 5, "btgoff");
        Item item1 = new Item("orange", 5, "btgoff");
        Item item2 = new Item("orange", 5, "btgoff");
        Item item3 = new Item("Apple", 3, "btgoff");
        Item item4 = new Item("Banana", 4, "btgoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);
        cartItems.add(item4);

        int totalPricewithVat = cartItems.getTotalPriceWithVat();

        assertEquals(totalPricewithVat, 20);
    }
}
