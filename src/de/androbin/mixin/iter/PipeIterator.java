package de.androbin.mixin.iter;

import java.util.*;
import java.util.function.*;

public final class PipeIterator<S, T> implements Iterator<T> {
  private final Iterator<S> iter;
  private final Function<S, T> func;
  
  public PipeIterator( final Iterator<S> iter, final Function<S, T> func ) {
    this.iter = iter;
    this.func = func;
  }
  
  @ Override
  public boolean hasNext() {
    return iter.hasNext();
  }
  
  @ Override
  public T next() {
    return func.apply( iter.next() );
  }
  
  @ Override
  public void remove() {
    iter.remove();
  }
}