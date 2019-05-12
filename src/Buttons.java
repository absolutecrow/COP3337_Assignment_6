
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class Buttons extends JButton{
    
    private Container container;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints gridBagConstraints;
    private Actions action;
    private JButton close, drawing, browser, logo;
    
    Buttons(MyJFrame frame){
        action = new Actions();
    	container = new Container();
	gridBagLayout = new GridBagLayout();
	gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
	
        container = frame.getContentPane();
        container.setLayout(gridBagLayout);
        
        drawingButton();
        closeButton();
        browserButton();
        imageButton();
        
        buttonActions();
    }
    
    private void drawingButton()
    {
        gridBagConstraints.insets = new Insets(0,0,370,370);
        
        drawing = new JButton("Drawing");
        gridBagLayout.setConstraints(drawing, gridBagConstraints);
        container.add(drawing);
    }
    
    private void closeButton()
    {
        gridBagConstraints.insets = new Insets(0,370,370,0);
        
        close = new JButton("Close");
        gridBagLayout.setConstraints(close, gridBagConstraints);
        container.add(close);
    }
    
    private void browserButton()
    {
        gridBagConstraints.insets = new Insets(220,0,0,0);
        
        browser = new JButton("Browser");
        gridBagLayout.setConstraints(browser, gridBagConstraints);
        container.add(browser);
    }
    
    private void imageButton()
    {
        gridBagConstraints.insets = new Insets(0,0,60,0);
        
        ImageIcon fiuLogo = new ImageIcon("src/fiu.png");
        logo = new JButton(fiuLogo);
        gridBagLayout.setConstraints(logo, gridBagConstraints);
        container.add(logo);
    }
    
    private void buttonActions()
    {
        close.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.closeSoftware(evt);
           }
        });
        
        browser.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.openBrowser(evt);
           }
        });
        
        drawing.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.openDrawer(evt);
           }
        });
    }
    
}
