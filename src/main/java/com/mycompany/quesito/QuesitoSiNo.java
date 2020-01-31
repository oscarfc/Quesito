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
 * risposto solo si o no. Sovrascrivere il metodo ask() in modo da garantire che
 * l’utente risponda si o no (prima che venga restituito il punteggio
 * conseguito).
 *
 */
public class QuesitoSiNo extends Quesito {

    public QuesitoSiNo(String domanda, String answer, boolean sino, int valore) {
        super(Domanda.TipoDomanda.DOM_SINO, domanda, null, sino, null, valore);
    }

    @Override
    public int ask() {
        int punteggio = 0;
        String risposta;
        do {
            risposta = AskString(questione.getQuestion() + "[S / N]");
        } while (!risposta.equalsIgnoreCase("S") && !risposta.equalsIgnoreCase("N"));
        if (risposta.equalsIgnoreCase("S") && questione.isAnswerSiNo()) {
            punteggio = questione.getValore();
        } else if (risposta.equalsIgnoreCase("N") && !questione.isAnswerSiNo()) {
            punteggio = questione.getValore();
        }
        return punteggio;
    }

}
