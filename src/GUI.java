import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @Author: Autliety
 * @date: 2017/3/20
 */
public class GUI extends JFrame implements ActionListener {

  private JMenuBar menuBar = new JMenuBar();

  private JPanel topPanel = new JPanel();
  private JPanel midPanel = new JPanel();
  private JPanel botPanel = new JPanel();

  private JTextField value = new JTextField(15);
  private JButton

  public GUI() {
    setTitle("Product Manager - u1537697");
    setSize(250, 200);
    setLocation(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void actionPerformed(ActionEvent event) {

  }

}
