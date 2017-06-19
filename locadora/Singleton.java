package locadora;

import java.util.ArrayList;
import java.util.List;

public class Singleton 
{
    private List<Midia> tiposDeMidia =new ArrayList<>();
    private List<Itens> itens =new ArrayList<>();
    
    private static final Singleton INSTANCE = new Singleton();
    
    
    private Singleton() { }
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
    
    public void cadastrarTipoMidia(Midia midia) throws Exception {
    	this.tiposDeMidia.add(midia);
    }

	public List<Midia> getTiposDeMidia() {
		return tiposDeMidia;
	}
    
	
	public void cadastrarItens(Itens item) throws Exception{
		this.itens.add(item);
	}
	
	public List<Itens> getItens(){
		return itens;
	}
	
public String toString() {
		
		int aux = this.getTiposDeMidia().size()-1;
		
		if (this.getTiposDeMidia().size() == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < aux; i++) {
			builder.append(this.getTiposDeMidia().get(i));
			builder.append(", ");
		}

		builder.append(this.getTiposDeMidia().get(aux));
		builder.append("]");

		return builder.toString();
	}
  
}
