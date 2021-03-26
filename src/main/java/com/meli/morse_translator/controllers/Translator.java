package com.meli.morse_translator.controllers;

import com.meli.morse_translator.utils.MorseUtil;

import java.util.Hashtable;
import java.util.Set;

public class Translator {
    String morse;
    String result;

    public Translator(String morse) {
        this.morse = morse;
        this.result = this.translate();
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String morseAAscii(String morseActual) {
        Hashtable<String, String> equivalencias = MorseUtil.obtenerEquivalencias();
        Set<String> claves = equivalencias.keySet();
        for (String clave : claves) {
            String morse = equivalencias.get(clave);
            if (morse.equals(morseActual)) {
                return clave;
            }
        }
        return "";

    }

    public String translate() {
        StringBuilder decodificado = new StringBuilder();
        int contadorEspacios = 0;
        String[] morse = this.morse.split(" ");
        for (String morseActual : morse) {
            if(morseActual.equals("")) {
                contadorEspacios++;
                if(contadorEspacios == 2) {
                    decodificado.append(" ");
                    contadorEspacios = 0;
                }
            } else {
                String equivalencia = morseAAscii(morseActual);
                decodificado.append(equivalencia);
            }
        }
        return decodificado.toString();
    }
}
