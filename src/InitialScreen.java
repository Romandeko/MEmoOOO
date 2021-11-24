import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.*;
import java.util.List;

public class InitialScreen {

    // initialize class variables/fields.
    private JPanel rulesPanel = new JPanel();
    private JLabel  asd = new JLabel();
    private JPanel diffPanel = new JPanel();
    private JPanel timePanel = new JPanel();
    private JPanel oppPanel = new JPanel();
    private JPanel rowColPanel = new JPanel();
    private JButton buttonPanel = new JButton();
    private JComboBox<String> rowsNew = new JComboBox<String>();
    private JComboBox<String> colsNew = new JComboBox<String>();
    private List<String> playersName = new ArrayList<String>();
    private JFrame frame = new JFrame("MEMO");
    public Settings gameParams = new Settings();


    public static void main(String[] args) {

        //InitialScreen game = new InitialScreen();
        //game.initLaunchScreen();

    }

    // this method displays initial window to receive game parameters.
    // this parameters updates Settings class.
    public void initLaunchScreen() {

        // Add the frame, panel for the initial window.
        JPanel panelAll = new JPanel();
        panelAll.setBackground(Color.BLACK);
        JLabel abs= new JLabel("MEMO");
       abs.setForeground(Color.WHITE);

        // Define as Box Layout
        panelAll.setBorder(new EmptyBorder(5, 5, 5, 5));
        //panelAll.setLayout(new BoxLayout(panelAll,BoxLayout.Y_AXIS));
        panelAll.setLayout(new GridLayout(6, 5, 5, 0));


        // Add Time Info Level Button
        addTimeButton(panelAll);

        // Add Name/Opponent Button
        addOpponentButton(panelAll);

        // Add Size information of the game.
        addRowColumnButton(panelAll);


        // initialize final layer buttons
        buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setEnabled(false);



        // add final layer buttons successively.
        addCardThemeButton(buttonPanel);
        addLeaderBoardButton(buttonPanel);
        addStartButton(buttonPanel);
        addExitButton(buttonPanel);


        // add final layer into whole panel.
        panelAll.add(buttonPanel);


        // Finally, merge all information into one.
        frame.add(panelAll);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    // This is a method to add time information button.
    private void addTimeButton(JPanel panel) {

        // create panel template.
        timePanel.setLayout(new GridLayout(1, 5, 0, 5));
        timePanel.setBackground(Color.BLACK);
        JRadioButton b11 = new JRadioButton("0 sec");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.white);
        JRadioButton b22 = new JRadioButton("10 sec");
        b22.setBackground(Color.BLACK);
        b22.setForeground(Color.white);
        JRadioButton b33 = new JRadioButton("60 sec");
        b33.setForeground(Color.white);
        b33.setBackground(Color.BLACK);
        JRadioButton b44 = new JRadioButton("90 sec");
        b44.setForeground(Color.white);
        b44.setBackground(Color.BLACK);
        JRadioButton b55 = new JRadioButton("120 sec");
        b55.setForeground(Color.white);
        b55.setBackground(Color.BLACK);

        // Add Time information
        ButtonGroup groupTime = new ButtonGroup();
        groupTime.add(b11);
        groupTime.add(b22);
        groupTime.add(b33);
        groupTime.add(b44);
        groupTime.add(b55);

        // Add ActionListeners for each button.
        b11.addActionListener(this::actionPerformedTimeButton);
        b22.addActionListener(this::actionPerformedTimeButton);
        b33.addActionListener(this::actionPerformedTimeButton);
        b44.addActionListener(this::actionPerformedTimeButton);
        b55.addActionListener(this::actionPerformedTimeButton);

        // Create and Add Time Label Information.
        JLabel timeLabel = new JLabel("Time Setting");

        timeLabel.setForeground(Color.WHITE);

        b11.setHorizontalAlignment(SwingConstants.CENTER);
        b22.setHorizontalAlignment(SwingConstants.CENTER);
        b33.setHorizontalAlignment(SwingConstants.CENTER);
        b44.setHorizontalAlignment(SwingConstants.CENTER);
        b55.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // Merge all info inthe the final panel.
        timePanel.add(timeLabel);
        timePanel.add(b11);
        timePanel.add(b22);
        timePanel.add(b33);
        timePanel.add(b44);
        timePanel.add(b55);
        panel.add(timePanel);


    }


    // This is a method to add player number count.
    private void addOpponentButton(JPanel panel) {

        // Add opponent Type
        oppPanel.setLayout(new GridLayout(1, 3, 5, 5));
        oppPanel.setBackground(Color.BLACK);
        oppPanel.setForeground(Color.white);
        JRadioButton button11 = new JRadioButton("Single");
        button11.setBackground(Color.BLACK);
        button11.setForeground(Color.white);
        JRadioButton button21 = new JRadioButton(("Double"));
        button21.setBackground(Color.BLACK);
        button21.setForeground(Color.white);
        JLabel radioLabel1 = new JLabel("Opponent Type");
        radioLabel1.setForeground(Color.white);

        ButtonGroup groupOpp = new ButtonGroup();
        groupOpp.add(button11);
        groupOpp.add(button21);


        // add buttons into action listener.
        button11.addActionListener(this::actionPerformedOpponentButton);
        button21.addActionListener(this::actionPerformedOpponentButton);


        button11.setHorizontalAlignment(SwingConstants.CENTER);
        button21.setHorizontalAlignment(SwingConstants.CENTER);
        radioLabel1.setHorizontalAlignment(SwingConstants.LEFT);

        oppPanel.add(radioLabel1);
        oppPanel.add(button11);
        oppPanel.add(button21);
        panel.add(oppPanel);


    }


    // This is method to add size(col and row) of the game.
    private void addRowColumnButton(JPanel panel) {

        // Add row-col info.
        rowColPanel.setLayout(new GridLayout(1, 4, 5, 5));
        rowColPanel.setBackground(Color.BLACK);
        rowColPanel.setForeground(Color.white);
        //create a new label
        JLabel rowLabel = new JLabel("Number of rows ");
        rowLabel.setBackground(Color.BLACK);
        rowLabel.setForeground(Color.white);
        JLabel colLabel = new JLabel("Number of cols ");

        colLabel.setBackground(Color.BLACK);
        colLabel.setForeground(Color.white);

        //String array to store weekdays
        String[] rows = {
                "2",   "4",  "6"};
        String[] cols = { "2","4", "6",
        };

        // Add rows/col into the array.
        for (String number : rows) {
            rowsNew.addItem(number);
        }

        for (String number : cols) {
            colsNew.addItem(number);
        }

        // initial status is : NOT Selected.
        rowsNew.setSelectedItem(null);
        rowsNew.setBackground(Color.BLACK);
        rowsNew.setForeground(Color.white);
        colsNew.setSelectedItem(null);
        colsNew.setBackground(Color.BLACK);
        colsNew.setForeground(Color.white);

        // add actions for two buttons.
        rowsNew.addActionListener(this::actionPerformedRowColButton);
        colsNew.addActionListener(this::actionPerformedRowColButton);

        // modify locations of buttons.
        rowLabel.setHorizontalAlignment(SwingConstants.LEFT);
        colLabel.setHorizontalAlignment(SwingConstants.CENTER);


        // merge all buttons into the panel.
        rowColPanel.add(rowLabel);
        rowColPanel.add(rowsNew);
        rowColPanel.add(colLabel);
        rowColPanel.add(colsNew);
        panel.add(rowColPanel);


    }


    // This is a method to add CardThem Button in the final layer.
    private void addCardThemeButton(JButton button) {

        // initialize button and add action listener/panel.
        JButton bf0 = new JButton("Card Theme");
        bf0.setBackground(Color.BLACK);
        bf0.setForeground(Color.white);
        bf0.addActionListener(this::actionPerformedCardThemeButton);
        button.add(bf0);

    }




    // add high score board in the initial window.
    private void addLeaderBoardButton(JButton button) {

        // Add High Scores Button and action listener.
        JButton bf2 = new JButton("High Scores");
        bf2.setBackground(Color.BLACK);
        bf2.setForeground(Color.white);
        bf2.addActionListener(this::actionPerformedLeaderBoardButton);
        button.add(bf2);
    }


    // add start button.
    private void addStartButton(JButton button) {

        // add start button and its action.
        JButton bf3 = new JButton("Start");
        bf3.setBackground(Color.BLACK);
        bf3.setForeground(Color.white);
        bf3.addActionListener(this::actionPerformedStartButton);

        button.add(bf3);


    }


    // this button exits the window.
    private void addExitButton(JButton button) {

        // add exit button and its action.
        JButton bf4 = new JButton("Exit");
        bf4.addActionListener(this::actionPerformedExitButton);
        button.add(bf4);

        bf4.setBackground(Color.BLACK);
        bf4.setForeground(Color.white);
    }


    // display the highest score by reading a file.
    private void scoreDisplay() {

        // initialize template of the window.
        String[] titles = {"Names", "Date", "Total Points"};
        String[] names = new String[3];
        String[] dates = new String[3];
        String[] points = new String[3];

        int count = 0;

        try {
            // read txt file that stores highest score in the game.
            Scanner input = new Scanner("./src/highscore.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineArray = line.split(",");
                names[count] = lineArray[0];
                dates[count] = lineArray[1];
                points[count] = lineArray[2];
                count++;

            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // design displayed format in the LeaderBoard Screen. It is simple and understandable.
        StringBuilder rows = new StringBuilder(titles[0] + " | " + titles[1] + " | " + titles[2] + "\n");
        for (int i = 0; i < names.length; i++) {

            rows.append(" ").append(names[i]).append(" | ").append(dates[i]).append(" | ").append(points[i]).append(" ").append("\n");
        }

        // Display Window for points.
        JOptionPane.showMessageDialog(null, rows.toString());


    }

    // add actionListener for Exit Button.
    private void actionPerformedExitButton(ActionEvent e) {
        //Write code here to close the program.
        System.out.println("Program is closed ");
        System.exit(0);
    }

    // add actionListener for Start Button.
    private void actionPerformedStartButton(ActionEvent e) {
        // Write code here to start the program.
        // After parameters are collected, let's initialize game.

        frame.setVisible(false);
        frame.dispose();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // determine size of the game : Single or Multi Player.
        if (gameParams.getPlayersName().size() == 1) {
            PlayGameWithSingle startGame = new PlayGameWithSingle(gameParams);
            // Someone can exit board.
            startGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Set background color.
            startGame.setBackground(Color.gray);
            // Other Board remaining initializations.
            startGame.setPreferredSize(new Dimension(600, 600)); //need to use this instead of setSize
            startGame.pack();
            startGame.setVisible(true);

        } else {

            PlayGameWithMultiple startGame = new PlayGameWithMultiple(gameParams);
            // Someone can exit board.
            startGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Set background color.
            startGame.setBackground(Color.gray);
            // Other Board remaining initializations.
            startGame.setPreferredSize(new Dimension(600, 600)); //need to use this instead of setSize
            startGame.pack();
            startGame.setVisible(true);
        }


    }

    // add actionListener for Start Button.
    private void actionPerformedLeaderBoardButton(ActionEvent e) {
        //call a scoreDisplay method here.:
        scoreDisplay();

    }

    // add actionListener for Background Color Button.
    private void actionPerformedBackColorTypeButton(ActionEvent e) {

        // show possible color options.
        String[] options = new String[]{"White", "Gray", "Yellow", "Blue", "Green"};
        int option = JOptionPane.showOptionDialog(null, "Choose Background", "Option",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options);

        if (option != JOptionPane.CLOSED_OPTION) {
            System.out.println(options[option]);

            try {
                Color backgroundColor = (Color) Color.class.getField(options[option].toLowerCase()).get(null);

                gameParams.setBackColor(backgroundColor);

            } catch (IllegalAccessException | NoSuchFieldException ex) {
                ex.printStackTrace();
            }


        } else {
            System.out.println("No option selected");
        }

    }


    // add actionListener for Background Color Button.
    private void actionPerformedCardThemeButton(ActionEvent e) {
        //declarations:
        String[] options = new String[]{"Gastronomy", "Social Media", "Countries", "Brends"};
        int option = JOptionPane.showOptionDialog(null, "Choose Background", "Option",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options);

        if (option != JOptionPane.CLOSED_OPTION) {
            System.out.println(options[option]);

            // receive selected theme and save it.
            switch (options[option]) {
                case "Gastronomy":
                    System.out.println("Selected Theme : Gastronomy");
                    gameParams.setCardTheme("gastronomy");

                    break;
                case "Social Media":
                    System.out.println("Selected Theme : Social Media");
                    gameParams.setCardTheme("socialmedia");

                    break;
                case "Countries":
                    System.out.println("Selected Theme : Countries");
                    gameParams.setCardTheme("countries");
                    break;

                case "Brends":
                    System.out.println("Selected Theme : Brends");
                    gameParams.setCardTheme("Brends");
                    break;
            }

        } else {
            System.out.println("No option selected");
        }


    }


    // add actionListener for number of row and column buttons.
    private void actionPerformedRowColButton(ActionEvent e) {


        // add actions based on row/column information.

        if (e.getSource() == rowsNew) {
            String s = (String) rowsNew.getSelectedItem();
            assert s != null;
            int s2 = Integer.parseInt(s);
            System.out.println("Row button is selected as : " + s);
            gameParams.setrowId(s2);
        } else if (e.getSource() == colsNew) {

            String s3 = (String) colsNew.getSelectedItem();
            System.out.println("Column button is selected as : " + s3);
            String s33 = (String) colsNew.getSelectedItem();
            assert s33 != null;
            int s4 = Integer.parseInt(s33);
            gameParams.setcolId(s4);
        }


    }


    // add actionListener for opponent type information.
    private void actionPerformedOpponentButton(ActionEvent e) {

        // add playing type buttons as Single/Double.
        AbstractButton aButton = (AbstractButton) e.getSource();
        System.out.println("Selected: " + aButton.getText());
        if (aButton.getText().equals("Single")) {

            String Player1 = JOptionPane.showInputDialog("Please enter your name : ");
            if (Player1 == null) {
                System.out.println("The user canceled");

            } else {
                System.out.println("Entered name : " + Player1);

                //set game Params.
                playersName.add(Player1);
                gameParams.setPlayersName(playersName);
            }


        } else if (aButton.getText().equals("Double")) {

            String Player1 = JOptionPane.showInputDialog("Please enter name for Player 1  : ");
            if (Player1 == null) {
                System.out.println("The user canceled.");

            } else {
                System.out.println("Entered name : " + Player1);
            }

            String Player2 = JOptionPane.showInputDialog("Please enter name for Player 2 : ");
            if (Player1 == null) {
                System.out.println("The user canceled.");

            } else {
                System.out.println("Entered name : " + Player2);
            }

            playersName.add(Player1);
            playersName.add(Player2);
            gameParams.setPlayersName(playersName);
        }
    }


    // add actionListener for opponent type information.
    private void actionPerformedTimeButton(ActionEvent e) {

        // Receive time information and update gameParams object.
        AbstractButton aButton = (AbstractButton) e.getSource();
        System.out.println("Selected: " + aButton.getText());
        String timeText = aButton.getText().replaceAll("[A-Za-z\\s+]", "");
        int intTimeText = Integer.parseInt(timeText);
        gameParams.setTimeInfo(intTimeText);


    }


    private void actionPerformedDiffLevelButton(ActionEvent e) {

        // Receives Difficulty Level information and Updates gameParams object.
        AbstractButton aButton = (AbstractButton) e.getSource();
        System.out.println("Selected: " + aButton.getText());


    }


}





