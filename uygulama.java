import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class uygulama extends JPanel implements Runnable{


    final int originalTileSize=1;
    final int scale=3;

    public int x,y=0;
    public final int tileSize=60;
    final int maxScreenCol=64;
    final int maxScreenRow=48;
    final int screenWidth=tileSize*maxScreenCol;
    final int screenHeight=tileSize*maxScreenRow;
    int FPS=60;
    int row=0;
    int col=0;
    Map_Generator Map=new Map_Generator();

    agac a=new agac(this);
    karakter k=new karakter(this);
    yol yol_1=new yol(this);
    duvar duvar_1=new duvar(this);
    dag dag_1=new dag(this);
    kayalar kaya_1=new kayalar(this);
    Thread uyg_thread;







    public uygulama(){

        this.setPreferredSize(new Dimension(900,900));

        this.setBackground(Color.black);
        this.setDoubleBuffered(true);



        Map.generateMap();



        update();

    }
    public void update(){




    }





    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        for(row=0;row<Map.input_a;row++)
        {
            for(col=0;col<Map.input_b;col++){
                if(Map.dizi[col][row]==1)
                {
                    for(int agac_i=0;agac_i<6;agac_i++)
                    {
                        for(int agac_j=0;agac_j<6;agac_j++)
                        {
                            g2.drawImage(a.agac_image,(col*tileSize)+(agac_i*10),(row*tileSize)+(agac_j*10),10,10,null);
                        }
                    }
                }
                else if (Map.dizi[col][row]==4)
                {
                    for(int duvar_i=0;duvar_i<6;duvar_i++)
                    {
                        for(int duvar_j=1;duvar_j<6;duvar_j++)
                        {
                            g2.drawImage(duvar_1.wall_image,(col*tileSize),(row*tileSize),60,10,null);
                            g2.drawImage(a.agac_image,(col*tileSize)+(duvar_i*10),(row*tileSize)+(duvar_j*10),10,10,null);


                        }
                    }

                }
                else if(Map.dizi[col][row]==0)
                {
                    g2.drawImage(yol_1.yol_image,tileSize*col,tileSize*row,60,60,null);
                }
                else if(Map.dizi[col][row]==2)
                {
                    for(int dag_i=0;dag_i<2;dag_i++)
                    {
                        for(int dag_j=0;dag_j<2;dag_j++)
                        {
                            g2.drawImage(dag_1.dag_image,(tileSize*col)+(dag_i*30),(tileSize*row)+(dag_j*30),30,30,null);

                        }
                    }

                }
                else if(Map.dizi[col][row]==3)
                {
                    for(int kaya_i=0;kaya_i<10;kaya_i++)
                    {
                        for (int kaya_j=0;kaya_j<10;kaya_j++)
                        {
                            g2.drawImage(kaya_1.kaya_image,(tileSize*col)+(kaya_i*6),(row*tileSize)+(kaya_j*6),6,6,null);
                        }
                    }

                }else if(Map.dizi[col][row]==5)
                {
                    g2.fillRect(tileSize*col,row*tileSize,60,60);

                } else if (Map.dizi[col][row]==9) {
                    g2.drawImage(k.kar_image,tileSize*col,tileSize*row,60,60,null);
                }

            }}



        g2.dispose();
        repaint();
        }



    @Override
    public void run() {
        double drawInterval=1000000000/(FPS/4);
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(uyg_thread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime=currentTime;
            if(delta>=1){

                update();

                delta--;
            }


        }
    }
    public void start_thread(){
        uyg_thread=new Thread(this);
        uyg_thread.start();
    }
}
