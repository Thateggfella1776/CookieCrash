import java.math.BigDecimal;
import java.util.TimerTask;
import java.util.Timer;
import java.math.BigInteger;


public class Buildings {

    //variables and such
    BigDecimal cookieCount = new BigDecimal ("0.0");
    BigDecimal CookiesPerClick = new BigDecimal("1.0");
    BigDecimal CookiesPerSecond = new BigDecimal("0.0");
    Upgrades CPSMults = new Upgrades(this);;
    int CursorPurchases = 0;
    int CursorBaseCost = 15;
    int GrandmaPurchases = 0;
    int GrandmaBaseCost = 100;
    int FarmPurchases = 0;
    int FarmBaseCost = 1_100;
    int MinePurchases = 0;
    int MineBaseCost = 12_000;
    int FactoryPurchases = 0;
    int FactoryBaseCost = 130_000;
    int BankPurchases = 0;
    int BankBaseCost = 1_400_000;
    int TemplePurchases = 0;
    int TempleBaseCost = 20_000_000;
    int WizardTowerPurchases = 0;
    int WizardTowerBaseCost = 330_000_000;
    int ShipmentPurchases = 0;
    long ShipmentBaseCost = 5_100_000_000L;
    int AlchemyLabPurchases = 0;
    long AlchemyLabBaseCost = 75_000_000_000L;
    int PortalPurchases = 0;
    long PortalBaseCost = 1_000_000_000_000L;
    int TimeMachinePurchases = 0;
    long TimeMachineBaseCost = 14_000_000_000_000L;
    int AntimatterCondenserPurchases = 0;
    long AntimatterCondenserBaseCost = 170_000_000_000_000L;
    int PrismPurchases = 0;
    long PrismBaseCost = 2_100_000_000_000_000L;
    int ChancemakerPurchases = 0;
    long ChancemakerBaseCost = 26_000_000_000_000_000L;
    int FractalEnginePurchases = 0;
    long FractalEngineBaseCost = 310_000_000_000_000_000L;
    int JavaConsolePurchases = 0;
    BigInteger JavaConsoleBaseCost = new BigInteger("71000000000000000000");
    int IdleversePurchases = 0;
    BigInteger IdleverseBaseCost = new BigInteger("12000000000000000000000");
    int CortexBakerPurchases = 0;
    BigInteger CortexBakerBaseCost = new BigInteger("1900000000000000000000000");
    int YouPurchases = 0;
    BigInteger YouBaseCost = new BigInteger("540000000000000000000000000");
    Timer CPSTimer = new Timer();



    //return for necessary variables
    public BigDecimal getCookieCount(){return cookieCount;}
    public BigDecimal getCookiesPerClick(){return CookiesPerClick;}
    public BigDecimal getCookiesPerSecond(){return CookiesPerSecond;}
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
                cookieCount=(cookieCount.add(CookiesPerSecond)).multiply(BigDecimal.valueOf(CPSMults.getBaseCPSMult()));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(CPSMults.getCursorCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1).multiply(BigDecimal.valueOf(CPSMults.getGrandmaCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(CPSMults.getFarmCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(47).multiply(BigDecimal.valueOf(CPSMults.getMineCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(260).multiply(BigDecimal.valueOf(CPSMults.getFactoryCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1400).multiply(BigDecimal.valueOf(CPSMults.getBankCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(7800).multiply(BigDecimal.valueOf(CPSMults.getTempleCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(44000L).multiply(BigDecimal.valueOf(CPSMults.getWizardTowerCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(2200000L).multiply(BigDecimal.valueOf(CPSMults.getShipmentCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1600000L).multiply(BigDecimal.valueOf(CPSMults.getAlchemyLabCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(10000000L).multiply(BigDecimal.valueOf(CPSMults.getPortalCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(65000000L).multiply(BigDecimal.valueOf(CPSMults.getTimeMachineCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(430000000L).multiply(BigDecimal.valueOf(CPSMults.getAntimatterCondenserCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(2900000000L).multiply(BigDecimal.valueOf(CPSMults.getPrismCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(21000000000L).multiply(BigDecimal.valueOf(CPSMults.getChancemakerCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(150000000000L).multiply(BigDecimal.valueOf(CPSMults.getFractalEngineCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1100000000000L).multiply(BigDecimal.valueOf(CPSMults.getJavaConsoleCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(8300000000000L).multiply(BigDecimal.valueOf(CPSMults.getIdleverseCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(64000000000000L).multiply(BigDecimal.valueOf(CPSMults.getCortexBakerCPSMult())));
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
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(510000000000000L).multiply(BigDecimal.valueOf(CPSMults.getYouCPSMult())));
            return true;
        }
        return false;
    }
}