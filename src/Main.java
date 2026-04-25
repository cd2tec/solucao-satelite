package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Processador de Dados ===");
        System.out.println("[1] Bubble Sort");
        System.out.println("[2] Fatorial");
        System.out.println("[3] Busca Binaria");
        System.out.println("[4] Insertion Sort");
        System.out.println("[5] Selection Sort");
        System.out.println("[6] Fibonacci");
        System.out.println("[7] Numero Primo");
        System.out.println("[8] Contar Bits");
        System.out.println("[9] Cifra Caesar");
        System.out.println("[10] Pilha Demo");
        System.out.println("[11] Fila Demo");
        System.out.print("Escolha: ");

        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        int[] vetor = {42, 17, 83, 5, 61, 29, 74, 3, 56, 38};

        switch (opcao) {
            case 1:
                Sort.bubbleSort(vetor);
                printArray(vetor);
                break;
            case 2:
                System.out.println("10! = " + Math2.factorial(10));
                break;
            case 3:
                Sort.bubbleSort(vetor);
                int idx = Sort.binarySearch(vetor, 56);
                System.out.println("Indice de 56: " + idx);
                break;
            case 4:
                Sort.insertionSort(vetor);
                printArray(vetor);
                break;
            case 5:
                Sort.selectionSort(vetor);
                printArray(vetor);
                break;
            case 6:
                System.out.println("fib(10) = " + Math2.fibonacci(10));
                break;
            case 7:
                System.out.println("17 eh primo? " + Math2.isPrime(17));
                break;
            case 8:
                System.out.println("Bits em 0b10110111: " + Bits.countBits(0b10110111));
                break;
            case 9:
                String enc = Crypto.caesarEncrypt("HelloWorld", 13);
                System.out.println("Cifrado: " + enc);
                System.out.println("Decifrado: " + Crypto.caesarDecrypt(enc, 13));
                break;
            case 10:
                Stack stack = new Stack(64);
                stack.push(10); stack.push(20); stack.push(30);
                System.out.println("Pop: " + stack.pop());
                break;
            case 11:
                Queue queue = new Queue(32);
                queue.enqueue(100); queue.enqueue(200); queue.enqueue(300);
                System.out.println("Dequeue: " + queue.dequeue());
                break;
            default:
                System.out.println("Opcao invalida");
        }

        sc.close();
    }

    private static void printArray(int[] arr) {
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}
