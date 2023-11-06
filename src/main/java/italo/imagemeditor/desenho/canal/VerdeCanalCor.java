package italo.imagemeditor.desenho.canal;

import java.awt.Color;

public class VerdeCanalCor implements CanalCor {

    @Override
    public Color removeCor(int r, int g, int b) {
        return new Color( r, 0, b );
    }
    
}
