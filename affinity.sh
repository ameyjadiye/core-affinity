#!/bin/bash
#===============================================================================
#title           : affinity.sh
#description     : For assigning equal cores to java pid passed to this script.
#author          : Amey Jadiye (ameyjadiye@gmail.com)
#date            : 20161221
#version         : 0.1    
#usage           : bash affinity.sh
#notes           : Vim and Emacs are needed to use this script.
#bash_version    : 4.1.5(1)-release
#===============================================================================

usage ()
{
  echo 'Usage : affinity <java_pid>'
  exit
}

if [ "$#" -ne 1 ]
then
  usage
fi


_index=0
_cores=`nproc`

for nid in `jstack $1 | grep nid  | cut -d' ' -f6 | grep nid | cut -d'=' -f2 | cut -d'x' -f2`
do 
	taskset -p -c $(($_index % $_cores)) $((16#$nid)) 
	((_index++))
done

