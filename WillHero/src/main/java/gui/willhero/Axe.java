package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.security.Key;

public class Axe extends Weapons{

    private Node axe;
    private int level;
    private Node orcNode;
    private  Node area;

    private Timeline staywOrc = new Timeline();
    private Timeline collision = new Timeline();

    Axe(Node axe, Node orc, Node area){
        super("Axe", 10);
        level = 1;
        this.axe = axe;
        this.orcNode = orc;
        this.area = area;

        KeyFrame attach = new KeyFrame(Duration.millis(1), actionEvent -> {
            axe.setLayoutX(orcNode.getLayoutX() + 11);
            axe.setLayoutY(orcNode.getLayoutY() - 10);
            area.setLayoutX(axe.getLayoutX() - 27);
            area.setLayoutY(axe.getLayoutY() - 12);
        });
        staywOrc.getKeyFrames().add(attach);
        staywOrc.setCycleCount(Timeline.INDEFINITE);
        staywOrc.play();

        KeyFrame col = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(area.getBoundsInParent().intersects(getCurPlayer().getNode().getBoundsInParent())){
                use();
            }
        });

        collision.getKeyFrames().add(col);
        collision.setCycleCount(Timeline.INDEFINITE);
        collision.play();


    }

    @Override
    public void use() {
        animations.rotateWeapon((ImageView) axe, -150);
        Timeline attack = new Timeline();
        KeyFrame kf = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(axe.getBoundsInParent().intersects(getCurPlayer().getNode().getBoundsInParent())){
                getCurPlayer().setHealth(1);
                attack.stop();
            }
        });
        attack.getKeyFrames().add(kf);
        attack.setCycleCount(Timeline.INDEFINITE);
        attack.play();
    }

    @Override
    public void toggle() {

    }

    @Override
    public Node getImg() {
        return axe;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
