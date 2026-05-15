import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI implements ActionListener {
    File save = new File("save.txt");
    Timer updateTimer;
    Timer CPSTimer;
    ActionListener guiUpdate;
    ActionListener CPSTimerUpdate;
    Cookies logic = new Cookies();
    Color myColor = new Color(99, 208, 168);
    JFrame frame;
    JButton SaveGameButton;
    JButton LoadGameButton;
    JButton cookieButton;
    JButton Upgrade1Button;
    JButton Upgrade2Button;
    JPanel MegaPanel = new JPanel();
    JPanel OptionsPanel;
    JPanel CookiePanel;
    JPanel UpgradesPanel;
    JPanel StatsPanel;
    JLabel CurrentCookies;
    JLabel ClickPWR;
    JLabel AutoPWR;

    ImageIcon Nummie = new ImageIcon("src/PerfectCookie.png");


    public GUI() {

        //Refresh Timer Creation
        guiUpdate = _ -> {
            ClickPWR.setText("CPC: "+logic.getCookiesPerClick());
            CurrentCookies.setText("Cookies: "+logic.getCookieCount());
            AutoPWR.setText("CPS: " +logic.getAutoCookies());
            if(logic.getAutoCookies()>0){
                CPSTimer.start();
            }
        };
        updateTimer = new Timer(500,guiUpdate);
        updateTimer.start();

        //Cookiespersecond Timer Creation
        CPSTimerUpdate = _ -> logic.AutoClick();
        CPSTimer = new Timer(1000,CPSTimerUpdate);


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
                        int AreYouSure = JOptionPane.showOptionDialog(frame,
                                "Would you like to overwrite your previous save?",
                                "Overwrite Save?",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                ConfirmOptions,
                                ConfirmOptions[0]);

                        if (AreYouSure == JOptionPane.YES_OPTION) {
                            logic.SaveToFile();
                        }
                    }
                    }else{
                logic.SaveToFile();
            }
        });

        LoadGameButton = new JButton("Load Game");
        Object[] LoadOptions = {"Yes, please",
                "No, thanks",};
        LoadGameButton.addActionListener(_ -> JOptionPane.showOptionDialog(frame,
                "Would you like to load your previous game data?",
                "Load Game?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                LoadOptions,
                LoadOptions[0]));

        //Cookie Button Creation & Modification
        cookieButton = new JButton(Nummie);
        cookieButton.setBorderPainted(false);
        cookieButton.setContentAreaFilled(false);
        cookieButton.setOpaque(false);
        cookieButton.setPreferredSize(new Dimension(512,512));
        cookieButton.addActionListener(_ -> {
            logic.Click();
            CurrentCookies.setText("Cookies: "+logic.getCookieCount());
        });

        //Upgrade Buttons
        Upgrade1Button = new JButton("Upgrade (+1 CPC) | Cost: "+logic.getUpgrade1Cost()+" Cookies | Owned: "+logic.getUpgrade1Purchases());
        Upgrade1Button.addActionListener(_ -> {
            if(logic.buyUpgrade1()){
                Upgrade1Button.setText("Upgrade (+1 CPC) | Cost: "+logic.getUpgrade1Cost()+" Cookies | Owned: "+logic.getUpgrade1Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + logic.getUpgrade1Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE); //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            }
        });
        Upgrade2Button = new JButton("Upgrade (+1 CPS) | Cost: "+logic.getUpgrade2Cost()+" Cookies | Owned: "+logic.getUpgrade2Purchases());
        Upgrade2Button.addActionListener(_ -> {
            if(logic.buyUpgrade2()){
                Upgrade2Button.setText("Upgrade (+1 CPS) | Cost: "+logic.getUpgrade2Cost()+" Cookies | Owned: "+logic.getUpgrade2Purchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + logic.getUpgrade2Cost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        //Frame Creation
        frame = new JFrame("COOKIE CRASH!");

        //Label Creation
        CurrentCookies = new JLabel("Cookies: "+logic.getCookieCount());
        ClickPWR = new JLabel("CPC: "+logic.getCookiesPerClick());
        AutoPWR = new JLabel("CPS: " +logic.getAutoCookies());

        //Panel Creation
        OptionsPanel = new JPanel();
        CookiePanel = new JPanel();
        UpgradesPanel = new JPanel();
        StatsPanel = new JPanel();
        MegaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        MegaPanel.add(StatsPanel);
        MegaPanel.add(CookiePanel);

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