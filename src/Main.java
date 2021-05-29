public class Main {
    public static void main(String[] args) {
        Chicken chicken1 = new Chicken();
//        chicken1.create();
        System.out.println("x= " + chicken1.x + " y= " + chicken1.y + " product " + chicken1.product );
        chicken1.moveRandom();
        System.out.println("x= " + chicken1.x + " y= " + chicken1.y + " price " + chicken1.price );
        for (int i = 0; i < 11; i++) {
            chicken1.moveRandom();
            System.out.println("x= " + chicken1.x + " y= " + chicken1.y);
        }
    }
}
