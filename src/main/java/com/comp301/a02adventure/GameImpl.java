package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {

  private Player player;
  private Map map;

  public GameImpl(Map map, Player player) {
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
      System.out.println("You have already visited this location");
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
            "You collected these items:"
                + this.map.getCell(this.player.getPosition()).getChest().getItems());
        this.player
            .getInventory()
            .transferFrom(this.map.getCell(this.player.getPosition()).getChest());
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    if (this.map.getCell(
                this.player.getPosition().getNeighbor(direction).getX(),
                this.player.getPosition().getNeighbor(direction).getY())
            != null
        && this.player.getPosition().getNeighbor(direction).getX() < this.map.getWidth()
        && this.player.getPosition().getNeighbor(direction).getY() < this.map.getHeight()) {
      return true;
    }
    return false;
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
