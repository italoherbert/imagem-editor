package italo.imagemeditor.desenho;

import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.desenho.Grafico;
import java.awt.Color;
import java.util.LinkedList;

public class PainelDesenho implements Desenho {

    private final LinkedList<Desenho> desenhos = new LinkedList();
    private final LinkedList<Desenho> removidos = new LinkedList();
        
    @Override
    public void desenha( Grafico g ) {
        g.setColor( new Color( 200, 200, 200 ) );
        g.preencheTela();
                        
        desenhos.forEach( ( d ) -> d.desenha( g ) );
    }
    
    public void add( Desenho desenho ) {
        desenhos.add( desenho );
    }
    
    public void desfaz() {
        if ( !desenhos.isEmpty() ) {
            Desenho d = desenhos.removeLast();
            removidos.add( d );
        }
    }
    
    public void refaz() {
        if ( !removidos.isEmpty() ) {
            Desenho d = removidos.removeLast();
            desenhos.add(d ); 
        }
    }
    
}
