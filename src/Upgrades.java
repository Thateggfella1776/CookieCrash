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
    boolean TempleU1 = false;
    int TU1Cost=200_000_000;
    boolean TU1Unlocked =false;
    boolean TempleU2 = false;
    int TU2Cost=1_000_000_000;
    boolean TU2Unlocked =false;
    boolean TempleU3 = false;
    long TU3Cost=10000000000L;
    boolean TU3Unlocked =false;
    boolean TempleU4 = false;
    long TU4Cost=1000000000000L;
    boolean TU4Unlocked =false;
    boolean TempleU5 = false;
    long TU5Cost=100000000000000L;
    boolean TU5Unlocked =false;
    boolean TempleU6 = false;
    long TU6Cost=10000000000000000L;
    boolean TU6Unlocked =false;
    boolean TempleU7 = false;
    BigInteger TU7Cost= new BigInteger("10000000000000000000");
    boolean TU7Unlocked =false;
    boolean TempleU8 = false;
    BigInteger TU8Cost= new BigInteger("10000000000000000000000");
    boolean TU8Unlocked =false;
    boolean TempleU9 = false;
    BigInteger TU9Cost= new BigInteger("10000000000000000000000000");
    boolean TU9Unlocked =false;
    boolean TempleU10 = false;
    BigInteger TU10Cost= new BigInteger("10000000000000000000000000000");
    boolean TU10Unlocked =false;
    boolean TempleU11 = false;
    BigInteger TU11Cost= new BigInteger("100000000000000000000000000000000");
    boolean TU11Unlocked =false;
    boolean TempleU12 = false;
    BigInteger TU12Cost= new BigInteger("100000000000000000000000000000000000");
    boolean TU12Unlocked =false;
    boolean TempleU13 = false;
    BigInteger TU13Cost= new BigInteger("100000000000000000000000000000000000000");
    boolean TU13Unlocked =false;
    boolean TempleU14 = false;
    BigInteger TU14Cost= new BigInteger("1000000000000000000000000000000000000000000");
    boolean TU14Unlocked =false;
    boolean TempleU15 = false;
    BigInteger TU15Cost= new BigInteger("1000000000000000000000000000000000000000000000");
    boolean TU15Unlocked =false;

    double WizardTowerCPSMult=1.0;
    boolean WizardTU1 = false;
    long WTU1Cost=3300000000L;
    boolean WTU1Unlocked = false;
    boolean WizardTU2 = false;
    long WTU2Cost=16500000000L;
    boolean WTU2Unlocked = false;
    boolean WizardTU3 = false;
    long WTU3Cost=165000000000L;
    boolean WTU3Unlocked = false;
    boolean WizardTU4 = false;
    long WTU4Cost=16500000000000L;
    boolean WTU4Unlocked = false;
    boolean WizardTU5 = false;
    long WTU5Cost=1650000000000000L;
    boolean WTU5Unlocked = false;
    boolean WizardTU6 = false;
    long WTU6Cost=165000000000000000L;
    boolean WTU6Unlocked = false;
    boolean WizardTU7 = false;
    BigInteger WTU7Cost= new BigInteger("165000000000000000000");
    boolean WTU7Unlocked = false;
    boolean WizardTU8 = false;
    BigInteger WTU8Cost= new BigInteger("165000000000000000000000");
    boolean WTU8Unlocked = false;
    boolean WizardTU9 = false;
    BigInteger WTU9Cost= new BigInteger("165000000000000000000000000");
    boolean WTU9Unlocked = false;
    boolean WizardTU10 = false;
    BigInteger WTU10Cost= new BigInteger("165000000000000000000000000000");
    boolean WTU10Unlocked = false;
    boolean WizardTU11 = false;
    BigInteger WTU11Cost= new BigInteger("165000000000000000000000000000000");
    boolean WTU11Unlocked = false;
    boolean WizardTU12 = false;
    BigInteger WTU12Cost= new BigInteger("165000000000000000000000000000000000");
    boolean WTU12Unlocked = false;
    boolean WizardTU13 = false;
    BigInteger WTU13Cost= new BigInteger("165000000000000000000000000000000000000");
    boolean WTU13Unlocked = false;
    boolean WizardTU14 = false;
    BigInteger WTU14Cost= new BigInteger("165000000000000000000000000000000000000000");
    boolean WTU14Unlocked = false;
    boolean WizardTU15 = false;
    BigInteger WTU15Cost= new BigInteger("165000000000000000000000000000000000000000000");
    boolean WTU15Unlocked = false;


    double ShipmentCPSMult=1.0;
    boolean ShipmentU1 = false;
    long S1Cost=51000000000L;
    boolean S1Unlocked = false;
    boolean ShipmentU2 = false;
    long S2Cost=255000000000L;
    boolean S2Unlocked = false;
    boolean ShipmentU3 = false;
    long S3Cost=2550000000000L;
    boolean S3Unlocked = false;
    boolean ShipmentU4 = false;
    long S4Cost=255000000000000L;
    boolean S4Unlocked = false;
    boolean ShipmentU5 = false;
    long S5Cost=25500000000000000L;
    boolean S5Unlocked = false;
    boolean ShipmentU6 = false;
    long S6Cost=2550000000000000000L;
    boolean S6Unlocked = false;
    boolean ShipmentU7 = false;
    BigInteger S7Cost= new BigInteger("2550000000000000000000");
    boolean S7Unlocked = false;
    boolean ShipmentU8 = false;
    BigInteger S8Cost= new BigInteger("2550000000000000000000000");
    boolean S8Unlocked = false;
    boolean ShipmentU9 = false;
    BigInteger S9Cost= new BigInteger("2550000000000000000000000000");
    boolean S9Unlocked = false;
    boolean ShipmentU10 = false;
    BigInteger S10Cost= new BigInteger("2550000000000000000000000000000");
    boolean S10Unlocked = false;
    boolean ShipmentU11 = false;
    BigInteger S11Cost= new BigInteger("25500000000000000000000000000000000");
    boolean S11Unlocked = false;
    boolean ShipmentU12 = false;
    BigInteger S12Cost= new BigInteger("25500000000000000000000000000000000000");
    boolean S12Unlocked = false;
    boolean ShipmentU13 = false;
    BigInteger S13Cost= new BigInteger("25500000000000000000000000000000000000000");
    boolean S13Unlocked = false;
    boolean ShipmentU14 = false;
    BigInteger S14Cost= new BigInteger("255000000000000000000000000000000000000000000");
    boolean S14Unlocked = false;
    boolean ShipmentU15 = false;
    BigInteger S15Cost= new BigInteger("255000000000000000000000000000000000000000000000");
    boolean S15Unlocked = false;

    double AlchemyLabCPSMult=1.0;
    boolean AlchemyLabU1 = false;
    long AL1Cost=750000000000L;
    boolean AL1Unlocked = false;
    boolean AlchemyLabU2 = false;
    long AL2Cost=3750000000000L;
    boolean AL2Unlocked = false;
    boolean AlchemyLabU3 = false;
    long AL3Cost=37500000000000L;
    boolean AL3Unlocked = false;
    boolean AlchemyLabU4 = false;
    long AL4Cost=3750000000000000L;
    boolean AL4Unlocked = false;
    boolean AlchemyLabU5 = false;
    long AL5Cost=375000000000000000L;
    boolean AL5Unlocked = false;
    boolean AlchemyLabU6 = false;
    BigInteger AL6Cost=new BigInteger("37500000000000000000");
    boolean AL6Unlocked = false;
    boolean AlchemyLabU7 = false;
    BigInteger AL7Cost= new BigInteger("37500000000000000000000");
    boolean AL7Unlocked = false;
    boolean AlchemyLabU8 = false;
    BigInteger AL8Cost= new BigInteger("37500000000000000000000000");
    boolean AL8Unlocked = false;
    boolean AlchemyLabU9 = false;
    BigInteger AL9Cost= new BigInteger("37500000000000000000000000000");
    boolean AL9Unlocked = false;
    boolean AlchemyLabU10 = false;
    BigInteger AL10Cost= new BigInteger("37500000000000000000000000000000");
    boolean AL10Unlocked = false;
    boolean AlchemyLabU11 = false;
    BigInteger AL11Cost= new BigInteger("3750000000000000000000000000000000000");
    boolean AL11Unlocked = false;
    boolean AlchemyLabU12 = false;
    BigInteger AL12Cost= new BigInteger("3750000000000000000000000000000000000000");
    boolean AL12Unlocked = false;
    boolean AlchemyLabU13 = false;
    BigInteger AL13Cost= new BigInteger("3750000000000000000000000000000000000000000");
    boolean AL13Unlocked = false;
    boolean AlchemyLabU14 = false;
    BigInteger AL14Cost= new BigInteger("3750000000000000000000000000000000000000000000");
    boolean AL14Unlocked = false;
    boolean AlchemyLabU15 = false;
    BigInteger AL15Cost= new BigInteger("37500000000000000000000000000000000000000000000000");
    boolean AL15Unlocked = false;

    double PortalCPSMult=1.0;
    boolean PortalU1 = false;
    long P1Cost=10000000000000L;
    boolean P1Unlocked = false;
    boolean PortalU2 = false;
    long P2Cost=50000000000000L;
    boolean P2Unlocked = false;
    boolean PortalU3 = false;
    long P3Cost=500000000000000L;
    boolean P3Unlocked = false;
    boolean PortalU4 = false;
    long P4Cost=50000000000000000L;
    boolean P4Unlocked = false;
    boolean PortalU5 = false;
    long P5Cost=5000000000000000000L;
    boolean P5Unlocked = false;
    boolean PortalU6 = false;
    BigInteger P6Cost= new BigInteger("500000000000000000000");
    boolean P6Unlocked = false;
    boolean PortalU7 = false;
    BigInteger P7Cost= new BigInteger("500000000000000000000000");
    boolean P7Unlocked = false;
    boolean PortalU8 = false;
    BigInteger P8Cost= new BigInteger("500000000000000000000000000");
    boolean P8Unlocked = false;
    boolean PortalU9 = false;
    BigInteger P9Cost= new BigInteger("500000000000000000000000000000");
    boolean P9Unlocked = false;
    boolean PortalU10 = false;
    BigInteger P10Cost= new BigInteger("500000000000000000000000000000000");
    boolean P10Unlocked = false;
    boolean PortalU11 = false;
    BigInteger P11Cost= new BigInteger("500000000000000000000000000000000000");
    boolean P11Unlocked = false;
    boolean PortalU12 = false;
    BigInteger P12Cost= new BigInteger("500000000000000000000000000000000000000");
    boolean P12Unlocked = false;
    boolean PortalU13 = false;
    BigInteger P13Cost= new BigInteger("500000000000000000000000000000000000000000");
    boolean P13Unlocked = false;
    boolean PortalU14 = false;
    BigInteger P14Cost= new BigInteger("50000000000000000000000000000000000000000000");
    boolean P14Unlocked = false;
    boolean PortalU15 = false;
    BigInteger P15Cost= new BigInteger("50000000000000000000000000000000000000000000000");
    boolean P15Unlocked = false;

    double TimeMachineCPSMult=1.0;
    boolean TimeMachineU1 = false;
    long TM1Cost=140000000000000L;
    boolean TM1Unlocked = false;
    boolean TimeMachineU2 = false;
    long TM2Cost=700000000000000L;
    boolean TM2Unlocked = false;
    boolean TimeMachineU3 = false;
    long TM3Cost=7000000000000000L;
    boolean TM3Unlocked = false;
    boolean TimeMachineU4 = false;
    long TM4Cost=700000000000000000L;
    boolean TM4Unlocked = false;
    boolean TimeMachineU5 = false;
    BigInteger TM5Cost= new BigInteger("70000000000000000000");
    boolean TM5Unlocked = false;
    boolean TimeMachineU6 = false;
    BigInteger TM6Cost= new BigInteger("7000000000000000000000");
    boolean TM6Unlocked = false;
    boolean TimeMachineU7 = false;
    BigInteger TM7Cost= new BigInteger("7000000000000000000000000");
    boolean TM7Unlocked = false;
    boolean TimeMachineU8 = false;
    BigInteger TM8Cost= new BigInteger("7000000000000000000000000000");
    boolean TM8Unlocked = false;
    boolean TimeMachineU9 = false;
    BigInteger TM9Cost= new BigInteger("7000000000000000000000000000000");
    boolean TM9Unlocked = false;
    boolean TimeMachineU10 = false;
    BigInteger TM10Cost= new BigInteger("7000000000000000000000000000000000");
    boolean TM10Unlocked = false;
    boolean TimeMachineU11 = false;
    BigInteger TM11Cost= new BigInteger("7000000000000000000000000000000000000");
    boolean TM11Unlocked = false;
    boolean TimeMachineU12 = false;
    BigInteger TM12Cost= new BigInteger("7000000000000000000000000000000000000000");
    boolean TM12Unlocked = false;
    boolean TimeMachineU13 = false;
    BigInteger TM13Cost= new BigInteger("7000000000000000000000000000000000000000000");
    boolean TM13Unlocked = false;
    boolean TimeMachineU14 = false;
    BigInteger TM14Cost= new BigInteger("7000000000000000000000000000000000000000000000");
    boolean TM14Unlocked = false;
    boolean TimeMachineU15 = false;
    BigInteger TM15Cost= new BigInteger("7000000000000000000000000000000000000000000000000");
    boolean TM15Unlocked = false;

    double AntimatterCondenserCPSMult=1.0;
    boolean AntimatterCondenserU1 = false;
    long AC1Cost=1700000000000000L;
    boolean AC1Unlocked = false;
    boolean AntimatterCondenserU2 = false;
    long AC2Cost=8500000000000000L;
    boolean AC2Unlocked = false;
    boolean AntimatterCondenserU3 = false;
    long AC3Cost=85000000000000000L;
    boolean AC3Unlocked = false;
    boolean AntimatterCondenserU4 = false;
    long AC4Cost=8500000000000000000L;
    boolean AC4Unlocked = false;
    boolean AntimatterCondenserU5 = false;
    BigInteger AC5Cost= new BigInteger("850000000000000000000");
    boolean AC5Unlocked = false;
    boolean AntimatterCondenserU6 = false;
    BigInteger AC6Cost= new BigInteger("85000000000000000000000");
    boolean AC6Unlocked = false;
    boolean AntimatterCondenserU7 = false;
    BigInteger AC7Cost= new BigInteger("8500000000000000000000000");
    boolean AC7Unlocked = false;
    boolean AntimatterCondenserU8 = false;
    BigInteger AC8Cost= new BigInteger("850000000000000000000000000");
    boolean AC8Unlocked = false;
    boolean AntimatterCondenserU9 = false;
    BigInteger AC9Cost= new BigInteger("850000000000000000000000000000");
    boolean AC9Unlocked = false;
    boolean AntimatterCondenserU10 = false;
    BigInteger AC10Cost= new BigInteger("85000000000000000000000000000000");
    boolean AC10Unlocked = false;
    boolean AntimatterCondenserU11 = false;
    BigInteger AC11Cost= new BigInteger("85000000000000000000000000000000000");
    boolean AC11Unlocked = false;
    boolean AntimatterCondenserU12 = false;
    BigInteger AC12Cost= new BigInteger("85000000000000000000000000000000000000");
    boolean AC12Unlocked = false;
    boolean AntimatterCondenserU13 = false;
    BigInteger AC13Cost= new BigInteger("85000000000000000000000000000000000000000");
    boolean AC13Unlocked = false;
    boolean AntimatterCondenserU14 = false;
    BigInteger AC14Cost= new BigInteger("85000000000000000000000000000000000000000000");
    boolean AC14Unlocked = false;
    boolean AntimatterCondenserU15 = false;
    BigInteger AC15Cost= new BigInteger("8500000000000000000000000000000000000000000000000");
    boolean AC15Unlocked = false;

    double PrismCPSMult=1.0;
    boolean PrisimU1 = false;
    long Prm1Cost=21000000000000000L;
    boolean Prm1Unlocked = false;
    boolean PrisimU2 = false;
    long Prm2Cost=105000000000000000L;
    boolean Prm2Unlocked = false;
    boolean PrisimU3 = false;
    long Prm3Cost=1050000000000000000L;
    boolean Prm3Unlocked = false;
    boolean PrisimU4 = false;
    BigInteger Prm4Cost=new BigInteger ("105000000000000000000");
    boolean Prm4Unlocked = false;
    boolean PrisimU5 = false;
    BigInteger Prm5Cost=new BigInteger ("10500000000000000000000");
    boolean Prm5Unlocked = false;
    boolean PrisimU6 = false;
    BigInteger Prm6Cost=new BigInteger ("1050000000000000000000000");
    boolean Prm6Unlocked = false;
    boolean PrisimU7 = false;
    BigInteger Prm7Cost=new BigInteger ("1050000000000000000000000000");
    boolean Prm7Unlocked = false;
    boolean PrisimU8 = false;
    BigInteger Prm8Cost=new BigInteger ("1050000000000000000000000000000");
    boolean Prm8Unlocked = false;
    boolean PrisimU9 = false;
    BigInteger Prm9Cost=new BigInteger ("1050000000000000000000000000000000");
    boolean Prm9Unlocked = false;
    boolean PrisimU10 = false;
    BigInteger Prm10Cost=new BigInteger ("1050000000000000000000000000000000000");
    boolean Prm10Unlocked = false;
    boolean PrisimU11 = false;
    BigInteger Prm11Cost=new BigInteger ("1050000000000000000000000000000000000000");
    boolean Prm11Unlocked = false;
    boolean PrisimU12 = false;
    BigInteger Prm12Cost=new BigInteger ("1050000000000000000000000000000000000000000");
    boolean Prm12Unlocked = false;
    boolean PrisimU13 = false;
    BigInteger Prm13Cost=new BigInteger ("1050000000000000000000000000000000000000000000");
    boolean Prm13Unlocked = false;
    boolean PrisimU14 = false;
    BigInteger Prm14Cost=new BigInteger ("1050000000000000000000000000000000000000000000000");
    boolean Prm14Unlocked = false;
    boolean PrisimU15 = false;
    BigInteger Prm15Cost=new BigInteger ("1050000000000000000000000000000000000000000000000000");
    boolean Prm15Unlocked = false;

    double ChancemakerCPSMult=1.0;
    boolean ChancemakerU1 = false;
    long CM1Cost=260000000000000000L;
    boolean CM1Unlocked = false;
    boolean ChancemakerU2 = false;
    long CM2Cost=1300000000000000000L;
    boolean CM2Unlocked = false;
    boolean ChancemakerU3 = false;
    BigInteger CM3Cost= new BigInteger("13000000000000000000");
    boolean CM3Unlocked = false;
    boolean ChancemakerU4 = false;
    BigInteger CM4Cost= new BigInteger("1300000000000000000000");
    boolean CM4Unlocked = false;
    boolean ChancemakerU5 = false;
    BigInteger CM5Cost= new BigInteger("130000000000000000000000");
    boolean CM5Unlocked = false;
    boolean ChancemakerU6 = false;
    BigInteger CM6Cost= new BigInteger("13000000000000000000000000");
    boolean CM6Unlocked = false;
    boolean ChancemakerU7 = false;
    BigInteger CM7Cost= new BigInteger("13000000000000000000000000000");
    boolean CM7Unlocked = false;
    boolean ChancemakerU8 = false;
    BigInteger CM8Cost= new BigInteger("13000000000000000000000000000000");
    boolean CM8Unlocked = false;
    boolean ChancemakerU9 = false;
    BigInteger CM9Cost= new BigInteger("1300000000000000000000000000000000");
    boolean CM9Unlocked = false;
    boolean ChancemakerU10 = false;
    BigInteger CM10Cost= new BigInteger("130000000000000000000000000000000000");
    boolean CM10Unlocked = false;
    boolean ChancemakerU11 = false;
    BigInteger CM11Cost= new BigInteger("130000000000000000000000000000000000000");
    boolean CM11Unlocked = false;
    boolean ChancemakerU12 = false;
    BigInteger CM12Cost= new BigInteger("13000000000000000000000000000000000000000");
    boolean CM12Unlocked = false;
    boolean ChancemakerU13 = false;
    BigInteger CM13Cost= new BigInteger("1300000000000000000000000000000000000000000");
    boolean CM13Unlocked = false;
    boolean ChancemakerU14 = false;
    BigInteger CM14Cost= new BigInteger("1300000000000000000000000000000000000000000000");
    boolean CM14Unlocked = false;
    boolean ChancemakerU15 = false;
    BigInteger CM15Cost= new BigInteger("130000000000000000000000000000000000000000000000000");
    boolean CM15Unlocked = false;

    double FractalEngineCPSMult=1.0;
    boolean FractalEU1 = false;
    long FractalE1Cost = 3100000000000000000L;
    boolean FE1Unlocked = false;
    boolean FractalEU2 = false;
    BigInteger FractalE2Cost = new BigInteger("15500000000000000000");
    boolean FE2Unlocked = false;
    boolean FractalEU3 = false;
    BigInteger FractalE3Cost = new BigInteger("155000000000000000000");
    boolean FE3Unlocked = false;
    boolean FractalEU4 = false;
    BigInteger FractalE4Cost = new BigInteger("15500000000000000000000");
    boolean FE4Unlocked = false;
    boolean FractalEU5 = false;
    BigInteger FractalE5Cost = new BigInteger("1550000000000000000000000");
    boolean FE5Unlocked = false;
    boolean FractalEU6 = false;
    BigInteger FractalE6Cost = new BigInteger("155000000000000000000000000");
    boolean FE6Unlocked = false;
    boolean FractalEU7 = false;
    BigInteger FractalE7Cost = new BigInteger("155000000000000000000000000000");
    boolean FE7Unlocked = false;
    boolean FractalEU8 = false;
    BigInteger FractalE8Cost = new BigInteger("155000000000000000000000000000000");
    boolean FE8Unlocked = false;
    boolean FractalEU9 = false;
    BigInteger FractalE9Cost = new BigInteger("155000000000000000000000000000000000");
    boolean FE9Unlocked = false;
    boolean FractalEU10 = false;
    BigInteger FractalE10Cost = new BigInteger("155000000000000000000000000000000000000");
    boolean FE10Unlocked = false;
    boolean FractalEU11 = false;
    BigInteger FractalE11Cost = new BigInteger("15500000000000000000000000000000000000000");
    boolean FE11Unlocked = false;
    boolean FractalEU12 = false;
    BigInteger FractalE12Cost = new BigInteger("150000000000000000000000000000000000000000");
    boolean FE12Unlocked = false;
    boolean FractalEU13 = false;
    BigInteger FractalE13Cost = new BigInteger("155000000000000000000000000000000000000000000");
    boolean FE13Unlocked = false;
    boolean FractalEU14 = false;
    BigInteger FractalE14Cost = new BigInteger("155000000000000000000000000000000000000000000000");
    boolean FE14Unlocked = false;
    boolean FractalEU15 = false;
    BigInteger FractalE15Cost = new BigInteger("155000000000000000000000000000000000000000000000000");
    boolean FE15Unlocked = false;

    double JavaConsoleCPSMult=1.0;
    boolean JavaConsoleU1 = false;
    BigInteger JC1Cost= new BigInteger("710000000000000000000");
    boolean JC1Unlocked = false;
    boolean JavaConsoleU2 = false;
    BigInteger JC2Cost= new BigInteger( "3550000000000000000000" );
    boolean JC2Unlocked = false;
    boolean JavaConsoleU3 = false;
    BigInteger JC3Cost=new BigInteger ("35500000000000000000000");
    boolean JC3Unlocked = false;
    boolean JavaConsoleU4 = false;
    BigInteger JC4Cost=new BigInteger ("3550000000000000000000000");
    boolean JC4Unlocked = false;
    boolean JavaConsoleU5 = false;
    BigInteger JC5Cost=new BigInteger ("355000000000000000000000000");
    boolean JC5Unlocked = false;
    boolean JavaConsoleU6 = false;
    BigInteger JC6Cost=new BigInteger ("35500000000000000000000000000");
    boolean JC6Unlocked = false;
    boolean JavaConsoleU7 = false;
    BigInteger JC7Cost=new BigInteger ("35500000000000000000000000000000");
    boolean JC7Unlocked = false;
    boolean JavaConsoleU8 = false;
    BigInteger JC8Cost=new BigInteger ("3550000000000000000000000000000000");
    boolean JC8Unlocked = false;
    boolean JavaConsoleU9 = false;
    BigInteger JC9Cost=new BigInteger ("355000000000000000000000000000000000");
    boolean JC9Unlocked = false;
    boolean JavaConsoleU10 = false;
    BigInteger JC10Cost=new BigInteger ("35500000000000000000000000000000000000");
    boolean JC10Unlocked = false;
    boolean JavaConsoleU11 = false;
    BigInteger JC11Cost=new BigInteger ("3550000000000000000000000000000000000000");
    boolean JC11Unlocked = false;
    boolean JavaConsoleU12 = false;
    BigInteger JC12Cost=new BigInteger ("355000000000000000000000000000000000000000");
    boolean JC12Unlocked = false;
    boolean JavaConsoleU13 = false;
    BigInteger JC13Cost=new BigInteger ("355000000000000000000000000000000000000000000");
    boolean JC13Unlocked = false;
    boolean JavaConsoleU14 = false;
    BigInteger JC14Cost=new BigInteger ("355000000000000000000000000000000000000000000000");
    boolean JC14Unlocked = false;
    boolean JavaConsoleU15 = false;
    BigInteger JC15Cost=new BigInteger ("355000000000000000000000000000000000000000000000000");
    boolean JC15Unlocked = false;

    double IdleverseCPSMult=1.0;
    boolean IdleverseU1 = false;
    BigInteger IV1Cost= new BigInteger("120000000000000000000000");
    boolean IV1Unlocked = false;
    boolean IdleverseU2 = false;
    BigInteger IV2Cost= new BigInteger("600000000000000000000000");
    boolean IV2Unlocked = false;
    boolean IdleverseU3 = false;
    BigInteger IV3Cost= new BigInteger("6000000000000000000000000");
    boolean IV3Unlocked = false;
    boolean IdleverseU4 = false;
    BigInteger IV4Cost= new BigInteger("600000000000000000000000000");
    boolean IV4Unlocked = false;
    boolean IdleverseU5 = false;
    BigInteger IV5Cost= new BigInteger("60000000000000000000000000000");
    boolean IV5Unlocked = false;
    boolean IdleverseU6 = false;
    BigInteger IV6Cost= new BigInteger("6000000000000000000000000000000");
    boolean IV6Unlocked = false;
    boolean IdleverseU7 = false;
    BigInteger IV7Cost= new BigInteger("600000000000000000000000000000000");
    boolean IV7Unlocked = false;
    boolean IdleverseU8 = false;
    BigInteger IV8Cost= new BigInteger("60000000000000000000000000000000000");
    boolean IV8Unlocked = false;
    boolean IdleverseU9 = false;
    BigInteger IV9Cost= new BigInteger("6000000000000000000000000000000000000");
    boolean IV9Unlocked = false;
    boolean IdleverseU10 = false;
    BigInteger IV10Cost= new BigInteger("60000000000000000000000000000000000000");
    boolean IV10Unlocked = false;
    boolean IdleverseU11 = false;
    BigInteger IV11Cost= new BigInteger("60000000000000000000000000000000000000000");
    boolean IV11Unlocked = false;
    boolean IdleverseU12 = false;
    BigInteger IV12Cost= new BigInteger("600000000000000000000000000000000000000000");
    boolean IV12Unlocked = false;
    boolean IdleverseU13 = false;
    BigInteger IV13Cost= new BigInteger("600000000000000000000000000000000000000000000");
    boolean IV13Unlocked = false;
    boolean IdleverseU14 = false;
    BigInteger IV14Cost= new BigInteger("6000000000000000000000000000000000000000000000");
    boolean IV14Unlocked = false;
    boolean IdleverseU15 = false;
    BigInteger IV15Cost= new BigInteger("60000000000000000000000000000000000000000000000000");
    boolean IV15Unlocked = false;

    double CortexBakerCPSMult=1.0;
    boolean CortexBakerU1 = false;
    BigInteger CB1Cost= new BigInteger("19000000000000000000000");
    boolean CB1Unlocked = false;
    boolean CortexBakerU2 = false;
    BigInteger CB2Cost= new BigInteger("95000000000000000000000");
    boolean CB2Unlocked = false;
    boolean CortexBakerU3 = false;
    BigInteger CB3Cost= new BigInteger("950000000000000000000000");
    boolean CB3Unlocked = false;
    boolean CortexBakerU4 = false;
    BigInteger CB4Cost= new BigInteger("95000000000000000000000000");
    boolean CB4Unlocked = false;
    boolean CortexBakerU5 = false;
    BigInteger CB5Cost= new BigInteger("9500000000000000000000000000");
    boolean CB5Unlocked = false;
    boolean CortexBakerU6 = false;
    BigInteger CB6Cost= new BigInteger("950000000000000000000000000000");
    boolean CB6Unlocked = false;
    boolean CortexBakerU7 = false;
    BigInteger CB7Cost= new BigInteger("950000000000000000000000000000000");
    boolean CB7Unlocked = false;
    boolean CortexBakerU8 = false;
    BigInteger CB8Cost= new BigInteger("95000000000000000000000000000000000");
    boolean CB8Unlocked = false;
    boolean CortexBakerU9 = false;
    BigInteger CB9Cost= new BigInteger("9500000000000000000000000000000000000");
    boolean CB9Unlocked = false;
    boolean CortexBakerU10 = false;
    BigInteger CB10Cost= new BigInteger("950000000000000000000000000000000000000");
    boolean CB10Unlocked = false;
    boolean CortexBakerU11 = false;
    BigInteger CB11Cost= new BigInteger("95000000000000000000000000000000000000000");
    boolean CB11Unlocked = false;
    boolean CortexBakerU12 = false;
    BigInteger CB12Cost= new BigInteger("9500000000000000000000000000000000000000000");
    boolean CB12Unlocked = false;
    boolean CortexBakerU13 = false;
    BigInteger CB13Cost= new BigInteger("950000000000000000000000000000000000000000000");
    boolean CB13Unlocked = false;
    boolean CortexBakerU14 = false;
    BigInteger CB14Cost= new BigInteger("95000000000000000000000000000000000000000000000");
    boolean CB14Unlocked = false;
    boolean CortexBakerU15 = false;
    BigInteger CB15Cost= new BigInteger("95000000000000000000000000000000000000000000000000");
    boolean CB15Unlocked = false;

    double YouCPSMult=1.0;
    boolean YouU1 = false;
    BigInteger Y1Cost= new BigInteger("5400000000000000000000000000");
    boolean Y1Unlocked = false;
    boolean YouU2 = false;
    BigInteger Y2Cost= new BigInteger("27000000000000000000000000000");
    boolean Y2Unlocked = false;
    boolean YouU3 = false;
    BigInteger Y3Cost= new BigInteger("270000000000000000000000000000");
    boolean Y3Unlocked = false;
    boolean YouU4 = false;
    BigInteger Y4Cost= new BigInteger("2700000000000000000000000000000");
    boolean Y4Unlocked = false;
    boolean YouU5 = false;
    BigInteger Y5Cost= new BigInteger("27000000000000000000000000000000");
    boolean Y5Unlocked = false;
    boolean YouU6 = false;
    BigInteger Y6Cost= new BigInteger("2700000000000000000000000000000000");
    boolean Y6Unlocked = false;
    boolean YouU7 = false;
    BigInteger Y7Cost= new BigInteger("2700000000000000000000000000000000000");
    boolean Y7Unlocked = false;
    boolean YouU8 = false;
    BigInteger Y8Cost= new BigInteger("270000000000000000000000000000000000000");
    boolean Y8Unlocked = false;
    boolean YouU9 = false;
    BigInteger Y9Cost= new BigInteger("27000000000000000000000000000000000000000");
    boolean Y9Unlocked = false;
    boolean YouU10 = false;
    BigInteger Y10Cost= new BigInteger("2700000000000000000000000000000000000000000");
    boolean Y10Unlocked = false;
    boolean YouU11 = false;
    BigInteger Y11Cost= new BigInteger("2700000000000000000000000000000000000000000000");
    boolean Y11Unlocked = false;
    boolean YouU12 = false;
    BigInteger Y12Cost= new BigInteger("270000000000000000000000000000000000000000000000");
    boolean Y12Unlocked = false;
    boolean YouU13 = false;
    BigInteger Y13Cost= new BigInteger("270000000000000000000000000000000000000000000000000");
    boolean Y13Unlocked = false;
    boolean YouU14 = false;
    BigInteger Y14Cost= new BigInteger("270000000000000000000000000000000000000000000000000000");
    boolean Y14Unlocked = false;
    boolean YouU15 = false;
    BigInteger Y15Cost= new BigInteger("270000000000000000000000000000000000000000000000000000000");
    boolean Y15Unlocked = false;


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

    public void BankUpgrade(){
        switch (BuildingLogic.getBankPurchases()) {
            case 1:
                BankU1=true;
                break;
            case 5:
                BankU2=true;
                break;
            case 25:
                BankU3=true;
                break;
            case 50:
                BankU4=true;
                break;
            case 100:
                BankU5=true;
                break;
            case 150:
                BankU6=true;
                break;
            case 200:
                BankU7=true;
                break;
            case 250:
                BankU8=true;
                break;
            case 300:
                BankU9=true;
                break;
            case 350:
                BankU10=true;
                break;
            case 400:
                BankU11=true;
                break;
            case 450:
                BankU12=true;
                break;
            case 500:
                BankU13=true;
                break;
            case 550:
                BankU14=true;
                break;
            case 600:
                BankU15=true;
                break;
            default:
                break;
        }
    }

    public void TempleUpgrade(){
        switch (BuildingLogic.getTemplePurchases()) {
            case 1:
                TempleU1=true;
                break;
            case 5:
                TempleU2=true;
                break;
            case 25:
                TempleU3=true;
                break;
            case 50:
                TempleU4=true;
                break;
            case 100:
                TempleU5=true;
                break;
            case 150:
                TempleU6=true;
                break;
            case 200:
                TempleU7=true;
                break;
            case 250:
                TempleU8=true;
                break;
            case 300:
                TempleU9=true;
                break;
            case 350:
                TempleU10=true;
                break;
            case 400:
                TempleU11=true;
                break;
            case 450:
                TempleU12=true;
                break;
            case 500:
                TempleU13=true;
                break;
            case 550:
                TempleU14=true;
                break;
            case 600:
                TempleU15=true;
                break;
            default:
                break;
        }
    }

    public void WizardTowerUpgrade(){
        switch (BuildingLogic.getWizardTowerPurchases()) {
            case 1:
                WizardTU1=true;
                break;
            case 5:
                WizardTU2=true;
                break;
            case 25:
                WizardTU3=true;
                break;
            case 50:
                WizardTU4=true;
                break;
            case 100:
                WizardTU5=true;
                break;
            case 150:
                WizardTU6=true;
                break;
            case 200:
                WizardTU7=true;
                break;
            case 250:
                WizardTU8=true;
                break;
            case 300:
                WizardTU9=true;
                break;
            case 350:
                WizardTU10=true;
                break;
            case 400:
                WizardTU11=true;
                break;
            case 450:
                WizardTU12=true;
                break;
            case 500:
                WizardTU13=true;
                break;
            case 550:
                WizardTU14=true;
                break;
            case 600:
                WizardTU15=true;
                break;
            default:
                break;
        }
    }

    public void ShipmentUpgrade(){
        switch (BuildingLogic.getShipmentPurchases()) {
            case 1:
                ShipmentU1=true;
                break;
            case 5:
                ShipmentU2=true;
                break;
            case 25:
                ShipmentU3=true;
                break;
            case 50:
                ShipmentU4=true;
                break;
            case 100:
                ShipmentU5=true;
                break;
            case 150:
                ShipmentU6=true;
                break;
            case 200:
                ShipmentU7=true;
                break;
            case 250:
                ShipmentU8=true;
                break;
            case 300:
                ShipmentU9=true;
                break;
            case 350:
                ShipmentU10=true;
                break;
            case 400:
                ShipmentU11=true;
                break;
            case 450:
                ShipmentU12=true;
                break;
            case 500:
                ShipmentU13=true;
                break;
            case 550:
                ShipmentU14=true;
                break;
            case 600:
                ShipmentU15=true;
                break;
            default:
                break;
        }
    }

    public void AlchemyLabUpgrade(){
        switch (BuildingLogic.getAlchemyLabPurchases()){
            case 1:
                AlchemyLabU1=true;
                break;
            case 5:
                AlchemyLabU2=true;
                break;
            case 25:
                AlchemyLabU3=true;
                break;
            case 50:
                AlchemyLabU4=true;
                break;
            case 100:
                AlchemyLabU5=true;
                break;
            case 150:
                AlchemyLabU6=true;
                break;
            case 200:
                AlchemyLabU7=true;
                break;
            case 250:
                AlchemyLabU8=true;
                break;
            case 300:
                AlchemyLabU9=true;
                break;
            case 350:
                AlchemyLabU10=true;
                break;
            case 400:
                AlchemyLabU11=true;
                break;
            case 450:
                AlchemyLabU12=true;
                break;
            case 500:
                AlchemyLabU13=true;
                break;
            case 550:
                AlchemyLabU14=true;
                break;
            case 600:
                AlchemyLabU15=true;
                break;
            default:
                break;
        }
    }

    public void PortalUpgrade(){
        switch (BuildingLogic.getPortalPurchases()){
            case 1:
                PortalU1=true;
                break;
            case 5:
                PortalU2=true;
                break;
            case 25:
                PortalU3=true;
                break;
            case 50:
                PortalU4=true;
                break;
            case 100:
                PortalU5=true;
                break;
            case 150:
                PortalU6=true;
                break;
            case 200:
                PortalU7=true;
                break;
            case 250:
                PortalU8=true;
                break;
            case 300:
                PortalU9=true;
                break;
            case 350:
                PortalU10=true;
                break;
            case 400:
                PortalU11=true;
                break;
            case 450:
                PortalU12=true;
                break;
            case 500:
                PortalU13=true;
                break;
            case 550:
                PortalU14=true;
                break;
            case 600:
                PortalU15=true;
                break;
            default:
                break;
        }
    }

    public void TimeMachineUpgrade(){
        switch (BuildingLogic.getTimeMachinePurchases()) {
            case 1:
                TimeMachineU1=true;
                break;
            case 5:
                TimeMachineU2=true;
                break;
            case 25:
                TimeMachineU3=true;
                break;
            case 50:
                TimeMachineU4=true;
                break;
            case 100:
                TimeMachineU5=true;
                break;
            case 150:
                TimeMachineU6=true;
                break;
            case 200:
                TimeMachineU7=true;
                break;
            case 250:
                TimeMachineU8=true;
                break;
            case 300:
                TimeMachineU9=true;
                break;
            case 350:
                TimeMachineU10=true;
                break;
            case 400:
                TimeMachineU11=true;
                break;
            case 450:
                TimeMachineU12=true;
                break;
            case 500:
                TimeMachineU13=true;
                break;
            case 550:
                TimeMachineU14=true;
                break;
            case 600:
                TimeMachineU15=true;
                break;
            default:
                break;
        }
    }

    public void AntimatterCondenserUpgrade(){
        switch (BuildingLogic.getAntimatterCondenserPurchases()) {
            case 1:
                AntimatterCondenserU1=true;
                break;
            case 5:
                AntimatterCondenserU2=true;
                break;
            case 25:
                AntimatterCondenserU3=true;
                break;
            case 50:
                AntimatterCondenserU4=true;
                break;
            case 100:
                AntimatterCondenserU5=true;
                break;
            case 150:
                AntimatterCondenserU6=true;
                break;
            case 200:
                AntimatterCondenserU7=true;
                break;
            case 250:
                AntimatterCondenserU8=true;
                break;
            case 300:
                AntimatterCondenserU9=true;
                break;
            case 350:
                AntimatterCondenserU10=true;
                break;
            case 400:
                AntimatterCondenserU11=true;
                break;
            case 450:
                AntimatterCondenserU12=true;
                break;
            case 500:
                AntimatterCondenserU13=true;
                break;
            case 550:
                AntimatterCondenserU14=true;
                break;
            case 600:
                AntimatterCondenserU15=true;
                break;
            default:
                break;
        }
    }

    public void PrismUpgrade(){
        switch (BuildingLogic.getPrismPurchases()){
            case 1:
                PrisimU1 = true;
                break;
            case 5:
                PrisimU2 = true;
                break;
            case 25:
                PrisimU3 = true;
                break;
            case 50:
                PrisimU4 = true;
                break;
            case 100:
                PrisimU5 = true;
                break;
            case 150:
                PrisimU6 = true;
                break;
            case 200:
                PrisimU7 = true;
                break;
            case 250:
                PrisimU8 = true;
                break;
            case 300:
                PrisimU9 = true;
                break;
            case 350:
                PrisimU10 = true;
                break;
            case 400:
                PrisimU11 = true;
                break;
            case 450:
                PrisimU12 = true;
                break;
            case 500:
                PrisimU13 = true;
                break;
            case 550:
                PrisimU14 = true;
                break;
            case 600:
                PrisimU15 = true;
                break;
            default:
                break;
        }
    }

    public void ChancemakerUpgrade(){
        switch (BuildingLogic.getChancemakerPurchases()) {
            case 1:
                ChancemakerU1=true;
                break;
            case 5:
                ChancemakerU2=true;
                break;
            case 25:
                ChancemakerU3=true;
                break;
            case 50:
                ChancemakerU4=true;
                break;
            case 100:
                ChancemakerU5=true;
                break;
            case 150:
                ChancemakerU6=true;
                break;
            case 200:
                ChancemakerU7=true;
                break;
            case 250:
                ChancemakerU8=true;
                break;
            case 300:
                ChancemakerU9=true;
                break;
            case 350:
                ChancemakerU10=true;
                break;
            case 400:
                ChancemakerU11=true;
                break;
            case 450:
                ChancemakerU12=true;
                break;
            case 500:
                ChancemakerU13=true;
                break;
            case 550:
                ChancemakerU14=true;
                break;
            case 600:
                ChancemakerU15=true;
                break;
            default:
                break;

        }
    }

    public void FractalEngineUpgrade(){
        switch (BuildingLogic.getFractalEnginePurchases()){
            case 1:
                FractalEU1 = true;
                break;
            case 5:
                FractalEU2 = true;
                break;
            case 25:
                FractalEU3 = true;
                break;
            case 50:
                FractalEU4 = true;
                break;
            case 100:
                FractalEU5 = true;
                break;
            case 150:
                FractalEU6 = true;
                break;
            case 200:
                FractalEU7 = true;
                break;
            case 250:
                FractalEU8 = true;
                break;
            case 300:
                FractalEU9 = true;
                break;
            case 350:
                FractalEU10 = true;
                break;
            case 400:
                FractalEU11 = true;
                break;
            case 450:
                FractalEU12 = true;
                break;
            case 500:
                FractalEU13 = true;
                break;
            case 550:
                FractalEU14 = true;
                break;
            case 600:
                FractalEU15 = true;
                break;
            default:
                break;
        }
    }

    public void JavaConsoleUpgrade(){
        switch (BuildingLogic.getJavaConsolePurchases()){
            case 1:
                JavaConsoleU1 = true;
                break;
            case 5:
                JavaConsoleU2 = true;
                break;
            case 25:
                JavaConsoleU3 = true;
                break;
            case 50:
                JavaConsoleU4 = true;
                break;
            case 100:
                JavaConsoleU5 = true;
                break;
            case 150:
                JavaConsoleU6 = true;
                break;
            case 200:
                JavaConsoleU7 = true;
                break;
            case 250:
                JavaConsoleU8 = true;
                break;
            case 300:
                JavaConsoleU9 = true;
                break;
            case 350:
                JavaConsoleU10 = true;
                break;
            case 400:
                JavaConsoleU11 = true;
                break;
            case 450:
                JavaConsoleU12 = true;
                break;
            case 500:
                JavaConsoleU13 = true;
                break;
            case 550:
                JavaConsoleU14 = true;
                break;
            case 600:
                JavaConsoleU15 = true;
                break;
            default:
                break;
        }
    }

    public void IdleverseUpgrade(){
        switch (BuildingLogic.getIdleversePurchases()){
            case 1:
                IdleverseU1 = true;
                break;
            case 5:
                IdleverseU2 = true;
                break;
            case 25:
                IdleverseU3 = true;
                break;
            case 50:
                IdleverseU4 = true;
                break;
            case 100:
                IdleverseU5 = true;
                break;
            case 150:
                IdleverseU6 = true;
                break;
            case 200:
                IdleverseU7 = true;
                break;
            case 250:
                IdleverseU8 = true;
                break;
            case 300:
                IdleverseU9 = true;
                break;
            case 350:
                IdleverseU10 = true;
                break;
            case 400:
                IdleverseU11 = true;
                break;
            case 450:
                IdleverseU12 = true;
                break;
            case 500:
                IdleverseU13 = true;
                break;
            case 550:
                IdleverseU14 = true;
                break;
            case 600:
                IdleverseU15 = true;
                break;
            default:
                break;
        }
    }

    public void CortexBakerUpgrade(){
        switch (BuildingLogic.getCortexBakerPurchases()){
            case 1:
                CortexBakerU1 = true;
                break;
            case 5:
                CortexBakerU2 = true;
                break;
            case 25:
                CortexBakerU3 = true;
                break;
            case 50:
                CortexBakerU4 = true;
                break;
            case 100:
                CortexBakerU5 = true;
                break;
            case 150:
                CortexBakerU6 = true;
                break;
            case 200:
                CortexBakerU7 = true;
                break;
            case 250:
                CortexBakerU8 = true;
                break;
            case 300:
                CortexBakerU9 = true;
                break;
            case 350:
                CortexBakerU10 = true;
                break;
            case 400:
                CortexBakerU11 = true;
                break;
            case 450:
                CortexBakerU12 = true;
                break;
            case 500:
                CortexBakerU13 = true;
                break;
            case 550:
                CortexBakerU14 = true;
                break;
            case 600:
                CortexBakerU15 = true;
                break;
            default:
                break;
        }
    }

    public void YouUpgrade(){
        switch (BuildingLogic.getYouPurchases()){
            case 1:
                YouU1 = true;
                break;
            case 5:
                YouU2 = true;
                break;
            case 25:
                YouU3 = true;
                break;
            case 50:
                YouU4 = true;
                break;
            case 100:
                YouU5 = true;
                break;
            case 150:
                YouU6 = true;
                break;
            case 200:
                YouU7 = true;
                break;
            case 250:
                YouU8 = true;
                break;
            case 300:
                YouU9 = true;
                break;
            case 350:
                YouU10 = true;
                break;
            case 400:
                YouU11 = true;
                break;
            case 450:
                YouU12 = true;
                break;
            case 500:
                YouU13 = true;
                break;
            case 550:
                YouU14 = true;
                break;
            case 600:
                YouU15 = true;
                break;
            default:
                break;
        }
    }
}