public class MovableBlock implements Block {
  @Override
  public void collision(TheArchitect architect, int x, int y, int xScale, int yScale) {
    if(architect.updatedMatrix[x + (xScale * 2)][y + (yScale * 2)].equals("N")) {
      architect.updatedMatrix[x][y] = "N";
      architect.updatedMatrix[x + xScale][y + yScale] = "P";
      architect.updatedMatrix[x + (xScale * 2)][y + (yScale * 2)] = "M";
    }
  }

  @Override
  public String toString() {
    return "M";
  }
}