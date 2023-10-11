package decorator_design_pattern; // Package declaration

// Interface for Dress
interface Dress {
	public void assemble(); // Method to assemble the dress
}

// Concrete class for Basic Dress
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features");
	}
}

// Abstract decorator class for Dress
class DressDecorator implements Dress {
	protected Dress dress;

	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// Concrete decorator class for Casual Dress
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Concrete decorator class for Sporty Dress
class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Concrete decorator class for Fancy Dress
class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		// Create a Sporty Dress on top of a Basic Dress
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		// Create a Fancy Dress on top of a Basic Dress
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		// Create a Casual Dress on top of a Basic Dress
		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		// Create a Sporty Dress on top of a Fancy Dress on top of a Basic Dress
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		// Create a Casual Dress on top of a Fancy Dress on top of a Basic Dress
		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
