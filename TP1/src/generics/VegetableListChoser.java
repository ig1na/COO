package generics;

import scanner.*;

import java.util.*;

public class VegetableListChoser {

    // methode chose
    // elle est similaire a celle de ListChoser simplement elle ne fonctionne
    // qu'avec des listes d'objets de type Legume (cf. interface Legume)
    // quel changement apporter a la methode de ListChoser  ?
    
    public static void main(String[] args) {
		List<Carrot> lCarrots = new ArrayList<Carrot>();
		lCarrots.add(new Carrot(1));
		lCarrots.add(new Carrot(2));
		lCarrots.add(new Carrot(3));

		List<Apple> lApples = new ArrayList<Apple>();
		lApples.add(new Apple(1));
		lApples.add(new Apple(2));
		lApples.add(new Apple(3));

		VegetableListChoser lcl = new VegetableListChoser();

		Carrot chosenCarrot = lcl.chose("which carrot ? ", lCarrots);
		System.out.println("You have chosen : " + chosenCarrot);

		// NE COMPILE PAS
		// Apple chosenApple = lcl.chose("which apple ? ",lApples);


    }
    
    public <T extends Vegetable> T chose(String s, List<T> list){
		
		int choice;
		
		System.out.println("Veuillez choisir un legume: ");
		System.out.println("0. Aucun");
		for(Vegetable elem : list){
			System.out.println((list.indexOf(elem)+1) + ". " + elem);
		}
		
		choice = ScannerInt.readInt(list.size()+1) -1;
		
		if(choice == -1) return null;
		else return (T)list.get(choice);
		
	}
}
