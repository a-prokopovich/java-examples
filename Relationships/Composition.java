public class Lens {
    private String name;
    private String material;
    private double refractiveIndex;

    public void setLens() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter information about lens:");
        System.out.print("name: ")
        this.name = scanner.nextLine();
        System.out.print("material: ");
        this.material = scanner.nextLine();
        System.out.print("refractiveIndex: ");
        this.refractiveIndex = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Lens: " +
                "name = " + name +
                ", material = " + material +
                ", refractive index = " + refractiveIndex;
    }
}

public class Glasses {
    private String name;
    private String appointment;
    private double price;
    private int quantity;
    private Lens lens;

    public Glasses() {
        this.lens = new Lens();
    }

    public void addGlasses() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter information about glasses: ");
        System.out.print("name: ")
        name = scanner.nextLine();
        System.out.print("appointment: ");
        appointment = scanner.nextLine();
        System.out.print("price: ");
        price = scanner.nextDouble();
        System.out.print("quantity: ");
        quantity = scanner.nextInt();
        lens.setLens();
    }

    public double calculateTotalСost() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Glasses: " +
                "name = " + name +
                ", appointment='" + appointment +
                ", price = " + price +
                ", quantity = " + quantity + "; " +
                lens.toString();
    }
}

public class OpticsWarehouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    List<Glasses> glassesList = new ArrayList<>();
	    boolean isContinue = true;
	    double totalCost = 0;

        System.out.println("Add some glasses to the warehouse");
	    while (isContinue) {
	        Glasses glasses = new Glasses();
	        glasses.addGlasses();
	        glassesList.add(glasses);
            System.out.println("Continue adding glasses? (1 - yes, 2 - no)");
            if(scanner.nextInt() != 1) {
                isContinue = false;
            }
        }
        System.out.println("Added glasses");
	    for (Glasses glasses : glassesList) {
            System.out.println(glasses.toString());
            totalCost += glasses.calculateTotalСost();
        }
        System.out.println("Total cost of glasses in the warehouse: " + totalCost);
    }
}
