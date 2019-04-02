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
 * Implementation for OSNR Velocity
 */
public class OSNR_Velocity
{
	// Variables
	private double[] area_variable;
	private double[] species_variable;

	/**
	 * Constructor
	 */
	public OSNR_Velocity()
    {

    }

	/**
	 * Constructor
	 * @param area_variable
	 * @param species_variable
	 */
	public OSNR_Velocity(double[] area_variable, double[] species_variable)
	{
		this.area_variable = new double[area_variable.length];
		this.species_variable = new double[species_variable.length];

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
        
        final OSNR_Velocity other = (OSNR_Velocity) obj;

		return Objects.equals(this.area_variable, other.area_variable) & Objects.equals(this.species_variable, other.species_variable);
	}


	public double[] getArea_variable()
	{
		return area_variable;
	}

	public void setArea_variable(double[] area_variable)
	{
		this.area_variable = area_variable;
	}

	public double[] getSpecies_variable()
	{
		return species_variable;
	}

	public void setSpecies_variable(double[] species_variable)
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
		return "\n{\n" +
				"area_variable : " + Arrays.toString(area_variable) + "\n" +
				"species_variable : " + Arrays.toString(species_variable) + "\n" +
				'}';
	}

	@Override
	public OSNR_Velocity clone()
	{
		double[] copy_area_variable = this.area_variable.clone();
		double[] copy_species_variable = this.species_variable.clone();

		return new OSNR_Velocity(copy_area_variable, copy_species_variable);
	}

}
