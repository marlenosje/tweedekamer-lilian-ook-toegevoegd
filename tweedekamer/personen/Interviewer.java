package personen;
import data.Vraag;

public class Interviewer extends Persoon implements InterviewerInterface {
	private String omroep;
	
	@Override
	public String StelMoeilijkeVraag() {
		return Vraag.getVraag();
	}

	@Override
	public void setOmroep(String omroep) { this.omroep = omroep; }

	@Override
	public String getOmroep() {	return this.omroep; }
	
}
