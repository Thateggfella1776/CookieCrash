import java.math.BigDecimal;
import java.util.TimerTask;
import java.util.Timer;
import java.math.BigInteger;


public class Buildings {

    //variables and such
    BigDecimal cookieCount = new BigDecimal ("0.0");
    BigDecimal CookiesPerClick = new BigDecimal("1.0");
    BigDecimal CookiesPerSecond = new BigDecimal("0.0");
    Upgrades UpgradeLogic;
    int CursorPurchases = 0;
    int CursorBaseCost = 15;
    BigDecimal CursorCPS = BigDecimal.valueOf(0d);
    int GrandmaPurchases = 0;
    int GrandmaBaseCost = 100;
    BigDecimal GrandmaCPS = BigDecimal.valueOf(0d);
    int FarmPurchases = 0;
    int FarmBaseCost = 1_100;
    BigDecimal FarmCPS = BigDecimal.valueOf(0d);
    int MinePurchases = 0;
    int MineBaseCost = 12_000;
    BigDecimal MineCPS = BigDecimal.valueOf(0d);
    int FactoryPurchases = 0;
    int FactoryBaseCost = 130_000;
    BigDecimal FactoryCPS = BigDecimal.valueOf(0d);
    int BankPurchases = 0;
    int BankBaseCost = 1_400_000;
    BigDecimal BankCPS = BigDecimal.valueOf(0d);
    int TemplePurchases = 0;
    int TempleBaseCost = 20_000_000;
    BigDecimal TempleCPS = BigDecimal.valueOf(0d);
    int WizardTowerPurchases = 0;
    int WizardTowerBaseCost = 330_000_000;
    BigDecimal WizardTowerCPS = BigDecimal.valueOf(0d);
    int ShipmentPurchases = 0;
    long ShipmentBaseCost = 5_100_000_000L;
    BigDecimal ShipmentCPS = BigDecimal.valueOf(0d);
    int AlchemyLabPurchases = 0;
    long AlchemyLabBaseCost = 75_000_000_000L;
    BigDecimal AlchemyLabCPS = BigDecimal.valueOf(0d);
    int PortalPurchases = 0;
    long PortalBaseCost = 1_000_000_000_000L;
    BigDecimal PortalCPS = BigDecimal.valueOf(0d);
    int TimeMachinePurchases = 0;
    long TimeMachineBaseCost = 14_000_000_000_000L;
    BigDecimal TimeMachineCPS = BigDecimal.valueOf(0d);
    int AntimatterCondenserPurchases = 0;
    long AntimatterCondenserBaseCost = 170_000_000_000_000L;
    BigDecimal AntimatterCondenserCPS = BigDecimal.valueOf(0d);
    int PrismPurchases = 0;
    long PrismBaseCost = 2_100_000_000_000_000L;
    BigDecimal PrismCPS = BigDecimal.valueOf(0d);
    int ChancemakerPurchases = 0;
    long ChancemakerBaseCost = 26_000_000_000_000_000L;
    BigDecimal ChancemakerCPS = BigDecimal.valueOf(0d);
    int FractalEnginePurchases = 0;
    long FractalEngineBaseCost = 310_000_000_000_000_000L;
    BigDecimal FractalEngineCPS = BigDecimal.valueOf(0d);
    int JavaConsolePurchases = 0;
    BigInteger JavaConsoleBaseCost = new BigInteger("71000000000000000000");
    BigDecimal JavaConsoleCPS = BigDecimal.valueOf(0d);
    int IdleversePurchases = 0;
    BigInteger IdleverseBaseCost = new BigInteger("12000000000000000000000");
    BigDecimal IdleverseCPS = BigDecimal.valueOf(0d);
    int CortexBakerPurchases = 0;
    BigInteger CortexBakerBaseCost = new BigInteger("1900000000000000000000000");
    BigDecimal CortexBakerCPS = BigDecimal.valueOf(0d);
    int YouPurchases = 0;
    BigInteger YouBaseCost = new BigInteger("540000000000000000000000000");
    BigDecimal YouCPS = BigDecimal.valueOf(0d);
    Timer CPSTimer = new Timer();



    //return for necessary variables
    public BigDecimal getCookieCount(){return cookieCount;}
    public BigDecimal getCookiesPerClick(){return CookiesPerClick;}
    public BigDecimal getCookiesPerSecond(){return CookiesPerSecond =
            CursorCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getCursorCPSMult()))
                    .add(GrandmaCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getGrandmaCPSMult())))
                    .add(FarmCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getFarmCPSMult())))
                    .add(MineCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getMineCPSMult())))
                    .add(FactoryCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getFactoryCPSMult())))
                    .add(BankCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getBankCPSMult())))
                    .add(TempleCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getTempleCPSMult())))
                    .add(WizardTowerCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getWizardTowerCPSMult())))
                    .add(ShipmentCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getShipmentCPSMult())))
                    .add(AlchemyLabCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getAlchemyLabCPSMult())))
                    .add(PortalCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getPortalCPSMult())))
                    .add(TimeMachineCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getTimeMachineCPSMult())))
                    .add(AntimatterCondenserCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getAntimatterCondenserCPSMult())))
                    .add(PrismCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getPrismCPSMult())))
                    .add(ChancemakerCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getChancemakerCPSMult())))
                    .add(FractalEngineCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getFractalEngineCPSMult())))
                    .add(JavaConsoleCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getJavaConsoleCPSMult())))
                    .add(IdleverseCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getIdleverseCPSMult())))
                    .add(CortexBakerCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getCortexBakerCPSMult())))
                    .add(YouCPS.multiply(BigDecimal.valueOf(UpgradeLogic.getYouCPSMult())))
                    .multiply(BigDecimal.valueOf(UpgradeLogic.getBaseCPSMult()));
    }
    public int getCursorPurchases(){return CursorPurchases;}
    public int getGrandmaPurchases(){return GrandmaPurchases;}
    public int getFarmPurchases(){return FarmPurchases;}
    public int getMinePurchases(){return MinePurchases;}
    public int getFactoryPurchases(){return FactoryPurchases;}
    public int getBankPurchases(){return BankPurchases;}
    public int getTemplePurchases(){return TemplePurchases;}
    public int getWizardTowerPurchases(){return WizardTowerPurchases;}
    public int getShipmentPurchases(){return ShipmentPurchases;}
    public int getAlchemyLabPurchases(){return AlchemyLabPurchases;}
    public int getPortalPurchases(){return PortalPurchases;}
    public int getTimeMachinePurchases(){return TimeMachinePurchases;}
    public int getAntimatterCondenserPurchases(){return AntimatterCondenserPurchases;}
    public int getPrismPurchases(){return PrismPurchases;}
    public int getChancemakerPurchases(){return ChancemakerPurchases;}
    public int getFractalEnginePurchases(){return FractalEnginePurchases;}
    public int getJavaConsolePurchases(){return JavaConsolePurchases;}
    public int getIdleversePurchases(){return IdleversePurchases;}
    public int getCortexBakerPurchases(){return CortexBakerPurchases;}
    public int getYouPurchases(){return YouPurchases;}

    public void Click(){
        cookieCount = cookieCount.add(CookiesPerClick);
    }

    public void AutoTimer() {
        CPSTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                cookieCount=cookieCount.add(CursorCPS)
                        .add(GrandmaCPS)
                        .add(FarmCPS)
                        .add(MineCPS)
                        .add(FactoryCPS)
                        .add(BankCPS)
                        .add(TempleCPS)
                        .add(WizardTowerCPS)
                        .add(ShipmentCPS)
                        .add(AlchemyLabCPS)
                        .add(PortalCPS)
                        .add(TimeMachineCPS)
                        .add(AntimatterCondenserCPS)
                        .add(PrismCPS)
                        .add(ChancemakerCPS)
                        .add(FractalEngineCPS)
                        .add(JavaConsoleCPS)
                        .add(IdleverseCPS)
                        .add(CortexBakerCPS)
                        .add(YouCPS);
            }
        },0,1000);
    }

    public int getCursorCost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(CursorBaseCost *Math.pow(1.15, CursorPurchases));
    }
    public boolean buyCursor(){
        int cost = getCursorCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            CursorPurchases++;
            CursorCPS=CursorCPS.add(BigDecimal.valueOf(0.1));
            return true;
        }
        return false;
    }

    public int getGrandmaCost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(GrandmaBaseCost *Math.pow(1.15, GrandmaPurchases));}

    public boolean buyGrandma(){
        int cost = getGrandmaCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            GrandmaPurchases++;
            GrandmaCPS=GrandmaCPS.add(BigDecimal.valueOf(1));
            return true;
        }
        return false;
    }

    public int getFarmCost(){return (int) Math.round(FarmBaseCost *Math.pow(1.15, FarmPurchases));}
    public boolean buyFarm(){
        int cost = getFarmCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            FarmPurchases++;
            FarmCPS=FarmCPS.add(BigDecimal.valueOf(8));
            return true;
        }
        return false;
    }

    public int getMineCost(){return (int) Math.round(MineBaseCost *Math.pow(1.15, MinePurchases));}
    public boolean buyMine(){
        int cost = getMineCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            MinePurchases++;
            MineCPS=MineCPS.add(BigDecimal.valueOf(47));
            return true;
        }
        return false;
    }

    public int getFactoryCost(){return (int) Math.round(FactoryBaseCost *Math.pow(1.15, FactoryPurchases));}
    public boolean buyFactory(){
        int cost = getFactoryCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            FactoryPurchases++;
            FactoryCPS=FactoryCPS.add(BigDecimal.valueOf(260));
            return true;
        }
        return false;
    }

    public int getBankCost(){return (int) Math.round(BankBaseCost *Math.pow(1.15, BankPurchases));    }
    public boolean buyBank(){
        int cost = getBankCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            BankPurchases++;
            BankCPS=BankCPS.add(BigDecimal.valueOf(1400));
            return true;
        }
        return false;
    }

    public int getTempleCost(){return (int) Math.round(TempleBaseCost *Math.pow(1.15, TemplePurchases));    }
    public boolean buyTemple(){
        int cost = getTempleCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            TemplePurchases++;
            TempleCPS=TempleCPS.add(BigDecimal.valueOf(7800));
            return true;
        }
        return false;
    }

    public int getWizardTowerCost(){return (int) Math.round(WizardTowerBaseCost *Math.pow(1.15, WizardTowerPurchases));}
    public boolean buyWizardTower(){
        int cost = getWizardTowerCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            WizardTowerPurchases++;
            WizardTowerCPS=WizardTowerCPS.add(BigDecimal.valueOf(44000L));
            return true;
        }
        return false;
    }

    public int getShipmentCost(){return (int) Math.round(ShipmentBaseCost *Math.pow(1.15, ShipmentPurchases));}
    public boolean buyShipment(){
        int cost = getShipmentCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            ShipmentPurchases++;
            ShipmentCPS=ShipmentCPS.add(BigDecimal.valueOf(2200000L).multiply(BigDecimal.valueOf(UpgradeLogic.getShipmentCPSMult())));
            return true;
        }
        return false;
    }

    public long getAlchemyLabCost(){return Math.round(AlchemyLabBaseCost *Math.pow(1.15, AlchemyLabPurchases));}
    public boolean buyAlchemyLab(){
        long cost = getAlchemyLabCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            AlchemyLabPurchases++;
            AlchemyLabCPS=AlchemyLabCPS.add(BigDecimal.valueOf(1600000L));
            return true;
        }
        return false;
    }

    public long getPortalCost(){return Math.round(PortalBaseCost *Math.pow(1.15, PortalPurchases));}
    public boolean buyPortal(){
        long cost = getPortalCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            PortalPurchases++;
            PortalCPS=PortalCPS.add(BigDecimal.valueOf(10000000L));
            return true;
        }
        return false;
    }

    public long getTimeMachineCost(){return Math.round(TimeMachineBaseCost *Math.pow(1.15, TimeMachinePurchases));}
    public boolean buyTimeMachine(){
        long cost = getTimeMachineCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            TimeMachinePurchases++;
            TimeMachineCPS=TimeMachineCPS.add(BigDecimal.valueOf(65000000L));
            return true;
        }
        return false;
    }

    public long getAntimatterCondenserCost(){return Math.round(AntimatterCondenserBaseCost *Math.pow(1.15, AntimatterCondenserPurchases));}
    public boolean buyAntimatterCondenser(){
        long cost = getAntimatterCondenserCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            AntimatterCondenserPurchases++;
            AntimatterCondenserCPS=AntimatterCondenserCPS.add(BigDecimal.valueOf(430000000L));
            return true;
        }
        return false;
    }

    public long getPrismCost(){return Math.round(PrismBaseCost *Math.pow(1.15, PrismPurchases));}
    public boolean buyPrism(){
        long cost = getPrismCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            PrismPurchases++;
            PrismCPS=PrismCPS.add(BigDecimal.valueOf(2900000000L));
            return true;
        }
        return false;
    }

    public long getChancemakerCost(){return Math.round(ChancemakerBaseCost *Math.pow(1.15, ChancemakerPurchases));}
    public boolean buyChancemaker(){
        long cost = getChancemakerCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            ChancemakerPurchases++;
            ChancemakerCPS=ChancemakerCPS.add(BigDecimal.valueOf(21000000000L));
            return true;
        }
        return false;
    }

    public long getFractalEngineCost(){return Math.round(FractalEngineBaseCost *Math.pow(1.15, FractalEnginePurchases));}
    public boolean buyFractalEngine(){
        long cost = getFractalEngineCost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            FractalEnginePurchases++;
            FractalEngineCPS=FractalEngineCPS.add(BigDecimal.valueOf(150000000000L));
            return true;
        }
        return false;
    }

    public BigDecimal getJavaConsoleCost(){return new BigDecimal(JavaConsoleBaseCost).multiply(BigDecimal.valueOf(1.15).pow(JavaConsolePurchases));}
    public boolean buyJavaConsole(){
        BigDecimal cost = getJavaConsoleCost();
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            JavaConsolePurchases++;
            JavaConsoleCPS=JavaConsoleCPS.add(BigDecimal.valueOf(1100000000000L));
            return true;
        }
        return false;
    }

    public BigDecimal getIdleverseCost(){return new BigDecimal(IdleverseBaseCost).multiply(BigDecimal.valueOf(1.15).pow(IdleversePurchases));}
    public boolean buyIdleverse(){
        BigDecimal cost = getIdleverseCost();
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            IdleversePurchases++;
            IdleverseCPS=IdleverseCPS.add(BigDecimal.valueOf(8300000000000L));
            return true;
        }
        return false;
    }

    public BigDecimal getCortexBakerCost(){return new BigDecimal(CortexBakerBaseCost).multiply(BigDecimal.valueOf(1.15).pow(CortexBakerPurchases));}
    public boolean buyCortexBaker(){
        BigDecimal cost = getCortexBakerCost();
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            CortexBakerPurchases++;
            CortexBakerCPS=CortexBakerCPS.add(BigDecimal.valueOf(64000000000000L));
            return true;
        }
        return false;
    }

    public BigDecimal getYouCost(){return new BigDecimal(YouBaseCost).multiply(BigDecimal.valueOf(1.15).pow(YouPurchases));}
    public boolean buyYou(){
        BigDecimal cost = getYouCost();
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            YouPurchases++;
            YouCPS=YouCPS.add(BigDecimal.valueOf(510000000000000L));
            return true;
        }
        return false;
    }
    public void CPSpostLoad() {
        CursorCPS = BigDecimal.valueOf(CursorPurchases * 0.1);
        GrandmaCPS = BigDecimal.valueOf(GrandmaPurchases);
        FarmCPS = BigDecimal.valueOf(FarmPurchases * 8);
        MineCPS = BigDecimal.valueOf(MinePurchases * 47);
        FactoryCPS = BigDecimal.valueOf(FactoryPurchases * 260);
        BankCPS = BigDecimal.valueOf(BankPurchases * 1400);
        TempleCPS = BigDecimal.valueOf(TemplePurchases * 7800);
        WizardTowerCPS = BigDecimal.valueOf(WizardTowerPurchases * 44000L);
        ShipmentCPS = BigDecimal.valueOf(ShipmentPurchases * 260000L);
        AlchemyLabCPS = BigDecimal.valueOf(AlchemyLabPurchases * 1600000L);
        PortalCPS = BigDecimal.valueOf(PortalPurchases * 10000000L);
        TimeMachineCPS = BigDecimal.valueOf(TimeMachinePurchases * 65000000L);
        AntimatterCondenserCPS = BigDecimal.valueOf(AntimatterCondenserPurchases * 430000000L);
        PrismCPS = BigDecimal.valueOf(PrismPurchases * 2900000000L);
        ChancemakerCPS = BigDecimal.valueOf(ChancemakerPurchases * 21000000000L);
        FractalEngineCPS = BigDecimal.valueOf(FractalEnginePurchases * 150000000000L);
        JavaConsoleCPS = BigDecimal.valueOf(JavaConsolePurchases * 1100000000000L);
        IdleverseCPS = BigDecimal.valueOf(IdleversePurchases * 8300000000000L);
        CortexBakerCPS = new BigDecimal("64000000000000").multiply(BigDecimal.valueOf(CortexBakerPurchases));
        YouCPS = new BigDecimal("500000000000000").multiply(BigDecimal.valueOf(YouPurchases));
    }
}