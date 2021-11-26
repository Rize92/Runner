import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;

public class staticThing {
    private static double X,Y;
    private ImageView sprite;



    public static void setX(double a){
        X=X-a;
        if(X<0)X=800;
    }

    public staticThing(double X, double Y, String FileName,int Height,int Width) {

        Image spriteSheet = new Image(FileName);
        sprite = new ImageView(spriteSheet);

        this.X=X;
        this.Y=Y;
        sprite.setX(X);
        sprite.setY(Y);
        sprite.setFitHeight(Height);
        sprite.setFitWidth(Width);
        sprite.setPreserveRatio(true);

    }

    public ImageView getImage() {
        return sprite;
    }

    public double getX() {
        return X;
    }
    public double getY() {
        return Y;
    }
}
