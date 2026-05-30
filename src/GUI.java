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
    JButton CursorButton;
    JButton GrandmaButton;
    JButton FarmButton;
    JButton MineButton;
    JButton FactoryButton;
    JButton BankButton;
    JButton TempleButton;
    JButton WizardTowerButton;
    JButton ShipmentButton;
    JButton AlchemyLabButton;
    JButton PortalButton;
    JButton TimeMachineButton;
    JButton AntimatterCondenserButton;
    JButton PrismButton;
    JButton ChancemakerButton;
    JButton FractalEngineButton;
    JButton JavaConsoleButton;
    JButton IdleverseButton;
    JButton CortexBakerButton;
    JButton YouButton;

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
            CursorButton.setText("Upgrade (+0.5 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
            GrandmaButton.setText("Upgrade (+1 CPS) | Cost: "+ BuildingLogic.getGrandmaCost()+" Cookies | Owned: "+ BuildingLogic.getGrandmaPurchases());
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
        CursorButton = new JButton("Cursor (+0.5 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
        CursorButton.addActionListener(_ -> {
            if(BuildingLogic.buyCursor()){
                CursorButton.setText("Cursor (+0.5 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getCursorCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE); //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            }
        });
        GrandmaButton = new JButton("Grandma (+1 CPS) | Cost: "+ BuildingLogic.getGrandmaCost()+" Cookies | Owned: "+ BuildingLogic.getGrandmaPurchases());
        GrandmaButton.addActionListener(_ -> {
            if(BuildingLogic.buyGrandma()){
                GrandmaButton.setText("Grandma (+1 CPS) | Cost: "+ BuildingLogic.getGrandmaCost()+" Cookies | Owned: "+ BuildingLogic.getGrandmaPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getGrandmaCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        FarmButton = new JButton("Farm (+8 CPS) | Cost: "+ BuildingLogic.getFarmCost()+" Cookies | Owned: "+ BuildingLogic.getFarmPurchases());
        FarmButton.addActionListener(_ -> {
            if(BuildingLogic.buyFarm()){
                FarmButton.setText("Farm (+8 CPS) | Cost: "+ BuildingLogic.getFarmCost()+" Cookies | Owned: "+ BuildingLogic.getFarmPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getFarmCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        MineButton = new JButton("Mine (+47 CPS) | Cost: "+ BuildingLogic.getMineCost()+" Cookies | Owned: "+ BuildingLogic.getMinePurchases());
        MineButton.addActionListener(_ -> {
            if(BuildingLogic.buyMine()){
                MineButton.setText("Mine (+47 CPS) | Cost: "+ BuildingLogic.getMineCost()+" Cookies | Owned: "+ BuildingLogic.getMinePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getMineCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        FactoryButton = new JButton("Factory (+260 CPS) | Cost: "+ BuildingLogic.getFactoryCost()+" Cookies | Owned: "+ BuildingLogic.getFactoryPurchases());
        FactoryButton.addActionListener(_ -> {
            if(BuildingLogic.buyFactory()){
                FactoryButton.setText("Factory (+260 CPS) | Cost: "+ BuildingLogic.getFactoryCost()+" Cookies | Owned: "+ BuildingLogic.getFactoryPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getFactoryCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        BankButton = new JButton("Bank (+1400 CPS) | Cost: "+ BuildingLogic.getBankCost()+" Cookies | Owned: "+ BuildingLogic.getBankPurchases());
        BankButton.addActionListener(_ -> {
            if(BuildingLogic.buyBank()){
                BankButton.setText("Bank (+1400 CPS) | Cost: "+ BuildingLogic.getBankCost()+" Cookies | Owned: "+ BuildingLogic.getBankPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getBankCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        TempleButton = new JButton("Temple (+7800 CPS) | Cost: "+ BuildingLogic.getTempleCost()+" Cookies | Owned: "+ BuildingLogic.getTemplePurchases());
        TempleButton.addActionListener(_ -> {
            if(BuildingLogic.buyTemple()){
                TempleButton.setText("Temple (+7800 CPS) | Cost: "+ BuildingLogic.getTempleCost()+" Cookies | Owned: "+ BuildingLogic.getTemplePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getTempleCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        WizardTowerButton = new JButton("Wizard Tower (+44000 CPS) | Cost: "+ BuildingLogic.getWizardTowerCost()+" Cookies | Owned: "+ BuildingLogic.getWizardTowerPurchases());
        WizardTowerButton.addActionListener(_ -> {
            if(BuildingLogic.buyWizardTower()){
                WizardTowerButton.setText("Wizard Tower (+44000 CPS) | Cost: "+ BuildingLogic.getWizardTowerCost()+" Cookies | Owned: "+ BuildingLogic.getWizardTowerPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getWizardTowerCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        ShipmentButton = new JButton("Shipment (+260000 CPS) | Cost: "+ BuildingLogic.getShipmentCost()+" Cookies | Owned: "+ BuildingLogic.getShipmentPurchases());
        ShipmentButton.addActionListener(_ -> {
            if(BuildingLogic.buyShipment()){
                ShipmentButton.setText("Shipment (+260000 CPS) | Cost: "+ BuildingLogic.getShipmentCost()+" Cookies | Owned: "+ BuildingLogic.getShipmentPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getShipmentCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        AlchemyLabButton = new JButton("Alchemy Lab (+1600000 CPS) | Cost: "+ BuildingLogic.getAlchemyLabCost()+" Cookies | Owned: "+ BuildingLogic.getAlchemyLabPurchases());
        AlchemyLabButton.addActionListener(_ -> {
            if(BuildingLogic.buyAlchemyLab()){
                AlchemyLabButton.setText("Alchemy Lab (+1600000 CPS) | Cost: "+ BuildingLogic.getAlchemyLabCost()+" Cookies | Owned: "+ BuildingLogic.getAlchemyLabPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getAlchemyLabCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        PortalButton = new JButton("Portal (+10000000 CPS) | Cost: "+ BuildingLogic.getPortalCost()+" Cookies | Owned: "+ BuildingLogic.getPortalPurchases());
        PortalButton.addActionListener(_ -> {
            if(BuildingLogic.buyPortal()){
                PortalButton.setText("Portal (+10000000 CPS) | Cost: "+ BuildingLogic.getPortalCost()+" Cookies | Owned: "+ BuildingLogic.getPortalPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getPortalCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        TimeMachineButton = new JButton("Time Machine (+65000000 CPS) | Cost: "+ BuildingLogic.getTimeMachineCost()+" Cookies | Owned: "+ BuildingLogic.getTimeMachinePurchases());
        TimeMachineButton.addActionListener(_ -> {
            if(BuildingLogic.buyTimeMachine()){
                TimeMachineButton.setText("Time Machine (+65000000 CPS) | Cost: "+ BuildingLogic.getTimeMachineCost()+" Cookies | Owned: "+ BuildingLogic.getTimeMachinePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getTimeMachineCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        AntimatterCondenserButton = new JButton("Antimatter Condenser (+430000000 CPS) | Cost: "+ BuildingLogic.getAntimatterCondenserCost()+" Cookies | Owned: "+ BuildingLogic.getAntimatterCondenserPurchases());
        AntimatterCondenserButton.addActionListener(_ -> {
            if(BuildingLogic.buyAntimatterCondenser()){
                AntimatterCondenserButton.setText("Antimatter Condenser (+430000000 CPS) | Cost: "+ BuildingLogic.getAntimatterCondenserCost()+" Cookies | Owned: "+ BuildingLogic.getAntimatterCondenserPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getAntimatterCondenserCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        PrismButton = new JButton("Prism (+2900000000 CPS) | Cost: "+ BuildingLogic.getPrismCost()+" Cookies | Owned: "+ BuildingLogic.getPrismPurchases());
        PrismButton.addActionListener(_ -> {
            if(BuildingLogic.buyPrism()){
                PrismButton.setText("Prism (+2900000000 CPS) | Cost: "+ BuildingLogic.getPrismCost()+" Cookies | Owned: "+ BuildingLogic.getPrismPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getPrismCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        ChancemakerButton = new JButton("Chancemaker (+21000000000 CPS) | Cost: "+ BuildingLogic.getChancemakerCost()+" Cookies | Owned: "+ BuildingLogic.getChancemakerPurchases());
        ChancemakerButton.addActionListener(_ -> {
            if(BuildingLogic.buyChancemaker()){
                ChancemakerButton.setText("Chancemaker (+21000000000 CPS) | Cost: "+ BuildingLogic.getChancemakerCost()+" Cookies | Owned: "+ BuildingLogic.getChancemakerPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getChancemakerCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        FractalEngineButton = new JButton("Fractal Engine (+150000000000 CPS) | Cost: "+ BuildingLogic.getFractalEngineCost()+" Cookies | Owned: "+ BuildingLogic.getFractalEnginePurchases());
        FractalEngineButton.addActionListener(_ -> {
            if(BuildingLogic.buyFractalEngine()){
                ChancemakerButton.setText("Fractal Engine (+150000000000 CPS) | Cost: "+ BuildingLogic.getFractalEngineCost()+" Cookies | Owned: "+ BuildingLogic.getFractalEnginePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getFractalEngineCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        JavaConsoleButton = new JButton("Java Console (+1100000000000 CPS) | Cost: "+ BuildingLogic.getJavaConsoleCost()+" Cookies | Owned: "+ BuildingLogic.getJavaConsolePurchases());
        JavaConsoleButton.addActionListener(_ -> {
            if(BuildingLogic.buyJavaConsole()){
                JavaConsoleButton.setText("Java Console (+1100000000000 CPS) | Cost: "+ BuildingLogic.getJavaConsoleCost()+" Cookies | Owned: "+ BuildingLogic.getJavaConsolePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getJavaConsoleCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        IdleverseButton = new JButton("Idleverse (+8300000000000 CPS) | Cost: "+ BuildingLogic.getIdleverseCost()+" Cookies | Owned: "+ BuildingLogic.getIdleversePurchases());
        IdleverseButton.addActionListener(_ -> {
            if(BuildingLogic.buyIdleverse()){
                IdleverseButton.setText("Idleverse (+8300000000000 CPS) | Cost: "+ BuildingLogic.getIdleverseCost()+" Cookies | Owned: "+ BuildingLogic.getIdleversePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getIdleverseCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        CortexBakerButton = new JButton("Cortex Baker (+64000000000000 CPS) | Cost: "+ BuildingLogic.getCortexBakerCost()+" Cookies | Owned: "+ BuildingLogic.getCortexBakerPurchases());
        CortexBakerButton.addActionListener(_ -> {
            if(BuildingLogic.buyCortexBaker()){
                CortexBakerButton.setText("Cortex Baker (+64000000000000 CPS) | Cost: "+ BuildingLogic.getCortexBakerCost()+" Cookies | Owned: "+ BuildingLogic.getCortexBakerPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getCortexBakerCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        YouButton = new JButton("You (+500000000000000 CPS) | Cost: "+ BuildingLogic.getYouCost()+" Cookies | Owned: "+ BuildingLogic.getYouPurchases());
        YouButton.addActionListener(_ -> {
            if(BuildingLogic.buyYou()){
                YouButton.setText("You (+500000000000000 CPS) | Cost: "+ BuildingLogic.getYouCost()+" Cookies | Owned: "+ BuildingLogic.getYouPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getYouCost() + " cookies.",
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
        BuildingPanel.add(CursorButton);
        BuildingPanel.add(GrandmaButton);
        BuildingPanel.add(FarmButton);
        BuildingPanel.add(MineButton);
        BuildingPanel.add(FactoryButton);
        BuildingPanel.add(BankButton);
        BuildingPanel.add(TempleButton);
        BuildingPanel.add(WizardTowerButton);
        BuildingPanel.add(ShipmentButton);
        BuildingPanel.add(AlchemyLabButton);
        BuildingPanel.add(PortalButton);
        BuildingPanel.add(TimeMachineButton);
        BuildingPanel.add(AntimatterCondenserButton);
        BuildingPanel.add(PrismButton);
        BuildingPanel.add(ChancemakerButton);
        BuildingPanel.add(FractalEngineButton);
        BuildingPanel.add(JavaConsoleButton);
        BuildingPanel.add(IdleverseButton);
        BuildingPanel.add(CortexBakerButton);
        BuildingPanel.add(YouButton);
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