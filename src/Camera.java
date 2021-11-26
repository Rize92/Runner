public class Camera {
    private int X, Y;


    public void Camera(int X,int Y) {
        this.X=X;
        this.Y=Y;

    }

    @Override
    public String toString(){
        return "X="+X+" et Y="+Y ;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public static void update(long time){

    }

}