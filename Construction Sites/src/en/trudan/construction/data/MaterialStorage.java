package en.trudan.construction.data;

import java.io.Serializable;
import java.util.HashMap;

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
