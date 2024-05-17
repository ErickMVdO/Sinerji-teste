package src;
public class Gerente extends Funcionario {
    public Gerente(String nome, int mesContratacao, int anoContratacao) {
        super(nome, "Gerente", mesContratacao, anoContratacao, 20000.0);
    }

    @Override
    public double calcularSalarioTotal(int mes, int ano) {
        return calcularSalario(mes, ano);
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosServico = calcularAnosServico(mes, ano, mesContratacao, anoContratacao);
        double bonusAnual = 3000.0 * anosServico;
        return salarioBase + bonusAnual;
    }

    @Override
    public double calcularBeneficios(int mes, int ano) {
        return 0;
    }
}