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
        for (Map.Entry<Integer, Option> e : options.entrySet()) {
            String strOption = String.format("[%s] - %s", e.getKey(), e.getValue().toString() );
            result.append(strOption).append("\n");
        }
        result.append("Risposta: ");
        return result.toString();
    }
}
