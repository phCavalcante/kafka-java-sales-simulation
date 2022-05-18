package util;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 19:12
 */

public enum SaleStatus {

  APPROVED("Approved"),
  FAILED("Failed");

  private String status;

  private SaleStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public static SaleStatus toEnum(String status) {

    if (status == null) {
      return null;
    }

    for (SaleStatus saleStatus: SaleStatus.values()) {
          if (status.equals(saleStatus.getStatus())) {
            return saleStatus;
          }
    }
    throw new IllegalArgumentException("Invalid status: " + status);
  }
}
