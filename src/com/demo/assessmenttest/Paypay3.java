package com.demo.assessmenttest;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Paypay3 {
    public static void main(String[] args) {

        String[] members = {"id42", "id158", "id23"};
        String[][] events = new String[][]{
                new String[]{"MESSAGE", "0", "ALL id158 id42"},
                new String[]{"OFFLINE", "1", "id158"},
                new String[]{"MESSAGE", "2", "id158 id158"},
                new String[]{"OFFLINE", "3", "id23"},
                new String[]{"MESSAGE", "60", "HERE id158 id42 id23"},
                new String[]{"MESSAGE", "61", "HERE"}};

        // Initialize mention counts
        Map<String, Integer> mentionCount = new HashMap<>();
        for (String member : members) {
            mentionCount.put(member, 0);
        }

        // Set to track active users
        Set<String> activeUsers = new HashSet<>(Arrays.asList(members));

        for (String[] event : events) {
            String eventType = event[0];
            String mentions = event[2];

            if (eventType.equals("MESSAGE")) {
                // Create a set to track unique mentions in this message
                Set<String> uniqueMentions = new HashSet<>();

                // Process the mentions
                String[] mentionTokens = mentions.split(" ");
                for (String token : mentionTokens) {
                    if (token.equals("ALL") || token.equals("HERE")) {
                        uniqueMentions.addAll(activeUsers);
                    } else {
                        uniqueMentions.add(token); // individual mention
                    }
                }

                // Increment mention counts for unique mentions
                for (String id : uniqueMentions) {
                    if (mentionCount.containsKey(id)) {
                        mentionCount.put(id, mentionCount.get(id) + 1);
                    }
                }
            } else if (eventType.equals("OFFLINE")) {
                String id = event[2];
                activeUsers.remove(id);
            }
        }

        // Prepare and sort the output
        List<String> result = Arrays.stream(members)
                .map(member -> member + "=" + mentionCount.get(member))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}


/*
Question 3 of 4

Think about a team chat with numerous users writing messages in it. The chat supports two types of actions:

        "MESSAGE" – Messages a set of users. The format looks as follows: ["MESSAGE", "<timestamp>", "<mentions>"].
        Mentions string can contain the following space-separated tokens:

        id<number>, where <number> is an integer in range [1:999] - mentioning of individual users
        ALL - mentioning all users
        HERE - mentioning active users
        "OFFLINE" – Makes a user with a given id inactive for 60 time ticks – the user will be active again at time <timestamp> + 60.
        It is guaranteed that the user with given <id> will be active when this action is applied.
        The format looks as follows: ["OFFLINE", "<timestamp>", "<id>"], where id is a single individual mention.
        Note: all the events are sorted by their timestamp.

Examples of events

	["MESSAGE", "0", "id1"] – mentioning user with id id1
	["MESSAGE", "9", "HERE id3"] – mentioning all the active users and user with id id3
	["MESSAGE", "6", "ALL"] – mentioning all the users
	["MESSAGE", "100", ""] – message, without mentioning any user
	["OFFLINE", "200", "id3"] – making user with id id3 inactive

	Please note, that mentions do not contain any other text, but only a list of ids or aliases separates by a space.

	Your task is to calculate mention statistics. Given a list of users in the group chat and a list of chat events, count the number of message events that each user is mentioned in.

	Return the results in an array of strings, with each string following this format: "[user id]=[mentions count]". The array should be sorted lexicographically by user id in ascending order.

	Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than O(members.length * events.length) will fit within the execution time limit.

	Example

	For members = ["id42", "id158", "id23"] and

	events = [
				["MESSAGE", "0", "ALL id158 id42"],
				["OFFLINE", "1", "id158"],
				["MESSAGE", "2", "id158 id158"],
				["OFFLINE", "3", "id23"],
				["MESSAGE", "60", "HERE id158 id42 id23"],
				["MESSAGE", "61", "HERE"]
			]
	the output should be solution(members, events) = ["id158=4", "id23=2", "id42=3"].

Explanation:

	In the first event at time 0, all users are mentioned with ALL alias. Note that id158 and id42 are mentioned twice – once by ALL alias and once by their ids, but they should be counted once.

	In the second event at time 1 the user id158 becomes inactive.

	In the third event at time 2 the user id158 is mentioned and they get notified even when inactive. Note that id158 is mentioned twice, but it should be counted once.

	In the fourth event at time 3 the user id23 becomes inactive.

	In the fifth event at time 60 all active users and id158, id42, and id23 are mentioned. Note that id158 and id23 are mentioned by their username, so they will be notified even when they are inactive, and id42 is mentioned twice – once by HERE alias and once by their id, but it should be counted once.

	In the last event at time 61 the user with id158 is back online again as they have been offline for 60 time ticks already. Here all the active users are mentioned – which are id42 and id158.
	So, the output should be ["id158=4", "id23=2", "id42=3"].

Guaranteed constraints:
        2 ≤ members.length ≤ 50,
        3 ≤ members[i].length ≤ 5.

        [input] array.array.string events

Events occurred in chronological order. Note, that timestamps can be in range [0:200].

Guaranteed constraints:
        1 ≤ events.length ≤ 100.

        [output] array.string

Return an array of strings containing all user ids from members, with count of each user id mentions across events (described above) separated by = sign. This array should be sorted lexicographically by user id in ascending order.

*/