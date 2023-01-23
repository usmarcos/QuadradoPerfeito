import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //matriz teste (é um quadrado perfeito)
//        int[][] matriz = { {20, 6, 7, 17},
//                {9, 15, 14, 12},
//                {13, 11, 10, 16},
//                {8, 18, 19, 5} };
        int [][] matriz = montarEPreencherQuadrado();

        metodoUm(matriz);
        metodoDois(matriz);

    }

    public static int[][] montarEPreencherQuadrado() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o tamanho do quadrado desejado:");
        int tamanho = scanner.nextInt();
        int[][] matriz = new int[tamanho][tamanho];
        for (int linha = 0; linha < matriz.length; linha++) {
            int[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                int valorAleatorio = random.nextInt(1000);
                colunas[coluna] = valorAleatorio;
                System.out.print("[" + valorAleatorio + "]");
            }
            System.out.println();
        }
        return matriz;
    }

    private static void metodoUm(int[][] matriz) {
        int soma = 0;
        boolean isPerfeito = true;

        //calcula a soma da primeira linha para comparar com as outras
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[0][i];
        }

        //compara a soma das linhas
        for (int i = 0; i < matriz.length; i++) {
            int linhaSoma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                linhaSoma += matriz[i][j];
            }
            if (linhaSoma != soma) {
                isPerfeito = false;
                break;
            }
        }

        //compara a soma das colunas
        if (isPerfeito) {
            for (int i = 0; i < matriz.length; i++) {
                int colunaSoma = 0;
                for (int j = 0; j < matriz[i].length; j++) {
                    colunaSoma += matriz[j][i];
                }
                if (colunaSoma != soma) {
                    isPerfeito = false;
                    break;
                }
            }
        }

        //compara a soma das diagonais
        if (isPerfeito) {
            int diagonalPrincipal = 0;
            int diagonalSecundaria = 0;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i == j) {
                        diagonalPrincipal += matriz[i][j];
                    }
                    if (i + j == matriz.length - 1) {
                        diagonalSecundaria += matriz[i][j];
                    }
                }
            }
            if (diagonalPrincipal != soma || diagonalSecundaria != soma) {
                isPerfeito = false;
            }
        }

        if (isPerfeito) {
            System.out.println("O quadrado é perfeito!");
        } else {
            System.out.println("O quadrado não é perfeito.");
        }
    }

    private static void metodoDois(int[][] matriz) {
        // verifica linhas
        int totalLinha = 0;
        int totalColuna = 0;
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;
        int controleDiagonalPrincipal = 0;
        int controleDiagonalSecundaria = matriz.length - 1;


        for (int i = 0; i < matriz.length; i++) {
            //linha e coluna, invertendo i e j para mudar as posições de leitura
            for (int j = 0; j < matriz.length; j++) {
                totalLinha += matriz[j][i];
                totalColuna += matriz[i][j];
                somaDiagonalPrincipal += matriz[controleDiagonalPrincipal][i];
                somaDiagonalSecundaria += matriz[i][controleDiagonalSecundaria];
            }
        }

        //verificando se é um quadrado perfeito
        if (totalLinha == totalColuna && somaDiagonalPrincipal == somaDiagonalSecundaria){
            System.out.println("Quadrado perfeito");
        }else{
            System.out.println("Não é um quadrado perfeito");
        }
    }

}