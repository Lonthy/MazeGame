public class DiamondBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {
    architect.updatedMatrix[x][y] = "N";
    architect.updatedMatrix[x + xScale][y + yScale] = "P";
    architect.collected += 1;// we got a dimond
  }

  @Override
  public String toString() {
    return "D";
  }
}