package day17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_Set_Test1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<10; i++) {
			int r = (int)(Math.random()*(9 - 1 + 1)+1);
			System.out.println(r + " : " + set.add(r));
		}
		
		System.out.println(set);
		System.out.println("1 삭제 ? "+set.remove(1));
		System.out.println(set);
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}
