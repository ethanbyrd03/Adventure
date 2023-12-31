package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

  private Player player;
  private Map map;

  public GameImpl(Map map, Player player) {
    if (map == null | player == null) {
      throw new IllegalArgumentException();
    }
    this.player = player;
    this.map = map;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    if (this.player.getInventory().getNumItems() == this.map.getNumItems()) {
      return true;
    }
    return false;
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + this.map.getCell(this.player.getPosition()).getName());
    System.out.println(this.map.getCell(this.player.getPosition()).getDescription());
    if (this.map.getCell(this.player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(this.player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (!this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else {
      if (this.map.getCell(this.player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + this.map.getCell(this.player.getPosition()).getChest().getItems());
        this.player
            .getInventory()
            .transferFrom(this.map.getCell(this.player.getPosition()).getChest());
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position position = this.player.getPosition().getNeighbor(direction);
    int x = position.getX();
    int y = position.getY();
    if (x < 0 || x >= this.map.getWidth() || y < 0 || y >= this.map.getHeight()) {
      return false;
    } else {
      Cell cell = this.map.getCell(position);
      return cell != null;
    }
  }

  @Override
  public void move(Direction direction) {
    if (!this.canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      this.player.move(direction);
      this.printCellInfo();
    }
  }
}
