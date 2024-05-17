package src;
import java.util.HashMap;
import java.util.Map;

public class Vendedor extends Funcionario {
    private Map<String, Double> vendas;

    public Vendedor(String nome, int mesContratacao, int anoContratacao) {
        super(nome, "Vendedor", mesContratacao, anoContratacao, 12000.0);
        this.vendas = new HashMap<>();
    }

    public void registrarVenda(String mesAno, double valor) {
        vendas.put(mesAno, valor);
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
        double bonusAnual = 1800.0 * anosServico;
        return salarioBase + bonusAnual;
    }

    @Override
    public double calcularBeneficios(int mes, int ano) {
        String mesAno = String.format("%02d/%04d", mes, ano);
        double valorVendido = vendas.getOrDefault(mesAno, 0.0);
        double comissao = 0.3 * valorVendido;
        return comissao;
    }
}