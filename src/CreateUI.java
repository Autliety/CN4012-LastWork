import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Autliety
 * @date: 2017/3/23
 */
public class CreateUI extends JFrame implements ActionListener {

  private JPanel conf = new JPanel(new FlowLayout());
  private JTextField nameen = new JTextField(15);
  private JTextField lvlen = new JTextField(15);
  private JTextField priceen = new JTextField(15);
  private JButton create = new JButton("Create");
  private JButton cancel = new JButton("Cancel");

  public CreateUI() {

    setTitle("Create a new product");
    setSize(350, 170);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new FlowLayout());
    setVisible(true);

    add(new JLabel("Name:         "));
    add(nameen);
    add(new JLabel("StockLevel: "));
    add(lvlen);
    add(new JLabel("Price:          "));
    add(priceen);
    add(BorderLayout.SOUTH, conf);
    conf.add(create);
    conf.add(cancel);

    create.addActionListener(this);
    cancel.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == create) {
      try {
        String s = nameen.getText();
        int i = Integer.parseInt(lvlen.getText());
        double d = Double.parseDouble(priceen.getText());
        if (i > 0 && d > 0) {
          Main.listPro.add(new Product(s, i, d));
          MainUI.namelist.addItem(s);
          MainUI.namelist.setSelectedItem(s);
          this.dispose();
        } else {
          JOptionPane.showMessageDialog(null, "StockLevel and price should be positive!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      } catch (NumberFormatException error) {
        JOptionPane.showMessageDialog(null, "Value error, create failed", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      nameen.setText("");
      lvlen.setText("");
      priceen.setText("");
    }
    if (e.getSource() == cancel) {
      this.dispose();
    }
  }
}
