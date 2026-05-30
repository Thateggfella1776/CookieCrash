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
               +"Building 1 Purchases:"+BuildingLogic.getCursorPurchases()+"\n"
               +"Building 2 Purchases:"+BuildingLogic.getGrandmaPurchases()+"\n"
               +"Building 3 Purchases:"+BuildingLogic.getFarmPurchases()+"\n"
               +"Building 4 Purchases:"+BuildingLogic.getMinePurchases()+"\n"
               +"Building 5 Purchases:"+BuildingLogic.getFactoryPurchases()+"\n"
               +"Building 6 Purchases:"+BuildingLogic.getBankPurchases()+"\n"
               +"Building 7 Purchases:"+BuildingLogic.getTemplePurchases()+"\n"
               +"Building 8 Purchases:"+BuildingLogic.getWizardTowerPurchases()+"\n"
               +"Building 9 Purchases:"+BuildingLogic.getShipmentPurchases()+"\n"
               +"Building 10 Purchases:"+BuildingLogic.getAlchemyLabPurchases()+"\n"
               +"Building 11 Purchases:"+BuildingLogic.getPortalPurchases()+"\n"
               +"Building 12 Purchases:"+BuildingLogic.getTimeMachinePurchases()+"\n"
               +"Building 13 Purchases:"+BuildingLogic.getAntimatterCondenserPurchases()+"\n"
               +"Building 14 Purchases:"+BuildingLogic.getPrismPurchases()+"\n"
               +"Building 15 Purchases:"+BuildingLogic.getChancemakerPurchases()+"\n"
               +"Building 16 Purchases:"+BuildingLogic.getFractalEnginePurchases()+"\n"
               +"Building 17 Purchases:"+BuildingLogic.getJavaConsolePurchases()+"\n"
               +"Building 18 Purchases:"+BuildingLogic.getIdleversePurchases()+"\n"
               +"Building 19 Purchases:"+BuildingLogic.getCortexBakerPurchases()+"\n"
               +"Building 20 Purchases:"+BuildingLogic.getYouPurchases()+"\n"
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
                case "Building 1 Purchases":
                    BuildingLogic.CursorPurchases = num.intValue();
                    break;
                case "Building 2 Purchases":
                    BuildingLogic.GrandmaPurchases = num.intValue();
                    break;
                case "Building 3 Purchases":
                    BuildingLogic.FarmPurchases = num.intValue();
                    break;
                case "Building 4 Purchases":
                    BuildingLogic.MinePurchases = num.intValue();
                    break;
                case "Building 5 Purchases":
                    BuildingLogic.FactoryPurchases = num.intValue();
                    break;
                case "Building 6 Purchases":
                    BuildingLogic.BankPurchases = num.intValue();
                    break;
                case "Building 7 Purchases":
                    BuildingLogic.TemplePurchases = num.intValue();
                    break;
                case "Building 8 Purchases":
                    BuildingLogic.WizardTowerPurchases = num.intValue();
                    break;
                case "Building 9 Purchases":
                    BuildingLogic.ShipmentPurchases = num.intValue();
                    break;
                case "Building 10 Purchases":
                    BuildingLogic.AlchemyLabPurchases = num.intValue();
                    break;
                case "Building 11 Purchases":
                    BuildingLogic.PortalPurchases = num.intValue();
                    break;
                case "Building 12 Purchases":
                    BuildingLogic.TimeMachinePurchases = num.intValue();
                    break;
                case "Building 13 Purchases":
                    BuildingLogic.AntimatterCondenserPurchases = num.intValue();
                    break;
                case "Building 14 Purchases":
                    BuildingLogic.PrismPurchases = num.intValue();
                    break;
                case "Building 15 Purchases":
                    BuildingLogic.ChancemakerPurchases = num.intValue();
                    break;
                case "Building 16 Purchases":
                    BuildingLogic.FractalEnginePurchases = num.intValue();
                    break;
                case "Building 17 Purchases":
                    BuildingLogic.JavaConsolePurchases = num.intValue();
                    break;
                case "Building 18 Purchases":
                    BuildingLogic.IdleversePurchases = num.intValue();
                    break;
                case "Building 19 Purchases":
                    BuildingLogic.CortexBakerPurchases = num.intValue();
                    break;
                case "Building 20 Purchases":
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