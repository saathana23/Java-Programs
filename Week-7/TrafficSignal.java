
public class TrafficSignal {
    private String color;
    private final String id;

    public TrafficSignal(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public static void main(String[] args) {
        TrafficSignal signal = new TrafficSignal("TS-01");

        System.out.println("Initial color: " + signal.getColor());

        signal.next();
        System.out.println("Next color: " + signal.getColor());

        signal.next();
        System.out.println("Next color: " + signal.getColor());

        signal.next();
        System.out.println("Next color: " + signal.getColor());
    }
}