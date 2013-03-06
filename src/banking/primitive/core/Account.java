package banking.primitive.core;

public abstract class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    protected enum State {
        OPEN, CLOSED, OVERDRAWN
    };
   
    protected Account(String n) {
        _name = n;
        _state = State.OPEN;
    }

    protected Account(String n, float b) {
        this(n); // <-- MAKE THIS CHANGE HERE
        _balance = b;
    }

    /**
     * @return name of the Account
     */
    public final String getName() {
        return _name;
    }

    /**
     * @return balance in the Account
     */
    public final float getBalance() {
        return _balance;
    }

    /**
     * Adds money to an account. May not be done if the account is CLOSED
     * 
     * @param parameter
     *            amount is a deposit and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean deposit(float amount);

    /**
     * Takes money out of an account. If the balance falls below 0 then the
     * account is moved to an OVERDRAWN state
     * 
     * @param parameter
     *            amount is a withdrawal and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean withdraw(float amount);

    /**
     * @return either "Checking" or "Savings"
     */
    public abstract String getType();

    protected final State getState() {
        return _state;
    }

    protected final void setState(State s) {
        _state = s;
    }

    public String toString() {
        return "Account " + _name + " has $" + _balance + "and is " + getState()
                + "\n";
    }
    
    //Jupiter ID HDZ0WE1J Lab6rpmille6
    //Jupiter ID HDZ0VWHE Lab6rpmille6
    private float _balance = 0.0F;
    private String _name;
    //Jupiter ID HDZ0HKCQ  Lab6rpmille6
    private State _state;

}
