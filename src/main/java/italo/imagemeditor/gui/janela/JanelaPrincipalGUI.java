package italo.imagemeditor.gui.janela;

import italo.imagemeditor.gui.desenho.DesenhoPainel;
import italo.imagemeditor.gui.desenho.DesenhoPainelGUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipalGUI extends JFrame implements JanelaPrincipal, ActionListener {
    
    private final DesenhoPainelGUI desenhoGUI = new DesenhoPainelGUI();
    private ImagemOperListener imagemOperListener = new ImagemOperAdapter();
    private ImagemArquivoListener imagemArquivoListener = new ImagemArquivoAdapter();
    
    private JButton removeCanalVermelhoBT;
    private JButton removeCanalVerdeBT;
    private JButton removeCanalAzulBT;
    
    private JButton converteParaCinzaBT;
    private JButton aplicaFiltroGaussianoBT;
    private JButton pixelizaBT;
    
    private JButton desfazBT;
    private JButton refazBT;
    
    private JButton carregaBT;
    private JButton salvaBT;
    
    public JanelaPrincipalGUI() {                     
        JPanel nortePNL = this.criaNortePNL();
        JPanel sulPNL = this.criaSulPNL();
        
        Container c = super.getContentPane();
        c.setLayout( new BorderLayout( 5, 5 ) );
        c.add( BorderLayout.NORTH, nortePNL );
        c.add( BorderLayout.CENTER, desenhoGUI );
        c.add( BorderLayout.SOUTH, sulPNL );
        
        super.setTitle( "Ferramenta de Manipulação de Imagem" );        
        super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        super.setSize( 650, 500 );
        super.setLocationRelativeTo( this );                
    }
                    
    private JPanel criaNortePNL() {
        converteParaCinzaBT = new JButton( "Tons de sinza" );        
        aplicaFiltroGaussianoBT = new JButton( "Filtro gaussiano" );
        pixelizaBT = new JButton( "Pixeliza" );
        
        converteParaCinzaBT.addActionListener( this ); 
        aplicaFiltroGaussianoBT.addActionListener( this );
        pixelizaBT.addActionListener( this );
        
        JPanel botoesPNL = new JPanel();
        botoesPNL.setLayout( new FlowLayout( FlowLayout.LEFT ) );
        botoesPNL.setBorder( BorderFactory.createTitledBorder( "Filtros" ) );
        botoesPNL.add( converteParaCinzaBT );
        botoesPNL.add( aplicaFiltroGaussianoBT );
        botoesPNL.add( pixelizaBT );
        
        JPanel nortePNL = new JPanel();
        nortePNL.setLayout( new FlowLayout( FlowLayout.CENTER ) ); 
        nortePNL.add( botoesPNL );
        nortePNL.add( this.criaCanalPNL() );
        
        return nortePNL;
    }
    
    private JPanel criaSulPNL() {
        carregaBT = new JButton( "Carregar" );
        salvaBT = new JButton( "Salvar" );              
        desfazBT = new JButton( "Desfaz" );
        refazBT = new JButton( "Refaz" );
        
        carregaBT.addActionListener( this );
        salvaBT.addActionListener( this );         
        desfazBT.addActionListener( this );
        refazBT.addActionListener( this );        
                                        
        JPanel arqPNL = new JPanel();
        arqPNL.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        arqPNL.add( carregaBT );
        arqPNL.add( salvaBT );
        
        JPanel drPNL = new JPanel();
        drPNL.setLayout( new FlowLayout( FlowLayout.LEFT ) );
        drPNL.add( desfazBT );
        drPNL.add( refazBT );
        
        JPanel sulPNL = new JPanel();
        sulPNL.setLayout( new BorderLayout( 5, 5 ) );
        sulPNL.add( BorderLayout.WEST, drPNL );
        sulPNL.add( BorderLayout.EAST, arqPNL );
        return sulPNL;
    }
    
    private JPanel criaCanalPNL() {
        removeCanalVermelhoBT = new JButton( "Vermelho" );
        removeCanalVerdeBT = new JButton( "Verde" );
        removeCanalAzulBT = new JButton( "Azul" );
        
        removeCanalVermelhoBT.addActionListener( this );
        removeCanalVerdeBT.addActionListener( this );
        removeCanalAzulBT.addActionListener( this ); 
        
        JPanel canalPNL = new JPanel();
        canalPNL.setLayout( new FlowLayout() );
        canalPNL.setBorder( BorderFactory.createTitledBorder( "Remove canal" ) );
        canalPNL.add(removeCanalVermelhoBT );
        canalPNL.add(removeCanalVerdeBT );
        canalPNL.add(removeCanalAzulBT );
        
        return canalPNL;
    }
            
    @Override
    public void actionPerformed( ActionEvent e ) {                
        if ( e.getSource() == removeCanalVermelhoBT ) {
            imagemOperListener.removeCanalVermelhoBTClicado( this );
        } else if ( e.getSource() == removeCanalVerdeBT ) {
            imagemOperListener.removeCanalVerdeBTClicado( this );
        } else if ( e.getSource() == removeCanalAzulBT ) {
            imagemOperListener.removeCanalAzulBTClicado( this );
        } else if ( e.getSource() == converteParaCinzaBT ) {
            imagemOperListener.converteParaCinzaBTClicado( this ); 
        } else if ( e.getSource() == aplicaFiltroGaussianoBT ) {
            imagemOperListener.aplicaFiltroGausssianoBTClicado( this ); 
        } else if ( e.getSource() == pixelizaBT ) {
            imagemOperListener.pixelizaBTClicado( this ); 
        } else if ( e.getSource() == desfazBT ) {
            imagemOperListener.desfazBTClicado( this );
        } else if ( e.getSource() == refazBT ) {
            imagemOperListener.refazBTClicado( this ); 
        } else if ( e.getSource() == carregaBT ) {
            imagemArquivoListener.carregarBTClicado( this );
        } else if ( e.getSource() == salvaBT ) {
            imagemArquivoListener.salvarBTClicado( this ); 
        }
    }

    @Override
    public void setVisivel( boolean visivel ) {
        super.setVisible( visivel );
    }        

    @Override
    public void setImagemOperListener( ImagemOperListener listener ) {
        this.imagemOperListener = listener;
    }

    @Override
    public void setImagemArquivoListener( ImagemArquivoListener listener ) {
        this.imagemArquivoListener = listener;
    }    
            
    @Override
    public DesenhoPainel getDesenhoPainel() {
        return desenhoGUI;
    }        
    
}
