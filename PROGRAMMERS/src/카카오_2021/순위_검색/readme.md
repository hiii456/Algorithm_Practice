## Programmers - μμ κ²μ 
- Level 2 
- dfs, binarySearch  
- 2021 KAKAO BLIND RECRUITMENT
π[μμ κ²μ λ¬Έμ  λ°λ‘κ°κΈ°](https://programmers.co.kr/learn/courses/30/lessons/72412)



## νμ΄

μ΄ λ¬Έμ λ dfsμ μ΄λΆνμμ μ¬μ©νμκ³  μΉ΄μΉ΄μ€ λ¬Έμ νμ΄λ₯Ό μ°Έκ³ νμ¬ λ¬Έμ λ₯Ό νμλ€.

μ΄ λ¬Έμ λ ν¨μ¨μ±λ ν΅κ³Όν΄μΌνλ―λ‘ info λ°°μ΄μμ μ‘°κ±΄μ ν΄λΉνλ μ§μμλ₯Ό μ°Ύλλ€λ©΄ μ νμ±μ λ€ λ§μμ§ λͺ°λΌλ ν¨μ¨μ±μ μκ°μ΄κ³Όλ‘ λ¬λ€.
λ°λΌμ μ§μμλ€μ κ·Έλ£Ήλ³λ‘ λ―Έλ¦¬ λΆλ₯ν΄λμ΄ λ¬Έμ λ₯Ό νμ΄μΌνλ€.

μλ₯Ό λ€μ΄ βjava backend junior pizza 150β μ§μμμ κ²½μ°,
|μΈμ΄|	μ§κ΅°	|κ²½λ ₯	|μμΈ νΈλ	|μ μ|
|---|---|---|---|---|
|java|	backend|	|junior|	pizza|	|150|
|β|	backend|	junior	pizza|	150|
|java|	β|	junior	pizza|	150|
|java|	backend|	β	pizza|	150|
|java|	backend	|junior|	β|	150|
|β|	β|	junior|	pizza|	150|
|β|	backend|	β	|pizza|	150|
|β¦(μλ΅)|	|	|	|	|
|java|	β|	β	|β|	150|
|β|	β|	β|	β|	150|

μ¦, 16κ°μ§ ννλ‘ λνλΌ μ μλ€. 

μ΄λ κ² λ§λ  μ§μμμ μ λ³΄λ₯Ό hashmapμ keyκ°μΌλ‘ μ μ₯νκ³  κ°κ°μ ν΄λΉνλ μ μλ λ¦¬μ€νΈ ννλ‘ λ§λ€μ΄ μ μ₯νλ€.
μ¦, κ²μ μ‘°κ±΄μ΄ βjava and backend and junior and pizza 100β³μ΄λΌ νλ©΄, μ μ§μμλ κ²μ λμμ ν¬ν¨λλ©°, κ²μ μ‘°κ±΄μ΄ βjava and β and junior and β 100β μΈ κ²½μ°μλ κ²μ λμμ ν¬ν¨μ΄ λμ΄μΌνλ€.

~~~java
    public static void dfs(String[] applicant,String str,int cnt){
        if(cnt == 4){
            if(!hm.containsKey(str)){
                List<Integer> list = new ArrayList<>();               
                hm.put(str,list);
            }
            // infoμ λ§¨λ§μ§λ§μ ν΄λΉνλ μ½λ©νμ€νΈ μ μλ ν΄λΉνλ infoμ listμ λ£λλ€.
            hm.get(str).add(Integer.parseInt(applicant[4]));
            return;
        }
        
        dfs(applicant, str + "-" , cnt+1);
        dfs(applicant, str + applicant[cnt], cnt+1);
    }
~~~

κ·Έλ¦¬κ³  μ΄λΆνμμ μν΄ κ° keyμ ν΄λΉνλ μ μ λ¦¬μ€νΈλ₯Ό μ€λ¦μ°¨μν΄μ£Όλ μμμ νλ€.

~~~java
        for(String key : hm.keySet()){
            // κ° keyμ λ§λ μ½λ©νμ€νΈ μ μλ₯Ό μ€λ¦μ°¨μ μ λ ¬ 
            Collections.sort(hm.get(key));
        }
~~~

κ·Έλ¦¬κ³  κ²μμ‘°κ±΄μ ν΄λΉνλ μ μμ μΈμμ μΈκΈ°μν΄ μ΄λΆνμμ μ€ννλ€. (νμν κ°μ μ¬λ¬λ² μ°ΎμμΌ νλ€λ©΄ μκ°λ³΅μ‘λκ° O(logN)μΈ μ΄λΆνμμ μ¬μ©νλ κ²μ΄ ν¨μ¨μ μ΄λ€.)
μ¬κΈ°μ λ°°μ΄μ μ°Ύλ κ°μ΄ μμ μλ μμΌλ―λ‘ νΉμ  κ°λ³΄λ€ ν¬κ±°λ κ°μ μ²«λ²μ§Έ μμμ μΈλ±μ€λ₯Ό λ¦¬ν΄νλ lower boundλ₯Ό μ¬μ©νλ€.

~~~java
    public static int binarySearch(String info, int score){
        if(!hm.containsKey(info)){
            return 0;
        }
        
        List<Integer> list = hm.get(info);
        
        int left = 0;
        int right = list.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(score>list.get(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
~~~

## λ§νμ  

μ²μμ 2, 3, 4, 7, 13, 16 νμ€νΈ μΌμ΄μ€μμ λ°νμ μλ¬κ° λ°μνμλ€. κ·Έ μ΄μ λ μ§μμ μ λ³΄μ ν΄λΉνλ μ½λ©νμ€νΈ μ μ λ¦¬μ€νΈμ μ λ ¬μ query λ°°μ΄ λ°λ³΅λ¬Έμμ μ€νν΄μ£Όμλλ° μ΄λ query λ°°μ΄μ μ λ³΄κ° infoμ μλ μ λ³΄μ΄κΈ° λλ¬Έμ΄μλ€.

λ°λΌμ λ°λ‘ λ¦¬μ€νΈλ₯Ό μ λ ¬ν΄μ£Όλ λ°λ³΅λ¬Έμ λ°μμ μ€ννμκ³ , μ΄λΆνμμ ν λ ν΄λΉνλ μ λ³΄κ° μμΌλ©΄ 0μ λ¦¬ν΄νλλ‘ ifλ¬Έμ μ€μ ν΄μ£Όμλ€.


## μμ€μ½λ
~~~java
import java.util.*;
class Solution {
    static HashMap<String,List<Integer>> hm = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i=0; i<info.length; i++){
            String[] applicant = info[i].split(" ");
            dfs(applicant,"",0);
        }
        
        for(String key : hm.keySet()){
            // κ° keyμ λ§λ μ½λ©νμ€νΈ μ μλ₯Ό μ€λ¦μ°¨μ μ λ ¬ 
            Collections.sort(hm.get(key));
        }

        for(int i=0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ","");
            // μ‘°κ±΄μ ν΄λΉνλ μ§μμ μ λ³΄μ μ½λ©νμ€νΈ μ μ λΆλ¦¬ 
            String[] arr = query[i].split(" ");
            answer[i] = binarySearch(arr[0],Integer.parseInt(arr[1]));
        }
        return answer;
    }
    public static int binarySearch(String info, int score){
        if(!hm.containsKey(info)){
            return 0;
        }
        
        List<Integer> list = hm.get(info);
        
        int left = 0;
        int right = list.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(score>list.get(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
    public static void dfs(String[] applicant,String str,int cnt){
        if(cnt == 4){
            if(!hm.containsKey(str)){
                List<Integer> list = new ArrayList<>();               
                hm.put(str,list);
            }
            // infoμ λ§¨λ§μ§λ§μ ν΄λΉνλ μ½λ©νμ€νΈ μ μλ ν΄λΉνλ infoμ listμ λ£λλ€.
            hm.get(str).add(Integer.parseInt(applicant[4]));
            return;
        }
        
        dfs(applicant, str + "-" , cnt+1);
        dfs(applicant, str + applicant[cnt], cnt+1);
    }
}
~~~

## κ²°κ³Ό 

| μ νμ±  | νμ€νΈ |
|----|----|
|νμ€νΈ 1 |	ν΅κ³Ό (5.01ms, 76.1MB)|
|νμ€νΈ 2 |	ν΅κ³Ό (5.92ms, 77.7MB)|
|νμ€νΈ 3 |	ν΅κ³Ό (8.57ms, 75.4MB)|
|νμ€νΈ 4 |	ν΅κ³Ό (15.45ms, 89.5MB)|
|νμ€νΈ 5 |	ν΅κ³Ό (21.81ms, 78.9MB)|
|νμ€νΈ 6 |	ν΅κ³Ό (25.40ms, 94.9MB)|
|νμ€νΈ 7 |	ν΅κ³Ό (24.42ms, 91.5MB)|
|νμ€νΈ 8 |	ν΅κ³Ό (59.70ms, 122MB)|
|νμ€νΈ 9 |	ν΅κ³Ό (104.17ms, 114MB)|
|νμ€νΈ 10 |	ν΅κ³Ό (69.84ms, 129MB)|
|νμ€νΈ 11 |	ν΅κ³Ό (16.46ms, 80.8MB)|
|νμ€νΈ 12 |	ν΅κ³Ό (23.42ms, 88.2MB)|
|νμ€νΈ 13 |	ν΅κ³Ό (30.44ms, 88.6MB)|
|νμ€νΈ 14 |	ν΅κ³Ό (39.22ms, 112MB)|
|νμ€νΈ 15 |	ν΅κ³Ό (66.52ms, 106MB)|
|νμ€νΈ 16 |	ν΅κ³Ό (16.74ms, 94.9MB)|
|νμ€νΈ 17 |	ν΅κ³Ό (19.75ms, 91.8MB)|
|νμ€νΈ 18 |	ν΅κ³Ό (38.56ms, 110MB)|

---

|ν¨μ¨μ±  |νμ€νΈ|
|---|---|
|νμ€νΈ 1 |	ν΅κ³Ό (1086.45ms, 289MB)|
|νμ€νΈ 2 |	ν΅κ³Ό (1286.87ms, 305MB)|
|νμ€νΈ 3 |	ν΅κ³Ό (1274.50ms, 317MB)|
|νμ€νΈ 4 γ	ν΅κ³Ό (1759.69ms, 339MB)|