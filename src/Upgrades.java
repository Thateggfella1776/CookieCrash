class Upgrades {

    Buildings BuildingLogic;

    public Upgrades(Buildings buildings) {
        this.BuildingLogic = buildings;
    }

    double BaseCPSMult=1.0;
    double CursorCPSMult=1.0;
    boolean CursorU1 = false;
    boolean CU1Unlocked =false;
    boolean CursorU2 = false;
    boolean CU2Unlocked =false;
    boolean CursorU3 = false;
    boolean CU3Unlocked =false;
    boolean CursorU4 = false;
    boolean CU4Unlocked =false;
    boolean CursorU5 = false;
    boolean CU5Unlocked =false;
    boolean CursorU6 = false;
    boolean CU6Unlocked =false;
    boolean CursorU7 = false;
    boolean CU7Unlocked =false;
    boolean CursorU8 = false;
    boolean CU8Unlocked =false;
    boolean CursorU9 = false;
    boolean CU9Unlocked =false;
    boolean CursorU10 = false;
    boolean CU10Unlocked =false;
    boolean CursorU11 = false;
    boolean CU11Unlocked =false;
    boolean CursorU12 = false;
    boolean CU12Unlocked =false;
    boolean CursorU13 = false;
    boolean CU13Unlocked =false;
    boolean CursorU14 = false;
    boolean CU14Unlocked =false;
    double GrandmaCPSMult=1.0;
    double FarmCPSMult=1.0;
    double MineCPSMult=1.0;
    double FactoryCPSMult=1.0;
    double BankCPSMult=1.0;
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
                break;
            case 10:
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


}