package de.androbin.mixin.iter;

import java.util.*;
import java.util.function.*;

public final class MixIterable<T> implements Iterable<T> {
  private final Supplier<Iterator<T>> iter;
  
  public MixIterable( final Supplier<Iterator<T>> iter ) {
    this.iter = iter;
  }
  
  @ Override
  public Iterator<T> iterator() {
    return iter.get();
  }
}