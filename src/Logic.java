import java.io.*;

public class Logic {
   Buildings BuildingLogic;
   public Logic(Buildings buildings){
       this.BuildingLogic=buildings;
   }

    //Save Function, Source:https://www.youtube.com/shorts/MvzzBvbiwjk?feature=share
    public void SaveToFile(){
        try {
            BufferedWriter SaveFile = new BufferedWriter(new FileWriter("save.txt",false));
            SaveFile.write("Current Cookies: "+BuildingLogic.getCookieCount()+
                    "\nCookies per click: "+BuildingLogic.getCookiesPerClick()+
                    "\nAuto Cookies: "+BuildingLogic.getCookiesPerSecond()+
                    "\nBuilding 1 purchases: "+BuildingLogic.getBuilding1Purchases()+
                    "\nBuilding 2 purchases: "+BuildingLogic.getBuilding2Purchases()+
                    "\nHave a cookie");
            SaveFile.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Load Function, Source: https://www.w3schools.com/java/java_bufferedreader.asp
    public void LoadFromFile(){
        try(BufferedReader SaveReader = new BufferedReader(new FileReader("save.txt"))){
            String line;
            while((line = SaveReader.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}