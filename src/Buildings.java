import java.util.TimerTask;
import java.util.Timer;


public class Buildings {

    //variables and such
    Double cookieCount = 0.0;
    Double CookiesPerClick = 1.0;
    Double CookiesPerSecond = 0.0;
    int Building1Purchases = 0;
    int Building1BaseCost = 15;
    int Building2Purchases = 0;
    int Building2BaseCost = 100;
    int Building3Purchases = 0;
    int Building3BaseCost = 1100;
    int Building4Purchases = 0;
    int Building4BaseCost = 12000;
    int Building5Purchases = 0;
    int Building5BaseCost = 130000;
    int Building6Purchases = 0;
    int Building6BaseCost = 1400000;
    Timer CPSTimer = new Timer();



    //return for necessary variables
    public Double getCookieCount(){return cookieCount;}
    public Double getCookiesPerClick(){return CookiesPerClick;}
    public Double getCookiesPerSecond(){return CookiesPerSecond;}
    public int getBuilding1Purchases(){return Building1Purchases;}
    public int getBuilding2Purchases(){return Building2Purchases;}
    public int getBuilding3Purchases(){return Building3Purchases;}
    public int getBuildingTotal(){return Building1Purchases+Building2Purchases+Building3Purchases;}

    public void Click(){
        cookieCount+=CookiesPerClick;
    }

    public void AutoTimer() {
        CPSTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                cookieCount+=CookiesPerSecond;
            }
        },0,1000);
    }

    public int getBuilding1Cost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(Building1BaseCost *Math.pow(1.15, Building1Purchases));
    }

    public boolean buyUpgrade1(){
        int cost = getBuilding1Cost();
        if(cookieCount>=cost){
            cookieCount-=cost;
            Building1Purchases++;
            CookiesPerSecond+=0.5;
            return true;
        }
        return false;
    }

    public int getBuilding2Cost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(Building2BaseCost *Math.pow(1.15, Building2Purchases));
    }

    public boolean buyUpgrade2(){
        int cost = getBuilding2Cost();
        if(cookieCount>=cost){
            cookieCount-=cost;
            Building2Purchases++;
            CookiesPerSecond++;
            return true;
        }
        return false;
    }

    public int getBuilding3Cost(){
        return (int) Math.round(Building3BaseCost *Math.pow(1.15, Building3Purchases));
    }

    public boolean buyBuilding3(){
        int cost = getBuilding3Cost();
        if(cookieCount>=cost){
            cookieCount-=cost;
            Building3Purchases++;
            CookiesPerSecond+=8;
            return true;
        }
        return false;
    }


}