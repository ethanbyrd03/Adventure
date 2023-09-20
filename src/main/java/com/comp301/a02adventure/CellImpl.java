package com.comp301.a02adventure;

public class CellImpl implements Cell {

  private Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null | description == null) {
      throw new IllegalArgumentException();
    }
    this.position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.visited = false;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getChest() {
    return this.chest;
  }

  @Override
  public boolean getIsVisited() {
    return this.visited;
  }

  @Override
  public boolean hasChest() {
    if (this.chest != null) {
      return true;
    }
    return false;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    }
    this.description = description;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException();
    }
    this.chest = chest;
  }

  @Override
  public void visit() {
    this.visited = true;
  }
}
