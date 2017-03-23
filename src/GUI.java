import com.sun.tools.javac.comp.Flow;

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

  private JPanel topPanel = new JPanel(new FlowLayout());
  private JPanel midPanel = new JPanel(new FlowLayout());
  private JPanel botPanel = new JPanel(new FlowLayout());

  private JTextField enterValue = new JTextField(5);
  private JButton restock = new JButton("restock");
  private JButton reprice = new JButton("reprice");
  private JButton sell = new JButton("be sold");

  private Product testpro = new Product("whiteFF", 6, 23.3);

  public GUI() {
    setTitle("Product Manager - u1537697");
    setSize(450, 500);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    restock.addActionListener(this);
    reprice.addActionListener(this);
    sell.addActionListener(this);

    setJMenuBar(menuBar);
    menuBar.add(menuAdd);
    menuBar.add(menuHelp);
    menuAdd.add(newone);
    menuHelp.add(thisapp);

    add(BorderLayout.NORTH, topPanel);
    add(BorderLayout.CENTER, midPanel);
    add(BorderLayout.SOUTH, botPanel);

    topPanel.add(enterValue);
    topPanel.add(reprice);
    topPanel.add(restock);
    topPanel.add(sell);





  }

  public void actionPerformed(ActionEvent event) {

  }

}
