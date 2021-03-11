package element;

public class Communication {
	private Diffuser diffuser;
	private Receptionner receptionner;
	public Communication(Diffuser diffuser, Receptionner receptionner) {
		this.diffuser = diffuser;
		this.receptionner = receptionner;
	}
	public Diffuser getDiffuser() {
		return diffuser;
	}
	public Receptionner getReceptionner() {
		return receptionner;
	}
	public void setDiffuser(Diffuser diffuser) {
		this.diffuser = diffuser;
	}
	public void setReceptionner(Receptionner receptionner) {
		this.receptionner = receptionner;
	}
	
}
