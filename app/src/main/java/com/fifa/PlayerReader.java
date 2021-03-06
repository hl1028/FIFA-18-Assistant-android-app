package com.fifa;

import java.io.IOException;
import java.io.InputStreamReader;



import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is created to read the csv file of FIFA players.
 */

public class PlayerReader {

    //Data Stream variable
    private InputStreamReader csvStreamReader;

    //playerData object and teamData object to be used in data reading.
    private PlayerData playerData;
    private TeamData teamData;

    /**
     * Constructor method
     * @param stream input stream for player data
     * @param playerData playerData where the data will be written in.
     * @param teamData teamData to be used to create index for playerData.
     */
    public PlayerReader(InputStreamReader stream, PlayerData playerData, TeamData teamData) {
        csvStreamReader = stream;
        this.playerData = playerData;
        this.teamData = teamData;
    }

    /**
     * Method to read input streams
     */
    public void read() {
        CSVReader reader = new CSVReader(csvStreamReader);
        String[] line;
        try {
            while(true) {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                int id = Integer.parseInt(line[1]);
                String name = line[2];
                int age = Integer.parseInt(line[3]);
                String photo = line[4];
                String nationality = line[5];
                String flag = line[6];
                int overall = Integer.parseInt(line[7]);
                int potential = Integer.parseInt(line[8]);
                String club = line[9];
                String clubLogo = line[10];
                int value = Integer.parseInt(line[11]);
                int wage = Integer.parseInt(line[12]);
                Player cur = new Player(id, name, age, photo, nationality, flag, overall,
                        potential, club, clubLogo, value, wage);
                playerData.add(cur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        playerData.createIndex(teamData);
    }
}
