package en.trudan.ConstructionSites.Data;

import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class MaterialStorage implements Serializable{

	private static final long serialVersionUID = -2568572539544142880L;
	private static HashMap<Blockdata,Integer> ms = null;


	public MaterialStorage() {
		ms = new HashMap<Blockdata,Integer>();	
	}

	public int getAmought(int blockID){
		if(ms.containsKey(new Blockdata(blockID))){
			return ms.get(new Blockdata(blockID));
		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount){
		if(ms.containsKey(new Blockdata(blockID))){
			if(ms.get(new Blockdata(blockID))>=amount){
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
		if(ms.containsKey(new Blockdata(blockID))){
			ms.put(new Blockdata(blockID), ms.get(blockID)+amount);
		}
	}
	
	public void addMaterial(Material material, int amount){
		if(ms.containsKey(new Blockdata(material.getId()))){
			ms.put(new Blockdata(material.getId()), ms.get(material.getId())+amount);
		}
	}
 
	public boolean useMaterial(int blockID, int amount){
		if(ms.containsKey(new Blockdata(blockID))){
			if(ms.get(blockID)>amount){
				ms.put(new Blockdata(blockID), ms.get(blockID)-amount);
				return true;
			}
		}
		return false;
	}
	
	public boolean useMaterial(Material material, int amount){
		if(ms.containsKey(new Blockdata(material.getId()))){
			if(ms.get(material.getId())>amount){
				ms.put(new Blockdata(material.getId()), ms.get(material.getId())-amount);
				return true;
			}
		}
		return false;
	}
	
	public ItemStack[] getChest(){
		
		MaterialData mat = new MaterialData(1, (byte) 0);
		ItemStack is = new ItemStack(type, amount, damage, data)
		
		return null;
	}

}
