public class ExitBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {
    architect.updatedMatrix[x][y] = "N";
    architect.updatedMatrix[x + xScale][y + yScale] = "P";
    architect.nextLevel(true);// allow the next level to be loaded.
  }

  @Override
  public String toString() {
    return "E";
  }
}