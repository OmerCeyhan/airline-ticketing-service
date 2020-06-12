package com.airline.ticketservice.ticket;

import com.airline.ticketservice.exception.BadRequestException;
import com.airline.ticketservice.util.TicketUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TicketTests {

    @Test
    public void calculateTicketPriceTest() {
        BigDecimal basePrice = new BigDecimal("100.00");
        Assert.assertEquals(basePrice, TicketUtils.calculateTicketPrice(basePrice, 100, 1));
        Assert.assertEquals(basePrice, TicketUtils.calculateTicketPrice(basePrice, 100, 8));
        Assert.assertEquals(new BigDecimal("110.00"), TicketUtils.calculateTicketPrice(basePrice, 100, 15));
        Assert.assertEquals(new BigDecimal("121.00"), TicketUtils.calculateTicketPrice(basePrice, 100, 21));

        basePrice = basePrice.add(BigDecimal.valueOf(5));
        Assert.assertEquals(basePrice, TicketUtils.calculateTicketPrice(basePrice, 100, 7));
        Assert.assertEquals(new BigDecimal("115.50"), TicketUtils.calculateTicketPrice(basePrice, 100, 16));

    }

    @Test
    public void formatCreditCardNumberTest(){
        String expectedCreditCardFormat = "123412******1234";
        Assert.assertEquals(expectedCreditCardFormat,TicketUtils.formatCreditCardNumber("1234-1234-1234-1234"));
        Assert.assertEquals(expectedCreditCardFormat,TicketUtils.formatCreditCardNumber("1234,1234,1234,1234"));
        Assert.assertEquals(expectedCreditCardFormat,TicketUtils.formatCreditCardNumber("1234 1234 1234 1234"));
        Assert.assertEquals(expectedCreditCardFormat,TicketUtils.formatCreditCardNumber("1234_1234_1234_1234"));
    }

    @Test(expected = BadRequestException.class)
    public void InvalidCreditCardFormatTest(){
        String falseCreditCardFormat = "123412******12349999";
        TicketUtils.formatCreditCardNumber(falseCreditCardFormat);
    }


}
