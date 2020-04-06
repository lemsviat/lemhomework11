package main.java.com.lemsviat.lemhomework11.variant1;

public enum States {
    КАМЕНЬ, НОЖНИЦЫ, БУМАГА;

    public int compareStates(States otherState) {
        // Ничья
        if (this == otherState)
            return 0;


        switch (this) {

            case КАМЕНЬ:
                return (otherState == НОЖНИЦЫ ? 1 : -1);
            case БУМАГА:
                return (otherState == КАМЕНЬ ? 1 : -1);
            case НОЖНИЦЫ:
                return (otherState == БУМАГА ? 1 : -1);
        }

        // Этот код не должен выполняться никогда
        return 0;
    }
}
