import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Plotter extends JComponent
{
  private int width;
  private int height;
  private BufferedImage image;
  
  public Plotter(int width, int height)
  {
    this.width = width;
    this.height = height;
    setPreferredSize(new Dimension(width, height));
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, width, height);
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(image, 0, 0, null);
  }
  
  private boolean isValidColor(int c)
  {
    return 0 <= c && c <= 255;
  }
  
  public void setColor(int x, int y, int red, int green, int blue)
  {
    if (x < 0 || x >= width || y < 0 || y >= height)
      throw new RuntimeException("invalid point:  " + x + ", " + y);
    if (!isValidColor(red) || !isValidColor(green) || !isValidColor(blue))
      throw new RuntimeException("Invalid color:  " + red + ", " + green + ", " + blue);
    int rgb = (red << 16) | (green << 8) | blue;
    image.setRGB(x, height - 1 - y, rgb);
    repaint();
  }
}