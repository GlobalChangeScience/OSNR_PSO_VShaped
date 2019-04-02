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

import java.util.Arrays;
import java.util.Objects;


/**
 * Implementation for OSNR Solution
 */
public class OSNR_Solution
{
	// Variables
	private int[] area_variable;
	private int[] species_variable;

	/**
	 * Constructor
	 */
	public OSNR_Solution()
    {

    }

	/**
	 * Constructor
	 * @param area_variable
	 * @param species_variable
	 */
	public OSNR_Solution(int[] area_variable, int[] species_variable)
	{
		this.area_variable = new int[area_variable.length];
		this.species_variable = new int[species_variable.length];

		// Copy original values
		for (int i = 0; i < area_variable.length; i++)
		{
			this.area_variable[i] = area_variable[i];
		}

		for (int i = 0; i < species_variable.length; i++)
		{
			this.species_variable[i] = species_variable[i];
		}
	}

	@Override
	public boolean equals(Object obj)
	{
        if (obj == null)
        {
            return false;
        }
        
        if (getClass() != obj.getClass())
        {
            return false;
        }
        
        final OSNR_Solution other = (OSNR_Solution) obj;

		return Objects.equals(this.area_variable, other.area_variable) & Objects.equals(this.species_variable, other.species_variable);
	}


	public int[] getArea_variable()
	{
		return area_variable;
	}

	public void setArea_variable(int[] area_variable)
	{
		this.area_variable = area_variable;
	}

	public int[] getSpecies_variable()
	{
		return species_variable;
	}

	public void setSpecies_variable(int[] species_variable)
	{
		this.species_variable = species_variable;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(area_variable) * Objects.hashCode(species_variable);
	}

	@Override
	public String toString()
	{
		return  "Areas   : " + Arrays.toString(area_variable) + "\n" +
				"Species : " + Arrays.toString(species_variable);
	}

	@Override
	public OSNR_Solution clone()
	{
		int[] copy_area_variable = this.area_variable.clone();
		int[] copy_species_variable = this.species_variable.clone();

		return new OSNR_Solution(copy_area_variable, copy_species_variable);
	}

}
