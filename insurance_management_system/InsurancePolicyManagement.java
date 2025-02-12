package insurance_management_system;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare policies by expiry date for TreeSet sorting
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Policyholder='" + policyHolderName + '\'' +
                ", Expiry Date=" + expiryDate +
                ", Coverage Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Display all policies
    public void displayAllPolicies() {
        System.out.println("Policies (HashSet - Unordered):");
        for (Policy policy : hashSetPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies (LinkedHashSet - Insertion Order):");
        for (Policy policy : linkedHashSetPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies (TreeSet - Sorted by Expiry Date):");
        for (Policy policy : treeSetPolicies) {
            System.out.println(policy);
        }
    }

    // Retrieve policies expiring within the next 30 days
    public void displayExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Within 30 Days:");
        for (Policy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    // Retrieve policies with a specific coverage type
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Identify duplicate policies (by policy number)
    public void displayDuplicatePolicies(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Performance comparison of different sets
    public void comparePerformance() {
        int testSize = 10000;
        List<Policy> testPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // Generate test policies
        for (int i = 1; i <= testSize; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, today.plusDays(i % 365), "Auto", 500 + i));
        }

        // Measure HashSet performance
        long start = System.nanoTime();
        hashSetPolicies.addAll(testPolicies);
        long end = System.nanoTime();
        System.out.println("\nHashSet - Add Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSetPolicies.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSetPolicies.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet - Remove Time: " + (end - start) / 1e6 + " ms");

        // Measure LinkedHashSet performance
        start = System.nanoTime();
        linkedHashSetPolicies.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("\nLinkedHashSet - Add Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        linkedHashSetPolicies.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        linkedHashSetPolicies.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet - Remove Time: " + (end - start) / 1e6 + " ms");

        // Measure TreeSet performance
        start = System.nanoTime();
        treeSetPolicies.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("\nTreeSet - Add Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSetPolicies.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet - Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSetPolicies.remove(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet - Remove Time: " + (end - start) / 1e6 + " ms");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Adding sample policies
        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(20), "Health", 1200.50));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(50), "Auto", 800.75));
        system.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(15), "Home", 1500.00));
        system.addPolicy(new Policy("P1004", "David", LocalDate.now().plusDays(10), "Health", 1000.00));

        system.displayAllPolicies();
        system.displayExpiringSoonPolicies();
        system.displayPoliciesByCoverageType("Health");

        // Performance comparison
        system.comparePerformance();
    }
}

