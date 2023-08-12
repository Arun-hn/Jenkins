# Use a base image, e.g., a specific version of Nginx
FROM nginx:1.18.0

# Remove default Nginx configuration
RUN rm /etc/nginx/conf.d/default.conf

# Set the working directory in the container
WORKDIR /usr/share/nginx/html

# Copy your index.html to the default Nginx root directory
COPY index.html .

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
