package italo.imagemeditor.gui.desenho;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class DesenhoPainelGUI extends JPanel implements DesenhoPainel {
        
    private final Grafico grafico = new Grafico( this );
    
    private Desenho desenho = null;
    
    private boolean inicializarGrafico = true;
    
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        if ( inicializarGrafico ) {
            grafico.inicializa();
            inicializarGrafico = false;
        }
                    
        if ( desenho != null )
            desenho.desenha( grafico );
        
        Image image = grafico.getBufferedImage();
        int largura = grafico.getLargura();
        int altura = grafico.getAltura();
        
        g.drawImage( image, 0, 0, largura, altura, this );
    }

    @Override
    public Grafico getGrafico() {
        return grafico;
    }

    @Override
    public Desenho getDesenho() {
        return desenho;
    }

    @Override
    public void setDesenho(Desenho pintor) {
        this.desenho = pintor;
    }

}
