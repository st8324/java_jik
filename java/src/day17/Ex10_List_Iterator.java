package day17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex10_List_Iterator {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		//향상된 for문 : 배열과 리스트 가능
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//Iterator
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
	
}
