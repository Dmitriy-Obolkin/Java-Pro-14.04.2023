package src.main.homeworks.hw16;

public class DemoIntTree {
    public static void main(String[] args) {
        TreeIntNode root = new TreeIntNode(15);

        TreeIntNode child3 = new TreeIntNode(3);
        TreeIntNode child1 = new TreeIntNode(1);
        TreeIntNode child5 = new TreeIntNode(5);
        TreeIntNode child2 = new TreeIntNode(2);
        TreeIntNode child4 = new TreeIntNode(4);
        TreeIntNode child8 = new TreeIntNode(8);

        root.addChild(child3);
        root.addChild(child1);
        root.addChild(child2);

        child1.addChild(child5);
        //child5.addChild(root); //err
        //child1.addChild(child5); //err

        child2.addChild(child4);
        child2.addChild(child8);


        System.out.println("Iterate from root:");
        root.iterate();
        System.out.println("Iterate from child1:");
        child1.iterate();

        System.out.printf("Sum from child2: %d", child2.sum());
    }
}
