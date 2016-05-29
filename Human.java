import javax.swing.*;

public class Human{
   private Armor helmet;
   private Armor cuirass;
   private Armor leggings;
   private Weapon weapon;
   
   public Human(){
      helmet = Armor.tophat;
      cuirass = Armor.tatteredshirt;
      leggings = Armor.tatteredcloths;
      weapon = Weapon.slingshot;
   } //end constructor
   
   public Human(Armor helm, Armor chest, Armor legs, Weapon wep){
      helmet = helm;
      cuirass = chest;
      leggings = legs;
      weapon = wep;
   } //end constructor
   public Armor gethelm(){return helmet;}
   public Armor getchest(){return cuirass;}
   public Armor getlegs(){return leggings;}
   public Weapon getwep(){return weapon;}
   
} //end class