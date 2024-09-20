# Use an official Java runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the current directory contents into the container at /usr/src/app
COPY . .

# List contents of the directory for debugging
RUN ls -la

# Find Java files in the Game directory and compile them
RUN find ./Game -name "*.java" -print0 | xargs -0 javac

# Set the working directory to the Game folder
WORKDIR /usr/src/app/Game

# Run the game when the container launches
CMD ["java", "Main"]
