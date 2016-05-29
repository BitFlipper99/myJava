import javax.swing.*;

public class Weapon{
   private String name;
   private int pdam;
   private int mdam;
   private int weight;
   private String[] icon;

   public Weapon(String Aname, int Apdam, int Amdam, int Aweight, String[] Aicon){
      name=Aname;
      pdam=Apdam;
      mdam=Amdam;
      weight=Aweight;
      icon=Aicon;
   } // end constructor
   public String name(){return name;}
   public int mdam(){return mdam;}
   public int pdam(){return pdam;}
   public int weight(){return weight;}
   public String[] icon(){return icon;}
   
   static String[] katanaicon = {
             "  /| ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             " | | ",
             "=====",
             " |0| ",
             " |0| ",
             " |0| ",
             " |0| ",
             " |0| ",
             " |0| ",
             " \\_/ "};
             
   static String[] magpolearmicon = {
           "   /\\   ",
           "^^//\\\\^^",         
           "\\\\//\\\\//",
           " \\\\()// ",
           "  \\||/  ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ||   ",
           "   ()   "};
           
   static String[] flailicon = {
            " _ O            ",
            "| | O           ",
            "| |  O          ",
            "| |   O         ",
            "| |    O        ",
            "| |     O ^_^   ",
            "| |      /V V\\  ",
            "| |    <|  V  |>", 
            "| |      \\V_V/  ",
            "| |       V V   ",
            "| |             ",          
            "| |             ",
            "|_|             ",
            "\\_/             "};
            
   static String[] legendaryswordicon = {
      "           ,           ",
      "          / \\          ",
      "         {   }         ",
      "         p   !         ",
      "         ; : ;         ",
      "         | : |         ",
      "         | : |         ",
      "         l ; l         ",
      "         l ; l         ",
      "         I ; I         ",
      "         I ; I         ",
      "         I ; I         ",
      "         I ; I         ",
      "         d | b	      ",
      "         H | H         ",
      "         H | H         ",
      "         H I H         ",
      " ,;,     H I H     ,;, ",
      ";H@H;    ;_H_;,   ;H@H;",
      "`\\Y/d_,;|4H@HK|;,_b\\Y/'",
      " '\\;MMMMM$@@@$MMMMM;/' ",
      "   \"~~~*;!8@8!;*~~~\"   ",
      "         ;888;         ",
      "         ;888;         ",
      "         ;888;         ",
      "         ;888;         ",
      "         d8@8b         ",
      "         O8@8O         ",
      "         T808T         ",
      "          `~` 	      "};
      
   static String[] flamingswordicon = {
      "        )         ",
      "          (       ",     
      "        '    }    ",  
      "      (    '      ",
      "     '      (     ",
      "      )  |    )   ",
      "    '   /|\\    `  ",
      "   )   / | \\  ` ) ",  
      "  {    | | |  {   ",
      " }     | | |  .   ",
      "  '    | | |    ) ",
      " (    /| | |\\    .",
      "  .  / | | | \\  ( ",
      "}    \\ \\ | / /  . ",        
      " (    \\ `-' /    }",
      " '    / ,-. \\    '",
      "  }  / / | \\ \\  } ",
      " '   \\ | | | /   }",
      "  (   \\| | |/  (  ",
      "    )  | | |  )   ",
      "    .  | | |  '   ",
      "       J | L      ",
      " /|    J_|_L    |\\",
      " \\ \\___/ o \\___/ /",
      "  \\_____ _ _____/ ",
      "        |-|       ",
      "        |-|       ",
      "        |-|       ",
      "       ,'-'.      ",
      "       '---'      "};
   
   static String[] basicswordicon = {
       "    /\\    ",
       "   /  \\   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       "   |  |   ",
       " __|__|__ ",
       "/__    __\\",
       "   \\  /   ",
       "   |  |   ",
       "   |  |   ",
       "   \\__/   "};
       
   static String[] maceicon = {
        "  _^___^_  ",
        " /       \\ ",
        "<| v   v |>",
        " |       | ",
        "<| v   v |>",
        " \\_______/ ",
        "    | |    ",
        "    | |    ",
        "    | |    ",
        "    | |    ",
        "    | |    ",
        "    | |    ",
        "    | |    ",
        "    |_|    ",
        "    |_|    ",
        "    |_|    ",
        "    |_|    ",
        "    |_|    ",
        "    |_|    ",
        "    \\_/    "};

   static String[] slingshoticon = {
      "__   __   __",
      "\\ \\-|__|-/ /",
      " \\ \\    / / ",
      "  \\ \\  / /  ",
      "   \\ \\/ /   ",
      "    \\  /    ",
      "    |  |    ",
      "    |  |    ",
      "    |__|    "};
   static String[] daggericon = {
      "   ^   ",
      "  / \\  ",
      "  | |  ",
      "  | |  ",
      "  | |  ",
      " _|_|_ ",
      "|_ O _|",
      "  | |  ",
      "  \\_/  "};

   static Weapon katana = new Weapon("Katana",10,0,3,katanaicon);
   static Weapon magpolearm = new Weapon("Magic Polearm",5,5,5,magpolearmicon);
   static Weapon flail = new Weapon("Flail",14,0,8,flailicon);
   static Weapon legendarysword = new Weapon("Legendary Sword",20,10,10,legendaryswordicon);
   static Weapon flamingsword = new Weapon("Flaming Sword",10,10,6,flamingswordicon);
   static Weapon basicsword = new Weapon("Longsword",6,0,4,basicswordicon);
   static Weapon mace = new Weapon("Mace",8,0,8,maceicon);
   static Weapon slingshot = new Weapon("Slingshot",4,0,1,slingshoticon);
   static Weapon dagger = new Weapon("Dagger",6,0,1,daggericon);
   
} //end class