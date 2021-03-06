package com.fifa;

import java.io.IOException;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by qiyuanxu on 12/16/17.
 * This class is create to read team data into TeamData object
 */

public class TeamReader {
    private InputStreamReader teamStream;
    private InputStreamReader teamAttrStream;
    private TeamData teamData;

    /**
     * Constructor for this class
     * @param teamStream input stream for team
     * @param teamAttrStream input stream for team attributes
     * @param teamData data manager where we want to write data in.
     */
    public TeamReader(InputStreamReader teamStream, InputStreamReader teamAttrStream, TeamData teamData) {
        this.teamStream = teamStream;
        this.teamAttrStream = teamAttrStream;
        this.teamData = teamData;
    }

    /**
     * Method to read input streams
     */
    public void read() {
        CSVReader reader = new CSVReader(teamStream);
        String[] line;
        try {
            reader.readNext();
            while (true) {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                int id = line[0].length() == 0 ? 0 : Integer.parseInt(line[0]);
                int apiId = line[1].length() == 0 ? 0 :Integer.parseInt(line[1]);
                int fifaId = line[2].length() == 0 ? 0 : Integer.parseInt(line[2]);
                String longName = line[3];
                String shortName = line[4];
                Team cur = new Team(id, apiId, fifaId, longName, shortName);
                teamData.addTeam(cur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * create index for teamData
         */
        teamData.createIndex();

        reader = new CSVReader(teamAttrStream);

        try {
            reader.readNext();
            while (true) {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                int id = Integer.parseInt(line[2]);
                Team t = teamData.getTeamById(id);
                if (t != null) {
                    t.setDate(line[3]);
                    t.setBuildUpPlaySpeed(line[4].length() == 0? 0:Integer.parseInt(line[4]));
                    t.setBuildUpPlaySpeedClass(line[5]);
                    t.setBuildUpPlayDribbling(line[6].length() == 0? 0:Integer.parseInt(line[6]));
                    t.setBuildUpPlayDribblingClass(line[7]);
                    t.setBuildUpPlayPassing(line[8].length() == 0? 0:Integer.parseInt(line[8]));
                    t.setBuildUpPlayPassingClass(line[9]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
