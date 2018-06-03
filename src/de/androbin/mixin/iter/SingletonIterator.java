package de.androbin.mixin.iter;

import java.util.*;

public final class SingletonIterator<T> implements Iterator<T> {
  private final T value;
  private boolean consumed;
  
  public SingletonIterator( final T value ) {
    this.value = value;
  }
  
  @ Override
  public boolean hasNext() {
    return !consumed;
  }
  
  @ Override
  public T next() {
    consumed = true;
    return value;
  }
}