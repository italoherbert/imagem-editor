package italo.imagemeditor.desenho.canal;

import java.awt.Color;

public class AzulCanalCor implements CanalCor {

    @Override
    public Color removeCor(int r, int g, int b) {
        return new Color( r, g, 0 );
    }
    
}
