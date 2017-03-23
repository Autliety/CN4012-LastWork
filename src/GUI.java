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

  /*private JTextField nameCreat = new JTextField(5);
  private JTextField stockCreat = new JTextField(5);
  private JTextField priceCreat = new JTextField(5);
  private JButton productCreat = new JButton("Creat");*/

  private JTextField enterValue = new JTextField(5);
  private JButton restock = new JButton("restock");
  private JButton reprice = new JButton("reprice");
  private JButton sell = new JButton("be sold");



  public GUI() {
    setTitle("Product Manager - u1537697");
    setSize(500, 500);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    //productCreat.addActionListener(this);
    restock.addActionListener(this);
    reprice.addActionListener(this);
    sell.addActionListener(this);

    setJMenuBar(menuBar);
    menuBar.add(menuAdd);
    menuBar.add(menuHelp);
    menuAdd.add(newone);
    menuHelp.add(thisapp);


    /*add(new JLabel(" name:"));
    add(nameCreat);
    add(new JLabel(" stocklvl:"));
    add(stockCreat);
    add(new JLabel(" price:"));
    add(priceCreat);
    add(productCreat);*/

    add(enterValue);
    add(restock);
    add(reprice);
    add(sell);





  }

  public void actionPerformed(ActionEvent event) {

  }

}
