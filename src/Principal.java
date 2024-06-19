import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        double valor = 0;
        System.out.println("*=====================================================*");
        System.out.println("Boas-vindas ao Conversor de Moedas");
        System.out.println("Escolha uma opção de conversão: ");
        System.out.println("1) Real Brasileiro (BRL) -> Dólar americano (USD)");
        System.out.println("2) Peso Chileno (CLP) -> Real Brasileiro (BRL)");
        System.out.println("3) Peso Argentino (ARS) -> Real Brasileiro (BRL)");
        System.out.println("4) Boliviano boliviano (BOB) -> Real Brasileiro (BRL)");
        System.out.println("5) Peso Colombiano (COP) -> Real Brasileiro (BRL)");
        System.out.println("6) Dólar americano (USD) -> Peso Argentino (ARS)");
        System.out.println("7) Sair.");
        System.out.println("*=====================================================*");

        int escolha = input.nextInt();

        if (escolha == 7){
            System.out.println("Programa encerrado.");
        }
        else {
            System.out.println("Qual o valor que deseja converter?");
            valor = input.nextDouble();
        }

        if (escolha == 1) {
            Servico.chamarValor("BRL", "USD", valor);
        }
        else if (escolha == 2 ) {
            Servico.chamarValor("CLP", "BRL", valor);
        }
        else if (escolha == 3 ) {
            Servico.chamarValor("ARS", "BRL", valor);
        }
        else if (escolha == 4 ) {
            Servico.chamarValor("BOB", "BRL", valor);
        }
        else if (escolha == 5 ) {
            Servico.chamarValor("COP", "BRL", valor);
        }
        else if (escolha == 6 ) {
            Servico.chamarValor("USD", "ARS", valor);
        }
        else {
            System.out.println("Sistema encerrado.");
        }
    }
}