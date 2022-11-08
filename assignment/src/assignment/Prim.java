package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Prim{
	public static void main(String[] args) throws IOException {
		HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> routeMap = new HashMap<>();
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token ;
		token = new StringTokenizer(scan.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		ArrayList<Integer> checkIfMade = new ArrayList<>(); 
		ArrayList<Integer> groupOfNode = new ArrayList<>();
		
		for (int i=0; i<n+1; i++) {
			checkIfMade.add(0);
		}
		checkIfMade.set(0, 1);
		
		for (int i=0; i<m; i++) {
			token = new StringTokenizer(scan.readLine());
			HashMap<Integer, Integer> temp = new HashMap<>();
			ArrayList<HashMap<Integer, Integer>> tempArr;
			String key = token.nextToken();
			if (groupOfNode.isEmpty()) {
				groupOfNode.add(Integer.parseInt(key));
				checkIfMade.set(Integer.parseInt(key),1);
			}
			temp.put(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			
			
			if (routeMap.containsKey(Integer.parseInt(key))) {
				tempArr = routeMap.get(Integer.parseInt(key));
			}
			else {
				tempArr = new ArrayList<>();
			}
			
			tempArr.add(temp);
			
			routeMap.put(Integer.parseInt(key),tempArr);
		}
		
//		for (int x : routeMap.keySet()) {
//			System.out.println(x + " " + routeMap.get(x));
//		}
		
		int mstMinValue=0;
		
		while (checkIfMade.contains(0)) {
			//System.out.println(groupOfNode);
			int minValue=0;
			int minValueKey =0;
			
			
			
			for (int x : groupOfNode) {
				//System.out.println("!" + x);
				if (routeMap.keySet().contains(x)) {
					for (HashMap<Integer, Integer> vertex : routeMap.get(x)) {
						for (int key : vertex.keySet()) {
							if ((minValue == 0 || minValue > vertex.get(key)) && !groupOfNode.contains(key)){
								//System.out.println(x + " -> " + key + " : " + vertex.get(key));
								minValue = vertex.get(key);
								minValueKey=key;
							}
						}
					}
					
				}
				
//				for (int key : routeMap.keySet()) {
//					//System.out.println(x + " vs " + key);
//					if (!groupOfNode.contains(key)) {
//						//System.out.println(routeMap.get(key));
//						for (HashMap<Integer, Integer> vertex : routeMap.get(key)) {
//							for (int keyInner : vertex.keySet()) {
//								//System.out.println(keyInner);
//								if (keyInner == x ){
//									
//									if ((minValue == 0 || minValue > vertex.get(keyInner))) {
//										//System.out.println(minValue +  "vsvs" + vertex.get(keyInner));
//										//System.out.println("*"+keyInner + " -> " + key + " : " + vertex.get(keyInner));
//									//System.out.println("!!!" + keyInner);
//										minValue = vertex.get(keyInner);
//										minValueKey=key;
//									}
//										
//								}
//							}
//						}
//
//					}
//				}
			}
			
				//System.out.println(minValueKey);
				mstMinValue+=minValue;
				//System.out.println("!!" + minValueKey);
				
				checkIfMade.set(minValueKey, 1);
				if (!groupOfNode.contains(minValueKey) && minValueKey!=0) {
					groupOfNode.add(minValueKey);
				}
			
			
			//System.out.println(checkIfMade);
		}
		
		System.out.println(mstMinValue);
		
	}
}