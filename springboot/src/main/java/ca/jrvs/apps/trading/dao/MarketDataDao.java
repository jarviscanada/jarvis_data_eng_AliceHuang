package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.utils.MarketDataConfig;
import ca.jrvs.apps.trading.model.IexQuote;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;

public class MarketDataDao implements CrudRepository<IexQuote, String> {
  private static final String IEX_BATCH_PATH = "/stock/market/batch?types=quote&token=";
  private final String IEX_BATCH_URL;

  private final Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
  private HttpClientConnectionManager httpClientConnectionManager;

  public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig) {
    IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
    this.httpClientConnectionManager = httpClientConnectionManager;
  }

  /**
   * Get an IexQuote (helper method which class findById)
   *
   * @param ticker
   * @throws IllegalArgumentException if a given ticker is invalid
   * @throws DataRetrievalFailureException if HTTP request failed
   * @return
   */
  @Override
  public Optional<IexQuote> findById(String ticker) {
    Optional<IexQuote> iexQuote;
    List<IexQuote> quotes = findAllById(Collections.singletonList(ticker));

    if (quotes.size() == 0) {
      return Optional.empty();
    } else if (quotes.size() == 1) {
      iexQuote = Optional.of(quotes.get(0));
    } else {
      throw new DataRetrievalFailureException("Unexpected number of quotes");
    }
    return iexQuote;
  }
  /**
   * Get quotes from IEX
   * @param tickers is a list of tickers
   * @return a list of IexQuote Object
   * @throws IllegalArgumentException if any ticker is invalid or tickers is empty
   * @throws DataRetrievalFailureException if HTTP request failed
   */
  @Override
  public List<IexQuote> findAllById(Iterable<String> tickers) {
    int tickers_size = 0;
    StringBuffer url = new StringBuffer(IEX_BATCH_URL + "&symbols=");
    for (String ticker : tickers) {
      url.append(ticker).append(",");
      tickers_size++;
    }

    String response = executeHttpGet(url.toString())
        .orElseThrow(() -> new IllegalArgumentException("Invalid ticker" + url.toString()));
    JSONObject jsonObject = new JSONObject(response);

    //check and set length
    if (jsonObject.length() != tickers_size) {
      throw new IllegalArgumentException("Invalid ticker");
    }
    int size = jsonObject.length();

    ObjectMapper mapper = new ObjectMapper(); //create object mapper
    JSONArray names = jsonObject.names();
    JSONArray array = jsonObject.toJSONArray(names); //json array of quotes
    List<IexQuote> quotes = new ArrayList<>(); //return list

    for (int i = 0; i < size; i++) {
      JSONObject quoteJson = (JSONObject) array.get(i);
      String stringValue = quoteJson.opt("quote").toString();
      try {
        quotes.add(mapper.readValue(stringValue, IexQuote.class));
      } catch (IOException e) {
        logger.error("Unable to deserialize quote json to java object");
      }
    }
    return quotes;
  }
  /**
   * Execute a get and return http entity/body as a string
   *
   * @param url resource url
   * @return http response body or Optional.empty for 404 response
   * @throws DataRetrievalFailureException if http failed or status code is unexpected
   **/
  private Optional<String> executeHttpGet(String url){
    HttpClient httpClient = getHttpClient();
    HttpGet get = new HttpGet(url);

    try {
      HttpResponse response = httpClient.execute(get);
      int status = response.getStatusLine().getStatusCode();

      if (status != 200) {
        return Optional.empty();
      }
      return Optional.ofNullable(EntityUtils.toString(response.getEntity()));
    } catch (IOException e) {
      throw new DataRetrievalFailureException("http request failed");
    }
  }

  private CloseableHttpClient getHttpClient(){
    return HttpClients.custom()
        .setConnectionManager(httpClientConnectionManager)
        .setConnectionManagerShared(true)
        .build();
  }


  /**
   * @param s
   * @return
   */
  @Override
  public boolean existsById(String s) {
    return false;
  }

  /**
   * @return
   */
  @Override
  public Iterable<IexQuote> findAll() {
    return null;
  }



  /**
   * @return
   */
  @Override
  public long count() {
    return 0;
  }

  /**
   * @param s
   */
  @Override
  public void deleteById(String s) {

  }

  /**
   * @param iexQuote
   */
  @Override
  public void delete(IexQuote iexQuote) {

  }

  /**
   * @param iterable
   */
  @Override
  public void deleteAll(Iterable<? extends IexQuote> iterable) {

  }

  /**
   *
   */
  @Override
  public void deleteAll() {

  }

  /**
   * @param s
   * @param <S>
   * @return
   */
  @Override
  public <S extends IexQuote> S save(S s) {
    return null;
  }

  /**
   * @param iterable
   * @param <S>
   * @return
   */
  @Override
  public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> iterable) {
    return null;
  }
}
