import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI implements ActionListener {

    //Timer Stuff
    Timer updateTimer;
    ActionListener guiUpdate;

    //GUI Stuff
    Color myColor = new Color(99, 208, 168);
    JFrame frame;

    //Logic Stuff
    Buildings BuildingLogic = new Buildings();
    Logic GameLogic = new Logic(BuildingLogic);
    File save = new File("save.txt");
    boolean CookiesOn=false;


    //Buttons
    JButton SaveGameButton;
    JButton LoadGameButton;
    JButton cookieButton;
    JButton Upgrade1Button;
    JButton Upgrade2Button;

    //Panels
    JPanel MegaPanel = new JPanel();
    JPanel OptionsPanel;
    JPanel CookiePanel;
    JPanel UpgradesPanel;
    JPanel StatsPanel;

    //Labels
    JLabel CurrentCookies;
    JLabel ClickPWR;
    JLabel AutoPWR;

    //Image Imports
    ImageIcon Nummie = new ImageIcon("src/PerfectCookie.png");
    ImageIcon AreYouSure = new ImageIcon("src/AreYouSure.jpg");


    public GUI() {

        //Refresh Timer Creation
        guiUpdate = _ -> {
            ClickPWR.setText("CPC: "+ BuildingLogic.getCookiesPerClick());
            CurrentCookies.setText("Cookies: "+ BuildingLogic.getCookieCount());
            AutoPWR.setText("CPS: " + BuildingLogic.getAutoCookies());
            if(BuildingLogic.getAutoCookies()>0&&!CookiesOn){
                BuildingLogic.AutoTimer();
                CookiesOn=true;
            }
        };
        updateTimer = new Timer(500,guiUpdate);
        updateTimer.start();

        //Save/Load Button Creation
        SaveGameButton = new JButton("Save Game");
        Object[] SaveOptions = {"Yes, please",
                "No, thanks",};
        SaveGameButton.addActionListener(_ ->{
            int SaveChoice=JOptionPane.showOptionDialog(frame,
                    "Would you like to save your current game data?",
                    "Save Game?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    SaveOptions,
                    SaveOptions[0]);

            if(save.exists()){  //Source: https://www.w3schools.com/java/java_files.asp
                if(SaveChoice==JOptionPane.YES_OPTION) {
                    Object[] ConfirmOptions = {"Pretty Sure",
                            "I take It Back",};
                    int OverwriteCheck = JOptionPane.showOptionDialog(frame,
                            "Are you sure you want to save?" +"\n"+
                                    "This will overwrite your current save.",
                            "Overwrite Save?",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            AreYouSure,
                            ConfirmOptions,
                            ConfirmOptions[0]);

                    if (OverwriteCheck == JOptionPane.YES_OPTION) {
                        GameLogic.SaveToFile();
                    }
                }
            }else{
                GameLogic.SaveToFile();
            }
        });

        LoadGameButton = new JButton("Load Game");
        Object[] LoadOptions = {"Yes, please",
                "No, thanks",};
        LoadGameButton.addActionListener(_ ->{
            int LoadSelection = JOptionPane.showOptionDialog(frame,
                    "Would you like to load your previous game data?",
                    "Load Game?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    LoadOptions,
                    LoadOptions[0]);

            if (LoadSelection==JOptionPane.YES_OPTION){
                if(save.exists()){
                    GameLogic.LoadFromFile();
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "No save file found!",
                            "No Save File",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Cookie Button Creation & Modification
        cookieButton = new JButton(Nummie);
        cookieButton.setBorderPainted(false);
        cookieButton.setContentAreaFilled(false);
        cookieButton.setOpaque(false);
        cookieButton.setPreferredSize(new Dimension(512,512));
        cookieButton.addActionListener(_ -> {
            BuildingLogic.Click();
            CurrentCookies.setText("Cookies: "+ BuildingLogic.getCookieCount());
        });

        //Upgrade Buttons
        Upgrade1Button = new JButton("Upgrade (+1 CPC) | Cost: "+ BuildingLogic.getBuilding1Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding1Purchases());
        Upgrade1Button.addActionListener(_ -> {
            if(BuildingLogic.buyUpgrade1()){
                Upgrade1Button.setText("Upgrade (+1 CPC) | Cost: "+ BuildingLogic.getBuilding1Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding1Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding1Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE); //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            }
        });
        Upgrade2Button = new JButton("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getBuilding2Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding2Purchases());
        Upgrade2Button.addActionListener(_ -> {
            if(BuildingLogic.buyUpgrade2()){
                Upgrade2Button.setText("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getBuilding2Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding2Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding2Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        //Frame Creation
        frame = new JFrame("COOKIE CRASH!");

        //Label Creation
        CurrentCookies = new JLabel("Cookies: "+ BuildingLogic.getCookieCount());
        ClickPWR = new JLabel("CPC: "+ BuildingLogic.getCookiesPerClick());
        AutoPWR = new JLabel("CPS: " + BuildingLogic.getAutoCookies());

        //Panel Creation
        OptionsPanel = new JPanel();
        CookiePanel = new JPanel();
        UpgradesPanel = new JPanel();
        StatsPanel = new JPanel();
        MegaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MegaPanel.setLayout(new BorderLayout());

        //Panel Colors
        MegaPanel.setBackground(myColor);
        StatsPanel.setBackground(myColor);
        CookiePanel.setBackground(myColor);
        UpgradesPanel.setBackground(myColor);
        OptionsPanel.setBackground(myColor);

        //Panel Packing
        OptionsPanel.add(SaveGameButton);
        OptionsPanel.add(LoadGameButton);
        CookiePanel.add(cookieButton);
        UpgradesPanel.add(Upgrade1Button);
        UpgradesPanel.add(Upgrade2Button);
        StatsPanel.add(CurrentCookies);
        StatsPanel.add(ClickPWR);
        StatsPanel.add(AutoPWR);
        MegaPanel.add(StatsPanel, BorderLayout.NORTH);
        MegaPanel.add(CookiePanel, BorderLayout.CENTER);

        //Frame Packing
        frame.add(MegaPanel, BorderLayout.CENTER);
        frame.add(OptionsPanel, BorderLayout.NORTH);
        frame.add(UpgradesPanel, BorderLayout.EAST);
        frame.setIconImage(Nummie.getImage());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}