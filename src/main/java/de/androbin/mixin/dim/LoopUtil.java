package de.androbin.mixin.dim;

import de.androbin.func.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.function.*;

public final class LoopUtil {
  private LoopUtil() {
  }
  
  public static boolean all( final Rectangle r, final Predicate<Point> p ) {
    return !any( r, p.negate() );
  }
  
  public static boolean any( final Rectangle r, final Predicate<Point> p ) {
    for ( int y = r.y; y < r.y + r.height; y++ ) {
      for ( int x = r.x; x < r.x + r.width; x++ ) {
        if ( p.test( new Point( x, y ) ) ) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public static Rectangle clip( final Rectangle2D.Float r ) {
    final int x = (int) r.x;
    final int y = (int) r.y;
    final int width = (int) Math.ceil( r.x + r.width ) - x;
    final int height = (int) Math.ceil( r.y + r.height ) - y;
    return new Rectangle( x, y, width, height );
  }
  
  public static void forEach( final Dimension d, final Consumer<Point> c ) {
    for ( int y = 0; y < d.height; y++ ) {
      for ( int x = 0; x < d.width; x++ ) {
        c.accept( new Point( x, y ) );
      }
    }
  }
  
  public static <E extends Exception> void forEachDirty( final Dimension d,
      final DirtyConsumer<Point, E> c ) throws E {
    for ( int y = 0; y < d.height; y++ ) {
      for ( int x = 0; x < d.width; x++ ) {
        c.accept( new Point( x, y ) );
      }
    }
  }
  
  public static void forEach( final Rectangle r, final Consumer<Point> c ) {
    for ( int y = r.y; y < r.y + r.height; y++ ) {
      for ( int x = r.x; x < r.x + r.width; x++ ) {
        c.accept( new Point( x, y ) );
      }
    }
  }
  
  public static <E extends Exception> void forEachDirty( final Rectangle r,
      final DirtyConsumer<Point, E> c ) throws E {
    for ( int y = r.y; y < r.y + r.height; y++ ) {
      for ( int x = r.x; x < r.x + r.width; x++ ) {
        c.accept( new Point( x, y ) );
      }
    }
  }
  
  public static void forEach( final Rectangle2D.Float r, final Consumer<Point> c ) {
    forEach( clip( r ), c );
  }
  
  public static <E extends Exception> void forEachDirty( final Rectangle2D.Float r,
      final DirtyConsumer<Point, E> c ) throws E {
    forEachDirty( clip( r ), c );
  }
  
  public static boolean none( final Rectangle r, final Predicate<Point> p ) {
    return !any( r, p );
  }
}