//Justin Cai, jc5pz and Ayush Mayur, am3nz
import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if(a.getNumberOfWins() > b.getNumberOfWins()) {
			return -1;
		}
		else if(b.getNumberOfWins() > a.getNumberOfWins()) {
			return 1;
		}
		else if(a.getNumberOfLosses() < b.getNumberOfLosses()) {
			return -1;
		}
		else if(b.getNumberOfLosses() < a.getNumberOfLosses()) { 
			return 1;
		}
		else if(a.getNumberOfChampionships() > b.getNumberOfChampionships()) {
			return -1;
		}
		else if(b.getNumberOfChampionships() > a.getNumberOfChampionships()) {
			return 1;
		}
		return 0;
		
	}

}