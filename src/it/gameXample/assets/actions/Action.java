package it.gameXample.assets.actions;

public class Action {

    protected String question;

    protected Option[] options;

    public Action(String question, Option[] options) {
        this.question = question;
        this.options = options;
    }

    public String getAnswer(int choice){
        for (Option o : options) {
            if (o.getValue() == choice){
                return o.getAnswer();
            }
        }
        return String.format("Il comando [%s] non  è valido", choice);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(question + "\n");
        for (Option o : options) {
            result.append(o.toString()).append("\n");
        }
        result.append("Risposta: ");
        return result.toString();
    }
}
