import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta implements ITaxas{

    private int numero;

    private Cliente dono;

    private double saldo;

    private double limite;

    private ArrayList<Operacao> operacoes;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new ArrayList<Operacao>();

        Conta.totalContas++;
    }
    public Conta(){}

    /*private void dobrarOperacao(){
        //Cria um vetor temporário com o valor requerido para armazenar as informações
        Operacao[] aux = new Operacao[this.operacoes.size()*2];
        for(int i = 0; i < this.operacoes.size(); ++i) {
            //Armazena as informações atuais nesse vetor
            aux[i] = this.operacoes[i];
        }
        //Iguala o vetor original ao vetor temporário
        this.operacoes = aux;
    }*/

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            operacoes.add(new OperacaoSaque(valor));

            /*this.saldo -= valor;

            this.operacoes.get(proximaOperacao) = new OperacaoSaque(valor);
            this.proximaOperacao++;
            if(this.proximaOperacao==this.operacoes.length){
                //System.out.println(this.operacoes.length);
                dobrarOperacao();
                //System.out.println(this.operacoes.length);
            }*/
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        operacoes.add(new OperacaoDeposito(valor));
        /*this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
        if(this.proximaOperacao==this.operacoes.length){
            //System.out.println(this.operacoes.length);
            dobrarOperacao();
            //System.out.println(this.operacoes.length);
        }*/
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void imprimir() {
        System.out.println("===== Conta " + this.numero + " =====");
        System.out.println("Dono: " + this.dono);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("====================");
    }

    public void imprimirExtrato(int ordernar) {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        ArrayList<Operacao> aux = (ArrayList<Operacao>) operacoes.clone();
        if(ordernar==1) Collections.sort(aux);
        for (Operacao op : aux) {
            if (op != null) {
                System.out.println(op.toString());
            }
        }
        System.out.println("====================");
    }


    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public ArrayList getOperacoes() {
        return operacoes;
    }

    public abstract void setLimite(double limite);

    public String toString(){
        String contaStr = "Nº" + numero + '\n' + dono.toString() + "Saldo: " + saldo + '\n' + "Limite: " + limite + '\n';
        for(int i = 0; i < operacoes.size(); ++i){
            if(operacoes.get(i)!=null) contaStr = contaStr.concat(operacoes.get(i).toString());
        }
        return contaStr;
    }

    public boolean equals(Object obj){
        Conta contaComparada = (Conta) obj;
        return contaComparada.getNumero() == this.numero;
    }

    public void imprimirExtratoTaxas() {
        double t = calculaTaxas();
        System.out.println("============Extrato de Taxas============");
        System.out.println("Taxa de Manunteção: " + calculaTaxas());

        for (int i = 0; i < operacoes.size(); ++i) {
            if (operacoes.get(i) != null && operacoes.get(i).getTipo() == 's') {
                System.out.println("Saque: R$" + operacoes.get(i).calculaTaxas());
                t += operacoes.get(i).calculaTaxas();
            }
        }

        System.out.println();
        System.out.printf("Taxa de Saque Total: R$ %.2f", t);
    }
}
