public class PrepaidPlan extends PhonePlan {
    private int validity;
    private double extraData;

    public PrepaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType,
            int validity, double extraData) {
        super(providerName, planName, talkTime, data, smsPerDay, planType);
        this.validity = validity;
        this.extraData = extraData;
    }

    @Override
    public double findPlanAmount() {
        // Normalize providerName to lowercase for case insensitivity
        String normalizedProvider = providerName.toLowerCase();

        // Define plan costs based on provider, data, and validity
        double planAmount = -1; // Default to -1 if no matching plan found

        if (normalizedProvider.equals("airtel")) {
            if (data == 2 && (validity == 28 || validity == 56 || validity == 84))
                planAmount = validity == 28 ? 299 : (validity == 56 ? 549 : 839);
            else if (data == 3 && (validity == 28 || validity == 56 || validity == 84))
                planAmount = validity == 28 ? 399 : (validity == 56 ? 649 : 939);
        } else if (normalizedProvider.equals("jio")) {
            if (data == 2 && (validity == 28 || validity == 56 || validity == 84))
                planAmount = validity == 28 ? 389 : (validity == 56 ? 620 : 939);
            else if (data == 3 && (validity == 28 || validity == 56 || validity == 84))
                planAmount = validity == 28 ? 400 : (validity == 56 ? 749 : 839);
        }

        // Calculate extra data cost
        planAmount += extraData * 100; // Assuming cost of extra data is Rs. 100 per GB

        return planAmount;
    }

    // Getters and setters for PrepaidPlan specific attributes
    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public double getExtraData() {
        return extraData;
    }

    public void setExtraData(double extraData) {
        this.extraData = extraData;
    }
}
