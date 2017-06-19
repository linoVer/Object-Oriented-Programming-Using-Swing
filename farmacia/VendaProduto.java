package farmacia;

public class VendaProduto {	
    private Venda venda;
    private Produto produto;
    private double preco;
    private int quantidade;

//    public static String save = "c:\\Salvando VendaProduto\\";

    public VendaProduto(Produto produto, double preco, int quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Funcionario getFuncionario(){
            return this.venda.getFuncionario();
    }

    public Produto getProduto() {
            return produto;
    }
    
    public Venda getVenda() {
            return venda;
    }

    public double getPreco() {
            return preco;
    }

    public int getQuantidade() {
            return quantidade;
    }

    public void setProduto(Produto produto) {
            this.produto = produto;
    }

    public void setVenda(Venda venda) {
            this.venda = venda;
    }

    public void setPreco(double preco) {
            this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
    }

}
