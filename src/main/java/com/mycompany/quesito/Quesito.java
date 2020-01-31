/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quesito;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Quesito {

    protected Domanda questione;

    public Quesito(String domanda, String answer, boolean sino, int valore) {

        this(Domanda.TipoDomanda.DOM_ANSWER, domanda, answer, false, null, valore);
    }

    public Quesito(Domanda.TipoDomanda tipo, String domanda, String answer, boolean sino, int[] multipla, int valore) {
        switch (tipo) {
            case DOM_ANSWER:
                this.questione = new Domanda(domanda, answer, valore, Domanda.TipoDomanda.DOM_ANSWER);
                break;
            case DOM_SINO:
                this.questione = new Domanda(domanda, sino, valore, Domanda.TipoDomanda.DOM_SINO);
                break;
            case DOM_MULTIPLA:
                this.questione = new Domanda(domanda, multipla, valore, Domanda.TipoDomanda.DOM_MULTIPLA);
                break;
            default:
                this.questione = null;
                break;
        }
    }

    /**
     * stampa la domanda, legge la risposta dell’utente e restituisce il
     * punteggio conseguito (0 se la risposta dell’utente e' sbagliata).
     *
     * @param domanda
     * @return punteggio conseguito
     */
    public int ask() {
        int punteggio = 0;
        String risposta = AskString(questione.getQuestion());
        if (risposta.equalsIgnoreCase(questione.getAnswer())) {
            punteggio = questione.getValore();
        }
        return punteggio;
    }

    public int AskInt(String testo) {
        int ret = 0;
        String strInt;
        boolean controllo = true;
        Scanner keyb = new Scanner(System.in);
        System.out.println(testo + " ? ");
        do {
            strInt = keyb.nextLine();
            if (checkIfInteger(strInt)) {
                controllo = false;
                ret = Integer.parseInt(strInt);
            }
        } while (controllo);
        return ret;
    }

    public String AskString(String testo) {
        String ret;
        Scanner keyb = new Scanner(System.in);
        System.out.println(testo + " ? ");
        ret = keyb.nextLine();
        return ret;
    }

    private boolean checkIfInteger(String strInt) {
        for (int i = 0; i < strInt.length(); i++) {
            if (strInt.charAt(i) < '0' || strInt.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

}
