package gui.willhero;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sword extends Weapons{

    private transient Node img;
    private static final long serialVersionUID = 11;

    Sword(Node sword){
        super("Sword", 1);
        this.img = sword;

    }

    public void update(){
        super.update();
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }

    @Override
    public void use(){
        animations.rotateWeapon((ImageView) img, 170);
    }

    @Override
    public void toggle(){
        System.out.println(img.getId());
        animations.toggleOpacity((ImageView) this.img);
    }

    public void showSelected(){
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), img);
        st.setByX(0.75);
        st.setByY(0.75);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }

    @Override
    public Node getImg(){
        return this.img;
    }
}

