package italo.imagemeditor.gui.janela;

import italo.imagemeditor.gui.desenho.DesenhoPainel;

public interface JanelaPrincipal {        
        
    public void setVisivel( boolean visivel );
    
    public void setImagemOperListener( ImagemOperListener listener );
    
    public void setImagemArquivoListener( ImagemArquivoListener listener );
    
    public DesenhoPainel getDesenhoPainel(); 
    
}
