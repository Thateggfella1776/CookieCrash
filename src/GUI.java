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
            Upgradelogic.FactoryUpgrade();
            FactoryUpgradeCheck();
            Upgradelogic.BankUpgrade();
            BankUpgradeCheck();
            Upgradelogic.TempleUpgrade();
            TempleUpgradeCheck();
            Upgradelogic.WizardTowerUpgrade();
            WizardTowerUpgradeCheck();
            Upgradelogic.ShipmentUpgrade();
            ShipmentUpgradeCheck();
            Upgradelogic.AlchemyLabUpgrade();
            AlchemyLabUpgradeCheck();
            Upgradelogic.PortalUpgrade();
            PortalUpgradeCheck();
            Upgradelogic.TimeMachineUpgrade();
            TimeMachineUpgradeCheck();
            Upgradelogic.AntimatterCondenserUpgrade();
            AntimatterCondenserUpgradeCheck();
            Upgradelogic.PrismUpgrade();
            PrismUpgradeCheck();
            Upgradelogic.ChancemakerUpgrade();
            ChancemakerUpgradeCheck();
            Upgradelogic.FractalEngineUpgrade();
            FractalEngineUpgradeCheck();
            Upgradelogic.JavaConsoleUpgrade();
            JavaConsoleUpgradeCheck();
            Upgradelogic.IdleverseUpgrade();
            IdleverseUpgradeCheck();
            Upgradelogic.CortexBakerUpgrade();
            CortexBakeryUpgradeCheck();
            Upgradelogic.YouUpgrade();
            YouUpgradeCheck();

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
    //GrandmaCPSUpgrades
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
            JButton FactoryUpgrade1 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU1Cost+" Cookies");
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
            JButton FactoryUpgrade2 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU2Cost+" Cookies");
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
            JButton FactoryUpgrade3 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU3Cost+" Cookies");
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
            JButton FactoryUpgrade4 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU4Cost+" Cookies");
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
            JButton FactoryUpgrade5 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU5Cost+" Cookies");
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
            JButton FactoryUpgrade6 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU6Cost+" Cookies");
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
            JButton FactoryUpgrade7 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU7Cost+" Cookies");
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
            JButton FactoryUpgrade8 = new JButton("x2 CPS From Factory | Cost: " + Upgradelogic.FAU8Cost + " Cookies");
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
            JButton FactoryUpgrade9 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU9Cost+" Cookies");
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
            JButton FactoryUpgrade10 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU10Cost+" Cookies");
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
            JButton FactoryUpgrade11 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU11Cost+" Cookies");
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
            JButton FactoryUpgrade12 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU12Cost+" Cookies");
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
            JButton FactoryUpgrade13 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU13Cost+" Cookies");
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
            JButton FactoryUpgrade14 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU14Cost+" Cookies");
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
            JButton FactoryUpgrade15 = new JButton("x2 CPS From Factory | Cost: "+ Upgradelogic.FAU15Cost+" Cookies");
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
    //BankCPSUpgrades
    public void BankUpgradeCheck(){
        if(Upgradelogic.BankU1&&!Upgradelogic.BU1Unlocked){
            JButton BankUpgrade1 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU1Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade1);
            Upgradelogic.BU1Unlocked=true;
            BankUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU1Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade1);
                }
            });
        }else if(Upgradelogic.BankU2&&!Upgradelogic.BU2Unlocked){
            JButton BankUpgrade2 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU2Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade2);
            Upgradelogic.BU2Unlocked=true;
            BankUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU2Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade2);
                }
            });
        }else if(Upgradelogic.BankU3&&!Upgradelogic.BU3Unlocked){
            JButton BankUpgrade3 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU3Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade3);
            Upgradelogic.BU3Unlocked=true;
            BankUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU3Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade3);
                }
            });
        }else if(Upgradelogic.BankU4&&!Upgradelogic.BU4Unlocked){
            JButton BankUpgrade4 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU4Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade4);
            Upgradelogic.BU4Unlocked=true;
            BankUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU4Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade4);
                }
            });
        }else if(Upgradelogic.BankU5&&!Upgradelogic.BU5Unlocked){
            JButton BankUpgrade5 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU5Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade5);
            Upgradelogic.BU5Unlocked=true;
            BankUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU5Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade5);
                }
            });
        }else if(Upgradelogic.BankU6&&!Upgradelogic.BU6Unlocked){
            JButton BankUpgrade6 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU6Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade6);
            Upgradelogic.BU6Unlocked=true;
            BankUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU6Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade6);
                }
            });
        }else if(Upgradelogic.BankU7&&!Upgradelogic.BU7Unlocked){
            JButton BankUpgrade7 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU7Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade7);
            Upgradelogic.BU7Unlocked=true;
            BankUpgrade7.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.BU7Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.BU7Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade7);
                }
            });
        }else if(Upgradelogic.BankU8&&!Upgradelogic.BU8Unlocked) {
            JButton BankUpgrade8 = new JButton("x2 CPS From Bank | Cost: " + Upgradelogic.BU8Cost + " Cookies");
            UpgradesPanel.add(BankUpgrade8);
            Upgradelogic.BU8Unlocked = true;
            BankUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU8Cost));
                    Upgradelogic.BankCPSMult = Upgradelogic.BankCPSMult * 2;
                    UpgradesPanel.remove(BankUpgrade8);
                }
            });
        }else if(Upgradelogic.BankU9&&!Upgradelogic.BU9Unlocked){
            JButton BankUpgrade9 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU9Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade9);
            Upgradelogic.BU9Unlocked=true;
            BankUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU9Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade9);
                }
            });
        }else if(Upgradelogic.BankU10&&!Upgradelogic.BU10Unlocked){
            JButton BankUpgrade10 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU10Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade10);
            Upgradelogic.BU10Unlocked=true;
            BankUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU10Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade10);
                }
            });
        }else if(Upgradelogic.BankU11&&!Upgradelogic.BU11Unlocked){
            JButton BankUpgrade11 = new JButton("x2 CPS From Bank Cost: "+ Upgradelogic.BU11Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade11);
            Upgradelogic.BU11Unlocked=true;
            BankUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU11Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade11);
                }
            });
        }else if(Upgradelogic.BankU12&&!Upgradelogic.BU12Unlocked){
            JButton BankUpgrade12 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU12Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade12);
            Upgradelogic.BU12Unlocked=true;
            BankUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU12Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade12);
                }
            });
        }else if(Upgradelogic.BankU13&&!Upgradelogic.BU13Unlocked){
            JButton BankUpgrade13 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU13Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade13);
            Upgradelogic.BU13Unlocked=true;
            BankUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU13Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade13);
                }
            });
        }else if(Upgradelogic.BankU14&&!Upgradelogic.BU14Unlocked){
            JButton BankUpgrade14 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU14Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade14);
            Upgradelogic.BU14Unlocked=true;
            BankUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU14Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade14);
                }
            });
        }else if(Upgradelogic.BankU15&&!Upgradelogic.BU15Unlocked){
            JButton BankUpgrade15 = new JButton("x2 CPS From Bank | Cost: "+ Upgradelogic.BU15Cost+" Cookies");
            UpgradesPanel.add(BankUpgrade15);
            Upgradelogic.BU15Unlocked=true;
            BankUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.BU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.BU15Cost));
                    Upgradelogic.BankCPSMult=Upgradelogic.BankCPSMult*2;
                    UpgradesPanel.remove(BankUpgrade15);
                }
            });
        }
    }
    //TempleCPSUpgrades
    public void TempleUpgradeCheck(){
        if(Upgradelogic.TempleU1&&!Upgradelogic.TU1Unlocked){
            JButton TempleUpgrade1 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU1Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade1);
            Upgradelogic.TU1Unlocked=true;
            TempleUpgrade1.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU1Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU1Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade1);
                }
            });
        }else if(Upgradelogic.TempleU2&&!Upgradelogic.TU2Unlocked){
            JButton TempleUpgrade2 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU2Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade2);
            Upgradelogic.TU2Unlocked=true;
            TempleUpgrade2.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU2Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU2Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade2);
                }
            });
        }else if(Upgradelogic.TempleU3&&!Upgradelogic.TU3Unlocked){
            JButton TempleUpgrade3 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU3Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade3);
            Upgradelogic.TU3Unlocked=true;
            TempleUpgrade3.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU3Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU3Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade3);
                }
            });
        }else if(Upgradelogic.TempleU4&&!Upgradelogic.TU4Unlocked){
            JButton TempleUpgrade4 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU4Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade4);
            Upgradelogic.TU4Unlocked=true;
            TempleUpgrade4.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU4Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU4Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade4);
                }
            });
        }else if(Upgradelogic.TempleU5&&!Upgradelogic.TU5Unlocked){
            JButton TempleUpgrade5 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU5Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade5);
            Upgradelogic.TU5Unlocked=true;
            TempleUpgrade5.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU5Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU5Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade5);
                }
            });
        }else if(Upgradelogic.TempleU6&&!Upgradelogic.TU6Unlocked){
            JButton TempleUpgrade6 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU6Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade6);
            Upgradelogic.TU6Unlocked=true;
            TempleUpgrade6.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.TU6Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.TU6Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade6);
                }
            });
        }else if(Upgradelogic.TempleU7&&!Upgradelogic.TU7Unlocked) {
            JButton TempleUpgrade7 = new JButton("x2 CPS From Temple | Cost: " + Upgradelogic.TU7Cost + " Cookies");
            UpgradesPanel.add(TempleUpgrade7);
            Upgradelogic.TU7Unlocked = true;
            TempleUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU7Cost));
                    Upgradelogic.TempleCPSMult = Upgradelogic.TempleCPSMult * 2;
                    UpgradesPanel.remove(TempleUpgrade7);
                }
            });
        }else if(Upgradelogic.TempleU8&&!Upgradelogic.TU8Unlocked){
            JButton TempleUpgrade8 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU8Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade8);
            Upgradelogic.TU8Unlocked=true;
            TempleUpgrade8.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU8Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU8Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade8);
                }
            });
        }else if(Upgradelogic.TempleU9&&!Upgradelogic.TU9Unlocked){
            JButton TempleUpgrade9 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU9Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade9);
            Upgradelogic.TU9Unlocked=true;
            TempleUpgrade9.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU9Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU9Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade9);
                }
            });
        }else if(Upgradelogic.TempleU10&&!Upgradelogic.TU10Unlocked){
            JButton TempleUpgrade10 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU10Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade10);
            Upgradelogic.TU10Unlocked=true;
            TempleUpgrade10.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU10Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU10Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade10);
                }
            });
        }else if(Upgradelogic.TempleU11&&!Upgradelogic.TU11Unlocked){
            JButton TempleUpgrade11 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU11Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade11);
            Upgradelogic.TU11Unlocked=true;
            TempleUpgrade11.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU11Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU11Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade11);
                }
            });
        }else if(Upgradelogic.TempleU12&&!Upgradelogic.TU12Unlocked){
            JButton TempleUpgrade12 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU12Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade12);
            Upgradelogic.TU12Unlocked=true;
            TempleUpgrade12.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU12Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU12Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade12);
                }
            });
        }else if(Upgradelogic.TempleU13&&!Upgradelogic.TU13Unlocked){
            JButton TempleUpgrade13 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU13Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade13);
            Upgradelogic.TU13Unlocked=true;
            TempleUpgrade13.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU13Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU13Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade13);
                }
            });
        }else if(Upgradelogic.TempleU14&&!Upgradelogic.TU14Unlocked){
            JButton TempleUpgrade14 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU14Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade14);
            Upgradelogic.TU14Unlocked=true;
            TempleUpgrade14.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU14Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU14Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade14);
                }
            });
        }else if(Upgradelogic.TempleU15&&!Upgradelogic.TU15Unlocked){
            JButton TempleUpgrade15 = new JButton("x2 CPS From Temple | Cost: "+ Upgradelogic.TU15Cost+" Cookies");
            UpgradesPanel.add(TempleUpgrade15);
            Upgradelogic.TU15Unlocked=true;
            TempleUpgrade15.addActionListener(_ -> {
                if(BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TU15Cost))>=0){
                    BuildingLogic.cookieCount=BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TU15Cost));
                    Upgradelogic.TempleCPSMult=Upgradelogic.TempleCPSMult*2;
                    UpgradesPanel.remove(TempleUpgrade15);
                }
            });
        }
    }
    //WizardTowerCPSUpgrades
    public void WizardTowerUpgradeCheck(){
        if(Upgradelogic.WizardTU1&&!Upgradelogic.WTU1Unlocked) {
            JButton WizardTUpgrade1 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU1Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade1);
            Upgradelogic.WTU1Unlocked = true;
            WizardTUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU1Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade1);
                }
            });
        }else if(Upgradelogic.WizardTU2&&!Upgradelogic.WTU2Unlocked){
            JButton WizardTUpgrade2 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU2Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade2);
            Upgradelogic.WTU2Unlocked = true;
            WizardTUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU2Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade2);
                }
            });
        }else if(Upgradelogic.WizardTU3&&!Upgradelogic.WTU3Unlocked){
            JButton WizardTUpgrade3 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU3Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade3);
            Upgradelogic.WTU3Unlocked = true;
            WizardTUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU3Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade3);
                }
            });
        }else if(Upgradelogic.WizardTU4&&!Upgradelogic.WTU4Unlocked){
            JButton WizardTUpgrade4 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU4Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade4);
            Upgradelogic.WTU4Unlocked = true;
            WizardTUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU4Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade4);
                }
            });
        }else if(Upgradelogic.WizardTU5&&!Upgradelogic.WTU5Unlocked){
            JButton WizardTUpgrade5 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU5Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade5);
            Upgradelogic.WTU5Unlocked = true;
            WizardTUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU5Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade5);
                }
            });
        }else if(Upgradelogic.WizardTU6&&!Upgradelogic.WTU6Unlocked){
            JButton WizardTUpgrade6 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU6Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade6);
            Upgradelogic.WTU6Unlocked = true;
            WizardTUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU6Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade6);
                }
            });
        }else if(Upgradelogic.WizardTU7&&!Upgradelogic.WTU7Unlocked){
            JButton WizardTUpgrade7 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU7Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade7);
            Upgradelogic.WTU7Unlocked = true;
            WizardTUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU7Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade7);
                }
            });
        }else if(Upgradelogic.WizardTU8&&!Upgradelogic.WTU8Unlocked){
            JButton WizardTUpgrade8 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU8Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade8);
            Upgradelogic.WTU8Unlocked = true;
            WizardTUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU8Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade8);
                }
            });
        }else if(Upgradelogic.WizardTU9&&!Upgradelogic.WTU9Unlocked){
            JButton WizardTUpgrade9 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU9Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade9);
            Upgradelogic.WTU9Unlocked = true;
            WizardTUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU9Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade9);
                }
            });
        }else if(Upgradelogic.WizardTU10&&!Upgradelogic.WTU10Unlocked){
            JButton WizardTUpgrade10 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU10Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade10);
            Upgradelogic.WTU10Unlocked = true;
            WizardTUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU10Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade10);
                }
            });
        }else if(Upgradelogic.WizardTU11&&!Upgradelogic.WTU11Unlocked){
            JButton WizardTUpgrade11 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU11Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade11);
            Upgradelogic.WTU11Unlocked = true;
            WizardTUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU11Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade11);
                }
            });
        }else if(Upgradelogic.WizardTU12&&!Upgradelogic.WTU12Unlocked){
            JButton WizardTUpgrade12 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU12Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade12);
            Upgradelogic.WTU12Unlocked = true;
            WizardTUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU12Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade12);
                }
            });
        }else if(Upgradelogic.WizardTU13&&!Upgradelogic.WTU13Unlocked){
            JButton WizardTUpgrade13 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU13Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade13);
            Upgradelogic.WTU13Unlocked = true;
            WizardTUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU13Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade13);
                }
            });
        }else if(Upgradelogic.WizardTU14&&!Upgradelogic.WTU14Unlocked){
            JButton WizardTUpgrade14 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU14Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade14);
            Upgradelogic.WTU14Unlocked = true;
            WizardTUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU14Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade14);
                }
            });
        }else if(Upgradelogic.WizardTU15&&!Upgradelogic.WTU15Unlocked){
            JButton WizardTUpgrade15 = new JButton("x2 CPS From Wizard Tower | Cost: " + Upgradelogic.WTU15Cost + " Cookies");
            UpgradesPanel.add(WizardTUpgrade15);
            Upgradelogic.WTU15Unlocked = true;
            WizardTUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.WTU15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.WTU15Cost));
                    Upgradelogic.WizardTowerCPSMult = Upgradelogic.WizardTowerCPSMult * 2;
                    UpgradesPanel.remove(WizardTUpgrade15);
                }
            });
        }
    }
    //ShipmentCPSUpgrades
    public void ShipmentUpgradeCheck(){
        if(Upgradelogic.ShipmentU1&&!Upgradelogic.S1Unlocked) {
            JButton ShipmentUpgrade1 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S1Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade1);
            Upgradelogic.S1Unlocked = true;
            ShipmentUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S1Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade1);
                }
            });
        }else if(Upgradelogic.ShipmentU2&&!Upgradelogic.S2Unlocked){
            JButton ShipmentUpgrade2 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S2Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade2);
            Upgradelogic.S2Unlocked = true;
            ShipmentUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S2Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade2);
                }
            });
        }else if(Upgradelogic.ShipmentU3&&!Upgradelogic.S3Unlocked){
            JButton ShipmentUpgrade3 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S3Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade3);
            Upgradelogic.S3Unlocked = true;
            ShipmentUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S3Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade3);
                }
            });
        }else if(Upgradelogic.ShipmentU4&&!Upgradelogic.S4Unlocked){
            JButton ShipmentUpgrade4 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S4Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade4);
            Upgradelogic.S4Unlocked = true;
            ShipmentUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S4Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade4);
                }
            });
        }else if(Upgradelogic.ShipmentU5&&!Upgradelogic.S5Unlocked){
            JButton ShipmentUpgrade5 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S5Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade5);
            Upgradelogic.S5Unlocked = true;
            ShipmentUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S5Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade5);
                }
            });
        }else if(Upgradelogic.ShipmentU6&&!Upgradelogic.S6Unlocked){
            JButton ShipmentUpgrade6 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S6Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade6);
            Upgradelogic.S6Unlocked = true;
            ShipmentUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S6Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade6);
                }
            });
        }else if(Upgradelogic.ShipmentU7&&!Upgradelogic.S7Unlocked){
            JButton ShipmentUpgrade7 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S7Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade7);
            Upgradelogic.S7Unlocked = true;
            ShipmentUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S7Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade7);
                }
            });
        }else if(Upgradelogic.ShipmentU8&&!Upgradelogic.S8Unlocked){
            JButton ShipmentUpgrade8 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S8Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade8);
            Upgradelogic.S8Unlocked = true;
            ShipmentUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S8Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade8);
                }
            });
        }else if(Upgradelogic.ShipmentU9&&!Upgradelogic.S9Unlocked){
            JButton ShipmentUpgrade9 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S9Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade9);
            Upgradelogic.S9Unlocked = true;
            ShipmentUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S9Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade9);
                }
            });
        }else if(Upgradelogic.ShipmentU10&&!Upgradelogic.S10Unlocked){
            JButton ShipmentUpgrade10 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S10Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade10);
            Upgradelogic.S10Unlocked = true;
            ShipmentUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S10Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade10);
                }
            });
        }else if(Upgradelogic.ShipmentU11&&!Upgradelogic.S11Unlocked){
            JButton ShipmentUpgrade11 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S11Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade11);
            Upgradelogic.S11Unlocked = true;
            ShipmentUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S11Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade11);
                }
            });
        }else if(Upgradelogic.ShipmentU12&&!Upgradelogic.S12Unlocked){
            JButton ShipmentUpgrade12 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S12Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade12);
            Upgradelogic.S12Unlocked = true;
            ShipmentUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S12Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade12);
                }
            });
        }else if(Upgradelogic.ShipmentU13&&!Upgradelogic.S13Unlocked){
            JButton ShipmentUpgrade13 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S13Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade13);
            Upgradelogic.S13Unlocked = true;
            ShipmentUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S13Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade13);
                }
            });
        }else if(Upgradelogic.ShipmentU14&&!Upgradelogic.S14Unlocked){
            JButton ShipmentUpgrade14 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S14Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade14);
            Upgradelogic.S14Unlocked = true;
            ShipmentUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S14Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade14);
                }
            });
        }else if(Upgradelogic.ShipmentU15&&!Upgradelogic.S15Unlocked){
            JButton ShipmentUpgrade15 = new JButton("x2 CPS From Shipment | Cost: " + Upgradelogic.S15Cost + " Cookies");
            UpgradesPanel.add(ShipmentUpgrade15);
            Upgradelogic.S15Unlocked = true;
            ShipmentUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.S15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.S15Cost));
                    Upgradelogic.ShipmentCPSMult = Upgradelogic.ShipmentCPSMult * 2;
                    UpgradesPanel.remove(ShipmentUpgrade15);
                }
            });
        }
    }
    //AlchemyLabCPSUpgrades
    public void AlchemyLabUpgradeCheck(){
        if(Upgradelogic.AlchemyLabU1&&!Upgradelogic.AL1Unlocked) {
            JButton AlchemyLabUpgrade1 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL1Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade1);
            Upgradelogic.AL1Unlocked = true;
            AlchemyLabUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL1Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade1);
                }
            });
        }else if(Upgradelogic.AlchemyLabU2&&!Upgradelogic.AL2Unlocked){
            JButton AlchemyLabUpgrade2 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL2Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade2);
            Upgradelogic.AL2Unlocked = true;
            AlchemyLabUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL2Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade2);
                }
            });
        }else if(Upgradelogic.AlchemyLabU3&&!Upgradelogic.AL3Unlocked){
            JButton AlchemyLabUpgrade3 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL3Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade3);
            Upgradelogic.AL3Unlocked = true;
            AlchemyLabUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL3Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade3);
                }
            });
        }else if(Upgradelogic.AlchemyLabU4&&!Upgradelogic.AL4Unlocked){
            JButton AlchemyLabUpgrade4 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL4Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade4);
            Upgradelogic.AL4Unlocked = true;
            AlchemyLabUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL4Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade4);
                }
            });
        }else if(Upgradelogic.AlchemyLabU5&&!Upgradelogic.AL5Unlocked){
            JButton AlchemyLabUpgrade5 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL5Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade5);
            Upgradelogic.AL5Unlocked = true;
            AlchemyLabUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL5Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade5);
                }
            });
        }else if(Upgradelogic.AlchemyLabU6&&!Upgradelogic.AL6Unlocked){
            JButton AlchemyLabUpgrade6 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL6Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade6);
            Upgradelogic.AL6Unlocked = true;
            AlchemyLabUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL6Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade6);
                }
            });
        }else if(Upgradelogic.AlchemyLabU7&&!Upgradelogic.AL7Unlocked){
            JButton AlchemyLabUpgrade7 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL7Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade7);
            Upgradelogic.AL7Unlocked = true;
            AlchemyLabUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL7Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade7);
                }
            });
        }else if(Upgradelogic.AlchemyLabU8&&!Upgradelogic.AL8Unlocked){
            JButton AlchemyLabUpgrade8 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL8Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade8);
            Upgradelogic.AL8Unlocked = true;
            AlchemyLabUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL8Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade8);
                }
            });
        }else if(Upgradelogic.AlchemyLabU9&&!Upgradelogic.AL9Unlocked){
            JButton AlchemyLabUpgrade9 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL9Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade9);
            Upgradelogic.AL9Unlocked = true;
            AlchemyLabUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL9Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade9);
                }
            });
        }else if(Upgradelogic.AlchemyLabU10&&!Upgradelogic.AL10Unlocked){
            JButton AlchemyLabUpgrade10 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL10Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade10);
            Upgradelogic.AL10Unlocked = true;
            AlchemyLabUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL10Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade10);
                }
            });
        }else if(Upgradelogic.AlchemyLabU11&&!Upgradelogic.AL11Unlocked){
            JButton AlchemyLabUpgrade11 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL11Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade11);
            Upgradelogic.AL11Unlocked = true;
            AlchemyLabUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL11Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade11);
                }
            });
        }else if(Upgradelogic.AlchemyLabU12&&!Upgradelogic.AL12Unlocked){
            JButton AlchemyLabUpgrade12 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL12Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade12);
            Upgradelogic.AL12Unlocked = true;
            AlchemyLabUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL12Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade12);
                }
            });
        }else if(Upgradelogic.AlchemyLabU13&&!Upgradelogic.AL13Unlocked){
            JButton AlchemyLabUpgrade13 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL13Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade13);
            Upgradelogic.AL13Unlocked = true;
            AlchemyLabUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL13Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade13);
                }
            });
        }else if(Upgradelogic.AlchemyLabU14&&!Upgradelogic.AL14Unlocked){
            JButton AlchemyLabUpgrade14 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL14Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade14);
            Upgradelogic.AL14Unlocked = true;
            AlchemyLabUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL14Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade14);
                }
            });
        }else if(Upgradelogic.AlchemyLabU15&&!Upgradelogic.AL15Unlocked){
            JButton AlchemyLabUpgrade15 = new JButton("x2 CPS From Alchemy Lab | Cost: " + Upgradelogic.AL15Cost + " Cookies");
            UpgradesPanel.add(AlchemyLabUpgrade15);
            Upgradelogic.AL15Unlocked = true;
            AlchemyLabUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AL15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AL15Cost));
                    Upgradelogic.AlchemyLabCPSMult = Upgradelogic.AlchemyLabCPSMult * 2;
                    UpgradesPanel.remove(AlchemyLabUpgrade15);
                }
            });
        }
    }
    //PortalCPSUpgrade
    public void PortalUpgradeCheck(){
        if(Upgradelogic.PortalU1&&!Upgradelogic.P1Unlocked) {
            JButton PortalUpgrade1 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P1Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade1);
            Upgradelogic.P1Unlocked = true;
            PortalUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P1Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade1);
                }
            });
        }else if(Upgradelogic.PortalU2&&!Upgradelogic.P2Unlocked){
            JButton PortalUpgrade2 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P2Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade2);
            Upgradelogic.P2Unlocked = true;
            PortalUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P2Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade2);
                }
            });
        }else if(Upgradelogic.PortalU3&&!Upgradelogic.P3Unlocked){
            JButton PortalUpgrade3 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P3Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade3);
            Upgradelogic.P3Unlocked = true;
            PortalUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P3Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade3);
                }
            });
        }else if(Upgradelogic.PortalU4&&!Upgradelogic.P4Unlocked){
            JButton PortalUpgrade4 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P4Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade4);
            Upgradelogic.P4Unlocked = true;
            PortalUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P4Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade4);
                }
            });
        }else if(Upgradelogic.PortalU5&&!Upgradelogic.P5Unlocked){
            JButton PortalUpgrade5 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P5Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade5);
            Upgradelogic.P5Unlocked = true;
            PortalUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P5Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade5);
                }
            });
        }else if(Upgradelogic.PortalU6&&!Upgradelogic.P6Unlocked){
            JButton PortalUpgrade6 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P6Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade6);
            Upgradelogic.P6Unlocked = true;
            PortalUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P6Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade6);
                }
            });
        }else if(Upgradelogic.PortalU7&&!Upgradelogic.P7Unlocked){
            JButton PortalUpgrade7 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P7Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade7);
            Upgradelogic.P7Unlocked = true;
            PortalUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P7Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade7);
                }
            });
        }else if(Upgradelogic.PortalU8&&!Upgradelogic.P8Unlocked){
            JButton PortalUpgrade8 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P8Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade8);
            Upgradelogic.P8Unlocked = true;
            PortalUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P8Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade8);
                }
            });
        }else if(Upgradelogic.PortalU9&&!Upgradelogic.P9Unlocked){
            JButton PortalUpgrade9 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P9Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade9);
            Upgradelogic.P9Unlocked = true;
            PortalUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P9Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade9);
                }
            });
        }else if(Upgradelogic.PortalU10&&!Upgradelogic.P10Unlocked){
            JButton PortalUpgrade10 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P10Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade10);
            Upgradelogic.P10Unlocked = true;
            PortalUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P10Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade10);
                }
            });
        }else if(Upgradelogic.PortalU11&&!Upgradelogic.P11Unlocked){
            JButton PortalUpgrade11 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P11Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade11);
            Upgradelogic.P11Unlocked = true;
            PortalUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P11Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade11);
                }
            });
        }else if(Upgradelogic.PortalU12&&!Upgradelogic.P12Unlocked){
            JButton PortalUpgrade12 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P12Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade12);
            Upgradelogic.P12Unlocked = true;
            PortalUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P12Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade12);
                }
            });
        }else if(Upgradelogic.PortalU13&&!Upgradelogic.P13Unlocked){
            JButton PortalUpgrade13 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P13Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade13);
            Upgradelogic.P13Unlocked = true;
            PortalUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P13Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade13);
                }
            });
        }else if(Upgradelogic.PortalU14&&!Upgradelogic.P14Unlocked){
            JButton PortalUpgrade14 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P14Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade14);
            Upgradelogic.P14Unlocked = true;
            PortalUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P14Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade14);
                }
            });
        }else if(Upgradelogic.PortalU15&&!Upgradelogic.P15Unlocked){
            JButton PortalUpgrade15 = new JButton("x2 CPS From Portal | Cost: " + Upgradelogic.P15Cost + " Cookies");
            UpgradesPanel.add(PortalUpgrade15);
            Upgradelogic.P15Unlocked = true;
            PortalUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.P15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.P15Cost));
                    Upgradelogic.PortalCPSMult = Upgradelogic.PortalCPSMult * 2;
                    UpgradesPanel.remove(PortalUpgrade15);
                }
            });
        }
    }
    //TimeMachineCPSUpgrade
    public void TimeMachineUpgradeCheck(){
        if(Upgradelogic.TimeMachineU1&&!Upgradelogic.TM1Unlocked) {
            JButton TimeMachineUpgrade1 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM1Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade1);
            Upgradelogic.TM1Unlocked = true;
            TimeMachineUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM1Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade1);
                }
            });
        }else if(Upgradelogic.TimeMachineU2&&!Upgradelogic.TM2Unlocked){
            JButton TimeMachineUpgrade2 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM2Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade2);
            Upgradelogic.TM2Unlocked = true;
            TimeMachineUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM2Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade2);
                }
            });
        }else if(Upgradelogic.TimeMachineU3&&!Upgradelogic.TM3Unlocked){
            JButton TimeMachineUpgrade3 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM3Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade3);
            Upgradelogic.TM3Unlocked = true;
            TimeMachineUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM3Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade3);
                }
            });
        }else if(Upgradelogic.TimeMachineU4&&!Upgradelogic.TM4Unlocked){
            JButton TimeMachineUpgrade4 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM4Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade4);
            Upgradelogic.TM4Unlocked = true;
            TimeMachineUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM4Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade4);
                }
            });
        }else if(Upgradelogic.TimeMachineU5&&!Upgradelogic.TM5Unlocked){
            JButton TimeMachineUpgrade5 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM5Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade5);
            Upgradelogic.TM5Unlocked = true;
            TimeMachineUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM5Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade5);
                }
            });
        }else if(Upgradelogic.TimeMachineU6&&!Upgradelogic.TM6Unlocked){
            JButton TimeMachineUpgrade6 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM6Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade6);
            Upgradelogic.TM6Unlocked = true;
            TimeMachineUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM6Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade6);
                }
            });
        }else if(Upgradelogic.TimeMachineU7&&!Upgradelogic.TM7Unlocked){
            JButton TimeMachineUpgrade7 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM7Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade7);
            Upgradelogic.TM7Unlocked = true;
            TimeMachineUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM7Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade7);
                }
            });
        }else if(Upgradelogic.TimeMachineU8&&!Upgradelogic.TM8Unlocked){
            JButton TimeMachineUpgrade8 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM8Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade8);
            Upgradelogic.TM8Unlocked = true;
            TimeMachineUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM8Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade8);
                }
            });
        }else if(Upgradelogic.TimeMachineU9&&!Upgradelogic.TM9Unlocked){
            JButton TimeMachineUpgrade9 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM9Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade9);
            Upgradelogic.TM9Unlocked = true;
            TimeMachineUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM9Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade9);
                }
            });
        }else if(Upgradelogic.TimeMachineU10&&!Upgradelogic.TM10Unlocked){
            JButton TimeMachineUpgrade10 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM10Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade10);
            Upgradelogic.TM10Unlocked = true;
            TimeMachineUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM10Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade10);
                }
            });
        }else if(Upgradelogic.TimeMachineU11&&!Upgradelogic.TM11Unlocked){
            JButton TimeMachineUpgrade11 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM11Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade11);
            Upgradelogic.TM11Unlocked = true;
            TimeMachineUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM11Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade11);
                }
            });
        }else if(Upgradelogic.TimeMachineU12&&!Upgradelogic.TM12Unlocked){
            JButton TimeMachineUpgrade12 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM12Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade12);
            Upgradelogic.TM12Unlocked = true;
            TimeMachineUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM12Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade12);
                }
            });
        }else if(Upgradelogic.TimeMachineU13&&!Upgradelogic.TM13Unlocked){
            JButton TimeMachineUpgrade13 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM13Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade13);
            Upgradelogic.TM13Unlocked = true;
            TimeMachineUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM13Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade13);
                }
            });
        }else if(Upgradelogic.TimeMachineU14&&!Upgradelogic.TM14Unlocked){
            JButton TimeMachineUpgrade14 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM14Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade14);
            Upgradelogic.TM14Unlocked = true;
            TimeMachineUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM14Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade14);
                }
            });
        }else if(Upgradelogic.TimeMachineU15&&!Upgradelogic.TM15Unlocked){
            JButton TimeMachineUpgrade15 = new JButton("x2 CPS From Time Machine | Cost: " + Upgradelogic.TM15Cost + " Cookies");
            UpgradesPanel.add(TimeMachineUpgrade15);
            Upgradelogic.TM15Unlocked = true;
            TimeMachineUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.TM15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.TM15Cost));
                    Upgradelogic.TimeMachineCPSMult = Upgradelogic.TimeMachineCPSMult * 2;
                    UpgradesPanel.remove(TimeMachineUpgrade15);
                }
            });
        }
    }
    //AntiMatterCondenserCPSUpgrade
    public void AntimatterCondenserUpgradeCheck(){
        if(Upgradelogic.AntimatterCondenserU1&&!Upgradelogic.AC1Unlocked) {
            JButton AntimatterCondenserUpgrade1 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC1Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade1);
            Upgradelogic.AC1Unlocked = true;
            AntimatterCondenserUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC1Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade1);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU2&&!Upgradelogic.AC2Unlocked){
            JButton AntimatterCondenserUpgrade2 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC2Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade2);
            Upgradelogic.AC2Unlocked = true;
            AntimatterCondenserUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC2Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade2);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU3&&!Upgradelogic.AC3Unlocked){
            JButton AntimatterCondenserUpgrade3 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC3Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade3);
            Upgradelogic.AC3Unlocked = true;
            AntimatterCondenserUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC3Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade3);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU4&&!Upgradelogic.AC4Unlocked){
            JButton AntimatterCondenserUpgrade4 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC4Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade4);
            Upgradelogic.AC4Unlocked = true;
            AntimatterCondenserUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC4Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade4);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU5&&!Upgradelogic.AC5Unlocked){
            JButton AntimatterCondenserUpgrade5 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC5Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade5);
            Upgradelogic.AC5Unlocked = true;
            AntimatterCondenserUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC5Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade5);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU6&&!Upgradelogic.AC6Unlocked){
            JButton AntimatterCondenserUpgrade6 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC6Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade6);
            Upgradelogic.AC6Unlocked = true;
            AntimatterCondenserUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC6Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade6);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU7&&!Upgradelogic.AC7Unlocked){
            JButton AntimatterCondenserUpgrade7 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC7Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade7);
            Upgradelogic.AC7Unlocked = true;
            AntimatterCondenserUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC7Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade7);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU8&&!Upgradelogic.AC8Unlocked){
            JButton AntimatterCondenserUpgrade8 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC8Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade8);
            Upgradelogic.AC8Unlocked = true;
            AntimatterCondenserUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC8Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade8);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU9&&!Upgradelogic.AC9Unlocked){
            JButton AntimatterCondenserUpgrade9 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC9Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade9);
            Upgradelogic.AC9Unlocked = true;
            AntimatterCondenserUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC9Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade9);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU10&&!Upgradelogic.AC10Unlocked){
            JButton AntimatterCondenserUpgrade10 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC10Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade10);
            Upgradelogic.AC10Unlocked = true;
            AntimatterCondenserUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC10Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade10);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU11&&!Upgradelogic.AC11Unlocked){
            JButton AntimatterCondenserUpgrade11 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC11Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade11);
            Upgradelogic.AC11Unlocked = true;
            AntimatterCondenserUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC11Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade11);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU12&&!Upgradelogic.AC12Unlocked){
            JButton AntimatterCondenserUpgrade12 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC12Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade12);
            Upgradelogic.AC12Unlocked = true;
            AntimatterCondenserUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC12Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade12);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU13&&!Upgradelogic.AC13Unlocked){
            JButton AntimatterCondenserUpgrade13 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC13Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade13);
            Upgradelogic.AC13Unlocked = true;
            AntimatterCondenserUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC13Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade13);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU14&&!Upgradelogic.AC14Unlocked){
            JButton AntimatterCondenserUpgrade14 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC14Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade14);
            Upgradelogic.AC14Unlocked = true;
            AntimatterCondenserUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC14Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade14);
                }
            });
        }else if(Upgradelogic.AntimatterCondenserU15&&!Upgradelogic.AC15Unlocked){
            JButton AntimatterCondenserUpgrade15 = new JButton("x2 CPS From Antimatter Condenser | Cost: " + Upgradelogic.AC15Cost + " Cookies");
            UpgradesPanel.add(AntimatterCondenserUpgrade15);
            Upgradelogic.AC15Unlocked = true;
            AntimatterCondenserUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.AC15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.AC15Cost));
                    Upgradelogic.AntimatterCondenserCPSMult = Upgradelogic.AntimatterCondenserCPSMult * 2;
                    UpgradesPanel.remove(AntimatterCondenserUpgrade15);
                }
            });
        }
    }
    //PrismCPSUpgrades
    public void PrismUpgradeCheck(){
        if(Upgradelogic.PrisimU1&&!Upgradelogic.Prm1Unlocked){
            JButton PrismUpgrade1 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm1Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade1);
            Upgradelogic.Prm1Unlocked = true;
            PrismUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.Prm1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.Prm1Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade1);
                }
            });
        }else if(Upgradelogic.PrisimU2&&!Upgradelogic.Prm2Unlocked){
            JButton PrismUpgrade2 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm2Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade2);
            Upgradelogic.Prm2Unlocked = true;
            PrismUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.Prm2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.Prm2Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade2);
                }
            });
        }else if(Upgradelogic.PrisimU3&&!Upgradelogic.Prm3Unlocked){
            JButton PrismUpgrade3 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm3Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade3);
            Upgradelogic.Prm3Unlocked = true;
            PrismUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(BigDecimal.valueOf(Upgradelogic.Prm3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(BigDecimal.valueOf(Upgradelogic.Prm3Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade3);
                }
            });
        }else if(Upgradelogic.PrisimU4&&!Upgradelogic.Prm4Unlocked){
            JButton PrismUpgrade4 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm4Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade4);
            Upgradelogic.Prm4Unlocked = true;
            PrismUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm4Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade4);
                }
            });
        }else if(Upgradelogic.PrisimU5&&!Upgradelogic.Prm5Unlocked){
            JButton PrismUpgrade5 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm5Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade5);
            Upgradelogic.Prm5Unlocked = true;
            PrismUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm5Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade5);
                }
            });
        }else if(Upgradelogic.PrisimU6&&!Upgradelogic.Prm6Unlocked){
            JButton PrismUpgrade6 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm6Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade6);
            Upgradelogic.Prm6Unlocked = true;
            PrismUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm6Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade6);
                }
            });
        }else if(Upgradelogic.PrisimU7&&!Upgradelogic.Prm7Unlocked){
            JButton PrismUpgrade7 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm7Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade7);
            Upgradelogic.Prm7Unlocked = true;
            PrismUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm7Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade7);
                }
            });
        }else if(Upgradelogic.PrisimU8&&!Upgradelogic.Prm8Unlocked){
            JButton PrismUpgrade8 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm8Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade8);
            Upgradelogic.Prm8Unlocked = true;
            PrismUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm8Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade8);
                }
            });
        }else if(Upgradelogic.PrisimU9&&!Upgradelogic.Prm9Unlocked){
            JButton PrismUpgrade9 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm9Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade9);
            Upgradelogic.Prm9Unlocked = true;
            PrismUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm9Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade9);
                }
            });
        }else if(Upgradelogic.PrisimU10&&!Upgradelogic.Prm10Unlocked){
            JButton PrismUpgrade10 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm10Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade10);
            Upgradelogic.Prm10Unlocked = true;
            PrismUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm10Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade10);
                }
            });
        }else if(Upgradelogic.PrisimU11&&!Upgradelogic.Prm11Unlocked){
            JButton PrismUpgrade11 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm11Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade11);
            Upgradelogic.Prm11Unlocked = true;
            PrismUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm11Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade11);
                }
            });
        }else if(Upgradelogic.PrisimU12&&!Upgradelogic.Prm12Unlocked){
            JButton PrismUpgrade12 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm12Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade12);
            Upgradelogic.Prm12Unlocked = true;
            PrismUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm12Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade12);
                }
            });
        }else if(Upgradelogic.PrisimU13&&!Upgradelogic.Prm13Unlocked){
            JButton PrismUpgrade13 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm13Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade13);
            Upgradelogic.Prm13Unlocked = true;
            PrismUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm13Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade13);
                }
            });
        }else if(Upgradelogic.PrisimU14&&!Upgradelogic.Prm14Unlocked){
            JButton PrismUpgrade14 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm14Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade14);
            Upgradelogic.Prm14Unlocked = true;
            PrismUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm14Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade14);
                }
            });
        }else if(Upgradelogic.PrisimU15&&!Upgradelogic.Prm15Unlocked){
            JButton PrismUpgrade15 = new JButton("x2 CPS From Prism | Cost: " + Upgradelogic.Prm15Cost + " Cookies");
            UpgradesPanel.add(PrismUpgrade15);
            Upgradelogic.Prm15Unlocked = true;
            PrismUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Prm15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Prm15Cost));
                    Upgradelogic.PrismCPSMult = Upgradelogic.PrismCPSMult * 2;
                    UpgradesPanel.remove(PrismUpgrade15);
                }
            });
        }
    }
    //ChancemakerCPSUpgrade
    public void ChancemakerUpgradeCheck(){
        if(Upgradelogic.ChancemakerU1&&!Upgradelogic.CM1Unlocked) {
            JButton ChancemakerUpgrade1 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM1Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade1);
            Upgradelogic.CM1Unlocked = true;
            ChancemakerUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM1Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade1);
                }
            });
        }else if(Upgradelogic.ChancemakerU2&&!Upgradelogic.CM2Unlocked){
            JButton ChancemakerUpgrade2 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM2Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade2);
            Upgradelogic.CM2Unlocked = true;
            ChancemakerUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM2Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade2);
                }
            });
        }else if(Upgradelogic.ChancemakerU3&&!Upgradelogic.CM3Unlocked){
            JButton ChancemakerUpgrade3 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM3Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade3);
            Upgradelogic.CM3Unlocked = true;
            ChancemakerUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM3Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade3);
                }
            });
        }else if(Upgradelogic.ChancemakerU4&&!Upgradelogic.CM4Unlocked){
            JButton ChancemakerUpgrade4 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM4Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade4);
            Upgradelogic.CM4Unlocked = true;
            ChancemakerUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM4Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade4);
                }
            });
        }else if(Upgradelogic.ChancemakerU5&&!Upgradelogic.CM5Unlocked){
            JButton ChancemakerUpgrade5 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM5Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade5);
            Upgradelogic.CM5Unlocked = true;
            ChancemakerUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM5Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade5);
                }
            });
        }else if(Upgradelogic.ChancemakerU6&&!Upgradelogic.CM6Unlocked){
            JButton ChancemakerUpgrade6 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM6Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade6);
            Upgradelogic.CM6Unlocked = true;
            ChancemakerUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM6Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade6);
                }
            });
        }else if(Upgradelogic.ChancemakerU7&&!Upgradelogic.CM7Unlocked){
            JButton ChancemakerUpgrade7 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM7Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade7);
            Upgradelogic.CM7Unlocked = true;
            ChancemakerUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM7Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade7);
                }
            });
        }else if(Upgradelogic.ChancemakerU8&&!Upgradelogic.CM8Unlocked){
            JButton ChancemakerUpgrade8 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM8Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade8);
            Upgradelogic.CM8Unlocked = true;
            ChancemakerUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM8Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade8);
                }
            });
        }else if(Upgradelogic.ChancemakerU9&&!Upgradelogic.CM9Unlocked){
            JButton ChancemakerUpgrade9 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM9Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade9);
            Upgradelogic.CM9Unlocked = true;
            ChancemakerUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM9Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade9);
                }
            });
        }else if(Upgradelogic.ChancemakerU10&&!Upgradelogic.CM10Unlocked){
            JButton ChancemakerUpgrade10 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM10Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade10);
            Upgradelogic.CM10Unlocked = true;
            ChancemakerUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM10Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade10);
                }
            });
        }else if(Upgradelogic.ChancemakerU11&&!Upgradelogic.CM11Unlocked){
            JButton ChancemakerUpgrade11 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM11Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade11);
            Upgradelogic.CM11Unlocked = true;
            ChancemakerUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM11Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade11);
                }
            });
        }else if(Upgradelogic.ChancemakerU12&&!Upgradelogic.CM12Unlocked){
            JButton ChancemakerUpgrade12 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM12Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade12);
            Upgradelogic.CM12Unlocked = true;
            ChancemakerUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM12Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade12);
                }
            });
        }else if(Upgradelogic.ChancemakerU13&&!Upgradelogic.CM13Unlocked){
            JButton ChancemakerUpgrade13 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM13Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade13);
            Upgradelogic.CM13Unlocked = true;
            ChancemakerUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM13Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade13);
                }
            });
        }else if(Upgradelogic.ChancemakerU14&&!Upgradelogic.CM14Unlocked){
            JButton ChancemakerUpgrade14 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM14Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade14);
            Upgradelogic.CM14Unlocked = true;
            ChancemakerUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM14Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade14);
                }
            });
        }else if(Upgradelogic.ChancemakerU15&&!Upgradelogic.CM15Unlocked){
            JButton ChancemakerUpgrade15 = new JButton("x2 CPS From Chancemaker | Cost: " + Upgradelogic.CM15Cost + " Cookies");
            UpgradesPanel.add(ChancemakerUpgrade15);
            Upgradelogic.CM15Unlocked = true;
            ChancemakerUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CM15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CM15Cost));
                    Upgradelogic.ChancemakerCPSMult = Upgradelogic.ChancemakerCPSMult * 2;
                    UpgradesPanel.remove(ChancemakerUpgrade15);
                }
            });
        }
    }
    //FractalEngineCPSUpgrade
    public void FractalEngineUpgradeCheck(){
        if(Upgradelogic.FractalEU1&&!Upgradelogic.FE1Unlocked) {
          JButton FractalEUpgrade1 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE1Cost+" Cookies");
          UpgradesPanel.add(FractalEUpgrade1);
          Upgradelogic.FE1Unlocked = true;
          FractalEUpgrade1.addActionListener(_ -> {
              if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE1Cost)) >= 0) {
                  BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE1Cost));
                  Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                  UpgradesPanel.remove(FractalEUpgrade1);
              }
          });
        }else if(Upgradelogic.FractalEU2&&!Upgradelogic.FE2Unlocked){
            JButton FractalEUpgrade2 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE2Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade2);
            Upgradelogic.FE2Unlocked = true;
            FractalEUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE2Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade2);
                }
            });
        }else if(Upgradelogic.FractalEU3&&!Upgradelogic.FE3Unlocked){
            JButton FractalEUpgrade3 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE3Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade3);
            Upgradelogic.FE3Unlocked = true;
            FractalEUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE3Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade3);
                }
            });
        }else if(Upgradelogic.FractalEU4&&!Upgradelogic.FE4Unlocked){
            JButton FractalEUpgrade4 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE4Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade4);
            Upgradelogic.FE4Unlocked = true;
            FractalEUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE4Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade4);
                }
            });
        }else if(Upgradelogic.FractalEU5&&!Upgradelogic.FE5Unlocked){
            JButton FractalEUpgrade5 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE5Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade5);
            Upgradelogic.FE5Unlocked = true;
            FractalEUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE5Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade5);
                }
            });
        }else if(Upgradelogic.FractalEU6&&!Upgradelogic.FE6Unlocked){
            JButton FractalEUpgrade6 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE6Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade6);
            Upgradelogic.FE6Unlocked = true;
            FractalEUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE6Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade6);
                }
            });
        }else if(Upgradelogic.FractalEU7&&!Upgradelogic.FE7Unlocked){
            JButton FractalEUpgrade7 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE7Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade7);
            Upgradelogic.FE7Unlocked = true;
            FractalEUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE7Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade7);
                }
            });
        }else if(Upgradelogic.FractalEU8&&!Upgradelogic.FE8Unlocked){
            JButton FractalEUpgrade8 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE8Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade8);
            Upgradelogic.FE8Unlocked = true;
            FractalEUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE8Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade8);
                }
            });
        }else if(Upgradelogic.FractalEU9&&!Upgradelogic.FE9Unlocked){
            JButton FractalEUpgrade9 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE9Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade9);
            Upgradelogic.FE9Unlocked = true;
            FractalEUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE9Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade9);
                }
            });
        }else if(Upgradelogic.FractalEU10&&!Upgradelogic.FE10Unlocked){
            JButton FractalEUpgrade10 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE10Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade10);
            Upgradelogic.FE10Unlocked = true;
            FractalEUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE10Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade10);
                }
            });
        }else if(Upgradelogic.FractalEU11&&!Upgradelogic.FE11Unlocked){
            JButton FractalEUpgrade11 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE11Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade11);
            Upgradelogic.FE11Unlocked = true;
            FractalEUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE11Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade11);
                }
            });
        }else if(Upgradelogic.FractalEU12&&!Upgradelogic.FE12Unlocked){
            JButton FractalEUpgrade12 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE12Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade12);
            Upgradelogic.FE12Unlocked = true;
            FractalEUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE12Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade12);
                }
            });
        }else if(Upgradelogic.FractalEU13&&!Upgradelogic.FE13Unlocked){
            JButton FractalEUpgrade13 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE13Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade13);
            Upgradelogic.FE13Unlocked = true;
            FractalEUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE13Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade13);
                }
            });
        }else if(Upgradelogic.FractalEU14&&!Upgradelogic.FE14Unlocked){
            JButton FractalEUpgrade14 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE14Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade14);
            Upgradelogic.FE14Unlocked = true;
            FractalEUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE14Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade14);
                }
            });
        }else if(Upgradelogic.FractalEU15&&!Upgradelogic.FE15Unlocked){
            JButton FractalEUpgrade15 = new JButton("x2 CPS From Fractal Engine | Cost: "+Upgradelogic.FractalE15Cost+" Cookies");
            UpgradesPanel.add(FractalEUpgrade15);
            Upgradelogic.FE15Unlocked = true;
            FractalEUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.FractalE15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.FractalE15Cost));
                    Upgradelogic.FractalEngineCPSMult = Upgradelogic.FractalEngineCPSMult * 2;
                    UpgradesPanel.remove(FractalEUpgrade15);
                }
            });
        }
    }
    //JavaConsoleCPSUpgrade
    public void JavaConsoleUpgradeCheck(){
       if(Upgradelogic.JavaConsoleU1&&!Upgradelogic.JC1Unlocked) {
           JButton JavaConsoleUpgrade1 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC1Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade1);
           Upgradelogic.JC1Unlocked = true;
           JavaConsoleUpgrade1.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC1Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC1Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade1);
               }
           });
       }else if(Upgradelogic.JavaConsoleU2&&!Upgradelogic.JC2Unlocked){
           JButton JavaConsoleUpgrade2 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC2Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade2);
           Upgradelogic.JC2Unlocked = true;
           JavaConsoleUpgrade2.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC2Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC2Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade2);
               }
           });
       }else if(Upgradelogic.JavaConsoleU3&&!Upgradelogic.JC3Unlocked){
           JButton JavaConsoleUpgrade3 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC3Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade3);
           Upgradelogic.JC3Unlocked = true;
           JavaConsoleUpgrade3.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC3Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC3Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade3);
               }
           });
       }else if(Upgradelogic.JavaConsoleU4&&!Upgradelogic.JC4Unlocked){
           JButton JavaConsoleUpgrade4 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC4Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade4);
           Upgradelogic.JC4Unlocked = true;
           JavaConsoleUpgrade4.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC4Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC4Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade4);
               }
           });
       }else if(Upgradelogic.JavaConsoleU5&&!Upgradelogic.JC5Unlocked){
           JButton JavaConsoleUpgrade5 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC5Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade5);
           Upgradelogic.JC5Unlocked = true;
           JavaConsoleUpgrade5.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC5Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC5Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade5);
               }
           });
       }else if(Upgradelogic.JavaConsoleU6&&!Upgradelogic.JC6Unlocked){
           JButton JavaConsoleUpgrade6 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC6Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade6);
           Upgradelogic.JC6Unlocked = true;
           JavaConsoleUpgrade6.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC6Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC6Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade6);
               }
           });
       }else if(Upgradelogic.JavaConsoleU7&&!Upgradelogic.JC7Unlocked){
           JButton JavaConsoleUpgrade7 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC7Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade7);
           Upgradelogic.JC7Unlocked = true;
           JavaConsoleUpgrade7.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC7Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC7Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade7);
               }
           });
       }else if(Upgradelogic.JavaConsoleU8&&!Upgradelogic.JC8Unlocked){
           JButton JavaConsoleUpgrade8 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC8Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade8);
           Upgradelogic.JC8Unlocked = true;
           JavaConsoleUpgrade8.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC8Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC8Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade8);
               }
           });
       }else if(Upgradelogic.JavaConsoleU9&&!Upgradelogic.JC9Unlocked){
           JButton JavaConsoleUpgrade9 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC9Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade9);
           Upgradelogic.JC9Unlocked = true;
           JavaConsoleUpgrade9.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC9Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC9Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade9);
               }
           });
       }else if(Upgradelogic.JavaConsoleU10&&!Upgradelogic.JC10Unlocked){
           JButton JavaConsoleUpgrade10 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC10Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade10);
           Upgradelogic.JC10Unlocked = true;
           JavaConsoleUpgrade10.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC10Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC10Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade10);
               }
           });
       }else if(Upgradelogic.JavaConsoleU11&&!Upgradelogic.JC11Unlocked){
           JButton JavaConsoleUpgrade11 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC11Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade11);
           Upgradelogic.JC11Unlocked = true;
           JavaConsoleUpgrade11.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC11Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC11Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade11);
               }
           });
       }else if(Upgradelogic.JavaConsoleU12&&!Upgradelogic.JC12Unlocked){
           JButton JavaConsoleUpgrade12 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC12Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade12);
           Upgradelogic.JC12Unlocked = true;
           JavaConsoleUpgrade12.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC12Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC12Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade12);
               }
           });
       }else if(Upgradelogic.JavaConsoleU13&&!Upgradelogic.JC13Unlocked){
           JButton JavaConsoleUpgrade13 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC13Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade13);
           Upgradelogic.JC13Unlocked = true;
           JavaConsoleUpgrade13.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC13Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC13Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade13);
               }
           });
       }else if(Upgradelogic.JavaConsoleU14&&!Upgradelogic.JC14Unlocked){
           JButton JavaConsoleUpgrade14 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC14Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade14);
           Upgradelogic.JC14Unlocked = true;
           JavaConsoleUpgrade14.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC14Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC14Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade14);
               }
           });
       }else if(Upgradelogic.JavaConsoleU15&&!Upgradelogic.JC15Unlocked){
           JButton JavaConsoleUpgrade15 = new JButton("x2 CPS From Java Console | Cost: "+Upgradelogic.JC15Cost+" Cookies");
           UpgradesPanel.add(JavaConsoleUpgrade15);
           Upgradelogic.JC15Unlocked = true;
           JavaConsoleUpgrade15.addActionListener(_ -> {
               if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.JC15Cost)) >= 0) {
                   BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.JC15Cost));
                   Upgradelogic.JavaConsoleCPSMult = Upgradelogic.JavaConsoleCPSMult * 2;
                   UpgradesPanel.remove(JavaConsoleUpgrade15);
               }
           });
       }
    }
    //IdleverseCPSUpgrade
    public void IdleverseUpgradeCheck(){
        if(Upgradelogic.IdleverseU1&&!Upgradelogic.IV1Unlocked){
            JButton IdleverseUpgrade1 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV1Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade1);
            Upgradelogic.IV1Unlocked = true;
            IdleverseUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV1Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade1);
                }
            });
        }else if(Upgradelogic.IdleverseU2&&!Upgradelogic.IV2Unlocked){
            JButton IdleverseUpgrade2 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV2Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade2);
            Upgradelogic.IV2Unlocked = true;
            IdleverseUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV2Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade2);
                }
            });
        }else if(Upgradelogic.IdleverseU3&&!Upgradelogic.IV3Unlocked){
            JButton IdleverseUpgrade3 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV3Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade3);
            Upgradelogic.IV3Unlocked = true;
            IdleverseUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV3Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade3);
                }
            });
        }else if(Upgradelogic.IdleverseU4&&!Upgradelogic.IV4Unlocked){
            JButton IdleverseUpgrade4 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV4Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade4);
            Upgradelogic.IV4Unlocked = true;
            IdleverseUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV4Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade4);
                }
            });
        }else if(Upgradelogic.IdleverseU5&&!Upgradelogic.IV5Unlocked){
            JButton IdleverseUpgrade5 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV5Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade5);
            Upgradelogic.IV5Unlocked = true;
            IdleverseUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV5Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade5);
                }
            });
        }else if(Upgradelogic.IdleverseU6&&!Upgradelogic.IV6Unlocked){
            JButton IdleverseUpgrade6 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV6Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade6);
            Upgradelogic.IV6Unlocked = true;
            IdleverseUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV6Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade6);
                }
            });
        }else if(Upgradelogic.IdleverseU7&&!Upgradelogic.IV7Unlocked){
            JButton IdleverseUpgrade7 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV7Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade7);
            Upgradelogic.IV7Unlocked = true;
            IdleverseUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV7Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade7);
                }
            });
        }else if(Upgradelogic.IdleverseU8&&!Upgradelogic.IV8Unlocked){
            JButton IdleverseUpgrade8 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV8Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade8);
            Upgradelogic.IV8Unlocked = true;
            IdleverseUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV8Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade8);
                }
            });
        }else if(Upgradelogic.IdleverseU9&&!Upgradelogic.IV9Unlocked){
            JButton IdleverseUpgrade9 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV9Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade9);
            Upgradelogic.IV9Unlocked = true;
            IdleverseUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV9Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade9);
                }
            });
        }else if(Upgradelogic.IdleverseU10&&!Upgradelogic.IV10Unlocked){
            JButton IdleverseUpgrade10 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV10Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade10);
            Upgradelogic.IV10Unlocked = true;
            IdleverseUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV10Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade10);
                }
            });
        }else if(Upgradelogic.IdleverseU11&&!Upgradelogic.IV11Unlocked){
            JButton IdleverseUpgrade11 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV11Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade11);
            Upgradelogic.IV11Unlocked = true;
            IdleverseUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV11Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade11);
                }
            });
        }else if(Upgradelogic.IdleverseU12&&!Upgradelogic.IV12Unlocked){
            JButton IdleverseUpgrade12 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV12Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade12);
            Upgradelogic.IV12Unlocked = true;
            IdleverseUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV12Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade12);
                }
            });
        }else if(Upgradelogic.IdleverseU13&&!Upgradelogic.IV13Unlocked){
            JButton IdleverseUpgrade13 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV13Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade13);
            Upgradelogic.IV13Unlocked = true;
            IdleverseUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV13Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade13);
                }
            });
        }else if(Upgradelogic.IdleverseU14&&!Upgradelogic.IV14Unlocked){
            JButton IdleverseUpgrade14 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV14Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade14);
            Upgradelogic.IV14Unlocked = true;
            IdleverseUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV14Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade14);
                }
            });
        }else if(Upgradelogic.IdleverseU15&&!Upgradelogic.IV15Unlocked){
            JButton IdleverseUpgrade15 = new JButton("x2 CPS From Idleverse | Cost: "+Upgradelogic.IV15Cost+" Cookies");
            UpgradesPanel.add(IdleverseUpgrade15);
            Upgradelogic.IV15Unlocked = true;
            IdleverseUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.IV15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.IV15Cost));
                    Upgradelogic.IdleverseCPSMult = Upgradelogic.IdleverseCPSMult * 2;
                    UpgradesPanel.remove(IdleverseUpgrade15);
                }
            });
        }
    }
    //CortexBakeryCPSUpgrade
    public void CortexBakeryUpgradeCheck(){
        if(Upgradelogic.CortexBakerU1&&!Upgradelogic.CB1Unlocked) {
            JButton CortexBUpgrade1 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB1Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade1);
            Upgradelogic.CB1Unlocked = true;
            CortexBUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB1Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade1);
                }
            });
        }else if(Upgradelogic.CortexBakerU2&&!Upgradelogic.CB2Unlocked){
            JButton CortexBUpgrade2 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB2Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade2);
            Upgradelogic.CB2Unlocked = true;
            CortexBUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB2Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade2);
                }
            });
        }else if(Upgradelogic.CortexBakerU3&&!Upgradelogic.CB3Unlocked){
            JButton CortexBUpgrade3 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB3Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade3);
            Upgradelogic.CB3Unlocked = true;
            CortexBUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB3Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade3);
                }
            });
        }else if(Upgradelogic.CortexBakerU4&&!Upgradelogic.CB4Unlocked){
            JButton CortexBUpgrade4 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB4Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade4);
            Upgradelogic.CB4Unlocked = true;
            CortexBUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB4Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade4);
                }
            });
        }else if(Upgradelogic.CortexBakerU5&&!Upgradelogic.CB5Unlocked){
            JButton CortexBUpgrade5 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB5Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade5);
            Upgradelogic.CB5Unlocked = true;
            CortexBUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB5Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade5);
                }
            });
        }else if(Upgradelogic.CortexBakerU6&&!Upgradelogic.CB6Unlocked){
            JButton CortexBUpgrade6 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB6Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade6);
            Upgradelogic.CB6Unlocked = true;
            CortexBUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB6Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade6);
                }
            });
        }else if(Upgradelogic.CortexBakerU7&&!Upgradelogic.CB7Unlocked){
            JButton CortexBUpgrade7 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB7Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade7);
            Upgradelogic.CB7Unlocked = true;
            CortexBUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB7Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade7);
                }
            });
        }else if(Upgradelogic.CortexBakerU8&&!Upgradelogic.CB8Unlocked){
            JButton CortexBUpgrade8 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB8Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade8);
            Upgradelogic.CB8Unlocked = true;
            CortexBUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB8Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade8);
                }
            });
        }else if(Upgradelogic.CortexBakerU9&&!Upgradelogic.CB9Unlocked){
            JButton CortexBUpgrade9 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB9Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade9);
            Upgradelogic.CB9Unlocked = true;
            CortexBUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB9Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade9);
                }
            });
        }else if(Upgradelogic.CortexBakerU10&&!Upgradelogic.CB10Unlocked){
            JButton CortexBUpgrade10 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB10Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade10);
            Upgradelogic.CB10Unlocked = true;
            CortexBUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB10Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade10);
                }
            });
        }else if(Upgradelogic.CortexBakerU11&&!Upgradelogic.CB11Unlocked){
            JButton CortexBUpgrade11 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB11Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade11);
            Upgradelogic.CB11Unlocked = true;
            CortexBUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB11Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade11);
                }
            });
        }else if(Upgradelogic.CortexBakerU12&&!Upgradelogic.CB12Unlocked){
            JButton CortexBUpgrade12 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB12Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade12);
            Upgradelogic.CB12Unlocked = true;
            CortexBUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB12Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade12);
                }
            });
        }else if(Upgradelogic.CortexBakerU13&&!Upgradelogic.CB13Unlocked){
            JButton CortexBUpgrade13 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB13Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade13);
            Upgradelogic.CB13Unlocked = true;
            CortexBUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB13Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade13);
                }
            });
        }else if(Upgradelogic.CortexBakerU14&&!Upgradelogic.CB14Unlocked){
            JButton CortexBUpgrade14 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB14Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade14);
            Upgradelogic.CB14Unlocked = true;
            CortexBUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB14Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade14);
                }
            });
        }else if(Upgradelogic.CortexBakerU15&&!Upgradelogic.CB15Unlocked){
            JButton CortexBUpgrade15 = new JButton("x2 CPS From Cortex Bakery | Cost: "+Upgradelogic.CB15Cost+" Cookies");
            UpgradesPanel.add(CortexBUpgrade15);
            Upgradelogic.CB15Unlocked = true;
            CortexBUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.CB15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.CB15Cost));
                    Upgradelogic.CortexBakerCPSMult = Upgradelogic.CortexBakerCPSMult * 2;
                    UpgradesPanel.remove(CortexBUpgrade15);
                }
            });
        }
    }
    //YouCPSUpgrade
    public void YouUpgradeCheck(){
        if(Upgradelogic.YouU1&&!Upgradelogic.Y1Unlocked) {
            JButton YouUpgrade1 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y1Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade1);
            Upgradelogic.Y1Unlocked = true;
            YouUpgrade1.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y1Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y1Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade1);
                }
            });
        }else if(Upgradelogic.YouU2&&!Upgradelogic.Y2Unlocked){
            JButton YouUpgrade2 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y2Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade2);
            Upgradelogic.Y2Unlocked = true;
            YouUpgrade2.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y2Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y2Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade2);
                }
            });
        }else if(Upgradelogic.YouU3&&!Upgradelogic.Y3Unlocked){
            JButton YouUpgrade3 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y3Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade3);
            Upgradelogic.Y3Unlocked = true;
            YouUpgrade3.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y3Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y3Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade3);
                }
            });
        }else if(Upgradelogic.YouU4&&!Upgradelogic.Y4Unlocked){
            JButton YouUpgrade4 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y4Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade4);
            Upgradelogic.Y4Unlocked = true;
            YouUpgrade4.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y4Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y4Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade4);
                }
            });
        }else if(Upgradelogic.YouU5&&!Upgradelogic.Y5Unlocked){
            JButton YouUpgrade5 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y5Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade5);
            Upgradelogic.Y5Unlocked = true;
            YouUpgrade5.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y5Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y5Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade5);
                }
            });
        }else if(Upgradelogic.YouU6&&!Upgradelogic.Y6Unlocked){
            JButton YouUpgrade6 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y6Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade6);
            Upgradelogic.Y6Unlocked = true;
            YouUpgrade6.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y6Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y6Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade6);
                }
            });
        }else if(Upgradelogic.YouU7&&!Upgradelogic.Y7Unlocked){
            JButton YouUpgrade7 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y7Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade7);
            Upgradelogic.Y7Unlocked = true;
            YouUpgrade7.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y7Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y7Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade7);
                }
            });
        }else if(Upgradelogic.YouU8&&!Upgradelogic.Y8Unlocked){
            JButton YouUpgrade8 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y8Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade8);
            Upgradelogic.Y8Unlocked = true;
            YouUpgrade8.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y8Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y8Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade8);
                }
            });
        }else if(Upgradelogic.YouU9&&!Upgradelogic.Y9Unlocked){
            JButton YouUpgrade9 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y9Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade9);
            Upgradelogic.Y9Unlocked = true;
            YouUpgrade9.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y9Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y9Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade9);
                }
            });
        }else if(Upgradelogic.YouU10&&!Upgradelogic.Y10Unlocked){
            JButton YouUpgrade10 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y10Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade10);
            Upgradelogic.Y10Unlocked = true;
            YouUpgrade10.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y10Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y10Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade10);
                }
            });
        }else if(Upgradelogic.YouU11&&!Upgradelogic.Y11Unlocked){
            JButton YouUpgrade11 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y11Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade11);
            Upgradelogic.Y11Unlocked = true;
            YouUpgrade11.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y11Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y11Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade11);
                }
            });
        }else if(Upgradelogic.YouU12&&!Upgradelogic.Y12Unlocked){
            JButton YouUpgrade12 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y12Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade12);
            Upgradelogic.Y12Unlocked = true;
            YouUpgrade12.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y12Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y12Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade12);
                }
            });
        }else if(Upgradelogic.YouU13&&!Upgradelogic.Y13Unlocked){
            JButton YouUpgrade13 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y13Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade13);
            Upgradelogic.Y13Unlocked = true;
            YouUpgrade13.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y13Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y13Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade13);
                }
            });
        }else if(Upgradelogic.YouU14&&!Upgradelogic.Y14Unlocked){
            JButton YouUpgrade14 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y14Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade14);
            Upgradelogic.Y14Unlocked = true;
            YouUpgrade14.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y14Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y14Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade14);
                }
            });
        }else if(Upgradelogic.YouU15&&!Upgradelogic.Y15Unlocked){
            JButton YouUpgrade15 = new JButton("x2 CPS From You | Cost: "+Upgradelogic.Y15Cost+" Cookies");
            UpgradesPanel.add(YouUpgrade15);
            Upgradelogic.Y15Unlocked = true;
            YouUpgrade15.addActionListener(_ -> {
                if (BuildingLogic.getCookieCount().compareTo(new BigDecimal(Upgradelogic.Y15Cost)) >= 0) {
                    BuildingLogic.cookieCount = BuildingLogic.getCookieCount().subtract(new BigDecimal(Upgradelogic.Y15Cost));
                    Upgradelogic.YouCPSMult = Upgradelogic.YouCPSMult * 2;
                    UpgradesPanel.remove(YouUpgrade15);
                }
            });
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}