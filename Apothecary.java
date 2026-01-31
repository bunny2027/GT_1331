//In order to help learn course concepts, I worked on the homework with [Josh Riddick my robotic mentor], discussed homework topics and issues with [provide names of people], 
//and/or consulted related material that can be found at stackoverflow


import java.util.Scanner;

public class Apothecary {

    public static void content() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to my apothecary! Please enter your name here: ");
        String name = scanner.nextLine();
        System.out.println();

        if (name.equals("")) {
            name = "Apprentice";
        } else {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        System.out.print("Hello " + name + ", which potion do you want me to brew? ");
        String potion_name = scanner.nextLine();

        if (potion_name.equalsIgnoreCase("death poison")) {
            System.out.println("GUARDS!");
            return;
        }

        potion_name = potion_name.toLowerCase();

        String potionName = "";
        String ingredients = "";
        String[] ingredientTypes = new String[3];
        int[] ingredientCounts = new int[3];
        int[] ingredientCosts = new int[3];
        int numIngredients = 0;
        boolean isAdvanced = false;
        boolean isValid = true;

        switch (potion_name) {
            case "potion of clarity":
                potionName = "Potion of Clarity";
                ingredients = "2 Vials of Crystal Dew";
                ingredientTypes[0] = "Vials of Crystal Dew";
                ingredientCounts[0] = 2;
                ingredientCosts[0] = 10;
                numIngredients = 1;
                break;

            case "elixir of agility":
                potionName = "Elixir of Agility";
                ingredients = "3 Swift Feathers";
                ingredientTypes[0] = "Swift Feathers";
                ingredientCounts[0] = 3;
                ingredientCosts[0] = 20;
                numIngredients = 1;
                break;

            case "healing draught":
                potionName = "Healing Draught";
                ingredients = "1 Phoenix Feather and 2 Vials of Moonlit Dew";
                ingredientTypes[0] = "Phoenix Feathers";
                ingredientCounts[0] = 1;
                ingredientCosts[0] = 50;
                ingredientTypes[1] = "Vials of Moonlit Dew";
                ingredientCounts[1] = 2;
                ingredientCosts[1] = 15;
                numIngredients = 2;
                isAdvanced = true;
                break;

            case "elixir of elemental power":
                potionName = "Elixir of Elemental Power";
                ingredients = "1 Vial of Moonlit Dew, 3 Lava Stones, and 2 Phoenix Feathers";
                ingredientTypes[0] = "Vials of Moonlit Dew";
                ingredientCounts[0] = 1;
                ingredientCosts[0] = 15;
                ingredientTypes[1] = "Lava Stones";
                ingredientCounts[1] = 3;
                ingredientCosts[1] = 30;
                ingredientTypes[2] = "Phoenix Feathers";
                ingredientCounts[2] = 2;
                ingredientCosts[2] = 50;
                numIngredients = 3;
                isAdvanced = true;
                break;

            default:
                isValid = false;
        }

        if (!isValid) {
            System.out.println("I am sorry, I cannot brew that potion.");
            return;
        }

        System.out.print("The " + potionName + " requires " + ingredients + ". How many would you like? ");
        String amountInput = scanner.nextLine();
        System.out.println();

        int numPotions = 1;
        try {
            int temp = Integer.parseInt(amountInput);
            if (temp >= 1) {
                numPotions = temp;
            }
        } catch (Exception e) {
            numPotions = 1;
        }

        int totalMissingCost = 0;

        for (int i = 0; i < numIngredients; i++) {
            System.out.print("How many " + ingredientTypes[i] + " will you provide? ");
            int provided = scanner.nextInt();
            scanner.nextLine();

            int required = ingredientCounts[i] * numPotions;
            int missing = required - provided;
            if (missing > 0) {
                totalMissingCost += missing * ingredientCosts[i];
            }
        }

        System.out.println();
        System.out.print("Is there anything I should know? ");
        String specialNote = scanner.nextLine();
        System.out.println();

        boolean isForKing = specialNote.equalsIgnoreCase("The order is for the King");

        int serviceFee = isAdvanced ? 20 : 10;
        int potionFee = isAdvanced ? 25 : 15;
        double finalCost = serviceFee + (potionFee * numPotions) + totalMissingCost;

        if (isForKing) {
            finalCost *= 0.5;
        }

        String potionNamePlural = potionName;
        if (numPotions > 1) {
            potionNamePlural = potionName.replace("Potion", "Potions")
                    .replace("Elixir", "Elixirs")
                    .replace("Draught", "Draughts");
        }

        System.out.printf("%s, thank you for requesting the %s. The cost is $%.2f.%n",
                name, potionNamePlural, finalCost);

        scanner.close();
    }

    public static void main(String[] args) {
        content();
    }
}
