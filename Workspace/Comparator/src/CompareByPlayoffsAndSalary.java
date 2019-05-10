//Justin Cai, jc5pz and Ayush Mayur, am3nz
import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if(a.isPlayoffTeam() && !b.isPlayoffTeam()) {
			return -1;
		}
		else if(b.isPlayoffTeam() && !a.isPlayoffTeam()) {
			return 1;
		}
		else if(a.getSalaryInMillions() < b.getSalaryInMillions()) {
			return -1;
		}
		else if(b.getSalaryInMillions() < a.getSalaryInMillions()) {
			return 1;
		}
		return 0;
		
	}

}