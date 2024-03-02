import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class duvar {
    public int id=4;
    public BufferedImage wall_image;
    uygulama uyg;
    public duvar(uygulama uyg){
        this.uyg=uyg;
        get_duvar_image();
    }

    public void get_duvar_image(){
        try {
            wall_image= ImageIO.read(getClass().getResourceAsStream("wall.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
