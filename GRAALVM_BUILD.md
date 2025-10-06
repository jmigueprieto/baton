# GraalVM Native Image Build Guide

This project is configured to build a native binary using GraalVM Native Image.

## Prerequisites

### Install GraalVM

**Option 1: Using SDKMAN (Recommended)**
```bash
# List available GraalVM distributions
sdk list java | grep graal

# Install GraalVM Community Edition (includes native-image)
sdk install java 21.0.2-graalce

# Use it
sdk use java 21.0.2-graalce

# Verify native-image is included
native-image --version
```

**Note**: Modern GraalVM (21+) includes native-image by default. The `gu` tool is deprecated.

**Option 2: Manual Download**
- Download GraalVM from https://www.graalvm.org/downloads/
- Choose a distribution that includes native-image (Community Edition or Oracle GraalVM)
- Set `JAVA_HOME` to the GraalVM installation
- Add GraalVM's `bin` directory to your `PATH`
- Verify: `native-image --version`

## Building the Native Binary

### Quick Build

**Important**: Make sure you're using GraalVM, not regular JDK:
```bash
# Verify you're using GraalVM
java -version  # Should show "GraalVM CE"
native-image --version  # Should work

# If not, switch to GraalVM
sdk use java 21.0.2-graalce
```

Then build:
```bash
# Option 1: Use the build script (recommended - handles JAVA_HOME)
./build-native.sh

# Option 2: Build directly
./gradlew clean nativeCompile
```

The binary will be located at: `build/native/nativeCompile/baton`

**Build time**: ~90 seconds on modern hardware

### Running the Native Binary

```bash
# Run directly
./build/native/nativeCompile/baton -f samples/baton/sample0.baton

# With output directory
./build/native/nativeCompile/baton -f samples/baton/sample0.baton -d output/
```

## Reflection Configuration

This project uses **both** approaches for reflection configuration:

### 1. Programmatic Registration (NativeImageConfiguration.java)

The `NativeImageConfiguration` class registers known Conductor classes for reflection at build time.

### 2. JSON Configuration (reflect-config.json)

Manual reflection configuration in `src/main/resources/META-INF/native-image/me.mprieto/baton/reflect-config.json`.

## Using the Tracing Agent (Optional)

To auto-generate reflection configs for any missing classes:

### 1. Run with the agent
```bash
./gradlew -Pagent run
```

This runs the application with the GraalVM tracing agent, which monitors reflection usage.

### 2. Run with different sample files
```bash
# Edit build.gradle to change the sample file
./gradlew -Pagent run
```

### 3. Agent generates configs
The agent automatically creates/updates JSON files in:
```
src/main/resources/META-INF/native-image/
├── jni-config.json
├── proxy-config.json
├── reflect-config.json
├── resource-config.json
└── serialization-config.json
```

### 4. Review and merge
Review the generated files and merge with existing configs if needed.

## Troubleshooting

### ClassNotFoundException at runtime

Add the missing class to `reflect-config.json`:
```json
{
  "name": "com.example.MissingClass",
  "allDeclaredFields": true,
  "allDeclaredMethods": true,
  "allDeclaredConstructors": true
}
```

Or add to `NativeImageConfiguration.java`:
```java
registerForReflection(MissingClass.class);
```

### Build fails with "unsupported features"

Check the build output for specific features that aren't supported. Common issues:
- Dynamic class loading: Use reflection config
- JNI: Add to `jni-config.json`
- Resources: Add to `resource-config.json`

### Out of memory during build

Increase heap size:
```bash
./gradlew nativeCompile -J-Xmx8g
```

Or add to `build.gradle`:
```gradle
graalvmNative {
    binaries {
        main {
            buildArgs.add('-J-Xmx8g')
        }
    }
}
```

## Build Configuration

Key settings in `build.gradle`:

- `--no-fallback`: Prevents fallback to JVM mode
- `-H:+ReportExceptionStackTraces`: Better error messages during build
- `mainClass`: Entry point for the application
- `imageName`: Name of the output binary

## Performance Benefits

Native binary vs JAR (measured on this project):
- **Startup time**: 131ms vs 518ms (~4x faster)
- **Binary size**: 48MB (standalone) vs 34MB JAR + JRE (~400MB total)
- **Memory**: Lower baseline memory usage (no JVM overhead)
- **Distribution**: Single executable that runs anywhere (same OS/arch)

## Limitations

- Build time is slower (2-5 minutes vs seconds for JAR)
- Some Java features require configuration (reflection, JNI, resources)
- Platform-specific binaries (must build on target OS)
