#!/bin/bash

# Define the filename
filename=$2;

for (( i=1;i<=$1;i++ ))
do
 sum=$(( $i + 221777000000 ))
 echo "$i,$sum" >> $filename
done

# Example run command;
# bash append_n_lines_to_file.sh 100 ../src/main/resources/msisdn.csv