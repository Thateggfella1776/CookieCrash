import java.math.BigDecimal;
import java.util.TimerTask;
import java.util.Timer;
import java.math.BigInteger;


public class Buildings {

    //variables and such
    BigDecimal cookieCount = new BigDecimal ("0.0");
    BigDecimal CookiesPerClick = new BigDecimal("1.0");
    BigDecimal CookiesPerSecond = new BigDecimal("0.0");
    int Building1Purchases = 0;
    int Building1BaseCost = 15;
    int Building2Purchases = 0;
    int Building2BaseCost = 100;
    int Building3Purchases = 0;
    int Building3BaseCost = 1_100;
    int Building4Purchases = 0;
    int Building4BaseCost = 12_000;
    int Building5Purchases = 0;
    int Building5BaseCost = 130_000;
    int Building6Purchases = 0;
    int Building6BaseCost = 1_400_000;
    int Building7Purchases = 0;
    int Building7BaseCost = 20_000_000;
    int Building8Purchases = 0;
    int Building8BaseCost = 330_000_000;
    int Building9Purchases = 0;
    long Building9BaseCost = 5_100_000_000L;
    int Building10Purchases = 0;
    long Building10BaseCost = 75_000_000_000L;
    int Building11Purchases = 0;
    long Building11BaseCost = 1_000_000_000_000L;
    int Building12Purchases = 0;
    long Building12BaseCost = 14_000_000_000_000L;
    int Building13Purchases = 0;
    long Building13BaseCost = 170_000_000_000_000L;
    int Building14Purchases = 0;
    long Building14BaseCost = 2_100_000_000_000_000L;
    int Building15Purchases = 0;
    long Building15BaseCost = 26_000_000_000_000_000L;
    int Building16Purchases = 0;
    long Building16BaseCost = 310_000_000_000_000_000L;
    int Building17Purchases = 0;
    BigInteger Building17BaseCost = new BigInteger("71000000000000000000");
    int Building18Purchases = 0;
    BigInteger Building18BaseCost = new BigInteger("12000000000000000000000");
    int Building19Purchases = 0;
    BigInteger Building19BaseCost = new BigInteger("1900000000000000000000000");
    int Building20Purchases = 0;
    BigInteger Building20BaseCost = new BigInteger("540000000000000000000000000");
    Timer CPSTimer = new Timer();



    //return for necessary variables
    public BigDecimal getCookieCount(){return cookieCount;}
    public BigDecimal getCookiesPerClick(){return CookiesPerClick;}
    public BigDecimal getCookiesPerSecond(){return CookiesPerSecond;}
    public int getBuilding1Purchases(){return Building1Purchases;}
    public int getBuilding2Purchases(){return Building2Purchases;}
    public int getBuilding3Purchases(){return Building3Purchases;}
    public int getBuilding4Purchases(){return Building4Purchases;}
    public int getBuilding5Purchases(){return Building5Purchases;}
    public int getBuilding6Purchases(){return Building6Purchases;}
    public int getBuilding7Purchases(){return Building7Purchases;}
    public int getBuilding8Purchases(){return Building8Purchases;}
    public int getBuilding9Purchases(){return Building9Purchases;}
    public int getBuilding10Purchases(){return Building10Purchases;}
    public int getBuilding11Purchases(){return Building11Purchases;}
    public int getBuilding12Purchases(){return Building12Purchases;}
    public int getBuilding13Purchases(){return Building13Purchases;}
    public int getBuilding14Purchases(){return Building14Purchases;}
    public int getBuilding15Purchases(){return Building15Purchases;}
    public int getBuilding16Purchases(){return Building16Purchases;}
    public int getBuilding17Purchases(){return Building17Purchases;}
    public int getBuilding18Purchases(){return Building18Purchases;}
    public int getBuilding19Purchases(){return Building19Purchases;}
    public int getBuilding20Purchases(){return Building20Purchases;}

    public void Click(){
        cookieCount = cookieCount.add(CookiesPerClick);
    }

    public void AutoTimer() {
        CPSTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                cookieCount=cookieCount.add(CookiesPerSecond);
            }
        },0,1000);
    }

    public int getBuilding1Cost(){
        //15(base cost)*(1.15)^(times purchased)
        return (int) Math.round(Building1BaseCost *Math.pow(1.15, Building1Purchases));
    }

    public boolean buyUpgrade1(){
        int cost = getBuilding1Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building1Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(0.5));
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
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building2Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1));
            return true;
        }
        return false;
    }

    public int getBuilding3Cost(){
        return (int) Math.round(Building3BaseCost *Math.pow(1.15, Building3Purchases));
    }

    public boolean buyBuilding3(){
        int cost = getBuilding3Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building3Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(8));
            return true;
        }
        return false;
    }

    public int getBuilding4Cost(){
        return (int) Math.round(Building4BaseCost *Math.pow(1.15, Building4Purchases));
    }

    public boolean buyBuilding4(){
        int cost = getBuilding4Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building4Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(47));
            return true;
        }
        return false;
    }

    public int getBuilding5Cost(){
        return (int) Math.round(Building5BaseCost *Math.pow(1.15, Building5Purchases));
    }

    public boolean buyBuilding5(){
        int cost = getBuilding5Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building5Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(260));
            return true;
        }
        return false;
    }

    public int getBuilding6Cost(){
        return (int) Math.round(Building6BaseCost *Math.pow(1.15, Building6Purchases));
    }

    public boolean buyBuilding6(){
        int cost = getBuilding6Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building6Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1400));
        }
        return false;
    }

    public int getBuilding7Cost(){
        return (int) Math.round(Building7BaseCost *Math.pow(1.15, Building7Purchases));
    }

    public boolean buyBuilding7(){
        int cost = getBuilding7Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building7Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(7800));
        }
        return false;
    }

    public int getBuilding8Cost(){
        return (int) Math.round(Building8BaseCost *Math.pow(1.15, Building8Purchases));
    }
    public boolean buyBuilding8(){
        int cost = getBuilding8Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building8Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(44000L));
        }
        return false;
    }

    public int getBuilding9Cost(){return (int) Math.round(Building9BaseCost *Math.pow(1.15, Building9Purchases));}
    public boolean buyBuilding9(){
        int cost = getBuilding9Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building9Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(2200000L));
        }
        return false;
    }

    public long getBuilding10Cost(){return (long) Math.round(Building10BaseCost *Math.pow(1.15, Building10Purchases));}
    public boolean buyBuilding10(){
        long cost = getBuilding10Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building10Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1600000L));
        }
        return false;
    }

    public long getBuilding11Cost(){return (long) Math.round(Building11BaseCost *Math.pow(1.15, Building11Purchases));}
    public boolean buyBuilding11(){
        long cost = getBuilding11Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building11Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(10000000L));
        }
        return false;
    }

    public long getBuilding12Cost(){return (long) Math.round(Building12BaseCost *Math.pow(1.15, Building12Purchases));}
    public boolean buyBuilding12(){
        long cost = getBuilding12Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building12Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(65000000L));
        }
        return false;
    }

    public long getBuilding13Cost(){return (long) Math.round(Building13BaseCost *Math.pow(1.15, Building13Purchases));}
    public boolean buyBuilding13(){
        long cost = getBuilding13Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building13Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(430000000L));
        }
        return false;
    }

    public long getBuilding14Cost(){return (long) Math.round(Building14BaseCost *Math.pow(1.15, Building14Purchases));}
    public boolean buyBuilding14(){
        long cost = getBuilding14Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building14Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(2900000000L));
        }
        return false;
    }

    public long getBuilding15Cost(){return (long) Math.round(Building15BaseCost *Math.pow(1.15, Building15Purchases));}
    public boolean buyBuilding15(){
        long cost = getBuilding15Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building15Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(21000000000L));
        }
        return false;
    }

    public long getBuilding16Cost(){return (long) Math.round(Building16BaseCost *Math.pow(1.15, Building16Purchases));}
    public boolean buyBuilding16(){
        long cost = getBuilding16Cost();
        if(cookieCount.compareTo(BigDecimal.valueOf(cost))>=0){
            cookieCount=cookieCount.subtract(BigDecimal.valueOf(cost));
            Building16Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(150000000000L));
        }
        return false;
    }

    public long getBuilding17Cost(){return Building17BaseCost.multiply(BigInteger.valueOf(Building17Purchases)).longValue();}
    public boolean buyBuilding17(){
        BigDecimal cost = BigDecimal.valueOf(getBuilding17Cost());
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            Building17Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(1100000000000L));
        }
        return false;
    }

    public long getBuilding18Cost(){return Building18BaseCost.multiply(BigInteger.valueOf(Building18Purchases)).longValue();}
    public boolean buyBuilding18(){
        BigDecimal cost = BigDecimal.valueOf(getBuilding18Cost());
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            Building18Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(8300000000000L));
        }
        return false;
    }

    public long getBuilding19Cost(){return Building19BaseCost.multiply(BigInteger.valueOf(Building19Purchases)).longValue();}
    public boolean buyBuilding19(){
        BigDecimal cost = BigDecimal.valueOf(getBuilding19Cost());;
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            Building19Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(64000000000000L));
        }
        return false;
    }

    public long getBuilding20Cost(){return Building20BaseCost.multiply(BigInteger.valueOf(Building20Purchases)).longValue();}
    public boolean buyBuilding20(){
        BigDecimal cost = BigDecimal.valueOf(getBuilding20Cost());
        if(cookieCount.compareTo(cost)>=0){
            cookieCount=cookieCount.subtract(cost);
            Building20Purchases++;
            CookiesPerSecond=CookiesPerSecond.add(BigDecimal.valueOf(510000000000000L));
        }
        return false;
    }

}