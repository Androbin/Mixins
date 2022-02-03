package de.androbin.mixin.iter;

import java.util.*;
import java.util.function.*;

public final class FilterIterator<T> implements Iterator<T> {
  private final Iterator<T> iter;
  private final Predicate<T> filter;
  
  private boolean hasValue;
  private T value;
  
  public FilterIterator( final Iterator<T> iter, final Predicate<T> filter ) {
    this.iter = iter;
    this.filter = filter;
    
    fetchValue();
  }
  
  private void fetchValue() {
    do {
      hasValue = iter.hasNext();
      
      if ( hasValue ) {
        value = iter.next();
      } else {
        value = null;
        return;
      }
    } while ( !filter.test( value ) );
  }
  
  @ Override
  public boolean hasNext() {
    return hasValue;
  }
  
  @ Override
  public T next() {
    final T value = this.value;
    fetchValue();
    return value;
  }
}