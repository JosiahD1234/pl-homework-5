package com.craftinginterpreters.lox;

/*-------- Start of Code --------*/
import java.util.ArrayList;
import java.util.List;
/*-------- End of Code --------*/

class Environment {
  final Environment enclosing;
  /*-------- Start of Code --------*/
  private final List<Object> values = new ArrayList<>();
  /*-------- End of Code --------*/
  Environment() {
    enclosing = null;
  }

  Environment(Environment enclosing) {
    this.enclosing = enclosing;
  }

  /*-------- Start of Code --------*/
  void define(Object value) {
    values.add(value);
  }

  Object getAt(int distance, int slot) {
    Environment environment = this;
    for (int i = 0; i < distance; i++) {
      environment = environment.enclosing;
    }

    return environment.values.get(slot);
  }

  void assignAt(int distance, int slot, Object value) {
    Environment environment = this;
    for (int i = 0; i < distance; i++) {
      environment = environment.enclosing;
    }

    environment.values.set(slot, value);
  }
  /*-------- End of Code --------*/
  @Override
  public String toString() {
    String result = values.toString();
    if (enclosing != null) {
      result += " -> " + enclosing.toString();
    }

    return result;
  }
}
