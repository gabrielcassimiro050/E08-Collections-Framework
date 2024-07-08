public class OperacaoSaque extends Operacao implements ITaxas{
    public OperacaoSaque(double valor){
        this.setValor(valor);
        this.setTipo('s');
    }

    public double calculaTaxas(){
        return .05;
    }

    public String toString(){
        String opSaqueStr = '\n'+"Valor:" + getValor() + '\n' + "Tipo: Saque" + '\n' + "Data: " + getData() + '\n';
        return opSaqueStr;
    }
}
