package de.androbin.mixin.iter;

import java.util.*;

public final class ReverseIterator<T> implements Iterator<T> {
  private final ListIterator<T> iter;
  
  public ReverseIterator( final List<T> list ) {
    iter = list.listIterator( list.size() );
  }
  
  @ Override
  public boolean hasNext() {
    return iter.hasPrevious();
  }
  
  @ Override
  public T next() {
    return iter.previous();
  }
  
  @ Override
  public void remove() {
    iter.remove();
  }
}