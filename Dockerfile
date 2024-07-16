FROM php:8.2-fpm-alpine
RUN docker-php-ext-install mysqli pdo pdo_mysql

# Installer les outils de gestion des utilisateurs/groupes
RUN apk --no-cache add shadow

RUN addgroup -g 1000 monprof && adduser -u 1000 -G monprof -D monprof
RUN addgroup -g 1001 -S www && adduser -u 1001 -S www -G www
# Installer Supervisor
RUN apk --no-cache add supervisor

# Installer composer 

RUN php -r "readfile('http://getcomposer.org/installer');" | php -- --install-dir=/usr/bin/ --filename=composer

COPY --chown=www:www . /code
# Copier le code de l'application
#COPY . /code

# Copier les configurations PHP
COPY custom-php.ini /usr/local/etc/php/conf.d/

# Copier la configuration Supervisor
  
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf


# Définir le répertoire de travail
WORKDIR /code

# Exposer le port 9000 pour PHP-FPM
EXPOSE 9000


# Changer le propriétaire des fichiers de code et donner les permissions nécessaires


RUN chown -R www:www /code/storage /code/bootstrap/cache
RUN chmod -R 777 /code/storage /code/bootstrap/cache


# Démarrer PHP-FPM et Supervisor
CMD ["/usr/bin/supervisord", "-n", "-c", "/etc/supervisor/conf.d/supervisord.conf"]
# CMD ["php-fpm"]
