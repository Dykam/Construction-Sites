package en.trudan.ConstructionSites.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

public class MaterialStorage implements Serializable {

	private static final long serialVersionUID = -2568572539544142880L;
	private static HashMap<Integer, Integer> ms = null;
	@SuppressWarnings("unused")
	private boolean inuse = false;

	public MaterialStorage() {
		ms = new HashMap<Integer, Integer>();
	}

	public int getAmought(int blockID) {
		if (ms.containsKey(Blockdata(blockID))) {
			return ms.get(Blockdata(blockID));
		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount) {
		if (ms.containsKey(Blockdata(blockID))) {
			if (ms.get(Blockdata(blockID)) >= amount) {
				return true;
			}
		}
		return false;
	}

	public boolean useMaterial(int blockID, int amount) {
		if (ms.containsKey(Blockdata(blockID))) {
			if (ms.get(blockID) > amount) {
				ms.put(Blockdata(blockID), ms.get(blockID) - amount);
				return true;
			}
		}
		return false;
	}

	public int getAmought(int blockID, byte data) {
		if (ms.containsKey(Blockdata(blockID, data))) {
			return ms.get(Blockdata(blockID, data));
		}else{

		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount, byte data) {
		if (ms.containsKey(Blockdata(blockID, data))) {
			if (ms.get(Blockdata(blockID, data)) >= amount) {
				return true;
			}
		}
		return false;
	}

	public boolean useMaterial(int blockID, int amount, byte data) {
		if (ms.containsKey(Blockdata(blockID, data))) {
			if (ms.get(Blockdata(blockID, data)) > amount) {
				ms.put(Blockdata(blockID, data),
						ms.get(Blockdata(blockID, data)) - amount);
				return true;
			}
		}
		return false;
	}

	public void addMaterial(ItemStack is){
		if(is == null) // Guard
			return; // Log error as well.
		
		int blockId = is.getTypeId();
		byte data = is.getData() != null ? is.getData().getData() : 0;
		int key = Blockdata(blockId, data);
		int previousAmount = 0;
		if (ms.containsKey(key)) {
			previousAmount = ms.get(key);
		} 
		ms.put(key, previousAmount + is.getAmount());

	}

	public ItemStack[] getChest() {
		int i = 0;
		ItemStack[] chest = new ItemStack[54];
		for (Integer blockdata : ms.keySet()) {
			byte data = (byte)(blockdata % 255);
			Material material = Material.getMaterial(blockdata/255);
			
			for(int amount = ms.get(blockdata); amount > 0 && i < 54; amount -= 64, i++)
				chest[i] = new ItemStack(material, mat, data, data);
			}
			
			// Early escape
			if(i < 54) return chest;
		}
		return chest;
	}

	public int Blockdata(int BlockID){
		return BlockID * 255;	
	}

	public int Blockdata(int BlockID,byte data){
		return BlockID * 255 + data;
	}

}
