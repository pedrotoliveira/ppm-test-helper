#!/bin/sh
./mvnw release:prepare release:perform deploy -Prelease
