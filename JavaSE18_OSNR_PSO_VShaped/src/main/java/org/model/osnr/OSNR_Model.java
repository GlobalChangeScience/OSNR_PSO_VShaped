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


package org.model.osnr;


import benchmark.OSNR_Data;


/**
 * A class for OSNR model.
 */
public final class OSNR_Model
{
    /**
     * false for maximization,
     * true for minimization.
     */
    private static boolean minimization = false;

    private static int[][] A;
    private static int num_areas;
    private static int num_species;
    private static int[] budget;
    private static int total_budget;

    private long seed;

    /**
     * Constructor.
     * @param data OSNR data.
     */
    public OSNR_Model(OSNR_Data data)
    {
        this.A = data.getA();
        this.num_areas = data.getNumAreas();
        this.num_species = data.getNumSpecies();
        this.budget = data.getBudget();
        this.total_budget = data.getBudgetTotal();
        this.seed = 0;
    }

    /**
     * Constructor
     * @param A
     * @param num_areas
     * @param num_species
     */
    public OSNR_Model(int A[][], int num_areas, int num_species, int[] budget, int total_budget)
    {
        this.A = A;
        this.num_areas = num_areas;
        this.num_species = num_species;
        this.budget = budget;
        this.total_budget = total_budget;
        this.seed = 0;
    }

    /**
     * Calculate the fitness
     * @param species_variable
     * @return
     */
    public static int calculate_fitness(int[] species_variable)
    {
        int fitness = 0;

        // var int: fitness = sum( j in 1..num_species) (Y[j]);
        for (int j = 0; j < num_species; j++)
        {
            fitness = fitness + species_variable[j];
        }

        return fitness;
    }

    /**
     * A function for check all constraints.
     * @return
     */
    public static boolean check_constraint(int[] area_variable, int[] species_variable)
    {
        boolean flag_constraint_1 = constraint_1(area_variable, species_variable);
        boolean flag_constraint_2 = constraint_2(area_variable);

        //System.out.println(flag_constraint_1 +""+ flag_constraint_2 +""+ flag_constraint_3);
        if (flag_constraint_1 == false)
        {
            return false;
        }

        if (flag_constraint_2 == false)
        {
            return false;
        }

        return true;
    }


    // First constraint:
    // forall(j in 1..num_species)
    // (
    //     sum(i in 1..num_terrains) (X[i]*A[i,j]) >= Y[j]
    // )
    private static boolean constraint_1(int[] area_variable, int[] species_variable)
    {
        for (int j = 0; j < num_species; j++)
        {
            double sum = 0;
            for (int i = 0; i < num_areas; i++)
            {
                sum = sum + area_variable[i] * A[i][j];
            }

            if (sum < species_variable[j])
            {
                return false;
            }
        }
        return true;
    }

    // Second constraint:
    //   sum(i in 1..num_terrains) (X[i] * budget[i]) <= budget_total
    private static boolean constraint_2(int[] area_variable)
    {
        double sum = 0;
        for (int i = 0; i < num_areas; i++)
        {
            sum = sum + area_variable[i] * budget[i];
        }

        if (sum <= total_budget)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean isMinimization()
    {
        return minimization;
    }

    public long getSeed()
    {
        return seed;
    }

    public void setSeed(long seed)
    {
        this.seed = seed;
    }

    public int[][] getA()
    {
        return A;
    }

    public int getNum_areas()
    {
        return num_areas;
    }

    public int getNum_species()
    {
        return num_species;
    }

    public int[] getBudget()
    {
        return budget;
    }

    public int getTotal_budget()
    {
        return total_budget;
    }

}

