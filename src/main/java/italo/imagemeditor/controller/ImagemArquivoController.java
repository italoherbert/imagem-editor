package italo.imagemeditor.controller;

import italo.imagemeditor.Erros;
import italo.imagemeditor.Infos;
import italo.imagemeditor.desenho.CentralizaImagemDesenho;
import italo.imagemeditor.gui.desenho.Desenho;
import italo.imagemeditor.gui.janela.ImagemArquivoListener;
import italo.imagemeditor.gui.janela.JanelaPrincipal;
import italo.imagemeditor.logica.ImagemArquivoUtil;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImagemArquivoController implements ImagemArquivoListener {
    
    private final Sistema sistema;
   
    public ImagemArquivoController( Sistema sistema ) {
        this.sistema = sistema;
    }
    
    @Override
    public void carregarBTClicado(JanelaPrincipal jp) {
        ImagemArquivoUtil imgArqUtil = sistema.getImagemArquivoUtil();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
        chooser.setMultiSelectionEnabled( false );
        chooser.setAcceptAllFileFilterUsed( false );
        chooser.setCurrentDirectory( new File( "." ) ); 
        
        chooser.setFileFilter( imgArqUtil.fileFilter() );
        
        int result = chooser.showOpenDialog( null );
        if ( result == JFileChooser.APPROVE_OPTION ) {
            try {
                File arquivo = chooser.getSelectedFile();
                BufferedImage imagem = ImageIO.read( new FileInputStream( arquivo ) );
                
                Desenho desenho = new CentralizaImagemDesenho( imagem );
                
                sistema.getPainelDesenho().add( desenho );
                sistema.getGUI().repaintPainelDesenho();
            } catch (FileNotFoundException ex) {
                sistema.getGUI().mostraMensagemErro( Erros.ARQUIVO_IMG_NAO_ENCONTRADO );
            } catch (IOException ex) {
                sistema.getGUI().mostraMensagemErro( Erros.ARQUIVO_IMG_ERRO_LEITURA );
            }
        }
    }

    @Override
    public void salvarBTClicado(JanelaPrincipal jp) {
        ImagemArquivoUtil imgArqUtil = sistema.getImagemArquivoUtil();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
        chooser.setMultiSelectionEnabled( false );
        chooser.setCurrentDirectory( new File( "." ) ); 
                
        int result = chooser.showSaveDialog( null );
        if ( result == JFileChooser.APPROVE_OPTION ) {
            try {
                File arquivo = chooser.getSelectedFile();                
                String arquivoNome = arquivo.getName();
                
                boolean nomeValido = imgArqUtil.isNomeValido( arquivoNome );                
                if ( nomeValido ) {
                    String formato = imgArqUtil.getFormato( arquivoNome );
                    
                    BufferedImage image = (BufferedImage)jp.getDesenhoPainel().getGrafico().getBufferedImage();
                    ImageIO.write( image, formato, new FileOutputStream( arquivo ) );

                    sistema.getGUI().mostraMensagemInfo( Infos.IMAGEM_SALVA ); 
                } else {
                    sistema.getGUI().mostraMensagemErro( Erros.ARQUIVO_IMG_TIPO_INVALIDO ); 
                }
            } catch (FileNotFoundException ex) {
                sistema.getGUI().mostraMensagemErro( Erros.CAMINHO_DIR_NAO_ENCONTRADO );
            } catch (IOException ex) {
                sistema.getGUI().mostraMensagemErro( Erros.ARQUIVO_IMG_ERRO_GRAVACAO );
            }
        }                
    }
    
}
