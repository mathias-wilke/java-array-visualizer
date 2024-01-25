import javax.swing.*;
import java.awt.*;

/**
 * A class for visualizing one-dimensional and two-dimensional arrays.
 * It can display int arrays as bar charts and boolean arrays as black and white grids.
 */
public class ArrayVisualizer extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array;
    private boolean[][] boolArray;

    /**
     * Constructor to initialize the ArrayVisualizer window.
     * 
     * @param width  the width of the window
     * @param height the height of the window
     */
    public ArrayVisualizer(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Draws an int array as a bar chart.
     * Each element in the array is represented by a bar of corresponding height.
     * 
     * @param a the int array to be visualized
     */
    public void drawIntArray(int[] a) {
        this.array = a;
        this.boolArray = null; // Resets the boolArray when an int array is drawn
        repaint();
    }

    /**
     * Draws a boolean array as a black and white grid.
     * Each element is represented as a black (true) or white (false) square.
     * 
     * @param a the boolean array to be visualized
     */
    public void drawBoolArray(boolean[][] a) {
        this.boolArray = a;
        this.array = null; // Resets the int array when a bool array is drawn
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (array != null) {
            drawIntArray(g);
        } else if (boolArray != null) {
            drawBoolArray(g);
        }
    }

    /**
     * Helper method to draw the int array as a bar chart.
     * This method is called within the paint method.
     * 
     * @param g the Graphics object used for drawing
     */
     private void drawIntArray(Graphics g) {
        double heightUnits = ((double)(getHeight() - getInsets().top)) / (double)this.max(array);
    	
        System.out.println(getInsets().top);
        System.out.println(heightUnits);
        
    	int width = getWidth() / array.length;
        for (int i = 0; i < array.length; i++) {
            int height =  (int)(heightUnits * array[i]);
            g.fillRect(i * width, getHeight() - height, width, height);
        }
        
        g.setColor(Color.RED);
        int y = getInsets().top;
        //g.fillRect(0, y , getWidth(), getHeight() - y);
        g.setColor(Color.BLACK);
    }

    /**
     * Helper method to draw the boolean array as a black and white grid.
     * This method is called within the paint method.
     * 
     * @param g the Graphics object used for drawing
     */
    private void drawBoolArray(Graphics g) {
        int rowHeight = getHeight() / boolArray.length;
        for (int i = 0; i < boolArray.length; i++) {
            int colWidth = getWidth() / boolArray[i].length;
            for (int j = 0; j < boolArray[i].length; j++) {
                g.setColor(boolArray[i][j] ? Color.BLACK : Color.WHITE);
                g.fillRect(j * colWidth, i * rowHeight, colWidth, rowHeight);
            }
        }
    }

    private int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
