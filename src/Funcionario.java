package src;
public abstract class Funcionario {
    protected String nome;
    protected String cargo;
    protected int mesContratacao;
    protected int anoContratacao;
    protected double salarioBase;

    Funcionario(String nome, String cargo, int mesContratacao, int anoContratacao, double salarioBase) {
        this.nome = nome;
        this.cargo = cargo;
        this.mesContratacao = mesContratacao;
        this.anoContratacao = anoContratacao;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalarioTotal(int mes, int ano);
    public abstract double calcularSalario(int mes, int ano);
    public abstract double calcularBeneficios(int mes, int ano);

    public int calcularAnosServico(int mes, int ano, int mesContratacao, int anoContratacao) {
        int anos = 0;
        if (mes < mesContratacao) {
            anos = ano - anoContratacao - 1;
        } else {
            anos = ano - anoContratacao;
        }

        return anos;
    }

    public String getNome() {
        return nome;
    }
}