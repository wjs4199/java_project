import java.io.FileWriter; 
import java.io.IOException; 
import java.io.FileNotFoundException; 
import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.*;

class RankingFile {
	
	private static String DATA_FILE= "C:\\JYE_HOME\\JAVA\\javateamplay\\src\\gui\\ranking.txt";
	private ArrayList<File1> filedata;

	//Constructor
	public RankingFile(){
		filedata=new ArrayList<>();
	}
	public int getfiledata() {return filedata.size();}
	
	public String[][] getvalues(){
		String values[][] = new String[filedata.size()][3];
		for(int i=0;i<filedata.size();i++) {
			values[i][0]= String.valueOf(filedata.get(i).getRanking())+"위";
			values[i][1]= filedata.get(i).getName();
			values[i][2]= String.valueOf(filedata.get(i).getWin_number());			System.out.println(values[i][0]+values[i][1]+values[i][2]);
		}
		return values;
	}
	//Save updated game ranking history
	public void save() {
		FileWriter outputStream = null;
		try{
			outputStream = new FileWriter(DATA_FILE);
			for (int i = 0; i < filedata.size(); i++) {
				String line=filedata.get(i).getRanking()+":"+filedata.get(i).getName()+":"+filedata.get(i).getWin_number()+"\n";
				outputStream.write(line);
			}
			outputStream.close();  
		} 
		catch(FileNotFoundException e){ 
			System.out.println("Error opening the file" + DATA_FILE); 
		}
		catch (IOException e) {
			System.out.println("Error in" + DATA_FILE); 
		} 
	}
	
	//Loading original ranking history
	public void load() {
		Scanner inputStream = null; 
		try{ 
			inputStream = new Scanner(new File(DATA_FILE)); 
		} 
		catch(FileNotFoundException e){ 
			System.out.println("Error opening the file " + DATA_FILE); 
			System.exit(0); 
		} 
		while(inputStream.hasNextLine()){
		    String line=inputStream.nextLine();
		    String[] history=new String[3];
		    history = line.split(":");
      		    File1 temp=new File1(Integer.parseInt(history[0]),history[1],Integer.parseInt(history[2]));
      		    filedata.add(temp);
    		} 
		inputStream.close(); 
	}

	//Update the game history of Player1 and Player2 in the original ranking
	public void update_players(Player p1, Player p2) {
		boolean check1= false;
		boolean check2= false;  
		for(int i=0;i<filedata.size();i++) {
			if(filedata.get(i).getName().equals(p1.get_NAME())) {
				if(p1.is_win(p2)==1){
					filedata.get(i).plusWin_number();
				}
				check1=true;
			}
			else if(filedata.get(i).getName().equals(p2.get_NAME())) {
				if(p1.is_win(p2)==-1){
					filedata.get(i).plusWin_number();
				}
				check2=true;
			}
		}
		File1 temp;
		if(check1==false) {
		      if(p1.is_win(p2)==1){
		    	  temp=new File1(0,p1.get_NAME(),1);
		      }
		      else{
		    	  temp=new File1(0,p1.get_NAME(),0);
		      }
		      filedata.add(temp);
		}
		if(check2==false) {
		      if(p1.is_win(p2)==-1){
		    	  temp=new File1(0,p2.get_NAME(),1);
		      }
		      else{
		    	  temp=new File1(0,p2.get_NAME(),0);
		      }
		      filedata.add(temp);
		}
		sort_ranking(0, filedata.size()-1);
		save();
  	}  
	
	//Update ranking numbers based on number of wins
	public void sort_ranking(int left, int right) { 
		int pivot, i, j; 
		if (left < right) { 
			i = left;     
			j = right+1; 
			pivot = filedata.get(left).getWin_number(); 
			do { 
			   do i++; 
			   while(i <= right && filedata.get(i).getWin_number() > pivot); 
			   do j--; 
			   while(j  > left  && filedata.get(j).getWin_number() < pivot); 
			   if(i<j) {
           			Collections.swap(filedata, i, j);
			   }
			}while (i<j);     
			    
      		  Collections.swap(filedata, left, j);
		  sort_ranking(left, j-1); 
		  sort_ranking(j+1, right); 
		}
		int ranking_update=1;
		for(int k=0;k<filedata.size();k++) {
			if(k!=0){
				if(filedata.get(k).getWin_number()==filedata.get(k-1).getWin_number()) { 
					filedata.get(k).setRanking(filedata.get(k-1).getRanking());
				}
				else{
					filedata.get(k).setRanking(ranking_update++);}
				}
		    else{
		    	filedata.get(k).setRanking(ranking_update++);
		    }
		}
	}
  
  
	/*//Print Ranking (automatically load, update, save)
	public void print_ranking(Player p1, Player p2) {
		load();
		update_players(p1, p2);
		sort_ranking(0, filedata.size()-1);
		System.out.println("===============Ranking==============="); //37
		System.out.println("Ranking        Player name        Win"); // 7 11 3
		for(int i=0;i<10;i++) {
			System.out.printf("%7d        %11s        %3d\n", filedata.get(i).getRanking(), filedata.get(i).getName(), filedata.get(i).getWin_number());
			//System.out.println("  "+filedata.get(i).getRanking()+"위         "+filedata.get(i).getName()+"       "+filedata.get(i).getWin_number());
		}
		save();
	}*/
}
