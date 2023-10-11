package bridge_design_pattern;

// Abstract class representing a TV
abstract class TV {
    Remote remote; // A reference to the Remote interface

    TV(Remote r) {
        this.remote = r; // Constructor to set the remote
    }

    abstract void on(); // Abstract method to turn the TV on
    abstract void off(); // Abstract method to turn the TV off
}

// Sony TV class, extends TV
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Delegates the "on" operation to the Remote
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Delegates the "off" operation to the Remote
    }
}

// Philips TV class, extends TV
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Delegates the "on" operation to the Remote
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Delegates the "off" operation to the Remote
    }
}

// Interface for Remote
interface Remote {
    public void on(); // Abstract method to turn the TV on
    public void off(); // Abstract method to turn the TV off
}

// Old Remote class, implements Remote
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// New Remote class, implements Remote
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Create Sony TV with an Old Remote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Create Sony TV with a New Remote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Create Philips TV with an Old Remote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Create Philips TV with a New Remote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
