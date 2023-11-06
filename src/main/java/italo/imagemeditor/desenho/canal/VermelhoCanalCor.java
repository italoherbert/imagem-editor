package italo.imagemeditor.desenho.canal;

import java.awt.Color;

public class VermelhoCanalCor implements CanalCor {

    @Override
    public Color removeCor(int r, int g, int b) {
        return new Color( 0, g, b );
    }
    
}
