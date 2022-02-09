import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class MapMaker
{
	private HashMap<String, Integer> hmap;
	public MapMaker() {
		hmap = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer> makeMap(ArrayList<String> key, ArrayList<Integer> val) 
	{
		for (int i=0; i<key.size(); i++) {
			int v=val.get(i);
			String k=key.get(i).substring(0,1).toUpperCase()+key.get(i).substring(1).toLowerCase();
			if(hmap.containsKey(k)) {
				v+=hmap.get(k);
				hmap.remove(k);
			}
			hmap.put(k,v);
		}
		double sum=0;
		for (int k = 0; k < val.size(); k++)
		{
			sum+=val.get(k);
		}
		double avg=sum/val.size();
		avg=val.size()/(val.size()/15);
		Set<Entry<String, Integer>> setOfEntries = hmap.entrySet();
		Iterator<Entry<String, Integer>> iterator = setOfEntries.iterator();
		
		while (iterator.hasNext()) 
		{
            Entry<String, Integer> entry = iterator.next();
            int p=entry.getValue();
            if (p < avg) {
            	iterator.remove();
            }
		}
		System.out.println(hmap);
		return hmap;
	}
}
