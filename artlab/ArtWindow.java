import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArtWindow extends JFrame implements ActionListener
{
  private JComboBox complexityBox;
  private Plotter plotter;
  private Artist artist;
  private JTextArea functionArea;
  
  public ArtWindow(Artist artist)
  {
    this.artist = artist;
    artist.setComplexity(0);
    
    setTitle("Random Digital Art Generator");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    
    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
    getContentPane().add(controlPanel);
    
    controlPanel.add(new JLabel("Complexity:"));
    
    Integer[] choices = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    complexityBox = new JComboBox(choices);
    complexityBox.setActionCommand("complexity");
    complexityBox.addActionListener(this);
    controlPanel.add(complexityBox);
    
    JButton drawButton = new JButton("Draw");
    drawButton.setMnemonic(KeyEvent.VK_D);
    drawButton.setActionCommand("draw");
    drawButton.addActionListener(this);
    controlPanel.add(drawButton);
    
    plotter = new Plotter(artist.getWidth(), artist.getHeight());
    getContentPane().add(plotter);

    functionArea = new JTextArea(2, 20);
    JScrollPane scrollPane = new JScrollPane(functionArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    functionArea.setEditable(false);
    getContentPane().add(scrollPane);
    
    pack();
    setVisible(true);

    artist.setPlotter(plotter);
}
  
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();
    if (command.equals("complexity"))
      artist.setComplexity((Integer)complexityBox.getSelectedItem());
    else if (command.equals("draw"))
    {
      artist.draw();
      functionArea.setText(artist.getTitle());
    }
    else
      throw new RuntimeException("Invalid action command:  " + command);
  }
}