package italo.imagemeditor.gui;

import italo.imagemeditor.gui.janela.JanelaPrincipal;
import italo.imagemeditor.gui.janela.JanelaPrincipalGUI;
import javax.swing.JOptionPane;

public class GUI {
    
    private final JanelaPrincipalGUI janelaGUI = new JanelaPrincipalGUI();
    
    public JanelaPrincipal getJanelaPrincipal() {
        return janelaGUI;
    }
    
    public void repaintPainelDesenho() {
        janelaGUI.getDesenhoPainel().repaint();
    }
        
    public void mostraMensagemInfo( String mensagem ) {
        JOptionPane.showMessageDialog( 
                janelaGUI, 
                mensagem, 
                "Mensagem de informação", 
                JOptionPane.INFORMATION_MESSAGE );
    }
    
    public void mostraMensagemErro( String mensagem ) {
        JOptionPane.showMessageDialog(
                janelaGUI, 
                mensagem, 
                "Mensagem de erro", 
                JOptionPane.ERROR_MESSAGE );
    }
        
}
