public class OperacaoDeposito extends Operacao implements ITaxas{
    public OperacaoDeposito(double valor){
        this.setValor(valor);
        this.setTipo('d');
    }

    public double calculaTaxas(){
        return 0;
    }

    public String toString() {
        String opSaqueStr = "Valor:" + getValor() + '\n' + "Tipo: Depósito" + '\n' + "Data: " + getData() + '\n';
        return opSaqueStr;
    }
}
