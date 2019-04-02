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

import org.apache.commons.math3.special.Erf;


/**
 * V Shaped functions, v1, v2, v3 and v4
 */
public final class VShaped
{
    // V1
    public static double V1(float x)
    {
        return Math.abs(Erf.erf( (Math.sqrt(Math.PI)/2) * x));
    }

    public static double V1(double x)
    {
        return Math.abs(Erf.erf( (Math.sqrt(Math.PI)/2) * x));
    }

    // V2
    public static double V2(float x)
    {
        return Math.abs( Math.tanh(x) );
    }

    public static double V2(double x)
    {
        return Math.abs( Math.tanh(x) );
    }

    // V3
    public static double V3(float x)
    {
        return Math.abs( x / Math.sqrt(1 + Math.pow(x, 2)));
    }

    public static double V3(double x)
    {
        return Math.abs( x / Math.sqrt(1 + Math.pow(x, 2)));
    }

    // V4
    public static double V4(float x)
    {
        return Math.abs( (2/Math.PI) * Math.atan( (Math.PI/2) * x));
    }

    public static double V4(double x)
    {
        return Math.abs( (2/Math.PI) * Math.atan( (Math.PI/2) * x));
    }

    public static void main(String[] args)
    {
        System.out.println("V1(-1): " + V1(-1));
        System.out.println("V1(0): " + V1(0));
        System.out.println("V1(1): " + V1(1));
        System.out.println("V1(-0.999999): " + V1(-0.999999));
        System.out.println("V1(0.999999): " + V1(0.999999));
        System.out.println("V1(-0.111111): " + V1(-0.111111));
        System.out.println("V1(0.111111): " + V1(0.111111));
        System.out.println("V1(-1.6939411510425213): " + V1(-1.6939411510425213));
        System.out.println("V1(1.6939411510425213): " + V1(1.6939411510425213));
        System.out.println("V1(30): " + V1(30));
        System.out.println("V1(300): " + V1(300));

        System.out.println("---------------");
        System.out.println("V2(-1): " + V2(-1));
        System.out.println("V2(0): " + V2(0));
        System.out.println("V2(1): " + V2(1));
        System.out.println("V2(-0.999999): " + V2(-0.999999));
        System.out.println("V2(0.999999): " + V2(0.999999));
        System.out.println("V2(-0.111111): " + V2(-0.111111));
        System.out.println("V2(0.111111): " + V2(0.111111));
        System.out.println("V2(-1.6939411510425213): " + V2(-1.6939411510425213));
        System.out.println("V2(1.6939411510425213): " + V2(1.6939411510425213));

        System.out.println("---------------");
        System.out.println("V3(-1): " + V3(-1));
        System.out.println("V3(0): " + V3(0));
        System.out.println("V3(1): " + V3(1));
        System.out.println("V3(-0.999999): " + V3(-0.999999));
        System.out.println("V3(0.999999): " + V3(0.999999));
        System.out.println("V3(-0.111111): " + V3(-0.111111));
        System.out.println("V3(0.111111): " + V3(0.111111));
        System.out.println("V3(-1.6939411510425213): " + V3(-1.6939411510425213));
        System.out.println("V3(1.6939411510425213): " + V3(1.6939411510425213));

        System.out.println("---------------");
        System.out.println("V4(-1): " + V4(-1));
        System.out.println("V4(0): " + V4(0));
        System.out.println("V4(1): " + V4(1));
        System.out.println("V4(-0.999999): " + V4(-0.999999));
        System.out.println("V4(0.999999): " + V4(0.999999));
        System.out.println("V4(-0.111111): " + V4(-0.111111));
        System.out.println("V4(0.111111): " + V4(0.111111));
        System.out.println("V4(-1.6939411510425213): " + V4(-1.6939411510425213));
        System.out.println("V4(1.6939411510425213): " + V4(1.6939411510425213));

    }

}
