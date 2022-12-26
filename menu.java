
package snake2d;

import javax.swing.*;
import java.awt.event.*;
public class menu extends JFrame implements ActionListener
{
    JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");
    ImageIcon home = new ImageIcon("C:\\Users\\Pangs\\Downloads\\home.jpg");
    JLabel pic = new JLabel(home);
    menu()
    {
        JPanel jp = new JPanel();
        setBounds(450,200,325,350);
        start.addActionListener(this);
        exit.addActionListener(this);
        jp.add(pic);
        jp.add(start);
        jp.add(exit);
        add(jp);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent evt)
    {
        Object source = evt.getSource();
        if(source==exit)
        {
            System.exit(0);
        }
        if(source==start)
        {
            Snake2d d = new Snake2d();
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        menu ob = new menu();
    }
}