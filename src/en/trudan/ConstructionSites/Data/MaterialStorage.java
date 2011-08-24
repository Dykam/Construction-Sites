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
		if(is != null){
			if(is.getData() == null){
				if (ms.containsKey(Blockdata(is.getTypeId()))) {
					ms.put(Blockdata(is.getTypeId()),
							ms.get(Blockdata(is.getTypeId())) + is.getAmount());
				}else{
					ms.put(Blockdata(is.getTypeId()),
							is.getAmount());
				}
			}else{
				if (ms.containsKey(Blockdata(is.getTypeId(), is.getData().getData()))) {
					ms.put(Blockdata(is.getTypeId(), is.getData().getData()),
							ms.get(Blockdata(is.getTypeId(), is.getData().getData())) + is.getAmount());
				}else{
					ms.put(Blockdata(is.getTypeId(), is.getData().getData()),
							is.getAmount());
				}
			}
		}
	}

	public ItemStack[] getChest() {
		ItemStack[] chest = null;
		//if(!inuse){
		int i = 0;
		Set<Integer> items = ms.keySet();
		chest = new ItemStack[54];
		for (Integer blockdata : items) {
			int ID = blockdata/255;
			int dataint = (blockdata%255);
			byte data = Byte.parseByte(Integer.toString(dataint));
			int amount = ms.get(blockdata);
			System.out.println(amount + "|" + ID);
			while (amount != 0) {
				if (i < 54) {
					if (amount >= 64) {
						amount -= 64;
						ItemStack is = new ItemStack(ID,
								64, data, data);
						chest[i] = is;
						i++;
					} else if (amount >= 1 && amount <= 64) {
						ItemStack is = new ItemStack(ID,
								amount, data, data);
						chest[i] = is;
						amount = 0;
						i++;
					}
				}
			}
			//}
			return chest;
		}
		return chest;
	}
	
	public int Blockdata(int BlockID){
		return (BlockID*255);	
	}
	
	public int Blockdata(int BlockID,byte data){
		return ((BlockID*255)+data);
	}

}
