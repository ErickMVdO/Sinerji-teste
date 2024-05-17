package src;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void registrarVenda(String nome, String mesAno, double valor) {
        for (Funcionario f : funcionarios) {
            if (f instanceof Vendedor && f.nome.equals(nome)) {
                ((Vendedor) f).registrarVenda(mesAno, valor);
            }
        }
    }

    public List<Funcionario> obterFuncionariosComBeneficios() {
        return funcionarios.stream()
                .filter(f -> f instanceof Secretario || f instanceof Vendedor)
                .collect(Collectors.toList());
    }

    public List<Funcionario> obterVendedores() {
        return funcionarios.stream()
                .filter(f -> f instanceof Vendedor)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empresa empresa = new Empresa();
        Calculos calculos = new Calculos();

        empresa.adicionarFuncionario(new Secretario("Jorge Carvalho", 01, 2018));
        empresa.adicionarFuncionario(new Secretario("Maria Souza", 12, 2015));
        empresa.adicionarFuncionario(new Vendedor("Ana Silva", 12, 2021));
        empresa.adicionarFuncionario(new Vendedor("João Mendes", 12, 2021));
        empresa.adicionarFuncionario(new Gerente("Juliana Alves", 07, 2017));
        empresa.adicionarFuncionario(new Gerente("Bento Albino", 03, 2014));

        empresa.registrarVenda("Ana Silva", "12/2021", 5200);
        empresa.registrarVenda("Ana Silva", "01/2022", 4000);
        empresa.registrarVenda("Ana Silva", "02/2022", 4200);
        empresa.registrarVenda("Ana Silva", "03/2022", 5850);
        empresa.registrarVenda("Ana Silva", "04/2022", 7000);

        empresa.registrarVenda("João Mendes", "12/2021", 3400);
        empresa.registrarVenda("João Mendes", "01/2022", 7700);
        empresa.registrarVenda("João Mendes", "02/2022", 5000);
        empresa.registrarVenda("João Mendes", "03/2022", 5900);
        empresa.registrarVenda("João Mendes", "04/2022", 6500);

        int mes = 0;
        int ano = 2022;

        while (mes == 0) {
            System.out.println("Escolha um dos seguintes meses para calcular os pagamentos:");
            System.out.println("1 - 12/2021");
            System.out.println("2 - 01/2022");
            System.out.println("3 - 02/2022");
            System.out.println("4 - 03/2022");
            System.out.println("5 - 04/2022");
            System.out.print("Digite o número do mês: ");
            int opcao = sc.nextInt();

            System.out.println("");

            switch(opcao){
                case 1:
                    mes = 12;
                    ano = 2021;
                    break;
                case 2:
                    mes = 1;
                    break;
                case 3:
                    mes = 2;
                    break;
                case 4:
                    mes = 3;
                    break;
                case 5:
                    mes = 4;
                    break;
                default:
                    System.out.println("Opção inválida\n");
                    break;
            }
        }

        System.out.println("Pagamentos realizados em " + mes + "/" + ano + ":");
        List<Funcionario> funcionarios = empresa.funcionarios;
        double totalPago = calculos.calcularPagamentoTotal(funcionarios, mes, ano);
        System.out.printf("Total pago: R$%.2f%n", totalPago);

        double totalPagoSalarios = calculos.calcularPagamentoSalarios(funcionarios, mes, ano);
        System.out.printf("Total pago somente em salários: R$%.2f%n", totalPagoSalarios);
        
        List<Funcionario> funcionariosComBeneficios = empresa.obterFuncionariosComBeneficios();
        double totalPagoBeneficios = calculos.calcularPagamentoBeneficios(funcionariosComBeneficios, mes, ano);
        System.out.printf("Total pago em benefícios: R$%.2f%n", totalPagoBeneficios);

        String nomeMaiorSalario = calculos.calcularMaiorSalario(funcionarios, mes, ano);
        System.out.printf("Funcionário com maior salário: %s%n", nomeMaiorSalario);
        
        String nomeMaiorBeneficio = calculos.calcularMaiorBeneficio(funcionariosComBeneficios, mes, ano);
        System.out.printf("Funcionário com maior benefício: %s%n", nomeMaiorBeneficio);

        List<Funcionario> vendedores = empresa.obterVendedores();
        String nomeMaiorVendas = calculos.calcularMaiorVendas(vendedores, mes, ano);
        System.out.printf("Vendedor com maior vendas: %s%n\n", nomeMaiorVendas);

        sc.close();
    }
}