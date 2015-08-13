/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pixelchimera.teambuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dans
 */
public class Optimizer {
    
    public Optimizer(int offDef, int count, int[] dex, int[] off, int[] def){
        favor = offDef;
        optCount = count;
        optTypes = new int[optCount][2];
        dexNums = dex;
        offenseMult = off;
        defenseMult = def;
        beenDone = new ArrayList<Integer>();
        consAccess = new ConsClass();
        
        // Add any types we are already using to the list
        int tempType = 17;
        for (int i = 0; i < 6; i ++){
            if (dexNums[i] == -1){
                break;
            }
            // Check both types
            tempType = consAccess.GetIntTypeByDexNum(dexNums[i], 0);
            if (tempType != 17 && !beenDone.contains(tempType)){
                beenDone.add(tempType);
            }
            tempType = consAccess.GetIntTypeByDexNum(dexNums[i], 1);
            if (tempType != 17 && !beenDone.contains(tempType)){
                beenDone.add(tempType);
            }
        }
    }
    
    // Calculate one type against the current mult array
    public void CalcType(int type, boolean offScore){
        if (offScore){
            int[] tempMult = consAccess.CalcOff(type);
            for (int i = 0; i < 17; i++){
                offenseMult[i] += tempMult[i];
            }
        }
        else{
            int[] tempMult = consAccess.CalcDef(type,-1);
            for (int i = 0; i < 17; i++){
                defenseMult[i] += tempMult[i];
            }
        }
    }
    
    // Assign a score to the current mult array
    // The score should favor the highest array with the least variance
    // IE an array with a -6 and a +6 would not be as good as one with a -2 and +2
    public int AssignScore(boolean offScore){
        // Criteria: we want low variance
        // We want as many fields to be >0 as possible
        // We want a high sum
        int sum = 0;
        int zeros = 0;
        int highest = -100;
        int lowest = 100;
                
        for (int i = 0; i < 17; i++){
            if (offScore){
                // The if and else function exactly the same
                // First, get the sum
                // Then, get the variance (absolute value of a mult, squared)
                // Count the number of 0 values
                // And find the highest and lowest values
                sum += offenseMult[i];
                if (offenseMult[i] <= 0){
                    zeros++;
                }
                if (offenseMult[i] > highest){
                    highest = offenseMult[i];
                }
                else if (offenseMult[i] < lowest){
                    lowest = offenseMult[i];
                }
            }
            else{
                sum += defenseMult[i];
                if (defenseMult[i] <= 0){
                    zeros++;
                }
                if (defenseMult[i] > highest){
                    highest = defenseMult[i];
                }
                else if (defenseMult[i] < lowest){
                    lowest = defenseMult[i];
                }
            }
        }

        int retval = sum - zeros*2 - (Math.abs(highest) + Math.abs(lowest)*2);

        return retval;
    }
    
    // Run through all the types and get the best offense score
    public int GetBestOffScore(){
        int i = 0;
        int bestInd = -1;
        int bestSoFar = -100;
        int[] scoreArr = new int[17];
        int[] tempOff = offenseMult.clone();;
        List<Integer> bestList = new ArrayList<Integer>();
        
        // Calculate the score for each type
        for (i = 0; i < 17; i++){
            CalcType(i,true);
            scoreArr[i] = AssignScore(true);
            // Keep track of which type scores the best
            if (scoreArr[i] > bestSoFar && !beenDone.contains(i)){
                bestSoFar = scoreArr[i];
                bestInd = i;
            }
            // Reset the mult to where it was
            offenseMult = tempOff.clone();
        }

        // Return the type that scored the best
        return bestInd;
    }
    
    // Run through all the types and get the best defense score
    public int GetBestDefScore(){
        int i = 0;
        int bestInd = -1;
        int bestSoFar = -100;
        int[] scoreArr = new int[17];
        int[] tempDef = defenseMult;
        List<Integer> bestList = new ArrayList<Integer>();
        
        // Calculate the score for each type
        for (i = 0; i < 17; i++){
            CalcType(i,false);
            scoreArr[i] = AssignScore(false);
            // Keep track of which type scores the best
            if (scoreArr[i] > bestSoFar && !beenDone.contains(i)){
                bestSoFar = scoreArr[i];
                bestInd = i;
            }
            // Reset the mult to where it was
            defenseMult = tempDef;
        }

        // Return the type that scored the best
        return bestInd;
    }
    
    // Run through all types and see which has the best offense and defense average
    public int GetBestAvgScore(){
        int i = 0;
        int bestInd = -1;
        int bestSoFar = -100;
        int[][] scoreArr = new int[2][17];
        int[] tempDef = defenseMult;
        int[] tempOff = offenseMult;
        int avg;
        List<Integer> bestList = new ArrayList<Integer>();
        
        // Calculate the score for each type
        for (i = 0; i < 17; i++){
            CalcType(i,false);
            scoreArr[0][i] = AssignScore(false);
            CalcType(i,true);
            scoreArr[1][i] = AssignScore(true);
            
            avg = (int)((scoreArr[0][i]+scoreArr[1][i])/2);
            // Keep track of which type scores the best
            if (avg > bestSoFar && !beenDone.contains(i)){
                bestSoFar = avg;
                bestInd = i;
            }
            // Reset the mult to where it was
            defenseMult = tempDef;
            offenseMult = tempOff;
        }

        // Return the type that scored the best
        return bestInd;
    }
    
    public int[] GetBestScores(){
        // We will get a number of dual-types ("none" can be a type) to fill the
        // desired number of slots
        int[] bests = new int[optCount];
        
        for (int i = 0; i < 2; i++){
            if (favor == 1){//offense
                // Get the best type, then apply it to our layout
                bests[i] = GetBestOffScore();
                CalcType(bests[i],true);
                beenDone.add(bests[i]);
            }
            else if (favor == -1){//defense
                // Get the best type, then apply it to our layout
                bests[i] = GetBestDefScore();
                CalcType(bests[i],false);
                beenDone.add(bests[i]);
            }
            else{
                // Get the best average score
                bests[i] = GetBestAvgScore();
                CalcType(bests[i],false);
                CalcType(bests[i],true);
                beenDone.add(bests[i]);
            }
        }
        
        return bests;
    }
    
    private int optCount;
    private int favor;
    private int[][] optTypes;
    private int[] dexNums;
    private int[] offenseMult;
    private int[] defenseMult;
    private int[] bestTypes;
    private List<Integer> beenDone;
    private boolean dgFlag;
    private ConsClass consAccess;
}
