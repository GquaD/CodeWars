package kyu5;

import java.util.*;

/**
 * Created by Behzod on 07, January, 2020
 */
public class SportsLeagueTableRanking {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeRanks(6, new int[][]
                       {{0, 5, 2, 2},
                        {1, 4, 0, 2},
                        {2, 3, 1, 2},
                        {1, 5, 2, 2},
                        {2, 0, 1, 1},
                        {3, 4, 1, 1},
                        {2, 5, 0, 2},
                        {3, 1, 1, 1},
                        {4, 0, 2, 0}})));
    }

    //works!!!! yahoooo!
    public static int[] computeRanks(int number, int[][] games) {
        ArrayList<Team> league = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Team team = new Team();
            team.name = "Team " + i;
            team.number = i;
            league.add(team);
        }
        //assigning points, goals and differences
        for (int i = 0; i < games.length; i++) {
            //lets record points
            if (games[i][2] == games[i][3]) {
                league.get(games[i][0]).points += 1;
                league.get(games[i][1]).points += 1;
                //since a draw - nothing in goals dif is changed
            } else if (games[i][2] > games[i][3]) {
                league.get(games[i][0]).points +=2;
            } else if (games[i][2] < games[i][3]) {
                league.get(games[i][1]).points +=2;
            }

            //lets record goals difference
            league.get(games[i][0]).goalsDifference += games[i][2] - games[i][3];
            league.get(games[i][1]).goalsDifference += games[i][3] - games[i][2];

            //lets record goals scored
            league.get(games[i][0]).goalsScored += games[i][2];
            league.get(games[i][1]).goalsScored += games[i][3];
        }

        Collections.sort(league, new SortByGoalsScored());
        Collections.sort(league, new SortByGoalsDifference());
        Collections.sort(league, new SortByPoints());

        for (int i = 0; i < league.size(); i++) {
            league.get(i).place = i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //check if places are equal, assigning same rank to teams with equal performance params
        for (int i = 0; i < league.size() - 1; i++) {
            if (league.get(i).goalsScored == league.get(i+1).goalsScored && league.get(i).points == league.get(i + 1).points && league.get(i).goalsDifference == league.get(i+1).goalsDifference){
                league.get(i + 1).place = league.get(i).place;
            }
            map.put(league.get(i).number, league.get(i).place);
            if (i == league.size() - 2) map.put(league.get(i + 1).number, league.get(i + 1).place);
        }

        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = map.get(i) + 1;
        }
        return result;
    }

    static class Team {
        String name;
        int number;
        int place;
        int points;
        int goalsScored;
        int goalsDifference;

        public Team () {
            this.place = 0;
            this.points = 0;
            this.goalsScored = 0;
            this.goalsDifference = 0;
        }

        public Team(int place, int points, int goalsScored, int goalsDifference) {
            this.place = place;
            this.points = points;
            this.goalsScored = goalsScored;
            this.goalsDifference = goalsDifference;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    ", place=" + place +
                    ", points=" + points +
                    ", goalsScored=" + goalsScored +
                    ", goalsDifference=" + goalsDifference +
                    '}';
        }
    }

    static class SortByPoints implements Comparator<Team> {
        @Override
        public int compare(Team a, Team b) {
            return b.points - a.points;
        }
    }

    static class SortByGoalsDifference implements Comparator<Team> {
        @Override
        public int compare(Team a, Team b) {
            return b.goalsDifference - a.goalsDifference;
        }
    }

    static class SortByGoalsScored implements Comparator<Team> {
        @Override
        public int compare(Team a, Team b) {
            return b.goalsScored - a.goalsScored;
        }

    }

    /*  public static int[][] computeRanks1(int number, int[][] games) {
        int[][] results = new int[number][4];
        //first column - team     results[i][0]
        //second column - points  results[i][1]
        //third column - goal dif results[i][2]
        //fourth column - goals   results[i][3]
        //do smth with place in the league
        int count = 0;
        for (int i = 0; i < games.length; i++) {
            //lets record points
            if (games[i][2] == games[i][3]) {
                results[games[i][0]][1] += 1;
                results[games[i][1]][1] += 1;
                //since a draw - nothing in goals dif is changed
            } else if (games[i][2] > games[i][3]) {
                results[games[i][0]][1] += 2;
            } else if (games[i][2] < games[i][3]) {
                results[games[i][1]][1] += 2;
            }

            //lets record goals difference
            results[games[i][0]][2] += games[i][2] - games[i][3];
            results[games[i][1]][2] += games[i][3] - games[i][2];

            //lets record goals scored
            results[games[i][0]][3] += games[i][2];
            results[games[i][1]][3] += games[i][3];

            //adding team number
            if (count != number) {
                results[i][0] = count;
                count++;
            }
        }




        return results;
    }*/
}
