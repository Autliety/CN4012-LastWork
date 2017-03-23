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
    stockLevel += stockLevelReStock;
    return stockLevel;
  }

  public double sell(int stockLevelSell) {
    if (stockLevelSell < 0) {
      //illegal sell
      return -1;
    } else if (stockLevelSell > stockLevel) {
      //too more sell
      return -514;
    } else {
      stockLevel -= stockLevelSell;
      double cost = price * stockLevelSell;
      return cost;
    }
  }

  public void setPrice(double priceSetPrice) {
    if (priceSetPrice <0) {
      //illegal price
    } else {
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
