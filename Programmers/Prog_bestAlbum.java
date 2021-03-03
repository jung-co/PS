package Programmers;

import java.util.*;
import java.io.*;

public class Prog_bestAlbum {
	public static void main(String[] args) throws IOException {
		
	}
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        HashMap<Integer, String> gMap = new HashMap<>();
        HashMap<Integer, Integer> pMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
        	gMap.put(i, genres[i]);
        	pMap.put(i, plays[i]);
        }
        
        HashSet<String> gSet = new HashSet<>();
        for(int i=0; i<genres.length; i++) {
        	gSet.add(genres[i]);
        }
        
        HashMap<Integer, String> genresPlay = new HashMap<>();
        for(String s : gSet) {
        	int count = 0;
        	for(int i=0; i<gMap.size(); i++) {
        		if(gMap.get(i).equals(s)) {
        			count += pMap.get(i);
        		}
        	}
        	
        	genresPlay.put(count, s);
        }
        
        // play Ƚ�� ���� ���� (Ű �� ����)
        TreeMap sort = new TreeMap(genresPlay);
        String[] sortGenre = new String[gSet.size()];
        
        int idx = 0;
        for(Object o : sort.keySet()) {
        	sortGenre[idx] = sort.get(o).toString();
        	idx++;
        }
        
        /// genre�� ���� �÷��� �� �뷡�� ������ȣ ã��
        ArrayList<Integer> pIdx = new ArrayList<Integer>();
        for(int i=sortGenre.length-1; i>=0; i--) {
        	int count = 0;
        	for(int p : gMap.keySet()) {
        		if(sortGenre[i].equals(gMap.get(p))) {
        			count++;
        		}
        	}
        	
        	int[] tmp = new int[count];
        	int k = 0;
        	for(int p : gMap.keySet()) {
        		if(sortGenre[i].equals(gMap.get(p))) {
        			tmp[k] = pMap.get(p);
        			k++;
        		}
        	}
        	
            if(tmp.length != 1){
                Arrays.sort(tmp);
                for(int j = tmp.length - 1; j >= tmp.length - 2; j--){
                    for(int p : pMap.keySet()){
                        if(tmp[j] == pMap.get(p)){
                            pIdx.add(p);
                            pMap.put(p, 0);
                            break;
                        }
                    }
                }                
            }else{
                for(int p : pMap.keySet()){
                    if(tmp[0] == pMap.get(p)){
                        pIdx.add(p);
                        pMap.put(p, 0);
                        break;
                    }
                }                
            }
}
        
        answer = new int[pIdx.size()];
        
        for(int i = 0; i < pIdx.size(); i++){
            answer[i] = pIdx.get(i);
        }
        
        return answer;
    }
}