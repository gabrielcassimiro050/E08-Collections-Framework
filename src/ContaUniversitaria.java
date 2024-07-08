public class ContaUniversitaria extends Conta{

    ContaUniversitaria(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;
        if (limite > 500)
            limite = 500;
        setLimite(limite);
    }

    public double calculaTaxas() {
        return 0;
    }
}
