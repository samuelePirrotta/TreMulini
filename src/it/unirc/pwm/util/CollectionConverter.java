package it.unirc.pwm.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionConverter  {
	public static <T> List<T> getList(Set<T> input) {
		List<T> res = new ArrayList<T>();
		for(T i : input) {
			res.add(i);
		}
		return res;
	}
	
	public static <T> Set<T> getSet(List<T> input) {
		Set<T> res = new HashSet<T>();
		for(T i : input) {
			res.add(i);
		}
		return res;
	}
}