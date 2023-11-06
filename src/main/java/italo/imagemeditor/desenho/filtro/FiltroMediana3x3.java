package italo.imagemeditor.desenho.filtro;

public class FiltroMediana3x3 implements Filtro3x3 {

    private final double[][] FILTRO = {
        { 1.0/9.0, 1.0/9.0, 1.0/9.0 },
        { 1.0/9.0, 1.0/9.0, 1.0/9.0 },
        { 1.0/9.0, 1.0/9.0, 1.0/9.0 },        
    };
    
    @Override
    public double[][] getFiltroMat() {
        return FILTRO;
    }
    
}
