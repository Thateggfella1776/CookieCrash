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
    Upgrades Upgradelogic = new Upgrades(BuildingLogic);
    Logic GameLogic;
    File save = new File("save.txt");
    boolean CookiesOn=false;



    //Buttons
    Dimension ButtonSize = new Dimension(500,30);
    JButton StatsButton;
    JButton RebirthButton;
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
    JPanel UpgradesPanel;
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
        BuildingLogic = new Buildings();
        Upgradelogic = new Upgrades(BuildingLogic);
        BuildingLogic.UpgradeLogic = Upgradelogic;
        GameLogic = new Logic(BuildingLogic, Upgradelogic);

        //Refresh Timer Creation
        guiUpdate = _ -> {
            ClickPWR.setText("CPC: "+ BuildingLogic.getCookiesPerClick());
            CurrentCookies.setText("Cookies: " + BuildingLogic.getCookieCount().stripTrailingZeros().toPlainString());
            AutoPWR.setText("CPS: " + BuildingLogic.getCookiesPerSecond().stripTrailingZeros().toPlainString());
            CursorButton.setText("Cursor (+0.1 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
            GrandmaButton.setText("Grandma (+1 CPS) | Cost: "+ BuildingLogic.getGrandmaCost()+" Cookies | Owned: "+ BuildingLogic.getGrandmaPurchases());
            FarmButton.setText("Farm (+8 CPS) | Cost: "+ BuildingLogic.getFarmCost()+" Cookies | Owned: "+ BuildingLogic.getFarmPurchases());
            MineButton.setText("Mine (+47 CPS) | Cost: "+ BuildingLogic.getMineCost()+" Cookies | Owned: "+ BuildingLogic.getMinePurchases());
            FactoryButton.setText("Factory (+260 CPS) | Cost: "+ BuildingLogic.getFactoryCost()+" Cookies | Owned: "+ BuildingLogic.getFactoryPurchases());
            BankButton.setText("Bank (+1400 CPS) | Cost: "+ BuildingLogic.getBankCost()+" Cookies | Owned: "+ BuildingLogic.getBankPurchases());
            TempleButton.setText("Temple (+7800 CPS) | Cost: "+ BuildingLogic.getTempleCost()+" Cookies | Owned: "+ BuildingLogic.getTemplePurchases());
            WizardTowerButton.setText("Wizard Tower (+44000 CPS) | Cost: "+ BuildingLogic.getWizardTowerCost()+" Cookies | Owned: "+ BuildingLogic.getWizardTowerPurchases());
            ShipmentButton.setText("Shipment (+260000 CPS) | Cost: "+ BuildingLogic.getShipmentCost()+" Cookies | Owned: "+ BuildingLogic.getShipmentPurchases());
            AlchemyLabButton.setText("Alchemy Lab (+1600000 CPS) | Cost: "+ BuildingLogic.getAlchemyLabCost()+" Cookies | Owned: "+ BuildingLogic.getAlchemyLabPurchases());
            PortalButton.setText("Portal (+10000000 CPS) | Cost: "+ BuildingLogic.getPortalCost()+" Cookies | Owned: "+ BuildingLogic.getPortalPurchases());
            TimeMachineButton.setText("Time Machine (+65000000 CPS) | Cost: "+ BuildingLogic.getTimeMachineCost()+" Cookies | Owned: "+ BuildingLogic.getTimeMachinePurchases());
            AntimatterCondenserButton.setText("Antimatter Condenser (+430000000 CPS) | Cost: "+ BuildingLogic.getAntimatterCondenserCost()+" Cookies | Owned: "+ BuildingLogic.getAntimatterCondenserPurchases());
            PrismButton.setText("Prism (+2900000000 CPS) | Cost: "+ BuildingLogic.getPrismCost()+" Cookies | Owned: "+ BuildingLogic.getPrismPurchases());
            ChancemakerButton.setText("Chancemaker (+21000000000 CPS) | Cost: "+ BuildingLogic.getChancemakerCost()+" Cookies | Owned: "+ BuildingLogic.getChancemakerPurchases());
            FractalEngineButton.setText("Fractal Engine (+150000000000 CPS) | Cost: "+ BuildingLogic.getFractalEngineCost()+" Cookies | Owned: "+ BuildingLogic.getFractalEnginePurchases());
            JavaConsoleButton.setText("Java Console (+1100000000000 CPS) | Cost: "+ BuildingLogic.getJavaConsoleCost()+" Cookies | Owned: "+ BuildingLogic.getJavaConsolePurchases());
            IdleverseButton.setText("Idleverse (+8300000000000 CPS) | Cost: "+ BuildingLogic.getIdleverseCost()+" Cookies | Owned: "+ BuildingLogic.getIdleversePurchases());
            Upgradelogic.CursorUpgrade();
            CursorUpgradeCheck();
            Upgradelogic.GrandmaUpgrade();
            GrandmaUpgradeCheck();
            Upgradelogic.FarmUpgrade();
            FarmUpgradeCheck();
            Upgradelogic.MineUpgrade();
            MineUpgradeCheck();
            if(BuildingLogic.getCookiesPerSecond().compareTo(BigDecimal.valueOf(0))>0&&!CookiesOn){
                BuildingLogic.AutoTimer();
                CookiesOn=true;
            }
        };
        updateTimer = new Timer(500,guiUpdate);
        updateTimer.start();

        //Save/Load & Stats + Rebirth Button Creation
        StatsButton = new JButton("Stats");
        StatsButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(frame,
                "Cursor CPS Mult:"+Upgradelogic.getCursorCPSMult()+"\n"
                        +"Grandma CPS Mult:"+Upgradelogic.getGrandmaCPSMult()+"\n"
                        +"Farm CPS Mult:"+Upgradelogic.getFarmCPSMult()+"\n"
                        +"Mine CPS Mult:"+Upgradelogic.getMineCPSMult()+"\n"
                        +"Factory CPS Mult:"+Upgradelogic.getFactoryCPSMult()+"\n"
                        +"Bank CPS Mult:"+Upgradelogic.getBankCPSMult()+"\n"
                        +"Temple CPS Mult:"+Upgradelogic.getTempleCPSMult()+"\n"
                        +"Wizard Tower CPS Mult:"+Upgradelogic.getWizardTowerCPSMult()+"\n"
                        +"Shipment CPS Mult:"+Upgradelogic.getShipmentCPSMult()+"\n"
                        +"Alchemy Lab CPS Mult:"+Upgradelogic.getAlchemyLabCPSMult()+"\n"
                        +"Portal CPS Mult:"+Upgradelogic.getPortalCPSMult()+"\n"
                        +"Time Machine CPS Mult:"+Upgradelogic.getTimeMachineCPSMult()+"\n"
                        +"Antimatter Condenser CPS Mult:"+Upgradelogic.getAntimatterCondenserCPSMult()+"\n"
                        +"Prism CPS Mult:"+Upgradelogic.getPrismCPSMult()+"\n"
                        +"Chancemaker CPS Mult:"+Upgradelogic.getChancemakerCPSMult()+"\n"
                        +"Fractal Engine CPS Mult:"+Upgradelogic.getFractalEngineCPSMult()+"\n"
                        +"Java Console CPS Mult:"+Upgradelogic.getJavaConsoleCPSMult()+"\n"
                        +"Idleverse CPS Mult:"+Upgradelogic.getIdleverseCPSMult()+"\n"
                        +"Cortex Baker CPS Mult:"+Upgradelogic.getCortexBakerCPSMult()+"\n"
                        +"You CPS Mult:"+Upgradelogic.getYouCPSMult()+"\n"
                        +"Base CPS Mult:"+Upgradelogic.getBaseCPSMult()+"\n"
        );
        });
        RebirthButton = new JButton("Rebirth");
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
            CurrentCookies.setText("Cookies: " + BuildingLogic.getCookieCount().stripTrailingZeros().toPlainString());
        });

        //Upgrade Buttons
        CursorButton = new JButton("Cursor (+0.1 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
        CursorButton.addActionListener(_ -> {
            if(BuildingLogic.buyCursor()){
                CursorButton.setText("Cursor (+0.1 CPS) | Cost: "+ BuildingLogic.getCursorCost()+" Cookies | Owned: "+ BuildingLogic.getCursorPurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getCursorCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE); //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            }
        });
        CursorButton.setPreferredSize(ButtonSize);
        CursorButton.setMinimumSize(ButtonSize);
        CursorButton.setMaximumSize(ButtonSize);
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
        GrandmaButton.setPreferredSize(ButtonSize);
        GrandmaButton.setMinimumSize(ButtonSize);
        GrandmaButton.setMaximumSize(ButtonSize);
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
        FarmButton.setPreferredSize(ButtonSize);
        FarmButton.setMinimumSize(ButtonSize);
        FarmButton.setMaximumSize(ButtonSize);
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
        MineButton.setPreferredSize(ButtonSize);
        MineButton.setMinimumSize(ButtonSize);
        MineButton.setMaximumSize(ButtonSize);
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
        FactoryButton.setPreferredSize(ButtonSize);
        FactoryButton.setMinimumSize(ButtonSize);
        FactoryButton.setMaximumSize(ButtonSize);
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
        BankButton.setPreferredSize(ButtonSize);
        BankButton.setMinimumSize(ButtonSize);
        BankButton.setMaximumSize(ButtonSize);
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
        TempleButton.setPreferredSize(ButtonSize);
        TempleButton.setMinimumSize(ButtonSize);
        TempleButton.setMaximumSize(ButtonSize);
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
        WizardTowerButton.setPreferredSize(ButtonSize);
        WizardTowerButton.setMinimumSize(ButtonSize);
        WizardTowerButton.setMaximumSize(ButtonSize);
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
        ShipmentButton.setPreferredSize(ButtonSize);
        ShipmentButton.setMinimumSize(ButtonSize);
        ShipmentButton.setMaximumSize(ButtonSize);
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
        AlchemyLabButton.setPreferredSize(ButtonSize);
        AlchemyLabButton.setMinimumSize(ButtonSize);
        AlchemyLabButton.setMaximumSize(ButtonSize);
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
        PortalButton.setPreferredSize(ButtonSize);
        PortalButton.setMinimumSize(ButtonSize);
        PortalButton.setMaximumSize(ButtonSize);
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
        TimeMachineButton.setPreferredSize(ButtonSize);
        TimeMachineButton.setMinimumSize(ButtonSize);
        TimeMachineButton.setMaximumSize(ButtonSize);
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
        AntimatterCondenserButton.setPreferredSize(ButtonSize);
        AntimatterCondenserButton.setMinimumSize(ButtonSize);
        AntimatterCondenserButton.setMaximumSize(ButtonSize);
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
        PrismButton.setPreferredSize(ButtonSize);
        PrismButton.setMinimumSize(ButtonSize);
        PrismButton.setMaximumSize(ButtonSize);
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
        ChancemakerButton.setPreferredSize(ButtonSize);
        ChancemakerButton.setMinimumSize(ButtonSize);
        ChancemakerButton.setMaximumSize(ButtonSize);
        FractalEngineButton = new JButton("Fractal Engine (+150000000000 CPS) | Cost: "+ BuildingLogic.getFractalEngineCost()+" Cookies | Owned: "+ BuildingLogic.getFractalEnginePurchases());
        FractalEngineButton.addActionListener(_ -> {
            if(BuildingLogic.buyFractalEngine()){
                FractalEngineButton.setText("Fractal Engine (+150000000000 CPS) | Cost: "+ BuildingLogic.getFractalEngineCost()+" Cookies | Owned: "+ BuildingLogic.getFractalEnginePurchases());
            }else{
                JOptionPane.showMessageDialog(frame,
                        "Not enough cookies! You need " + BuildingLogic.getFractalEngineCost() + " cookies.",
                        "Insufficient Cookies",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        FractalEngineButton.setPreferredSize(ButtonSize);
        FractalEngineButton.setMinimumSize(ButtonSize);
        FractalEngineButton.setMaximumSize(ButtonSize);
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
        JavaConsoleButton.setPreferredSize(ButtonSize);
        JavaConsoleButton.setMinimumSize(ButtonSize);
        JavaConsoleButton.setMaximumSize(ButtonSize);
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
        IdleverseButton.setPreferredSize(ButtonSize);
        IdleverseButton.setMinimumSize(ButtonSize);
        IdleverseButton.setMaximumSize(ButtonSize);
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
        CortexBakerButton.setPreferredSize(ButtonSize);
        CortexBakerButton.setMinimumSize(ButtonSize);
        CortexBakerButton.setMaximumSize(ButtonSize);
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
        YouButton.setPreferredSize(ButtonSize);
        YouButton.setMinimumSize(ButtonSize);
        YouButton.setMaximumSize(ButtonSize);


        //Frame Creation

        frame = new JFrame("COOKIE CRASH!");

        //Label Creation
        CurrentCookies = new JLabel("Cookies: " + BuildingLogic.getCookieCount().stripTrailingZeros().toPlainString());
        ClickPWR = new JLabel("CPC: "+ BuildingLogic.getCookiesPerClick());
        AutoPWR = new JLabel("CPS: " + BuildingLogic.getCookiesPerSecond());

        //Panel Creation
        UpgradesBuildings = new JPanel(new BorderLayout());
        OptionsPanel = new JPanel();
        CookiePanel = new JPanel();
        BuildingPanel = new JPanel();
        UpgradesPanel = new JPanel();
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
        UpgradesPanel.setBackground(myColor);

        //Panel Packing
        OptionsPanel.add(SaveGameButton);
        OptionsPanel.add(LoadGameButton);
        OptionsPanel.add(StatsButton);
        OptionsPanel.add(RebirthButton);
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
        UpgradesBuildings.add(UpgradesPanel,BorderLayout.NORTH);
        UpgradesBuildings.add(BuildingPanel,BorderLayout.CENTER);
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

    //Upgrade check logic
    public void CursorUpgradeCheck(){
        if(Upgradelogic.CursorU1&&!Upgradelogic.CU1Unlocked){
            JButton CursorUpgrade1 = new JButton("x2 CPS From Cursor | Cost: "+ Upgradelogic.CursorU1Cost+" Cookies");
            UpgradesPanel.add(CursorUpgrade1);
            Upgradelogic.CU1Unlocked=true;
            CursorUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU1Cost));
                    Upgradelogic.CursorCPSMult=Upgradelogic.CursorCPSMult*2;
                    UpgradesPanel.remove(CursorUpgrade1);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Not enough cookies! You need " + Upgradelogic.CursorU1Cost + " cookies.",
                            "Insufficient Cookies",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
            JButton CursorUpgrade2 = new JButton("x2 CPS From Cursor | Cost: "+ Upgradelogic.CursorU2Cost+" Cookies");
            UpgradesPanel.add(CursorUpgrade2);
            Upgradelogic.CU2Unlocked=true;
            CursorUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU2Cost));
                    Upgradelogic.CursorCPSMult=Upgradelogic.CursorCPSMult*2;
                    UpgradesPanel.remove(CursorUpgrade2);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Not enough cookies! You need " + Upgradelogic.CursorU2Cost + " cookies.",
                            "Insufficient Cookies",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU3&&!Upgradelogic.CU3Unlocked){
            JButton CursorUpgrade3 = new JButton("x2 CPS From Cursor | Cost: "+ Upgradelogic.CursorU3Cost+" Cookies");
            UpgradesPanel.add(CursorUpgrade3);
            Upgradelogic.CU3Unlocked=true;
            CursorUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU3Cost));
                    Upgradelogic.CursorCPSMult=Upgradelogic.CursorCPSMult*2;
                    UpgradesPanel.remove(CursorUpgrade3);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Not enough cookies! You need " + Upgradelogic.CursorU2Cost + " cookies.",
                            "Insufficient Cookies",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU4&&!Upgradelogic.CU4Unlocked){
            JButton CursorUpgrade4 = new JButton("x2 CPS From Cursor | Cost: "+ Upgradelogic.CursorU4Cost+" Cookies");
            UpgradesPanel.add(CursorUpgrade4);
            Upgradelogic.CU4Unlocked=true;
            CursorUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU4Cost));
                    Upgradelogic.CursorCPSMult=Upgradelogic.CursorCPSMult*2;
                    UpgradesPanel.remove(CursorUpgrade4);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Not enough cookies! You need " + Upgradelogic.CursorU4Cost + " cookies.",
                            "Insufficient Cookies",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU5&&!Upgradelogic.CU5Unlocked){
            JButton CursorUpgrade5 = new JButton("x2 CPS From Cursor | Cost: "+ Upgradelogic.CursorU5Cost+" Cookies");
            UpgradesPanel.add(CursorUpgrade5);
            Upgradelogic.CU5Unlocked=true;
            CursorUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU5Cost));
                    Upgradelogic.CursorCPSMult=Upgradelogic.CursorCPSMult*2;
                    UpgradesPanel.remove(CursorUpgrade5);
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "Not enough cookies! You need " + Upgradelogic.CursorU5Cost + " cookies.",
                            "Insufficient Cookies",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU6 && !Upgradelogic.CU6Unlocked) {
            JButton CursorUpgrade6 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU6Cost);
            UpgradesPanel.add(CursorUpgrade6);
            Upgradelogic.CU6Unlocked = true;
            CursorUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU6Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade6);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU6Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU7 && !Upgradelogic.CU7Unlocked) {
            JButton CursorUpgrade7 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU7Cost);
            UpgradesPanel.add(CursorUpgrade7);
            Upgradelogic.CU7Unlocked = true;
            CursorUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU7Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade7);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU7Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU8 && !Upgradelogic.CU8Unlocked) {
            JButton CursorUpgrade8 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU8Cost);
            UpgradesPanel.add(CursorUpgrade8);
            Upgradelogic.CU8Unlocked = true;
            CursorUpgrade8.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.CursorU8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.CursorU8Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade8);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU8Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU9 && !Upgradelogic.CU9Unlocked) {
            JButton CursorUpgrade9 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU9Cost);
            UpgradesPanel.add(CursorUpgrade9);
            Upgradelogic.CU9Unlocked = true;
            CursorUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU9Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade9);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU9Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU10 && !Upgradelogic.CU10Unlocked) {
            JButton CursorUpgrade10 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU10Cost);
            UpgradesPanel.add(CursorUpgrade10);
            Upgradelogic.CU10Unlocked = true;
            CursorUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU10Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade10);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU10Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU11 && !Upgradelogic.CU11Unlocked) {
            JButton CursorUpgrade11 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU11Cost);
            UpgradesPanel.add(CursorUpgrade11);
            Upgradelogic.CU11Unlocked = true;
            CursorUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU11Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade11);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU11Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU12 && !Upgradelogic.CU12Unlocked) {
            JButton CursorUpgrade12 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU12Cost);
            UpgradesPanel.add(CursorUpgrade12);
            Upgradelogic.CU12Unlocked = true;
            CursorUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU12Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade12);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU12Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.CursorU13 && !Upgradelogic.CU13Unlocked) {
            JButton CursorUpgrade13 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU13Cost);
            UpgradesPanel.add(CursorUpgrade13);
            Upgradelogic.CU13Unlocked = true;
            CursorUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU13Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade13);

                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU13Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        } else if (Upgradelogic.CursorU14 && !Upgradelogic.CU14Unlocked) {
            JButton CursorUpgrade14 = new JButton("x2 CPS From Cursor | Cost: " + Upgradelogic.CursorU14Cost);
            UpgradesPanel.add(CursorUpgrade14);
            Upgradelogic.CU14Unlocked = true;
            CursorUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CursorU14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CursorU14Cost));
                    Upgradelogic.CursorCPSMult = Upgradelogic.CursorCPSMult * 2;
                    UpgradesPanel.remove(CursorUpgrade14);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.CursorU14Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }
    //Grandma CPSUpgrades
    public void GrandmaUpgradeCheck(){
        if(Upgradelogic.GrandmaU1&&!Upgradelogic.GU1Unlocked){
            JButton GrandmaUpgrade1 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU1Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade1);
            Upgradelogic.GU1Unlocked=true;
            GrandmaUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU1Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade1);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU1Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU2&&!Upgradelogic.GU2Unlocked){
            JButton GrandmaUpgrade2 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU2Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade2);
            Upgradelogic.GU2Unlocked=true;
            GrandmaUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU2Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade2);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU2Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU3&&!Upgradelogic.GU3Unlocked){
            JButton GrandmaUpgrade3 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU3Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade3);
            Upgradelogic.GU3Unlocked=true;
            GrandmaUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU3Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade3);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU3Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU4&&!Upgradelogic.GU4Unlocked){
            JButton GrandmaUpgrade4 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU4Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade4);
            Upgradelogic.GU4Unlocked=true;
            GrandmaUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU4Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade4);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU4Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU5&&!Upgradelogic.GU5Unlocked){
            JButton GrandmaUpgrade5 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU5Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade5);
            Upgradelogic.GU5Unlocked=true;
            GrandmaUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU5Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade5);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU5Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU6&&!Upgradelogic.GU6Unlocked){
            JButton GrandmaUpgrade6 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU6Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade6);
            Upgradelogic.GU6Unlocked=true;
            GrandmaUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU6Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade6);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU6Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU7&&!Upgradelogic.GU7Unlocked){
            JButton GrandmaUpgrade7 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU7Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade7);
            Upgradelogic.GU7Unlocked=true;
            GrandmaUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU7Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU7Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade7);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU7Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU8&&!Upgradelogic.GU8Unlocked){
            JButton GrandmaUpgrade8 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU8Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade8);
            Upgradelogic.GU8Unlocked=true;
            GrandmaUpgrade8.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.GrandmaU8Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.GrandmaU8Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade8);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU8Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU9&&!Upgradelogic.GU9Unlocked){
            JButton GrandmaUpgrade9 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU9Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade9);
            Upgradelogic.GU9Unlocked=true;
            GrandmaUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU9Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade9);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU9Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU10&&!Upgradelogic.GU10Unlocked){
            JButton GrandmaUpgrade10 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU10Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade10);
            Upgradelogic.GU10Unlocked=true;
            GrandmaUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU10Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade10);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU10Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU11&&!Upgradelogic.GU11Unlocked){
            JButton GrandmaUpgrade11 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU11Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade11);
            Upgradelogic.GU11Unlocked=true;
            GrandmaUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU11Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade11);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU11Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU12&&!Upgradelogic.GU12Unlocked){
            JButton GrandmaUpgrade12 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU12Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade12);
            Upgradelogic.GU12Unlocked=true;
            GrandmaUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU12Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade12);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU12Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU13&&!Upgradelogic.GU13Unlocked){
            JButton GrandmaUpgrade13 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU13Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade13);
            Upgradelogic.GU13Unlocked=true;
            GrandmaUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU13Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade13);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU13Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU14&&!Upgradelogic.GU14Unlocked){
            JButton GrandmaUpgrade14 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU14Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade14);
            Upgradelogic.GU14Unlocked=true;
            GrandmaUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU14Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade14);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU14Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.GrandmaU15&&!Upgradelogic.GU15Unlocked){
            JButton GrandmaUpgrade15 = new JButton("x2 CPS From Grandma | Cost: "+ Upgradelogic.GrandmaU15Cost+" Cookies");
            UpgradesPanel.add(GrandmaUpgrade15);
            Upgradelogic.GU15Unlocked=true;
            GrandmaUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.GrandmaU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.GrandmaU15Cost));
                    Upgradelogic.GrandmaCPSMult=Upgradelogic.GrandmaCPSMult*2;
                    UpgradesPanel.remove(GrandmaUpgrade15);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.GrandmaU15Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }
    //FarmCPSUpgrade
    public void FarmUpgradeCheck(){
        if(Upgradelogic.FarmU1&&!Upgradelogic.FU1Unlocked){
            JButton FarmUpgrade1 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU1Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade1);
            Upgradelogic.FU1Unlocked=true;
            FarmUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU1Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade1);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU1Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU2&&!Upgradelogic.FU2Unlocked){
            JButton FarmUpgrade2 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU2Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade2);
            Upgradelogic.FU2Unlocked=true;
            FarmUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU2Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade2);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU2Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU3&&!Upgradelogic.FU3Unlocked){
            JButton FarmUpgrade3 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU3Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade3);
            Upgradelogic.FU3Unlocked=true;
            FarmUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU3Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade3);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU3Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU4&&!Upgradelogic.FU4Unlocked){
            JButton FarmUpgrade4 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU4Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade4);
            Upgradelogic.FU4Unlocked=true;
            FarmUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU4Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade4);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU4Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU5&&!Upgradelogic.FU5Unlocked){
            JButton FarmUpgrade5 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU5Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade5);
            Upgradelogic.FU5Unlocked=true;
            FarmUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU5Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade5);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU5Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU6&&!Upgradelogic.FU6Unlocked){
            JButton FarmUpgrade6 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU6Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade6);
            Upgradelogic.FU6Unlocked=true;
            FarmUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU6Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade6);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU6Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU7&&!Upgradelogic.FU7Unlocked){
            JButton FarmUpgrade7 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU7Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade7);
            Upgradelogic.FU7Unlocked=true;
            FarmUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU7Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU7Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade7);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU7Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU8&&!Upgradelogic.FU8Unlocked){
            JButton FarmUpgrade8 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU8Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade8);
            Upgradelogic.FU8Unlocked=true;
            FarmUpgrade8.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FarmU8Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FarmU8Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade8);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU8Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU9&&!Upgradelogic.FU9Unlocked){
            JButton FarmUpgrade9 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU9Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade9);
            Upgradelogic.FU9Unlocked=true;
            FarmUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU9Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade9);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU9Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU10&&!Upgradelogic.FU10Unlocked){
            JButton FarmUpgrade10 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU10Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade10);
            Upgradelogic.FU10Unlocked=true;
            FarmUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU10Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade10);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU10Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU11&&!Upgradelogic.FU11Unlocked){
            JButton FarmUpgrade11 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU11Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade11);
            Upgradelogic.FU11Unlocked=true;
            FarmUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU11Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade11);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU11Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU12&&!Upgradelogic.FU12Unlocked){
            JButton FarmUpgrade12 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU12Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade12);
            Upgradelogic.FU12Unlocked=true;
            FarmUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU12Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade12);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU12Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU13&&!Upgradelogic.FU13Unlocked){
            JButton FarmUpgrade13 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU13Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade13);
            Upgradelogic.FU13Unlocked=true;
            FarmUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU13Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade13);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU13Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU14&&!Upgradelogic.FU14Unlocked){
            JButton FarmUpgrade14 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU14Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade14);
            Upgradelogic.FU14Unlocked=true;
            FarmUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU14Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade14);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU14Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }else if(Upgradelogic.FarmU15&&!Upgradelogic.FU15Unlocked){
            JButton FarmUpgrade15 = new JButton("x2 CPS From Farm | Cost: "+ Upgradelogic.FarmU15Cost+" Cookies");
            UpgradesPanel.add(FarmUpgrade15);
            Upgradelogic.FU15Unlocked=true;
            FarmUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FarmU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FarmU15Cost));
                    Upgradelogic.FarmCPSMult=Upgradelogic.FarmCPSMult*2;
                    UpgradesPanel.remove(FarmUpgrade15);
                }else{
                    JOptionPane.showMessageDialog(frame, "Not enough cookies! You need " + Upgradelogic.FarmU15Cost + " cookies.", "Insufficient Cookies", JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }
    //MineCPSUpgrades
    public void MineUpgradeCheck(){
        if(Upgradelogic.MineU1&&!Upgradelogic.MU1Unlocked){
            JButton MineUpgrade1 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU1Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade1);
            Upgradelogic.MU1Unlocked=true;
            MineUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU1Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade1);
                }
            });
        }else if(Upgradelogic.MineU2&&!Upgradelogic.MU2Unlocked){
            JButton MineUpgrade2 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU2Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade2);
            Upgradelogic.MU2Unlocked=true;
            MineUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU2Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade2);
                }
            });
        }else if(Upgradelogic.MineU3&&!Upgradelogic.MU3Unlocked){
            JButton MineUpgrade3 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU3Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade3);
            Upgradelogic.MU3Unlocked=true;
            MineUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU3Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade3);
                }
            });
        }else if(Upgradelogic.MineU4&&!Upgradelogic.MU4Unlocked){
            JButton MineUpgrade4 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU4Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade4);
            Upgradelogic.MU4Unlocked=true;
            MineUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU4Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade4);
                }
            });
        }else if(Upgradelogic.MineU5&&!Upgradelogic.MU5Unlocked){
            JButton MineUpgrade5 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU5Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade5);
            Upgradelogic.MU5Unlocked=true;
            MineUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU5Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade5);
                }
            });
        }else if(Upgradelogic.MineU6&&!Upgradelogic.MU6Unlocked){
            JButton MineUpgrade6 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU6Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade6);
            Upgradelogic.MU6Unlocked=true;
            MineUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU6Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade6);
                }
            });
        }else if(Upgradelogic.MineU7&&!Upgradelogic.MU7Unlocked){
            JButton MineUpgrade7 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU7Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade7);
            Upgradelogic.MU7Unlocked=true;
            MineUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU7Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU7Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade7);
                }
            });
        }else if(Upgradelogic.MineU8&&!Upgradelogic.MU8Unlocked){
            JButton MineUpgrade8 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU8Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade8);
            Upgradelogic.MU8Unlocked=true;
            MineUpgrade8.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.MineU8Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.MineU8Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade8);
                }
            });
        }else if(Upgradelogic.MineU9&&!Upgradelogic.MU9Unlocked){
            JButton MineUpgrade9 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU9Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade9);
            Upgradelogic.MU9Unlocked=true;
            MineUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU9Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade9);
                }
            });
        }else if(Upgradelogic.MineU10&&!Upgradelogic.MU10Unlocked){
            JButton MineUpgrade10 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU10Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade10);
            Upgradelogic.MU10Unlocked=true;
            MineUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU10Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade10);
                }
            });
        }else if(Upgradelogic.MineU11&&!Upgradelogic.MU11Unlocked){
            JButton MineUpgrade11 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU11Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade11);
            Upgradelogic.MU11Unlocked=true;
            MineUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU11Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade11);
                }
            });
        }else if(Upgradelogic.MineU12&&!Upgradelogic.MU12Unlocked){
            JButton MineUpgrade12 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU12Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade12);
            Upgradelogic.MU12Unlocked=true;
            MineUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU12Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade12);
                }
            });
        }else if(Upgradelogic.MineU13&&!Upgradelogic.MU13Unlocked){
            JButton MineUpgrade13 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU13Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade13);
            Upgradelogic.MU13Unlocked=true;
            MineUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU13Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade13);
                }
            });
        }else if(Upgradelogic.MineU14&&!Upgradelogic.MU14Unlocked){
            JButton MineUpgrade14 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU14Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade14);
            Upgradelogic.MU14Unlocked=true;
            MineUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU14Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade14);
                }
            });
        }else if(Upgradelogic.MineU15&&!Upgradelogic.MU15Unlocked){
            JButton MineUpgrade15 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.MineU15Cost+" Cookies");
            UpgradesPanel.add(MineUpgrade15);
            Upgradelogic.MU15Unlocked=true;
            MineUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.MineU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.MineU15Cost));
                    Upgradelogic.MineCPSMult=Upgradelogic.MineCPSMult*2;
                    UpgradesPanel.remove(MineUpgrade15);
                }
            });
        }
    }
    //FactoryCPSUpgrades
    public void FactoryUpgradeCheck(){
        if(Upgradelogic.FactoryU1&&!Upgradelogic.FAU1Unlocked){
            JButton FactoryUpgrade1 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU1Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade1);
            Upgradelogic.FAU1Unlocked=true;
            FactoryUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU1Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade1);
                }
            });
        }else if(Upgradelogic.FactoryU2&&!Upgradelogic.FAU2Unlocked){
            JButton FactoryUpgrade2 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU2Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade2);
            Upgradelogic.FAU2Unlocked=true;
            FactoryUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU2Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade2);
                }
            });
        }else if(Upgradelogic.FactoryU3&&!Upgradelogic.FAU3Unlocked){
            JButton FactoryUpgrade3 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU3Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade3);
            Upgradelogic.FAU3Unlocked=true;
            FactoryUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU3Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade3);
                }
            });
        }else if(Upgradelogic.FactoryU4&&!Upgradelogic.FAU4Unlocked){
            JButton FactoryUpgrade4 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU4Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade4);
            Upgradelogic.FAU4Unlocked=true;
            FactoryUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU4Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade4);
                }
            });
        }else if(Upgradelogic.FactoryU5&&!Upgradelogic.FAU5Unlocked){
            JButton FactoryUpgrade5 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU5Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade5);
            Upgradelogic.FAU5Unlocked=true;
            FactoryUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU5Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade5);
                }
            });
        }else if(Upgradelogic.FactoryU6&&!Upgradelogic.FAU6Unlocked){
            JButton FactoryUpgrade6 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU6Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade6);
            Upgradelogic.FAU6Unlocked=true;
            FactoryUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU6Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade6);
                }
            });
        }else if(Upgradelogic.FactoryU7&&!Upgradelogic.FAU7Unlocked){
            JButton FactoryUpgrade7 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU7Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade7);
            Upgradelogic.FAU7Unlocked=true;
            FactoryUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.FAU7Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.FAU7Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade7);
                }
            });
        }else if(Upgradelogic.FactoryU8&&!Upgradelogic.FAU8Unlocked) {
            JButton FactoryUpgrade8 = new JButton("x2 CPS From Mine | Cost: " + Upgradelogic.FAU8Cost + " Cookies");
            UpgradesPanel.add(FactoryUpgrade8);
            Upgradelogic.FAU8Unlocked = true;
            FactoryUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU8Cost));
                    Upgradelogic.FactoryCPSMult = Upgradelogic.FactoryCPSMult * 2;
                    UpgradesPanel.remove(FactoryUpgrade8);
                }
            });
        }else if(Upgradelogic.FactoryU9&&!Upgradelogic.FAU9Unlocked){
            JButton FactoryUpgrade9 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU9Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade9);
            Upgradelogic.FAU9Unlocked=true;
            FactoryUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU9Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade9);
                }
            });
        }else if(Upgradelogic.FactoryU10&&!Upgradelogic.FAU10Unlocked){
            JButton FactoryUpgrade10 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU10Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade10);
            Upgradelogic.FAU10Unlocked=true;
            FactoryUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU10Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade10);
                }
            });
        }else if(Upgradelogic.FactoryU11&&!Upgradelogic.FAU11Unlocked){
            JButton FactoryUpgrade11 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU11Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade11);
            Upgradelogic.FAU11Unlocked=true;
            FactoryUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU11Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade11);
                }
            });
        }else if(Upgradelogic.FactoryU12&&!Upgradelogic.FAU12Unlocked){
            JButton FactoryUpgrade12 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU12Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade12);
            Upgradelogic.FAU12Unlocked=true;
            FactoryUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU12Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade12);
                }
            });
        }else if(Upgradelogic.FactoryU13&&!Upgradelogic.FAU13Unlocked){
            JButton FactoryUpgrade13 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU13Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade13);
            Upgradelogic.FAU13Unlocked=true;
            FactoryUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU13Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade13);
                }
            });
        }else if(Upgradelogic.FactoryU14&&!Upgradelogic.FAU14Unlocked){
            JButton FactoryUpgrade14 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU14Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade14);
            Upgradelogic.FAU14Unlocked=true;
            FactoryUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU14Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade14);
                }
            });
        }else if(Upgradelogic.FactoryU15&&!Upgradelogic.FAU15Unlocked){
            JButton FactoryUpgrade15 = new JButton("x2 CPS From Mine | Cost: "+ Upgradelogic.FAU15Cost+" Cookies");
            UpgradesPanel.add(FactoryUpgrade15);
            Upgradelogic.FAU15Unlocked=true;
            FactoryUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FAU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FAU15Cost));
                    Upgradelogic.FactoryCPSMult=Upgradelogic.FactoryCPSMult*2;
                    UpgradesPanel.remove(FactoryUpgrade15);
                }
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}