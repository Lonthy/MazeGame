public final class BlockFactory {

  private BlockFactory() {}

  public static Block createBlock(String blockCode) {

    switch(blockCode) {
      case "P":
        return new PlayerBlock();
      case "M":
        return new MovableBlock();
      case "D":
        return new DiamondBlock();
      case "H":
        return new HiddenDiamondBlock();
      case "W":
        return new WallBlock();
      case "E":
        return new EmptyBlock();
      case "N":
        return new EmptyBlock();
    }

    return null;
  }
}