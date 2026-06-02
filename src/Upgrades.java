class Upgrades {

    Buildings BuildingLogic;

    public Upgrades(Buildings buildings) {
        this.BuildingLogic = buildings;
    }

    double BaseCPSMult=1.0;
    double CursorCPSMult=1.0;
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
                CursorCPSMult=2.0;
                break;
            case 10:
                CursorCPSMult=1.1;
                break;
            case 25:
                CursorCPSMult=1.2;
                break;
            case 50:
                CursorCPSMult=1.3;
                break;
            case 100:
                CursorCPSMult=1.4;
                break;
            case 150:
                CursorCPSMult=1.5;
                break;
            case 200:
                CursorCPSMult=1.6;
                break;
            case 250:
                CursorCPSMult=1.7;
                break;
            case 300:
                CursorCPSMult=1.8;
                break;
            case 350:
                CursorCPSMult=1.9;
                break;
            case 400:
                CursorCPSMult=2.0;
                break;
            case 450:
                CursorCPSMult=2.1;
                break;
            case 500:
                CursorCPSMult=2.2;
                break;
            case 550:
                CursorCPSMult=2.3;
                break;
            default:
                break;
        }
    }


}