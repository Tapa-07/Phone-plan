public class PostpaidPlan extends PhonePlan {
    private String dataCarryOver;
    private String subscription;

    public PostpaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType,
            String dataCarryOver) {
        super(providerName, planName, talkTime, data, smsPerDay, planType);
        this.dataCarryOver = dataCarryOver;
        this.subscription = findSubscription(planName); // Set subscription based on planName
    }

    @Override
    public double findPlanAmount() {
        // Normalize providerName and planName to lowercase for case insensitivity
        String normalizedProvider = providerName.toLowerCase();
        String normalizedPlan = planName.toLowerCase();

        // Define plan costs based on provider and planName
        double planAmount = -1; // Default to -1 if no matching plan found

        if (normalizedProvider.equals("airtel")) {
            if (normalizedPlan.equals("regular-postpay"))
                planAmount = 399;
            else if (normalizedPlan.equals("family plan for 2"))
                planAmount = 599;
            else if (normalizedPlan.equals("family plan for 5"))
                planAmount = 999;
            else if (normalizedPlan.equals("family plan for 8"))
                planAmount = 1599;
        } else if (normalizedProvider.equals("jio")) {
            if (normalizedPlan.equals("regular-postpay"))
                planAmount = 500;
            else if (normalizedPlan.equals("family plan for 2"))
                planAmount = 720;
            else if (normalizedPlan.equals("family plan for 5"))
                planAmount = 980;
            else if (normalizedPlan.equals("family plan for 8"))
                planAmount = 1650;
        }

        return planAmount;
    }

    // Method to find subscription based on planName
    private String findSubscription(String planName) {
        // Logic to determine subscription based on planName
        // This could be extended based on actual requirements
        if (planName.toLowerCase().contains("wynk music"))
            return "Wynk Music";
        else if (planName.toLowerCase().contains("jio saavn"))
            return "Jio Saavn";
        else
            return "Unknown Subscription";
    }

    // Getters and setters for PostpaidPlan specific attributes
    public String getDataCarryOver() {
        return dataCarryOver;
    }

    public void setDataCarryOver(String dataCarryOver) {
        this.dataCarryOver = dataCarryOver;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
}
