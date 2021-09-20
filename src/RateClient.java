import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Given a method RateClient::fetchRateFromProvider,
 that fetches foreign currency exchange rate from
 a rate provider via REST,implement RateClient::getRate.
 Exchange rates change once a minute.
 The method will be called 10 times a second by multiple threads.

 Examples:
 EUR, USD -> 1.18 (1 EUR == 1.18 USD)
 USD, GBP -> 0.72 (1 USD == 0.72 GBP)
 */



@RequiredArgsConstructor
class RateClient {

  private Map<String, RateResponse> currencyCache = new ConcurrentHashMap<>();

  public BigDecimal getRate( Currency first, Currency second) {
    final String key = first.getDisplayName() + second.getDisplayName();

      if (currencyCache.containsKey(key)) {
        final RateResponse rateResponse = currencyCache.get(key);
        if (Instant.now().isBefore(rateResponse.getTimestamp())) {
          return rateResponse.getRate();
        }
      }
    RateResponse rate;
    synchronized (key) {
      rate = fetchRateFromProvider(first, second);
    }
    currencyCache.put(key, rate);
    return rate.getRate();
  }

  private RateResponse fetchRateFromProvider(Currency first, Currency second) {
    // no need to implement, just complete the method signature
    // takes 2 currencies as a parameter
    // fetches exchange rate by making a REST call to a rate provider
    // returns the exchange rate
    return null;
  }

  class RateResponse {
    private BigDecimal rate;
    private Instant timestamp;

    private RateResponse(BigDecimal rate, Instant timestamp) {
      this.rate = rate;
      this.timestamp = timestamp;
    }

    private BigDecimal getRate() {
      return rate;
    }

    private void setRate(BigDecimal rate) {
      this.rate = rate;
    }

    private Instant getTimestamp() {
      return timestamp;
    }

    private void setTimestamp(Instant timestamp) {
      this.timestamp = timestamp;
    }
  }
}
