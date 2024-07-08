import java.util.Date;

public class PessoaFisica extends Cliente{
    private String cpf;
    private int idade;
    private char sexo;


    public PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo) {
        super(nome, endereco);
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public double calculaTaxas(){
        return 10;
    }

    public void imprimir() {
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
    }

    public String getCpf() {return cpf;}

    public void setIdade(int idade) {this.idade = idade;}
    public int getIdade() {return idade;}

    public void setSexo(char sexo) {this.sexo = sexo;}
    public char getSexo() {return sexo;}

    private boolean validarCpf(String cpf) {
        boolean cpfValido = true;
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;


        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;


        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }

        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;


        if (cpfValido)
            System.out.println("CPF Válido");
        else
            System.out.println("CPF Inválido");

        return cpfValido;
    }

    public static PessoaFisica criarCliente(String nome, String cpf, String endereco, int idade, char sexo){
        PessoaFisica aux = new PessoaFisica(nome, endereco, cpf, idade, sexo);
        //System.out.println(aux.validarCpf(cpf));
        if (aux.validarCpf(cpf)) {
            return aux;
        } else {
            return null;
        }
    }

    public String toString(){
        String pFisicaStr = "Nome: "+ getNome() + '\n' + "Endereço: " + getEndereco() + '\n' + "CPF: " + cpf + '\n' + "Idade: " + idade + '\n' + "Sexo: " + sexo;
        return pFisicaStr;
    }

    public boolean equals(Object obj){
        PessoaFisica pFisicaComparada = (PessoaFisica) obj;
        return pFisicaComparada.getCpf().equals(this.cpf);
    }

    public boolean autenticar(String chave){
        return cpf.equals(chave);
    }
}
