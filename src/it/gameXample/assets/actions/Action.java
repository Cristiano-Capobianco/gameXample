package it.gameXample.assets.actions;

import java.util.HashMap;
import java.util.Map;

public class Action {

    protected String question;

    protected HashMap<Integer, Option> options;

    public Action(String question, HashMap<Integer, Option> options) {
        this.question = question;
        this.options = options;
    }

    public String getAnswer(int choice) throws Exception {
        Option o = options.get(choice);
        if (o == null) {
            throw new Exception (String.format("Il comando [%s] non  è valido", choice));
        }
        return o.getAnswer();
    }

    public String toString() {
        StringBuilder result = new StringBuilder(question + "\n");
        /*for (Map.Entry<Integer, Option> e : options.entrySet()) {                                   //Iteriamo sul set di Entry<chiave, valore> dell'hashMap delle opzioni
            String strOption = String.format("[%s] - %s", e.getKey(), e.getValue().toString() );
            result.append(strOption).append("\n");
        }*/
        options.forEach((key, value) -> {                                               // per ogni coppia chiave-azione
            String strOption = String.format("[%s] - %s", key, value.toString() );      // creo la stringa dell'opzione
            result.append(strOption).append("\n");                                      // la concateno al mio
        });
        result.append("Risposta: ");
        return result.toString();
    }
}
