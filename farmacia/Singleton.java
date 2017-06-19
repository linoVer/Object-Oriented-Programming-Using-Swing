package farmacia;

import java.util.ArrayList;
import java.util.List;

public class Singleton 
{
    private List<Cliente> clientesCadastrados =new ArrayList<>();
    private List<Produto> produtosCadastrados=new ArrayList<>();
    
    private static final Singleton INSTANCE = new Singleton();
    
    
    
    private Singleton() { }
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
    
    public void cadastrarCliente(Cliente cliente) throws Exception {
        this.clientesCadastrados.add(cliente);
    }
    
    public void cadastrarProduto(Produto produto) throws Exception {        
        this.produtosCadastrados.add(produto);
    }
    
    public List<Cliente> getClientesCadastrados() throws Exception {                
        return this.clientesCadastrados;
    }
    
    public List<Produto> getProdutosCadastrados() throws Exception {      
        return this.produtosCadastrados;
    }
}
