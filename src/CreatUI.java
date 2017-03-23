import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Autliety
 * @date: 2017/3/23
 */
public class CreatUI extends JFrame implements ActionListener {

  private JPanel conf = new JPanel(new FlowLayout());
  private JTextField nameen = new JTextField(15);
  private JTextField lvlen = new JTextField(15);
  private JTextField priceen = new JTextField(15);
  private JButton creat = new JButton("Creat");
  private JButton cancel = new JButton("Cancel");

  public CreatUI() {

    setTitle("Creat a new product");
    setSize(300, 170);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(false);
    setLayout(new FlowLayout());


    add(new JLabel("Name:         "));
    add(nameen);
    add(new JLabel("StockLevel: "));
    add(lvlen);
    add(new JLabel("Price:          "));
    add(priceen);
    add(BorderLayout.SOUTH, conf);
    conf.add(creat);
    conf.add(cancel);

    creat.addActionListener(this);
    cancel.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == creat) {
      String s = nameen.getText();
      int i = Integer.parseInt(lvlen.getText());
      double d = Double.parseDouble(priceen.getText());
      Main.listPro.add(new Product(s, i, d));
    }
    setVisible(false);
  }
}
