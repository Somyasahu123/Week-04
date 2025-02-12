package insurance_policy_management_system;

import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Holder='" + policyHolderName + '\'' +
                ", Expiry Date=" + expiryDate +
                ", Premium=" + premiumAmount +
                '}';
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();  // Stores policies by policy number
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>();  // Maintains insertion order
    private TreeMap<LocalDate, List<Policy>> policiesByExpiry = new TreeMap<>();  // Stores policies sorted by expiry date

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);

        policiesByExpiry.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
        policiesByExpiry.get(policy.getExpiryDate()).add(policy);
    }

    // Retrieve a policy by policy number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : policiesByExpiry.entrySet()) {
            if (!entry.getKey().isAfter(threshold)) {
                expiringPolicies.addAll(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = policiesByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    orderedPolicies.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            } else {
                break;
            }
        }
    }

    // Display all policies
    public void displayAllPolicies() {
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding some sample policies
        manager.addPolicy(new Policy("P1001", "Alice Johnson", LocalDate.now().plusDays(10), 5000));
        manager.addPolicy(new Policy("P1002", "Bob Smith", LocalDate.now().plusDays(25), 7000));
        manager.addPolicy(new Policy("P1003", "Charlie Brown", LocalDate.now().minusDays(5), 6000)); // Expired
        manager.addPolicy(new Policy("P1004", "Alice Johnson", LocalDate.now().plusDays(40), 5500));

        System.out.println("All Policies:");
        manager.displayAllPolicies();

        System.out.println("\nPolicies expiring within 30 days:");
        for (Policy policy : manager.getExpiringPolicies()) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies for Alice Johnson:");
        for (Policy policy : manager.getPoliciesByHolder("Alice Johnson")) {
            System.out.println(policy);
        }

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nPolicies after removing expired ones:");
        manager.displayAllPolicies();
    }
}

