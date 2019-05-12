
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class MyJFrame extends JFrame{
    
    private Actions action;
    private JMenuBar menuBar;
    private JMenu fileMenu, toolMenu, helpMenu, editMenu;
    
    private JMenuItem newItem, lsFiles, saveAs, closeItem, copyItem, pasteItem, 
              sortItem, searchItem;
    
    
    
    MyJFrame(String title)
    {
        action = new Actions();
        
        setTitle(title);
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        toolMenu = new JMenu("Tool");
        helpMenu= new JMenu("Help");
        editMenu = new JMenu("Edit");

        menuBar.add(fileMenu);
        menuBar.add(toolMenu);
        menuBar.add(helpMenu);

        newItem = new JMenuItem("New");
        lsFiles = new JMenuItem("List Files");
        saveAs = new JMenuItem("Save As");
        closeItem = new JMenuItem("Close");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        sortItem = new JMenuItem("Sort");
        searchItem = new JMenuItem("Search");

        fileMenu.add(newItem);
        fileMenu.add(lsFiles);        
        fileMenu.addSeparator();   
        fileMenu.add(saveAs); 
        fileMenu.addSeparator(); 
        fileMenu.add(closeItem);

        toolMenu.add(sortItem);
        toolMenu.add(searchItem);
        toolMenu.add(editMenu);

        editMenu.add(copyItem);   
        editMenu.add(pasteItem);
        
        setJMenuBar(menuBar);        
        
        menuActions();

        setSize(500,500);
        setLocationRelativeTo(null);
    }
    
    private void menuActions()
    {
        newItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.newFile(evt);
           }
        });
        
        lsFiles.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               try {
                   action.openFile(evt);
               } 
               catch (IOException ex) {
                   System.out.println("File does not exist");;
               }
           }
        });
        
        copyItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.copy(evt);
           }
        });
        
        pasteItem.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               action.paste(evt);
           }
        });
    }
}
