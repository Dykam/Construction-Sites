package en.trudan.construction.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileHandler {

	//FileHandler-part
	//global stuff
	//ms = MaterialStorage
	private static HashMap<Integer,MaterialStorage> ms = null;
	//Folder-variables
	static String mainDirectory = "plugins/Construction Sites"; //sets the main directory for easy reference
	static File Storage = new File(mainDirectory + File.separator + "Storage.dat");
	//onEnable
	public FileHandler(){
		
		new File(mainDirectory).mkdir();
		if(Storage.exists()){
			load();
		}else{
			ms = new HashMap<Integer,MaterialStorage>();
		}	
	}
	public void save(){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Storage));
			oos.writeObject(ms);
			oos.flush();
			oos.close();
			//Handle I/O exceptions
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Storage));
			Object result = ois.readObject();
			//As long as it is not corrupted, we can just cast the object to hashmap
			ms = (HashMap<Integer, MaterialStorage>)result;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//Here i will add your interface:
	public MaterialStorage getMS(int ID){
		if(ms.containsKey(ID)){
		return ms.get(ID);
		}
		return null;
	}
}
