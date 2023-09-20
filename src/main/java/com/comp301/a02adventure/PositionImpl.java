package com.comp301.a02adventure;

import java.awt.*;

public class PositionImpl implements Position {

  private Point p;

  public PositionImpl(int x, int y) {
    p = new Point(x, y);
  }

  @Override
  public int getX() {
    return p.x;
  }

  @Override
  public int getY() {
    return p.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    if (direction == Direction.NORTH) {
      return new PositionImpl(this.p.x, this.p.y + 1);
    }
    if (direction == Direction.SOUTH) {
      return new PositionImpl(this.p.x, this.p.y - 1);
    }
    if (direction == Direction.WEST) {
      return new PositionImpl(this.p.x - 1, this.p.y);
    }
    if (direction == Direction.EAST) {
      return new PositionImpl(this.p.x + 1, this.p.y);
    }
    return this;
  }
}
