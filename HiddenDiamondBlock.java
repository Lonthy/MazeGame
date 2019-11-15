public class HiddenDiamondBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {
    architect.updatedMatrix[x][y] = "N";
    architect.updatedMatrix[x + xScale][y + yScale] = "P";
    architect.updatedMatrix[x][y] = "N";
    architect.collected += 1;// we got a hidden dimond! wow!
  }

  @Override
  public String toString() {
    return "H";
  }
}