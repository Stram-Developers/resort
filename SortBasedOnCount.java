package com.resort.utils;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Entity implements Comparable<Entity>{
	String domain;
	int count;
	@Override
	public int compareTo(Entity et) {
		if(this.count == et.count) {
			return 0;
		}else if(this.count < et.count) {
			return 1;
		}else {
			return -1;
		}
	}
	
}

public class SortBasedOnCount {

	public static void main(String[] args) {
		List<Entity> entity = new ArrayList<>();
		List<String> domainList = new ArrayList<>();
		domainList.add("mars@gmail.com");
		domainList.add("jena@yahoo.com");
		domainList.add("hena@hotmail.com");
		domainList.add("docker@gmail.com");
		domainList.add("Jackson@gmail.com");
		domainList.add("Jeff@yahoo.com");
		domainList.add("Johnny@gmail.com");
		Entity e = null;
		for(String str : domainList) {
			String domain = extractDomain(str);
		
			if(entity.isEmpty()) {
				e = new Entity(domain, 1);
				entity.add(e);
			}else {
				int isExists=  checkExistOrNot(domain, entity);
				if(isExists < entity.size()) {
					int count = entity.get(isExists).count;
					count++;
					e= new Entity(domain, count);
					
					entity.set(isExists, e);
				}else {
					e = new Entity(domain, 1);
					entity.add(e);
				}
			}
		}
		/*
		Entity e1 = new Entity("gmail",5);
		Entity e2 = new Entity("cognizant",15);
		Entity e3 = new Entity("htomail",9);
		Entity e4 = new Entity("yahoo",2);
		
		entity.add(e1);
		entity.add(e2);
		entity.add(e3);
		entity.add(e4);*/
		Collections.sort(entity);
		
		for(Entity en : entity) {
			System.out.println(en.getDomain() + "  " + en.getCount());
		}
	}

	private static  int checkExistOrNot(String str, List<Entity> entity) {
		// TODO Auto-generated method stub
		 int isTrue = 0;
		 for(Entity e : entity) {
			 if(e.getDomain().equals(str)) {
				 break;
			 }
			 isTrue++;
		 }
		 return isTrue;
	}
	
	public static String extractDomain(String str) {
		return str.substring(str.indexOf("@")+ 1, str.lastIndexOf("."));
	}

}
