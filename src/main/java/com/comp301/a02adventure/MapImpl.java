package com.comp301.a02adventure;

public class MapImpl implements Map {

  private int numItems;
  private Cell[] cells;
  private int height;
  private int width;

  public MapImpl(int width, int height, int numItems) {
    if (width < 0 | height < 0) {
      throw new IllegalArgumentException();
    }
    this.numItems = numItems;
    Cell[] cells = new Cell[width * height];
    this.cells = cells;
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
    if (x < 0 | x > width | y < 0 | y > height) {
      throw new IndexOutOfBoundsException();
    }
    Cell c = null;
    for (int i = 0; i < this.cells.length; i++) {
      if (this.cells[i].getPosition().getX() == x && this.cells[i].getPosition().getY() == y) {
        c = this.cells[i];
      }
    }
    return c;
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getX() < 0
        | position.getX() > this.width
        | position.getY() < 0
        | position.getY() > this.height) {
      throw new IndexOutOfBoundsException();
    }
    Cell c = null;
    for (int i = 0; i < this.cells.length; i++) {
      if (this.cells[i].getPosition() == position) {
        c = this.cells[i];
      }
    }
    return c;
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 | x > width | y < 0 | y > height) {
      throw new IndexOutOfBoundsException();
    }
    int i = 0;
    int j = 0;
    while (i < 1 | j < this.cells.length) {
      if (this.cells[j] == null) {
        this.cells[j] = new CellImpl(x, y);
        i++;
      }
      j++;
    }
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
