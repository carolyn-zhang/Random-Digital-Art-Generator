public class Cosine implements Function
{
  private Function one;
  
  public Cosine(Function one)
  {
    this.one = one;
  }
  
  public double evaluate(double x, double y)
  {
    return Math.cos(Math.PI * one.evaluate(x, y));
  }
  
  public String toString()
  {
    return "cos(pi * " + one.toString() + ")";
  }
}