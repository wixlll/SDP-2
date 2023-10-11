package singleton_design_pattern; // Package declaration

// Singleton with eager initialization
class SingletonEager {
  private static SingletonEager instance = new SingletonEager(); // Eagerly create an instance
  private SingletonEager() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonEager getInstance() {
    return instance; // Return the pre-created instance
  }
}

// Singleton with lazy initialization (not thread-safe)
class Singleton {
  private static Singleton instance; // Singleton instance
  private Singleton() {
    // Private constructor to prevent external instantiation
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton(); // Create the instance only if it doesn't exist
    }
    return instance;
  }
}

// Singleton with lazy initialization using synchronized method (thread-safe but not efficient)
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance; // Singleton instance
  private SingletonSynchronizedMethod() {
    // Private constructor to prevent external instantiation
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod(); // Create the instance only if it doesn't exist
    }
    return instance;
  }
}

// Singleton with lazy initialization using double-checked locking (thread-safe and more efficient)
class SingletonSynchronized {
  private static SingletonSynchronized instance; // Singleton instance
  private SingletonSynchronized() {
    // Private constructor to prevent external instantiation
  }

  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized(); // Create the instance with double-checked locking
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
