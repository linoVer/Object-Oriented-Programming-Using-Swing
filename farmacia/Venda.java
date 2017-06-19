package farmacia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Venda {
	
	private int codigo;
        private double precoTotal;
	private Cliente cliente;
	private Funcionario funcionario;
	private List<VendaProduto> listaVendaProduto;
	
	public static int cod = 0;
	public static String save = "c:\\Salvando Vendas\\";
	public boolean finalizar = false;

	public Venda(Cliente cliente, Funcionario funcionario) {
            this.codigo = cod;
            this.cliente = cliente;
            this.funcionario = funcionario;
            this.listaVendaProduto = new ArrayList<>();
            cod++;
	}
	
	public int posicaoPorCodigo(int codigo){
		
		int posicao = -1;
		for (int i = 0; i < this.listaVendaProduto.size(); i++) {
			if (codigo == listaVendaProduto.get(i).getProduto().getId()) {
				posicao = i;
			}
		}
		return posicao ;
	}
	
	
	public boolean adicionarProduto(Produto produto){
		if (!this.finalizar) {
			if (produto.getQuantidade() > 0) {
				VendaProduto vProduto = new VendaProduto(produto, produto.getPreco(), 1);
				produto.setQuantidade(produto.getQuantidade() - 1);
				this.listaVendaProduto.add(vProduto);
				return true;
			}
		}
		return finalizar;

	}
	
	public boolean removerProduto(int prodId){
		if (!this.finalizar) {
			int posicao = this.posicaoPorCodigo(prodId);
			if (posicao > -1) {
				this.listaVendaProduto.remove(posicao);
				return true;
			}
		}
		return finalizar;		
	}
	
	public boolean removerProduto(Produto produto){	
		if (!this.finalizar) {
			for (int i = 0; i < this.listaVendaProduto.size(); i++) {
				if (listaVendaProduto.get(i).getProduto().equals(produto)) {
					this.listaVendaProduto.remove(i);
					return true;
				}
			}
		}
		return finalizar;		
	}
	
	public boolean finalizarVenda(){
		finalizar = true;				
		return finalizar;
        }
        
	public void salvarVenda() throws IOException{
            		
	}
	
	public void obterVendas() throws IOException{

		
	}
	
	public void obterProdutosDestaques(){
		double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        String str = "";

        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(vendaProduto.getProduto().getPreco() > maior)
            {
                maior = vendaProduto.getProduto().getPreco();                    
            }
        }

        str = "Produto mais caro\n" ;
        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(maior == vendaProduto.getProduto().getPreco())
            {
                str += vendaProduto.getProduto().getNome() + ": R$ " + vendaProduto.getProduto().getPreco() + "\n";
            }
        }

        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(vendaProduto.getProduto().getPreco() < menor)
            {
                menor = vendaProduto.getProduto().getPreco();
            }
        }

        str += "\nProduto mais barato\n" ;            
        
        for(VendaProduto vendaProduto : listaVendaProduto)
        {
            if(menor == vendaProduto.getProduto().getPreco())
            {
                str += vendaProduto.getProduto().getNome() + ": R$ " + vendaProduto.getProduto().getPreco() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, str, "Produtos Destaques", JOptionPane.INFORMATION_MESSAGE);
	}



	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<VendaProduto> getListaVendaProduto() {
		return listaVendaProduto;
	}

	
	
	

}
