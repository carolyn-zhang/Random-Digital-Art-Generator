public class RandomFunctionArtist implements Artist
{
  private int width;
  private int height;
  private int complexity;
  private Function f;
  private Plotter plotter;
  
  public RandomFunctionArtist(int width, int height)
  {
    this.width = width;
    this.height = height;
  }
  
  public static void main(String[] args)
  {
    RandomFunctionArtist rfa = new RandomFunctionArtist(400, 400);
    ArtWindow aw = new ArtWindow(rfa);
  }
  
  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public void setPlotter(Plotter plotter)
  {
    this.plotter = plotter;
  }
  
  public Function randomFunction(int n)
  {
    if(n == 0)
    {
      if (Math.random() > 0.5)
        return new X();
      else
        return new Y();
    }
    else
    {
      double r = Math.random();
      if (r > 0.75)
        return new Sine(randomFunction(n-1));
      else if (r > 0.5)
        return new Cosine(randomFunction(n-1));
      else if (r > 0.25)
        return new Average(randomFunction(n-1), randomFunction(n-1));
      else
        return new Product(randomFunction(n-1), randomFunction(n-1));
        
    }
  }
  
  public void setComplexity(int complexity)
  {
    this.complexity = complexity;
  }

  public void draw()
  {
    f = randomFunction(complexity);
    int color;
    for(int x=0; x < width; x++)
    {
      for(int y=0; y < height; y++)
      {
        color = (int)(255*(1 + f.evaluate(x*(2.0/width)-1, y*(2.0/height)-1))/2);
        plotter.setColor(x, y, color, color, color);
      }
    }
    
  }

  public String getTitle()
  {
    String s = f.toString();
    return s;
  }
}