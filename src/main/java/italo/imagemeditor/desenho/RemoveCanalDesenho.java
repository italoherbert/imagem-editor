package italo.imagemeditor.desenho;

import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.Color;
import italo.imagemeditor.desenho.canal.CanalCor;

public class RemoveCanalDesenho implements Desenho {
    
    private final CanalCor canalCor;
    
    public RemoveCanalDesenho( CanalCor canalCor ) {
        this.canalCor = canalCor;
    }
    
    @Override
    public void desenha(Grafico g) {
        int telaLarg = g.getLargura();
        int telaAlt = g.getAltura();
        
        for( int y = 0; y < telaAlt; y++ ) {
            for( int x = 0; x < telaLarg; x++ ) {
                Color cor = g.getPixelCor( x, y );
                int vermelho = cor.getRed();
                int verde = cor.getGreen();
                int azul = cor.getBlue();
     
                Color novaCor = canalCor.removeCor( vermelho, verde, azul );                
                g.setPixel( x, y, novaCor );
            }
        }
    }
    
}
