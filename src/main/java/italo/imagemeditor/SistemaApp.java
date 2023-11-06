package italo.imagemeditor;

import italo.imagemeditor.controller.ImagemArquivoController;
import italo.imagemeditor.controller.ImagemOperController;
import italo.imagemeditor.controller.Sistema;
import italo.imagemeditor.desenho.PainelDesenho;
import italo.imagemeditor.gui.GUI;
import italo.imagemeditor.logica.ImagemArquivoUtil;
import javax.swing.SwingUtilities;

public class SistemaApp implements Sistema {

    private final ImagemArquivoUtil imagemArquivoUtil = new ImagemArquivoUtil();
    
    private final PainelDesenho painelDesenho = new PainelDesenho();    
    private final GUI gui = new GUI();
    
    private final ImagemOperController imagemOperController = new ImagemOperController( this );
    private final ImagemArquivoController imagemArquivoController = new ImagemArquivoController( this );
    
    public void executa() {
        gui.getJanelaPrincipal().getDesenhoPainel().setDesenho(painelDesenho );
        
        gui.getJanelaPrincipal().setImagemOperListener( imagemOperController );
        gui.getJanelaPrincipal().setImagemArquivoListener( imagemArquivoController ); 
   
        SwingUtilities.invokeLater( () -> {
            gui.getJanelaPrincipal().setVisivel( true );
            gui.getJanelaPrincipal().getDesenhoPainel().repaint();
        } );
    }        
    
    @Override
    public GUI getGUI() {
        return gui;
    }
    
    @Override
    public PainelDesenho getPainelDesenho() {
        return painelDesenho;
    }
    
    @Override
    public ImagemArquivoUtil getImagemArquivoUtil() {
        return imagemArquivoUtil;
    }
    
}
