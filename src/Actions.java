import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
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
public class Actions{
    
    private DisplayText displaytext;
    private String selectedText = "";
    
    Actions()
    {
        displaytext = new DisplayText();
    }
    
    public void newFile(ActionEvent evt) { 
        displaytext.newFrame("New File", "");
    }
    
    public void openFile(ActionEvent evt) throws IOException
    {
        displaytext = new DisplayText();
        BasicFile basicFiles = new BasicFile();
        basicFiles.openFile();
        displaytext.newFrame(basicFiles.getFileName(), basicFiles.getContents());
    }
    
    public void closeSoftware(ActionEvent evt)
    {
        JOptionPane.showMessageDialog(null, "The window is closing", "COP3337", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    public void openBrowser(ActionEvent evt)
    {
        Browser browser = new Browser();
    }
    
    public void openDrawer(ActionEvent evt)
    {
        MyGraphics drawer = new MyGraphics();
        drawer.launchDrawer();
    }
    
    //does nothing
    public void copy(ActionEvent evt)
    {
        selectedText = displaytext.selectText();
    }
    
    //does nothing
    public void paste(ActionEvent evt)
    {
        displaytext.insertText();
    }
}
