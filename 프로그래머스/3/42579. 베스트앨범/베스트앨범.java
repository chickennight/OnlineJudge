import java.util.*;
class Solution {
    private class Genre{
        String genre;
        int total;
        public Genre(String genre, int total){
            this.genre = genre;
            this.total = total;
        }
    }
    private class Song{
        int id,time;
        public Song(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        
        HashMap<String, List<Song>> map = new HashMap<>();
        ArrayList<Genre> cntList = new ArrayList<>();
        int size = genres.length;
        String genre;
        int play;
        
        for(int i=0; i<size; ++i){
            genre = genres[i];
            play = plays[i];
            if(map.containsKey(genre)){
                List<Song> list = map.get(genre);
                list.add(new Song(i,play));
                for(int j=0; j<cntList.size(); ++j){
                    if(cntList.get(j).genre.equals(genre)){
                        cntList.get(j).total += play;
                        break;
                    }
                }
            }else{
                List<Song> list = new ArrayList<>();
                list.add(new Song(i,play));
                map.put(genre,list);
                cntList.add(new Genre(genre,play));
            }
        }
        
        Collections.sort(cntList,(o1,o2)->{
            return o2.total-o1.total;
        });
        
        List<Integer> answer = new ArrayList<>(); 
        for(int i=0; i<cntList.size(); ++i){
            List<Song> list = map.get(cntList.get(i).genre);
            Collections.sort(list,(o1,o2)->{
                return o2.time-o1.time;
            });
            for(int j=0; j<Math.min(2,list.size()); ++j){
                answer.add(list.get(j).id);
            }
        }
        return answer;
    }
}
