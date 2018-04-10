package de.androbin.mixin;

import java.util.*;
import java.util.function.*;

public final class MixIterable<T> implements Iterable<T> {
  private final Supplier<Iterator<T>> iterator;
  
  public MixIterable( final Supplier<Iterator<T>> iterator ) {
    this.iterator = iterator;
  }
  
  @ Override
  public Iterator<T> iterator() {
    return iterator.get();
  }
}