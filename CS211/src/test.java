import java.awt.*;

import javax.swing.*;

class MyCanvas extends JComponent {

    public void paint(Graphics g) {
        g.drawRect (10, 10, 200, 200);
    }
}

public class test {
    public static void main(String[] a) {
        JFrame window = new JFrame();
        JLabel label = new JLabel("A",null, SwingConstants.CENTER);
        label.setBounds(10,10,200,200); window.add(label);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        //window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}









