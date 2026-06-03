import java.math.BigInteger;

class Upgrades {

    Buildings BuildingLogic;

    public Upgrades(Buildings buildings) {
        this.BuildingLogic = buildings;
    }

    double BaseCPSMult=1.0;
    double CursorCPSMult=1.0;
    boolean CursorU1 = false;
    int CursorU1Cost=500;
    boolean CU1Unlocked =false;
    boolean CursorU2 = false;
    int CursorU2Cost=100_000;
    boolean CU2Unlocked =false;
    boolean CursorU3 = false;
    int CursorU3Cost=10_000_000;
    boolean CU3Unlocked =false;
    boolean CursorU4 = false;
    int CursorU4Cost=1_000_000_000;
    boolean CU4Unlocked =false;
    boolean CursorU5 = false;
    long CursorU5Cost= 100000000000L;
    boolean CU5Unlocked =false;
    boolean CursorU6 = false;
    long CursorU6Cost=10000000000000L;
    boolean CU6Unlocked =false;
    boolean CursorU7 = false;
    long CursorU7Cost=1000000000000000L;
    boolean CU7Unlocked =false;
    boolean CursorU8 = false;
    long CursorU8Cost=10000000000000000L;
    boolean CU8Unlocked =false;
    boolean CursorU9 = false;
    BigInteger CursorU9Cost= new BigInteger("10000000000000000000");
    boolean CU9Unlocked =false;
    boolean CursorU10 = false;
    BigInteger CursorU10Cost=new BigInteger("10000000000000000000000");
    boolean CU10Unlocked =false;
    boolean CursorU11 = false;
    BigInteger CursorU11Cost=new BigInteger("10000000000000000000000000");
    boolean CU11Unlocked =false;
    boolean CursorU12 = false;
    BigInteger CursorU12Cost=new BigInteger("10000000000000000000000000000");
    boolean CU12Unlocked =false;
    boolean CursorU13 = false;
    BigInteger CursorU13Cost=new BigInteger("10000000000000000000000000000000");
    boolean CU13Unlocked =false;
    boolean CursorU14 = false;
    BigInteger CursorU14Cost=new BigInteger("10000000000000000000000000000000000");
    boolean CU14Unlocked =false;

    double GrandmaCPSMult=1.0;
    boolean GrandmaU1 = false;
    int GrandmaU1Cost=1_000;
    boolean GU1Unlocked =false;
    boolean GrandmaU2 = false;
    int GrandmaU2Cost=5_000;
    boolean GU2Unlocked =false;
    boolean GrandmaU3 = false;
    int GrandmaU3Cost=50_000;
    boolean GU3Unlocked =false;
    boolean GrandmaU4 = false;
    int GrandmaU4Cost=5_000_000;
    boolean GU4Unlocked =false;
    boolean GrandmaU5 = false;
    long GrandmaU5Cost= 500000000L;
    boolean GU5Unlocked =false;
    boolean GrandmaU6 = false;
    long GrandmaU6Cost=50000000000L;
    boolean GU6Unlocked =false;
    boolean GrandmaU7 = false;
    long GrandmaU7Cost=50000000000000L;
    boolean GU7Unlocked =false;
    boolean GrandmaU8 = false;
    long GrandmaU8Cost=50000000000000000L;
    boolean GU8Unlocked =false;
    boolean GrandmaU9 = false;
    BigInteger GrandmaU9Cost= new BigInteger("50000000000000000000");
    boolean GU9Unlocked =false;
    boolean GrandmaU10 = false;
    BigInteger GrandmaU10Cost=new BigInteger("50000000000000000000000");
    boolean GU10Unlocked =false;
    boolean GrandmaU11 = false;
    BigInteger GrandmaU11Cost=new BigInteger("500000000000000000000000000");
    boolean GU11Unlocked =false;
    boolean GrandmaU12 = false;
    BigInteger GrandmaU12Cost=new BigInteger("5000000000000000000000000000000");
    boolean GU12Unlocked =false;
    boolean GrandmaU13 = false;
    BigInteger GrandmaU13Cost=new BigInteger("5000000000000000000000000000000000");
    boolean GU13Unlocked =false;
    boolean GrandmaU14 = false;
    BigInteger GrandmaU14Cost=new BigInteger("5000000000000000000000000000000000000");
    boolean GU14Unlocked =false;
    boolean GrandmaU15 = false;
    BigInteger GrandmaU15Cost=new BigInteger("500000000000000000000000000000000000000000");
    boolean GU15Unlocked =false;


    double FarmCPSMult=1.0;
    boolean FarmU1 = false;
    int FarmU1Cost=11_000;
    boolean FU1Unlocked =false;
    boolean FarmU2 = false;
    int FarmU2Cost=55_000;
    boolean FU2Unlocked =false;
    boolean FarmU3 = false;
    int FarmU3Cost=550_000;
    boolean FU3Unlocked =false;
    boolean FarmU4 = false;
    int FarmU4Cost=55_000_000;
    boolean FU4Unlocked =false;
    boolean FarmU5 = false;
    long FarmU5Cost= 5500000000L;
    boolean FU5Unlocked =false;
    boolean FarmU6 = false;
    long FarmU6Cost=550000000000L;
    boolean FU6Unlocked =false;
    boolean FarmU7 = false;
    long FarmU7Cost=550000000000000L;
    boolean FU7Unlocked =false;
    boolean FarmU8 = false;
    long FarmU8Cost=550000000000000000L;
    boolean FU8Unlocked =false;
    boolean FarmU9 = false;
    BigInteger FarmU9Cost= new BigInteger("550000000000000000000");
    boolean FU9Unlocked =false;
    boolean FarmU10 = false;
    BigInteger FarmU10Cost=new BigInteger("550000000000000000000000");
    boolean FU10Unlocked =false;
    boolean FarmU11 = false;
    BigInteger FarmU11Cost=new BigInteger("5500000000000000000000000000");
    boolean FU11Unlocked =false;
    boolean FarmU12 = false;
    BigInteger FarmU12Cost=new BigInteger("55000000000000000000000000000000");
    boolean FU12Unlocked =false;
    boolean FarmU13 = false;
    BigInteger FarmU13Cost=new BigInteger("55000000000000000000000000000000000");
    boolean FU13Unlocked =false;
    boolean FarmU14 = false;
    BigInteger FarmU14Cost=new BigInteger("55000000000000000000000000000000000000");
    boolean FU14Unlocked =false;
    boolean FarmU15 = false;
    BigInteger FarmU15Cost=new BigInteger("550000000000000000000000000000000000000000");
    boolean FU15Unlocked =false;

    double MineCPSMult=1.0;
    boolean MineU1 = false;
    int MineU1Cost=120_000;
    boolean MU1Unlocked =false;
    boolean MineU2 = false;
    int MineU2Cost=600_000;
    boolean MU2Unlocked =false;
    boolean MineU3 = false;
    int MineU3Cost=6_000_000;
    boolean MU3Unlocked =false;
    boolean MineU4 = false;
    int MineU4Cost=60_000_000;
    boolean MU4Unlocked =false;
    boolean MineU5 = false;
    long MineU5Cost= 600000000L;
    boolean MU5Unlocked =false;
    boolean MineU6 = false;
    long MineU6Cost=60000000000L;
    boolean MU6Unlocked =false;
    boolean MineU7 = false;
    long MineU7Cost=6000000000000000L;
    boolean MU7Unlocked =false;
    boolean MineU8 = false;
    long MineU8Cost=6000000000000000000L;
    boolean MU8Unlocked =false;
    boolean MineU9 = false;
    BigInteger MineU9Cost= new BigInteger("6000000000000000000000");
    boolean MU9Unlocked =false;
    boolean MineU10 = false;
    BigInteger MineU10Cost=new BigInteger("6000000000000000000000000");
    boolean MU10Unlocked =false;
    boolean MineU11 = false;
    BigInteger MineU11Cost=new BigInteger("60000000000000000000000000000");
    boolean MU11Unlocked =false;
    boolean MineU12 = false;
    BigInteger MineU12Cost=new BigInteger("600000000000000000000000000000000");
    boolean MU12Unlocked =false;
    boolean MineU13 = false;
    BigInteger MineU13Cost=new BigInteger("600000000000000000000000000000000000");
    boolean MU13Unlocked =false;
    boolean MineU14 = false;
    BigInteger MineU14Cost=new BigInteger("600000000000000000000000000000000000000");
    boolean MU14Unlocked =false;
    boolean MineU15 = false;
    BigInteger MineU15Cost=new BigInteger("600000000000000000000000000000000000000000");
    boolean MU15Unlocked =false;

    double FactoryCPSMult=1.0;
    boolean FactoryU1 = false;
    int FAU1Cost=1_300_000;
    boolean FAU1Unlocked =false;
    boolean FactoryU2 = false;
    int FAU2Cost=6_500_000;
    boolean FAU2Unlocked =false;
    boolean FactoryU3 = false;
    int FAU3Cost=65_000_000;
    boolean FAU3Unlocked =false;
    boolean FactoryU4 = false;
    long FAU4Cost=6_500_000_000L;
    boolean FAU4Unlocked =false;
    boolean FactoryU5 = false;
    long FAU5Cost= 650_000_000_000L;
    boolean FAU5Unlocked =false;
    boolean FactoryU6 = false;
    long FAU6Cost=65_000_000_000_000L;
    boolean FAU6Unlocked =false;
    boolean FactoryU7 = false;
    long FAU7Cost=65_000_000_000_000_000L;
    boolean FAU7Unlocked =false;
    boolean FactoryU8 = false;
    BigInteger FAU8Cost=new BigInteger("65000000000000000000");
    boolean FAU8Unlocked =false;
    boolean FactoryU9 = false;
    BigInteger FAU9Cost= new BigInteger("65000000000000000000000");
    boolean FAU9Unlocked =false;
    boolean FactoryU10 = false;
    BigInteger FAU10Cost=new BigInteger("65000000000000000000000000");
    boolean FAU10Unlocked =false;
    boolean FactoryU11 = false;
    BigInteger FAU11Cost=new BigInteger("650000000000000000000000000000");
    boolean FAU11Unlocked =false;
    boolean FactoryU12 = false;
    BigInteger FAU12Cost=new BigInteger("650000000000000000000000000000000");
    boolean FAU12Unlocked =false;
    boolean FactoryU13 = false;
    BigInteger FAU13Cost=new BigInteger("650000000000000000000000000000000000");
    boolean FAU13Unlocked =false;
    boolean FactoryU14 = false;
    BigInteger FAU14Cost=new BigInteger("650000000000000000000000000000000000000");
    boolean FAU14Unlocked =false;
    boolean FactoryU15 = false;
    BigInteger FAU15Cost=new BigInteger("6500000000000000000000000000000000000000000");
    boolean FAU15Unlocked =false;


    double BankCPSMult=1.0;
    boolean BankU1 = false;
    int BU1Cost=14_000_000;
    boolean BU1Unlocked =false;
    boolean BankU2 = false;
    int BU2Cost=70_000_000;
    boolean BU2Unlocked =false;
    boolean BankU3 = false;
    int BU3Cost=700_000_000;
    boolean BU3Unlocked =false;
    boolean BankU4 = false;
    long BU4Cost=70_000_000_000L;
    boolean BU4Unlocked =false;
    boolean BankU5 = false;
    long BU5Cost= 7_000_000_000_000L;
    boolean BU5Unlocked =false;
    boolean BankU6 = false;
    long BU6Cost=700_000_000_000_000L;
    boolean BU6Unlocked =false;
    boolean BankU7 = false;
    long BU7Cost=700_000_000_000_000_000L;
    boolean BU7Unlocked =false;
    boolean BankU8 = false;
    BigInteger BU8Cost=new BigInteger("700000000000000000000");
    boolean BU8Unlocked =false;
    boolean BankU9 = false;
    BigInteger BU9Cost= new BigInteger("700000000000000000000000");
    boolean BU9Unlocked =false;
    boolean BankU10 = false;
    BigInteger BU10Cost=new BigInteger("700000000000000000000000000");
    boolean BU10Unlocked =false;
    boolean BankU11 = false;
    BigInteger BU11Cost=new BigInteger("7000000000000000000000000000000");
    boolean BU11Unlocked =false;
    boolean BankU12 = false;
    BigInteger BU12Cost=new BigInteger("7000000000000000000000000000000000");
    boolean BU12Unlocked =false;
    boolean BankU13 = false;
    BigInteger BU13Cost=new BigInteger("7000000000000000000000000000000000000");
    boolean BU13Unlocked =false;
    boolean BankU14 = false;
    BigInteger BU14Cost=new BigInteger("7000000000000000000000000000000000000000");
    boolean BU14Unlocked =false;
    boolean BankU15 = false;
    BigInteger BU15Cost=new BigInteger("7000000000000000000000000000000000000000000");
    boolean BU15Unlocked =false;

    double TempleCPSMult=1.0;

    double WizardTowerCPSMult=1.0;
    double ShipmentCPSMult=1.0;
    double AlchemyLabCPSMult=1.0;
    double PortalCPSMult=1.0;
    double TimeMachineCPSMult=1.0;
    double AntimatterCondenserCPSMult=1.0;
    double PrismCPSMult=1.0;
    double ChancemakerCPSMult=1.0;
    double FractalEngineCPSMult=1.0;
    double JavaConsoleCPSMult=1.0;
    double IdleverseCPSMult=1.0;
    double CortexBakerCPSMult=1.0;
    double YouCPSMult=1.0;

    //Returns for my mults
    public double getBaseCPSMult() {return BaseCPSMult;}
    public double getCursorCPSMult() {return CursorCPSMult;}
    public double getGrandmaCPSMult() {return GrandmaCPSMult;}
    public double getFarmCPSMult() {return FarmCPSMult;}
    public double getMineCPSMult() {return MineCPSMult;}
    public double getFactoryCPSMult() {return FactoryCPSMult;}
    public double getBankCPSMult() {return BankCPSMult;}
    public double getTempleCPSMult() {return TempleCPSMult;}
    public double getWizardTowerCPSMult() {return WizardTowerCPSMult;}
    public double getShipmentCPSMult() {return ShipmentCPSMult;}
    public double getAlchemyLabCPSMult() {return AlchemyLabCPSMult;}
    public double getPortalCPSMult() {return PortalCPSMult;}
    public double getTimeMachineCPSMult() {return TimeMachineCPSMult;}
    public double getAntimatterCondenserCPSMult() {return AntimatterCondenserCPSMult;}
    public double getPrismCPSMult() {return PrismCPSMult;}
    public double getChancemakerCPSMult() {return ChancemakerCPSMult;}
    public double getFractalEngineCPSMult() {return FractalEngineCPSMult;}
    public double getJavaConsoleCPSMult() {return JavaConsoleCPSMult;}
    public double getIdleverseCPSMult() {return IdleverseCPSMult;}
    public double getCortexBakerCPSMult() {return CortexBakerCPSMult;}
    public double getYouCPSMult() {return YouCPSMult;}


    //Switch Case For Building Upgrades
    public void CursorUpgrade(){
        switch (BuildingLogic.getCursorPurchases()) {
            case 1:
                CursorU1=true;
                CursorU2=true;
                break;
            case 25:
                CursorU3=true;
                break;
            case 50:
                CursorU4=true;
                break;
            case 100:
                CursorU5=true;
                break;
            case 150:
                CursorU6=true;
                break;
            case 200:
                CursorU7=true;
                break;
            case 250:
                CursorU8=true;
                break;
            case 300:
                CursorU9=true;
                break;
            case 350:
                CursorU10=true;
                break;
            case 400:
                CursorU11=true;
                break;
            case 450:
                CursorU12=true;
                break;
            case 500:
                CursorU13=true;
                break;
            case 550:
                CursorU14=true;
                break;
            default:
                break;
        }
    }
    public void GrandmaUpgrade(){
        switch (BuildingLogic.getGrandmaPurchases()) {
            case 1:
                GrandmaU1=true;
                break;
            case 5:
                GrandmaU2=true;
                break;
            case 25:
                GrandmaU3=true;
                break;
            case 50:
                GrandmaU4=true;
                break;
            case 100:
                GrandmaU5=true;
                break;
            case 150:
                GrandmaU6=true;
                break;
            case 200:
                GrandmaU7=true;
                break;
            case 250:
                GrandmaU8=true;
                break;
            case 300:
                GrandmaU9=true;
                break;
            case 350:
                GrandmaU10=true;
                break;
            case 400:
                GrandmaU11=true;
                break;
            case 450:
                GrandmaU12=true;
                break;
            case 500:
                GrandmaU13=true;
                break;
            case 550:
                GrandmaU14=true;
                break;
            case 600:
                GrandmaU15=true;
                break;
            default:
                break;
        }
    }

    public void FarmUpgrade(){
        switch (BuildingLogic.getFarmPurchases()) {
            case 1:
                FarmU1=true;
                break;
            case 5:
                FarmU2=true;
                break;
            case 25:
                FarmU3=true;
                break;
            case 50:
                FarmU4=true;
                break;
            case 100:
                FarmU5=true;
                break;
            case 150:
                FarmU6=true;
                break;
            case 200:
                FarmU7=true;
                break;
            case 250:
                FarmU8=true;
                break;
            case 300:
                FarmU9=true;
                break;
            case 350:
                FarmU10=true;
                break;
            case 400:
                FarmU11=true;
                break;
            case 450:
                FarmU12=true;
                break;
            case 500:
                FarmU13=true;
                break;
            case 550:
                FarmU14=true;
                break;
            case 600:
                FarmU15=true;
                break;
            default:
                break;
        }
    }

    public void MineUpgrade(){
        switch (BuildingLogic.getMinePurchases()) {
            case 1:
                MineU1=true;
                break;
            case 5:
                MineU2=true;
                break;
            case 25:
                MineU3=true;
                break;
            case 50:
                MineU4=true;
                break;
            case 100:
                MineU5=true;
                break;
            case 150:
                MineU6=true;
                break;
            case 200:
                MineU7=true;
                break;
            case 250:
                MineU8=true;
                break;
            case 300:
                MineU9=true;
                break;
            case 350:
                MineU10=true;
                break;
            case 400:
                MineU11=true;
                break;
            case 450:
                MineU12=true;
                break;
            case 500:
                MineU13=true;
                break;
            case 550:
                MineU14=true;
                break;
            case 600:
                MineU15=true;
                break;
            default:
                break;
        }
    }
    public void FactoryUpgrade(){
        switch (BuildingLogic.getFactoryPurchases()) {
            case 1:
                FactoryU1=true;
                break;
            case 5:
                FactoryU2=true;
                break;
            case 25:
                FactoryU3=true;
                break;
            case 50:
                FactoryU4=true;
                break;
            case 100:
                FactoryU5=true;
                break;
            case 150:
                FactoryU6=true;
                break;
            case 200:
                FactoryU7=true;
                break;
            case 250:
                FactoryU8=true;
                break;
            case 300:
                FactoryU9=true;
                break;
            case 350:
                FactoryU10=true;
                break;
            case 400:
                FactoryU11=true;
                break;
            case 450:
                FactoryU12=true;
                break;
            case 500:
                FactoryU13=true;
                break;
            case 550:
                FactoryU14=true;
                break;
            case 600:
                FactoryU15=true;
                break;
            default:
                break;
        }
    }



}