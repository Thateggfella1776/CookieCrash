import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;

public class Logic {
   Buildings BuildingLogic;
   public Logic(Buildings buildings){
       this.BuildingLogic=buildings;
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
                default:
                    break;
            }

            test = LoadReader.nextLine();
            identifier=test.split(":")[0];
        }
    }
}