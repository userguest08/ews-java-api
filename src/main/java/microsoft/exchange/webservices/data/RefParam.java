package microsoft.exchange.webservices.data;

/**
 * The Class RefParam.
 *
 * @param <T> the generic type
 */
public class RefParam<T> extends Param<T> {

  /**
   * Instantiates a new ref param.
   *
   * @param param the param
   */
  public RefParam(T param) {
    this.setParam(param);
  }
}
