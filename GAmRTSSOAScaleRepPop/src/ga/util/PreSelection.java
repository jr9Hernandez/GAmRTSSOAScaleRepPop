package ga.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ga.config.ConfigurationsGA;
import ga.model.Chromosome;
import ga.model.ChromosomeValue;
import ga.model.Population;

public class PreSelection {

	Population p;
	public PreSelection(Population p)
	{
		this.p=p;
	}
	public List<ChromosomeValue> Tournament()
	{
		//we want to select some parents (list parents) from all the population (listCandidates)
		int parentsAdded=0;
		List<ChromosomeValue> listParents= new ArrayList();
		List<ChromosomeValue> listCandidates = new ArrayList<ChromosomeValue>(p.getChromosomes());
		while(parentsAdded<ConfigurationsGA.SIZE_PARENTSFORCROSSOVER)
		{
			//here we randomize the list in order to select k random elements for the tournament
			Collections.shuffle(listCandidates);
			ChromosomeValue best=null;

			for(int i=0; i<ConfigurationsGA.K_TOURNMENT; i++)
			{

				if(best==null || listCandidates.get(i).getValue().intValue()>best.getValue().intValue())
				{
					best=listCandidates.get(i);
				}
			}
			//here we add the champion as a parent
			listParents.add(best);
			parentsAdded++;
		}
		return listParents;
	}
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List list = new LinkedList(map.entrySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
			if(sortedHashMap.size()==ConfigurationsGA.SIZE_ELITE)
			{
				break;
			}
		} 
		return sortedHashMap;

	}
	
    public ArrayList<ChromosomeValue> sortByValueList(ArrayList<ChromosomeValue> l) {
    	
    	ArrayList<ChromosomeValue> eliteL=new ArrayList<ChromosomeValue>();
    	eliteL.addAll(l);
    	Comparator<ChromosomeValue> feeComparator = (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    	eliteL.sort(Collections.reverseOrder(feeComparator));
    	
    	ArrayList<ChromosomeValue> eliteL2 = new ArrayList<ChromosomeValue>(eliteL.subList(0,eliteL.size()));
    	return eliteL;

    }

}
