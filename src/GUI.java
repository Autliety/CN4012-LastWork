import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @Author: Autliety
 * @date: 2017/3/20
 */
public class GUI extends JFrame implements ActionListener {

  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuAdd = new JMenu("Creat");
  private JMenu menuHelp = new JMenu("About");
  private JMenuItem newone = new JMenuItem("a new product");
  private JMenuItem thisapp = new JMenuItem("this app");

  private JPanel redoPanel = new JPanel(new FlowLayout());
  private JPanel pickPanel = new JPanel(new FlowLayout());
  private JPanel infoPanel = new JPanel(new FlowLayout());
  private JTextField enterValue = new JTextField("0", 5);
  private JButton restock = new JButton("restock");
  private JButton reprice = new JButton("reprice");
  private JButton sell = new JButton("be sold");
  private JTextArea infomation = new JTextArea("test", 6, 32);
  private JComboBox combobox = new JComboBox();

  private int pickup = 0;
  private Product pickuppro;


  public GUI() {

    setTitle("Product Manager - u1537697");
    setSize(450, 230);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    pickPanel.add(new JLabel("select a product to view:"));
    pickPanel.add(combobox);
    combobox.addItem("                    ");
    infoPanel.add(infomation);
    infomation.setEditable(false);

    restock.addActionListener(this);
    reprice.addActionListener(this);
    sell.addActionListener(this);
    combobox.addActionListener(this);
    newone.addActionListener(this);
    thisapp.addActionListener(this);

    JOptionPane.showMessageDialog(null, "Welcome! Firstly add a product please.");
    new CreatUI();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == newone) {
      new CreatUI();
    } else if (e.getSource() == thisapp) {
      JOptionPane.showMessageDialog(null, "Product Manager Application\n@Author: Autliety\n" +
              "@IDNumber: u1537697\n" + "@Date: Mar.23 2017", "About this app", JOptionPane.INFORMATION_MESSAGE);
    } else if(e.getSource() == combobox) {
      //combobox
    } else {
      if (Main.listPro.isEmpty()) {
        JOptionPane.showMessageDialog(null, "add a product first!", "Information", JOptionPane.INFORMATION_MESSAGE);
        new CreatUI();
      } else {
        String s = enterValue.getText();
        if (e.getSource() == restock) {
          pickuppro.reStock(Integer.parseInt(s));
        } else if (e.getSource() == reprice) {
          pickuppro.setPrice(Double.parseDouble(s));
        } else if (e.getSource() == sell) {
          pickuppro.sell(Integer.parseInt(s));
        }
        ChangeText(pickuppro);
      }
    }

  }

  private void ChangeText(Product pick) {

  }

}
