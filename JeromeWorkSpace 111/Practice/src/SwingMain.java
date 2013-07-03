import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class SwingMain
{
    public static void main(String args [])
    {
        // Swing test
        JFrame frame = new JFrame( "JFrame is me" );
        frame.setBounds(0, 0, 400, 300);

        JPanel jpan = new JPanel(new GridLayout(4,4,4,4));
        frame.getContentPane().add( jpan );
        JButton jbut = new JButton( "Hello" );
        jbut.setPreferredSize(new Dimension(50,25));
        jpan.add(jbut);

        frame.setVisible(true);
    } //main
} //application/SwingMain