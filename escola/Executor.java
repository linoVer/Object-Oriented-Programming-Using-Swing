package escola;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Executor {
	
	static ArrayList<Alunos> listaAlunos = new ArrayList<>();
	static ArrayList<Professores> listaProfessores = new ArrayList<>();

	public static void main(String[] args) {
		
		Alunos aluno1 = new Alunos("789", "Santos",'M', 2);
		Alunos aluno2 = new Alunos("456", "Rita",'F', 6);
		Alunos aluno3 = new Alunos("123", "Widow",'F', 4);
		
		listaAlunos.add(aluno1);
		listaAlunos.add(aluno2);
		listaAlunos.add(aluno3);
		
	

//		Professores professor1 = new Professores("12", "Carla",'F', 8, 3.4);
//		Professores professor2 = new Professores("34", "Joãoo",'M', 10, 3.4);
//		Professores professor3 = new Professores("11", "Alberto",'M', 4, 3.4);
//
//		listaProfessores.add(professor1);
//		listaProfessores.add(professor2);
//		listaProfessores.add(professor3);
//
//		Collections.sort(listaProfessores);
//		Collections.sort(listaAlunos);
//		
//		String str = new String();
//		
//		for (int i = 0; i < listaAlunos.size(); i++) {
//
//			str += ("Nome:   " + listaAlunos.get(i).getNome() + "   " + "Matrícula: "
//					+ listaAlunos.get(i).getMatricula() + "   " + "Créditos: "
//					+ listaProfessores.get(i).getQuantideCreditos() + "\n\n");
//		}
//		JOptionPane.showMessageDialog(null, str);
//		
//		
//		
//		str = new String();
//
//		for (int i = 0; i < listaProfessores.size(); i++) {
//
//			str += ("Nome:   " + listaProfessores.get(i).getNome() + "   " + "Matrícula: "
//					+ listaProfessores.get(i).getMatricula() + "   " + "Créditos: "
//					+ listaProfessores.get(i).getQuantideCreditos() + "   " + "Salário: "
//					+ listaProfessores.get(i).getValorHoraAula() * listaProfessores.get(i).getQuantideCreditos() + "\n\n");
//		}
//		JOptionPane.showMessageDialog(null, str);
	

	}

}
