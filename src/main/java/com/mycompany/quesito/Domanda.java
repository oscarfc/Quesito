/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quesito;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Domanda {

    public enum TipoDomanda {
        DOM_SINO, DOM_MULTIPLA, DOM_ANSWER
    };
    private final String question;
    private String answer;
    private boolean answerSiNo;
    private int[] answerNum;
    private int valore;
    private final TipoDomanda tipo;

    public Domanda(String question, int[] answerNum, int valore, TipoDomanda tipo) {
        this.question = question;
        this.answerNum = answerNum;
        this.valore = valore;
        this.tipo = tipo;
    }

    public Domanda(String question, String answer, int valore, TipoDomanda tipo) {
        this.question = question;
        this.answer = answer;
        this.valore = valore;
        this.tipo = tipo;
    }

    public Domanda(String question, boolean answerSiNo, int valore, TipoDomanda tipo) {
        this.question = question;
        this.answerSiNo = answerSiNo;
        this.valore = valore;
        this.tipo = tipo;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isAnswerSiNo() {
        return answerSiNo;
    }

    public int[] getAnswerNum() {
        return answerNum;
    }

    public int getValore() {
        return valore;
    }

    public TipoDomanda getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.question);
        hash = 71 * hash + this.valore;
        hash = 71 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domanda other = (Domanda) obj;
        if (this.valore != other.valore) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

}
