
public class ShoppingCart {
    private int[] prices;
    private int itemCount;
    private final String cartId;

    public ShoppingCart(String cartId, int size) {
        this.cartId = cartId;
        this.prices = new int[size];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full");
        }
    }

    public int getTotal() {
        int total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("CART-01", 5);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total price: " + cart.getTotal());
        System.out.println("Number of items: " + cart.getItemCount());
    }
}
