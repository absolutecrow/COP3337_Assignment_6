
import javax.swing.JFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class Tester {
    
    static MyJFrame frame;
    static Buttons buttons;
    
    public static void main(String args[])
    {
        frame = new MyJFrame("My First GUI 2019");
        buttons = new Buttons(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
