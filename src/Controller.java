import javax.swing.*;
import java.awt.*;

public class Controller {

    InitialScreen theView;
    Settings theModel;
    public Controller(InitialScreen theView, Settings theModel) {
        this.theView = theView;
        this.theModel = theModel;

    }
    public Controller(InitialScreen theView) {

        this.theView = theView;

    }


    public void controllerStartInitialScreen() {

        theView.initLaunchScreen();
        //controllerStartGame();

    }

    public void controllerStartGame() {

        if (theView.gameParams.getPlayersName().size() == 1) {
            PlayGameWithSingle startGame = new PlayGameWithSingle(theView.gameParams);
            startGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startGame.setBackground(Color.gray);
            startGame.setPreferredSize(new Dimension(600, 600)); //need to use this instead of setSize
            startGame.pack();
            startGame.setVisible(true);
        }


    }

}

