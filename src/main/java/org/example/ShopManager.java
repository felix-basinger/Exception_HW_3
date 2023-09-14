package org.example;

public class ShopManager {
    public static double purchaseProduct(int productId, int quantity)  {
        try {
            Product product = ProductDataBase.getProduct(productId);
            assert product != null;
            product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
            return product.getPrice() * quantity;

        } catch (NullPointerException e) {
            System.out.println("Нет такого товара!");
        } catch (NotEnoughQuantityException e) {
            System.out.println("Нет такого количества на складе!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
