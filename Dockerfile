# Use an official Java runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the current directory contents into the container at /usr/src/app
COPY . .

# Compile Java files
# RUN javac *.java
RUN /Game CompileAll.bat

# Run the game when the container launches
# CMD ["java", "Main"]
