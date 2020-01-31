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
 * estende la classe Quesito in modo da rappresentare domande a cui possa essere
 * risposto solo con un valore intero. Sovrascrivere il metodo ask() in modo da
 * garantire che l’utente risponda con un valore intero (prima che venga
 * restituito il punteggio conseguito).
 *
 */
public class QuesitoNumerico extends Quesito {

    public QuesitoNumerico(String domanda, int[] multipla, int valore) {
        super(Domanda.TipoDomanda.DOM_MULTIPLA, domanda, null, false, multipla, valore);
    }

    @Override
    public int ask() {
        int punteggio = 0;
        int risposta;
        do {
            risposta = AskInt(questione.getQuestion());
        } while (risposta <= 0);
        if (rispostaOk(risposta, questione.getAnswerNum())) {
            punteggio = questione.getValore();
        }
        return punteggio;
    }

    private boolean rispostaOk(int risposta, int[] answerNum) {
        for (int i = 0; i < answerNum.length; i++) {
            if (risposta == answerNum[i]) {
                return true;
            }
        }
        return false;
    }

}
