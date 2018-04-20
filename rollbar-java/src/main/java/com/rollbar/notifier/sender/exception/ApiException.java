package com.rollbar.notifier.sender.exception;

import com.rollbar.notifier.sender.result.Response;
import com.rollbar.notifier.util.ObjectsUtils;

/**
 * Represents an error return by the Rollbar API.
 */
public class ApiException extends RuntimeException {

  private final Response response;

  /**
   * Constructor.
   * @param response the response.
   */
  public ApiException(Response response) {
    super(response.getResult().getContent());
    this.response = response;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiException that = (ApiException) o;
    return ObjectsUtils.equals(response, that.response);
  }

  @Override
  public int hashCode() {
    return ObjectsUtils.hash(response);
  }
}
