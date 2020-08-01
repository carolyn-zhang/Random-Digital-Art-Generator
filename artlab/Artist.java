public interface Artist
{
  public int getWidth();

  public int getHeight();

  public void setPlotter(Plotter plotter);

  void setComplexity(int complexity);

  void draw();

  String getTitle();
}