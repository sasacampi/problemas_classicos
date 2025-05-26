import java.util.Arrays;

public class Algoritmos {

    public static void calcularTroco(double valorCompra, double valorPago) {
        double troco = valorPago - valorCompra;
        if (troco < 0) {
            System.out.println("Valor pago não é suficiente");
            return;
        }

        System.out.println("Troco: R$ " + troco);
        double[] moedas = {1.0, 0.5, 0.25, 0.10, 0.05, 0.01};

        for (double moeda : moedas) {
            int quantidade = (int) (troco / moeda);
            if (quantidade > 0) {
                System.out.println(quantidade + " moeda(s) de R$ " + moeda);
                troco = troco - quantidade * moeda;
                troco = Math.round(troco * 100.0) / 100.0; 
            }
        }
    }

    public static void mochilaFracionaria(double capacidade, double[] valores, double[] pesos) {
        int n = valores.length;
        double[] valorPorPeso = new double[n];

        for (int i = 0; i < n; i++) {
            valorPorPeso[i] = valores[i] / pesos[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (valorPorPeso[j] > valorPorPeso[i]) {
                    double temp = valorPorPeso[i];
                    valorPorPeso[i] = valorPorPeso[j];
                    valorPorPeso[j] = temp;

                    double tempVal = valores[i];
                    valores[i] = valores[j];
                    valores[j] = tempVal;

                    double tempPes = pesos[i];
                    pesos[i] = pesos[j];
                    pesos[j] = tempPes;
                }
            }
        }

        double valorTotal = 0;
        System.out.println("Itens selecionados:");

        for (int i = 0; i < n; i++) {
            if (capacidade >= pesos[i]) {
                capacidade -= pesos[i];
                valorTotal += valores[i];
                System.out.println("- 100% do item " + (i + 1) + " (valor: " + valores[i] + ")");
            } else {
                double frac = capacidade / pesos[i];
                valorTotal += valores[i] * frac;
                System.out.printf("- %.1f%% do item %d (valor: %.1f)%n", frac * 100, (i + 1), valores[i] * frac);
                capacidade = 0;
                break;
            }
        }

        System.out.println("O valor total na mochila é: " + valorTotal);
    }

    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(array, inicio, fim);
            quickSort(array, inicio, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] array, int inicio, int fim) {
        int pivo = array[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (array[i] <= pivo) {
                i++;
            } else if (pivo < array[f]) {
                f--;
            } else {
                int troca = array[i];
                array[i] = array[f];
                array[f] = troca;
                i++;
                f--;
            }
        }
        array[inicio] = array[f];
        array[f] = pivo;
        return f;
    }

    public static void ordenarArray(int[] numeros) {
        quickSort(numeros, 0, numeros.length - 1);
        System.out.println("O Array ordenado é: " + Arrays.toString(numeros));
    }
}
