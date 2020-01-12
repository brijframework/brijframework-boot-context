#!/bin/bash

set -e

cd `dirname $0`
r=`pwd`
echo $r
exec &> logfile.txt

# brijframework-context
echo "Starting brijframework-context..."
mvn clean install 