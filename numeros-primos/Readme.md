# Numeros Primos
Esta classe contém métodos para encontrar números primos utilizando diferentes algoritmos. Abaixo está a explicação de cada algoritmo e sua complexidade.

### Crivo de Eratóstenes
O algoritmo Crivo de Eratóstenes é utilizado para encontrar todos os números primos menores que um número dado. A ideia básica é a seguinte: todos os números menores que o dado são inicialmente marcados como primos. Depois, o algoritmo percorre cada número e marca como composto todos os múltiplos desse número. Ao final, os números que permanecerem marcados como primos são, de fato, primos.

A complexidade desse algoritmo é O(n log log n), onde n é o número limite.

### Divisões sucessivas
Esse algoritmo percorre todos os números até o limite desejado e testa se cada um é primo. O teste consiste em verificar se o número é divisível por algum número menor que ele (exceto 1). Se o número for divisível, ele é composto; caso contrário, ele é primo.

A complexidade desse algoritmo é O(n²), onde n é o número limite.

### AKS
O algoritmo AKS é utilizado para determinar se um número é primo. A ideia básica é que, se n é primo, então (x + a)^n ≡ x^n + a (mod n) para todo x e a inteiros. Essa igualdade pode ser verificada em tempo polinomial usando o Teorema do Binômio. O algoritmo tem complexidade O(log²(n)).

### Miller-Rabin
O algoritmo de Miller-Rabin é utilizado para determinar se um número é primo com alta probabilidade. Ele é baseado no Pequeno Teorema de Fermat, que afirma que, se p é primo e a é um número inteiro, então a^(p-1) ≡ 1 (mod p). O algoritmo escolhe aleatoriamente um número a e testa se essa igualdade é satisfeita para um número ímpar de valores diferentes de a. Se o número passa nesses testes, ele é considerado primo com alta probabilidade.

A complexidade desse algoritmo é O(k log³ n), onde k é o número de testes a serem realizados e n é o número a ser testado. Quanto maior k, maior a precisão do teste.