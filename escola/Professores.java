package escola;

public class Professores extends Pessoa implements Comparable<Professores> {
	
	public double valorHoraAula;

	public Professores(String matricula, String nome, char sexo, int quantideCreditos, double valorHoraAula) {
		super(matricula, nome, sexo, quantideCreditos);
		this.valorHoraAula = valorHoraAula;
	}

	public double getValorHoraAula() {
		return valorHoraAula;
	}

	public void setValorHoraAula(double valorHoraAula) {
		this.valorHoraAula = valorHoraAula;
	}

	@Override
	public int compareTo(Professores o) {
		return this.getMatricula().compareTo(o.getMatricula());
	}

	
	
}
