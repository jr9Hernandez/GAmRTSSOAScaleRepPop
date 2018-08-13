package model;

public class EvalResult  implements Comparable<EvalResult>{
	
	private Integer evaluation;
	private String IA1, IA2;
	private Integer idIA1, idIA2;
	
	public EvalResult(){
		evaluation = 0;
		IA1="";
		IA2="";
		idIA1 = -1;
		idIA2 = -1;
	}
	
	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public String getIA1() {
		return IA1;
	}

	public void setIA1(String iA1) {
		IA1 = iA1;
	}

	public String getIA2() {
		return IA2;
	}

	public void setIA2(String iA2) {
		IA2 = iA2;
	}

	public Integer getIdIA1() {
		return idIA1;
	}

	public void setIdIA1(Integer idIA1) {
		this.idIA1 = idIA1;
	}

	public Integer getIdIA2() {
		return idIA2;
	}

	public void setIdIA2(Integer idIA2) {
		this.idIA2 = idIA2;
	}

	public String getLine(){
		return " Evaluation= "+this.evaluation+" ID IA1= "+ idIA1+" IA1= "+ IA1+ " ID IA2= "+ idIA2+" IA2="+IA2;
	}
	
	public void print(){
		System.out.println("AI's do confronto:");
		System.out.println("IA1= "+IA1+" id IA1= "+idIA1);
		System.out.println("IA2= "+IA2+" id IA2= "+idIA2);
		System.out.println(" Winner ="+ (evaluation));
		System.out.println();
	}

	@Override
	public int compareTo(EvalResult o) {
		if(this.evaluation > o.getEvaluation()){
			return -1;
		}
		if(this.evaluation < o.getEvaluation()){
			return 1;
		}
		
		return 0;
	}
	
}
