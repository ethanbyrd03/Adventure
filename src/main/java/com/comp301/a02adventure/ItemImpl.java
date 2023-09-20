package com.comp301.a02adventure;

public class ItemImpl implements Item {

  private String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (this.name.equals(other.toString())) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
