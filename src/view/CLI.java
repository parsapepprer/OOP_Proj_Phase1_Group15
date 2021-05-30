package view;

import controller.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class CLI {

    private final Scanner scanner;
    private final MainManager manager;

    public CLI() {
        this.scanner = new Scanner(System.in);
        this.manager = new MainManager();
    }

    private void addPerson(Matcher matcher) {
        ResultType result = manager.addPerson(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        switch (result) {
            case DATE_INCORRECT:
                System.out.println("Your date was incorrect!");
                break;
            case PERSON_EXISTED:
                System.out.println("The national code already exists!");
                break;
            case INVALID_NUMBER:
                System.out.println("Your national code must be number!");
                break;
            case ADD_PERSON_SUCCESS:
                System.out.println("The person has successfully added!");
                break;
        }
    }

    private void addCompany(Matcher matcher) {
        ResultType result = manager.addCompany(matcher.group(1), matcher.group(2));
        switch (result) {
            case PERSON_EXISTED:
                System.out.println("The company name already exists!");
                break;
            case INVALID_NUMBER:
                System.out.println("CEO national code must be number!");
                break;
            case ADD_PERSON_SUCCESS:
                System.out.println("The company has successfully added!");
                break;
        }
    }

    private void addBank(Matcher matcher) {
        ResultType result = manager.addBank(matcher.group(1), matcher.group(2));
        switch (result) {
            case BANK_INVALID:
                System.out.println("The bank name is invalid!");
                break;
            case BANK_EXITED:
                System.out.println("The bank already exits!");
                break;
            case INVALID_NUMBER:
                System.out.println("The amount of balance is incorrect!");
                break;
            case BANK_SUCCESS:
                System.out.println("The bank has successfully added!");
                break;
        }
    }

    private void setBankParameters(Matcher matcher) {
        ResultType result = manager.setBankParameters(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("The bank name is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("The bank doesn't exit!");
                break;
            case INVALID_NUMBER:
                System.out.println("The number of parameter is invalid!");
                break;
            case SET_PARAMETER_SUCCESS:
                System.out.println("The bank parameter has successfully changed!");
                break;
        }
    }

    private void openCurrentAccount(Matcher matcher) {
        ResultType result = manager.openCurrentAccount(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case LOW_AGE:
                System.out.println("Your age is under 16!");
                break;
            case INVALID_NUMBER:
                System.out.println("Your amount is invalid!");
                break;
            case OPEN_ACCOUNT_SUCCESS:
                System.out.println("A current account was opened successfully!");
                System.out.println("Your card specifications: " + result.getValue());
                break;
        }
    }

    private void openDepositAccount(Matcher matcher) {
        ResultType result = manager.openDepositAccount(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case INVALID_TYPE:
                System.out.println("The type of deposit account is invalid!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case LOW_AGE:
                System.out.println("Your age is under 16!");
                break;
            case INVALID_NUMBER:
                System.out.println("Your amount is invalid!");
                break;
            case INCOMPLETE_LOAN:
                System.out.println("Because you have an incomplete load, you can't open deposit account!");
                break;
            case OPEN_ACCOUNT_SUCCESS:
                System.out.println("A deposit account was opened successfully!");
                System.out.println(result.getValue());
                break;
        }
    }

    private void closeAccount(Matcher matcher) {
        ResultType result = manager.closeAccount(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case CURRENT_LOAN:
                System.out.println("You can't close your current account because you have a loan in this bank!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case INVALID_NUMBER:
                System.out.println("Your amount is invalid!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no account with these number and owner id!");
                break;
            case CLOSE_CURRENT_NOT_ALLOWED:
                System.out.println("You can't close this current account because a deposit account uses it!");
                break;
            case CLOSE_ACCOUNT_SUCCESS:
                System.out.println("Your current account was closed successfully!");
                break;
        }
    }

    private void setCardParameters(Matcher matcher) {
        ResultType result = manager.setCardParameters(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case CARD_EXPIRED:
                System.out.println("You can't do anything with your card because your card is expired!");
                break;
            case INVALID_CARD_NUMBER:
                System.out.println("The card number is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("The bank doesn't exit!");
                break;
            case INVALID_PASSWORD:
                System.out.println("The password is incorrect!");
                break;
            case INVALID_NEW_PASSWORD:
                System.out.println("The new password is incorrect!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no card with this number!");
                break;
            case PASSWORD2_NOT_SET:
                System.out.println("At first, set the second password!");
                break;
            case PASSWORD2_SET:
                System.out.println("The second password is already set!");
                break;
            case SET_PARAMETER_SUCCESS:
                System.out.println("The card parameter has successfully changed!");
                break;
        }
    }

    private void extendCardExpiration(Matcher matcher) {
        ResultType result = manager.extendCardExpiration(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case INVALID_CARD_NUMBER:
                System.out.println("The card number is invalid!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case INVALID_NUMBER:
                System.out.println("Your card number is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("The bank doesn't exit!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no card with these number and owner id!");
                break;
            case EXTEND_SUCCESS:
                System.out.println("The card expiration date has successfully extended!");
                break;
        }
    }

    private void depositMoney(Matcher matcher) {
        ResultType result = manager.depositMoney(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case INVALID_NUMBER:
                System.out.println("The numbers you entered are invalid!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no account with this number!");
                break;
            case ACCOUNT_DEPOSIT:
                System.out.println("You can't deposit money to deposit account!");
                break;
            case DEPOSIT_SUCCESS:
                System.out.println("The money was successfully deposited!");
                break;
        }
    }

    private void withdrawMoney(Matcher matcher) {
        ResultType result = manager.withdrawMoney(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case CARD_EXPIRED:
                System.out.println("You can't do anything with your card because your card is expired!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case INVALID_CARD_NUMBER:
                System.out.println("The card number is invalid!");
                break;
            case INVALID_NUMBER:
                System.out.println("The numbers you entered are invalid!");
                break;
            case INVALID_PASSWORD:
                System.out.println("The password is incorrect!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no account with this number!");
                break;
            case NOT_ENOUGH_BALANCE:
                System.out.println("You don't have enough balance!");
                break;
            case NOT_ENOUGH_BALANCE_DEPOSIT:
                System.out.println("You don't have enough balance to withdraw and pay penalty for withdrawing from deposit account!");
                break;
            case NOT_ALLOWED_MAX_AMOUNT_DAY:
                System.out.println("You are not allowed to withdraw from your card because you violate the max amount of withdraw in a day!");
                break;
            case WITHDRAW_SUCCESS:
                System.out.println("The money was successfully withdrawn!");
                break;
            case WITHDRAW_SUCCESS_DEPOSIT:
                System.out.println("The money was successfully withdrawn from deposit account!");
                System.out.println("Your deposit account was closed and your balance was transferred to your current account with account number = " + result.getValue() + "!");
                break;
        }
    }

    private void getAccountBalance(Matcher matcher) {
        ResultType result = manager.getAccountBalance(matcher.group(1), matcher.group(2));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case CARD_EXPIRED:
                System.out.println("You can't do anything with your card because your card is expired!");
                break;
            case INVALID_CARD_NUMBER:
                System.out.println("The card number is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("The bank doesn't exit!");
                break;
            case INVALID_PASSWORD:
                System.out.println("The password is incorrect!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no card with this number!");
                break;
            case GET_BALANCE_SUCCESS:
                System.out.println("The balance of your account is " + result.getValue() + "!");
                break;
        }
    }

    private void transferMoney(Matcher matcher) {
        ResultType result = manager.transferMoney(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case NOT_ALLOWED_PERSON_RECEIVER:
                System.out.println("The receiver has an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case CARD_EXPIRED:
                System.out.println("You can't do anything with your card because your card is expired!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case RECEIVER_ACCOUNT_DEPOSIT:
                System.out.println("You can't transfer money to deposit account!");
                break;
            case BANK_RECEIVER_NOT_EXISTED:
                System.out.println("The receiver bank doesn't exist!");
                break;
            case INVALID_CARD_NUMBER:
                System.out.println("The card number is invalid!");
                break;
            case INVALID_RECEIVER_CARD_NUMBER:
                System.out.println("The card number of receiver is invalid!");
                break;
            case INVALID_NUMBER:
                System.out.println("The numbers you entered are invalid!");
                break;
            case INVALID_PASSWORD:
                System.out.println("The password is incorrect!");
                break;
            case ACCOUNT_NOT_EXISTED:
                System.out.println("There is no account with this number!");
                break;
            case ACCOUNT_RECEIVER_NOT_EXISTED:
                System.out.println("There is no account with this number in the receiver bank!");
                break;
            case NOT_ENOUGH_BALANCE:
                System.out.println("You don't have enough balance!");
                break;
            case NOT_ENOUGH_BALANCE_DEPOSIT:
                System.out.println("You don't have enough balance to withdraw and pay penalty for withdrawing from deposit account!");
                break;
            case NOT_ALLOWED_MAX_AMOUNT_DAY:
                System.out.println("You are not allowed to transfer from your card because you violate the max amount of transfer in a day!");
                break;
            case TRANSFER_SUCCESS:
                System.out.println("The money was successfully transferred from your account to the receiver account!");
                break;
            case TRANSFER_SUCCESS_DEPOSIT:
                System.out.println("The money was successfully transferred from your deposit account to the receiver account!");
                System.out.println("Your deposit account was closed and your balance was transferred to your current account with account number = " + result.getValue() + "!");
                break;
        }
    }

    private void receiveLoan(Matcher matcher) {
        ResultType result = manager.receiveLoan(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case NOT_ALLOWED_PERSON:
                System.out.println("You have an overdue loan!");
                break;
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case LOW_AGE:
                System.out.println("Your age is under 18!");
                break;
            case INVALID_NUMBER:
                System.out.println("The numbers you entered are invalid!");
                break;
            case ACCOUNT_DEPOSIT:
                System.out.println("You can't receive loan because you have a deposit account!");
                break;
            case ACCOUNT_CURRENT:
                System.out.println("You can't receive loan because you don't have current account in this bank!");
                break;
            case INCOMPLETE_LOAN:
                System.out.println("You can't receive loan because you have an incomplete loan in this bank!");
                break;
            case NOT_ENOUGH_BALANCE:
                System.out.println("You can't receive loan because you don't have enough balance to receive loan!");
                break;
            case LOAN_SUCCESS:
                System.out.println("You received a loan successfully!");
                break;
        }
    }

    private void payOffTheLoan(Matcher matcher) {
        ResultType result = manager.payOffTheLoan(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case BANKRUPT:
                System.out.println("The bank is bankrupt!");
                break;
            case PERSON_NOT_EXISTED:
                System.out.println("There is no person or company with this id!");
                break;
            case BANK_INVALID:
                System.out.println("Your bank is invalid!");
                break;
            case BANK_NOT_EXISTED:
                System.out.println("Your bank doesn't exist!");
                break;
            case INVALID_NUMBER:
                System.out.println("The numbers you entered are invalid!");
                break;
            case PAY_LOAN_SUCCESS:
                System.out.println("Your pay was successful!");
                break;
            case LOAN_NOT_EXISTED:
                System.out.println("There is no loan for this person or company!");
                break;
            case LOAN_FINISH:
                System.out.println("Your loan is completed!");
                break;
        }
    }

    private void showAll(Matcher matcher) {
        System.out.println(manager.showAll(matcher.group(1).charAt(0)));
    }

    private void showDetail(Matcher matcher) {
        System.out.println(manager.showDetail(matcher.group(1).charAt(0), matcher.group(2)));
    }

    private void showBank(Matcher matcher) {
        System.out.println(manager.showBank(matcher.group(1).charAt(0), matcher.group(2)));
    }

    private void showCentralBank() {
        System.out.println(manager.showCentralBank());
    }

    private void showDate() {
        System.out.println("Today = " + manager.showDate());
    }

    private void go(Matcher matcher) {
        ResultType result = manager.go(matcher.group(1), matcher.group(2), matcher.group(3));
        switch (result) {
            case DATE_INCORRECT:
                System.out.println("Your date was incorrect!");
                break;
            case DATE_SUCCESS:
                System.out.println("Time was changed successfully!");
                break;
        }
    }

    public void run() {
        String command;
        Matcher matcher;
        while (!Commands.EXIT.getMatcher(command = scanner.nextLine()).matches()) {
            if ((matcher = Commands.ADD_PERSON.getMatcher(command)).matches()) {
                addPerson(matcher);
            } else if ((matcher = Commands.ADD_COMPANY.getMatcher(command)).matches()) {
                addCompany(matcher);
            } else if ((matcher = Commands.ADD_BANK.getMatcher(command)).matches()) {
                addBank(matcher);
            } else if ((matcher = Commands.SET_BANK_PARAMETER.getMatcher(command)).matches()) {
                setBankParameters(matcher);
            } else if ((matcher = Commands.OPEN_CURRENT_ACCOUNT.getMatcher(command)).matches()) {
                openCurrentAccount(matcher);
            } else if ((matcher = Commands.OPEN_DEPOSIT_ACCOUNT.getMatcher(command)).matches()) {
                openDepositAccount(matcher);
            } else if ((matcher = Commands.CLOSE_ACCOUNT.getMatcher(command)).matches()) {
                closeAccount(matcher);
            } else if ((matcher = Commands.SET_CARD_PARAMETER.getMatcher(command)).matches()) {
                setCardParameters(matcher);
            } else if ((matcher = Commands.EXTEND_EXPIRATION.getMatcher(command)).matches()) {
                extendCardExpiration(matcher);
            } else if ((matcher = Commands.DEPOSIT_MONEY.getMatcher(command)).matches()) {
                depositMoney(matcher);
            } else if ((matcher = Commands.WITHDRAW_MONEY.getMatcher(command)).matches()) {
                withdrawMoney(matcher);
            } else if ((matcher = Commands.GET_ACCOUNT_BALANCE.getMatcher(command)).matches()) {
                getAccountBalance(matcher);
            } else if ((matcher = Commands.TRANSFER_MONET_TO_ANOTHER_ACCOUNT.getMatcher(command)).matches()) {
                transferMoney(matcher);
            } else if ((matcher = Commands.RECEIVE_LOAN.getMatcher(command)).matches()) {
                receiveLoan(matcher);
            } else if ((matcher = Commands.PAY_OFF_THE_LOAN.getMatcher(command)).matches()) {
                payOffTheLoan(matcher);
            } else if ((matcher = Commands.GO.getMatcher(command)).matches()) {
                go(matcher);
            } else if ((matcher = Commands.SHOW_DETAIL.getMatcher(command)).matches()) {
                showDetail(matcher);
            } else if ((matcher = Commands.SHOW_ALL.getMatcher(command)).matches()) {
                showAll(matcher);
            } else if ((matcher = Commands.SHOW_BANK.getMatcher(command)).matches()) {
                showBank(matcher);
            } else if (Commands.SHOW_CENTRAL_BANK.getMatcher(command).matches()) {
                showCentralBank();
            } else if (Commands.SHOW_DATE.getMatcher(command).matches()) {
                showDate();
            } else {
                System.out.println("Illegal command!");
            }
        }
    }
}
