package de.androbin.mixin;

import java.util.*;
import java.util.function.*;

public final class PipeIterator<S, T> implements Iterator<T> {
  private final Iterator<S> iterator;
  private final Function<S, T> function;
  
  public PipeIterator( final Iterator<S> iterator, final Function<S, T> function ) {
    this.iterator = iterator;
    this.function = function;
  }
  
  @ Override
  public boolean hasNext() {
    return iterator.hasNext();
  }
  
  @ Override
  public T next() {
    return function.apply( iterator.next() );
  }
}