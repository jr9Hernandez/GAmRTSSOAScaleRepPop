package ga.model;

import java.math.BigDecimal;

public class ChromosomeValue {
	
	private Integer ID;
	private Chromosome cromo;
	private BigDecimal value;
	
	public ChromosomeValue(){
		this.ID = -1;
		this.cromo = new Chromosome();
		this.value = BigDecimal.ZERO;
	}
	
	public ChromosomeValue(Integer id, Chromosome cromo, BigDecimal value) {
		this.ID = id;
		this.cromo = cromo;
		this.value = value;
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Chromosome getCromo() {
		return cromo;
	}
	public void setCromo(Chromosome cromo) {
		this.cromo = cromo;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public void print(){
		System.out.print("ID "+ID + " ");
		cromo.print();
		System.out.println("Value = "+ value);
	}
	
	public void cleanValue(){
		this.value = BigDecimal.ZERO;
	}
	
	public void updateValue(){
		this.value = this.value.add(BigDecimal.ONE);
	}
}
