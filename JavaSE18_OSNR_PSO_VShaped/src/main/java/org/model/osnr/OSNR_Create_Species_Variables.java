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

/**
 * Create matrix species x variables.
 */
public final class OSNR_Create_Species_Variables
{

    /**
     * Create Species variable matrix
     * @param area_variable
     * @param num_areas
     * @param num_species
     * @param A
     * @return
     */
    public static int[] createSpeciesVariable(int[] area_variable, int num_areas, int num_species, int[][] A)
    {
        //Se crea la matriz pieza×celda para el momento en que se necesita
        int[] species_variable = new int[num_species];

        for (int j = 0; j < num_species; j++) //Rellenar la matriz de "0"
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
