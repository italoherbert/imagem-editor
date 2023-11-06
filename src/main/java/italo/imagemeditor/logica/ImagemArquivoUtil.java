package italo.imagemeditor.logica;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ImagemArquivoUtil {
    
    public final static String[] IMG_EXTS_VALIDAS = { ".jpg", ".jpeg", ".png", ".gif" };
    public final static String FILTRO_DESCRICAO = "jpg, jpeg, gif e png";
        
    public boolean isNomeValido( String arquivoNome ) {
        int pontoI = arquivoNome.indexOf( "." );
        if ( pontoI < 1 )
            return false;
        return this.isExtValida( arquivoNome );
    }
    
    public boolean isExtValida( String arquivoNome ) {        
        for( String ext : IMG_EXTS_VALIDAS )
            if ( arquivoNome.endsWith( ext ) )
                return true;
        return false;
    }
    
    public String getFormato( String arquivoNome ) {
        int pontoI = arquivoNome.indexOf( "." );
        if ( pontoI < 1 )
            return "jpeg";
    
        String ext = arquivoNome.substring( pontoI );    
        if ( ext.equals( ".png" ) )
            return "png";
        if ( ext.equals( "gif" ) )
            return "gif";
        return "jpeg";
    }
    
    public FileFilter fileFilter() {
        return new FileFilter() {
            @Override
            public boolean accept(File f) {
                return isNomeValido( f.getName() ) || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return FILTRO_DESCRICAO;
            }
        };
    }
        
}
