/**
 * @Author: Autliety
 * @date: 2017/3/19
 */
public class Product {
  private String name;
  private int stockLevel;
  private double price;

  public Product(String nameInit, int stockLevelInit, double priceInit) throws Exception {
    name = nameInit;
    if (stockLevelInit <= 0 ) {
      throw new Exception("Please enter a positive value for stock level.");
    } else {
      stockLevel = stockLevelInit;
    }
    if (priceInit <= 0) {
      throw new Exception("Please enter a positive value for price");
    } else {
      price = priceInit;
    }
  }

  public int reStock(int stockLevelReStock) throws Exception {
    if (stockLevelReStock < 0) {
      throw new Exception("Please enter a positive value for stock level.");
    } else {
      stockLevel += stockLevelReStock;
      return stockLevel;
    }
  }

  public double sell(int stockLevelSell) throws Exception {
    if (stockLevelSell < 0) {
      throw new Exception("Please enter a positive value for sell number.");
    } else if (stockLevelSell > stockLevel) {
      throw new Exception("Please enter a sell number no more than stock level");
    } else {
      stockLevel -= stockLevelSell;
      return price * stockLevelSell;
    }
  }

  public void setPrice(double priceSetPrice) throws Exception {
    if (priceSetPrice <= 0) {
      throw new Exception("Price must be positive.");
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
