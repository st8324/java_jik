package day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex01_Map {

	public static void main(String[] args) {
		/* Map에 다양한 타입(클래스)의 정보들을 묶어서 담을 수 있다는걸 보여주는 예제 */
		Map<String,Object> map = new HashMap<String,Object>();
		Point pt = new Point();
		String str = "Hello";
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		map.put("point", pt);
		map.put("string", str);
		map.put("userList", list);
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Object obj = map.get(key);
			if(obj instanceof String) {
				System.out.println("문자열 : " + (String)obj);
			}else if(obj instanceof Point) {
				Point pt2 = (Point)obj;
				System.out.println(pt2.x + "," + pt2.y);
			}else if(obj instanceof ArrayList) {
				List<String> list2 = (ArrayList<String>)obj;
				System.out.println(list2);
			}
		}
	}
}

class Point{
	int x,y;
}
