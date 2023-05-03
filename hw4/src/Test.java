import java.time.Year;
import java.util.Scanner;

public class Test {
    private Question[] questions;
    public Test(Question[] questions){
        this.questions = questions;
    }
    public void passTest() {
        Scanner scanner = new Scanner(System.in);

        printHelloMessage();

        try {Thread.sleep(5000);} catch (Exception e) {}

        Question[] questions = Test.initQuestionsAndAnswers();
        int usersScore = 0;


        for (int i = 0; i < questions.length; i++) {
            if (questions[i].ask())
                usersScore++;
        }
        printResult(usersScore);
    }



    public static Question[] initQuestionsAndAnswers(){
        Question[] questions = new Question[3];

        questions[0] = new Question(1,"Что такое интерфейс в Java?",
                new Answer[]{new Answer("Схема классов",false),new Answer("Тип, который может содержать методы, поля и внутренние классыы",false),
                        new Answer("Набор абстрактных методов и константных значений",true),new Answer("Набор связанных классов",false)});
        questions[1] = new Question(2,"Какова цель метода «public static void main (String [] args)» в Java?",
                new Answer[]{new Answer("Он объявляет основной метод для приложения Java",false),new Answer("Он указывает начальную точку для приложения Java",false),
                        new Answer("Он позволяет приложению Java принимать аргументы командной строки",false),new Answer("Все вышеперечисленное",true)});
        questions[2] = new Question(3,"Что такое наследование в Java?",
                new Answer[]{new Answer("Механизм создания новых классов из существующих классов",true),new Answer("Механизм совместного использования методов и полей между классам",false),
                        new Answer("Механизм повторного использования существующего кода в новых приложениях",false),new Answer("Все вышеперечисленное",false)});
        return questions;
    }
    public static void printHelloMessage() {
        System.out.println("Сегодня Вам предстоит пройти тест по Java\n" +
                "Он состоит из трёх вопросов\n" +
                "В каждом из них ровно один верный вариант ответа\n" +
                "Закончив тестирование Вы узнаетие свой результат\n" +
                "Удачи!");
        System.out.println();
        System.out.println();
    }

    public static void printResult(int result){
        if (result==3)
            System.out.println("Вы довольно хорошо знаете Java\n" +
                    "Ваш результат: "+result);
        if (result==2)
            System.out.println("Вы неплохо знаете Java\n" +
                    "Ваш результат: "+result);
        if (result<=1)
            System.out.println("Вам стоит повторить изученный материал\n" +
                    "Ваш результат: "+result);
    }
}

