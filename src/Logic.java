import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
               +"Have a Cookie!";
       Files.writeString(Path.of("save.txt"),text);
   }

    //Load Function, Source: https://www.w3schools.com/java/java_bufferedreader.asp
    public void LoadFromFile() throws IOException{
        Scanner LoadReader = new Scanner(Paths.get("save.txt"));
        String test = LoadReader.nextLine();
        String identifier = test.split(":")[0];

        while (LoadReader.hasNextLine()) {
            double num = Double.valueOf(test.split(":")[1]);
            if(identifier.equals("Cookie Count")){
                BuildingLogic.cookieCount = num;
            }else if(identifier.equals("Cookies Per Click")){
                BuildingLogic.CookiesPerClick = num;
            }else if(identifier.equals("Cookies Per Second")){
                    BuildingLogic.CookiesPerSecond = num;
            }else if(identifier.equals("Building 1 Purchases")){
                    BuildingLogic.Building1Purchases = (int)num;
            }else if(identifier.equals("Building 2 Purchases")) {
                BuildingLogic.Building2Purchases = (int)num;
            }
            test = LoadReader.nextLine();
            identifier=test.split(":")[0];
        }
    }
}