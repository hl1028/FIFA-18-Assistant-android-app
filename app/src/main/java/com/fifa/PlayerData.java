package com.fifa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyuanxu on 12/16/17.
 * This is a class to manage all players data create indexes for quick query
 */

public class PlayerData {

    //playerList holds all Player objects in the order of reading
    private List<Player> playerList;

    //indexes are hash maps to improve query efficiency
    private Map<Integer, Player> idIndex;
    private Map<Integer, List<Player>> teamIndex;

    /**
     * Constructor method
     */
    public PlayerData() {
        playerList = new ArrayList<>();
    }

    /**
     * Method to add a new player into this dataset.
     * No duplication in CSV file after data cleaning.
     * @param player new Player object to be added in.
     */
    public void add(Player player) {
        playerList.add(player);
    }

    /**
     * This method is created to create all hash maps to accelerate data querying.
     * @param teamData
     */
    public void createIndex(TeamData teamData) {
        createIndexWithId();
        createIndexWithTeam(teamData);
    }

    /**
     * This method is built to create a hashmap of id with Player object.
     */
    private void createIndexWithId() {
        idIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            idIndex.put(playerList.get(i).getId(), playerList.get(i));
        }
    }

    /**
     * This method is built to create a hashmap of team id with list of a player objects who are
     * in this team
     * @param teamData
     */
    private void createIndexWithTeam(TeamData teamData) {
        teamIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            String club = String.valueOf(playerList.get(i).getClub());
            Team team = teamData.getTeamByName(club);
            if (team == null) {
                continue;
            } else {
                if (!teamIndex.containsKey(team.getApiId())) {
                    teamIndex.put(team.getApiId(), new ArrayList<Player>());
                }
                teamIndex.get(team.getApiId()).add(playerList.get(i));
            }
        }
    }

    /**
     * Getter for playerList
     * @return List of players
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerData that = (PlayerData) o;

        if (playerList != null ? !playerList.equals(that.playerList) : that.playerList != null)
            return false;
        if (idIndex != null ? !idIndex.equals(that.idIndex) : that.idIndex != null) return false;
        return teamIndex != null ? teamIndex.equals(that.teamIndex) : that.teamIndex == null;
    }

    /**
     * Getter for hashmap of player id and player object
     * @return hashmap of api id and player object
     */
    public Map<Integer, Player> getIdIndex() {
        return idIndex;
    }

    /**
     * Getter for hashmap of team api id and player object list
     * @return hashmap of team api id and player object list
     */
    public Map<Integer, List<Player>> getTeamIndex() {
        return teamIndex;
    }
    /**
     * get a list of all names of players
     * @return list of all names of players
     */
    public ArrayList<String> getNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Player p: playerList) {
            nameList.add(p.getName());
        }
        return nameList;
    }
}
