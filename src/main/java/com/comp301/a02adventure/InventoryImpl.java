package com.comp301.a02adventure;

import java.util.*;

public class InventoryImpl implements Inventory {

  private ArrayList<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    if (this.items.isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public int getNumItems() {
    return this.items.size();
  }

  @Override
  public List<Item> getItems() {
    List<Item> c = (List<Item>) this.items.clone();
    return c;
  }

  @Override
  public void addItem(Item item) {
    this.items.add(item);
  }

  @Override
  public void removeItem(Item item) {
    this.items.remove(item);
  }

  @Override
  public void clear() {
    this.items.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    for (int i = 0; i < other.getNumItems(); i++) {
      this.addItem(other.getItems().get(i));
    }
    other.clear();
  }
}
