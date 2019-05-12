
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class MyGraphics extends JPanel{
    
    JFrame frame;
    int lastX, lastY;
    
    public void launchDrawer()
    {
        lastX = 0;
        lastY = 0;
        
        frame = new JFrame("Smile white board ...");
        frame.setSize(500,500);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        addMouseListener(new PositionRecorder());
        addMouseMotionListener(new LineDrawer());
    }
    
    private void record(int x, int y)
    {
        lastX = x;
        lastY = y;
    }
    
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        int[] houseX = {50,100,150,150,113,113,88,88,50};
        int[] houseY = {350,300,350,400,400,375,375,400,400};
        g.fillPolygon(new Polygon(houseX, houseY, houseX.length));
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("House", 75, 425);
        
        g.setColor(Color.yellow);
        int[] starX = {100,112,137,119,112,100,88,81,62,88};
        int[] starY = {50,75,87,100,125,100,125,100,87,75};
        g.fillPolygon(new Polygon(starX, starY, starX.length));
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.black);
        g.drawString("Star", 85, 145); 
    }
    
    private class PositionRecorder extends MouseAdapter
    {
        public void mouseEntered(MouseEvent evt)
        {
            record(evt.getX(), evt.getY());
        }
        public void mousePressed(MouseEvent evt)
        {
            record(evt.getX(), evt.getY());
        }
    }
    
    private class LineDrawer extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent evt)
        {
            int x = evt.getX();
            int y = evt.getY();
            
            Graphics g = getGraphics();
            
            g.setColor(Color.green);
            g.fillRect(lastX, lastY, 5, 5);
            g.drawLine(x, y, lastX, lastY);
            record(x, y);
        }
    }
}
