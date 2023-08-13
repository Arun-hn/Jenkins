FROM nginx:1.18.0

# Remove default NGINX configuration
RUN rm /etc/nginx/conf.d/default.conf

# Copy custom configuration
COPY default.conf /etc/nginx/conf.d/

# Copy web application content
WORKDIR /usr/share/nginx/html
COPY index.html .

# Expose port and start NGINX
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
