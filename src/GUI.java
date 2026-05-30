import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

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
    JButton Building1Button;
    JButton Building2Button;
    JButton Building3Button;
    JButton Building4Button;
    JButton Building5Button;
    JButton Building6Button;
    JButton Building7Button;
    JButton Building8Button;
    JButton Building9Button;
    JButton Building10Button;
    JButton Building11Button;
    JButton Building12Button;
    JButton Building13Button;
    JButton Building14Button;
    JButton Building15Button;
    JButton Building16Button;
    JButton Building17Button;
    JButton Building18Button;
    JButton Building19Button;
    JButton Building20Button;

    //Panels
    JPanel MegaPanel = new JPanel();
    JPanel UpgradesBuildings;
    JPanel OptionsPanel;
    JPanel CookiePanel;
    JPanel BuildingPanel;
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
            AutoPWR.setText("CPS: " + BuildingLogic.getCookiesPerSecond());
            Building1Button.setText("Upgrade (+0.5 CPS) | Cost: "+ BuildingLogic.getBuilding1Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding1Purchases());
            Building2Button.setText("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getBuilding2Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding2Purchases());
            if(BuildingLogic.getCookiesPerSecond().compareTo(BigDecimal.valueOf(0))>0&&!CookiesOn){
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
                        try {
                            GameLogic.SaveToFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }else{
                try {
                    GameLogic.SaveToFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
                    try {
                        GameLogic.LoadFromFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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
        Building1Button = new JButton("Upgrade (+0.5 CPS) | Cost: "+ BuildingLogic.getBuilding1Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding1Purchases());
        Building1Button.addActionListener(_ -> {
            if(BuildingLogic.buyUpgrade1()){
                Building1Button.setText("Upgrade (+0.5 CPS) | Cost: "+ BuildingLogic.getBuilding1Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding1Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding1Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE); //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            }
        });
        Building2Button = new JButton("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getBuilding2Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding2Purchases());
        Building2Button.addActionListener(_ -> {
            if(BuildingLogic.buyUpgrade2()){
                Building2Button.setText("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getBuilding2Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding2Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding2Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building3Button = new JButton("Upgrade (+8 CPS) | Cost: "+ BuildingLogic.getBuilding3Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding3Purchases());
        Building3Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding3()){
                Building3Button.setText("Upgrade (+8 CPS) | Cost: "+ BuildingLogic.getBuilding3Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding3Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding3Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building4Button = new JButton("Upgrade (+47 CPS) | Cost: "+ BuildingLogic.getBuilding4Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding4Purchases());
        Building4Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding4()){
                Building4Button.setText("Upgrade (+47 CPS) | Cost: "+ BuildingLogic.getBuilding4Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding4Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding4Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building5Button = new JButton("Upgrade (+260 CPS) | Cost: "+ BuildingLogic.getBuilding5Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding5Purchases());
        Building5Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding5()){
                Building5Button.setText("Upgrade (+260 CPS) | Cost: "+ BuildingLogic.getBuilding5Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding5Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding5Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building6Button = new JButton("Upgrade (+1400 CPS) | Cost: "+ BuildingLogic.getBuilding6Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding6Purchases());
        Building6Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding6()){
                Building6Button.setText("Upgrade (+1400 CPS) | Cost: "+ BuildingLogic.getBuilding6Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding6Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding6Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building7Button = new JButton("Upgrade (+7800 CPS) | Cost: "+ BuildingLogic.getBuilding7Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding7Purchases());
        Building7Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding7()){
                Building7Button.setText("Upgrade (+7800 CPS) | Cost: "+ BuildingLogic.getBuilding7Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding7Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding7Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building8Button = new JButton("Upgrade (+44000 CPS) | Cost: "+ BuildingLogic.getBuilding8Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding8Purchases());
        Building8Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding7()){
                Building8Button.setText("Upgrade (+44000 CPS) | Cost: "+ BuildingLogic.getBuilding8Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding8Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding8Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building9Button = new JButton("Upgrade (+260000 CPS) | Cost: "+ BuildingLogic.getBuilding9Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding9Purchases());
        Building9Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding9()){
                Building9Button.setText("Upgrade (+260000 CPS) | Cost: "+ BuildingLogic.getBuilding9Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding9Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding9Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building10Button = new JButton("Upgrade (+1600000 CPS) | Cost: "+ BuildingLogic.getBuilding10Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding10Purchases());
        Building10Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding10()){
                Building10Button.setText("Upgrade (+1600000 CPS) | Cost: "+ BuildingLogic.getBuilding10Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding10Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding10Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building11Button = new JButton("Upgrade (+10000000 CPS) | Cost: "+ BuildingLogic.getBuilding11Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding11Purchases());
        Building11Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding11()){
                Building11Button.setText("Upgrade (+10000000 CPS) | Cost: "+ BuildingLogic.getBuilding11Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding11Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding11Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building12Button = new JButton("Upgrade (+65000000 CPS) | Cost: "+ BuildingLogic.getBuilding12Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding12Purchases());
        Building12Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding12()){
                Building12Button.setText("Upgrade (+65000000 CPS) | Cost: "+ BuildingLogic.getBuilding12Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding12Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding12Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building13Button = new JButton("Upgrade (+430000000 CPS) | Cost: "+ BuildingLogic.getBuilding13Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding13Purchases());
        Building13Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding13()){
                Building13Button.setText("Upgrade (+430000000 CPS) | Cost: "+ BuildingLogic.getBuilding13Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding13Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding13Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building14Button = new JButton("Upgrade (+2900000000 CPS) | Cost: "+ BuildingLogic.getBuilding14Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding14Purchases());
        Building14Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding14()){
                Building14Button.setText("Upgrade (+2900000000 CPS) | Cost: "+ BuildingLogic.getBuilding14Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding14Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding14Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building15Button = new JButton("Upgrade (+21000000000 CPS) | Cost: "+ BuildingLogic.getBuilding15Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding15Purchases());
        Building15Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding15()){
                Building15Button.setText("Upgrade (+21000000000 CPS) | Cost: "+ BuildingLogic.getBuilding15Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding15Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding15Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building16Button = new JButton("Upgrade (+150000000000 CPS) | Cost: "+ BuildingLogic.getBuilding16Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding16Purchases());
        Building16Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding16()){
                Building15Button.setText("Upgrade (+150000000000 CPS) | Cost: "+ BuildingLogic.getBuilding16Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding16Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding16Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building17Button = new JButton("Upgrade (+1100000000000 CPS) | Cost: "+ BuildingLogic.getBuilding17Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding17Purchases());
        Building17Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding17()){
                Building17Button.setText("Upgrade (+1100000000000 CPS) | Cost: "+ BuildingLogic.getBuilding17Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding17Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding17Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building18Button = new JButton("Upgrade (+8300000000000 CPS) | Cost: "+ BuildingLogic.getBuilding18Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding18Purchases());
        Building18Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding18()){
                Building18Button.setText("Upgrade (+8300000000000 CPS) | Cost: "+ BuildingLogic.getBuilding18Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding18Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding18Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building19Button = new JButton("Upgrade (+64000000000000 CPS) | Cost: "+ BuildingLogic.getBuilding19Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding19Purchases());
        Building19Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding19()){
                Building19Button.setText("Upgrade (+64000000000000 CPS) | Cost: "+ BuildingLogic.getBuilding19Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding19Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding19Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        Building20Button = new JButton("Upgrade (+500000000000000 CPS) | Cost: "+ BuildingLogic.getBuilding20Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding20Purchases());
        Building20Button.addActionListener(_ -> {
            if(BuildingLogic.buyBuilding20()){
                Building20Button.setText("Upgrade (+500000000000000 CPS) | Cost: "+ BuildingLogic.getBuilding20Cost()+" Cookies | Owned: "+ BuildingLogic.getBuilding20Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBuilding20Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });


        //Frame Creation
        frame = new JFrame("COOKIE CRASH!");

        //Label Creation
        CurrentCookies = new JLabel("Cookies: "+ BuildingLogic.getCookieCount());
        ClickPWR = new JLabel("CPC: "+ BuildingLogic.getCookiesPerClick());
        AutoPWR = new JLabel("CPS: " + BuildingLogic.getCookiesPerSecond());

        //Panel Creation
        UpgradesBuildings = new JPanel();
        OptionsPanel = new JPanel();
        CookiePanel = new JPanel();
        BuildingPanel = new JPanel();
        BuildingPanel.setLayout(new GridLayout(20,0));
        StatsPanel = new JPanel();
        MegaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MegaPanel.setLayout(new BorderLayout());

        //Panel Colors
        MegaPanel.setBackground(myColor);
        StatsPanel.setBackground(myColor);
        CookiePanel.setBackground(myColor);
        BuildingPanel.setBackground(myColor);
        OptionsPanel.setBackground(myColor);
        UpgradesBuildings.setBackground(myColor);

        //Panel Packing
        OptionsPanel.add(SaveGameButton);
        OptionsPanel.add(LoadGameButton);
        CookiePanel.add(cookieButton);
        BuildingPanel.add(Building1Button);
        BuildingPanel.add(Building2Button);
        BuildingPanel.add(Building3Button);
        BuildingPanel.add(Building4Button);
        BuildingPanel.add(Building5Button);
        BuildingPanel.add(Building6Button);
        BuildingPanel.add(Building7Button);
        BuildingPanel.add(Building8Button);
        BuildingPanel.add(Building9Button);
        BuildingPanel.add(Building10Button);
        BuildingPanel.add(Building11Button);
        BuildingPanel.add(Building12Button);
        BuildingPanel.add(Building13Button);
        BuildingPanel.add(Building14Button);
        BuildingPanel.add(Building15Button);
        BuildingPanel.add(Building16Button);
        BuildingPanel.add(Building17Button);
        BuildingPanel.add(Building18Button);
        BuildingPanel.add(Building19Button);
        BuildingPanel.add(Building20Button);
        UpgradesBuildings.add(BuildingPanel, BorderLayout.SOUTH);
        StatsPanel.add(CurrentCookies);
        StatsPanel.add(ClickPWR);
        StatsPanel.add(AutoPWR);
        MegaPanel.add(StatsPanel, BorderLayout.NORTH);
        MegaPanel.add(CookiePanel, BorderLayout.CENTER);

        //Frame Packing
        frame.add(MegaPanel, BorderLayout.CENTER);
        frame.add(OptionsPanel, BorderLayout.NORTH);
        frame.add(UpgradesBuildings, BorderLayout.EAST);
        frame.setIconImage(Nummie.getImage());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}