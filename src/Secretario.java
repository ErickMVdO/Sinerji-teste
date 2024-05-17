package src;
public class Secretario extends Funcionario {
    public Secretario(String nome, int mesContratacao, int anoContratacao) {
        super(nome, "Secretário", mesContratacao, anoContratacao, 7000.0);
    }

    @Override
    public double calcularSalarioTotal(int mes, int ano) {
        double salario = calcularSalario(mes, ano);
        double beneficio = calcularBeneficios(mes, ano);
        return salario + beneficio;
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosServico = calcularAnosServico(mes, ano, mesContratacao, anoContratacao);
        double bonusAnual = 1000.0 * anosServico;
        return salarioBase + bonusAnual;
    }

    @Override
    public double calcularBeneficios(int mes, int ano) {
        double salario = calcularSalario(mes, ano);
        double beneficio = 0.2 * salario;
        return beneficio;
    }
}