import java.util.Scanner;
import java.util.Arrays;

/*
 *
 * Attempting to make a text-based graphical game using concepts from Dark Souls.
 *
 */
public class DarkSouls{
   //public static void clear(){System.out.print("\033[H\033[2J");} //end method
   
   public static void printbattle(Human player, Human enemy){
      String spaces = "                                                                                             ";
      String[] ph = player.gethelm().icon();
      String[] pc = player.getchest().icon();
      String[] pl = player.getlegs().icon();
      String[] pw = player.getwep().icon();
      
      String[] eh = enemy.gethelm().icon();
      String[] ec = enemy.getchest().icon();
      String[] el = enemy.getlegs().icon();
      String[] ew = enemy.getwep().icon();
      
      String[] graphic = new String[70];
      Arrays.fill(graphic, "");
      
      int lc = 69; //lc stands for line count
      
      int i;
      int wfix = pc[0].length() - pl[0].length();
      //int lfix = 4;
      if (wfix < 4){wfix=0;}
      else{wfix-=4;}
      for (i = (pl.length-1); i > -1; i--){ //PLAYER LEGS
         graphic[lc]+="    "+pl[i]+spaces.substring(0, wfix);
         lc--;
      } //end for loop
      
      for (i = (pc.length-1); i > -1; i--){ //PLAYER CHEST
         graphic[lc]+=pc[i];
         lc--;
      } //end for loop
      
      for (i = (ph.length-1); i > -1; i--){ //PLAYER HELM
         graphic[lc]+="  "+ph[i];
         lc--;
      } //end for loop
      
      lc = (graphic.length-pl.length);
      for (i = (pw.length-1); i > -1; i--){ //PLAYER WEAPON
         graphic[lc]+=" "+pw[i];
         lc--;
      } //end for loop
      
      System.out.print(arrtostr(graphic));
   } //end method
   
   public static void sleep(double seconds){
      try {
         Thread.sleep((int)(seconds*1000));}
      catch(InterruptedException ex) {
         Thread.currentThread().interrupt();}
   } // end method
   
   public static void travel(String destination){
      String[] figurine = {"     k\n  O  |\n()Y==o\n /_\\ |\n _W_ |\n"," o\n|\\O   )\n \\Y==d\n /_\\\n / >\n"," 0   \\0\n/0--- :\\\n/ >  / >\n"};
      System.out.println("Traveling to "+destination);
      for (int i = 0; i < 3; i++){
         sleep(0.5);
         System.out.println(figurine[i]);
      } // end for loop
      System.out.println("Arrived at: "+destination);
      sleep(0.4);
   } //end method
   
   public static String[] options(String[] buttons){
      String spaces="                          ";
      String[] finals = {"","",""};
      String fix="";
      int in=0;
      for (int i=0; i<buttons.length; i++){
         fix=spaces.substring(0, 10-buttons[i].length());
         finals[0]+=spaces.substring(0,in)+"  ____________";
         finals[1]+=" |"+(i+1)+fix.substring(0, fix.length()/2)+buttons[i]+fix.substring(fix.length()/2)+(i+1)+"|";
         finals[2]+=spaces.substring(0,in)+"  ¯¯¯¯¯¯¯¯¯¯¯¯";
         in=1;
      } //end for
      return finals;
   } //end class
   public static String arrtostr(String[] strarr){
      String newstring = "";
      for (String s: strarr){
         newstring+=s+"\n";
      } //end for loop
      return newstring;
   } //end method
   
   public static int mapchoice(int progression){
      int choice=-1;
      Scanner s = new Scanner(System.in);
      String[] map = new String[27];
      Arrays.fill(map, "");
      if (progression>=1){map[15]+="          _______";
                          map[16]+="         /       \\";
                          map[17]+="         |Logan's|";
                          map[18]+="         |Castle |";
                          map[19]+="         \\_______/ 1.";
                          map[20]+="            |";
                          map[21]+="            |";
                          map[22]+="            |";
                          map[23]+="   _______  /";
                          map[24]+="  /       \\/";
                          map[25]+="  | Shrine|";
                          map[26]+="  \\_______/";
                          } //end if
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
                          } //end if
      if (progression>=3){map[0]+="         ________";
                          map[1]+="        /        \\";
                          map[2]+="       /      ___|_____";
                          map[3]+="      /      / Spooky  \\";
                          map[4]+="     /       |Cathedral|";
                          map[5]+="     |       \\_________/ 3.";
                          map[6]+="     |";
                          } //end if
      if (progression>=4){map[6]+="           |";
                          map[7]+="         \\___________";
                          map[8]+="                    \\";
                          map[9]+="         \\";
                          map[10]+="         |";
                          map[11]+="        |    ______";
                          map[12]+="       |   / Dark \\";
                          map[13]+="      \\___|Swampy|";
                          map[14]+="          \\Place /";
                          map[15]+="            \\____/ 4.";
                          } //end if
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
                          map[22]+="                         |                |       |    The   |       |";
                          map[23]+="                         |                |       |   Meme   |       |";
                          map[24]+="                          |                |       | Dimension|       |";
                          map[25]+="                           \\________________|       |    5.    |       |";
                          map[26]+="                                            |       |          |       |";
                          } //end if
      System.out.println(arrtostr(map));
      while (choice>progression || choice<0){
         if (s.hasNextInt()){
            choice=s.nextInt();
         } //end if
         else{System.out.println("Please select a level");
              s.nextLine();}
      } //end while
      return choice;
   } //end method
   
   public static void Shrine(){
   
   
   } //end method
   
   public static int battle(int area, int progression){
      
      return progression;
   } //end method
   
   public static int[] rungame(int[] profile){
      int mchoice=0;
      int progression=5;
      String[] maps = {"Shrine","Logan's Castle","Bone Zone","Spooky Cathedral","Dark Swampy Place","The Meme Dimension"};
      mchoice=mapchoice(progression);
      travel(maps[mchoice]);
      if (mchoice==0){Shrine();}
      else{progression = battle(mchoice, progression);}
      return profile;
   } //end method
   
   public static void main(String[] Args){
      int choice=3;
      int[] profile = new int[6];
      Scanner s = new Scanner(System.in);
      System.out.println("Welcome to Dark Souls!\nPrepare to die!");
      String[] firstops = {"New Game","Continue","Quit"};
      System.out.println(arrtostr(options(firstops)));
      
      Human player = new Human(Armor.knighthelm, Armor.sunbrochest, Armor.polishedgreaves, Weapon.flamingsword);
      Human enemy = new Human();
      printbattle(player, enemy);
      if (s.hasNextInt()){
         choice=s.nextInt();
         if (choice==1){
           profile=rungame(profile);
         
         } //new game
         else if (choice==2){
         
         
         } //Continue
         else if (choice==3){
            System.exit(0);
         } //Quit
         System.out.println("Save Here");
      } //end if



   } //end main
} //end class