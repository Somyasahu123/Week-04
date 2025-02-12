package design_a_voting_system;

import java.util.*;
class VotingSystem {
    private Map<String, Integer> votesMap = new HashMap<>(); // Candidate -> Votes
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains voting order

    // Cast a vote
    public void castVote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votesMap.get(candidate));
    }

    // Display results sorted by candidate name
    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votesMap);
        System.out.println("\nVoting Results (Sorted Alphabetically):");
        for (var entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display votes in order they were cast
    public void displayVotesInOrder() {
        System.out.println("\nVotes in the order they were cast:");
        for (var entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}

public class VotingSystemApp {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        votingSystem.displayResultsSorted();
        votingSystem.displayVotesInOrder();
    }
}

