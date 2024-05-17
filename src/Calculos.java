package src;
import java.util.List;

public class Calculos {
    
    public double calcularPagamentoTotal(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalarioTotal(mes, ano);
        }
        return total;
    }

    public double calcularPagamentoSalarios(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario(mes, ano);
        }
        return total;
    }

    public double calcularPagamentoBeneficios(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario f : funcionarios) {
            total += f.calcularBeneficios(mes, ano);
        }
        return total;
    }

    public String calcularMaiorSalario(List<Funcionario> funcionarios, int mes, int ano) {
        double maiorSalario = 0.0;
        String nome = "";
        for (Funcionario f : funcionarios) {
            double salario = f.calcularSalarioTotal(mes, ano);
            if (salario > maiorSalario) {
                maiorSalario = salario;
                nome = f.getNome();
            }
        }
        return nome;
    }

    public String calcularMaiorBeneficio(List<Funcionario> funcionarios, int mes, int ano){
        double maiorBeneficio = 0.0;
        String nome = "";
        for (Funcionario f : funcionarios) {
            double beneficio = f.calcularBeneficios(mes, ano);
            if (beneficio > maiorBeneficio) {
                maiorBeneficio = beneficio;
                nome = f.getNome();
            }
        }
        return nome;
    }

    public String calcularMaiorVendas(List<Funcionario> funcionarios, int mes, int ano){
        double maiorVendas = 0.0;
        String nome = "";
        for (Funcionario f : funcionarios) {
            double vendas = f.calcularBeneficios(mes, ano);
            if (vendas > maiorVendas) {
                maiorVendas = vendas;
                nome = f.getNome();
            }
        }
        return nome;
    }
}