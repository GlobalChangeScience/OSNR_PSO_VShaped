/*
 * Resolving the Optimal Selection of a Natural Reserve
 * using the Particle Swarm Optimisation by Applying Transfer Functions
 * Copyright (C) 2019 Boris L. Almonacid, Global Change Science
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package benchmark;

import java.util.Arrays;


/**
 * A class for support a OSNR data.
 */
public class OSNR_Data
{
    private int id;
    private String name;
    private int num_areas;
    private int num_species;
    private int budget_total;
    private int [] budget;
    private int [][] A;

    public OSNR_Data()
    {
        this.id = 0;
        this.name = "";
        this.num_areas = 0;
        this.num_species = 0;
        this.budget_total = 0;
        this.budget = null;
        this.A = null;
    }


    public OSNR_Data(int id, String name, int num_areas, int num_species,
                     int budget_total, int[] budget, int[][] A)
    {
        this.id = id;
        this.name = name;
        this.num_areas = num_areas;
        this.num_species = num_species;
        this.budget_total = budget_total;
        this.budget = budget;
        this.A = A;
    }



    public int getId()
    {
        return id;
    }

    public int getNumAreas()
    {
        return num_areas;
    }

    public int getNumSpecies()
    {
        return num_species;
    }

    public int getBudgetTotal()
    {
        return budget_total;
    }

    public int[] getBudget()
    {
        return budget;
    }

    public int[][] getA()
    {
        return A;
    }


    @Override
    public String toString()
    {
        return
               "\"id\"          : \""   + this.id               + "\", \n" +
               "\"name\"        : \""   + this.name             + "\", \n" +
               "\"Num Areas\"   : \""   + this.getNumAreas()    + "\", \n" +
               "\"Num Species\" : \""   + this.getNumSpecies()  + "\", \n" +
               "\"Budget Total\": \""   + this.getBudgetTotal() + "\", \n" +
               "\"Budget\"      : \"" 	+ Arrays.toString(this.budget)  + "\", \n" +
               "\"A\"           : \"\n" + Arrays.deepToString(this.A)   + "\", \n";
    }
}
