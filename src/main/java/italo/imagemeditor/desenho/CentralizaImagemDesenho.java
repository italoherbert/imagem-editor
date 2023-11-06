package italo.imagemeditor.desenho;

import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.image.BufferedImage;

public class CentralizaImagemDesenho implements Desenho {

    private final BufferedImage imagem;
    
    public CentralizaImagemDesenho( BufferedImage imagem ) {
        this.imagem = imagem;
    }
    
    @Override
    public void desenha(Grafico g) {
        int telaLarg = g.getLargura()-1;
        int telaAlt = g.getAltura()-1;
        
        int imgLarg = imagem.getWidth();
        int imgAlt = imagem.getHeight();
        
        int x, y, largura, altura;
        int px, py;
        
        if ( imgLarg > telaLarg ) {
            x = ( imgLarg - telaLarg ) / 2;
            largura = telaLarg;
            px = 0;
        } else {
            x = 0;
            largura = imgLarg;
            px = ( telaLarg - imgLarg ) / 2;
        }
        
        if ( imgAlt > telaAlt ) {
            y = ( imgAlt - telaAlt ) / 2;
            altura = telaAlt;
            py = 0;
        } else {
            y = 0;
            altura = imgAlt;
            py = ( telaAlt - imgAlt ) / 2;
        }
                             
        for( int i = 0; i < altura; i++ ) {
            for( int j = 0; j < largura; j++ ) {
                int rgb = imagem.getRGB( x+j, y+i );
                g.setPixel( px+j, py+i, rgb ); 
            }
        }              
    }
            
}
