package Dragcave;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Dragcave {
    private static long time = 500;
    private static Hashtable<String, String> wantedEggs = new Hashtable<String, String>();
    private static Hashtable<String, String> rareEggs = new Hashtable<String, String>();
    private static LinkedList<String> gottenEggs = new LinkedList<String>();
    private static LinkedList<String> eggs = new LinkedList<String>();
    private static Map<String, String > cookies;
    private static ScheduledExecutorService clock;
    private static String username = "";
    private static String password = "";

    public static void main(String[] args) {
    	/*if (args.length > 0) {
    		username = args[0];
    		password = args[1];
    	}*/
    	
        setRareEggs();
        setWantedEggs();
        login();
        //setEggLocations();

        clock = Executors.newSingleThreadScheduledExecutor();
        clock.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int minute = LocalDateTime.now().getMinute();
                int second = LocalDateTime.now().getSecond();
                if ((minute + 1) % 10 == 5 || (minute + 1) % 10 == 0 || minute % 10 == 0 || minute % 10 == 5) {
                    if (second % 2 == 0) {
                        if ((minute % 10 == 0 || minute % 10 == 5) && second <= 30) {
                            setEggLocations();
                        } else if (((minute + 1) % 10 == 5 || (minute + 1) % 10 == 0) && second >= 46) {
                            setEggLocations();
                        }
                    }
                }
                if (second % 10 == 0) {
                    System.out.println("");
                    System.out.println(wantedEggs.size());
                } else {
                    System.out.print(minute + ":" + second + "  ");
                }
                if (minute % 15 == 0) {
                    gottenEggs.clear();
                    eggs.clear();
                }
            }
        }, 0, time, TimeUnit.MILLISECONDS);
    }

    @Deprecated
    private static void setTime(long num) {
        time = num;
    }

    private static void setRareEggs() {
        String Xenowyrm = "Mana courses throughout this glassy egg.";
        String BlueDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.";
        String BlusangLindwurm = "This egg smells faintly like brine.";
        String CheeseDragon = "This egg is soft and smells uncannily like cheese.";
        String Chicken = "This egg is much smaller than the others.";
        String Copper = "This egg gleams with a reddish shine.";
        String GoldDragon = "This egg is very reflective, almost metallic-looking.";
        String GoldenWyvren = "This egg shimmers like gold.";
        String GreenDino = "This egg looks like it doesn't belong; it is brightly colored with white spots.";
        String IceDragon = "This egg has icicles forming on it.";
        String MagmaDragon = "This egg is almost too hot to touch.";
        String PaperDragon = "This egg is tiny and made out of several pieces of paper folded together.";
        String RedDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.";
        String SilverDragon = "This egg gives off a beautiful glow.";
        String ThunderDragon = "Whenever you go near this egg, your hair stands on end.";
        String YellowDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.";
        rareEggs.put(Xenowyrm, "Xenowyrm");
        rareEggs.put(BlueDino, "BlueDino");
        rareEggs.put(BlusangLindwurm, "BlusangLindwurm");
        rareEggs.put(CheeseDragon, "CheeseDragon");
        rareEggs.put(Chicken, "Chicken");
        rareEggs.put(Copper, "Copper");
        rareEggs.put(GoldDragon, "GoldDragon");
        rareEggs.put(GoldenWyvren, "GoldenWyvren");
        rareEggs.put(GreenDino, "GreenDino");
        rareEggs.put(IceDragon, "IceDragon");
        rareEggs.put(MagmaDragon, "MagmaDragon");
        rareEggs.put(PaperDragon, "PaperDragon");
        rareEggs.put(RedDino, "RedDino");
        rareEggs.put(SilverDragon, "SilverDragon");
        rareEggs.put(ThunderDragon, "ThunderDragon");
        rareEggs.put(YellowDino, "YellowDino");
    }

    private static void setWantedEggs() {
        String Xenowyrm = "Mana courses throughout this glassy egg.";
        String BlueDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.";
        String BlusangLindwurm = "This egg smells faintly like brine.";
        String CheeseDragon = "This egg is soft and smells uncannily like cheese.";
        String Chicken = "This egg is much smaller than the others.";
        String Copper = "This egg gleams with a reddish shine.";
        String GoldDragon = "This egg is very reflective, almost metallic-looking.";
        String GoldenWyvren = "This egg shimmers like gold.";
        String GreenDino = "This egg looks like it doesn't belong; it is brightly colored with white spots.";
        String IceDragon = "This egg has icicles forming on it.";
        String MagmaDragon = "This egg is almost too hot to touch.";
        String PaperDragon = "This egg is tiny and made out of several pieces of paper folded together.";
        String RedDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.";
        String SilverDragon = "This egg gives off a beautiful glow.";
        String ThunderDragon = "Whenever you go near this egg, your hair stands on end.";
        String YellowDino = "This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.";
        wantedEggs.put(Xenowyrm, Xenowyrm);
        wantedEggs.put(BlueDino, BlueDino);
        wantedEggs.put(BlusangLindwurm, BlusangLindwurm);
        wantedEggs.put(CheeseDragon, CheeseDragon);
        wantedEggs.put(Chicken, Chicken);
        wantedEggs.put(Copper, Copper);
        wantedEggs.put(GoldDragon, GoldDragon);
        wantedEggs.put(GoldenWyvren, GoldenWyvren);
        wantedEggs.put(GreenDino, GreenDino);
        wantedEggs.put(IceDragon, IceDragon);
        wantedEggs.put(MagmaDragon, MagmaDragon);
        wantedEggs.put(PaperDragon, PaperDragon);
        wantedEggs.put(RedDino, RedDino);
        wantedEggs.put(SilverDragon, SilverDragon);
        wantedEggs.put(ThunderDragon, ThunderDragon);
        wantedEggs.put(YellowDino, YellowDino);
    }
    private static void login() {
        try {
            Document loginPage = Jsoup.connect("http://dragcave.net/login").get();
            Element loginElement = loginPage.getElementsByClass("_11_6").get(0);
            FormElement loginForm = (FormElement) loginElement;
            Connection con = loginForm.submit();
            Connection.Response loginResponse = con.data("username", username, "password", password).execute();
            cookies = loginResponse.cookies();
        } catch (Exception e) {
                System.out.println("Login error: " + e);
        }
    }

    private static void getEggs(LinkedList<Element> locations) {
        try {
            for (Element location : locations) {
                for (Element e : location.children()) {
                    String description = e.ownText();
                    String eggLink = e.child(0).attr("href");
                    checkEggLink(eggLink);
                    if (wantedEggs.containsKey(description)) {
                        Connection get = Jsoup.connect("http://dragcave.net" + eggLink).cookies(cookies);
                        Connection.Response resultResponse = get.cookies(cookies).execute();
                        Document resultDocument = resultResponse.parse();
                        Element resultElement = resultDocument.children().get(0).getElementsByClass("_w_0")
                                .get(0).getElementsByClass("_w_2").get(0).getElementById("middle");
                        String result = resultElement.children().get(0).text();
                        getEggResult(result, description, eggLink);
                        Thread.sleep(1000);
                    }
                    if (rareEggs.containsKey(description)) {
                        String rareEgg = rareEggs.get(description);
                        eggs.add(rareEgg);
                    }
                    System.out.println(description + " " + eggLink);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    private static void setEggLocations(){
        try {
            Document Alpine = Jsoup.connect("http://dragcave.net/locations/5").cookies(cookies).get();
            Document Coast = Jsoup.connect("http://dragcave.net/locations/1").cookies(cookies).get();
            Document Desert = Jsoup.connect("http://dragcave.net/locations/2").cookies(cookies).get();
            Document Forest = Jsoup.connect("http://dragcave.net/locations/3").cookies(cookies).get();
            Document Jungle = Jsoup.connect("http://dragcave.net/locations/4").cookies(cookies).get();
            Document Volcano = Jsoup.connect("http://dragcave.net/locations/6").cookies(cookies).get();
            Element AlpineEggs = Alpine.getElementsByClass("eggs").get(0);
            Element CoastEggs = Coast.getElementsByClass("eggs").get(0);
            Element DesertEggs = Desert.getElementsByClass("eggs").get(0);
            Element ForestEggs = Forest.getElementsByClass("eggs").get(0);
            Element JungleEggs = Jungle.getElementsByClass("eggs").get(0);
            Element VolcanoEggs = Volcano.getElementsByClass("eggs").get(0);
            LinkedList<Element> eggs = new LinkedList<Element>();
            eggs.add(AlpineEggs);
            eggs.add(CoastEggs);
            eggs.add(DesertEggs);
            eggs.add(ForestEggs);
            eggs.add(JungleEggs);
            eggs.add(VolcanoEggs);
            getEggs(eggs);
        } catch (Exception e) {

        }
    }

    private static void getEggResult(String result, String description, String link) {
        if (result == "You are already overburdened and decide not to stress yourself by taking this egg.") {
            System.out.println("You are overburdened!");
        } else if (result == "Sorry, this egg has already been taken by somebody else.") {
            getGottenEggs().add(rareEggs.get(description) + " has been taken by somebody else." + " Link: " + link);
        } else{
            String name = rareEggs.get(description);
            gottenEggs.add(name);
        }
    }

    private static void checkEggLink(String link) {
        if (link.equals("/register")) {
            login();
        }
    }

    public static void stop() {
        clock.shutdown();
    }

    public static LinkedList<String> getGottenEggs() {
        return gottenEggs;
    }

    public static LinkedList<String> getEggs() {
        return eggs;
    }

    public static void changeWantedEggs(String description, Boolean bol) {
        if (bol == true) {
            wantedEggs.put(description, description);
        } else {
            wantedEggs.remove(description);
        }
    }

    public static void clearGottenEggs() {
        gottenEggs.clear();
    }

    public static void clearEggs() {
        eggs.clear();
    }
}