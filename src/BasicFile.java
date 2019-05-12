
import java.io.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author AbsoluteCrow
 */
public class BasicFile 
{
    private File origFile;     
    
    public void openFile()
    {
        JFileChooser dialogFileChooser = new JFileChooser();
        dialogFileChooser.showOpenDialog(null);
        
        origFile = dialogFileChooser.getSelectedFile();  
    }
    
    public String getFileName()
    {
        return origFile.getName();
    }
    
    public void copyFile() throws IOException
    {
        File newFile;
        JFileChooser dialogFileChooser = new JFileChooser();
        DataInputStream inputStream;
        DataOutputStream outputStream;
        
        dialogFileChooser.showSaveDialog(null);       
        newFile = dialogFileChooser.getSelectedFile();
 
        newFile.createNewFile();

        inputStream = new DataInputStream(new FileInputStream(origFile));
        outputStream = new DataOutputStream(new FileOutputStream(newFile));

        byte[] buffer = new byte[inputStream.available()];
        for (byte b : buffer)
        {
            outputStream.writeByte(inputStream.readByte());
        }
    }
    
    public void appendFile() throws IOException
    {
        File newFile;
        JFileChooser dialogFileChooser = new JFileChooser();
        FileWriter appender;
        DataInputStream inputStream = new DataInputStream(new FileInputStream(origFile));
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder textToAppend = new StringBuilder();
        
        String line = buffReader.readLine();
        
        while(line != null)
        {
            textToAppend.append(line + "\n");
            line = buffReader.readLine();
        }
        
        dialogFileChooser.showSaveDialog(null);
        newFile = dialogFileChooser.getSelectedFile();
        appender = new FileWriter(newFile, true);
        
        appender.write(textToAppend.toString());
        appender.close();
    }
    
    public String fileAttributes() throws FileNotFoundException, IOException
    {
        StringBuilder attributes = new StringBuilder();
        
        attributes.append("Absolute File Path: " + "\"" + origFile.getAbsolutePath() + "\"\n");
        attributes.append("File Size: " + Math.round(origFile.length()/1024.0) + " KB\n");
        attributes.append("Lines: " + getNumOfLines() + "\n\n");
        attributes.append(listFiles() + "\n");
        
        return attributes.toString();
    }
    
    public String listFiles()
    {
        StringBuilder ls = new StringBuilder();
        File rootDirectory = origFile.getParentFile();
        File[] arrayOfFiles = rootDirectory.listFiles();
        
        for (File i : arrayOfFiles)
        {
            if (i.isFile())
            {
                ls.append("File:\t" + i.getName() + "\n");
            }
            else if (i.isDirectory())
            {
                ls.append("Directory:\t" + i.getName() + "\n");
            }
        }
        return ls.toString();
    }
    
    private StreamTokenizer tokenize() throws FileNotFoundException, IOException
    {  
        FileReader reader = new FileReader(origFile);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        
        tokenizer.eolIsSignificant(true);
        
        return tokenizer; 
    }
    
    public String locateText(String text) throws FileNotFoundException, IOException
    {       
        DataInputStream inputStream = new DataInputStream(new FileInputStream(origFile));
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder allLines = new StringBuilder();
        
        allLines.append("Searching for: " + "\"" + text + "\"\n\n");
        String line = buffReader.readLine();
        int lineNum = 1;
        
        while(line != null)
        {
            if (line.toLowerCase().contains(text.toLowerCase()))
            {
                allLines.append(lineNum + ": " + line + "\n");
            }
            line = buffReader.readLine();
            lineNum++;
        }            
        return allLines.toString();
    }
    
    public int getNumOfLines() throws IOException
    {
        StreamTokenizer tokenized = tokenize();
        int numOfLines = 1;
        
        while (tokenized.nextToken() != StreamTokenizer.TT_EOF)
        {
            if (tokenized.ttype == StreamTokenizer.TT_EOL)
                numOfLines++;
        }
        
        return numOfLines;
    }
    
    public String getContents() throws FileNotFoundException, IOException
    {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(origFile));
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder textContent = new StringBuilder();

        String line = buffReader.readLine();
        
        while(line != null)
        {
            textContent.append(line + "\n");
            line = buffReader.readLine();
        }        
        return textContent.toString();  
    }
}
