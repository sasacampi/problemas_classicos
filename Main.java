import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===========XXX=============");
            System.out.println("         MENU DE OPÇÕES       ");
            System.out.println("=============XXX=============");
            System.out.println("1 - Calcular Troco (Guloso)");
            System.out.println("2 - Mochila Fracionaria");
            System.out.println("3 - Ordenar Array (Quick Sort)");
            System.out.println("0 - Sair");
            System.out.println("============XXX=============");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da compra: ");
                    double valorCompra = sc.nextDouble();
                    System.out.print("Digite o valor pago: ");
                    double valorPago = sc.nextDouble();
                    Algoritmos.calcularTroco(valorCompra, valorPago);
                    break;

                case 2:
                    System.out.print("Digite o peso máximo da mochila: ");
                    double capacidade = sc.nextDouble();

                    System.out.print("Digite a quantidade de itens: ");
                    int qtdItens = sc.nextInt();

                    double[] valores = new double[qtdItens];
                    double[] pesos = new double[qtdItens];

                    for (int i = 0; i < qtdItens; i++) {
                        System.out.print("Valor do item " + (i + 1) + ": ");
                        valores[i] = sc.nextDouble();
                        System.out.print("Peso do item " + (i + 1) + ": ");
                        pesos[i] = sc.nextDouble();
                    }

                    Algoritmos.mochilaFracionaria(capacidade, valores, pesos);
                    break;

                case 3:
                    System.out.print("Digite a quantidade de números: ");
                    int qtd = sc.nextInt();
                    int[] numeros = new int[qtd];

                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Numero " + (i + 1) + ": ");
                        numeros[i] = sc.nextInt();
                    }

                    Algoritmos.ordenarArray(numeros);
                    break;

                case 0:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
