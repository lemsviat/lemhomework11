package main.java.com.lemsviat.lemhomework11;

import java.util.Scanner;

public class Human implements Playable{
    private Scanner scanHumanMove;
    public Human() {
        scanHumanMove = new Scanner(System.in);
    }

    @Override
    public States getStates() {
        // Выведем запрос на ввод
        System.out.print("Камень, ножницы или бумага? Ваш выбор--> ");

        // Прочитаем ввод пользователя
        String userInput = scanHumanMove.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);
        if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
            // Ввод корректный
            switch (firstLetter) {
                case 'К':
                    return States.КАМЕНЬ;
                case 'Н':
                    return States.НОЖНИЦЫ;
                case 'Б':
                    return States.БУМАГА;
            }
        }
        // Ввод некорректный. Выведем запрос на ввод снова.
        System.out.println("Введите, пожалуйста буквы 'к' или 'н' или 'б'");
        return getStates();
    }
    public boolean playAgain() {
        System.out.print("Хотите сыграть еще раз? Буква 'д'-да, любой другой символ-нет -->");
        String userInput = scanHumanMove.nextLine();
        if (userInput.length()==0) return false;
        else {
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Д'; }
    }
}
