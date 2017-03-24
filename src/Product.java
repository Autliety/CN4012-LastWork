/**
 * @Author: Autliety
 * @date: 2017/3/19
 */
public class Product {
  private String name;
  private int stockLevel;
  private double price;

  public Product(String nameInit, int stockLevelInit, double priceInit) {
    name = nameInit;
    stockLevel = stockLevelInit;
    price = priceInit;
  }

  public int reStock(int stockLevelReStock) {
    if (stockLevelReStock < 0) {
      return -514;
    } else {
      stockLevel += stockLevelReStock;
      return stockLevel;
    }
  }

  public double sell(int stockLevelSell) {
    if (stockLevelSell < 0) {
      return -514;
    } else if (stockLevelSell > stockLevel) {
      return -223;
    } else {
      stockLevel -= stockLevelSell;
      return price * stockLevelSell;
    }
  }

  public void setPrice(double priceSetPrice) {
    if (priceSetPrice > 0) {
      price = priceSetPrice;
    }
  }

  public String getName() {
    return name;
  }

  public int getStockLevel() {
    return stockLevel;
  }

  public double getPrice() {
    return price;
  }
}
