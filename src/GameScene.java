import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;


public class GameScene extends Scene{

static Pane pane;
static staticThing left =new staticThing(0,0,"C:\\ridha\\S7\\java\\image\\desert.png",1600,800);
static staticThing right =new staticThing(800,0,"C:\\ridha\\S7\\java\\image\\desert.png",1600,800);
static staticThing spike =new staticThing(0,0,"C:\\ridha\\S7\\java\\image\\Spikes-PNG-Photo.png",64,66);
static double X,Y;
static Hero Hero;
static Spike Spike;
public static int jump;


    public GameScene(Pane pane, int X ,int Y) {
        super(pane,X,Y,true);
        GameScene.X = X;
        GameScene.Y = Y;
        GameScene.pane = pane;
        GameScene.pane.getChildren().add(left.getImage());//mettre l'imageView dans pane (la fenêtre)
        GameScene.pane.getChildren().add(right.getImage());
        //GameScene.pane.getChildren().add(spike.getImage());



        Spike=new Spike();
        GameScene.pane.getChildren().add(Spike.getImage());

        Hero =new Hero();
        GameScene.pane.getChildren().add(Hero.getImage());






        this.pane.setOnMouseClicked(event -> {
            jump=1;
            System.out.println("Jump");
        });


        timer.start();

    }

    AnimationTimer timer =new AnimationTimer() {

        public void handle(long time) {
            Hero.update(time);
            Hero.setTemps();
            Camera.update(time);
            GameScene.update(time);

           if(jump==1) {
                    Hero.jump();
            }
        }
    };
    public static void update(long time) {
/*
        spike.setX(2);
        //System.out.println("Xr" + right.getX());
        Rectangle2D viewportRect3 = new Rectangle2D(0, 0,800 , 400);
        spike.getImage().setX(spike.getX());
        spike.getImage().setY(spike.getY());
        spike.getImage().setViewport(viewportRect3);

 */



        left.setX(2);
        //System.out.println("Xl" + left.getX());
        Rectangle2D viewportRect = new Rectangle2D(0, 0, 800, 400);
        left.getImage().setX(left.getX());
        left.getImage().setY(left.getY());
        left.getImage().setViewport(viewportRect);

        right.setX(2);
        //System.out.println("Xr" + right.getX());
        Rectangle2D viewportRect2 = new Rectangle2D(0, 0, 800, 400);
        right.getImage().setX(right.getX()-798);
        right.getImage().setY(right.getY());
        right.getImage().setViewport(viewportRect2);




        //Spike.RunSpike();

    }


}