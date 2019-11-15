public class EmptyBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {
    architect.updatedMatrix[x][y] = "N";
    architect.updatedMatrix[x + xScale][y + yScale] = "P";
  }

  @Override
  public String toString() {
    return "N";
  }
}