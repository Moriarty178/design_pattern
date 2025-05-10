package structural_pattern.composite_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import structural_pattern.composite_pattern.component.MenuComponent;
import structural_pattern.composite_pattern.composite.Menu;
import structural_pattern.composite_pattern.leaf.MenuItem;

@SpringBootApplication
public class CompositePatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompositePatternApplication.class, args);

//		// composite - menu
//		MenuComponent breakfastMenu = new Menu("Breakfast");
//		MenuComponent lunchMenu = new Menu("Lunch");
//
//		// leaf - item
//		MenuComponent pancakes = new MenuItem("Pancakes");
//		MenuComponent sandwich = new MenuItem("Sandwich");
//		MenuComponent burger = new MenuItem("Burger");
//		MenuComponent chip = new MenuItem("Chip");
//
//		breakfastMenu.add(sandwich);
//		breakfastMenu.add(burger);
//		lunchMenu.add(pancakes);
//
//		MenuComponent allMenus = new Menu("All Menus");
//		allMenus.add(breakfastMenu);
//		allMenus.add(lunchMenu);
//		allMenus.add(chip);
//
//		allMenus.print("");

	}



}
