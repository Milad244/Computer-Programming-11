package com.example.friendsbook;

import java.util.ArrayList;

public class FriendGroup {
    //fields
    private String groupName;
    private ArrayList<Friend> friends;

    //methods

    // Requires: group name as a string
    // Modifies: this
    // Effects: FriendGroup constructor also creates a Friend arraylist that stores the friends for this group
    public FriendGroup(String groupName){
        this.groupName = groupName;
        this.friends = new ArrayList<>();
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns group name as a string
    public String getGroupName() {
        return groupName;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the friends list of this group as an arraylist of Friends
    public ArrayList<Friend> getFriends() {
        return friends;
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: adds a new friend
    public void addFriend(Friend friend){
        friends.add(friend);
    }

    // Requires: friend as a Friend
    // Modifies: this
    // Effects: removes a friend
    public void removeFriend(Friend friend){
        friends.remove(friend);
    }
}
