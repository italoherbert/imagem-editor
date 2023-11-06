package italo.imagemeditor.controller;

import italo.imagemeditor.Sistema;
import italo.imagemeditor.desenho.AplicaFiltro3x3Desenho;
import italo.imagemeditor.desenho.PixelizaDesenho;
import italo.imagemeditor.desenho.RemoveCanalDesenho;
import italo.imagemeditor.desenho.TonsDeCinzaConversorDesenho;
import italo.imagemeditor.desenho.canal.AzulCanalCor;
import italo.imagemeditor.desenho.canal.CanalCor;
import italo.imagemeditor.desenho.canal.VerdeCanalCor;
import italo.imagemeditor.desenho.canal.VermelhoCanalCor;
import italo.imagemeditor.desenho.filtro.Filtro3x3;
import italo.imagemeditor.desenho.filtro.FiltroGaussiano3x3;
import italo.imagemeditor.gui.janela.ImagemOperListener;
import italo.imagemeditor.gui.janela.JanelaPrincipal;

public class ImagemOperController implements ImagemOperListener {

    private final Sistema sistema;
    
    public ImagemOperController( Sistema sistema ) {
        this.sistema = sistema;
    }
    
    @Override
    public void removeCanalVermelhoBTClicado(JanelaPrincipal jp) {
        CanalCor canal = new VermelhoCanalCor();
        RemoveCanalDesenho desenho = new RemoveCanalDesenho( canal );
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void removeCanalVerdeBTClicado(JanelaPrincipal jp) {
        CanalCor canal = new VerdeCanalCor();
        RemoveCanalDesenho desenho = new RemoveCanalDesenho( canal );
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void removeCanalAzulBTClicado(JanelaPrincipal jp) {
        CanalCor canal = new AzulCanalCor();
        RemoveCanalDesenho desenho = new RemoveCanalDesenho( canal );
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void converteParaCinzaBTClicado(JanelaPrincipal jp) {
        TonsDeCinzaConversorDesenho desenho = new TonsDeCinzaConversorDesenho();
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void aplicaFiltroGausssianoBTClicado(JanelaPrincipal jp) {
        Filtro3x3 filtro = new FiltroGaussiano3x3();
        AplicaFiltro3x3Desenho desenho = new AplicaFiltro3x3Desenho( filtro );
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void pixelizaBTClicado(JanelaPrincipal jp) {
        PixelizaDesenho desenho = new PixelizaDesenho();
        sistema.getPainelDesenho().add( desenho );
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void desfazBTClicado(JanelaPrincipal jp) {
        sistema.getPainelDesenho().desfaz();
        sistema.getGUI().repaintPainelDesenho();
    }

    @Override
    public void refazBTClicado(JanelaPrincipal jp) {
        sistema.getPainelDesenho().refaz();
        sistema.getGUI().repaintPainelDesenho();
    }
    
}
