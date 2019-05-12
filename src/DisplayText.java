
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class DisplayText {
    
    MyJFrame frame;
    Container container;
    JTextArea text;
    JScrollPane scrollPane;
    String selectedText = "";
    
    DisplayText()
    {
        text = new JTextArea();        
    }
    
    public void newFrame(String fileName, String content)
    {
        frame = new MyJFrame(fileName);
        container = frame.getContentPane();
        text.append(content);
        scrollPane = new JScrollPane(text);
        
        container.add(scrollPane);
        
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    
    //does nothing
    public String selectText()
    {
        return text.getSelectedText();
    }
    
    //does nothing
    public void insertText()
    {
        text.insert(selectedText, text.getCaretPosition());
    }
}
