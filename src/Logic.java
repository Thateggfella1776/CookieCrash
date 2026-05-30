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
               +"Building 1 Purchases:"+BuildingLogic.getBuilding1Purchases()+"\n"
               +"Building 2 Purchases:"+BuildingLogic.getBuilding2Purchases()+"\n"
               +"Building 3 Purchases:"+BuildingLogic.getBuilding3Purchases()+"\n"
               +"Building 4 Purchases:"+BuildingLogic.getBuilding4Purchases()+"\n"
               +"Building 5 Purchases:"+BuildingLogic.getBuilding5Purchases()+"\n"
               +"Building 6 Purchases:"+BuildingLogic.getBuilding6Purchases()+"\n"
               +"Building 7 Purchases:"+BuildingLogic.getBuilding7Purchases()+"\n"
               +"Building 8 Purchases:"+BuildingLogic.getBuilding8Purchases()+"\n"
               +"Building 9 Purchases:"+BuildingLogic.getBuilding9Purchases()+"\n"
               +"Building 10 Purchases:"+BuildingLogic.getBuilding10Purchases()+"\n"
               +"Building 11 Purchases:"+BuildingLogic.getBuilding11Purchases()+"\n"
               +"Building 12 Purchases:"+BuildingLogic.getBuilding12Purchases()+"\n"
               +"Building 13 Purchases:"+BuildingLogic.getBuilding13Purchases()+"\n"
               +"Building 14 Purchases:"+BuildingLogic.getBuilding14Purchases()+"\n"
               +"Building 15 Purchases:"+BuildingLogic.getBuilding15Purchases()+"\n"
               +"Building 16 Purchases:"+BuildingLogic.getBuilding16Purchases()+"\n"
               +"Building 17 Purchases:"+BuildingLogic.getBuilding17Purchases()+"\n"
               +"Building 18 Purchases:"+BuildingLogic.getBuilding18Purchases()+"\n"
               +"Building 19 Purchases:"+BuildingLogic.getBuilding19Purchases()+"\n"
               +"Building 20 Purchases:"+BuildingLogic.getBuilding20Purchases()+"\n"
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
                    BuildingLogic.Building1Purchases = num.intValue();
                    break;
                case "Building 2 Purchases":
                    BuildingLogic.Building2Purchases = num.intValue();
                    break;
                case "Building 3 Purchases":
                    BuildingLogic.Building3Purchases = num.intValue();
                    break;
                case "Building 4 Purchases":
                    BuildingLogic.Building4Purchases = num.intValue();
                    break;
                case "Building 5 Purchases":
                    BuildingLogic.Building5Purchases = num.intValue();
                    break;
                case "Building 6 Purchases":
                    BuildingLogic.Building6Purchases = num.intValue();
                    break;
                case "Building 7 Purchases":
                    BuildingLogic.Building7Purchases = num.intValue();
                    break;
                case "Building 8 Purchases":
                    BuildingLogic.Building8Purchases = num.intValue();
                    break;
                case "Building 9 Purchases":
                    BuildingLogic.Building9Purchases = num.intValue();
                    break;
                case "Building 10 Purchases":
                    BuildingLogic.Building10Purchases = num.intValue();
                    break;
                case "Building 11 Purchases":
                    BuildingLogic.Building11Purchases = num.intValue();
                    break;
                case "Building 12 Purchases":
                    BuildingLogic.Building12Purchases = num.intValue();
                    break;
                case "Building 13 Purchases":
                    BuildingLogic.Building13Purchases = num.intValue();
                    break;
                case "Building 14 Purchases":
                    BuildingLogic.Building14Purchases = num.intValue();
                    break;
                case "Building 15 Purchases":
                    BuildingLogic.Building15Purchases = num.intValue();
                    break;
                case "Building 16 Purchases":
                    BuildingLogic.Building16Purchases = num.intValue();
                    break;
                case "Building 17 Purchases":
                    BuildingLogic.Building17Purchases = num.intValue();
                    break;
                case "Building 18 Purchases":
                    BuildingLogic.Building18Purchases = num.intValue();
                    break;
                case "Building 19 Purchases":
                    BuildingLogic.Building19Purchases = num.intValue();
                    break;
                case "Building 20 Purchases":
                    BuildingLogic.Building20Purchases = num.intValue();
                    break;
                default:
                    break;
            }

            test = LoadReader.nextLine();
            identifier=test.split(":")[0];
        }
    }
}