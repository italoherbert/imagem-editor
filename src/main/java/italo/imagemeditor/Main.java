package italo.imagemeditor;

import javax.swing.UIManager;

public class Main {

    static {
        UIManager.put( "FileChooser.openDialogTitleText", "Abrir" );
        UIManager.put( "FileChooser.saveDialogTitleText", "Salvar" );
        UIManager.put( "FileChooser.cancelButtonText", "Cancelar" );
        UIManager.put( "FileChooser.openButtonText", "Abrir" );
        UIManager.put( "FileChooser.saveButtonText", "Salvar" );
        UIManager.put( "FileChooser.filesOfTypeLabelText", "Arquivos do tipo" );
        UIManager.put( "FileChooser.fileNameLabelText", "Nome do arquivo" );
        UIManager.put( "FileChooser.listViewButtonToolTipText", "Visualizar" );
        UIManager.put( "FileChooser.newFolderToolTipText", "Nova pasta" );
        UIManager.put( "FileChooser.homeFolderToolTipText", "Pasta home" );
        UIManager.put( "FileChooser.detailsViewButtonToolTipText", "Detalhes" );
        UIManager.put( "FileChooser.upFolderToolTipText", "Pasta pai" );
        UIManager.put( "FileChooser.lookInLabelText", "Procurar em" );
        UIManager.put( "FileChooser.saveInLabelText", "Salvar em" );
        UIManager.put( "FileChooser.foldersLabelText", "Pastas" );
        UIManager.put( "FileChooser.acceptAllFileFilterText", "Todos" );        
    }
    
    public static void main( String[] args ) {
        SistemaApp sistema = new SistemaApp();
        sistema.executa();
    }
    
}
