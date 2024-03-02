

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class Map_Generator{


    int birthLimit=4;



    int deathLimit=4;
    int numberOfSteps=1;
    public int input_a=10;
    public int input_b=10;
    public int zerosAdded=0;
    public int kar_say=0;



    public int count=0;

    float chancetoalive=0.37f;
    Random random=new Random();
    int[] weightedValues = {1, 1, 3, 1, 1, 1, 2, 1, 1, 2, 3, 4};
    int totalWeight = weightedValues.length;


    public int[][] dizi=new int[input_a][input_b];
    public boolean[][] cellmap=new boolean[input_a][input_b];

    public boolean[][] initialiseMap(boolean[][] map){
        for(int i=0;i<input_a;i++)
        {
            for(int j=0;j<input_b;j++)
            {
                if(random()<chancetoalive)
                {
                    map[i][j]=true;
                }
            }
        }
        return map;
    }
    public int[][] generateMap(){


        cellmap=initialiseMap(cellmap);
        for(int i=0;i<numberOfSteps;i++){
            cellmap=doSimulationMap(cellmap);


        }
        for(int i=0;i<input_a;i++){
            for(int j=0;j<input_b;j++){

                if(cellmap[i][j]){
                    dizi[i][j]=1;

                }
                else{
                    dizi[i][j]=0;
                    count+=1;
                }


            }



        }
        for (int it = 0; it < input_a; it++) {
            for (int jt = 0; jt < input_b; jt++) {
                if (dizi[it][jt] == 1) {
                    int randomIndex = random.nextInt(totalWeight);
                    dizi[it][jt] = weightedValues[randomIndex];
                }

            }
        }
        while (zerosAdded < 5) {
            int hs = random.nextInt(input_a);
            int hs1 = random.nextInt(input_b);

            if (dizi[hs][hs1] == 0) {
                dizi[hs][hs1] = 5;
                zerosAdded++;
            }
        }
        while(kar_say<1){
            int hss=random.nextInt(input_a);
            int hss1= random.nextInt(input_b);
            if(dizi[hss][hss1]==0)
            {
                dizi[hss][hss1]=9;
                kar_say+=1;
            }
        }




        return dizi;
    }

    public boolean[][] doSimulationMap(boolean[][] oldmap){
        boolean[][] newmap=new boolean[input_a][input_b];
        for(int x=0;x<oldmap.length;x++){
            for(int y=0;y<oldmap[0].length;y++){
                int nbs=countaliveNeighbors(oldmap,x,y);
                if(oldmap[x][y]){
                    if(nbs<deathLimit){
                        newmap[x][y]=false;
                    }
                    else{
                        newmap[x][y]=true;
                    }

                }
                else{
                    if(nbs>birthLimit){
                        newmap[x][y]=true;
                    }
                    else {
                        newmap[x][y]=false;
                    }
                }
            }
        }

        return newmap;
    }
    public int countaliveNeighbors(boolean[][] map,int x,int y){
        int count=0;
        for(int i=-1;i<2;i++)
        {
            for(int j=-1;j<2;j++)
            {
                int neighbor_x=x+i;
                int neighbor_y=y+j;
                if(i==0&j==0){
                }
                else if (neighbor_x<0||neighbor_y<0||neighbor_x>=map.length||neighbor_y>=map[0].length){
                    count=count+1;
                }
                else if(map[neighbor_x][neighbor_y]){
                    count=count+1;
                }
            }
        }
        return count;
    }
}
