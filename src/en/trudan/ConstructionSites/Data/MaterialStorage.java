package en.trudan.ConstructionSites.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialStorage implements Serializable {

	private static final long serialVersionUID = -2568572539544142880L;
	private static HashMap<Blockdata, Integer> ms = null;
	@SuppressWarnings("unused")
	private boolean inuse = false;

	public MaterialStorage() {
		ms = new HashMap<Blockdata, Integer>();
	}

	public int getAmought(int blockID) {
		if (ms.containsKey(new Blockdata(blockID))) {
			return ms.get(new Blockdata(blockID));
		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount) {
		if (ms.containsKey(new Blockdata(blockID))) {
			if (ms.get(new Blockdata(blockID)) >= amount) {
				return true;
			}
		}
		return false;
	}

	public Boolean hasMaterial(Material material, int amount) {
		if (ms.containsKey(material.getId())) {
			if (ms.get(material.getId()) >= amount) {
				return true;
			}
		}
		return false;
	}

	public void addMaterial(int blockID, int amount) {
		if (ms.containsKey(new Blockdata(blockID))) {
			ms.put(new Blockdata(blockID), ms.get(blockID) + amount);
		}else{
			ms.put(new Blockdata(blockID), amount);
		}
	}

	public void addMaterial(Material material, int amount) {
		if (ms.containsKey(new Blockdata(material.getId()))) {
			ms.put(new Blockdata(material.getId()), ms.get(material.getId())
					+ amount);
		}else{
			ms.put(new Blockdata(material.getId()), amount);
		}
	}

	public boolean useMaterial(int blockID, int amount) {
		if (ms.containsKey(new Blockdata(blockID))) {
			if (ms.get(blockID) > amount) {
				ms.put(new Blockdata(blockID), ms.get(blockID) - amount);
				return true;
			}
		}
		return false;
	}

	public boolean useMaterial(Material material, int amount) {
		if (ms.containsKey(new Blockdata(material.getId()))) {
			if (ms.get(material.getId()) > amount) {
				ms.put(new Blockdata(material.getId()),
						ms.get(material.getId()) - amount);
				return true;
			}
		}
		return false;
	}

	public int getAmought(int blockID, byte data) {
		if (ms.containsKey(new Blockdata(blockID, data))) {
			return ms.get(new Blockdata(blockID, data));
		}else{

		}
		return 0;
	}

	public Boolean hasMaterial(int blockID, int amount, byte data) {
		if (ms.containsKey(new Blockdata(blockID, data))) {
			if (ms.get(new Blockdata(blockID, data)) >= amount) {
				return true;
			}
		}
		return false;
	}

	public Boolean hasMaterial(Material material, int amount, byte data) {
		if (ms.containsKey(new Blockdata(material.getId()))) {
			if (ms.get(new Blockdata(material.getId(), data)) >= amount) {
				return true;
			}
		}
		return false;
	}

	public void addMaterial(int blockID, int amount, byte data) {
		if (ms.containsKey(new Blockdata(blockID, data))) {
			ms.put(new Blockdata(blockID, data),
					ms.get(new Blockdata(blockID, data)) + amount);
		}else{
			ms.put(new Blockdata(blockID, data),
					amount);
		}
	}

	public void addMaterial(Material material, int amount, byte data) {
		if (ms.containsKey(new Blockdata(material.getId(), data))) {
			ms.put(new Blockdata(material.getId(), data),
					ms.get(new Blockdata(material.getId(), data)) + amount);
		}else{
			ms.put(new Blockdata(material.getId(), data),
					amount);
		}
	}

	public boolean useMaterial(int blockID, int amount, byte data) {
		if (ms.containsKey(new Blockdata(blockID, data))) {
			if (ms.get(new Blockdata(blockID, data)) > amount) {
				ms.put(new Blockdata(blockID, data),
						ms.get(new Blockdata(blockID, data)) - amount);
				return true;
			}
		}
		return false;
	}

	public boolean useMaterial(Material material, int amount, byte data) {
		if (ms.containsKey(new Blockdata(material.getId()))) {
			if (ms.get(new Blockdata(material.getId(), data)) > amount) {
				ms.put(new Blockdata(material.getId(), data),
						ms.get(new Blockdata(material.getId(), data)) - amount);
				return true;
			}
		}
		return false;
	}

	public void addMaterial(ItemStack is){
		if(is != null){
			if(is.getData() == null){
				if (ms.containsKey(new Blockdata(is.getTypeId()))) {
					ms.put(new Blockdata(is.getTypeId()),
							ms.get(new Blockdata(is.getTypeId())) + is.getAmount());
				}else{
					ms.put(new Blockdata(is.getTypeId()),
							is.getAmount());
				}
			}else{
				if (ms.containsKey(new Blockdata(is.getTypeId(), is.getData().getData()))) {
					ms.put(new Blockdata(is.getTypeId(), is.getData().getData()),
							ms.get(new Blockdata(is.getTypeId(), is.getData().getData())) + is.getAmount());
				}else{
					ms.put(new Blockdata(is.getTypeId(), is.getData().getData()),
							is.getAmount());
				}
			}
		}
	}

	public ItemStack[] getChest() {
		ItemStack[] chest = null;
		//if(!inuse){
		int i = 0;
		Set<Blockdata> items = ms.keySet();
		chest = new ItemStack[54];
		for (Blockdata blockdata : items) {
			int amount = ms.get(blockdata);
			System.out.println(amount + "|" + blockdata.getBlockvalue());
			while (amount != 0) {
				if (i < 54) {
					if (amount >= 64) {
						amount -= 64;
						ItemStack is = new ItemStack(blockdata.getBlockvalue(),
								64, blockdata.getData(), blockdata.getData());
						chest[i] = is;
						i++;
					} else if (amount >= 1 && amount <= 64) {
						ItemStack is = new ItemStack(blockdata.getBlockvalue(),
								amount, blockdata.getData(), blockdata.getData());
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

}
