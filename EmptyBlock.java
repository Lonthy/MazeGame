public class EmptyBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {}

  @Override
  public String toString() {
    return "N";
  }
}