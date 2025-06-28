abstract class Transport {
    abstract void ignite();

    void energySource() {
        System.out.println("Most transports use fuel");
    }
}

class Sedan extends Transport {
    @Override
    void ignite() {
        System.out.println("Sedan starts with a key");
    }
}

class Motorbike extends Transport {
    @Override
    void ignite() {
        System.out.println("Motorbike starts with a self-start button");
    }
}

interface RenewableTransport {
    void recharge();
}

class EVCar extends Transport implements RenewableTransport {
    @Override
    void ignite() {
        System.out.println("EVCar starts silently");
    }

    @Override
    public void recharge() {
        System.out.println("EVCar is charging");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.ignite();
        sedan.energySource();
        System.out.println();

        Motorbike motorbike = new Motorbike();
        motorbike.ignite();
        motorbike.energySource();
        System.out.println();

        EVCar evCar = new EVCar();
        evCar.ignite();
        evCar.recharge();
    }
}
