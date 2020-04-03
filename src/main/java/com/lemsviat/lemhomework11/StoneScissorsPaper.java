package main.java.com.lemsviat.lemhomework11;

public class StoneScissorsPaper {
    private Human user;
    private Computer computer;

    public StoneScissorsPaper() {
        user = new Human();
        computer = new Computer();
    }
    public void startGame() {
        System.out.println("КАМЕНЬ, НОЖНИЦЫ, БУМАГА!");

        States userState = user.getStates();
        States computerState = computer.getStates();
        System.out.println("\nВаш ход - " + userState + ".");
        System.out.println("Ход компьютера - " + computerState + ".");

        int compareMoves = userState.compareStates(computerState);
        switch (compareMoves) {
            case 0: // Ничья
                System.out.println("Ничья!");
                break;
            case 1: // Победил игрок
                if (userState==States.НОЖНИЦЫ) System.out.println(userState + " бьют " + computerState + ". Вы победили!");
                else System.out.println(userState + " бьет " + computerState + ". Вы победили!");
                //userScore++;
                break;
            case -1: // Победил компьютер
                if (computerState==States.НОЖНИЦЫ) System.out.println(computerState + " бьют " + userState + ". Вы проиграли.");
                else System.out.println(computerState + " бьет " + userState + ". Вы проиграли.");
                break;
        }
        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            System.out.println("Игра закончена:)");;
        }
    }

    public static void main(String[] args) {
        StoneScissorsPaper game=new StoneScissorsPaper();
        game.startGame();
    }
}
