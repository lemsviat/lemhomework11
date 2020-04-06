package main.java.com.lemsviat.lemhomework11.variant2;
import java.util.Random;
import java.util.Scanner;

public class GameProcessor {
    private Player[] players;
    {
        players = new Player[2];
    }

    public States getHumanStates() {
        // Выведем запрос на ввод
        System.out.print("Камень, ножницы или бумага? Ваш выбор--> ");
        Scanner scanHumanMove;
        scanHumanMove = new Scanner(System.in);

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
        }  // Ввод некорректный. Выведем запрос на ввод снова.
        System.out.println("Введите, пожалуйста буквы 'к' или 'н' или 'б'");
        return getHumanStates();
    }

    public States getPCStates() {
        States[] states = States.values();
        Random random = new Random();
        int index = random.nextInt(states.length);
        return states[index];
    }

    public Player[] getPlayersInfo() {
        int i;
        for (i = 0; i < players.length; i++) {
            // Выведем запрос на ввод имени и типа игроков
            System.out.print("Ваше имя, " + (i + 1) + " игрок--> ");
            Scanner createPlayerScanner;
            createPlayerScanner = new Scanner(System.in);
            String playerName = createPlayerScanner.nextLine();
            System.out.print("Вы человек или компьютер--> 'ч'-человек, 'к'-компьютер-->");
            char playerType = createPlayerScanner.nextLine().toUpperCase().charAt(0);
            while (playerType != 'Ч' && playerType != 'К') {
                System.out.print("Введите, пожалуйста, буквы 'ч' или 'к'--> ");
                playerType = createPlayerScanner.nextLine().toUpperCase().charAt(0);
            }
            // Ввод корректный
            switch (playerType) {
                case 'Ч': {
                    players[i] = new Player(playerName, UserTypes.HUMAN);
                    break;
                }
                case 'К':
                    players[i] = new Player(playerName, UserTypes.PC);
            }
        }
        return players;
    }

    States playerState;
    States player1State;
    States player2State;

    public void startGame() {
        System.out.println("Играем в игру: КАМЕНЬ, НОЖНИЦЫ, БУМАГА!");

        getPlayersInfo();

        for (int i = 0; i < players.length; i++) {
            if (players[i].getType().equals(UserTypes.HUMAN)) {
                playerState = getHumanStates();
            } else {
                playerState = getPCStates();
            }
            if (i == 0) {
                player1State = playerState;
            } else {
                player2State = playerState;
                System.out.println("Ход игрока по имени - " + players[i].getName() + " -> " + player2State + ".");
            }
        }
        System.out.println("Ход игрока по имени - " + players[0].getName() + " -> " + player1State + ".");

        int compareMoves = player1State.compareStates(player2State);
        String win=". \nПобедил игрок по имени ";
        switch (compareMoves) {
            case 0: // Ничья
                System.out.println("Ничья!");
                break;
            case 1: // Победил 1 игрок
                if (player1State == States.НОЖНИЦЫ) {
                    System.out.println(player1State + " бьют " + player2State + win + players[0].getName());
                } else
                    System.out.println(player1State + " бьет " + player2State + win + players[0].getName());
                break;
            case -1: // Победил 2 игрок
                if (player2State == States.НОЖНИЦЫ) {
                    System.out.println(player2State + " бьют " + player1State + win + players[1].getName());
                } else
                    System.out.println(player2State + " бьет " + player1State + win + players[1].getName());
                break;
        }
    }
}

