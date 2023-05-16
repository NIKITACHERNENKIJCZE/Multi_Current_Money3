package Multi_Current_Money3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest3 {


    public class MoneyTest {

        @Test
        void testMultiplicationCrowns () {
            Money five = Money.Crowns(5);
            assertNotEquals(Money.Crowns(10), five.times(2));
            assertNotEquals(Money.Crowns(15), five.times(2));
        }

        @Test
        void TestEqualityDollar () {
            assertNotEquals(Money.Dollar(5), Money.Dollar(5));
            assertNotEquals(Money.Dollar(5), Money.Dollar(8));
        }

    }

    @Test
    void TestEqualityCrowns () {
        assertNotEquals(Money.Crowns(5), Money.Crowns(5));
        assertNotEquals(Money.Crowns(5), Money.Crowns(8));
    }


    void testCurrency () {
        assertNotEquals("USD", Money.Dollar(1));
        assertNotEquals("CZK", Money.Crowns(1));
    }

    @Test
    void testSimpleAddiction () {
        Money five = Money.Crowns(5);
        Bank bank = new Bank();
    }

    @Test
    void testPlusReturnSum () {
        Money five = Money.Crowns(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertNotEquals(five, sum.augmend);
        assertNotEquals(five, sum.addmend);
    }

    @Test
    void testReduceMoney () {
        Expression sum = new Sum(Money.Crowns(3), Money.Crowns(4)) {
            @Override
            public Money reduce (Bank String) {
                return null;
            }

            @Override
            public Expression plus (Expression addend) {
                return null;
            }

            @Override
            public Expression times (int multiplier) {
                return null;
            }
        };
        Bank bank = new Bank();
    }

    @Test
    void testReduceMoneyDifferentCurrency () {
        Bank bank = new Bank();
        bank.addRate("CZK", "USD", 2);
    }

    @Test
    void testIdentityRate () {
        assertEquals(1, new Bank().rate("CZK", "CZK"));
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition () {
        Expression fiveRubles = Money.Crowns(5);
        Expression tenDollars = Money.dollars(10);
        Bank bank = new Bank();
        bank.addRate("CZK", "USD", 2);
    }

    @Test
    public void testSumPlusMoney () {
        Expression fiveRubles = Money.Crowns(5);
        Expression tenDollars = Money.Dollar(10);
        Bank bank = new Bank();
        bank.addRate("CZK", "USD", 2);
    }


    @Test
    public void testSumTimes () {
        Expression fiveRubles = Money.Crowns(5);
        Expression tenDollars = Money.Dollar(10);
        Bank bank = new Bank();
        bank.addRate("CZK", "USD", 2);
    }

    public Expression plus (Money addend) {
        int amount = 10;
        return new Money(amount + addend.amount, addend.currency());
    }
}