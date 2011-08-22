package en.trudan.ConstructionSites.Data;

import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.Material;

public class MaterialStorage implements Serializable{

	private static final long serialVersionUID = -2568572539544142880L;
	private static HashMap<Integer,Integer> ms = null;


	public MaterialStorage() {
		ms = new HashMap<Integer,Integer>();	
	}

	public int getAmought(int blockID){
		if(ms.containsKey(blockID)){
			return ms.get(blockID);
		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount){
		if(ms.containsKey(blockID)){
			if(ms.get(blockID)>=amount){
				return true;
			}
		}
		return false;
	}
	
	public Boolean hasMaterial(Material material, int amount){
		if(ms.containsKey(material.getId())){
			if(ms.get(material.getId())>=amount){
				return true;
			}
		}
		return false;
	}

	public void addMaterial(int blockID, int amount){
		if(ms.containsKey(blockID)){
			ms.put(blockID, ms.get(blockID)+amount);
		}
	}
	
	public void addMaterial(Material material, int amount){
		if(ms.containsKey(material.getId())){
			ms.put(material.getId(), ms.get(material.getId())+amount);
		}
	}
 
	public boolean useMaterial(int blockID, int amount){
		if(ms.containsKey(blockID)){
			if(ms.get(blockID)>amount){
				ms.put(blockID, ms.get(blockID)-amount);
				return true;
			}
		}
		return false;
	}
	
	public boolean useMaterial(Material material, int amount){
		if(ms.containsKey(material.getId())){
			if(ms.get(material.getId())>amount){
				ms.put(material.getId(), ms.get(material.getId())-amount);
				return true;
			}
		}
		return false;
	}

}
