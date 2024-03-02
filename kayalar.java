import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class kayalar {
    public int id_kaya=3;
    uygulama uyg;
    public BufferedImage kaya_image;
    public kayalar(uygulama uyg){
        this.uyg=uyg;
        get_kaya_image();

    }
    public void get_kaya_image(){
        try{
            kaya_image= ImageIO.read(getClass().getResourceAsStream("/stone2.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
