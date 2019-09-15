package model;

public class Technique {
	
	
	private String nameTec;
	private double factor;
	
	
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


	public void setFactor(double factor) {
		this.factor = factor;
	}
	

}
