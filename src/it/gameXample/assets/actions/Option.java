package it.gameXample.assets.actions;

public class Option {

    protected int value;

    protected String text;

    protected String answer;

    public Option(int value, String text, String answer) {
        this.value = value;
        this.text = text;
        this.answer = answer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String toString() {
        return String.format("[%s] - %s", value, text);
    }
}
