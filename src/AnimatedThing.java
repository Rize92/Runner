import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

abstract class AnimatedThing {
    static double X, Y;
    private static ImageView sprite;
    private Integer action;
    private static int temps,frame, sizeX, sizeY, index, offset, indexMax,position,jumpEnd,position2;
    private static double a=5,b=0;

    public static void setTemps(){
        temps++;
    };
    public static void setX(int a){X=X+a;}
    public static double getX() {
        return X;
    }
    public double getY() {
        return Y;
    }



    public AnimatedThing(String Filename, double X, double Y, int index, int offset, int sizeX,int sizeY,int sizeImageX,int sizeImageY) {
        this.X = X;
        this.Y = Y;
        this.index = index;
        this.indexMax = indexMax;
        this.sizeX = sizeX;
        Image spriteSheet = new Image(Filename);

        sprite = new ImageView(spriteSheet);
        sprite.setFitHeight(sizeImageX);
        sprite.setFitWidth(sizeImageY);
        //sprite.setPreserveRatio(true);
        sprite.setViewport(new Rectangle2D(index, offset, sizeX, sizeY));
        sprite.setX(X);
        sprite.setY(Y);
    }

    public static ImageView getImage() {
        return sprite;
    }

    public static void update(long time) {

        if(temps%8==0) {

            if (position== 5) {index = 20;position=0;offset=0;}
            if (position == 4) {index = 425;position=5;offset=0;}
            if (position == 3) {index = 350;position=4;offset=0;}
            if (position == 2) {index = 270;position=3;offset=0;}

            if (position == 1) {index = 175;position=2;offset=0;}
            if (position == 0){ index = 90;position=1;offset=0;}

            Rectangle2D viewportRect = new Rectangle2D(index, offset, 75, 100);
            sprite.setX(X);
            sprite.setY(Y);
            sprite.setViewport(viewportRect);

        }

    }
    public static void jump(){
        if(Y<100){Y=100;}
        if(Y>=100 && jumpEnd==0){

            if(Y==100)jumpEnd=1;
            b=0;
            a=a-0.07;
            Y = Y - a;
            Rectangle2D viewportRect = new Rectangle2D(20, 160, 75, 100);
            sprite.setY(Y);
            sprite.setViewport(viewportRect);
        }

       if(Y>250){Y=250;}

        if(Y<=250 && jumpEnd==1){

            if(Y==250){jumpEnd=0;GameScene.jump=0;}
            a=5;
            b=b+0.1;
            Y=Y+b;
            Rectangle2D viewportRect = new Rectangle2D(90, 160, 75, 100);
            sprite.setY(Y);
            sprite.setViewport(viewportRect);
        }

        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println(Y);


    }
    public static void RunSpike(){
        X=X-2;
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 75, 100);
        sprite.setX(Spike.X);
        sprite.setViewport(viewportRect);
    }
}


