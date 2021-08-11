package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import components.Component;

public abstract class Entity {
	
	private UUID id;
	//List of all entities.
		public static HashMap<Class, HashMap<UUID, ? extends Component>> components = new HashMap<>();
		protected List<? extends Component> myComponents = new ArrayList<>();
		
		protected Entity(){
			this.id = UUID.randomUUID();
			// Add to list of all entities
		}
		
		public static <T extends Component> void addComponent(UUID entity, T component){
			synchronized(components){
				HashMap<UUID, ? extends Component> store = components.get(component);
				if(store == null){
					store = new HashMap<UUID, T>();
				}
				((HashMap<UUID, T>) store).put(entity, component);
				components.put(component.getClass(), store);
			}
		}
		public <T extends Component> void addComponent(T component){
			synchronized(components){
				HashMap<UUID, ? extends Component> store = components.get(component.getClass());
				if(store == null){
					store = new HashMap<UUID, T>();
				}
				((HashMap<UUID, T>) store).put(this.id, component);
				components.put(component.getClass(), store);
				((List<T>) myComponents).add(component);
			}
		}
		public static <T> T getComponents(UUID entity, Class<T> component){
			HashMap<UUID, ? extends Component> store = components.get(component);
			T results = (T) store.get(entity);
			if(results == null)
				throw new IllegalArgumentException("Get Fail: "+entity.toString()+" does not posses Component of Class \n missing: "+ component);
			return results;
		}
		public <T> T getComponent( Class<T> component) {
			HashMap<UUID, ? extends Component> store = components.get(component);
			T results = (T) store.get(this.id);
			if(results == null)
				throw new IllegalArgumentException("Get Fail: "+this.id.toString()+" does not posses Component of Class \n missing: "+ component);
			return results;
		}
		public static <T> boolean hasComponent(UUID entity, Class<T> component){
			HashMap<UUID, ? extends Component> store = components.get(component);
			T results = (T) store.get(entity);
			if(results == null)
				return false;
			return true;
		}
		public <T> boolean hasComponent( Class<T> component) {
			HashMap<UUID, ? extends Component> store = components.get(component);
			if(store == null)
				return false;
			
			T results = (T) store.get(id);
			if(results == null)
				return false;
			
			return true;
		}
		
		public <T> HashMap<UUID, ? extends Component> allComponents(Class<T> component){

			return components.get(component);
		}

}
