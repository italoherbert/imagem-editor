package italo.imagemeditor.desenho.filtro;

public class FiltroGaussiano3x3 implements Filtro3x3 {

    private final double[][] FILTRO = {
        { 1.0/36.0, 4.0/36.0, 1.0/36.0 },
        { 4.0/36.0, 16.0/36.0, 4.0/36.0 },
        { 1.0/36.0, 4.0/36.0, 1.0/36.0 },        
    };
    
    @Override
    public double[][] getFiltroMat() {
        return FILTRO;
    }
    
}
