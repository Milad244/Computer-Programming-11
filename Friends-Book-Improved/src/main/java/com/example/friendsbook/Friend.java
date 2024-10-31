package com.example.friendsbook;

public class Friend {
    //fields
    private final String name;
    private int age;
    private final String favouriteFood;
    private int friendLvl;

    //methods

    // Requires: name as a string, age as an int, favourite food as a string, and friend lvl as an int.
    // Modifies: this
    // Effects: Friend constructor
    public Friend(String name, int age, String favouriteFood, int friendLvl){
        this.name = name;
        this.age = age;
        this.favouriteFood = favouriteFood;
        this.friendLvl = friendLvl;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns name as a string
    public String getName() {
        return name;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns age as an int
    public int getAge() {
        return age;
    }

    // Requires: nothing
    // Modifies: this
    // Effects: increases friend age by one
    public void increaseAge(){
        age++;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns favourite food as a string
    public String getFavouriteFood() {
        return favouriteFood;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns friend level as an int
    public int getFriendLvl(){
        return friendLvl;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns friend level as it's corresponding string
    public String getFriendLvlString(){
        return switch (friendLvl) {
            case 1 -> "bad friend";
            case 2 -> "okay friend";
            case 3 -> "good friend";
            case 4 -> "amazing friend";
            case 5 -> "best friend";
            default -> "";
        };
    }

    // Requires: nothing
    // Modifies: this
    // Effects: increases friend level by one, if not at max level.
    public void upgradeFriend(){
        if (friendLvl < 5){
            friendLvl ++;
        }
    }

    // Requires: nothing
    // Modifies: this
    // Effects: decreases friend level by one, if not at min level.
    public void downgradeFriend(){
        if (friendLvl > 1){
            friendLvl --;
        }
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: turns friend object into a string with all the information about your friend
    @Override
    public String toString() {
        return "Your " + getFriendLvlString() + " " + getName() + " is " + getAge() + " and loves " + getFavouriteFood() + "!";
    }
}
