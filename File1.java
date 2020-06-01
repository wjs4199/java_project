
public class File1 {
	private int ranking;
	private String name;
	private int win_number;

	public File1(){
		ranking=0;
		name="name";
		win_number=0;
	}

	public File1(int ranking, String name, int win_number){
	  	this.ranking=ranking;
    	this.name=name;
    	this.win_number=win_number;
  	}

  	public int getRanking() {
		return ranking;
	}
  	
  	public String getRanking_str() {
		return String.valueOf(ranking);
	}

  	public void setRanking(int ranking){
  		this.ranking=ranking;
  	}

  	public String getName() {
		return name;
	}

  	public void setName(String name){
  		this.name=name;
  	}

  	public int getWin_number() {
		return win_number;
	}
  	
  	public String getWin_number_str() {
		return String.valueOf(win_number);
	}

  	public void setWin_number(int win_number){
  		this.win_number=win_number;
  	}
  
	public void plusWin_number(){
		win_number++;
	}
}
