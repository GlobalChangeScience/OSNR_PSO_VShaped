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

package org.implementation.pso_osnr;

import org.model.osnr.OSNR_Model;
import org.model.osnr.OSNR_Solution;
import org.model.osnr.OSNR_Velocity;

import org.apache.commons.math3.random.RandomDataGenerator;

public final class PSO_OSNR_Velocity
{

    public static OSNR_Velocity randomVelocity(OSNR_Model osnr_model, double vMin, double vMax)
    {
        int num_areas = osnr_model.getNum_areas();
        int num_species = osnr_model.getNum_species();
        double[] area_variable = new double[num_areas];
        double[] species_variable;

        RandomDataGenerator random = new RandomDataGenerator();
        random.reSeedSecure(osnr_model.getSeed());

        // Create a random velocity between vmin and vmax.
        for (int i = 0; i < num_areas; i++)
        {
            area_variable[i] = random.nextUniform(vMin, vMax);
        }

        // Create matrix species x variables.
        species_variable = createVelocitySpeciesVariable(area_variable, num_areas, num_species, osnr_model.getA());

        return new OSNR_Velocity(area_variable, species_variable);
    }


    /**
     * Calculate the velocity.
     * v_{i}^{t+1} = v_{i}^{t} + c_{1} * rand * (pbest_{i} - p_{i}^{t}) + c_{2} * rand * (gbest - p_{i}^{t})
     * @param osnr_model
     * @param velocity
     * @param pBest
     * @param current_solution
     * @param gBest
     * @param c1
     * @param c2
     * @param random1
     * @param random2
     * @return
     */
    public static OSNR_Velocity velocity(OSNR_Model osnr_model,
                                  OSNR_Velocity velocity,
                                  OSNR_Solution pBest,
                                  OSNR_Solution current_solution,
                                  OSNR_Solution gBest,
                                  double c1,
                                  double c2,
                                  double random1,
                                  double random2)
    {
        int num_areas = osnr_model.getNum_areas();
        int num_species = osnr_model.getNum_species();
        double[] terrain_variable = new double[num_areas];
        double[] species_variable = new double[num_species];


        // Calculate velocity
        for (int i = 0; i < num_areas; i++)
        {
            terrain_variable[i] = velocity.getArea_variable()[i] +
                    (c1 * random1 * (pBest.getArea_variable()[i] - current_solution.getArea_variable()[i])) +
                    (c2 * random2 * (gBest.getArea_variable()[i] - current_solution.getArea_variable()[i]));

        }

        for (int i = 0; i < num_species; i++)
        {
            species_variable[i] =  velocity.getSpecies_variable()[i] +
                    (c1 * random1 * (pBest.getSpecies_variable()[i] - current_solution.getSpecies_variable()[i])) +
                    (c2 * random2 * (gBest.getSpecies_variable()[i] - current_solution.getSpecies_variable()[i]));

        }


        return new OSNR_Velocity(species_variable, species_variable);
    }


    /**
     * Create matrix species x variables.
     * @param area_variable
     * @param num_areas
     * @param num_species
     * @param A
     * @return
     */
    public static double[] createVelocitySpeciesVariable(double[] area_variable,
                                                         int num_areas, int num_species, int[][] A)
    {
        double[] species_variable = new double[num_species];

        for (int j = 0; j < num_species; j++)
        {
            species_variable[j] = 0;
        }

        for (int i = 0; i < num_areas; i++)
        {
            if (area_variable[i] == 1)
            {
                for (int j = 0; j < num_species; j++)
                {
                    if (A[i][j] == 1 && species_variable[j] == 0)
                    {
                        species_variable[j] = 1;
                    }
                }
            }
        }

        return species_variable;
    }
}
