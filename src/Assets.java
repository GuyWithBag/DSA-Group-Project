import java.util.Random;

public class Assets {
    final public static String logo = " _                                             \n" +
            "| |                                            \n" +
            "| |__   _ _ _ _   _ _ _ _  + _   _ _ _ _  \n" +
            "| '_ \\ / _ | '_ \\ / _ | '_  _ \\ / _ | '_ \\ \n" +
            "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
            "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
            "                    __/ |                      \n" +
            "                   |___/    \n";
    final public static String[] stages = {
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n========="
    };
    final public static Word[] wordList = {
            new Word("abruptly", "Happening suddenly or unexpectedly."),
            new Word("absurd", "Utterly or obviously senseless or illogical."),
            new Word("abyss", "A deep or seemingly bottomless chasm."),
            new Word("affix", "To attach something firmly in place."),
            new Word("askew", "Not in a straight or level position."),
            new Word("avenue", "A wide road or path, typically lined with trees."),
            new Word("awkward", "Causing or feeling embarrassment or inconvenience."),
            new Word("axiom", "A statement or proposition regarded as self-evidently true."),
            new Word("azure", "A bright blue color like that of a clear sky."),
            new Word("banjo", "A stringed musical instrument 2with a round body."),
            new Word("blizzard", "A severe snowstorm with high winds."),
            new Word("boggle", "To be astonished or overwhelmed at something."),
            new Word("buffoon", "A person who amuses others by being silly or foolish."),
            new Word("buzzard", "A large bird of prey, typically seen soaring in the sky."),
            new Word("caliph", "A spiritual leader of Islam, regarded as a successor of Muhammad."),
            new Word("cobweb", "A spider's web, especially when old and covered in dust."),
            new Word("crypt", "An underground room or vault, typically beneath a church."),
            new Word("cycle", "A series of events that are regularly repeated in the same order."),
            new Word("dizzying", "Feeling or making someone feel unsteady or confused."),
            new Word("duplex", "A house divided into two separate residences."),
            new Word("dwarves", "Mythological beings who are typically small and skilled in mining or metalwork."),
            new Word("equip", "To provide with the necessary items for a particular purpose."),
            new Word("espionage", "The practice of spying or using spies."),
            new Word("exodus", "A mass departure of people, especially emigrants."),
            new Word("fjord", "A long, narrow inlet with steep sides, created by a glacier."),
            new Word("fuchsia", "A bright pinkish-purple color."),
            new Word("galaxy", "A large system of stars, gas, and dust bound by gravitational attraction."),
            new Word("gizmo", "A gadget, especially one whose name is unknown or forgotten."),
            new Word("glyph", "A symbolic character or figure."),
            new Word("gnarly", "Something excellent or outstanding, often used in slang."),
            new Word("groggy", "Dazed, weak, or unsteady, especially from illness or lack of sleep."),
            new Word("haiku", "A traditional Japanese poem of three lines with 5-7-5 syllables."),
            new Word("hyphen", "A punctuation mark used to join words."),
            new Word("injury", "Harm or damage done to a person or body."),
            new Word("ivory", "A hard, white material from the tusks of animals like elephants."),
            new Word("jazzy", "Lively, bright, or fancy in appearance."),
            new Word("jinx", "A person or thing that brings bad luck."),
            new Word("jovial", "Cheerful and friendly."),
            new Word("kayak", "A narrow, lightweight boat, usually with a covered deck."),
            new Word("keyhole", "A hole for inserting a key."),
            new Word("khaki", "A light brown color, often used in military clothing."),
            new Word("kiosk", "A small open-fronted booth or stand for selling goods."),
            new Word("kitsch", "Art or objects considered to be in poor taste but appreciated ironically."),
            new Word("larynx",
                    "The hollow muscular organ forming an air passage to the lungs and holding the vocal cords."),
            new Word("luxury", "A state of great comfort and extravagant living."),
            new Word("lymph", "A fluid that circulates throughout the lymphatic system."),
            new Word("marquis", "A nobleman ranking above a count and below a duke."),
            new Word("matrix", "An environment or material in which something develops."),
            new Word("mnemonic", "A device or pattern to aid memory."),
            new Word("mystify", "To perplex someone or make them feel puzzled."),
            new Word("nymph", "A mythological spirit of nature, usually depicted as a beautiful maiden."),
            new Word("onyx", "A semiprecious stone with bands of color."),
            new Word("oxidize", "To combine with oxygen or undergo a reaction involving oxygen."),
            new Word("pixel", "The smallest unit of a digital image or graphic."),
            new Word("pneumonia", "An infection that inflames the air sacs in the lungs."),
            new Word("quartz", "A hard mineral often used in jewelry."),
            new Word("quorum", "The minimum number of members required to conduct a meeting."),
            new Word("rhubarb", "A plant with large leaves and thick stems, often used in pies."),
            new Word("schnapps", "A strong alcoholic drink, typically flavored."),
            new Word("sphinx", "A mythical creature with the head of a human and the body of a lion."),
            new Word("topaz", "A gemstone that is often yellow or golden in color."),
            new Word("vortex", "A mass of whirling fluid or air."),
            new Word("waltz", "A ballroom dance in triple time."),
            new Word("wizard", "A person with magical powers, often seen in fantasy literature."),
            new Word("wyvern", "A type of dragon with two legs and a tail, often found in heraldry."),
            new Word("xylophone", "A musical instrument with wooden bars that produce sounds when struck."),
            new Word("zephyr", "A soft, gentle breeze."),
            new Word("zilch", "Nothing; zero."),
            new Word("zodiac", "A band of the sky divided into twelve astrological signs."),
            new Word("zombie", "A reanimated corpse or an undead being.")
    };

    final public static Word getRandomWord() {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)];
    }

}
