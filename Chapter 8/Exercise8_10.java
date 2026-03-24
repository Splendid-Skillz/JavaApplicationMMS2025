public class Exercise8_10 {

    // Enum type with duration
    public enum TrafficLight {

        RED(30),
        GREEN(45),
        YELLOW(5);

        private final int duration;

        // Constructor for enum
        TrafficLight(int duration) {
            this.duration = duration;
        }

        // Getter
        public int getDuration() {
            return duration;
        }
    }

    // Test program
    public static void main(String[] args) {

        System.out.println("Traffic Light Durations:\n");

        // Loop through all enum constants
        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%s light lasts %d seconds%n",
                    light, light.getDuration());
        }
    }
}