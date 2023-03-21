## Progressão Aritmética (PA)
Uma Progressão Aritmética (PA) é uma sequência de números em que cada termo é igual à soma do termo anterior com uma constante fixa chamada de razão (r).

O tempo de execução de um algoritmo que calcula uma PA depende do número de termos na sequência. O número de operações necessárias para calcular n termos de uma PA é proporcional a n, o que significa que o tempo de execução é O(n).

No entanto, se você quiser calcular a soma dos n primeiros termos de uma PA, precisará somar todos os termos individualmente, o que requer O(n) operações. Como a soma de uma PA é uma série aritmética, existe uma fórmula para calcular a soma diretamente, o que leva apenas O(1) operações. Mas se você calcular a soma por meio da soma individual dos termos, o tempo de execução será O(n).

Portanto, se você calcular a soma dos n primeiros termos de uma PA usando a soma individual de termos, o tempo de execução será proporcional a n^2, ou seja, O(n^2). No entanto, se você usar a fórmula direta para calcular a soma, o tempo de execução será O(1).