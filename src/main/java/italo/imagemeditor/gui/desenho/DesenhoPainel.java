package italo.imagemeditor.gui.desenho;

public interface DesenhoPainel extends DesenhoTela {
        
    public void repaint();
    
    public Grafico getGrafico();
    
    public Desenho getDesenho();
    
    public void setDesenho( Desenho pintor );
    
}
