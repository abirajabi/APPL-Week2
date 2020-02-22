// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y, width, height;
    private Color c;
    private JButton left, right, up, down;
    //---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
        this.width = width;
        this.height = width;

// Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
// Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
// Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
// Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        left.setMnemonic('l');
        left.setToolTipText("Move circle left 20 pixel");

        right.addActionListener(new MoveListener(20,0));
        right.setMnemonic('r');
        right.setToolTipText("Move circle right 20 pixel");

        up.addActionListener(new MoveListener(0,-20));
        up.setMnemonic('u');
        up.setToolTipText("Move circle up 20 pixel");

        down.addActionListener(new MoveListener(0,20));
        down.setMnemonic('d');
        down.setToolTipText("Move circle down 20 pixel");
// Need a panel to put the buttons on or they'll be on
// top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
// Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    //---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
        //---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
            if (x + dx + CIRCLE_SIZE + CIRCLE_SIZE/2 > width){
                right.setEnabled(false);
            } else {
                right.setEnabled(true);
            }

            if (x + dx + CIRCLE_SIZE + CIRCLE_SIZE/2 < CIRCLE_SIZE + CIRCLE_SIZE/2){
                left.setEnabled(false);
            } else {
                left.setEnabled(true);
            }

            if (y + dy + CIRCLE_SIZE + CIRCLE_SIZE/2 > height){
                down.setEnabled(false);
            } else {
                down.setEnabled(true);
            }

            if (y + dy + CIRCLE_SIZE + CIRCLE_SIZE/2 < CIRCLE_SIZE + CIRCLE_SIZE/2){
                up.setEnabled(false);
            } else {
                up.setEnabled(true);
            }
            x += dx;
            y += dy;
            //x<0
            repaint();
        }
    }
}