import java.io.FileWriter; 
import java.io.IOException; 
import java.io.FileNotFoundException; 
import java.io.File; 
import java.util.Scanner; 

class RankingFile {
	
	private static String DATA_FILE= "ranking.txt";
	private File1[] filedata=new File1[12];
  
  //Constructor
  public RankingFile(){
    for(int i=0;i<12;i++){
      filedata[i]=new File1(0,"blank",0);
    }
  }

  //Save updated game ranking history
	public void save() {
		FileWriter outputStream = null;
		try{
			outputStream = new FileWriter(DATA_FILE);
			for (int i = 0; i < 10; i++) {
				String line=filedata[i].getRanking()+":"+filedata[i].getName()+":"+filedata[i].getWin_number()+"\n";
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
		for(int i=0;i<10;i++){
      String[] history=new String[3];
			String line = inputStream.nextLine();
			history = line.split(":");
      filedata[i]=new File1(Integer.parseInt(history[0]),history[1],Integer.parseInt(history[2]));	
    } 
		inputStream.close(); 
	}

  //Update the game history of Player1 and Player2 in the original ranking
	public void update_players(Player p1, Player p2) {
		boolean check1= false;
		boolean check2= false;  
		for(int i=0;i<10;i++) {
			if(filedata[i].getName().equals(p1.getName())) {
        if(p1.getOutcome()){
          filedata[i].plusWin_number();
        }
				check1=true;
			}
			else if(filedata[i].getName().equals(p2.getName())) {
        if(p1.getOutcome()){
          filedata[i].plusWin_number();
        }
				check2=true;
			}
		}
		int j=11;
		if(check1==false) {
      filedata[j++]=new File1(j,p1.getName(),0);
	  }
		if(check2==false) {
			filedata[j]=new File1(j,p2.getName(),0);
		}
  }  
	
	//Update ranking numbers based on number of wins
	public void sort_ranking(int left, int right) { 
		int pivot, i, j; 
		if (left < right) { 
			i = left;     
			j = right+1; 
			pivot = filedata[left].getWin_number(); 
			do { 
			   do i++; 
			   while(i <= right && filedata[i].getWin_number() > pivot); 
			   do j--; 
			   while(j  > left  && filedata[j].getWin_number() < pivot); 
			   if(i<j) {
				   File1 temp=new File1();
				   temp=filedata[i];
				   filedata[i]=filedata[j];
				   filedata[j]=temp;
			   }
			}while (i<j);     
			    
			File1 temp=new File1();
			temp=filedata[left];
		  filedata[left]=filedata[j];
		  filedata[j]=temp;
		  sort_ranking(left, j-1); 
		  sort_ranking(j+1, right); 
		}
		int ranking_update=1;
		for(int k=0;k<12;k++) {
      if(k!=0){
        if(filedata[k].getWin_number()==filedata[k-1].getWin_number()) { 
				  filedata[k].setRanking(filedata[k-1].getRanking());
        }
        else{filedata[k].setRanking(ranking_update++);}
			}
      else{
        filedata[k].setRanking(ranking_update++);
      }
		}
	}
  
	//Print Ranking (automatically load, update, save)
	public void print_ranking(Player p1, Player p2) {
    load();
    update_players(p1, p2);
    sort_ranking(0, 11);
		System.out.println("===============Ranking==============");
		System.out.println("Ranking    Player name    Win");
		for(int i=0;i<10;i++) {
			System.out.println("  "+filedata[i].getRanking()+"위         "+filedata[i].getName()+"       "+filedata[i].getWin_number());
		}
		save();
	}
}
