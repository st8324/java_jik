package day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ex01_Map {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("abc123", "abc123");
		map.put("abc456", "abc123");	//비번 중복, 저장 가능
		map.put("abc123", "123456");	//아이디 중복, 기존 값 덮어쓰기
		map.put("a", "b");
		
		//Set<Map.Entry<String, String>> entry = map.entrySet();
		//Iterator<Map.Entry<String, String>> it = entry.iterator();
		//Map에 저장된 회원의 아이디와 비밀번호를 하나의 객체로 만들어서 List에 저장
		//List<User> list = new ArrayList<User>();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); 
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			//list.add(new User(entry.getKey(), entry.getValue()));
		}
		System.out.println(map);
		//System.out.println(list);
		map.remove("abc456");
		System.out.println(map);
		System.out.println("abc123회원이 있습니까? : "+map.containsKey("abc123"));
		System.out.println("비밀번호가 456인 회원이 있습니까? : " + map.containsValue("456"));
		
		Iterator<String> it2 = map.keySet().iterator();
		while(it2.hasNext()) {
			String id = it2.next();
			String pw = map.get(id);
			System.out.println(new User(id,pw));
		}
	}
}

class User{
	String id, pw;
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "[ID : " + id + ", PW : " + pw + "]";
	}
	
}
