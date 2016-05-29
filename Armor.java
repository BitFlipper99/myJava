import javax.swing.*;

public class Armor{
   private int mres;
   private int pres;
   private int weight;
   private String name;
   private String slot;
   private String[] icon;
   
   public Armor(String Aname, String Aslot, int Amres, int Apres, int Aweight, String[] Aicon){
      name=Aname;
      slot=Aslot;
      mres=Amres;
      pres=Apres;
      weight=Aweight;
      icon=Aicon;
   } // end constructor
   public String name(){return name;}
   public String slot(){return slot;}
   public int mres(){return mres;}
   public int pres(){return pres;}
   public int weight(){return weight;}
   public String[] icon(){return icon;}
   
   static String[] featherheadicon ={"       /\\        ",       
	 "      //\\\\      ",      
    "     ///\\\\\\     ",       
    "     \\\\\\///     ",                       
	 "      \\\\//      ",           
    "    ___||___    ",            
	 "   /        \\   ",         
    "  / ________ \\  ",           
    " / / _    _ \\ \\ ",           
    "/ / | |  | | \\ \\",          
    "|/  | |  | |  \\|",           
    "||  | |  | |  ||",          
    "||  | |  | |  ||",           
    "|\\  \\_/  \\_/  /|",           
    "\\ \\__________/ /",         
    " \\__        __/ ",            
	 "    \\______/    "};
    
    static String[] sunbrohelmicon = {
      "    ^          ",        
      "   /|\\         ",          
	   "   \\|/         ",          
      " ___|_________ ",            
      "/     | |     \\",           
      "|     | |     |",           
      "|     | |     |",           
      "|_____| |_____|",          
      "|__[_]   [_]__|",         
      "|     | |     |",          
      "|     | |     |",         
      "|     | |     |",         
      "|     | |     |",         
      "\\_____|_|_____/"}; 
   
   static String[] fathelmicon = {
     "           ^           ",     
     "   _______/|\\_______   ",     
     "  /  |     |     |  \\  ",     
     "  |  |     |     |  |  ",     
     " /   |     |     |   \\ ",     
     " |   |     |     |   | ",     
     "/____|_____|_____|____\\",     
     "|     (0)  >  (0)     |",   
     "|_____________________|",     
     "|    |     |     |    |",     
     "\\    |     |     |    /",    
     " |   |     |     |   | ",   
     " \\___|_____|_____|___/ "};
  
   static String[] robedhelmicon = {   
     "           ^	         ",     
     "          / \\__	      ",
     "       __/ ^   \\_       ",   
     "      /   / \\__  \\_     ",    
     "    _/  _/     \\_  \\    ",               
     "   /   /_________\\  \\   ",      
     "  /  _/           \\  |  ",       
     " |  /             |\\ |  ",      
     " | /|             || |  ",      
     "/ / |_____________|| \\  ",     
     "| | |__[_]   [_]__| \\ \\ ",    
     "| |/      | |      \\ \\ \\",     
     "| ||      | |      | | |",   
     "| ||      | |      | | |",  
     "| |\\      | |      / | |",   
     "\\ \\_\\_____|_|_____/ / / ",  
     " \\___ \\           _/ /  ",
     "    \\  \\___  ____/ _/   ",    
     "     \\_____\\/_____/     ",   
     "           \\/           "};
     
   static String[] crownicon = {
    "            _            ",
    "          _\\ /_          ",
    "          >_X_<          ",
    "   .---._  /_\\  _.---.   ",
    " /`.---._`{/ \\}`_.---.`\\ ",
    "| /   ___`{\\_/}`___   \\ |",
    "\\ \\.\"`*  `\"{_}\"`  *`\"./ /",
    " \\ \\  )\\  _\\ /_  /(  / / ",
    "  \\ *<()( >_X_< )()>* /  ",
    "   |._)/._./_\\._.\\(_.|   ",
    "   |() () () () () ()|   ",
    "   <<o>><<o>><o>><<o>>   ",
    "  `\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"`  "};
   
   static String[] knighthelmicon = {
    "   _.--.    .--._   ",
    " .\"  .\"      \".  \". ",
    ";  .\"    /\\    \".  ;",
    ";  '._,-/  \\-,_.`  ;",
    "\\  ,`  / /\\ \\  `,  /",
    " \\/    \\/  \\/    \\/ ",
    " ,=_    \\/\\/    _=, ",
    " |  \"_   \\/   _\"  | ", 
    " |_   '\"-..-\"'   _| ",
    " | \"-.        .-\" | ",
    " |    \"\\    /\"    | ",
    " |      |  |      | ",
    " |      |  |      | ",
    " '_     |  |     _' ",
    "   \"-.  |  |  .-\"   ",
    "      \"-'--'-\"      "};
   static String[] tophaticon = {
      "   .------\\ /------.   ",
      "   |       -       |   ",
      "   |               |   ",
      "   |               |   ",
      "   |               |   ",
      "_______________________",
      "===========.===========",
      "  / ~~~~~     ~~~~~ \\  ",
      " /|     |     |      \\ ",
      " W   ---  / \\  ---   W ",
      " \\.      |o o|      ./ ",
      "  |                 |  ",
      "  \\    #########    /  ",
      "   \\  ## ----- ##  /   ",
      "    \\##         ##/    ",
      "     \\_____v_____/     "};
   
   static Armor tophat =      new Armor("Top Hat","Helmet",3,3,1,tophaticon);
   static Armor knighthelm =  new Armor("Knight Helm","Helmet",10,10,10,knighthelmicon);
   static Armor crown =       new Armor("Crown","Helmet",100,100,4,crownicon);
   static Armor robedhelm =   new Armor("Robed Helm","Helmet",5,5,5,robedhelmicon);   
   static Armor fathelm =     new Armor("Fat Helm","Helmet",2,8,8,fathelmicon);   
   static Armor sunbrohelm =  new Armor("Sunbro Helm","Helmet",4,6,5,sunbrohelmicon);
   static Armor featherhead = new Armor("Feather Head","Helmet",3,7,4,featherheadicon);
   
   static String[] sunbrochesticon = {
   "    /----\\           /----\\   ",
   "   /      \\---------/      \\  ",
   "  /        |   |   |        \\ ",
   " /       \\           /       \\",
   "|          /-------\\         |",
   "|    |   _ |       | _  |    |",
   "|    |   _ |       | _  |    |",
   "|    |   _ |       | _  |    |",
   "|    |     \\-------/    |    |",
   "|    |   / |   |   | \\  |    |",
   "|    |                  |    |",
   "|    |                  |    |",
   "|    |                  |    |",
   "|====|                  |====|",
   "     |==================|     ",};
   
   static String[] feathercoaticon = {
   "     /-----     -----\\		",
   "    /      \\   /      \\   ",
   "   /        \\_/        \\  ",
   "  /          |          \\ ",
   " /           |           \\",
   "|            |           |",
   "|    |       |      |    |",
   "|    |       |      |    |",
   "|    |       |      |    |",
   "|____|       |      |____|",
   "|____|       |      |____|",
   "     |       |      |     ",
   "     |       |      |     ",
   "     |_______|______|     ",
   "     |_______|______|     "};
   
   static String[] spikedcuirassicon = {
  "      /^^^^^\\          /^^^^^\\      ",
  "      /      \\________/      \\      ",
  "     /                        \\     ", 
  "    /                          \\    ",
  "   /                            \\   ",
  "  /     /|                |\\     \\  ",
  " /     / |                | \\     \\ ",
  "<|    |  \\                /  |    |>",
  " |    |   \\              /   |    | ",
  " |____|   |   ________   |   |____| ",
  " |    |   |__/        \\__|   |    | ",  
  " |    |   |__|        |__|   |    | ",
  " |____|   |__|        |__|   |____| ",
  "          |__|        |__|          ",
  "          |__|________|__|          ",
  "          |______________|          "};
  
   static String[] tatteredshirticon = {
   "   /------        ------\\  ",
   "  /       \\      /       \\ ",
   " /         \\    /         \\",
   " |          \\  /          |",
   " |           \\/           |",
   " |                        |",
   " |    |              |    |",
   " |    |              |    |",
   " |    |              |    |",
   " |    |              |    |",
   " |    |              |    |",
   " |    |              |    |",
   " |    |              |    |",
   " |/\\/\\|              |/\\/\\|",
   "      |______________|     "};
   
   static Armor tatteredshirt = new Armor("Tattered Shirt","Cuirass",3,9,3,tatteredshirticon); 
   static Armor spikedcuirass = new Armor("Spiked Cuirass","Cuirass",4,21,15,spikedcuirassicon);
   static Armor feathercoat = new Armor("Feather Coat","Cuirass",7,18,10,feathercoaticon);
   static Armor sunbrochest = new Armor("Sunbro Chestplate","Cuirass",10,15,12,sunbrochesticon);
   
   static String[] tatteredclothsicon = {
      " __________________ ",
      " |       ()       | ",
      " |       ()       | ",
      " |                | ", 
      " |                | ",
      " |       /\\       | ",
      " |      /  \\      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |      |  |      | ",
      " |/\\/\\/\\|  |/\\/\\/\\| ",
      "  |    |    |    |  ",
      "  |    |    |    |  ",
      "  |    |    |    |  ", 
      "  |    |    |    |  ",
      "  |    |    |    |  ",  
      "  /    /    \\    \\  ",             
      " /    /      \\    \\ ",
      "/    /        \\    \\",
      "OOOOO          OOOOO"};
      
   static String[] jesterpantsicon = {
      " ____________________",
      " \\()()()()()()()()()/",                                
      " \\                  /",                                   
      "  \\                / ",
      "  \\                / ",
      "  \\                / ",
      "  \\                / ",
      "  \\                / ",
      "  \\\\\\\\|////\\\\\\\\|//// ",
      "   |     |  |     |  ",
      "   |     |  |     |  ",
      "   |     |  |     |  ",
      "   |     |  |     |  ",
      "   |     |  |     |  ",
      "   \\\\\\|///  \\\\\\|///  ",
      "    |   |    |   |   ",
      "    |   |    |   |   ",
      "    |   |    |   |   ",
      "    |   |    |   |   ",
      "    |   |    |   |   ",
      "    |___|    |___|   ",
      "    /   //  \\\\   \\   ",
      "   /   //    \\\\   \\  ",
      "  /___//      \\\\___\\ ",
      " ///\\\\/        \\//\\\\\\", 
      " \\\\\\//          \\\\///"};
   
   static String[] leathergreavesicon = {
      " ___________________  ",
      "\\\\\\[[[[[[(  )]]]]]]///",
      " \\\\                // ",
      " \\\\                // ",
      "  \\       /\\       /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "  \\      /  \\      /  ",
      "   \\    /    \\    /   ",
      "   \\    /    \\    /   ",
      "   \\    /    \\    /   ",
      "  \\\\    /    \\    /// ",
      "  \\\\    /    \\    //  ",
      "   \\ __ /    \\ __ /   ",
      "   <     >  <     >   ",
      "   /    //  \\\\    \\   ",
      "  /    //    \\\\    \\  ",
      " ///\\\\//      \\\\//\\\\\\ ",
      " \\\\////        \\\\\\\\// "};
      
   static String[] polishedgreavesicon = {
   "__________________",
   "UUUUUUUUUUUUUUUUUU",
   "uuuuuuuuuuuuuuuuuu",        
   "|                |",
   "|                |",
   "|                |", 
   "|       /\\       |",
   "|      /  \\      |",
   "|      |  |      |",
   "|      |  |      |",
   "|      |  |      |", 
   "|      |  |      |",
   "|      |  |      |",
   "|      |  |      |",
   "|      |  |      |", 
   "|______|  |______|",
   " \\_____/  \\_____/ ",
   "  |   |    |   |  ", 
   "  | X |    | X |  ",
   "  | X |    | x |  ",
   "  | X |    | X |  ",
   "  /   /|  |\\   \\  ",
   " /   /w    W\\   \\ ",
   "/___/w      W\\___\\",
   "\\WW|w        W|WW/"};
    
   static Armor leathergreaves = new Armor("Leather Greaves","Leggings",7,8,6,leathergreavesicon);
   static Armor jesterpants = new Armor("Jester's Pants","Leggings",5,10,5,jesterpantsicon);
   static Armor tatteredcloths = new Armor("Tattered Cloths","Leggings",1,6,1,tatteredclothsicon);
   static Armor polishedgreaves = new Armor("Polished Greaves","Leggings",3,15,8,polishedgreavesicon);   

} //end class