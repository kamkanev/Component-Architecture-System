package main;

import java.util.HashMap;
import java.util.UUID;

import components.BlockComponent;
import components.Component;
import components.LiveComponent;
import components.PositionComponent;
import entities.Entity;
import entities.Player;

public class Tester {

	public static void main(String[] args) {
		
		Player p = new Player();
		Player p2 = new Player();
		
		System.out.println(p);
		System.out.println("====================");
		System.out.println(p2);
		System.out.println("====================");
		
		

		p2.addComponent(new PositionComponent(90, 120));
		
		p.addComponent(new LiveComponent("Gosho", 200));
		p.addComponent(new PositionComponent(10, -2, 90));
		

		System.err.println(Entity.components);

		System.out.println("====================");
		System.out.println(p);
		System.out.println("====================");
		System.out.println(p2);
		
		
		System.out.println("**********************");

		System.out.println(p.hasComponent(BlockComponent.class));
		System.out.println(p2.getComponent(PositionComponent.class));
		
		HashMap<UUID, Component> n = (HashMap<UUID, Component>) p2.allComponents(PositionComponent.class);
		
		System.err.println();

	}

}
