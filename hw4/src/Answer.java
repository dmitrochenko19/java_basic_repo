public class Answer {
    // private int number;
    private String text;
    private boolean isRight;
    public Answer(String text, boolean isRight) {
        this.text = text;
        this.isRight = isRight;
    }
    public boolean getIsRight(){
        return this.isRight;
    }
    public String getText(){
        return this.text;
    }

}
