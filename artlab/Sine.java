public class Sine implements Function
{
  private Function one;
  
  public Sine (Function one)
  {
    this.one = one;
  }
  
  public double evaluate(double x, double y)
  {
    return Math.sin(Math.PI * one.evaluate(x, y));
  }
  
  public String toString()
  {
    return "sin(pi * " + one.toString() + ")";
  }
}