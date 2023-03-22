O algoritmo de Zeller, também conhecido como Algoritmo Congruencial de Zeller, é um algoritmo matemático que permite calcular o dia da semana correspondente a uma determinada data. Ele foi criado pelo matemático alemão Christian Zeller em 1887, com base em trabalhos anteriores de John Horton Conway e Jean Baptiste Joseph Fourier.

O algoritmo de Zeller utiliza uma fórmula que leva em consideração o dia, o mês e o ano da data em questão. A fórmula é a seguinte:

```
f = k + [(13*m-1)/5] + D + [D/4] + [C/4] - 2*C
dia_semana = f mod 7

onde:
k é o dia do mês;
m é o número do mês (janeiro = 1, fevereiro = 2, etc.);
D é o último dígito do ano (por exemplo, para o ano de 2023, D seria 3);
C é o século (ou seja, os dois primeiros dígitos do ano, desconsiderando o último dígito).
```

O resultado da fórmula, f, é então dividido por 7 e o resto da divisão é o número correspondente ao dia da semana (0 = sábado, 1 = domingo, 2 = segunda-feira, etc.).

O algoritmo de Zeller é utilizado em diversos sistemas e programas que precisam calcular o dia da semana a partir de uma data, como calendários, agendas eletrônicas, sistemas de reservas, entre outros. Ele é considerado uma forma simples e eficiente de realizar esse cálculo.