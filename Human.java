import javax.swing.*;

public class Human{
   private Armor helmet;
   private Armor cuirass;
   private Armor leggings;
   private Weapon weapon;
   private int weight;
   
   public Human(){
      helmet = Armor.tophat;
      cuirass = Armor.tatteredshirt;
      leggings = Armor.tatteredcloths;
      weapon = Weapon.slingshot;
   } //end constructor
   
   public Human(Armor helmet, Armor cuirass, Armor leggings, Weapon weapon){
      this.helmet = helmet;
      this.cuirass = cuirass;
      this.leggings = leggings;
      this.weapon = weapon;
      weight = helmet.weight() + cuirass.weight() + leggings.weight() + weapon.weight();
   } //end constructor
   
   public Armor gethelm(){return helmet;}
   public Armor getchest(){return cuirass;}
   public Armor getlegs(){return leggings;}
   public Weapon getwep(){return weapon;}
   
} //end class