# Use a base image, e.g., a specific version of Linux
FROM ubuntu:20.04

# Set the working directory in the container
WORKDIR /app

# Copy your application files into the container
COPY . /app

# Install dependencies (curl and nginx in this case)
RUN apt-get update && \
    apt-get install -y curl nginx

# Start nginx (or any other relevant setup)
CMD ["nginx", "-g", "daemon off;"]
