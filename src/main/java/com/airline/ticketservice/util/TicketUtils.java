package com.airline.ticketservice.util;

import com.airline.ticketservice.exception.BadRequestException;
import com.airline.ticketservice.type.ErrorMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.airline.ticketservice.constant.TicketConstants.*;

public class TicketUtils {

    /**
     * @param basePrice         Flight's defined initial ticket price.
     * @param customerQuota     Flight's customer capasity.
     * @param numberOfCustomers Number of bought ticket to that flight at the moment.
     * @return currentPrice  It adds up 10% more to its current value for every %10 increase in customer quota and returns it.
     */

    public static BigDecimal calculateTicketPrice(BigDecimal basePrice, Integer customerQuota, Integer numberOfCustomers) {
        float percentageIncrease = ((float) numberOfCustomers / customerQuota) * 100;
        if (percentageIncrease < 10) {
            return basePrice;
        }
        int timesOfIncrease = (int) percentageIncrease / 10; //pruning units and fractions.
        BigDecimal currentPrice = new BigDecimal(String.valueOf(basePrice));
        for (int i = 0; i < timesOfIncrease; i++) {
            BigDecimal tenPercentOfCurrentPrice = currentPrice.divide(BigDecimal.valueOf(100.00), BigDecimal.ROUND_DOWN);
            tenPercentOfCurrentPrice = tenPercentOfCurrentPrice.multiply(BigDecimal.valueOf(10.00));
            currentPrice = currentPrice.add(tenPercentOfCurrentPrice);
        }
        return currentPrice.setScale(2, RoundingMode.HALF_DOWN);
    }

    public static String formatCreditCardNumber(String creditCartNumber) {
        creditCartNumber = removeSpecialCharacters(creditCartNumber);
        if (creditCartNumber.length() != CREDIT_CART_NUMBER_LENGTH) {
            throw new BadRequestException(ErrorMessage.FALSE_CREDIT_CARD_FORMAT);
        }
        creditCartNumber = hideCreditCardNumberDigits(creditCartNumber);
        return creditCartNumber;
    }


    private static String removeSpecialCharacters(String creditCartNumber) {
        return creditCartNumber.replaceAll(NOT_A_DIGIT_REGEX, "");
    }

    private static String hideCreditCardNumberDigits(String creditCartNumber) {
        return creditCartNumber.substring(0, 6) + STAR_CHARACTERS + creditCartNumber.substring(12, 16);
    }

}
