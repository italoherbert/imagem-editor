package italo.imagemeditor.controller;

import italo.imagemeditor.desenho.PainelDesenho;
import italo.imagemeditor.gui.GUI;
import italo.imagemeditor.logica.ImagemArquivoUtil;

public interface Sistema {
    
    public GUI getGUI();
    
    public PainelDesenho getPainelDesenho();
    
    public ImagemArquivoUtil getImagemArquivoUtil();
    
}
