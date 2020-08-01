public class Product implements Function
{
  private Function one;
  private Function two;
  
  public Product (Function one, Function two)
  {
    this.one = one;
    this.two = two;
  }
  
  public double evaluate(double x, double y)
  {
    return one.evaluate(x, y) * two.evaluate(x, y);
  }
  
  public String toString()
  {
    return one.toString() + "*" + two.toString();
  }
}