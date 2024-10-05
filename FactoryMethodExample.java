//Transport interface defines a common method that all concrete transport types must implement.
interface Transport {
    //This method will simulate the action of delivering goods.
    void transportGoods();
}

//concrete class for land based transport
class LandTransport implements Transport {
    @Override
    public void transportGoods() {
        System.out.println("Goods are being transported by land using a truck");
    }
}

//concreteclass for water based transport
class WaterTransport implements Transport {
    @Override
    public void transportGoods() {
        System.out.println("Goods are being transported by sea using a ship");
    }
}

//class for air based transport
class AirTransport implements Transport {
    @Override
    public void transportGoods() {
        System.out.println("Goods are being transported by air using a drone");
    }
}

// abstract factory class that defines the method for creating transport objects
// subclasses of TransportFactory will implement this method to create specific types of transport
abstract class TransportFactory {
    // factory method for creating transport objects. Its abstract and must be implemented by subclasses
    public abstract Transport createTransport();
}

//concrete factory for creating land transport objects
class RoadTransportFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new LandTransport();
    }
}

//concrete factory for creating water transport objects
class SeaTransportFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new WaterTransport();
    }
}

//concrete factory for creating air transport objects
class AirwayTransportFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new AirTransport();
    }
}

// main class that demonstrates the Factory Method Pattern
// client code selects the appropriate factory based on the type of delivery required
public class FactoryMethodExample {
    public static void main(String[] args) {
        //simulate creating transport for land delivery
        TransportFactory roadFactory = new RoadTransportFactory();
        Transport truck = roadFactory.createTransport();
        truck.transportGoods(); //calls the deliver method of the land transport

        //simulate creating transport for water delivery
        TransportFactory seaFactory = new SeaTransportFactory();
        Transport ship = seaFactory.createTransport();
        ship.transportGoods(); // Calls the deliver method of the water transport

        //simulate creating transport for air delivery
        TransportFactory airFactory = new AirwayTransportFactory();
        Transport drone = airFactory.createTransport();
        drone.transportGoods(); //calls the deliver method of the air transport
    }
}
