package escola;

public class Alunos extends Pessoa implements Comparable<Alunos>{

	public Alunos(String matricula, String nome, char sexo, int quantideCreditos) {
		super(matricula, nome, sexo, quantideCreditos);
		
	}
	
	
	@Override
	public int compareTo(Alunos o) {
		return this.getMatricula().compareTo(o.getMatricula());
	}
	

}
