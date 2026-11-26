package transfers;

class TransferServiceTest {
/*
    private static final double DELTA = 0.001;

    private ContainerFactory containerFactory = new ContainerFactory();

    private Container container;
    private Owner owner;

    @BeforeEach
    public void setUp() {
        container = containerFactory.createContainer();
        owner = new Owner("Jan", "Novak");
    }

    @Test
    public void withdrawReducesBalance() {
        CurrentAccount account = new CurrentAccount(owner, 1000);

        container.transferService.withdraw(account, 300);

        assertEquals(700, account.getBalance(), DELTA);
    }

    @Test
    public void withdrawWholeBalanceIsAllowed() {
        CurrentAccount account = new CurrentAccount(owner, 1000);

        container.transferService.withdraw(account, 1000);

        assertEquals(0, account.getBalance(), DELTA);
    }

    @Test
    public void withdrawOverBalanceThrowsAndKeepsBalance() {
        CurrentAccount account = new CurrentAccount(owner, 1000);

        assertThrows(RuntimeException.class, () -> container.transferService.withdraw(account, 1001));
        assertEquals(1000, account.getBalance(), DELTA);
    }

    @Test
    public void businessAccountPaysWithdrawFee() {
        BusinessAccount account = new BusinessAccount(owner, 1000);

        container.transferService.withdraw(account, 100);

        // 1000 - 100 - 10 % fee
        assertEquals(890, account.getBalance(), DELTA);
    }

    @Test
    public void businessAccountFeeCountsTowardsLimit() {
        BusinessAccount account = new BusinessAccount(owner, 1000);

        assertThrows(RuntimeException.class, () -> container.transferService.withdraw(account, 1000));
        assertEquals(1000, account.getBalance(), DELTA);
    }

    @Test
    public void studentAccountCanGoNegativeUpToLimit() {
        StudentAccount account = new StudentAccount(owner, "Test");

        container.transferService.withdraw(account, 5000);

        assertEquals(-5000, account.getBalance(), DELTA);
    }

    @Test
    public void studentAccountOverLimitThrows() {
        StudentAccount account = new StudentAccount(owner, "Test");

        assertThrows(RuntimeException.class, () -> container.transferService.withdraw(account, 5001));
        assertEquals(0, account.getBalance(), DELTA);
    }

    @Test
    public void addToBalanceIncreasesBalance() {
        CurrentAccount account = new CurrentAccount(owner, 1000);

        container.transferService.addToBalance(account, 500);

        assertEquals(1500, account.getBalance(), DELTA);
    }
*/
}
