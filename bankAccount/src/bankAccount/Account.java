package bankAccount;
@SuppressWarnings("unused")

public class Account {
    private final String number;
    private final String owner;
    private int amount;

    public Account(final String number, final String owner) {
        this.number = number;
        this.owner = owner;
    }

    public Account(final String number, final String owner, int amount) {
        this.number = number;
        this.owner = owner;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public int getAmount() {
        return amount;
    }

    private int withdraw(int amountToWithdraw) {
        if (amountToWithdraw < 0) {
            return 0;
        }
        if (amountToWithdraw > amount) {
            final int amountToReturn = amount;
            amount = 0;
            return amountToReturn;
        }
        amount -= amountToWithdraw;
        return amountToWithdraw;
    }

    private int add(int amountToAdd) {
        if (amountToAdd < 0) {
            withdraw(amountToAdd);
        }
        amount += amountToAdd;
        return amountToAdd;
    }


    public class Card {
        private final String number;

        public Card(final String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public int withdraw(final int amountToWithdraw) {
            return Account.this.withdraw(amountToWithdraw);
        }

        public int add(final int amountToAdd) {
            return Account.this.add(amountToAdd);
        }
    }
}