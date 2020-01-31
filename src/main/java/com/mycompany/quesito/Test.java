/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quesito;

/**
 *
 * @author tss
 */
/**
 * riempie un array con quesiti di diversa natura e poi simula un’interrogazione
 * calcolando il punteggio totale ottenuto. A scelta, l’interrogazione puo'
 * essere fatta estraendo in modo casuale tre quesiti dall’array.
 *
 */
public class Test {

    Quesito[] questionario;
    private int index;

    public static void main(String[] args) {
        int numeroDomande = 3;
        Test test = new Test(numeroDomande);
        test.loadDomande(numeroDomande);
        int punteggio = test.eseguiTest(3);
        System.out.println("Hai ottenuto punti: " + punteggio);
    }

    private Test(int numeroDomande) {
        this.questionario = new Quesito[numeroDomande];
        this.index = 0;
    }

    private void loadDomande(int numeroDomande) {
        add(new Quesito("domanda " + 1, "answer " + 1, false, 1));
        int[] ansMult = {1, 2, 3, 4};
        add(new QuesitoNumerico("domanda\n d1\n d2\n d3\n d4", ansMult, 1));
        add(new QuesitoSiNo("domanda " + 3, "answer " + 3, false, 1));

    }

    private void add(Quesito quesito) {
        if (index == questionario.length) {
            throw new ExceptionInInitializerError("Hai superato il numero previsto di domande");
        } else {
            questionario[index++] = quesito;
        }
    }

    private int eseguiTest(int i) {
        int ret = 0;
        for (int j = 0; j < i; j++) {
            ret += questionario[j].ask();
        }
        return ret;
    }

}
