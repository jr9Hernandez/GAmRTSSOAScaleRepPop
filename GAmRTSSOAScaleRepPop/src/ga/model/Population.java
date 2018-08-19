package ga.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import ga.config.ConfigurationsGA;

public class Population {
	
	static Random rand = new Random();
	
	private ArrayList<ChromosomeValue> Chromosomes;
	
	public Population(){
		this.Chromosomes = new ArrayList<>();
	}
	
//	public Population(HashMap<Chromosome, BigDecimal> chromosomes){
//		this.Chromosomes = new ArrayList<>();
//		for(Chromosome c : chromosomes.keySet()){
//			this.addChromosome(c);
//		}
//	}

	public Population(ArrayList<ChromosomeValue> chromosomes) {
		super();
		Chromosomes = chromosomes;
	}

	public ArrayList<ChromosomeValue> getChromosomes() {
		return Chromosomes;
	}

	public void setChromosomes(ArrayList<ChromosomeValue> chromosomes) {
		Chromosomes = chromosomes;
	}
	
	public void addAllCromossomes(ArrayList<ChromosomeValue> chromosomes){
		this.Chromosomes = new ArrayList<>();
		for(ChromosomeValue c : chromosomes){
			addChromosome(c.getCromo());
		}
	}
	
	public void addChromosome(Chromosome chromosome){
		int id = rand.nextInt(1000000);
		//check if the id exist or not
		while(idExist(id)){
			id = rand.nextInt(1000000);
		}
		
		ChromosomeValue tChrom = new ChromosomeValue(id, chromosome, BigDecimal.ZERO);
		this.Chromosomes.add(tChrom);
	}	
	
	public void print(){
		System.out.println("-- Population --");
		for(ChromosomeValue c : Chromosomes){
			c.print();
		}
		System.out.println("-- Population --");
	}
	
	public void printWithValue(){
		System.out.println("-- Population --");
		for(ChromosomeValue c : Chromosomes){
			c.print();
		}
		System.out.println("-- Population --");
	}
	
	/**
	 * Função que zera os valores das avaliações dos Chromossomos.
	 */
	public void clearValueChromosomes(){
		for(ChromosomeValue chromo : this.Chromosomes){
			chromo.cleanValue();
		}
	}
	
	//static methods
	
	/**
	 * Cria uma população inicial gerada randomicamente.
	 * @param size Tamanho limite da população
	 * @return uma população com Key = Chromosome e Values = 0
	 */
	public static Population getInitialPopulation(int size){
		ArrayList<ChromosomeValue>  newChromosomes = new ArrayList<>();
		int id = 0;
		Chromosome tChom;
		for (int i = 0; i < size; i++) {
			//gerar o novo cromossomo com base no tamanho
			tChom = new Chromosome();
			int sizeCh=rand.nextInt(ConfigurationsGA.SIZE_CHROMOSOME)+1;
			for (int j = 0; j < sizeCh; j++) {
				tChom.addGene(rand.nextInt(ConfigurationsGA.QTD_SCRIPTS));
			}
			id++;
			newChromosomes.add(new ChromosomeValue(id,tChom, BigDecimal.ZERO));
		}
		Population pop = new Population(newChromosomes);
		return pop;
	}
	
	
	/**
	 * Cria uma população inicial com os genes dos cromossomos iguais ao passado por parametros
	 * @param gene Integer que será utilizado como gene dos cromossomos
	 * @return uma população com Key = Chromosome e Values = 0
	 */
	public static Population getInitialPopulation(Integer gene){
		ArrayList<ChromosomeValue>  newChromosomes = new ArrayList<>();
		int id = 0;
		Chromosome tChom;
		for (int i = 0; i < ConfigurationsGA.SIZE_POPULATION; i++) {
			//gerar o novo cromossomo com base no tamanho
			tChom = new Chromosome();
			for (int j = 0; j < ConfigurationsGA.SIZE_CHROMOSOME; j++) {
				tChom.addGene(gene);
			}
			id++;
			newChromosomes.add(new ChromosomeValue(id, tChom, BigDecimal.ZERO));
		}
		
		Population pop = new Population(newChromosomes);
		return pop;
	}

	
	public ArrayList<Chromosome> getListChromosome(){
		ArrayList<Chromosome> nList = new ArrayList<>();
		
		for (ChromosomeValue cvalue : Chromosomes) {
			nList.add(cvalue.getCromo());
		}
		
		return nList;
	}
	
	private boolean idExist(Integer checkID){
		
		for (ChromosomeValue cValue : Chromosomes) {
			if(cValue.getID() == checkID){
				return true;
			}
		}
		
		return false;
	}
	
	public ChromosomeValue getChromoValueByID(Integer id){
		for (ChromosomeValue cValue : Chromosomes) {
			if(cValue.getID() == id){
				return cValue;
			}
		}
		
		return null;
	}
	
}
