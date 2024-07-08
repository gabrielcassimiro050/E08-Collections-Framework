public class PessoaJuridica extends Cliente{
    private String cnpj;
    private int numFuncionarios;
    private String setor;


    public PessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

    public double calculaTaxas(){
        return 20;
    }

    public void imprimir() {
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Setor: " + setor);
        System.out.println("Número de Funcionários: " + numFuncionarios);
    }

    public String getCnpj(){return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getSetor() {return setor;}
    public void setSetor(String setor) {this.setor = setor;}

    public int getNumFuncionarios() {return numFuncionarios;}
    public void setNumFuncionarios(int numFuncionarios) {this.numFuncionarios = numFuncionarios;}

    public static PessoaJuridica criarCliente(String nome, String endereco, String cnpj, int numFuncionarios, String setor){
        PessoaJuridica aux = new PessoaJuridica(nome, endereco, cnpj, numFuncionarios, setor);
        return aux;
    }

    public String toString(){
        String pJuridicaStr = "Nome: "+ getNome() + "Endereço: " + getEndereco() + "CNPJ: " + cnpj + '\n' + "Nº Funcionários: " + numFuncionarios + '\n' + "Setor: " + setor + '\n';
        return pJuridicaStr;
    }

    public boolean equals(Object obj){
        PessoaJuridica pJuridicaComparada = (PessoaJuridica) obj;
        return pJuridicaComparada.getCnpj().equals(this.cnpj);
    }

    public boolean autenticar(String chave){
        return cnpj.equals(chave);
    }
}
