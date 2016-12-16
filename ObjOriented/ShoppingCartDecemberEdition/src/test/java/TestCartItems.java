/**
 * Created by ahmad.alomary on 15/12/2016.
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCartItems
{

    @Test
    public void shouldAddItemToList() {
        // When
        CartItems cartItems = new CartItems();
        Item item = new Item("Apple", 1,"bogoff");

        cartItems.add(item);
        // Then

        assertEquals(item, cartItems.itemList.get(0));
    }
    @Test
    public void shouldRandomAddItemToList() {
        // When
        CartItems cartItems = new CartItems();
        Item item = new Item("Apple", 1, "bogoff");

        cartItems.remove(item);
        cartItems.add(item);

        // Then

        assertEquals(item, cartItems.itemList.get(0));
    }

    @Test
    public void shouldAddMultipleItemsToTheList() {
        // When
        CartItems cartItems = new CartItems();
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
        CartItems cartItems = new CartItems();
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
        CartItems cartItems = new CartItems();
        Item item = new Item("Apple", 1, "bogoff");
        Item item1 = new Item("Appl", 2, "bogoff");
        Item item2 = new Item("App", 3, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        int totalPrice = cartItems.getTotalPrice();
        // Then

        assertEquals(6, totalPrice);
    }


    @Test
    public void shouldGetTotalNumberOffItemsFromList() {
        // When
        CartItems cartItems = new CartItems();
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
        CartItems cartItems = new CartItems();
        Item item = new Item("Apple", 2, "bogoff");
        Item item1 = new Item("Apple", 2, "bogoff");

        cartItems.add(item);
        cartItems.add(item1);

        int totalPrice = cartItems.getTotalPrice();
        // Then

        assertEquals(2, totalPrice);
    }

    @Test
    public void shouldImplementBtgoff() {
        // When
        CartItems cartItems = new CartItems();
        Item item = new Item("orange", 3, "btgoff");
        Item item1 = new Item("orange", 3, "btgoff");
        Item item2 = new Item("orange", 3, "btgoff");

        cartItems.add(item);
        cartItems.add(item1);
        cartItems.add(item2);

        int totalPrice = cartItems.getTotalPrice();
        // Then

        assertEquals(6, totalPrice);
    }
}
