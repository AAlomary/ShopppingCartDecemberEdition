/**
 * Created by ahmad.alomary on 15/12/2016.
 */
public class ShoppingCart
{
    CartItems cartItems = new CartItems();

    public int getTotalPrice(){
        return cartItems.getTotalPrice();
    }

    public int getTotalItems(){
        return cartItems.getTotalItems();
    }
}
