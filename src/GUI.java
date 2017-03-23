import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @Author: Autliety
 * @date: 2017/3/20
 */
public class GUI extends JFrame implements ActionListener, ItemListener {

  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuAdd = new JMenu("Create");
  private JMenu menuHelp = new JMenu("About");
  private JMenuItem newone = new JMenuItem("a new product");
  private JMenuItem thisapp = new JMenuItem("this app");

  private JPanel redoPanel = new JPanel(new FlowLayout());
  private JPanel pickPanel = new JPanel(new FlowLayout());
  private JPanel infoPanel = new JPanel(new FlowLayout());
  private JTextField enterValue = new JTextField("0", 5);
  private JButton restock = new JButton("re-stock");
  private JButton reprice = new JButton("re-price");
  private JButton sell = new JButton("be sold");
  private JTextArea information = new JTextArea("  Click 'Create' to add a new product.", 6, 32);
  public static JComboBox namelist = new JComboBox();

  private int pickup = 0;
  private Product pickuppro;


  public GUI() {

    setTitle("Product Manager - u1537697");
    setSize(450, 230);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    setJMenuBar(menuBar);
    menuBar.add(menuAdd);
    menuBar.add(menuHelp);
    menuAdd.add(newone);
    menuHelp.add(thisapp);

    add(BorderLayout.NORTH, pickPanel);
    add(BorderLayout.CENTER, infoPanel);
    add(BorderLayout.SOUTH, redoPanel);

    redoPanel.add(enterValue);
    redoPanel.add(reprice);
    redoPanel.add(restock);
    redoPanel.add(sell);
    pickPanel.add(new JLabel("select a product to manage:"));
    pickPanel.add(namelist);
    infoPanel.add(information);
    information.setEditable(false);

    restock.addActionListener(this);
    reprice.addActionListener(this);
    sell.addActionListener(this);
    newone.addActionListener(this);
    thisapp.addActionListener(this);
    namelist.addItemListener(this);

    JOptionPane.showMessageDialog(null, " Welcome! Firstly you should click 'Create' " +
            "\non the menu to add a new product.", "Welcome to ProductManager", JOptionPane.INFORMATION_MESSAGE);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == newone) {
      new CreateUI();
    } else if (e.getSource() == thisapp) {
      JOptionPane.showMessageDialog(null, " Product Manager Application\n@Author: Autliety\n" +
              "@IDNumber: u1537697\n" + "@Date: Mar.23 2017", "About this app", JOptionPane.INFORMATION_MESSAGE);
    } else {
      if (Main.listPro.isEmpty()) {
        JOptionPane.showMessageDialog(null, " Create a new product please!", "ERROR", JOptionPane.ERROR_MESSAGE);
      } else {
        String s = enterValue.getText();
        try {
          if (e.getSource() == restock) {
            if (pickuppro.reStock(Integer.parseInt(s)) < 0) {
              JOptionPane.showMessageDialog(null, "re-stock value should be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
          } else if (e.getSource() == reprice) {
            double priin = Double.parseDouble(s);
            pickuppro.setPrice(priin);
            if (priin < 0) {
              JOptionPane.showMessageDialog(null, "price should be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
          } else if (e.getSource() == sell) {
            int sold = Integer.parseInt(s);
            double i = pickuppro.sell(sold);
            if (i == -514) {
              JOptionPane.showMessageDialog(null, "sell-number should be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (i == -223) {
              JOptionPane.showMessageDialog(null, "Value error, too much sold!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, sold + " pieces of product sold out \n$" +
                      i + " income have got!", "Sold successfully", JOptionPane.INFORMATION_MESSAGE);
            }
          }
        } catch (NumberFormatException error) {
          JOptionPane.showMessageDialog(null, "Value error, action failed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        ChangeText(pickuppro);
      }
    }
  }

  public void itemStateChanged(ItemEvent e) {
    pickup = namelist.getSelectedIndex();
    pickuppro = (Product) Main.listPro.get(pickup);
    ChangeText(pickuppro);
  }

  private void ChangeText(Product pick) {
    if (Main.listPro.isEmpty()) {
      information.setText("  Click 'Create' to add a new product.");
    } else {
      information.setText("  Product Name: " + pick.getName() +
              "\n  Stock Level: " + pick.getStockLevel() +
              "\n  Price: $" + pick.getPrice());
    }
  }

}
