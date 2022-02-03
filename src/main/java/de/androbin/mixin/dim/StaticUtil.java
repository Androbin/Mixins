package de.androbin.mixin.dim;

import java.awt.*;

public final class StaticUtil {
  private StaticUtil() {
  }
  
  public static boolean contains( final Dimension d, final Point p ) {
    return p.x >= 0 && p.x < d.width
        && p.y >= 0 && p.y < d.height;
  }
}