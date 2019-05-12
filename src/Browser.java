
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class Browser {
    
    private JFrame frame;
    private Container container;
    private JTextField enter;
    private JEditorPane contents;
    
    Browser()
    {
        frame = new JFrame("Browser");
        enter = new JTextField("http://");
        
        container = frame.getContentPane();
        
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                getThePage(e.getActionCommand());
            }
        });
        
        container.add(enter, BorderLayout.NORTH);
        
        contents = new JEditorPane();
        contents.setEditable(false);
        
        contents.addHyperlinkListener(new HyperlinkListener(){
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e){
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                    getThePage(e.getURL().toString());
            }
        });
        
        JScrollPane scrollpane = new JScrollPane(contents);
        
        container.add(scrollpane);
        
        frame.setSize(1280,720);
        frame.setVisible(true);
    }
    
    void getThePage(String location)
    {
        try{
            contents.setPage(location);
            enter.setText(location);
        }
        catch (IOException io){
            JOptionPane.showMessageDialog(null,  
            "Error cannot access specified URL",
            "Bad URL", JOptionPane.ERROR_MESSAGE );
        }
    }
}
