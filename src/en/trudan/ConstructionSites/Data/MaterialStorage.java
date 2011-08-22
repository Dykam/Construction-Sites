package en.trudan.ConstructionSites.Data;

import java.util.HashMap;
import en.trudan.ConstructionSites.ConstructionSites;

public class MaterialStorage{

	public ConstructionSites plugin;
	
    public MaterialStorage(ConstructionSites instance)
    {
        plugin = instance;
    }
	
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

	public void addMaterial(int blockID, int amount){
		if(ms.containsKey(blockID)){
			ms.put(blockID, ms.get(blockID)+amount);
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

}
