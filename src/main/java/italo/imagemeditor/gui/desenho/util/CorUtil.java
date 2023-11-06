package italo.imagemeditor.gui.desenho.util;

import java.awt.Color;

public class CorUtil {
        
    public int toRGB( Color cor ) {
        int r = cor.getRed() << 16;
        int g = cor.getGreen() << 8;
        int b = cor.getBlue();
        return ( r + g + b ) + 0xFF000000;
    }
        
    public Color toColor( int rgb ) {
        int r = ( rgb & 0x00FF0000 ) >> 16;
        int g = ( rgb & 0x0000FF00 ) >> 8;
        int b = rgb & 0x000000FF;
        return new Color( r, g, b );
    }
        
}
