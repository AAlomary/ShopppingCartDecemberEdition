/**
 * Created by ahmad.alomary on 15/12/2016.
 */
public class ShoppingCart
{
    CartItems cartItems = new CartItems(20);

    public int getTotalPrice(){
        return cartItems.getTotalPriceWithoutVat();
    }

    public int getTotalItems(){
        return cartItems.getTotalItems();
    }
}
