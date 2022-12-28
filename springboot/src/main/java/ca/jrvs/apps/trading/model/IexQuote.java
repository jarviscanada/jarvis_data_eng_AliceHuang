package ca.jrvs.apps.trading.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "symbol",
    "companyName",
    "sector",
    "calculationPrice",
    "open",
    "openTime",
    "close",
    "closeTime",
    "high",
    "low",
    "latestPrice",
    "latestSource",
    "latestTime",
    "latestUpdate",
    "latestVolume",
    "iexRealtimePrice",
    "iexRealtimeSize",
    "iexLastUpdated",
    "delayedPrice",
    "delayedPriceTime",
    "extendedPrice",
    "extendedChange",
    "extendedChangePercent",
    "extendedPriceTime",
    "previousClose",
    "change",
    "changePercent",
    "iexMarketPercent",
    "iexVolume",
    "avgTotalVolume",
    "iexBidPrice",
    "iexBidSize",
    "iexAskPrice",
    "iexAskSize",
    "marketCap",
    "peRatio",
    "week52High",
    "week52Low",
    "ytdChange"
})
@Generated("jsonschema2pojo")
public class IexQuote {

  @JsonProperty("symbol")
  private String symbol;
  @JsonProperty("companyName")
  private String companyName;
  @JsonProperty("sector")
  private String sector;
  @JsonProperty("calculationPrice")
  private String calculationPrice;
  @JsonProperty("open")
  private double open;
  @JsonProperty("openTime")
  private long openTime;
  @JsonProperty("close")
  private double close;
  @JsonProperty("closeTime")
  private long closeTime;
  @JsonProperty("high")
  private double high;
  @JsonProperty("low")
  private double low;
  @JsonProperty("latestPrice")
  private double latestPrice;
  @JsonProperty("latestSource")
  private String latestSource;
  @JsonProperty("latestTime")
  private String latestTime;
  @JsonProperty("latestUpdate")
  private long latestUpdate;
  @JsonProperty("latestVolume")
  private long latestVolume;
  @JsonProperty("iexRealtimePrice")
  private double iexRealtimePrice;
  @JsonProperty("iexRealtimeSize")
  private long iexRealtimeSize;
  @JsonProperty("iexLastUpdated")
  private long iexLastUpdated;
  @JsonProperty("delayedPrice")
  private double delayedPrice;
  @JsonProperty("delayedPriceTime")
  private long delayedPriceTime;
  @JsonProperty("extendedPrice")
  private double extendedPrice;
  @JsonProperty("extendedChange")
  private double extendedChange;
  @JsonProperty("extendedChangePercent")
  private double extendedChangePercent;
  @JsonProperty("extendedPriceTime")
  private long extendedPriceTime;
  @JsonProperty("previousClose")
  private double previousClose;
  @JsonProperty("change")
  private double change;
  @JsonProperty("changePercent")
  private double changePercent;
  @JsonProperty("iexMarketPercent")
  private double iexMarketPercent;
  @JsonProperty("iexVolume")
  private double iexVolume;
  @JsonProperty("avgTotalVolume")
  private long avgTotalVolume;
  @JsonProperty("iexBidPrice")
  private double iexBidPrice;
  @JsonProperty("iexBidSize")
  private long iexBidSize;
  @JsonProperty("iexAskPrice")
  private double iexAskPrice;
  @JsonProperty("iexAskSize")
  private long iexAskSize;
  @JsonProperty("marketCap")
  private long marketCap;
  @JsonProperty("peRatio")
  private double peRatio;
  @JsonProperty("week52High")
  private double week52High;
  @JsonProperty("week52Low")
  private double week52Low;
  @JsonProperty("ytdChange")
  private double ytdChange;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   *
   */
  public IexQuote() {
  }

  /**
   *
   * @param symbol
   * @param avgTotalVolume
   * @param companyName
   * @param iexRealtimePrice
   * @param delayedPrice
   * @param iexMarketPercent
   * @param calculationPrice
   * @param extendedChangePercent
   * @param latestSource
   * @param latestUpdate
   * @param iexBidPrice
   * @param previousClose
   * @param high
   * @param peRatio
   * @param low
   * @param delayedPriceTime
   * @param extendedPrice
   * @param extendedPriceTime
   * @param week52Low
   * @param closeTime
   * @param changePercent
   * @param week52High
   * @param openTime
   * @param sector
   * @param close
   * @param latestPrice
   * @param marketCap
   * @param iexRealtimeSize
   * @param iexLastUpdated
   * @param change
   * @param latestVolume
   * @param iexAskPrice
   * @param ytdChange
   * @param iexVolume
   * @param iexAskSize
   * @param extendedChange
   * @param latestTime
   * @param open
   * @param iexBidSize
   */
  public IexQuote(String symbol, String companyName, String sector, String calculationPrice, double open, long openTime, double close, long closeTime, double high, double low, double latestPrice, String latestSource, String latestTime, long latestUpdate, long latestVolume, double iexRealtimePrice, long iexRealtimeSize, long iexLastUpdated, double delayedPrice, long delayedPriceTime, double extendedPrice, double extendedChange, double extendedChangePercent, long extendedPriceTime, double previousClose, double change, double changePercent, double iexMarketPercent, double iexVolume, long avgTotalVolume, double iexBidPrice, long iexBidSize, double iexAskPrice, long iexAskSize, long marketCap, double peRatio, double week52High, double week52Low, double ytdChange) {
    super();
    this.symbol = symbol;
    this.companyName = companyName;
    this.sector = sector;
    this.calculationPrice = calculationPrice;
    this.open = open;
    this.openTime = openTime;
    this.close = close;
    this.closeTime = closeTime;
    this.high = high;
    this.low = low;
    this.latestPrice = latestPrice;
    this.latestSource = latestSource;
    this.latestTime = latestTime;
    this.latestUpdate = latestUpdate;
    this.latestVolume = latestVolume;
    this.iexRealtimePrice = iexRealtimePrice;
    this.iexRealtimeSize = iexRealtimeSize;
    this.iexLastUpdated = iexLastUpdated;
    this.delayedPrice = delayedPrice;
    this.delayedPriceTime = delayedPriceTime;
    this.extendedPrice = extendedPrice;
    this.extendedChange = extendedChange;
    this.extendedChangePercent = extendedChangePercent;
    this.extendedPriceTime = extendedPriceTime;
    this.previousClose = previousClose;
    this.change = change;
    this.changePercent = changePercent;
    this.iexMarketPercent = iexMarketPercent;
    this.iexVolume = iexVolume;
    this.avgTotalVolume = avgTotalVolume;
    this.iexBidPrice = iexBidPrice;
    this.iexBidSize = iexBidSize;
    this.iexAskPrice = iexAskPrice;
    this.iexAskSize = iexAskSize;
    this.marketCap = marketCap;
    this.peRatio = peRatio;
    this.week52High = week52High;
    this.week52Low = week52Low;
    this.ytdChange = ytdChange;
  }

  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }

  @JsonProperty("symbol")
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public IexQuote withSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  @JsonProperty("companyName")
  public String getCompanyName() {
    return companyName;
  }

  @JsonProperty("companyName")
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public IexQuote withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  @JsonProperty("sector")
  public String getSector() {
    return sector;
  }

  @JsonProperty("sector")
  public void setSector(String sector) {
    this.sector = sector;
  }

  public IexQuote withSector(String sector) {
    this.sector = sector;
    return this;
  }

  @JsonProperty("calculationPrice")
  public String getCalculationPrice() {
    return calculationPrice;
  }

  @JsonProperty("calculationPrice")
  public void setCalculationPrice(String calculationPrice) {
    this.calculationPrice = calculationPrice;
  }

  public IexQuote withCalculationPrice(String calculationPrice) {
    this.calculationPrice = calculationPrice;
    return this;
  }

  @JsonProperty("open")
  public double getOpen() {
    return open;
  }

  @JsonProperty("open")
  public void setOpen(double open) {
    this.open = open;
  }

  public IexQuote withOpen(double open) {
    this.open = open;
    return this;
  }

  @JsonProperty("openTime")
  public long getOpenTime() {
    return openTime;
  }

  @JsonProperty("openTime")
  public void setOpenTime(long openTime) {
    this.openTime = openTime;
  }

  public IexQuote withOpenTime(long openTime) {
    this.openTime = openTime;
    return this;
  }

  @JsonProperty("close")
  public double getClose() {
    return close;
  }

  @JsonProperty("close")
  public void setClose(double close) {
    this.close = close;
  }

  public IexQuote withClose(double close) {
    this.close = close;
    return this;
  }

  @JsonProperty("closeTime")
  public long getCloseTime() {
    return closeTime;
  }

  @JsonProperty("closeTime")
  public void setCloseTime(long closeTime) {
    this.closeTime = closeTime;
  }

  public IexQuote withCloseTime(long closeTime) {
    this.closeTime = closeTime;
    return this;
  }

  @JsonProperty("high")
  public double getHigh() {
    return high;
  }

  @JsonProperty("high")
  public void setHigh(double high) {
    this.high = high;
  }

  public IexQuote withHigh(double high) {
    this.high = high;
    return this;
  }

  @JsonProperty("low")
  public double getLow() {
    return low;
  }

  @JsonProperty("low")
  public void setLow(double low) {
    this.low = low;
  }

  public IexQuote withLow(double low) {
    this.low = low;
    return this;
  }

  @JsonProperty("latestPrice")
  public double getLatestPrice() {
    return latestPrice;
  }

  @JsonProperty("latestPrice")
  public void setLatestPrice(double latestPrice) {
    this.latestPrice = latestPrice;
  }

  public IexQuote withLatestPrice(double latestPrice) {
    this.latestPrice = latestPrice;
    return this;
  }

  @JsonProperty("latestSource")
  public String getLatestSource() {
    return latestSource;
  }

  @JsonProperty("latestSource")
  public void setLatestSource(String latestSource) {
    this.latestSource = latestSource;
  }

  public IexQuote withLatestSource(String latestSource) {
    this.latestSource = latestSource;
    return this;
  }

  @JsonProperty("latestTime")
  public String getLatestTime() {
    return latestTime;
  }

  @JsonProperty("latestTime")
  public void setLatestTime(String latestTime) {
    this.latestTime = latestTime;
  }

  public IexQuote withLatestTime(String latestTime) {
    this.latestTime = latestTime;
    return this;
  }

  @JsonProperty("latestUpdate")
  public long getLatestUpdate() {
    return latestUpdate;
  }

  @JsonProperty("latestUpdate")
  public void setLatestUpdate(long latestUpdate) {
    this.latestUpdate = latestUpdate;
  }

  public IexQuote withLatestUpdate(long latestUpdate) {
    this.latestUpdate = latestUpdate;
    return this;
  }

  @JsonProperty("latestVolume")
  public long getLatestVolume() {
    return latestVolume;
  }

  @JsonProperty("latestVolume")
  public void setLatestVolume(long latestVolume) {
    this.latestVolume = latestVolume;
  }

  public IexQuote withLatestVolume(long latestVolume) {
    this.latestVolume = latestVolume;
    return this;
  }

  @JsonProperty("iexRealtimePrice")
  public double getIexRealtimePrice() {
    return iexRealtimePrice;
  }

  @JsonProperty("iexRealtimePrice")
  public void setIexRealtimePrice(double iexRealtimePrice) {
    this.iexRealtimePrice = iexRealtimePrice;
  }

  public IexQuote withIexRealtimePrice(double iexRealtimePrice) {
    this.iexRealtimePrice = iexRealtimePrice;
    return this;
  }

  @JsonProperty("iexRealtimeSize")
  public long getIexRealtimeSize() {
    return iexRealtimeSize;
  }

  @JsonProperty("iexRealtimeSize")
  public void setIexRealtimeSize(long iexRealtimeSize) {
    this.iexRealtimeSize = iexRealtimeSize;
  }

  public IexQuote withIexRealtimeSize(long iexRealtimeSize) {
    this.iexRealtimeSize = iexRealtimeSize;
    return this;
  }

  @JsonProperty("iexLastUpdated")
  public long getIexLastUpdated() {
    return iexLastUpdated;
  }

  @JsonProperty("iexLastUpdated")
  public void setIexLastUpdated(long iexLastUpdated) {
    this.iexLastUpdated = iexLastUpdated;
  }

  public IexQuote withIexLastUpdated(long iexLastUpdated) {
    this.iexLastUpdated = iexLastUpdated;
    return this;
  }

  @JsonProperty("delayedPrice")
  public double getDelayedPrice() {
    return delayedPrice;
  }

  @JsonProperty("delayedPrice")
  public void setDelayedPrice(double delayedPrice) {
    this.delayedPrice = delayedPrice;
  }

  public IexQuote withDelayedPrice(double delayedPrice) {
    this.delayedPrice = delayedPrice;
    return this;
  }

  @JsonProperty("delayedPriceTime")
  public long getDelayedPriceTime() {
    return delayedPriceTime;
  }

  @JsonProperty("delayedPriceTime")
  public void setDelayedPriceTime(long delayedPriceTime) {
    this.delayedPriceTime = delayedPriceTime;
  }

  public IexQuote withDelayedPriceTime(long delayedPriceTime) {
    this.delayedPriceTime = delayedPriceTime;
    return this;
  }

  @JsonProperty("extendedPrice")
  public double getExtendedPrice() {
    return extendedPrice;
  }

  @JsonProperty("extendedPrice")
  public void setExtendedPrice(double extendedPrice) {
    this.extendedPrice = extendedPrice;
  }

  public IexQuote withExtendedPrice(double extendedPrice) {
    this.extendedPrice = extendedPrice;
    return this;
  }

  @JsonProperty("extendedChange")
  public double getExtendedChange() {
    return extendedChange;
  }

  @JsonProperty("extendedChange")
  public void setExtendedChange(double extendedChange) {
    this.extendedChange = extendedChange;
  }

  public IexQuote withExtendedChange(double extendedChange) {
    this.extendedChange = extendedChange;
    return this;
  }

  @JsonProperty("extendedChangePercent")
  public double getExtendedChangePercent() {
    return extendedChangePercent;
  }

  @JsonProperty("extendedChangePercent")
  public void setExtendedChangePercent(double extendedChangePercent) {
    this.extendedChangePercent = extendedChangePercent;
  }

  public IexQuote withExtendedChangePercent(double extendedChangePercent) {
    this.extendedChangePercent = extendedChangePercent;
    return this;
  }

  @JsonProperty("extendedPriceTime")
  public long getExtendedPriceTime() {
    return extendedPriceTime;
  }

  @JsonProperty("extendedPriceTime")
  public void setExtendedPriceTime(long extendedPriceTime) {
    this.extendedPriceTime = extendedPriceTime;
  }

  public IexQuote withExtendedPriceTime(long extendedPriceTime) {
    this.extendedPriceTime = extendedPriceTime;
    return this;
  }

  @JsonProperty("previousClose")
  public double getPreviousClose() {
    return previousClose;
  }

  @JsonProperty("previousClose")
  public void setPreviousClose(double previousClose) {
    this.previousClose = previousClose;
  }

  public IexQuote withPreviousClose(double previousClose) {
    this.previousClose = previousClose;
    return this;
  }

  @JsonProperty("change")
  public double getChange() {
    return change;
  }

  @JsonProperty("change")
  public void setChange(double change) {
    this.change = change;
  }

  public IexQuote withChange(double change) {
    this.change = change;
    return this;
  }

  @JsonProperty("changePercent")
  public double getChangePercent() {
    return changePercent;
  }

  @JsonProperty("changePercent")
  public void setChangePercent(double changePercent) {
    this.changePercent = changePercent;
  }

  public IexQuote withChangePercent(double changePercent) {
    this.changePercent = changePercent;
    return this;
  }

  @JsonProperty("iexMarketPercent")
  public double getIexMarketPercent() {
    return iexMarketPercent;
  }

  @JsonProperty("iexMarketPercent")
  public void setIexMarketPercent(double iexMarketPercent) {
    this.iexMarketPercent = iexMarketPercent;
  }

  public IexQuote withIexMarketPercent(double iexMarketPercent) {
    this.iexMarketPercent = iexMarketPercent;
    return this;
  }

  @JsonProperty("iexVolume")
  public double getIexVolume() {
    return iexVolume;
  }

  @JsonProperty("iexVolume")
  public void setIexVolume(double iexVolume) {
    this.iexVolume = iexVolume;
  }

  public IexQuote withIexVolume(double iexVolume) {
    this.iexVolume = iexVolume;
    return this;
  }

  @JsonProperty("avgTotalVolume")
  public long getAvgTotalVolume() {
    return avgTotalVolume;
  }

  @JsonProperty("avgTotalVolume")
  public void setAvgTotalVolume(long avgTotalVolume) {
    this.avgTotalVolume = avgTotalVolume;
  }

  public IexQuote withAvgTotalVolume(long avgTotalVolume) {
    this.avgTotalVolume = avgTotalVolume;
    return this;
  }

  @JsonProperty("iexBidPrice")
  public double getIexBidPrice() {
    return iexBidPrice;
  }

  @JsonProperty("iexBidPrice")
  public void setIexBidPrice(double iexBidPrice) {
    this.iexBidPrice = iexBidPrice;
  }

  public IexQuote withIexBidPrice(double iexBidPrice) {
    this.iexBidPrice = iexBidPrice;
    return this;
  }

  @JsonProperty("iexBidSize")
  public long getIexBidSize() {
    return iexBidSize;
  }

  @JsonProperty("iexBidSize")
  public void setIexBidSize(long iexBidSize) {
    this.iexBidSize = iexBidSize;
  }

  public IexQuote withIexBidSize(long iexBidSize) {
    this.iexBidSize = iexBidSize;
    return this;
  }

  @JsonProperty("iexAskPrice")
  public double getIexAskPrice() {
    return iexAskPrice;
  }

  @JsonProperty("iexAskPrice")
  public void setIexAskPrice(double iexAskPrice) {
    this.iexAskPrice = iexAskPrice;
  }

  public IexQuote withIexAskPrice(double iexAskPrice) {
    this.iexAskPrice = iexAskPrice;
    return this;
  }

  @JsonProperty("iexAskSize")
  public long getIexAskSize() {
    return iexAskSize;
  }

  @JsonProperty("iexAskSize")
  public void setIexAskSize(long iexAskSize) {
    this.iexAskSize = iexAskSize;
  }

  public IexQuote withIexAskSize(long iexAskSize) {
    this.iexAskSize = iexAskSize;
    return this;
  }

  @JsonProperty("marketCap")
  public long getMarketCap() {
    return marketCap;
  }

  @JsonProperty("marketCap")
  public void setMarketCap(long marketCap) {
    this.marketCap = marketCap;
  }

  public IexQuote withMarketCap(long marketCap) {
    this.marketCap = marketCap;
    return this;
  }

  @JsonProperty("peRatio")
  public double getPeRatio() {
    return peRatio;
  }

  @JsonProperty("peRatio")
  public void setPeRatio(double peRatio) {
    this.peRatio = peRatio;
  }

  public IexQuote withPeRatio(double peRatio) {
    this.peRatio = peRatio;
    return this;
  }

  @JsonProperty("week52High")
  public double getWeek52High() {
    return week52High;
  }

  @JsonProperty("week52High")
  public void setWeek52High(double week52High) {
    this.week52High = week52High;
  }

  public IexQuote withWeek52High(double week52High) {
    this.week52High = week52High;
    return this;
  }

  @JsonProperty("week52Low")
  public double getWeek52Low() {
    return week52Low;
  }

  @JsonProperty("week52Low")
  public void setWeek52Low(double week52Low) {
    this.week52Low = week52Low;
  }

  public IexQuote withWeek52Low(double week52Low) {
    this.week52Low = week52Low;
    return this;
  }

  @JsonProperty("ytdChange")
  public double getYtdChange() {
    return ytdChange;
  }

  @JsonProperty("ytdChange")
  public void setYtdChange(double ytdChange) {
    this.ytdChange = ytdChange;
  }

  public IexQuote withYtdChange(double ytdChange) {
    this.ytdChange = ytdChange;
    return this;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public IexQuote withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(IexQuote.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("symbol");
    sb.append('=');
    sb.append(((this.symbol == null)?"<null>":this.symbol));
    sb.append(',');
    sb.append("companyName");
    sb.append('=');
    sb.append(((this.companyName == null)?"<null>":this.companyName));
    sb.append(',');
    sb.append("sector");
    sb.append('=');
    sb.append(((this.sector == null)?"<null>":this.sector));
    sb.append(',');
    sb.append("calculationPrice");
    sb.append('=');
    sb.append(((this.calculationPrice == null)?"<null>":this.calculationPrice));
    sb.append(',');
    sb.append("open");
    sb.append('=');
    sb.append(this.open);
    sb.append(',');
    sb.append("openTime");
    sb.append('=');
    sb.append(this.openTime);
    sb.append(',');
    sb.append("close");
    sb.append('=');
    sb.append(this.close);
    sb.append(',');
    sb.append("closeTime");
    sb.append('=');
    sb.append(this.closeTime);
    sb.append(',');
    sb.append("high");
    sb.append('=');
    sb.append(this.high);
    sb.append(',');
    sb.append("low");
    sb.append('=');
    sb.append(this.low);
    sb.append(',');
    sb.append("latestPrice");
    sb.append('=');
    sb.append(this.latestPrice);
    sb.append(',');
    sb.append("latestSource");
    sb.append('=');
    sb.append(((this.latestSource == null)?"<null>":this.latestSource));
    sb.append(',');
    sb.append("latestTime");
    sb.append('=');
    sb.append(((this.latestTime == null)?"<null>":this.latestTime));
    sb.append(',');
    sb.append("latestUpdate");
    sb.append('=');
    sb.append(this.latestUpdate);
    sb.append(',');
    sb.append("latestVolume");
    sb.append('=');
    sb.append(this.latestVolume);
    sb.append(',');
    sb.append("iexRealtimePrice");
    sb.append('=');
    sb.append(this.iexRealtimePrice);
    sb.append(',');
    sb.append("iexRealtimeSize");
    sb.append('=');
    sb.append(this.iexRealtimeSize);
    sb.append(',');
    sb.append("iexLastUpdated");
    sb.append('=');
    sb.append(this.iexLastUpdated);
    sb.append(',');
    sb.append("delayedPrice");
    sb.append('=');
    sb.append(this.delayedPrice);
    sb.append(',');
    sb.append("delayedPriceTime");
    sb.append('=');
    sb.append(this.delayedPriceTime);
    sb.append(',');
    sb.append("extendedPrice");
    sb.append('=');
    sb.append(this.extendedPrice);
    sb.append(',');
    sb.append("extendedChange");
    sb.append('=');
    sb.append(this.extendedChange);
    sb.append(',');
    sb.append("extendedChangePercent");
    sb.append('=');
    sb.append(this.extendedChangePercent);
    sb.append(',');
    sb.append("extendedPriceTime");
    sb.append('=');
    sb.append(this.extendedPriceTime);
    sb.append(',');
    sb.append("previousClose");
    sb.append('=');
    sb.append(this.previousClose);
    sb.append(',');
    sb.append("change");
    sb.append('=');
    sb.append(this.change);
    sb.append(',');
    sb.append("changePercent");
    sb.append('=');
    sb.append(this.changePercent);
    sb.append(',');
    sb.append("iexMarketPercent");
    sb.append('=');
    sb.append(this.iexMarketPercent);
    sb.append(',');
    sb.append("iexVolume");
    sb.append('=');
    sb.append(this.iexVolume);
    sb.append(',');
    sb.append("avgTotalVolume");
    sb.append('=');
    sb.append(this.avgTotalVolume);
    sb.append(',');
    sb.append("iexBidPrice");
    sb.append('=');
    sb.append(this.iexBidPrice);
    sb.append(',');
    sb.append("iexBidSize");
    sb.append('=');
    sb.append(this.iexBidSize);
    sb.append(',');
    sb.append("iexAskPrice");
    sb.append('=');
    sb.append(this.iexAskPrice);
    sb.append(',');
    sb.append("iexAskSize");
    sb.append('=');
    sb.append(this.iexAskSize);
    sb.append(',');
    sb.append("marketCap");
    sb.append('=');
    sb.append(this.marketCap);
    sb.append(',');
    sb.append("peRatio");
    sb.append('=');
    sb.append(this.peRatio);
    sb.append(',');
    sb.append("week52High");
    sb.append('=');
    sb.append(this.week52High);
    sb.append(',');
    sb.append("week52Low");
    sb.append('=');
    sb.append(this.week52Low);
    sb.append(',');
    sb.append("ytdChange");
    sb.append('=');
    sb.append(this.ytdChange);
    sb.append(',');
    sb.append("additionalProperties");
    sb.append('=');
    sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
    sb.append(',');
    if (sb.charAt((sb.length()- 1)) == ',') {
      sb.setCharAt((sb.length()- 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}