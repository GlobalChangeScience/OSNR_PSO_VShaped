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

package org.implementation.pso_osnr.util;

import java.util.Random;

/**
 * Standard Discretization
 */
public final class StandardDiscretization
{

    /**
     * Discretization from double value to binary value
     * @param value
     * @return
     */
    public static int StandardInt(double value)
    {
        Random rm = new Random();
        double randomValue = rm.nextDouble();

        if ( randomValue <= value )
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}
