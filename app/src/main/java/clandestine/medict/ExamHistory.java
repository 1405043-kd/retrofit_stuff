package clandestine.medict;

public class ExamHistory {

    private int UserId;
    private String QuestionId;
    private String TableName;
    private int Marks;
    private int Position;

    public ExamHistory() {
    }

    public int getUserId() {
        return UserId;
    }

    public String getQuestionId() {
        return QuestionId;
    }

    public String getTableName() {
        return TableName;
    }

    public int getMarks() {
        return Marks;
    }

    public int getPosition() {
        return Position;
    }
}
