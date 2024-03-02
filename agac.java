import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class agac {
    int agac_pixel_boyut=5;//5x5

    int agac_id=1;//possibility %50*
    uygulama ugl;
    public BufferedImage agac_image;
    public agac(uygulama ugl){
        this.ugl=ugl;
        get_agac_image();
    }
    public void get_agac_image(){
        try{
            agac_image= ImageIO.read(getClass().getResourceAsStream("/agac.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
