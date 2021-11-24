// This class initializes game.

public class MainGame {

    public static void main(String[] args) {
        InitialScreen theView = new InitialScreen();
        Controller theController = new Controller(theView);
        theController.controllerStartInitialScreen();
    }
}
