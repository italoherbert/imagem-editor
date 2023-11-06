package italo.imagemeditor.gui.desenho;

import italo.imagemeditor.gui.desenho.util.CorUtil;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Grafico {
           
    private final CorUtil corUtil = new CorUtil();
    private final DesenhoTela tela;

    private BufferedImage imagem = null;
    private Graphics graphics = null;
    private int rgb = 0x0;
    
    public Grafico( DesenhoTela tela ) {
        this.tela = tela;
    }
    
    public void inicializa() {
        if ( graphics != null )
            graphics.dispose();
        
        imagem = new BufferedImage( 
                tela.getWidth(), 
                tela.getHeight(), 
                BufferedImage.TYPE_INT_RGB );
        
        graphics = imagem.createGraphics();
    }
        
    public void preencheTela() {
        int larg = tela.getWidth();
        int alt = tela.getHeight();
        
        if ( imagem != null )
            for( int y = 0; y < alt; y++ )
                for( int x = 0; x < larg; x++ )
                    imagem.setRGB( x, y, rgb );                                         
    }
    
    public void setPixel( int x, int y ) {
        setPixel( x, y, rgb );
    }
        
    public void setPixel( int x, int y, int corRGB ) {
        if ( imagem != null )
            imagem.setRGB( x, y, corRGB ); 
    }
    
    public void setPixel( int x, int y, Color cor ) {
        if ( imagem != null ) {
            int corRGB = corUtil.toRGB( cor );
            imagem.setRGB( x, y, corRGB ); 
        }
    }

    
    public int getPixel( int x, int y ) {
        if ( imagem != null )
            return imagem.getRGB( x, y );
        return 0x0;
    }
    
    public Color getPixelCor( int x, int y ) {
        if ( imagem != null ) {
            int corRGB = imagem.getRGB( x, y );
            return corUtil.toColor( corRGB );
        }
        return Color.BLACK;
    }
    
    public Color getCor() {
        return corUtil.toColor( rgb );
    }
    
    public void setColor( Color cor ) {
        rgb = corUtil.toRGB( cor );
    }
    
    public BufferedImage novoBufferedImage() {
        if ( imagem == null )
            return null;
        
        int imgLarg = imagem.getWidth();
        int imgAlt = imagem.getHeight();
        
        BufferedImage novo = new BufferedImage( 
                imgLarg, imgAlt, BufferedImage.TYPE_INT_RGB );
        
        for( int y = 0; y < imgAlt; y++ )
            for( int x = 0; x < imgLarg; x++ )
                novo.setRGB( x, y, imagem.getRGB( x, y ) ); 
                
        return novo;
    }
    
    public int getLargura() {        
        return tela.getWidth();
    }
    
    public int getAltura() {
        return tela.getHeight();
    }
    
    public BufferedImage getBufferedImage() {
        return imagem;
    }
    
    public Graphics getGraphics() {
        return graphics;
    }
    
    public DesenhoTela getDesenhoTela() {
        return tela;
    }
    
    public CorUtil getCorUtil() {
        return corUtil;
    }
    
}
