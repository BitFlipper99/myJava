import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

/*
 *
 * Attempting to make a text-based graphical game using concepts from Dark Souls.
 *
 */
public class DarkSouls{
   //public static void clear(){System.out.print("\033[H\033[2J");} //end method
   
   private static boolean playing = true;
   private static int progression = 0;
   private static int titanite = 0;
   
   private static Human player = new Human();
   private static final String[][] MAPSFONT = {
  {"  _________.__          .__               ",
   " /   _____/|  |_________|__| ____   ____  ",
   " \\_____  \\ |  |  \\_  __ \\  |/    \\_/ __ \\ ",
   " /        \\|   Y  \\  | \\/  |   |  \\  ___/ ",
   "/_______  /|___|  /__|  |__|___|  /\\___  >",
   "        \\/      \\/              \\/     \\/ "},

  {"   __                        _        ___          _   _      ",
   "  / /  ___   __ _  __ _ _ __( )__    / __\\__ _ ___| |_| | ___ ",
   " / /  / _ \\ / _` |/ _` | '_ \\/ __|  / /  / _` / __| __| |/ _ \\",
   "/ /__| (_) | (_| | (_| | | | \\__ \\ / /__| (_| \\__ \\ |_| |  __/",
   "\\____/\\___/ \\__, |\\__,_|_| |_|___/ \\____/\\__,_|___/\\__|_|\\___|",
   "            |___/                                             "},

  {" ____                     ______                ",
   "|  _ \\                   |___  /                ",
   "| |_) | ___  _ __   ___     / / ___  _ __   ___ ",
   "|  _ < / _ \\| '_ \\ / _ \\   / / / _ \\| '_ \\ / _ \\",
   "| |_) | (_) | | | |  __/  / /_| (_) | | | |  __/",
   "|____/ \\___/|_| |_|\\___| /_____\\___/|_| |_|\\___|"},
   
  {"   ______                                               _           ______         _   __                   __                 __   ", 
   " .' ___  |                                             | |        .' ___  |       / |_[  |                 |  ]               [  |  ", 
   "/ .'   \\_| _ .--.  .---.  .--./)  .--.   _ .--.  _   __\\_|.--.   / .'   \\_| ,--. `| |-'| |--.  .---.   .--.| |  _ .--.  ,--.   | |  ",
   "| |   ____[ `/'`\\]/ /__\\\\/ /'`\\;/ .'`\\ \\[ `/'`\\][ \\ [  ] ( (`\\]  | |       `'_\\ : | |  | .-. |/ /__\\\\/ /'`\\' | [ `/'`\\]`'_\\ :  | |  ",
   "\\ `.___]  || |    | \\__.,\\ \\._//| \\__. | | |     \\ '/ /   `'.'.  \\ `.___.'\\// | |,| |, | | | || \\__.,| \\__/  |  | |    // | |, | |  ",
   " `._____.'[___]    '.__.'.',__`  '.__.' [___]  [\\_:  /   [\\__) )  `.____ .'\\'-;__/\\__/[___]|__]'.__.' '.__.;__][___]   \\'-;__/[___] ",
   "                        ( ( __))                \\__.'                                                                               "},
   
  {" _______ .-. .-.,---.    ,---.   ,-.      .--.    ,--,  ,-. .-. ",
   "|__   __|| | | || .-'    | .-.\\  | |     / /\\ \\ .' .')  | |/ /  ",
   "  )| |   | `-' || `-.    | |-' \\ | |    / /__\\ \\|  |(_) | | /   ",
   " (_) |   | .-. || .-'    | |--. \\| |    |  __  |\\  \\    | | \\   ",
   "   | |   | | |)||  `--.  | |`-' /| `--. | |  |)| \\  `-. | |) \\  ",
   "   `-'   /(  (_)/( __.'  /( `--' |( __.'|_|  (_)  \\____\\|((_)-' ",
   "        (__)   (__)     (__)     (_)                    (_)     "},
   
  {"       __                     ____  _                           _           ",
   "      / /___ __   ______ _   / __ \\(_)___ ___  ___  ____  _____(_)___  ____ ",
   " __  / / __ `/ | / / __ `/  / / / / / __ `__ \\/ _ \\/ __ \\/ ___/ / __ \\/ __ \\",
   "/ /_/ / /_/ /| |/ / /_/ /  / /_/ / / / / / / /  __/ / / (__  ) / /_/ / / / /",
   "\\____/\\__,_/ |___/\\__,_/  /_____/_/_/ /_/ /_/\\___/_/ /_/____/_/\\____/_/ /_/ "}};
  
   private static final String[] MAPS = {"Shrine","Logan's Castle","Bone Zone","Gregory's Cathedral","The Black","Java Dimension"};
   private static ArrayList<Human> enemies = new ArrayList<Human>();
   
   // h c l w
   
   protected static void campaign(){
      enemies.add(new Human(Armor.smallskull, Armor.tatteredshirt, Armor.tatteredcloths, Weapon.dagger)); //level 0
      enemies.add(new Human(Armor.skull, Armor.cleanshirt, Armor.tatteredcloths, Weapon.mace)); //level 1
      enemies.add(new Human(Armor.featherhead, Armor.feathercoat, Armor.jesterpants, Weapon.magpolearm)); //level 2
      enemies.add(new Human(Armor.sunbrohelm, Armor.sunbrochest, Armor.polishedgreaves, Weapon.basicsword)); //level 3
      enemies.add(new Human(Armor.fathelm, Armor.sunbrochest, Armor.leathergreaves, Weapon.katana)); //level 4
      enemies.add(new Human(Armor.knighthelm, Armor.spikedcuirass, Armor.plateleggings, Weapon.flamingsword)); //level 5
   }
   
   public static void printbattle(Human player, Human enemy){
      boolean dofix = false;
      String spaces = "                                                                                                                                                      ";
      String[] ph = player.gethelm().icon();
      String[] pc = player.getchest().icon();
      String[] pl = player.getlegs().icon();
      String[] pw = player.getwep().icon();
      
      String[] eh = enemy.gethelm().icon();
      String[] ec = enemy.getchest().icon();
      String[] el = enemy.getlegs().icon();
      String[] ew = enemy.getwep().icon();
      
      int pheight = ph.length + pc.length + pl.length;
      int eheight = eh.length + ec.length + el.length;
      
      int length  = pheight;
      if (pheight < eheight) length = eheight;      
      
      int x = pc[0].length() - pl[0].length();
      String plfix = spaces(x/2);
      int y = pc[0].length() - ph[0].length();
      String phfix = spaces(y/2);
      String[] graphic = new String[length+5];
      Arrays.fill(graphic, "");
      int i;
      int lc = graphic.length-1; //lc stands for line count

      dofix = (x%2 == 1);
      for (i = (pl.length-1); i > -1; i--){ //PLAYER LEGS
         if (dofix){graphic[lc]+=" ";}
         graphic[lc]+=plfix+pl[i]+plfix;
         lc--;
      } //end for loop
      
      for (i = (pc.length-1); i > -1; i--){ //PLAYER CHEST
         graphic[lc]+=pc[i];
         lc--;
      } //end for loop
      
      dofix = (y%2 == 1);
      for (i = (ph.length-1); i > -1; i--){ //PLAYER HELM
         if (dofix){graphic[lc]+=" ";}
         graphic[lc]+=phfix+ph[i]+phfix;
         lc--;
      } //end for loop

      for (lc = (graphic.length - (pheight+1)); lc > -1; lc--){ //ADD PHANTOM HELMET
         graphic[lc]+=spaces(phfix.length() * 2 + ph[0].length() + 1);
      } //end for loop

      lc = graphic.length-1;
      for (i = (pl.length-2); i > -1; i--){ //FIX LEGGING SPACE
         graphic[lc]+=spaces(pw[0].length()+1);
         lc--;
      } //end for loop

      for (lc = graphic.length - (pl.length + pw.length); lc > -1; lc--){ //FIX ABOVE PWEAPON
         graphic[lc]+=spaces(pw[0].length() + 1);
      } //end for loop
      
      lc = (graphic.length-pl.length);
      for (i = (pw.length-1); i > -1; i--){ //PLAYER WEAPON
         graphic[lc]+=" "+pw[i];
         lc--;
      } //end for loop

      for (lc = graphic.length-1; lc > -1; lc--){graphic[lc]+="                                     ";}// CREATE MIDDLE SPACE (maybe options later)
      
      //BEGIN ADDING ENEMY HERE
      lc = (graphic.length-el.length);
      for (i = (ew.length-1); i > -1; i--){ //ENEMY WEAPON
         graphic[lc]+=ew[i]+" ";
         lc--;
      } //end for loop

      for (lc = graphic.length-1; lc > (graphic.length - el.length); lc--){graphic[lc] += spaces(ew[0].length()+1);} //FIX BELOW WEAPON
      for (lc = graphic.length - (el.length + ew.length); lc > -1; lc--){graphic[lc] += spaces(ew[0].length()+1);} //FIX ABOVE WEAPON
      
      x = ec[0].length() - el[0].length();
      String elfix = spaces(x/2);
      y = ec[0].length() - eh[0].length();
      String ehfix = spaces(y/2);
      
      lc = graphic.length-1;
      dofix = (x%2 == 1);
      for (i = el.length-1; i > -1; i--){ //ENEMY LEGS
         if (dofix){graphic[lc]+=" ";}
         graphic[lc]+=elfix+el[i]+elfix;
         lc--;
      } //end for loop
      
      for (i = (ec.length-1); i > -1; i--){ //ENEMY CHEST
         graphic[lc]+=ec[i];
         lc--;
      } //end for loop
      
      dofix = (y%2 == 1);
      for (i = (eh.length-1); i > -1; i--){ //ENEMY HELM
         if (dofix){graphic[lc]+=" ";}
         graphic[lc]+=ehfix+eh[i]+ehfix;
         lc--;
      } //end for loop
      
      System.out.print(arrtostr(graphic));
      
      System.out.println((spaces((pl[0].length() / 2) - 4)) + "Player Health: 100" + spaces(graphic[graphic.length-1].length() - (pl[0].length() + el[0].length() + 6)) + "Enemy Health: 100");
      
   } //end method
   
   public static void sleep(double seconds){
      try {
         Thread.sleep((int)(seconds*1000));}
      catch(InterruptedException ex) {
         Thread.currentThread().interrupt();}
   } // end method
   
   public static void travel(int destination){
      String[] figurine = {"     k\n  O  |\n()Y==o\n /_\\ |\n _W_ |\n"," o\n|\\O   )\n \\Y==d\n /_\\\n / >\n"," 0   \\0\n/0--- :\\\n/ >  / >\n"};
      System.out.println("Traveling to " + MAPS[destination]);
      for (int i = 0; i < 3; i++){
         sleep(0.5);
         System.out.println(figurine[i]);
      } // end for loop
      System.out.println("Arrived at: ");
      sleep(0.4);
      
      if (destination == 0 && progression != 0) Shrine();
      else{progression = battle(destination, progression);}
   } // end method
   
   public static void options(String[] buttons){
      String spaces="                                                                    ";
      String[] finals = new String[3];
      Arrays.fill(finals, "");
      String fix="";
      int in=0;
      for (int i=0; i<buttons.length; i++){
         fix=spaces(10-buttons[i].length());
         finals[0]+=spaces(in)+"  ____________";
         finals[1]+=" |"+(i+1)+fix.substring(0, fix.length()/2)+buttons[i]+fix.substring(fix.length()/2)+(i+1)+"|";
         finals[2]+=spaces(in)+"  ¯¯¯¯¯¯¯¯¯¯¯¯";
         in=1;
      } // end for
      System.out.print(arrtostr(finals));
   } // end class
   public static String arrtostr(String[] strarr){
      String newstring = "";
      for (String s: strarr){
         newstring+=s+"\n";
      } // end for loop
      return newstring;
   } // end method
   
   public static int mapchoice(int progression){
      int choice=-1;
      Scanner s = new Scanner(System.in);
      String[] map = new String[27];
      Arrays.fill(map, "");
                          map[23]+="   _______  /";
                          map[24]+="  /       \\/";
                          map[25]+="  | Shrine|";
                          map[26]+="0.\\_______/";
      if (progression>=1){map[15]+="          _______";
                          map[16]+="         /       \\";
                          map[17]+="         |Logan's|";
                          map[18]+="         |Castle |";
                          map[19]+="         \\_______/ 1.";
                          map[20]+="            |";
                          map[21]+="            |";
                          map[22]+="            |";
                          } // end if
      if (progression>=2){map[7]+="    _|__";
                          map[8]+="   /    \\";
                          map[9]+="   |Bone|____________";
                          map[10]+="   |Zone|            \\";
                          map[11]+="   \\____/ 2.          \\";
                          map[12]+="                       \\";
                          map[13]+="                        |";
                          map[14]+="                        /";
                          map[15]+="      /";
                          map[16]+="    /";
                          map[17]+="___/";
                          } // end if
      if (progression>=3){map[0]+="         ________";
                          map[1]+="        /        \\";
                          map[2]+="       /      ___|_____";
                          map[3]+="      /      /Gregory's\\";
                          map[4]+="     /       |Cathedral|";
                          map[5]+="     |       \\_________/ 3.";
                          map[6]+="     |";
                          } // end if
      if (progression>=4){map[6]+="           |";
                          map[7]+="         \\___________";
                          map[8]+="                    \\";
                          map[9]+="         \\";
                          map[10]+="         |";
                          map[11]+="        |    ______";
                          map[12]+="       |   /      \\";
                          map[13]+="      \\___|  The |";
                          map[14]+="          \\ Black/";
                          map[15]+="            \\____/ 4.";
                          } // end if
      if (progression>=5){map[10]+="                      ___ ___ ___        ___ ___ ___";
                          map[11]+="            | | | | | |        | | | | | |";
                          map[12]+="           | |_| |_| |        | |_| |_| |";
                          map[13]+="           \\         /        \\         /";
                          map[14]+="            |       |          |       |";
                          map[15]+="          |       |          |       |";
                          map[16]+="               |                |       |          |       |";
                          map[17]+="                |                |       |__________|       |";
                          map[18]+="                    |                |                          |";
                          map[19]+="                 |                |        __________        |";
                          map[20]+="                         |                |       /          \\       |";
                          map[21]+="                         |                |       |          |       |";
                          map[22]+="                         |                |       |          |       |";
                          map[23]+="                         |                |       |   Java   |       |";
                          map[24]+="                          |                |       | Dimension|       |";
                          map[25]+="                           \\________________|       |    5.    |       |";
                          map[26]+="                                            |       |          |       |";
                          } // end if
      System.out.print(" ___       ________  ________  ________  _________  ___  ___  ________  ___  ________     \n"
                     +"|\\  \\     |\\   __  \\|\\   ____\\|\\   __  \\|\\___   ___\\\\  \\|\\  \\|\\   __  \\|\\  \\|\\   ____\\    \n"
                     +"\\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\ \\  \\___|    \n"
                     +" \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  __\\ \\   __  \\   \\ \\  \\ \\ \\   __  \\ \\   _  _\\ \\  \\ \\  \\       \n"
                     +"  \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\ \\  \\____  \n"
                     +"   \\ \\_______\\ \\_______\\ \\_______\\ \\__\\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\__\\ \\_______\\\n"
                     +"    \\|_______|\\|_______|\\|_______|\\|__|\\|__|    \\|__|  \\|__|\\|__|\\|__|\\|__|\\|__|\\|_______|\n");
      System.out.println(arrtostr(map));
      while (choice>progression || choice<0){
         if (s.hasNextInt()){
            choice=s.nextInt();
         } // end if
         else{System.out.println("Please select a level");
              s.nextLine();}
      } // end while
      return choice;
   } // end method

   public static String spaces(int spaces) {
      String str = "";
      if (spaces < 1) return str;
      for (int i = 0; i < spaces; i++) str+=" ";
      return str;
   } // end method
   
   public static int battle(int area, int progression){
      Scanner s = new Scanner(System.in);
      boolean win = false, parry = false, counter = false, cparry = false, ccounter = false, pstun=false, cstun=false;
      System.out.println(arrtostr(MAPSFONT[area]));
      sleep(1); //lets look at the title for a sec
      printbattle(player, enemies.get(area));
      int php = 100, ehp = 100, choice, cchoice, rint, rint2;
      int[] hpchange = {0,0};
      int[] playerchoices = {6,7,8};
      int tcount = 0;
      
      Random rand = new Random();
      
      ArrayList<String> fightoptions = new ArrayList<String>();
      fightoptions.add("Attack");                                                        //Attack = attack with physical strength
      fightoptions.add("Magic");                                                         //Magic  = cast spell and deal damage
      if (player.getwep().weight() < 7) {fightoptions.add("Parry"); parry=true;}         //Parry  = block attack and stun  (on success)
      else{fightoptions.add("Block");}                                                   //Block  = negate physical damage
      if (player.getmres() > 16) {fightoptions.add("Counter"); counter=true;}            //Counter= disable spell and stun (on success)
      else{fightoptions.add("Roll");}                                                    //Roll   = negate magic damage\
      
      Human opp = enemies.get(area);
      ArrayList<String> compoptions = new ArrayList<String>();
      compoptions.add("Attack");                                                        //Attack = attack with physical strength
      compoptions.add("Magic");                                                         //Magic  = cast spell and deal damage
      if (opp.getwep().weight() < 7) {compoptions.add("Parry"); cparry=true;}         //Parry  = block attack and stun  (on success)
      else{compoptions.add("Block");}                                                   //Block  = negate physical damage
      if (opp.getmres() > 16) {compoptions.add("Counter"); ccounter=true;}            //Counter= disable spell and stun (on success)
      else{compoptions.add("Roll");}                                                    //Roll   = negate magic damage
      
      

      options(fightoptions.toArray(new String[fightoptions.size()]));
      
      fightoptions.add("Stunned!");
      compoptions.add("Stunned!");

      System.out.println("Your HP:          Opp Hp:");
      while (php > 0 && ehp > 0){ //nobody is dead yet
         System.out.println("  "+php+"                "+ehp);
         choice = 0;
         if (!pstun){
            while (choice < 1 || choice > fightoptions.size() || pstun){
               while (!s.hasNextInt()) {
                  if (s.hasNextLine()) {
                     System.out.println("Invalid input!");
                     s.nextLine();
                  } //end if
               } //end while
               if (s.hasNextInt()){
                  choice=s.nextInt();
                  s.nextLine();
               } // end if
               else{System.out.println("Please select an action");s.nextLine();}  
            } //end parameter check
         } //end if
         else{choice = 5; tcount--;} //stunned
         //PROGRAMMING AI
         if (!cstun){
            rint = rand.nextInt(100) + 1;
            rint2 = rand.nextInt(100) + 1;
            if ((playerchoices[0] == playerchoices[1] && playerchoices[1] == playerchoices[2]) && !pstun){ //genetic algorithm to learn (not really haha)...(but sort of)
               if (playerchoices[0] < 3){cchoice = playerchoices[0] + 2;}
               else{cchoice = (playerchoices[0] - ((playerchoices[0]%3)*2 + 1));}
            } //end if
            else if ((playerchoices[0] == playerchoices[2]) && !pstun){  //computer algorithm logic enhancement
               if (playerchoices[1] < 3){cchoice = playerchoices[1] + 2;}
               else{cchoice = (playerchoices[1] - ((playerchoices[1]%3)*2 + 1));}
            } //end if
            else if ((playerchoices[0] == playerchoices[1]) && !pstun){  //computer algorithm logic enhancement
               if (playerchoices[2] < 3){cchoice = playerchoices[2] + 2;}
               else{cchoice = (playerchoices[2] - ((playerchoices[2]%3)*2 + 1));}
            } //end if
            else if ((playerchoices[1] == playerchoices[2]) && !pstun){  //computer algorithm logic enhancement
               if (playerchoices[0] < 3){cchoice = playerchoices[0] + 2;}
               else{cchoice = (playerchoices[0] - ((playerchoices[0]%3)*2 + 1));}
               
            } //end if
            else if ((rint > (60 - (opp.getweight()/2))) || pstun){ //ATTACK
               if (rint2 > (50 - (5 * opp.getwep().pdam() - opp.getwep().mdam()))){cchoice = 1;}  //PHYSICAL
               else{cchoice = 2;} //MAGICAL
            } //end if   
            
            else{
               if (rint2 > (50 - (opp.getpres() - opp.getmres()) + (3 * (player.getwep().mdam() - player.getwep().pdam())))){cchoice = 3;} //PHYSICAL BLOCK
               else{cchoice = 4;} //MAGICAL BLOCK
            } //end else
         } //end if
         
         else{cchoice = 5;} //stunned
         sleep(0.5);
         if (choice != 5){playerchoices[tcount%3] = choice;}
         //EVALUATION
         pstun=false;
         cstun=false;    
         hpchange = evalhp(choice, cchoice, opp, parry, counter, cparry, ccounter);
         if (hpchange[0] == -1){pstun=true;}
         else if (hpchange[1] == -1){cstun=true;}
         else{
            php-=hpchange[0];
            ehp-=hpchange[1];
         } //end else
         System.out.println("  "+fightoptions.get(choice-1)+"            "+compoptions.get(cchoice-1));
         if (hpchange[0] == -1){pstun=true;System.out.println("   Player Stunned");}
         if (hpchange[1] == -1){cstun=true;System.out.println("            Computer Stunned");}  
         tcount++;
      } //end while
      System.out.println("  "+php+"                "+ehp+"\n");
      if (php > 0){win = true;}
      
      if (!win){
         System.out.println(
          " _________     ____      _____   _____       __    __   ______      _____  \n"
         +"(_   _____)   (    )    (_   _) (_   _)      ) )  ( (  (   __ \\    / ___/  \n"
         +"  ) (___      / /\\ \\      | |     | |       ( (    ) )  ) (__) )  ( (__    \n"
         +" (   ___)    ( (__) )     | |     | |        ) )  ( (  (    __/    ) __)   \n"
         +"  ) (         )    (      | |     | |   __  ( (    ) )  ) \\ \\  _  ( (      \n"
         +" (   )       /  /\\  \\    _| |__ __| |___) )  ) \\__/ (  ( ( \\ \\_))  \\ \\___  \n"
         +"  \\_/       /__(  )__\\  /_____( \\________/   \\______/   )_) \\__/    \\____\\ \n");
         progression = 0;
      } //end if
      
      if (area == progression && win){progression++; titanite+=area;loot(area);}
      return progression;
   } // end method
   
   public static void loot(int area){
      Random rand = new Random();
      boolean isarmor = true;
      String treasure = "null";
      int luck = rand.nextInt(3);
      Armor loot = Armor.crown;
      Weapon wloot = Weapon.legendarysword;
      
      if (luck == 0){
      treasure = enemies.get(area).gethelm().name();
      loot = enemies.get(area).gethelm(); } //helmet
      
      else if (luck == 1){
      treasure = enemies.get(area).getchest().name(); //chest
      loot = enemies.get(area).getchest();}
      
      else if (luck == 2){
      treasure = enemies.get(area).getlegs().name(); //leggings
      loot = enemies.get(area).getlegs();}
      
      else if (luck == 3){
      treasure = enemies.get(area).getwep().name();
      isarmor = false;
      wloot = enemies.get(area).getwep();} //weapon

      System.out.println("The foe you defeated dropped: "+treasure+"\nAnd "+(area+1)+" Titanite Shard(s)!\nYou now have: "+(titanite+area+1)+" Titanite Shards.");
      if (isarmor){System.out.println(arrtostr(loot.icon()));}
      else{System.out.println(arrtostr(wloot.icon()));}
      String[] options = {"Take it","Leave it"};
      options(options);
      int choice = getinput(2);
      if (choice == 1){
         if (luck == 0){player.sethelm(loot);}
         else if (luck == 1){player.setchest(loot);}
         else if (luck == 2){player.setlegs(loot);}
         else if (luck == 3){player.setwep(wloot);}
      } //end if
   } //end method
   
   
   public static int[] evalhp(int pc, int cc, Human opp, boolean parry, boolean counter, boolean cparry, boolean ccounter){
      boolean chit = false;
      Random rand = new Random();
      int[] hp = {0,0};
      
      if (pc == 5){chit=true;} //player stunned
      
      else if (pc == 1 && cc != 3){ //player attacked successfully
         hp[1] = rand.nextInt(6) + player.getwep().pdam();
         chit = true;
         if (hp[0] == 5 + opp.getwep().pdam()){System.out.println("\nPlayer Critical Physical Strike!!!");}
      } //end if 
      
      else if (pc == 1 && cc == 3){ //player was blocked or parried
         if (cparry){hp[0] = -1;}
         else{hp[0] = 0;}
         hp[1] = 0;
      } //end else if
         
      else if (pc == 2 && cc != 4){ //player attacked magic success
         hp[1] = rand.nextInt(6) + player.getwep().mdam();
         chit = true;
         if (hp[0] == 5 + opp.getwep().pdam()){System.out.println("\nPlayer Critical Magic Strike!!!");}
      } //end else if
      
      else if (pc == 2 && cc == 4){ //player was rolled or counter
         if (ccounter){hp[0] = -1;}
         else{hp[0] = 0;}
         hp[1] = 0;
      } //end else if 
      
      else if (pc == 3 && cc == 1){
      if (parry){hp[1] = -1;}
      else{hp[1] = 0;}
      hp[0] = 0;} //player blocked
      
      else if (pc == 4 && cc == 2){
      if (counter){hp[1] = -1;}
      else{hp[1] = 0;}
      hp[0] = 0;} //player rolled
      
      if ((pc == 4 && cc == 1) || (pc == 3 && cc == 2)){chit = true;}
      if (cc == 5){chit = false;} //computer stunned
      if (chit && (cc != 3 || cc!= 4)){
         if (cc == 1){
            hp[0] = rand.nextInt(opp.getwep().pdam()*2) + opp.getwep().pdam();
            if (hp[0] >= (opp.getwep().pdam()*2 - (opp.getwep().pdam() / 2))){System.out.println("\nOpponent Critical Physical Strike!!!");}
         } //end if
         else if (cc == 2){
            hp[0] = rand.nextInt(opp.getwep().pdam()*2) + opp.getwep().mdam();
            if (hp[0] >= (opp.getwep().mdam()*2 - (opp.getwep().mdam() / 2))){System.out.println("\nOpponent Critical Magic Strike!!!");}
         } //end else if 
      } //end if
      
      return hp;
   } //end method
   
   //public static void shop(){
      
   public static void Shrine(){ //not implemented
      System.out.println("Save feature not yet implemented, sorry.\nComeback with 100 titanite for a suprise!");
      if (titanite >= 100){player.setwep(Weapon.legendarysword);}
      int[] profile = new int[6];
      rungame(profile);
   } // end method
   
   public static int[] rungame(int[] profile){
      int mchoice = 0;
      while (playing){
         mchoice = mapchoice(progression);
         travel(mchoice);
     } //end while
      return profile;
   } // end method
   
   public static int getinput(int max){
      Scanner s = new Scanner(System.in);
      int choice = -1;
      while (choice < 1 || choice > max){
               while (!s.hasNextInt()) {
                  if (s.hasNextLine()) {
                     System.out.println("Invalid input!");
                     s.nextLine();
                  } //end if
               } //end while
               if (s.hasNextInt()){
                  choice=s.nextInt();
                  s.nextLine();
               } // end if
               else{System.out.println("Please select an action");s.nextLine();}  
            } //end parameter check
      return choice;
   } //end method
   
   public static void main(String[] Args){
      
      campaign();
      int choice = 3;
      int[] profile = new int[6];
      Scanner s = new Scanner(System.in);
      
      String[] firstops = {"New Game","Continue","Quit"};
      
      System.out.println( "                             _____\n"
                          +"             ,             /@@@@@=-\n"
                          +"             \\\\            @@@@@@@@@@=-\n"
                          +"              \\\\          _\\@/\\@@@@@=-\n"
                          +"               \\\\        /_ +\\ \\@@@@@=-\n"
                          +"         ,      \\\\      (_/   )  \\@@@@=-\n"
                          +"         \\\\      \\\\     (_____)    \\@@=-\n"
                          +"         _\\\\_/\\_ _\\\\__  /     \\     ~~\n"
                          +"   ____,/+-  `/\\\\  { \\_|___(__ )\n"
                          +"  >             \\\\  )_|/  ___  \\\n"
                          +"  \\_/--\\___/     \\\\.` / <-q-p-> \\\n"
                          +"     _//   )      \\(\\/\\ <-d-b-> /___\n"
                          +"  _____  /         \\/ \\  \\|/  //   \\__\n"
                          +"  /     \\/          /   \\_____//     \\_\\\n"
                          +"  | /\\_  |         (_  /______\\\\     |||\n"
                          +"  | \\_ | |         | \\|   <    \\\\    /||\n"
                          +"  \\_\\_\\ \\/     ____\\  |____\\    \\)  / ||\n"
                          +"        /    _/  <____)\\    (      / //\\\\\n"
                          +"       /   _/           \\    \\    (  \\\\//\n"
                          +"      (   /              )  / \\    \\  \\/\n"
                          +"      /  /              /  /   \\    )\n"
                          +"  ---/  /--------------/  /-----)  /-----\n"
                          +"   _/__/ Logan souls  /__/      /  /\n"
                          +"  /__/               /__/     _/__/\n"
                          +"                             /__/");

      options(firstops);
      

      
      while (!s.hasNextInt()) {
         if (s.hasNextLine()) {
            System.out.println("Invalid input!");
            s.nextLine();
         }
      }
      
      if (s.hasNextInt()){
         choice=s.nextInt();
         if (choice==1){
           profile=rungame(profile);
         
         } // new game
         else if (choice==2){
         
         
         } // Continue
         else if (choice==3){
            System.exit(0);
         } // Quit
         System.out.println("Save Here");
      } // end if



   } //end main
} //end class