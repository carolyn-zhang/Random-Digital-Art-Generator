public class Average implements Function
{
  private Function one;
  private Function two;
  
  public Average (Function one, Function two)
  {
    this.one = one;
    this.two = two;
  }
  
  public double evaluate(double x, double y)
  {
    return (one.evaluate(x, y) + two.evaluate(x, y)) / 2;
  }
  
  public String toString()
  {
    return "avg(" + one.toString() + "," + two.toString() + ")";
  }
}