package model;

public class Technique {
	
	
	private String nameTec;
	private double factor;
	
	//Relation
	private Technique next;
	
	
	public Technique(String nameTec, double factor) {
		
		this.nameTec = nameTec;
		this.factor = factor;
	}


	public String getNameTec() {
		return nameTec;
	}


	public void setNameTec(String nameTec) {
		this.nameTec = nameTec;
	}


	public double getFactor() {
		return factor;
	}
	

	public Technique getNext() {
		return next;
	}


	public void setNext(Technique next) {
		this.next = next;
	}


	public void setFactor(double factor) {
		this.factor = factor;
	}
	public void changeNext (Technique technique) {
		next=technique;
		
	}
	
	
	
	

}