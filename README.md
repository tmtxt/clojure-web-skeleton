compojure-skeleton
==================

Skeleton for Clojure project using Compojure with Vagrant

# not finished yet...

# Variables to overwrite on real server

- project_user: the user to run the project
- project_dir: real path to the project
- db_password: password to access database
- db_name: name of database to create
- service_prefix: the prefix of the upstart service

# Deployment

- Install Ansible on the server
- Create a new user, clone the project to the user's home
- Create a file for holding the extra vars, for example

extra_vars.yml

```
---
project_user: skeleton
project_dir: /home/skeleton/compojure-skeleton
db_password: qeimdjspleks
service_prefix: skeleton
```

- Run the provision with this command

```
ansible-playbook -i localhost, -c local -e "@/path/to/extra_vars.yml" -K /path/to/compojure-skeleton/ansible/main.yml
```
