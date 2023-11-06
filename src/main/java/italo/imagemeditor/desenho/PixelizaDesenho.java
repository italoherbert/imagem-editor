package italo.imagemeditor.desenho;

import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.Color;

public class PixelizaDesenho implements Desenho {

    private final int pixelFator = 10;
    
    @Override
    public void desenha( Grafico g ) {
        int imgLarg = g.getLargura();
        int imgAlt = g.getAltura();
        
        int imgPxLarg = imgLarg / pixelFator;
        int imgPxAlt = imgAlt / pixelFator;
        
        for( int i = 0; i < imgPxAlt; i++ ) {
            for( int j = 0; j < imgPxLarg; j++ ) {
                int px1 = j * pixelFator;
                int py1 = i * pixelFator;
                int px2 = px1 + pixelFator;
                int py2 = py1 + pixelFator;
                
                int vermelho = 0;
                int verde = 0;
                int azul = 0;
                for( int y = py1; y < py2; y++ ) {
                    for( int x = px1; x < px2; x++ ) {
                        Color cor = g.getPixelCor( x, y );
                        
                        vermelho += cor.getRed();
                        verde += cor.getGreen();
                        azul += cor.getBlue();
                    }
                }
                
                vermelho /= ( pixelFator * pixelFator );
                verde /= ( pixelFator * pixelFator );
                azul /= ( pixelFator * pixelFator );
                
                Color mediaCor = new Color( vermelho, verde, azul );
                
                for( int y = py1; y < py2; y++ )
                    for( int x = px1; x < px2; x++ )
                        g.setPixel( x, y, mediaCor );                                                    
            }
        }
        
        
    }
    
}
