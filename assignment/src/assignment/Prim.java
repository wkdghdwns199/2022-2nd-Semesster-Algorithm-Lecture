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
		
		for (int i=0; i<n+1; i++) {
			checkIfMade.add(0);
		}
		checkIfMade.set(0, 1);
		
		int startNode = 0;
		checkIfMade.set(startNode, 1);
		
		for (int i=0; i<m; i++) {
			token = new StringTokenizer(scan.readLine());
			HashMap<Integer, Integer> temp = new HashMap<>();
			HashMap<Integer, Integer> temp2 = new HashMap<>();
			ArrayList<HashMap<Integer, Integer>> tempArr;
			ArrayList<HashMap<Integer, Integer>> tempArr2;
			String key = token.nextToken();
			
//			if (startNode == 0) {
//				startNode = Integer.parseInt(key);
//				checkIfMade.set(startNode, 1);
//				nextNode =1;
//			}
			
			int endNode = Integer.parseInt(token.nextToken());
			int vertexValue = Integer.parseInt(token.nextToken());
			
			temp.put(endNode, vertexValue);
			temp2.put(Integer.parseInt(key), vertexValue);
			
			if (routeMap.containsKey(Integer.parseInt(key))) {
				tempArr = routeMap.get(Integer.parseInt(key));
			}
			else {
				tempArr = new ArrayList<>();
			}
			
			if (routeMap.containsKey(endNode)) {
				tempArr2 = routeMap.get(endNode);
			}
			else {
				tempArr2 = new ArrayList<>();
			}
			
			
			tempArr.add(temp);
			tempArr2.add(temp2);
			
			routeMap.put(Integer.parseInt(key),tempArr);
			routeMap.put(endNode,tempArr2);
		}
		
		
		//token = new StringTokenizer(scan.readLine());
		//int w  = Integer.parseInt(token.nextToken());
		
		startNode=1;
		checkIfMade.set(startNode, 1);
		
		//System.out.println(startNode);
		
//		for (int i=1; i<n+1; i++) {
//			System.out.println(i + " " + routeMap.get(i));
//		}
		
		
		
		int mstMinValue=0;
		
		while (checkIfMade.contains(0)) {

			int minValue=Integer.MAX_VALUE;
			int minValueKey = 0;
			
			for (HashMap<Integer, Integer> vertex : routeMap.get(startNode)) {
				for (int key : vertex.keySet()) {
					if ((minValue > vertex.get(key)) && checkIfMade.get(key) == 0){
						minValue = vertex.get(key);
						minValueKey=key;
					}
				}
			}
			
			mstMinValue+=minValue;
			checkIfMade.set(minValueKey, 1);
			//System.out.println(minValueKey+ " " + mstMinValue + " " + minValue);
//			for (int i=0; i<routeMap.get(startNode).size(); i++) {
//				if (routeMap.get(startNode).get(i).entrySet().iterator().next().getKey() == minValueKey) {
//					routeMap.get(startNode).remove(i);
//					i--;
//				}
//			}
//			System.out.println("!" + minValueKey);
//			System.out.println(routeMap.get(minValueKey).size());
//			for (int i=0; i<routeMap.get(minValueKey).size(); i++) {
//				if (routeMap.get(minValueKey).get(i).entrySet().iterator().next().getKey() == nextNode) {
//					routeMap.get(minValueKey).remove(i);
//					i--;
//				}
//			}
//			System.out.println(minValueKey);
			for (HashMap<Integer, Integer> temp : routeMap.get(minValueKey)) {
				routeMap.get(startNode).add(temp);
			}
			
			
			
//			for (int x : groupOfNode) {
//				//System.out.println("!" + x);
//				if (routeMap.keySet().contains(x)) {
//					for (HashMap<Integer, Integer> vertex : routeMap.get(x)) {
//						for (int key : vertex.keySet()) {
//							if ((minValue == 0 || minValue > vertex.get(key)) && !groupOfNode.contains(key)){
//								//System.out.println(x + " -> " + key + " : " + vertex.get(key));
//								minValue = vertex.get(key);
//								minValueKey=key;
//							}
//						}
//					}
//					
//				}
				
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
//			}
			
				//System.out.println(minValueKey);
				
				//System.out.println("!!" + minValueKey);
				
				
//				if (!groupOfNode.contains(minValueKey) && minValueKey!=0) {
//					groupOfNode.add(minValueKey);
//				}
//			
			
			//System.out.println(checkIfMade);
			
//			System.out.println(minValueKey);	
//			System.out.println(checkIfMade);
//			System.out.println(routeMap.get(minValueKey));
			
			//System.out.println(mstMinValue + " " + minValue);
			
		}
		
		System.out.println(mstMinValue);
		
	}
}