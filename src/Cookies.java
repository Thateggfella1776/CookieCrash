
 class Cookies {

    //variables and such
    int cookieCount = 0;
    int CookiesPerClick = 1;
    int AutoCookies = 0;
    int Upgrade1Purchases = 0;
    int Upgrade1BaseCost = 15;
    int Upgrade2Purchases = 0; //First of the "auto clickers" for now possibly will be moved to buildings
    int Upgrade2BaseCost = 100;

    //return for necessary variables
    public int getCookieCount(){return cookieCount;}
    public int getCookiesPerClick(){return CookiesPerClick;}
    public int getAutoCookies(){return AutoCookies;}
    public int getUpgrade1Purchases(){return Upgrade1Purchases;}
    public int getUpgrade2Purchases(){return Upgrade2Purchases;}

    public void Click(){
        cookieCount+=CookiesPerClick;
    }

    public void AutoClick(){
        cookieCount+=AutoCookies;
    }

    public int getUpgrade2Cost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(Upgrade2BaseCost*Math.pow(1.15,Upgrade2Purchases));
    }

    public boolean buyUpgrade2(){
        int cost = getUpgrade2Cost();
        if(cookieCount>=cost){
            cookieCount-=cost;
            Upgrade2Purchases++;
            AutoCookies++;
            return true;
        }
        return false;
    }


    public int getUpgrade1Cost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(Upgrade1BaseCost*Math.pow(1.15,Upgrade1Purchases));
    }

    public boolean buyUpgrade1(){
        int cost = getUpgrade1Cost();
        if(cookieCount>=cost){
            cookieCount-=cost;
            Upgrade1Purchases++;
            CookiesPerClick++;
            return true;
        }
        return false;
    }
}