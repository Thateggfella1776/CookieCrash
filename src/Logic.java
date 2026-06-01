import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;

public class Logic {
   Buildings BuildingLogic;
   Upgrades CPSMult;
   public Logic(Buildings buildings, Upgrades upgrades) {
    this.BuildingLogic = buildings;
    this.CPSMult = upgrades;
}

    //Save Function, Source:https://www.youtube.com/shorts/MvzzBvbiwjk?feature=share
    public void SaveToFile() throws IOException{
       String text = "Cookie Count:"+BuildingLogic.getCookieCount()+"\n"
               +"Cookies Per Click:"+BuildingLogic.getCookiesPerClick()+"\n"
               +"Cookies Per Second:"+BuildingLogic.getCookiesPerSecond()+"\n"
               +"Cursor Purchases:"+BuildingLogic.getCursorPurchases()+"\n"
               +"Grandma Purchases:"+BuildingLogic.getGrandmaPurchases()+"\n"
               +"Farm Purchases:"+BuildingLogic.getFarmPurchases()+"\n"
               +"Mine Purchases:"+BuildingLogic.getMinePurchases()+"\n"
               +"Factory Purchases:"+BuildingLogic.getFactoryPurchases()+"\n"
               +"Bank Purchases:"+BuildingLogic.getBankPurchases()+"\n"
               +"Temple Purchases:"+BuildingLogic.getTemplePurchases()+"\n"
               +"Wizard Tower Purchases:"+BuildingLogic.getWizardTowerPurchases()+"\n"
               +"Shipment Purchases:"+BuildingLogic.getShipmentPurchases()+"\n"
               +"Alchemy Lab Purchases:"+BuildingLogic.getAlchemyLabPurchases()+"\n"
               +"Portal Purchases:"+BuildingLogic.getPortalPurchases()+"\n"
               +"Time Machine Purchases:"+BuildingLogic.getTimeMachinePurchases()+"\n"
               +"Antimatter Condenser Purchases:"+BuildingLogic.getAntimatterCondenserPurchases()+"\n"
               +"Prism Purchases:"+BuildingLogic.getPrismPurchases()+"\n"
               +"Chancemaker Purchases:"+BuildingLogic.getChancemakerPurchases()+"\n"
               +"Fractal Engine Purchases:"+BuildingLogic.getFractalEnginePurchases()+"\n"
               +"Java Console Purchases:"+BuildingLogic.getJavaConsolePurchases()+"\n"
               +"Idleverse Purchases:"+BuildingLogic.getIdleversePurchases()+"\n"
               +"Cortex Baker Purchases:"+BuildingLogic.getCortexBakerPurchases()+"\n"
               +"You Purchases:"+BuildingLogic.getYouPurchases()+"\n"
               +"Cursor CPS Mult:"+CPSMult.getCursorCPSMult()+"\n"
               +"Grandma CPS Mult:"+CPSMult.getGrandmaCPSMult()+"\n"
               +"Farm CPS Mult:"+CPSMult.getFarmCPSMult()+"\n"
               +"Mine CPS Mult:"+CPSMult.getMineCPSMult()+"\n"
               +"Factory CPS Mult:"+CPSMult.getFactoryCPSMult()+"\n"
               +"Bank CPS Mult:"+CPSMult.getBankCPSMult()+"\n"
               +"Temple CPS Mult:"+CPSMult.getTempleCPSMult()+"\n"
               +"Wizard Tower CPS Mult:"+CPSMult.getWizardTowerCPSMult()+"\n"
               +"Shipment CPS Mult:"+CPSMult.getShipmentCPSMult()+"\n"
               +"Alchemy Lab CPS Mult:"+CPSMult.getAlchemyLabCPSMult()+"\n"
               +"Portal CPS Mult:"+CPSMult.getPortalCPSMult()+"\n"
               +"Time Machine CPS Mult:"+CPSMult.getTimeMachineCPSMult()+"\n"
               +"Antimatter Condenser CPS Mult:"+CPSMult.getAntimatterCondenserCPSMult()+"\n"
               +"Prism CPS Mult:"+CPSMult.getPrismCPSMult()+"\n"
               +"Chancemaker CPS Mult:"+CPSMult.getChancemakerCPSMult()+"\n"
               +"Fractal Engine CPS Mult:"+CPSMult.getFractalEngineCPSMult()+"\n"
               +"Java Console CPS Mult:"+CPSMult.getJavaConsoleCPSMult()+"\n"
               +"Idleverse CPS Mult:"+CPSMult.getIdleverseCPSMult()+"\n"
               +"Cortex Baker CPS Mult:"+CPSMult.getCortexBakerCPSMult()+"\n"
               +"You CPS Mult:"+CPSMult.getYouCPSMult()+"\n"
               +"Base CPS Mult:"+CPSMult.getBaseCPSMult()+"\n"
               +"Have a Cookie!";
       Files.writeString(Path.of("save.txt"),text);
   }

    //Load Function, Source: https://www.w3schools.com/java/java_bufferedreader.asp
    public void LoadFromFile() throws IOException{
        Scanner LoadReader = new Scanner(Paths.get("save.txt"));
        String test = LoadReader.nextLine();
        String identifier = test.split(":")[0];

        while (LoadReader.hasNextLine()) {
            BigDecimal num = new BigDecimal(test.split(":")[1]);
            switch(identifier){
                case "Cookie Count":
                    BuildingLogic.cookieCount = num;
                    break;
                case "Cookies Per Click":
                    BuildingLogic.CookiesPerClick = num;
                    break;
                case "Cookies Per Second":
                    BuildingLogic.CookiesPerSecond = num;
                    break;
                case "Cursor Purchases":
                    BuildingLogic.CursorPurchases = num.intValue();
                    break;
                case "Grandma Purchases":
                    BuildingLogic.GrandmaPurchases = num.intValue();
                    break;
                case "Farm Purchases":
                    BuildingLogic.FarmPurchases = num.intValue();
                    break;
                case "Mine Purchases":
                    BuildingLogic.MinePurchases = num.intValue();
                    break;
                case "Factory Purchases":
                    BuildingLogic.FactoryPurchases = num.intValue();
                    break;
                case "Bank Purchases":
                    BuildingLogic.BankPurchases = num.intValue();
                    break;
                case "Temple Purchases":
                    BuildingLogic.TemplePurchases = num.intValue();
                    break;
                case "Wizard Tower Purchases":
                    BuildingLogic.WizardTowerPurchases = num.intValue();
                    break;
                case "Shipment Purchases":
                    BuildingLogic.ShipmentPurchases = num.intValue();
                    break;
                case "Alchemy Lab Purchases":
                    BuildingLogic.AlchemyLabPurchases = num.intValue();
                    break;
                case "Portal Purchases":
                    BuildingLogic.PortalPurchases = num.intValue();
                    break;
                case "Time Machine Purchases":
                    BuildingLogic.TimeMachinePurchases = num.intValue();
                    break;
                case "Antimatter Condenser Purchases":
                    BuildingLogic.AntimatterCondenserPurchases = num.intValue();
                    break;
                case "Prism Purchases":
                    BuildingLogic.PrismPurchases = num.intValue();
                    break;
                case "Chancemaker Purchases":
                    BuildingLogic.ChancemakerPurchases = num.intValue();
                    break;
                case "Fractal Engine Purchases":
                    BuildingLogic.FractalEnginePurchases = num.intValue();
                    break;
                case "Java Console Purchases":
                    BuildingLogic.JavaConsolePurchases = num.intValue();
                    break;
                case "Idleverse Purchases":
                    BuildingLogic.IdleversePurchases = num.intValue();
                    break;
                case "Cortex Baker Purchases":
                    BuildingLogic.CortexBakerPurchases = num.intValue();
                    break;
                case "You Purchases":
                    BuildingLogic.YouPurchases = num.intValue();
                    break;
                case "Cursor CPS Mult":
                    CPSMult.CursorCPSMult=num.doubleValue();
                    break;
                case "Grandma CPS Mult":
                    CPSMult.GrandmaCPSMult=num.doubleValue();
                    break;
                case "Farm CPS Mult":
                    CPSMult.FarmCPSMult=num.doubleValue();
                    break;
                case "Mine CPS Mult":
                    CPSMult.MineCPSMult=num.doubleValue();
                    break;
                case "Factory CPS Mult":
                    CPSMult.FactoryCPSMult=num.doubleValue();
                    break;
                case "Bank CPS Mult":
                    CPSMult.BankCPSMult=num.doubleValue();
                    break;
                case "Temple CPS Mult":
                    CPSMult.TempleCPSMult=num.doubleValue();
                    break;
                case "Wizard Tower CPS Mult":
                    CPSMult.WizardTowerCPSMult=num.doubleValue();
                    break;
                case "Shipment CPS Mult":
                    CPSMult.ShipmentCPSMult=num.doubleValue();
                    break;
                case "Alchemy Lab CPS Mult":
                    CPSMult.AlchemyLabCPSMult=num.doubleValue();
                    break;
                case "Portal CPS Mult":
                    CPSMult.PortalCPSMult=num.doubleValue();
                    break;
                case "Time Machine CPS Mult":
                    CPSMult.TimeMachineCPSMult=num.doubleValue();
                    break;
                case "Antimatter Condenser CPS Mult":
                    CPSMult.AntimatterCondenserCPSMult=num.doubleValue();
                    break;
                case "Prism CPS Mult":
                    CPSMult.PrismCPSMult=num.doubleValue();
                    break;
                case "Chancemaker CPS Mult":
                    CPSMult.ChancemakerCPSMult=num.doubleValue();
                    break;
                case "Fractal Engine CPS Mult":
                    CPSMult.FractalEngineCPSMult=num.doubleValue();
                    break;
                case "Java Console CPS Mult":
                    CPSMult.JavaConsoleCPSMult=num.doubleValue();
                    break;
                case "Idleverse CPS Mult":
                    CPSMult.IdleverseCPSMult=num.doubleValue();
                    break;
                case "Cortex Baker CPS Mult":
                    CPSMult.CortexBakerCPSMult=num.doubleValue();
                    break;
                case "You CPS Mult":
                    CPSMult.YouCPSMult=num.doubleValue();
                    break;
                case "Base CPS Mult":
                    CPSMult.BaseCPSMult=num.doubleValue();
                    break;
                default:
                    break;
            }

            test = LoadReader.nextLine();
            identifier=test.split(":")[0];
        }
    }
}