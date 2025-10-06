#!/bin/bash
set -e

# Make sure we're using GraalVM
export JAVA_HOME="$HOME/.sdkman/candidates/java/21.0.2-graalce"
export PATH="$JAVA_HOME/bin:$PATH"

# Verify
echo "Using Java: $(java -version 2>&1 | head -1)"
echo "native-image available: $(which native-image || echo 'NOT FOUND')"

# Stop any running gradle daemons to ensure they use the right Java
./gradlew --stop

# Build
./gradlew clean nativeCompile
