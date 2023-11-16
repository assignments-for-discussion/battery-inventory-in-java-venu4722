package bunchbysoh;


public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  }

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for (int capacity : presentCapacities) {
        double soh = calculateSoH(capacity, 120);  //Assuming ratedCapacity as 120

        if (soh > 80 && soh <= 100) {
            counts.healthy++;
        } else if (soh >= 62 && soh <= 80) {
            counts.exchange++;
        } else {
            counts.failed++;
        }
    }
    return counts;
  }

// Function to calculate State of Health (SoH)
static double calculateSoH(int presentCapacity, int ratedCapacity) {
    return 100.0 * presentCapacity / ratedCapacity;
}

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :\n");
    System.out.println("failed :" + " "+counts.failed);
    System.out.println("healthy :" +" "+ counts.healthy);
    System.out.println("exchange :" +" "+ counts.exchange);
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
