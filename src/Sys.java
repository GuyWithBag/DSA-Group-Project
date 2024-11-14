import java.util.Scanner;

public class Sys {

    private static final Scanner scanner = new Scanner(System.in);

    public static void outln(Object obj) {
        System.out.println(obj);
    }

    public static void out(Object obj) {
        System.out.print(obj);
    }

    public static String in() {
        String output = scanner.nextLine();
        return output;
    }

    public static <T extends Enum<T>> T inputLoop(Class<T> enumClass, String prompt) {
        Sys.outln("\n" + prompt);
        for (T constant : enumClass.getEnumConstants()) {
            Sys.outln(constant.ordinal() + " | " + constant);
        }

        String inputAgainDisplay = "Please input a number from the list of options.";
        while (true) {
            T[] constants = enumClass.getEnumConstants();
            Sys.out("Input a number from the list: ");
            String input = Sys.in();
            int numberInput = -1;

            try {
                numberInput = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Sys.outln(inputAgainDisplay);
                continue;
            }

            if (numberInput + 1 > constants.length) {
                Sys.outln(inputAgainDisplay);
                continue;
            }

            T chosenOption = constants[numberInput];
            return chosenOption;
        }

    }

}
