class Lamp {
    public String name = "generic";
    boolean isOn;

    public Lamp(String n) {
        name = n;
    }

    void nma() {
    }

    void turnOn() {
        isOn = true;
        System.out.println(name + " light on? " + isOn);

    }

    void turnOff() {
        isOn = false;
        System.out.println(name + " light on? " + isOn);
    }
}

class LampMan {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        Lamp led = new Lamp("led");
        Lamp halogen = new Lamp("halogen");

        led.turnOn();
        halogen.turnOff();
    }
}

