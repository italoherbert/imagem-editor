package italo.imagemeditor.desenho;

import italo.imagemeditor.desenho.filtro.Filtro3x3;
import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class AplicaFiltro3x3Desenho implements Desenho {
    
    private final Filtro3x3 filtro;
    
    public AplicaFiltro3x3Desenho( Filtro3x3 filtro ) {
        this.filtro = filtro;
    }

    @Override
    public void desenha( Grafico g ) {
        BufferedImage imagem = g.getBufferedImage();
        BufferedImage imagemNova = g.novoBufferedImage();
                
        int imgLarg = imagem.getWidth();
        int imgAlt = imagem.getHeight();
        
        double[][] filtroMat = filtro.getFiltroMat();
        
        for( int y = 0; y < imgAlt; y++ ) {
            for( int x = 0; x < imgLarg; x++ ) {                                
                int iInit = ( y > 0 ? -1 : 0 );
                int iFim = ( y < imgAlt-1 ? 1 : 0 );
                int jInit = ( x > 0 ? -1 : 0 );
                int jFim = ( x < imgLarg-1 ? 1 : 0 );
                
                int vermelho = 0;
                int verde = 0;
                int azul = 0;
                for( int i = iInit; i <= iFim; i++ ) {
                    for( int j = jInit; j <= jFim; j++ ) {                        
                        int rgb = imagemNova.getRGB( x+j, y+i );
                        Color cor = g.getCorUtil().toColor( rgb );

                        double fator = filtroMat[ i+1 ][ j+1 ];
                        vermelho += (int)( cor.getRed() * fator );
                        verde += (int)( cor.getGreen() * fator );
                        azul += (int)( cor.getBlue() * fator );                        
                    }
                }
                
                Color novaCor = new Color( vermelho, verde, azul );
                int novaCorRGB = g.getCorUtil().toRGB( novaCor );
                
                imagem.setRGB( x, y, novaCorRGB );
            }
        }
    }
    
}
