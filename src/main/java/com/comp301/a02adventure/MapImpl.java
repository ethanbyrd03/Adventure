package com.comp301.a02adventure;

public class MapImpl implements Map {

  private int numItems;
  private CellImpl[][] cells;
  private int height;
  private int width;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 | height <= 0) {
      throw new IllegalArgumentException();
    }
    this.numItems = numItems;
    this.cells = new CellImpl[width][height];
    this.height = height;
    this.width = width;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 | x >= width | y < 0 | y >= height) {
      throw new IndexOutOfBoundsException();
    }
    return this.cells[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getX() < 0
        | position.getX() > this.width
        | position.getY() < 0
        | position.getY() > this.height) {
      throw new IndexOutOfBoundsException();
    }
    return this.cells[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 | x > width | y < 0 | y > height) {
      throw new IndexOutOfBoundsException();
    }
    this.cells[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
