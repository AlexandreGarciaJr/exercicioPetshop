import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static PetBathMachine petBathMachine = new PetBathMachine();


    public static void main(String[] args) {

        scanner.useDelimiter("\\n");
        var option = -1;

        do {
            System.out.println("=== Escolha uma das opções ===");
            System.out.println("1 - Dar banho no Pet");
            System.out.println("2 - Abastecer máquina com água");
            System.out.println("3 - Abastecer máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> petBathMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPet();
                case 7 -> setPetInPetMachine();
                case 8 -> petBathMachine.removePet();
                case 9 -> petBathMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }while (true);
    }

    private static void setWater(){
        System.out.println("Tentando colocar água na máquina");
        petBathMachine.addWater();
    }

    private static void setShampoo(){
        System.out.println("Tentando colocar shampoo na máquina");
        petBathMachine.addShampoo();
    }

    private static void verifyWater() {
        var amount = petBathMachine.getWater();
        System.out.println("A máquina está com: " + amount + "litros(s) de Água");
    }

    private static void verifyShampoo() {
        var amount = petBathMachine.getShampoo();
        System.out.println("A máquina está com: " + amount + "litros(s) de shampoo");
    }

    private static void checkIfHasPet() {
        var hasPet = petBathMachine.hasPet();
        System.out.println(hasPet ? "Tem Pet na máquina" : "Não tem Pet na máquina");
    }

    public static void setPetInPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petBathMachine.setPet(pet);
    }

}