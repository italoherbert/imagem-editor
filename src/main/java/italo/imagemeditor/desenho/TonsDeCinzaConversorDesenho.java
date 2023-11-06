package italo.imagemeditor.desenho;

import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.Color;

public class TonsDeCinzaConversorDesenho implements Desenho {

    @Override
    public void desenha( Grafico g ) {
        int telaLarg = g.getLargura();
        int telaAlt = g.getAltura();
        
        for( int y = 0; y < telaAlt; y++ ) {
            for( int x = 0; x < telaLarg; x++ ) {
                Color cor = g.getPixelCor( x, y );
                int vermelho = cor.getRed();
                int verde = cor.getGreen();
                int azul = cor.getBlue();
                
                int cinza = ( vermelho + verde + azul ) / 3;
                Color novaCor = new Color( cinza, cinza, cinza );
                g.setPixel( x, y, novaCor );
            }
        }                
    }
    
}
