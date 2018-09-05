package br.com.mojumob.anotacoesmvp;

class Nota {
    private String text;
    private String date;

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
