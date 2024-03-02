import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class yol {
    int yol_id=0;
    public BufferedImage yol_image;
    uygulama uyg;
    public yol(uygulama uyg){
        this.uyg=uyg;
        get_yol_image();

    }
    public void get_yol_image(){
        try{
            yol_image= ImageIO.read(getClass().getResourceAsStream("/road00.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
