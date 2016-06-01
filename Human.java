import javax.swing.*;

public class Human{
   private Armor helmet;
   private Armor cuirass;
   private Armor leggings;
   private Weapon weapon;
   private int weight;
   private int pres;
   private int mres;
   
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
      pres = helmet.pres() + cuirass.pres() + leggings.pres();
      mres = helmet.mres() + cuirass.mres() + leggings.mres();
   } //end constructor
   
   public Armor gethelm(){return helmet;}
   public Armor getchest(){return cuirass;}
   public Armor getlegs(){return leggings;}
   public Weapon getwep(){return weapon;}
   public int getweight(){return weight;}
   public int getpres(){return pres;}
   public int getmres(){return mres;}
   
   public void sethelm(Armor helmet) { this.helmet = helmet; }
   public void setchest(Armor cuirass) { this.cuirass = cuirass; }
   public void setlegs(Armor leggings) { this.leggings = leggings; }
   public void setwep(Weapon weapon) { this.weapon = weapon; }

   
} //end class