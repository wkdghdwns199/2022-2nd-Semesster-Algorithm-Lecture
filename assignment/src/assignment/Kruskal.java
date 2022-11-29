package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class VertexComparator implements Comparator<ArrayList<Integer>>{
	public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		if ( arr1.get(2) < arr2.get(2) ) return -1;
		else if (arr1.get(2) == arr2.get(2)) return 0;
		else return 1;
	}
}

public class Kruskal {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); 
		ArrayList<ArrayList<Integer>> routeMap = new ArrayList<>();
		
		StringTokenizer st = null;
		st = new StringTokenizer(scan.readLine());
		int node = Integer.parseInt(st.nextToken()); 
		int edge = Integer.parseInt(st.nextToken()); 
		
		
		
		for (int i=0; i<edge; i++) {
			
			ArrayList<Integer> route = new ArrayList<>();
					
			st = new StringTokenizer(scan.readLine());
			for (int j=0; j<3; j++) {
				route.add(Integer.parseInt(st.nextToken()));
			}
			routeMap.add(route);
		}
		
		Collections.sort(routeMap, new VertexComparator());
		
		int[] checkIfCycle = new int[node+1];
		
//		for (int i=0; i<routeMap.size(); i++) {
//			System.out.println(routeMap.get(i));
//		}
		
		for (int i=0; i<node+1; i++) {
			checkIfCycle[i]=-1;
		}
		
		ArrayList<Integer> checkIfMade = new ArrayList<>(); 
		
		for (int i=0; i<node+1; i++) {
			checkIfMade.add(0);
		}
		checkIfMade.set(0,1);
		int mstSum=0;
		
		
		for (int i=0; i<routeMap.size(); i++) {
			
			if (checkIfCycle[routeMap.get(i).get(0)] == checkIfCycle[routeMap.get(i).get(1)]) {
				if (checkIfCycle[routeMap.get(i).get(0)] == -1 && checkIfCycle[routeMap.get(i).get(1)] == -1) {
					checkIfCycle[routeMap.get(i).get(0)] = routeMap.get(i).get(0);
					checkIfCycle[routeMap.get(i).get(1)] = routeMap.get(i).get(0);
					
					checkIfMade.set(routeMap.get(i).get(0), 1);
					checkIfMade.set(routeMap.get(i).get(1), 1);
					
					mstSum += routeMap.get(i).get(2);
					//System.out.println("1. " + routeMap.get(i).get(0) + "->" + routeMap.get(i).get(1) + " " + routeMap.get(i).get(2)+ " " + i + " " +mstSum);
				}
			}
			else {
				
				if (checkIfCycle[routeMap.get(i).get(0)] == -1 && checkIfCycle[routeMap.get(i).get(1)] != -1){
					checkIfCycle[routeMap.get(i).get(0)] = checkIfCycle[routeMap.get(i).get(1)];
					checkIfMade.set(routeMap.get(i).get(0), 1);
					mstSum += routeMap.get(i).get(2);
					//System.out.println("2. " + routeMap.get(i).get(0) + "->" + routeMap.get(i).get(1) + " " + routeMap.get(i).get(2)+ " " + i+" " +mstSum);
				}
				else if (checkIfCycle[routeMap.get(i).get(1)] == -1 && checkIfCycle[routeMap.get(i).get(0)] != -1) {
					checkIfCycle[routeMap.get(i).get(1)] = checkIfCycle[routeMap.get(i).get(0)];
					checkIfMade.set(routeMap.get(i).get(1), 1);
					mstSum += routeMap.get(i).get(2);
					//System.out.println("3. " + routeMap.get(i).get(0) + "->" + routeMap.get(i).get(1) + " " + routeMap.get(i).get(2)+ " " + i+" " +mstSum);
				}	
				else if (checkIfCycle[routeMap.get(i).get(1)] != -1 && checkIfCycle[routeMap.get(i).get(0)] != -1){	
					
					if (checkIfCycle[routeMap.get(i).get(0)] != checkIfCycle[routeMap.get(i).get(1)]) {
						//System.out.println(checkIfCycle[routeMap.get(i).get(0)] +" " + checkIfCycle[routeMap.get(i).get(1)]);
						mstSum += routeMap.get(i).get(2);
						//System.out.println("4. " + routeMap.get(i).get(0) + "->" + routeMap.get(i).get(1) + " " + routeMap.get(i).get(2)+ " " + i+ " " +mstSum);
						int[] temp = Arrays.copyOf(checkIfCycle, node+1);
						for (int j=0; j<node+1; j++) {
							//System.out.print(checkIfCycle[j] + "->" + checkIfCycle[routeMap.get(i).get(0)]);
							if (temp[j] == checkIfCycle[routeMap.get(i).get(0)]) {
								temp[j] = checkIfCycle[routeMap.get(i).get(1)];
							}
							//System.out.println(checkIfCycle[j]);
						}
						checkIfCycle = Arrays.copyOf(temp, node+1);
					}
				}
			}
			
		}

//		for (int j=0; j<node+1; j++) {
//			System.out.print(checkIfCycle[j] + " ");
//		}
//		System.out.println(checkIfMade);
//		System.out.println();
		System.out.println(mstSum);
		
	}

}
