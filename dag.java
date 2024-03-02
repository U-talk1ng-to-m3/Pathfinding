import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class dag {
    public int dag_id=3;

    BufferedImage dag_image;
    uygulama uyg;
    public dag(uygulama uyg){
        this.uyg=uyg;
        get_dag_image();
    }
    public void get_dag_image()
    {
        try{
            dag_image= ImageIO.read(getClass().getResourceAsStream("/mountain.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
